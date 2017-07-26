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

import co.edu.uniandes.csw.petstore.entities.AnimalEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import uk.co.jemos.podam.common.PodamStrategyValue;
import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;

/**
 * @generated
 */
@XmlRootElement
public class AnimalDTO  implements Serializable{

    private Long id;
    private String name;
    @PodamStrategyValue(DateStrategy.class)
    private Date birthDate;
    private String color;
    private String gender;


    /**
     * @generated
     */
    public AnimalDTO() {
    }

    /**
     * Crea un objeto AnimalDTO a partir de un objeto AnimalEntity.
     *
     * @param entity Entidad AnimalEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public AnimalDTO(AnimalEntity entity) {
	   if (entity!=null){
        this.id=entity.getId();
        this.name=entity.getName();
        this.birthDate=entity.getBirthDate();
        this.color=entity.getColor();
        this.gender=entity.getGender();
       }
    }

    /**
     * Convierte un objeto AnimalDTO a AnimalEntity.
     *
     * @return Nueva objeto AnimalEntity.
     * @generated
     */
    public AnimalEntity toEntity() {
        AnimalEntity entity = new AnimalEntity();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setBirthDate(this.getBirthDate());
        entity.setColor(this.getColor());
        entity.setGender(this.getGender());
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
     * Obtiene el atributo birthDate.
     *
     * @return atributo birthDate.
     * @generated
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Establece el valor del atributo birthDate.
     *
     * @param birthdate nuevo valor del atributo
     * @generated
     */
    public void setBirthDate(Date birthdate) {
        this.birthDate = birthdate;
    }

    /**
     * Obtiene el atributo color.
     *
     * @return atributo color.
     * @generated
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el valor del atributo color.
     *
     * @param color nuevo valor del atributo
     * @generated
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el atributo gender.
     *
     * @return atributo gender.
     * @generated
     */
    public String getGender() {
        return gender;
    }

    /**
     * Establece el valor del atributo gender.
     *
     * @param gender nuevo valor del atributo
     * @generated
     */
    public void setGender(String gender) {
        this.gender = gender;
    }


}
