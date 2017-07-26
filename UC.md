Se requiere una página web para la venta de diferentes animales domésticos que posea la información de las razas, tipos de animales vendidos y fotos de los mismos.

La página debe contener a demás una sección de registro para que los clientes puedan comprar las mascotas y un rol de administrador para manipular todos los datos de la página.

# Lista de entidades
-  [Entidad Animal](#entidad-animal---casos-de-uso)
-  [Entidad Specie](#entidad-specie---casos-de-uso)
-  [Entidad Breed](#entidad-breed---casos-de-uso)
-  [Entidad PhotoAlbum](#entidad-photoalbum---casos-de-uso)

## Entidad Animal - Casos de Uso
 - [Crear animal](#uc-crear-animal)
 - [Consultar animal](#uc-consultar-animal)
 - [Editar animal](#uc-editar-animal)
 - [Eliminar animal](#uc-eliminar-animal)





 - [Crear _photoAlbum_ a Animal](#uc-crear-photoAlbum-a-animal)
 - [Editar _photoAlbum_ a Animal](#uc-editar-photoAlbum-a-animal)
 - [Eliminar _photoAlbum_ a Animal](#uc-eliminar-photoAlbum-a-animal)
 - [Listar _photoAlbum_ a Animal](#uc-listar-photoAlbum-a-animal)





### UC Crear animal
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R000 |
|Nombre caso de uso:| Crear Animal |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor crea Animal en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de crear Animal, el formulario de registro se despliega.|
|                        | 3. El actor digita la informaci&oacute;n del formulario de Animal con los campos de: _name_ , _birthDate_ , _color_ , _gender_ .|                        
|                        | 4. Se guardan cambios de Animal.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacuten | |


### UC Editar animal
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R001 |
|Nombre caso de uso:| Editar Animal |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor edita Animal en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de editar Animal el formulario de registro se despliega.|
|                        | 3. El actor digita la informaci&oacute;n del formulario de Animal con los campos de: _name_ , _birthDate_ , _color_ , _gender_ .|
|                        | 4. Se guardan cambios de Animal.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||

### UC Consultar animal
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R002 |
|Nombre caso de uso:| Consultar Animal |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor consulta Animal en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de listar Animal.|
|                        | 3. La aplicaci&oacute;n muestra la informaci&oacute;n de Animal.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||

### UC Eliminar animal
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R003 |
|Nombre caso de uso:| Eliminar Animal |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor elimina Animal en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de eliminar Animal.|
|                        | 3. La aplicaci&oacute;n eliminar Animal.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||








### UC crear _photoAlbum_ a Animal
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R000 |
|Nombre caso de uso:| Crear photoAlbum |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor crea photoAlbum en la aplicaci&oacute;n a Animal.|
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de Animal.|
|                        | 3. El actor selecciona la opci&oacute;n de crear PhotoAlbum.|
|                        | 4. El actor completa el formulario de PhotoAlbum.|
|                        | 5. Se guardan cambios de Animal.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||

### UC editar _photoAlbum_ a Animal
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R001 |
|Nombre caso de uso:| Editar photoAlbum |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor edita photoAlbum en la aplicaci&oacute;n a Animal.|
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de Animal.|
|                        | 3. El actor selecciona la opci&oacute;n de editar PhotoAlbum.|
|                        | 4. El actor completa el formulario de PhotoAlbum.|
|                        | 5. Se guardan cambios de Animal.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||

### UC eliminar _photoAlbum_ a Animal
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R002 |
|Nombre caso de uso:| Eliminar photoAlbum |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor elimina photoAlbum en la aplicaci&oacute;n a Animal.|
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de Animal.|
|                        | 3. El actor selecciona la opci&oacute;n de eliminar PhotoAlbum.|
|                        | 4. La aplicaci&oacute;n elimina PhotoAlbum de Animal.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||

### UC Listar _photoAlbum_ a Animal
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R003 |
|Nombre caso de uso:| Listar photoAlbum |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor lista photoAlbum en la aplicaci&oacute;n a Animal.|
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n Animal.|
|                        | 3. La aplicaci&oacute;n muestra la informaci&oacute;n de photoAlbum asociadas a Animal.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||





## Entidad Specie - Casos de Uso
 - [Crear specie](#uc-crear-specie)
 - [Consultar specie](#uc-consultar-specie)
 - [Editar specie](#uc-editar-specie)
 - [Eliminar specie](#uc-eliminar-specie)





### UC Crear specie
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R000 |
|Nombre caso de uso:| Crear Specie |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor crea Specie en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de crear Specie, el formulario de registro se despliega.|
|                        | 3. El actor digita la informaci&oacute;n del formulario de Specie con los campos de: _name_ .|                        
|                        | 4. Se guardan cambios de Specie.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacuten | |


### UC Editar specie
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R001 |
|Nombre caso de uso:| Editar Specie |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor edita Specie en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de editar Specie el formulario de registro se despliega.|
|                        | 3. El actor digita la informaci&oacute;n del formulario de Specie con los campos de: _name_ .|
|                        | 4. Se guardan cambios de Specie.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||

### UC Consultar specie
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R002 |
|Nombre caso de uso:| Consultar Specie |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor consulta Specie en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de listar Specie.|
|                        | 3. La aplicaci&oacute;n muestra la informaci&oacute;n de Specie.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||

### UC Eliminar specie
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R003 |
|Nombre caso de uso:| Eliminar Specie |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor elimina Specie en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de eliminar Specie.|
|                        | 3. La aplicaci&oacute;n eliminar Specie.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||








## Entidad Breed - Casos de Uso
 - [Crear breed](#uc-crear-breed)
 - [Consultar breed](#uc-consultar-breed)
 - [Editar breed](#uc-editar-breed)
 - [Eliminar breed](#uc-eliminar-breed)







### UC Crear breed
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R000 |
|Nombre caso de uso:| Crear Breed |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor crea Breed en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de crear Breed, el formulario de registro se despliega.|
|                        | 3. El actor digita la informaci&oacute;n del formulario de Breed con los campos de: _name_ , _description_ , _mood_ , _size_ , _lifeExpectancy_ .|                        
|                        | 4. Se guardan cambios de Breed.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacuten | |


### UC Editar breed
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R001 |
|Nombre caso de uso:| Editar Breed |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor edita Breed en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de editar Breed el formulario de registro se despliega.|
|                        | 3. El actor digita la informaci&oacute;n del formulario de Breed con los campos de: _name_ , _description_ , _mood_ , _size_ , _lifeExpectancy_ .|
|                        | 4. Se guardan cambios de Breed.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||

### UC Consultar breed
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R002 |
|Nombre caso de uso:| Consultar Breed |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor consulta Breed en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de listar Breed.|
|                        | 3. La aplicaci&oacute;n muestra la informaci&oacute;n de Breed.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||

### UC Eliminar breed
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R003 |
|Nombre caso de uso:| Eliminar Breed |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor elimina Breed en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de eliminar Breed.|
|                        | 3. La aplicaci&oacute;n eliminar Breed.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||










## Entidad PhotoAlbum - Casos de Uso
 - [Crear photoalbum](#uc-crear-photoalbum)
 - [Consultar photoalbum](#uc-consultar-photoalbum)
 - [Editar photoalbum](#uc-editar-photoalbum)
 - [Eliminar photoalbum](#uc-eliminar-photoalbum)





### UC Crear photoalbum
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R000 |
|Nombre caso de uso:| Crear PhotoAlbum |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor crea PhotoAlbum en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de crear PhotoAlbum, el formulario de registro se despliega.|
|                        | 3. El actor digita la informaci&oacute;n del formulario de PhotoAlbum con los campos de: _name_ , _image_ .|                        
|                        | 4. Se guardan cambios de PhotoAlbum.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacuten | |


### UC Editar photoalbum
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R001 |
|Nombre caso de uso:| Editar PhotoAlbum |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor edita PhotoAlbum en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de editar PhotoAlbum el formulario de registro se despliega.|
|                        | 3. El actor digita la informaci&oacute;n del formulario de PhotoAlbum con los campos de: _name_ , _image_ .|
|                        | 4. Se guardan cambios de PhotoAlbum.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||

### UC Consultar photoalbum
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R002 |
|Nombre caso de uso:| Consultar PhotoAlbum |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor consulta PhotoAlbum en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de listar PhotoAlbum.|
|                        | 3. La aplicaci&oacute;n muestra la informaci&oacute;n de PhotoAlbum.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||

### UC Eliminar photoalbum
| Item | Descripci&oacute;n |
|----------------------|-------------------------------------------|
|Id caso de uso:| R003 |
|Nombre caso de uso:| Eliminar PhotoAlbum |
|Autor: | @Generated |
|Actor:| Actor |
|Resumen:| El actor elimina PhotoAlbum en la aplicaci&oacute;n. |
|Precondici&oacute;n: | |
|Curso b&aacute;sico de eventos:| 1. El actor ingresa a la aplicaci&oacute;n.|
|                        | 2. El actor selecciona la opci&oacute;n de eliminar PhotoAlbum.|
|                        | 3. La aplicaci&oacute;n eliminar PhotoAlbum.|
|Postcondici&oacute;n:|  |
|Caminos de excepci&oacute;n ||








[Volver arriba](#lista-de-entidades)
