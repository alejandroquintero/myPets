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
import co.edu.uniandes.csw.petstore.api.IAnimalLogic;
import co.edu.uniandes.csw.petstore.dtos.detail.AnimalDetailDTO;
import co.edu.uniandes.csw.petstore.entities.AnimalEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 * URI: animals/
 * @generated
 */
@Path("/animals")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnimalResource {

    @Inject private IAnimalLogic animalLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;

   
    /**
     * Convierte una lista de AnimalEntity a una lista de AnimalDetailDTO.
     *
     * @param entityList Lista de AnimalEntity a convertir.
     * @return Lista de AnimalDetailDTO convertida.
     * @generated
     */
    private List<AnimalDetailDTO> listEntity2DTO(List<AnimalEntity> entityList){
        List<AnimalDetailDTO> list = new ArrayList<>();
        for (AnimalEntity entity : entityList) {
            list.add(new AnimalDetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de Animal
     *
     * @return Colección de objetos de AnimalDetailDTO
     * @generated
     */
    @GET
    public List<AnimalDetailDTO> getAnimals() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", animalLogic.countAnimals());
            return listEntity2DTO(animalLogic.getAnimals(page, maxRecords));
        }
        return listEntity2DTO(animalLogic.getAnimals());
    }

    /**
     * Obtiene los datos de una instancia de Animal a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de AnimalDetailDTO con los datos del Animal consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public AnimalDetailDTO getAnimal(@PathParam("id") Long id) {
        return new AnimalDetailDTO(animalLogic.getAnimal(id));
    }

    /**
     * Se encarga de crear un Animal en la base de datos
     *
     * @param dto Objeto de AnimalDetailDTO con los datos nuevos
     * @return Objeto de AnimalDetailDTOcon los datos nuevos y su ID
     * @generated
     */
    @POST
    @StatusCreated
    public AnimalDetailDTO createAnimal(AnimalDetailDTO dto) {
        return new AnimalDetailDTO(animalLogic.createAnimal(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Animal
     *
     * @param id Identificador de la instancia de Animal a modificar
     * @param dto Instancia de AnimalDetailDTO con los nuevos datos
     * @return Instancia de AnimalDetailDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public AnimalDetailDTO updateAnimal(@PathParam("id") Long id, AnimalDetailDTO dto) {
        AnimalEntity entity = dto.toEntity();
        entity.setId(id);
        return new AnimalDetailDTO(animalLogic.updateAnimal(entity));
    }

    /**
     * Elimina una instancia de Animal de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteAnimal(@PathParam("id") Long id) {
        animalLogic.deleteAnimal(id);
    }
    public void existsAnimal(Long animalsId){
        AnimalDetailDTO animal = getAnimal(animalsId);
        if (animal== null) {
            throw new WebApplicationException(404);
        }
    }
    
    
    @Path("{animalsId: \\d+}/photoAlbum")
    public Class<PhotoAlbumResource> getPhotoAlbumResource(@PathParam("animalsId") Long animalsId){
        existsAnimal(animalsId);
        return PhotoAlbumResource.class;
    }
    
}
