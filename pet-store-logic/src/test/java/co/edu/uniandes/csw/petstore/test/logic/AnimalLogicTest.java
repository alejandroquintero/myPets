/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.petstore.test.logic;

import co.edu.uniandes.csw.petstore.ejbs.AnimalLogic;
import co.edu.uniandes.csw.petstore.api.IAnimalLogic;
import co.edu.uniandes.csw.petstore.entities.AnimalEntity;
import co.edu.uniandes.csw.petstore.persistence.AnimalPersistence;
import co.edu.uniandes.csw.petstore.entities.AnimalEntity;
import co.edu.uniandes.csw.petstore.entities.BreedEntity;
import co.edu.uniandes.csw.petstore.entities.PhotoAlbumEntity;
import co.edu.uniandes.csw.petstore.entities.AnimalEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AnimalLogicTest {

    /**
     * @generated
     */

    /**
     * @generated
     */
    private PodamFactory factory = new PodamFactoryImpl();

    /**
     * @generated
     */
    @Inject
    private IAnimalLogic animalLogic;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    private UserTransaction utx;

    /**
     * @generated
     */
    private List<AnimalEntity> data = new ArrayList<AnimalEntity>();
    /**
     * @generated
     */
    private List<BreedEntity> breedData = new ArrayList<>();

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AnimalEntity.class.getPackage())
                .addPackage(AnimalLogic.class.getPackage())
                .addPackage(IAnimalLogic.class.getPackage())
                .addPackage(AnimalPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     *
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from PhotoAlbumEntity").executeUpdate();
        em.createQuery("delete from AnimalEntity").executeUpdate();
        em.createQuery("delete from AnimalEntity").executeUpdate();
        em.createQuery("delete from BreedEntity").executeUpdate();
        em.createQuery("delete from AnimalEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
            for (int i = 0; i < 3; i++) {
                BreedEntity breed = factory.manufacturePojo(BreedEntity.class);
                em.persist(breed);
                breedData.add(breed);
            }
        for (int i = 0; i < 3; i++) {
            AnimalEntity entity = factory.manufacturePojo(AnimalEntity.class);
                entity.setBreed(breedData.get(0));

            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un Animal
     *
     * @generated
     */
    @Test
    public void createAnimalTest() {
        AnimalEntity newEntity = factory.manufacturePojo(AnimalEntity.class);
        AnimalEntity result = animalLogic.createAnimal(newEntity);
        Assert.assertNotNull(result);
        AnimalEntity entity = em.find(AnimalEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getBirthDate(), entity.getBirthDate());
        Assert.assertEquals(newEntity.getColor(), entity.getColor());
        Assert.assertEquals(newEntity.getGender(), entity.getGender());
    }

    /**
     * Prueba para consultar la lista de Animals
     *
     * @generated
     */
    @Test
    public void getAnimalsTest() {
        List<AnimalEntity> list = animalLogic.getAnimals();
        Assert.assertEquals(data.size(), list.size());
        for (AnimalEntity entity : list) {
            boolean found = false;
            for (AnimalEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    
    /**
     * Prueba para consultar un Animal
     *
     * @generated
     */
    @Test
    public void getAnimalTest() {
        AnimalEntity entity = data.get(0);
        AnimalEntity resultEntity = animalLogic.getAnimal(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getBirthDate(), resultEntity.getBirthDate());
        Assert.assertEquals(entity.getColor(), resultEntity.getColor());
        Assert.assertEquals(entity.getGender(), resultEntity.getGender());
    }

    /**
     * Prueba para eliminar un Animal
     *
     * @generated
     */
    @Test
    public void deleteAnimalTest() {
        AnimalEntity entity = data.get(0);
        animalLogic.deleteAnimal(entity.getId());
        AnimalEntity deleted = em.find(AnimalEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Animal
     *
     * @generated
     */
    @Test
    public void updateAnimalTest() {
        AnimalEntity entity = data.get(0);
        AnimalEntity pojoEntity = factory.manufacturePojo(AnimalEntity.class);

        pojoEntity.setId(entity.getId());

        animalLogic.updateAnimal(pojoEntity);

        AnimalEntity resp = em.find(AnimalEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getBirthDate(), resp.getBirthDate());
        Assert.assertEquals(pojoEntity.getColor(), resp.getColor());
        Assert.assertEquals(pojoEntity.getGender(), resp.getGender());
    }
}

