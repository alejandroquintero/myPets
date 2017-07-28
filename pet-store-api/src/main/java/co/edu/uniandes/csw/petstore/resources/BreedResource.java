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
import co.edu.uniandes.csw.petstore.api.IBreedLogic;
import co.edu.uniandes.csw.petstore.dtos.detail.BreedDetailDTO;
import co.edu.uniandes.csw.petstore.entities.BreedEntity;
import co.edu.uniandes.csw.petstore.exceptions.BusinessLogicException;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 * URI: breeds/
 * @generated
 */
@Path("/breeds")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BreedResource {

    @Inject private IBreedLogic breedLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;

   
    /**
     * Convierte una lista de BreedEntity a una lista de BreedDetailDTO.
     *
     * @param entityList Lista de BreedEntity a convertir.
     * @return Lista de BreedDetailDTO convertida.
     * @generated
     */
    private List<BreedDetailDTO> listEntity2DTO(List<BreedEntity> entityList){
        List<BreedDetailDTO> list = new ArrayList<>();
        for (BreedEntity entity : entityList) {
            list.add(new BreedDetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de Breed
     *
     * @return Colección de objetos de BreedDetailDTO
     * @generated
     */
    @GET
    public List<BreedDetailDTO> getBreeds() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", breedLogic.countBreeds());
            return listEntity2DTO(breedLogic.getBreeds(page, maxRecords));
        }
        return listEntity2DTO(breedLogic.getBreeds());
    }

    /**
     * Obtiene los datos de una instancia de Breed a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de BreedDetailDTO con los datos del Breed consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public BreedDetailDTO getBreed(@PathParam("id") Long id) {
        return new BreedDetailDTO(breedLogic.getBreed(id));
    }

    /**
     * Se encarga de crear un Breed en la base de datos
     *
     * @param dto Objeto de BreedDetailDTO con los datos nuevos
     * @return Objeto de BreedDetailDTOcon los datos nuevos y su ID
     * @throws co.edu.uniandes.csw.petstore.exceptions.BusinessLogicException
     * @generated
     */
    @POST
    @StatusCreated
    public BreedDetailDTO createBreed(BreedDetailDTO dto) throws BusinessLogicException {
        isDuplicated(dto);
        return new BreedDetailDTO(breedLogic.createBreed(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Breed
     *
     * @param id Identificador de la instancia de Breed a modificar
     * @param dto Instancia de BreedDetailDTO con los nuevos datos
     * @return Instancia de BreedDetailDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public BreedDetailDTO updateBreed(@PathParam("id") Long id, BreedDetailDTO dto) {
        BreedEntity entity = dto.toEntity();
        entity.setId(id);
        BreedEntity oldEntity = breedLogic.getBreed(id);
        entity.setAnimal(oldEntity.getAnimal());
        return new BreedDetailDTO(breedLogic.updateBreed(entity));
    }

    /**
     * Elimina una instancia de Breed de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBreed(@PathParam("id") Long id) {
        breedLogic.deleteBreed(id);
    }
    public void existsBreed(Long breedsId){
        BreedDetailDTO breed = getBreed(breedsId);
        if (breed== null) {
            throw new WebApplicationException(404);
        }
    }
    
    
    @Path("{breedsId: \\d+}/animal")
    public Class<BreedAnimalResource> getBreedAnimalResource(@PathParam("breedsId") Long breedsId){
        existsBreed(breedsId);
        return BreedAnimalResource.class;
    }
     public void isDuplicated(BreedDetailDTO dto) throws BusinessLogicException{
   for(BreedEntity ae:breedLogic.getBreeds())
       if(ae.getName().equals(dto.getName()))
           throw new BusinessLogicException("la raza ya existe");      
   }
}
