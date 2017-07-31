# Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-petstore)
  - [Recurso Animal](#recurso-animal)
    - [GET /animals](#GET-/animals)
    - [GET /animals/{id}](#GET-/animals/{id})
    - [POST /animals](#POST-/animals)
    - [PUT /animals/{id}](#PUT-/animals/{id})
    - [DELETE /animals/{id}](#DELETE-/animals/{id})
    - [GET animals/{animalsid}/photoAlbum](#GET-animals/{animalsid}/photoAlbum)
    - [GET animals/{animalsid}/photoAlbum/{photoAlbumid}](#GET-animals/{animalsid}/photoAlbum/{photoAlbumid})
    - [POST animals/{animalsid}/photoAlbum/{photoAlbumid}](#POST-animals/{animalsid}/photoAlbum/{photoAlbumid})
    - [PUT animals/{animalsid}/photoAlbum](#PUT-animals/{animalsid}/photoAlbum)
    - [DELETE animals/{animalsid}/photoAlbum/{photoAlbumid}](#DELETE-animals/{animalsid}/photoAlbum/{photoAlbumid}])
  - [Recurso Specie](#recurso-specie)
    - [GET /species](#GET-/species)
    - [GET /species/{id}](#GET-/species/{id})
    - [POST /species](#POST-/species)
    - [PUT /species/{id}](#PUT-/species/{id})
    - [DELETE /species/{id}](#DELETE-/species/{id})
    - [GET species/{speciesid}/breeds](#GET-species/{speciesid}/breeds)
    - [GET species/{speciesid}/breeds/{breedsid}](#GET-species/{speciesid}/breeds/{breedsid})
    - [POST species/{speciesid}/breeds/{breedsid}](#POST-species/{speciesid}/breeds/{breedsid})
    - [PUT species/{speciesid}/breeds](#PUT-species/{speciesid}/breeds)
    - [DELETE species/{speciesid}/breeds/{breedsid}](#DELETE-species/{speciesid}/breeds/{breedsid}])
  - [Recurso Breed](#recurso-breed)
    - [GET /breeds](#GET-/breeds)
    - [GET /breeds/{id}](#GET-/breeds/{id})
    - [POST /breeds](#POST-/breeds)
    - [PUT /breeds/{id}](#PUT-/breeds/{id})
    - [DELETE /breeds/{id}](#DELETE-/breeds/{id})
    - [GET breeds/{breedsid}/animal](#GET-breeds/{breedsid}/animal)
    - [GET breeds/{breedsid}/animal/{animalid}](#GET-breeds/{breedsid}/animal/{animalid})
    - [POST breeds/{breedsid}/animal/{animalid}](#POST-breeds/{breedsid}/animal/{animalid})
    - [PUT breeds/{breedsid}/animal](#PUT-breeds/{breedsid}/animal)
    - [DELETE breeds/{breedsid}/animal/{animalid}](#DELETE-breeds/{breedsid}/animal/{animalid}])

# API Rest
## Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /PetStore.api/api/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor en el header `X-Total-Count` y los registros se envían en el cuerpo del mensaje como un arreglo.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
[{}, {}, {}, {}, {}, {}]
```

## API de la aplicación PetStore
### Recurso Animal
El objeto Animal tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    birthDate: '' /*Tipo Date*/,
    color: '' /*Tipo String*/,
    gender: '' /*Tipo String*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    breed: {
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    description: '' /*Tipo String*/,
    mood: '' /*Tipo String*/,
    size: '' /*Tipo String*/,
    lifeExpectancy: '' /*Tipo Integer*/    },
    father: {
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    birthDate: '' /*Tipo Date*/,
    color: '' /*Tipo String*/,
    gender: '' /*Tipo String*/    },
    mother: {
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    birthDate: '' /*Tipo Date*/,
    color: '' /*Tipo String*/,
    gender: '' /*Tipo String*/    }
}
```



#### GET /animals

Retorna una colección de objetos Animal en representación Detail.
Cada Animal en la colección tiene embebidos los siguientes objetos: Breed, Animal, Animal.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-animal)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /animals/{id}

Retorna una colección de objetos Animal en representación Detail.
Cada Animal en la colección tiene los siguientes objetos: Breed, Animal, Animal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Animal a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Animal en [representaciones Detail](#recurso-animal)
404|No existe un objeto Animal con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /animals

Es el encargado de crear objetos Animal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Animal que será creado|Sí|[Representación Detail](#recurso-animal)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Animal ha sido creado|[Representación Detail](#recurso-animal)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Animal|Mensaje de error

#### PUT /animals/{id}

Es el encargado de actualizar objetos Animal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Animal a actualizar|Sí|Integer
body|body|Objeto Animal nuevo|Sí|[Representación Detail](#recurso-animal)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Animal actualizado|[Representación Detail](#recurso-animal)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
500|No se pudo actualizar el objeto Animal|Mensaje de error

#### DELETE /animals/{id}

Elimina un objeto Animal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Animal a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error


#### GET animals/{animalsid}/photoAlbum

Retorna una colección de objetos PhotoAlbum asociados a un objeto Animal en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Animal a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos PhotoAlbum en [representación Detail](#recurso-photoalbum)
500|Error consultando photoAlbum |Mensaje de error

#### GET animals/{animalsid}/photoAlbum/{photoAlbumid}

Retorna un objeto PhotoAlbum asociados a un objeto Animal en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
animalsid|Path|ID del objeto Animal a consultar|Sí|Integer
photoAlbumid|Path|ID del objeto PhotoAlbum a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto PhotoAlbum en [representación Detail](#recurso-photoalbum)
404|No existe un objeto PhotoAlbum con el ID solicitado asociado al objeto Animal indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST animals/{animalsid}/photoAlbum/{photoAlbumid}

Asocia un objeto PhotoAlbum a un objeto Animal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
animalsid|PathParam|ID del objeto Animal al cual se asociará el objeto PhotoAlbum|Sí|Integer
photoAlbumid|PathParam|ID del objeto PhotoAlbum a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto PhotoAlbum asociado|[Representación Detail de PhotoAlbum](#recurso-photoalbum)
500|No se pudo asociar el objeto PhotoAlbum|Mensaje de error

#### PUT animals/{animalsid}/photoAlbum

Es el encargado de actualizar un objeto PhotoAlbum asociada a un objeto Animal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
animalsid|Path|ID del objeto Animal cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos PhotoAlbum|Sí|[Representación Detail](#recurso-photoalbum)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se actualizo el objeto|Objeto PhotoAlbum en [Representación Detail](#recurso-photoalbum)
500|No se pudo actualizar|Mensaje de error

#### DELETE animals/{animalsid}/photoAlbum/{photoAlbumid}

Remueve un objeto PhotoAlbum asociado a un objeto Animal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
animalsid|Path|ID del objeto Animal asociado al objeto PhotoAlbum|Sí|Integer
photoAlbumid|Path|ID del objeto PhotoAlbum a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error


[Volver arriba](#tabla-de-contenidos)
### Recurso Specie
El objeto Specie tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/
}
```




#### GET /species

Retorna una colección de objetos Specie en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-specie)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /species/{id}

Retorna una colección de objetos Specie en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Specie a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Specie en [representaciones Detail](#recurso-specie)
404|No existe un objeto Specie con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /species

Es el encargado de crear objetos Specie.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Specie que será creado|Sí|[Representación Detail](#recurso-specie)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Specie ha sido creado|[Representación Detail](#recurso-specie)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Specie|Mensaje de error

#### PUT /species/{id}

Es el encargado de actualizar objetos Specie.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Specie a actualizar|Sí|Integer
body|body|Objeto Specie nuevo|Sí|[Representación Detail](#recurso-specie)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Specie actualizado|[Representación Detail](#recurso-specie)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
500|No se pudo actualizar el objeto Specie|Mensaje de error

#### DELETE /species/{id}

Elimina un objeto Specie.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Specie a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error

#### GET species/{speciesid}/breeds

Retorna una colección de objetos Breed asociados a un objeto Specie en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Specie a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Breed en [representación Detail](#recurso-breed)
500|Error consultando breeds |Mensaje de error

#### GET species/{speciesid}/breeds/{breedsid}

Retorna un objeto Breed asociados a un objeto Specie en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
speciesid|Path|ID del objeto Specie a consultar|Sí|Integer
breedsid|Path|ID del objeto Breed a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Breed en [representación Detail](#recurso-breed)
404|No existe un objeto Breed con el ID solicitado asociado al objeto Specie indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST species/{speciesid}/breeds/{breedsid}

Asocia un objeto Breed a un objeto Specie.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
speciesid|PathParam|ID del objeto Specie al cual se asociará el objeto Breed|Sí|Integer
breedsid|PathParam|ID del objeto Breed a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Breed asociado|[Representación Detail de Breed](#recurso-breed)
500|No se pudo asociar el objeto Breed|Mensaje de error

#### PUT species/{speciesid}/breeds

Es el encargado de remplazar la colección de objetos Breed asociada a un objeto Specie.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
speciesid|Path|ID del objeto Specie cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Breed|Sí|[Representación Detail](#recurso-breed)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Breed en [Representación Detail](#recurso-breed)
500|No se pudo remplazar la colección|Mensaje de error

#### DELETE species/{speciesid}/breeds/{breedsid}

Remueve un objeto Breed de la colección en un objeto Specie.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
speciesid|Path|ID del objeto Specie asociado al objeto Breed|Sí|Integer
breedsid|Path|ID del objeto Breed a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
### Recurso Breed
El objeto Breed tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    description: '' /*Tipo String*/,
    mood: '' /*Tipo String*/,
    size: '' /*Tipo String*/,
    lifeExpectancy: '' /*Tipo Integer*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    specie: {
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/    }
}
```



#### GET /breeds

Retorna una colección de objetos Breed en representación Detail.
Cada Breed en la colección tiene embebidos los siguientes objetos: Specie.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-breed)
409|Un objeto relacionado no existe|Mensaje de error
500|Error interno|Mensaje de error

#### GET /breeds/{id}

Retorna una colección de objetos Breed en representación Detail.
Cada Breed en la colección tiene los siguientes objetos: Specie.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Breed a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Breed en [representaciones Detail](#recurso-breed)
404|No existe un objeto Breed con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /breeds

Es el encargado de crear objetos Breed.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Breed que será creado|Sí|[Representación Detail](#recurso-breed)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Breed ha sido creado|[Representación Detail](#recurso-breed)
409|Un objeto relacionado no existe|Mensaje de error
500|No se pudo crear el objeto Breed|Mensaje de error

#### PUT /breeds/{id}

Es el encargado de actualizar objetos Breed.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Breed a actualizar|Sí|Integer
body|body|Objeto Breed nuevo|Sí|[Representación Detail](#recurso-breed)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Breed actualizado|[Representación Detail](#recurso-breed)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
500|No se pudo actualizar el objeto Breed|Mensaje de error

#### DELETE /breeds/{id}

Elimina un objeto Breed.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Breed a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error

#### GET breeds/{breedsid}/animal

Retorna una colección de objetos Animal asociados a un objeto Breed en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Breed a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Animal en [representación Detail](#recurso-animal)
500|Error consultando animal |Mensaje de error

#### GET breeds/{breedsid}/animal/{animalid}

Retorna un objeto Animal asociados a un objeto Breed en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
breedsid|Path|ID del objeto Breed a consultar|Sí|Integer
animalid|Path|ID del objeto Animal a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Animal en [representación Detail](#recurso-animal)
404|No existe un objeto Animal con el ID solicitado asociado al objeto Breed indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST breeds/{breedsid}/animal/{animalid}

Asocia un objeto Animal a un objeto Breed.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
breedsid|PathParam|ID del objeto Breed al cual se asociará el objeto Animal|Sí|Integer
animalid|PathParam|ID del objeto Animal a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Animal asociado|[Representación Detail de Animal](#recurso-animal)
500|No se pudo asociar el objeto Animal|Mensaje de error

#### PUT breeds/{breedsid}/animal

Es el encargado de remplazar la colección de objetos Animal asociada a un objeto Breed.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
breedsid|Path|ID del objeto Breed cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Animal|Sí|[Representación Detail](#recurso-animal)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Animal en [Representación Detail](#recurso-animal)
500|No se pudo remplazar la colección|Mensaje de error

#### DELETE breeds/{breedsid}/animal/{animalid}

Remueve un objeto Animal de la colección en un objeto Breed.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
breedsid|Path|ID del objeto Breed asociado al objeto Animal|Sí|Integer
animalid|Path|ID del objeto Animal a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error



[Volver arriba](#tabla-de-contenidos)
