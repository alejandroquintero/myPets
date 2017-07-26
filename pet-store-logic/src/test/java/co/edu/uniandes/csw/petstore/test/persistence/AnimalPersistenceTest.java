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
package co.edu.uniandes.csw.petstore.test.persistence;
import co.edu.uniandes.csw.petstore.entities.AnimalEntity;
import co.edu.uniandes.csw.petstore.entities.PhotoAlbumEntity;
import co.edu.uniandes.csw.petstore.persistence.AnimalPersistence;
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
public class AnimalPersistenceTest {

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AnimalEntity.class.getPackage())
                .addPackage(AnimalPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */

    /**
     * @generated
     */
    @Inject
    private AnimalPersistence animalPersistence;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * Configuración inicial de la prueba.
     *
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
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
    }

    /**
     * @generated
     */
    private List<AnimalEntity> data = new ArrayList<AnimalEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            AnimalEntity entity = factory.manufacturePojo(AnimalEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un Animal.
     *
     * @generated
     */
    @Test
    public void createAnimalTest() {
        PodamFactory factory = new PodamFactoryImpl();
        AnimalEntity newEntity = factory.manufacturePojo(AnimalEntity.class);
        AnimalEntity result = animalPersistence.create(newEntity);

        Assert.assertNotNull(result);

        AnimalEntity entity = em.find(AnimalEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getColor(), entity.getColor());
        Assert.assertEquals(newEntity.getGender(), entity.getGender());
    }

    /**
     * Prueba para consultar la lista de Animals.
     *
     * @generated
     */
    @Test
    public void getAnimalsTest() {
        List<AnimalEntity> list = animalPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (AnimalEntity ent : list) {
            boolean found = false;
            for (AnimalEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Animal.
     *
     * @generated
     */
    @Test
    public void getAnimalTest() {
        AnimalEntity entity = data.get(0);
        AnimalEntity newEntity = animalPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getBirthDate(), newEntity.getBirthDate());
        Assert.assertEquals(entity.getColor(), newEntity.getColor());
        Assert.assertEquals(entity.getGender(), newEntity.getGender());
    }

    /**
     * Prueba para eliminar un Animal.
     *
     * @generated
     */
    @Test
    public void deleteAnimalTest() {
        AnimalEntity entity = data.get(0);
        animalPersistence.delete(entity.getId());
        AnimalEntity deleted = em.find(AnimalEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Animal.
     *
     * @generated
     */
    @Test
    public void updateAnimalTest() {
        AnimalEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AnimalEntity newEntity = factory.manufacturePojo(AnimalEntity.class);

        newEntity.setId(entity.getId());

        animalPersistence.update(newEntity);

        AnimalEntity resp = em.find(AnimalEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getColor(), resp.getColor());
        Assert.assertEquals(newEntity.getGender(), resp.getGender());
    }
}
