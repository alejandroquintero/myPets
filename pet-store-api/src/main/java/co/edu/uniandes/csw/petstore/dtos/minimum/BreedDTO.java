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
package co.edu.uniandes.csw.petstore.dtos.minimum;

import co.edu.uniandes.csw.petstore.entities.BreedEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @generated
 */
@XmlRootElement
public class BreedDTO  implements Serializable{

    private Long id;
    private String name;
    private String description;
    private String mood;
    private String size;
    private Integer lifeExpectancy;


    /**
     * @generated
     */
    public BreedDTO() {
    }

    /**
     * Crea un objeto BreedDTO a partir de un objeto BreedEntity.
     *
     * @param entity Entidad BreedEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public BreedDTO(BreedEntity entity) {
	   if (entity!=null){
        this.id=entity.getId();
        this.name=entity.getName();
        this.description=entity.getDescription();
        this.mood=entity.getMood();
        this.size=entity.getSize();
        this.lifeExpectancy=entity.getLifeExpectancy();
       }
    }

    /**
     * Convierte un objeto BreedDTO a BreedEntity.
     *
     * @return Nueva objeto BreedEntity.
     * @generated
     */
    public BreedEntity toEntity() {
        BreedEntity entity = new BreedEntity();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setDescription(this.getDescription());
        entity.setMood(this.getMood());
        entity.setSize(this.getSize());
        entity.setLifeExpectancy(this.getLifeExpectancy());
    return entity;
    }

    /**
     * Obtiene el atributo id.
     *
     * @return atributo id.
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor del atributo id.
     *
     * @param id nuevo valor del atributo
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el atributo name.
     *
     * @return atributo name.
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el valor del atributo name.
     *
     * @param name nuevo valor del atributo
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el atributo description.
     *
     * @return atributo description.
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece el valor del atributo description.
     *
     * @param description nuevo valor del atributo
     * @generated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene el atributo mood.
     *
     * @return atributo mood.
     * @generated
     */
    public String getMood() {
        return mood;
    }

    /**
     * Establece el valor del atributo mood.
     *
     * @param mood nuevo valor del atributo
     * @generated
     */
    public void setMood(String mood) {
        this.mood = mood;
    }

    /**
     * Obtiene el atributo size.
     *
     * @return atributo size.
     * @generated
     */
    public String getSize() {
        return size;
    }

    /**
     * Establece el valor del atributo size.
     *
     * @param size nuevo valor del atributo
     * @generated
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Obtiene el atributo lifeExpectancy.
     *
     * @return atributo lifeExpectancy.
     * @generated
     */
    public Integer getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * Establece el valor del atributo lifeExpectancy.
     *
     * @param lifeexpectancy nuevo valor del atributo
     * @generated
     */
    public void setLifeExpectancy(Integer lifeexpectancy) {
        this.lifeExpectancy = lifeexpectancy;
    }


}
