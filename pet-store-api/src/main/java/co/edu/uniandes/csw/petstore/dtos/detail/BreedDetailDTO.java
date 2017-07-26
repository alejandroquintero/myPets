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
import co.edu.uniandes.csw.petstore.entities.BreedEntity;
import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * @generated
 */
@XmlRootElement
public class BreedDetailDTO extends BreedDTO{


    @PodamExclude
    private SpecieDTO specie;

    /**
     * @generated
     */
    public BreedDetailDTO() {
        super();
    }

    /**
     * Crea un objeto BreedDetailDTO a partir de un objeto BreedEntity incluyendo los atributos de BreedDTO.
     *
     * @param entity Entidad BreedEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public BreedDetailDTO(BreedEntity entity) {
        super(entity);
        if (entity.getSpecie()!=null){
        this.specie = new SpecieDTO(entity.getSpecie());
        }
        
    }

    /**
     * Convierte un objeto BreedDetailDTO a BreedEntity incluyendo los atributos de BreedDTO.
     *
     * @return Nueva objeto BreedEntity.
     * @generated
     */
    @Override
    public BreedEntity toEntity() {
        BreedEntity entity = super.toEntity();
        if (this.getSpecie()!=null){
        entity.setSpecie(this.getSpecie().toEntity());
        }
        return entity;
    }

    /**
     * Obtiene el atributo specie.
     *
     * @return atributo specie.
     * @generated
     */
    public SpecieDTO getSpecie() {
        return specie;
    }

    /**
     * Establece el valor del atributo specie.
     *
     * @param specie nuevo valor del atributo
     * @generated
     */
    public void setSpecie(SpecieDTO specie) {
        this.specie = specie;
    }

}
