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

import co.edu.uniandes.csw.petstore.ejbs.BreedLogic;
import co.edu.uniandes.csw.petstore.api.IBreedLogic;
import co.edu.uniandes.csw.petstore.entities.BreedEntity;
import co.edu.uniandes.csw.petstore.persistence.BreedPersistence;
import co.edu.uniandes.csw.petstore.entities.SpecieEntity;
import co.edu.uniandes.csw.petstore.entities.AnimalEntity;
import java.util.ArrayList;
import java.util.List;

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
public class BreedLogicTest {

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
    private IBreedLogic breedLogic;

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
    private List<BreedEntity> data = new ArrayList<BreedEntity>();
    /**
     * @generated
     */
    private List<SpecieEntity> specieData = new ArrayList<>();
    /**
     * @generated
     */
    private List<AnimalEntity> animalData = new ArrayList<>();

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(BreedEntity.class.getPackage())
                .addPackage(BreedLogic.class.getPackage())
                .addPackage(IBreedLogic.class.getPackage())
                .addPackage(BreedPersistence.class.getPackage())
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
        em.createQuery("delete from AnimalEntity").executeUpdate();
        em.createQuery("delete from BreedEntity").executeUpdate();
        em.createQuery("delete from SpecieEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
            for (int i = 0; i < 3; i++) {
                SpecieEntity specie = factory.manufacturePojo(SpecieEntity.class);
                em.persist(specie);
                specieData.add(specie);
            }
            for (int i = 0; i < 3; i++) {
                AnimalEntity animal = factory.manufacturePojo(AnimalEntity.class);
                em.persist(animal);
                animalData.add(animal);
            }
        for (int i = 0; i < 3; i++) {
            BreedEntity entity = factory.manufacturePojo(BreedEntity.class);
                entity.setSpecie(specieData.get(0));

            em.persist(entity);
            data.add(entity);

            if (i == 0) {
                animalData.get(i).setBreed(entity);
            }
        }
    }
    /**
     * Prueba para crear un Breed
     *
     * @generated
     */
    @Test
    public void createBreedTest() {
        BreedEntity newEntity = factory.manufacturePojo(BreedEntity.class);
        BreedEntity result = breedLogic.createBreed(newEntity);
        Assert.assertNotNull(result);
        BreedEntity entity = em.find(BreedEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getDescription(), entity.getDescription());
        Assert.assertEquals(newEntity.getMood(), entity.getMood());
        Assert.assertEquals(newEntity.getSize(), entity.getSize());
        Assert.assertEquals(newEntity.getLifeExpectancy(), entity.getLifeExpectancy());
    }

    /**
     * Prueba para consultar la lista de Breeds
     *
     * @generated
     */
    @Test
    public void getBreedsTest() {
        List<BreedEntity> list = breedLogic.getBreeds();
        Assert.assertEquals(data.size(), list.size());
        for (BreedEntity entity : list) {
            boolean found = false;
            for (BreedEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    
    /**
     * Prueba para consultar un Breed
     *
     * @generated
     */
    @Test
    public void getBreedTest() {
        BreedEntity entity = data.get(0);
        BreedEntity resultEntity = breedLogic.getBreed(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getDescription(), resultEntity.getDescription());
        Assert.assertEquals(entity.getMood(), resultEntity.getMood());
        Assert.assertEquals(entity.getSize(), resultEntity.getSize());
        Assert.assertEquals(entity.getLifeExpectancy(), resultEntity.getLifeExpectancy());
    }

    /**
     * Prueba para eliminar un Breed
     *
     * @generated
     */
    @Test
    public void deleteBreedTest() {
        BreedEntity entity = data.get(0);
        breedLogic.removeAnimal(entity.getId(), animalData.get(0).getId());
        breedLogic.deleteBreed(entity.getId());
        BreedEntity deleted = em.find(BreedEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Breed
     *
     * @generated
     */
    @Test
    public void updateBreedTest() {
        BreedEntity entity = data.get(0);
        BreedEntity pojoEntity = factory.manufacturePojo(BreedEntity.class);

        pojoEntity.setId(entity.getId());

        breedLogic.updateBreed(pojoEntity);

        BreedEntity resp = em.find(BreedEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getDescription(), resp.getDescription());
        Assert.assertEquals(pojoEntity.getMood(), resp.getMood());
        Assert.assertEquals(pojoEntity.getSize(), resp.getSize());
        Assert.assertEquals(pojoEntity.getLifeExpectancy(), resp.getLifeExpectancy());
    }

    /**
     * Prueba para obtener una instancia de Animal asociada a una instancia Breed
     *
     * @generated
     */
    @Test
    public void getAnimalTest() {
        BreedEntity entity = data.get(0);
        AnimalEntity animalEntity = animalData.get(0);
        AnimalEntity response = breedLogic.getAnimal(entity.getId(), animalEntity.getId());

        Assert.assertEquals(animalEntity.getId(), response.getId());
        Assert.assertEquals(animalEntity.getName(), response.getName());
        Assert.assertEquals(animalEntity.getBirthDate(), response.getBirthDate());
        Assert.assertEquals(animalEntity.getColor(), response.getColor());
        Assert.assertEquals(animalEntity.getGender(), response.getGender());
    }

    /**
     * Prueba para obtener una colección de instancias de Animal asociadas a una instancia Breed
     *
     * @generated
     */
    @Test
    public void listAnimalTest() {
        List<AnimalEntity> list = breedLogic.listAnimal(data.get(0).getId());
        Assert.assertEquals(1, list.size());
    }

    /**
     *Prueba para asociar un Animal existente a un Breed
     *
     * @generated
     */
    @Test
    public void addAnimalTest() {
        BreedEntity entity = data.get(0);
        AnimalEntity animalEntity = animalData.get(1);
        AnimalEntity response = breedLogic.addAnimal(entity.getId(), animalEntity.getId());

        Assert.assertNotNull(response);
        Assert.assertEquals(animalEntity.getId(), response.getId());
    }

    /**
     * Prueba para remplazar las instancias de Animal asociadas a una instancia de Breed
     *
     * @generated
     */
    @Test
    public void replaceAnimalTest() {
        BreedEntity entity = data.get(0);
        List<AnimalEntity> list = animalData.subList(1, 3);
        breedLogic.replaceAnimal(entity.getId(), list);

        entity = breedLogic.getBreed(entity.getId());
        Assert.assertFalse(entity.getAnimal().contains(animalData.get(0)));
        Assert.assertTrue(entity.getAnimal().contains(animalData.get(1)));
        Assert.assertTrue(entity.getAnimal().contains(animalData.get(2)));
    }

    /**
     * Prueba para desasociar un Animal existente de un Breed existente
     *
     * @generated
     */
    @Test
    public void removeAnimalTest() {
        breedLogic.removeAnimal(data.get(0).getId(), animalData.get(0).getId());
        AnimalEntity response = breedLogic.getAnimal(data.get(0).getId(), animalData.get(0).getId());
        Assert.assertNull(response);
    }
}

