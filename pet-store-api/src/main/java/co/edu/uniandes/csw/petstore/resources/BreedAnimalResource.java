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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.petstore.api.IBreedLogic;
import co.edu.uniandes.csw.petstore.dtos.detail.AnimalDetailDTO;
import co.edu.uniandes.csw.petstore.entities.AnimalEntity;
import java.util.ArrayList;
/**
 * URI: breeds/{breedsId: \\d+}/animal
 * @generated
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BreedAnimalResource {

    @Inject private IBreedLogic breedLogic;
    @Context private HttpServletResponse response;

    /**
     * Convierte una lista de AnimalEntity a una lista de AnimalDetailDTO.
     *
     * @param entityList Lista de AnimalEntity a convertir.
     * @return Lista de AnimalDetailDTO convertida.
     * @generated
     */
    private List<AnimalDetailDTO> animalListEntity2DTO(List<AnimalEntity> entityList){
        List<AnimalDetailDTO> list = new ArrayList<>();
        for (AnimalEntity entity : entityList) {
            list.add(new AnimalDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de AnimalDetailDTO a una lista de AnimalEntity.
     *
     * @param dtos Lista de AnimalDetailDTO a convertir.
     * @return Lista de AnimalEntity convertida.
     * @generated
     */
    private List<AnimalEntity> animalListDTO2Entity(List<AnimalDetailDTO> dtos){
        List<AnimalEntity> list = new ArrayList<>();
        for (AnimalDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de AnimalDetailDTO asociadas a una
     * instancia de Breed
     *
     * @param breedsId Identificador de la instancia de Breed
     * @return Colección de instancias de AnimalDetailDTO asociadas a la instancia de Breed
     * @generated
     */
    @GET
    public List<AnimalDetailDTO> listAnimal(@PathParam("breedsId") Long breedsId) {
        return animalListEntity2DTO(breedLogic.listAnimal(breedsId));
    }

    /**
     * Obtiene una instancia de Animal asociada a una instancia de Breed
     *
     * @param breedsId Identificador de la instancia de Breed
     * @param animalId Identificador de la instancia de Animal
     * @generated
     */
    @GET
    @Path("{animalId: \\d+}")
    public AnimalDetailDTO getAnimal(@PathParam("breedsId") Long breedsId, @PathParam("animalId") Long animalId) {
        return new AnimalDetailDTO(breedLogic.getAnimal(breedsId, animalId));
    }

    /**
     * Asocia un Animal existente a un Breed
     *
     * @param breedsId Identificador de la instancia de Breed
     * @param animalId Identificador de la instancia de Animal
     * @return Instancia de AnimalDetailDTO que fue asociada a Breed
     * @generated
     */
    @POST
    @Path("{animalId: \\d+}")
    public AnimalDetailDTO addAnimal(@PathParam("breedsId") Long breedsId, @PathParam("animalId") Long animalId) {
        return new AnimalDetailDTO(breedLogic.addAnimal(breedsId, animalId));
    }

    /**
     * Remplaza las instancias de Animal asociadas a una instancia de Breed
     *
     * @param breedsId Identificador de la instancia de Breed
     * @param animals Colección de instancias de AnimalDTO a asociar a instancia de Breed
     * @return Nueva colección de AnimalDTO asociada a la instancia de Breed
     * @generated
     */
    @PUT
    public List<AnimalDetailDTO> replaceAnimal(@PathParam("breedsId") Long breedsId, List<AnimalDetailDTO> animals) {
        return animalListEntity2DTO(breedLogic.replaceAnimal(breedsId, animalListDTO2Entity(animals)));
    }

    /**
     * Desasocia un Animal existente de un Breed existente
     *
     * @param breedsId Identificador de la instancia de Breed
     * @param animalId Identificador de la instancia de Animal
     * @generated
     */
    @DELETE
    @Path("{animalId: \\d+}")
    public void removeAnimal(@PathParam("breedsId") Long breedsId, @PathParam("animalId") Long animalId) {
        breedLogic.removeAnimal(breedsId, animalId);
    }
}
