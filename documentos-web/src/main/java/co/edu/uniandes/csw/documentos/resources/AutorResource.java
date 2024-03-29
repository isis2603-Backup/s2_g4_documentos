/*
MIT License

Copyright (c) 2017 ISIS2603

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
CITYS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.documentos.resources;


import co.edu.uniandes.csw.documentos.dtos.AutorDetailDTO;
import co.edu.uniandes.csw.documentos.ejb.AutorLogic;
import co.edu.uniandes.csw.documentos.entities.AutorEntity;
import co.edu.uniandes.csw.documentos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.documentos.mappers.BusinessLogicExceptionMapper;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 * <pre>Clase que implementa el recurso "autores".
 * URL: /api/autores
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "autores".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author Camilojaravila  
 * @version 2.0
 */
@Path("autores")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AutorResource {
    
    /**
     * Injecta las reglas de negocio del autor
     */
    @Inject
    private AutorLogic autorLogic;

        /**
     * Convierte una lista de AutorEntity a una lista de AutorDetailDTO.
     *
     * @param entityList Lista de AutorEntity a convertir.
     * @return Lista de AutorDetailDTO convertida.
     * 
     */
    private List<AutorDetailDTO> listEntity2DTO(List<AutorEntity> entityList) {
        List<AutorDetailDTO> list = new ArrayList<>();
        for (AutorEntity entity : entityList) {
            list.add(new AutorDetailDTO(entity));
        }
        return list;       
    }
    /**
     * <h1>POST /api/autores : Crear un autor.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link AutorDetailDTO}.
     * 
     * Crea un nuevo autor con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó un nuevo autor.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el autor.
     * </code>
     * </pre>
     * @param autor {@link AutorDetailDTO} - El autor que se desea guardar.
     * @return JSON {@link AutorDetailDTO}  - El autor guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el autor.
     */
    @POST
    public AutorDetailDTO createAutor(AutorDetailDTO autor) throws BusinessLogicException {
        AutorEntity entity = autor.toEntity();
        AutorEntity nuevo = autorLogic.createAutor(entity);
        return new AutorDetailDTO(nuevo);
    }

    /**
     * <h1>GET /api/autores : Obtener todas los autores.</h1>
     * 
     * <pre>Busca y devuelve todas los autores que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas los autores de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link AutorDetailDTO} - Los autores encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<AutorDetailDTO> getAutores() {
        return listEntity2DTO(autorLogic.getAutores());
    }

    /**
     * <h1>GET /api/autores/{id} : Obtener autores por id.</h1>
     * 
     * <pre>Busca el autor con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el autor correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un autor con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del autor que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link AutorDetailDTO} - El autor buscada
     */
    @GET
    @Path("{id: \\d+}")
    public AutorDetailDTO getAutor(@PathParam("id") Long id) {
        AutorEntity entity = autorLogic.getAutor(id);
        if (entity == null){
            throw new WebApplicationException("El Autor no existe", 404);
        }
        return new AutorDetailDTO(entity);
    }
    
    /**
     * <h1>PUT /api/autores/{id} : Actualizar autor con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link AutorDetailDTO}.
     * 
     * Actualiza el autor con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el autor con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un autor con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del autor que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param autor {@link AutorDetailDTO} El autor que se desea guardar.
     * @return JSON {@link AutorDetailDTO} - El autor guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el autor porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public AutorDetailDTO updateAutor(@PathParam("id") Long id, AutorDetailDTO autor) throws BusinessLogicException {
        autor.setId(id);
        AutorEntity entity = autorLogic.getAutor(id);
        if (entity == null){
            throw new WebApplicationException("El Autor con el id "+ id + " no existe", 404);
        }
        
        return new AutorDetailDTO(autorLogic.updateAutor(autor.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/autores/{id} : Borrar autor por id.</h1>
     * 
     * <pre>Borra el autor con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el autor correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un autor con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del autor que se desea borrar. Este debe ser una cadena de dígitos.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no encontrar el autor.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteAutor(@PathParam("id") Long id) throws BusinessLogicException {
        // Void
        AutorEntity entity = autorLogic.getAutor(id);
        if (entity == null){
            throw new WebApplicationException("El Autor con el id "+ id + " no existe", 404);
        }
        
        autorLogic.deleteAutor(id);
    }
     
    /**
     * <h1>GET /api/autores/{tipo} : Obtener todas los autores según el tipo.</h1>
     * 
     * <pre>Busca y devuelve todos los autores que existen en la aplicacion según el tipo.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las areas de la aplicacion.</code> 
     * </pre>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un autor con el id dado.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precondition Failed. La precondición ha fallado.
     * </code>
     * @param nombre Identificador del area que se desea borrar. Este debe ser una cadena de dígitos.
     * @return JSONArray {@link AreaDeConocimientoDetailDTO} - Las areas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    @Path("{nombre}")
    public List<AutorDetailDTO> getAreasByTipo(@PathParam("nombre") String nombre){
        try{
            return listEntity2DTO(autorLogic.getAutoresByNombre(nombre));
        }
        catch (BusinessLogicException e){
            throw new WebApplicationException(e.getMessage(),412);
        }    
    }
}
