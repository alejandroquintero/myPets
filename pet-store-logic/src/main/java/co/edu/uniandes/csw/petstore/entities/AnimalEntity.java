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
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamStrategyValue;
import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import uk.co.jemos.podam.common.PodamExclude;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;

/**
 * @generated
 */
@Entity
public class AnimalEntity extends BaseEntity implements Serializable {

    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date birthDate;

    private String color;

    private String gender;

    @PodamExclude
    @ManyToOne
    @JoinTable(name = "Animal_FATHER")
    private AnimalEntity father;

    @PodamExclude
    @OneToMany(mappedBy = "animal", cascade = CascadeType.REMOVE)
    private List<PhotoAlbumEntity> photoAlbum = new ArrayList<>();

    @PodamExclude
    @ManyToOne
    @JoinTable(name = "Animal_MOTHER")
    private AnimalEntity mother;

    @PodamExclude
    @ManyToOne
    private BreedEntity breed;

    /**
     * Obtiene el atributo birthDate.
     *
     * @return atributo birthDate.
     * @generated
     */
    public Date getBirthDate(){
        return birthDate;
    }

    /**
     * Establece el valor del atributo birthDate.
     *
     * @param birthDate nuevo valor del atributo
     * @generated
     */
    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

    /**
     * Obtiene el atributo color.
     *
     * @return atributo color.
     * @generated
     */
    public String getColor(){
        return color;
    }

    /**
     * Establece el valor del atributo color.
     *
     * @param color nuevo valor del atributo
     * @generated
     */
    public void setColor(String color){
        this.color = color;
    }

    /**
     * Obtiene el atributo gender.
     *
     * @return atributo gender.
     * @generated
     */
    public String getGender(){
        return gender;
    }

    /**
     * Establece el valor del atributo gender.
     *
     * @param gender nuevo valor del atributo
     * @generated
     */
    public void setGender(String gender){
        this.gender = gender;
    }

    /**
     * Obtiene el atributo father.
     *
     * @return atributo father.
     * @generated
     */
    public AnimalEntity getFather() {
        return father;
    }

    /**
     * Establece el valor del atributo father.
     *
     * @param father nuevo valor del atributo
     * @generated
     */
    public void setFather(AnimalEntity father) {
        this.father = father;
    }

    /**
     * Obtiene el atributo mother.
     *
     * @return atributo mother.
     * @generated
     */
    public AnimalEntity getMother() {
        return mother;
    }

    /**
     * Establece el valor del atributo mother.
     *
     * @param mother nuevo valor del atributo
     * @generated
     */
    public void setMother(AnimalEntity mother) {
        this.mother = mother;
    }

    /**
     * Obtiene el atributo breed.
     *
     * @return atributo breed.
     * @generated
     */
    public BreedEntity getBreed() {
        return breed;
    }

    /**
     * Establece el valor del atributo breed.
     *
     * @param breed nuevo valor del atributo
     * @generated
     */
    public void setBreed(BreedEntity breed) {
        this.breed = breed;
    }

    /**
     * Obtiene la colección de photoAlbum.
     *
     * @return colección photoAlbum.
     * @generated
     */
    public List<PhotoAlbumEntity> getPhotoAlbum() {
        return photoAlbum;
    }

    /**
     * Establece el valor de la colección de photoAlbum.
     *
     * @param photoAlbum nuevo valor de la colección.
     * @generated
     */
    public void setPhotoAlbum(List<PhotoAlbumEntity> photoalbum) {
        this.photoAlbum = photoalbum;
    }
}
