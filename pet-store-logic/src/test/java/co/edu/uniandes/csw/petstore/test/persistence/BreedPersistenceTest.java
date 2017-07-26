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
import co.edu.uniandes.csw.petstore.entities.BreedEntity;
import co.edu.uniandes.csw.petstore.persistence.BreedPersistence;
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
public class BreedPersistenceTest {

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(BreedEntity.class.getPackage())
                .addPackage(BreedPersistence.class.getPackage())
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
    private BreedPersistence breedPersistence;

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
        em.createQuery("delete from BreedEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<BreedEntity> data = new ArrayList<BreedEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            BreedEntity entity = factory.manufacturePojo(BreedEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un Breed.
     *
     * @generated
     */
    @Test
    public void createBreedTest() {
        PodamFactory factory = new PodamFactoryImpl();
        BreedEntity newEntity = factory.manufacturePojo(BreedEntity.class);
        BreedEntity result = breedPersistence.create(newEntity);

        Assert.assertNotNull(result);

        BreedEntity entity = em.find(BreedEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getDescription(), entity.getDescription());
        Assert.assertEquals(newEntity.getMood(), entity.getMood());
        Assert.assertEquals(newEntity.getSize(), entity.getSize());
        Assert.assertEquals(newEntity.getLifeExpectancy(), entity.getLifeExpectancy());
    }

    /**
     * Prueba para consultar la lista de Breeds.
     *
     * @generated
     */
    @Test
    public void getBreedsTest() {
        List<BreedEntity> list = breedPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (BreedEntity ent : list) {
            boolean found = false;
            for (BreedEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Breed.
     *
     * @generated
     */
    @Test
    public void getBreedTest() {
        BreedEntity entity = data.get(0);
        BreedEntity newEntity = breedPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getDescription(), newEntity.getDescription());
        Assert.assertEquals(entity.getMood(), newEntity.getMood());
        Assert.assertEquals(entity.getSize(), newEntity.getSize());
        Assert.assertEquals(entity.getLifeExpectancy(), newEntity.getLifeExpectancy());
    }

    /**
     * Prueba para eliminar un Breed.
     *
     * @generated
     */
    @Test
    public void deleteBreedTest() {
        BreedEntity entity = data.get(0);
        breedPersistence.delete(entity.getId());
        BreedEntity deleted = em.find(BreedEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Breed.
     *
     * @generated
     */
    @Test
    public void updateBreedTest() {
        BreedEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        BreedEntity newEntity = factory.manufacturePojo(BreedEntity.class);

        newEntity.setId(entity.getId());

        breedPersistence.update(newEntity);

        BreedEntity resp = em.find(BreedEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getDescription(), resp.getDescription());
        Assert.assertEquals(newEntity.getMood(), resp.getMood());
        Assert.assertEquals(newEntity.getSize(), resp.getSize());
        Assert.assertEquals(newEntity.getLifeExpectancy(), resp.getLifeExpectancy());
    }
}
