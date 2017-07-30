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
package co.edu.uniandes.csw.petstore.dtos.detail;

import co.edu.uniandes.csw.petstore.dtos.minimum.*;
import co.edu.uniandes.csw.petstore.entities.AnimalEntity;
import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * @generated
 */
@XmlRootElement
public class AnimalDetailDTO extends AnimalDTO{


    @PodamExclude
    private AnimalDTO mother;
    @PodamExclude
    private BreedDTO breed;
    @PodamExclude
    private AnimalDTO father;

    /**
     * @generated
     */
    public AnimalDetailDTO() {
        super();
    }

    /**
     * Crea un objeto AnimalDetailDTO a partir de un objeto AnimalEntity incluyendo los atributos de AnimalDTO.
     *
     * @param entity Entidad AnimalEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public AnimalDetailDTO(AnimalEntity entity) {
        super(entity);
        if (entity.getMother()!=null){
        this.mother = new AnimalDTO(entity.getMother());
        }
        if (entity.getBreed()!=null){
        this.breed = new BreedDTO(entity.getBreed());
        }
        if (entity.getFather()!=null){
        this.father = new AnimalDTO(entity.getFather());
        }
        
    }

    /**
     * Convierte un objeto AnimalDetailDTO a AnimalEntity incluyendo los atributos de AnimalDTO.
     *
     * @return Nueva objeto AnimalEntity.
     * @generated
     */
    @Override
    public AnimalEntity toEntity() {
        AnimalEntity entity = super.toEntity();
        if (this.getMother()!=null){
        entity.setMother(this.getMother().toEntity());
        }
        if (this.getBreed()!=null){
        entity.setBreed(this.getBreed().toEntity());
        }
        if (this.getFather()!=null){
        entity.setFather(this.getFather().toEntity());
        }
        return entity;
    }

    /**
     * Obtiene el atributo mother.
     *
     * @return atributo mother.
     * @generated
     */
    public AnimalDTO getMother() {
        return mother;
    }

    /**
     * Establece el valor del atributo mother.
     *
     * @param mother nuevo valor del atributo
     * @generated
     */
    public void setMother(AnimalDTO mother) {
        this.mother = mother;
    }

    /**
     * Obtiene el atributo breed.
     *
     * @return atributo breed.
     * @generated
     */
    public BreedDTO getBreed() {
        return breed;
    }

    /**
     * Establece el valor del atributo breed.
     *
     * @param breed nuevo valor del atributo
     * @generated
     */
    public void setBreed(BreedDTO breed) {
        this.breed = breed;
    }

    /**
     * Obtiene el atributo father.
     *
     * @return atributo father.
     * @generated
     */
    public AnimalDTO getFather() {
        return father;
    }

    /**
     * Establece el valor del atributo father.
     *
     * @param father nuevo valor del atributo
     * @generated
     */
    public void setFather(AnimalDTO father) {
        this.father = father;
    }

}
