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
package co.edu.uniandes.csw.petstore.resources;

import co.edu.uniandes.csw.auth.filter.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.petstore.api.ISpecieLogic;
import co.edu.uniandes.csw.petstore.dtos.detail.SpecieDetailDTO;
import co.edu.uniandes.csw.petstore.entities.SpecieEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;
import co.edu.uniandes.csw.petstore.exceptions.BusinessLogicException;

/**
 * URI: species/
 * @generated
 */
@Path("/species")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SpecieResource {

    @Inject private ISpecieLogic specieLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;

   
    /**
     * Convierte una lista de SpecieEntity a una lista de SpecieDetailDTO.
     *
     * @param entityList Lista de SpecieEntity a convertir.
     * @return Lista de SpecieDetailDTO convertida.
     * @generated
     */
    private List<SpecieDetailDTO> listEntity2DTO(List<SpecieEntity> entityList){
        List<SpecieDetailDTO> list = new ArrayList<>();
        for (SpecieEntity entity : entityList) {
            list.add(new SpecieDetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de Specie
     *
     * @return Colección de objetos de SpecieDetailDTO
     * @generated
     */
    @GET
    public List<SpecieDetailDTO> getSpecies() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", specieLogic.countSpecies());
            return listEntity2DTO(specieLogic.getSpecies(page, maxRecords));
        }
        return listEntity2DTO(specieLogic.getSpecies());
    }

    /**
     * Obtiene los datos de una instancia de Specie a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de SpecieDetailDTO con los datos del Specie consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public SpecieDetailDTO getSpecie(@PathParam("id") Long id) {
        return new SpecieDetailDTO(specieLogic.getSpecie(id));
    }

    /**
     * Se encarga de crear un Specie en la base de datos
     *
     * @param dto Objeto de SpecieDetailDTO con los datos nuevos
     * @return Objeto de SpecieDetailDTOcon los datos nuevos y su ID
     * @generated
     */
    @POST
    @StatusCreated
    public SpecieDetailDTO createSpecie(SpecieDetailDTO dto) {
        return new SpecieDetailDTO(specieLogic.createSpecie(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Specie
     *
     * @param id Identificador de la instancia de Specie a modificar
     * @param dto Instancia de SpecieDetailDTO con los nuevos datos
     * @return Instancia de SpecieDetailDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public SpecieDetailDTO updateSpecie(@PathParam("id") Long id, SpecieDetailDTO dto) {
        SpecieEntity entity = dto.toEntity();
        entity.setId(id);
        SpecieEntity oldEntity = specieLogic.getSpecie(id);
        entity.setBreeds(oldEntity.getBreeds());
        return new SpecieDetailDTO(specieLogic.updateSpecie(entity));
    }

    /**
     * Elimina una instancia de Specie de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteSpecie(@PathParam("id") Long id) {
        specieLogic.deleteSpecie(id);
    }
    public void existsSpecie(Long speciesId){
        SpecieDetailDTO specie = getSpecie(speciesId);
        if (specie== null) {
            throw new WebApplicationException(404);
        }
    }
    
    
    @Path("{speciesId: \\d+}/breeds")
    public Class<SpecieBreedsResource> getSpecieBreedsResource(@PathParam("speciesId") Long speciesId){
        existsSpecie(speciesId);
        return SpecieBreedsResource.class;
    }
    

}
