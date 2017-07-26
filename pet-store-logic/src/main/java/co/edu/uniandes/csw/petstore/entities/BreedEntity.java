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
package co.edu.uniandes.csw.petstore.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import uk.co.jemos.podam.common.PodamExclude;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.FetchType;


/**
 * @generated
 */
@Entity
public class BreedEntity extends BaseEntity implements Serializable {

    private String description;

    private String mood;

    private String size;

    private Integer lifeExpectancy;

    @PodamExclude
    @ManyToOne
    private SpecieEntity specie;

    @PodamExclude
    @OneToMany(mappedBy = "breed")
    private List<AnimalEntity> animal = new ArrayList<>();

    /**
     * Obtiene el atributo description.
     *
     * @return atributo description.
     * @generated
     */
    public String getDescription(){
        return description;
    }

    /**
     * Establece el valor del atributo description.
     *
     * @param description nuevo valor del atributo
     * @generated
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Obtiene el atributo mood.
     *
     * @return atributo mood.
     * @generated
     */
    public String getMood(){
        return mood;
    }

    /**
     * Establece el valor del atributo mood.
     *
     * @param mood nuevo valor del atributo
     * @generated
     */
    public void setMood(String mood){
        this.mood = mood;
    }

    /**
     * Obtiene el atributo size.
     *
     * @return atributo size.
     * @generated
     */
    public String getSize(){
        return size;
    }

    /**
     * Establece el valor del atributo size.
     *
     * @param size nuevo valor del atributo
     * @generated
     */
    public void setSize(String size){
        this.size = size;
    }

    /**
     * Obtiene el atributo lifeExpectancy.
     *
     * @return atributo lifeExpectancy.
     * @generated
     */
    public Integer getLifeExpectancy(){
        return lifeExpectancy;
    }

    /**
     * Establece el valor del atributo lifeExpectancy.
     *
     * @param lifeExpectancy nuevo valor del atributo
     * @generated
     */
    public void setLifeExpectancy(Integer lifeExpectancy){
        this.lifeExpectancy = lifeExpectancy;
    }

    /**
     * Obtiene el atributo specie.
     *
     * @return atributo specie.
     * @generated
     */
    public SpecieEntity getSpecie() {
        return specie;
    }

    /**
     * Establece el valor del atributo specie.
     *
     * @param specie nuevo valor del atributo
     * @generated
     */
    public void setSpecie(SpecieEntity specie) {
        this.specie = specie;
    }

    /**
     * Obtiene la colección de animal.
     *
     * @return colección animal.
     * @generated
     */
    public List<AnimalEntity> getAnimal() {
        return animal;
    }

    /**
     * Establece el valor de la colección de animal.
     *
     * @param animal nuevo valor de la colección.
     * @generated
     */
    public void setAnimal(List<AnimalEntity> animal) {
        this.animal = animal;
    }
}
