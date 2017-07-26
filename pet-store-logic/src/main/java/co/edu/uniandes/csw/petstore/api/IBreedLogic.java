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
package co.edu.uniandes.csw.petstore.api;

import co.edu.uniandes.csw.petstore.entities.BreedEntity;
import co.edu.uniandes.csw.petstore.entities.AnimalEntity;
import java.util.List;

public interface IBreedLogic {
    public int countBreeds();
    public List<BreedEntity> getBreeds();
    public List<BreedEntity> getBreeds(Integer page, Integer maxRecords);
    public BreedEntity getBreed(Long id);
    public BreedEntity createBreed(BreedEntity entity); 
    public BreedEntity updateBreed(BreedEntity entity);
    public void deleteBreed(Long id);
    public List<AnimalEntity> listAnimal(Long breedId);
    public AnimalEntity getAnimal(Long breedId, Long animalId);
    public AnimalEntity addAnimal(Long breedId, Long animalId);
    public List<AnimalEntity> replaceAnimal(Long breedId, List<AnimalEntity> list);
    public void removeAnimal(Long breedId, Long animalId);
}
