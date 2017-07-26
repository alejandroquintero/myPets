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
package co.edu.uniandes.csw.petstore.ejbs;

import co.edu.uniandes.csw.petstore.api.IBreedLogic;
import co.edu.uniandes.csw.petstore.entities.BreedEntity;
import co.edu.uniandes.csw.petstore.persistence.BreedPersistence;
import co.edu.uniandes.csw.petstore.entities.AnimalEntity;
import co.edu.uniandes.csw.petstore.api.IAnimalLogic;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class BreedLogic implements IBreedLogic {

    @Inject private BreedPersistence persistence;


    @Inject private IAnimalLogic animalLogic;

    /**
     * Obtiene el número de registros de Breed.
     *
     * @return Número de registros de Breed.
     * @generated
     */
    public int countBreeds() {
        return persistence.count();
    }

    /**
     * Obtiene la lista de los registros de Breed.
     *
     * @return Colección de objetos de BreedEntity.
     * @generated
     */
    @Override
    public List<BreedEntity> getBreeds() {
        return persistence.findAll();
    }

    /**
     * Obtiene la lista de los registros de Breed indicando los datos para la paginación.
     *
     * @param page Número de página.
     * @param maxRecords Número de registros que se mostraran en cada página.
     * @return Colección de objetos de BreedEntity.
     * @generated
     */
    @Override
    public List<BreedEntity> getBreeds(Integer page, Integer maxRecords) {
        return persistence.findAll(page, maxRecords);
    }

    /**
     * Obtiene los datos de una instancia de Breed a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de BreedEntity con los datos del Breed consultado.
     * @generated
     */
    public BreedEntity getBreed(Long id) {
        return persistence.find(id);
    }

    /**
     * Se encarga de crear un Breed en la base de datos.
     *
     * @param entity Objeto de BreedEntity con los datos nuevos
     * @return Objeto de BreedEntity con los datos nuevos y su ID.
     * @generated
     */
    @Override
    public BreedEntity createBreed(BreedEntity entity) {
        persistence.create(entity);
        return entity;
    }

    /**
     * Actualiza la información de una instancia de Breed.
     *
     * @param entity Instancia de BreedEntity con los nuevos datos.
     * @return Instancia de BreedEntity con los datos actualizados.
     * @generated
     */
    @Override
    public BreedEntity updateBreed(BreedEntity entity) {
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Breed de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    @Override
    public void deleteBreed(Long id) {
        persistence.delete(id);
    }
  

    /**
     * Obtiene una colección de instancias de AnimalEntity asociadas a una
     * instancia de Breed
     *
     * @param breedId Identificador de la instancia de Breed
     * @return Colección de instancias de AnimalEntity asociadas a la instancia de Breed
     * @generated
     */
    @Override
    public List<AnimalEntity> listAnimal(Long breedId) {
        return getBreed(breedId).getAnimal();
    }

    /**
     * Obtiene una instancia de AnimalEntity asociada a una instancia de Breed
     *
     * @param breedId Identificador de la instancia de Breed
     * @param animalId Identificador de la instancia de Animal
     * @generated
     */
    @Override
    public AnimalEntity getAnimal(Long breedId, Long animalId) {
        List<AnimalEntity> list = getBreed(breedId).getAnimal();
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setId(animalId);
        int index = list.indexOf(animalEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia un Animal existente a un Breed
     *
     * @param breedId Identificador de la instancia de Breed
     * @param animalId Identificador de la instancia de Animal
     * @return Instancia de AnimalEntity que fue asociada a Breed
     * @generated
     */
    @Override
    public AnimalEntity addAnimal(Long breedId, Long animalId) {
        BreedEntity breedEntity = getBreed(breedId);
        AnimalEntity animalEntity = animalLogic.getAnimal(animalId);
        animalEntity.setBreed(breedEntity);
        return animalEntity;
    }

    /**
     * Remplaza las instancias de Animal asociadas a una instancia de Breed
     *
     * @param breedId Identificador de la instancia de Breed
     * @param list Colección de instancias de AnimalEntity a asociar a instancia de Breed
     * @return Nueva colección de AnimalEntity asociada a la instancia de Breed
     * @generated
     */
    @Override
    public List<AnimalEntity> replaceAnimal(Long breedId, List<AnimalEntity> list) {
        BreedEntity breedEntity = getBreed(breedId);
        List<AnimalEntity> animalList = animalLogic.getAnimals();
        for (AnimalEntity animal : animalList) {
            if (list.contains(animal)) {
                animal.setBreed(breedEntity);
            } else {
                if (animal.getBreed() != null && animal.getBreed().equals(breedEntity)) {
                    animal.setBreed(null);
                }
            }
        }
        breedEntity.setAnimal(list);
        return breedEntity.getAnimal();
    }

    /**
     * Desasocia un Animal existente de un Breed existente
     *
     * @param breedId Identificador de la instancia de Breed
     * @param animalId Identificador de la instancia de Animal
     * @generated
     */
    @Override
    public void removeAnimal(Long breedId, Long animalId) {
        AnimalEntity entity = animalLogic.getAnimal(animalId);
        entity.setBreed(null);
    }
}
