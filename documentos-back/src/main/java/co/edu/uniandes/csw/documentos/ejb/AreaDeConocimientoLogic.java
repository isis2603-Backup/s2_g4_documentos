/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.documentos.ejb;

import co.edu.uniandes.csw.documentos.entities.AreaDeConocimientoEntity;
import co.edu.uniandes.csw.documentos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.documentos.persistence.AreaDeConocimientoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Camilojaravila
 */
@Stateless
public class AreaDeConocimientoLogic{
    
    private static final Logger LOGGER = Logger.getLogger(AreaDeConocimientoLogic.class.getName());

    @Inject
    private AreaDeConocimientoPersistence persistence;

    //@Inject
    //private DocumentoLogic DocumentoLogic;

    /**
     * Se encarga de crear un Area De Conocimiento en la base de datos.
     *
     * @param entity Objeto de AreaDeConocimientoEntity con los datos nuevos
     * @return Objeto de AreaDeConocimientoEntity con los datos nuevos y su ID.
     * @throws BusinessLogicException Excepción cuando se incumple una regla de negocio.
     */
    public AreaDeConocimientoEntity createArea(AreaDeConocimientoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de crear un Area de Conocimiento");
        
        AreaDeConocimientoEntity buscado = persistence.find(entity.getId());
        if (buscado != null){
            LOGGER.log(Level.INFO, "El Area de Conocimiento con el id {0} ya existe" , entity.getId());
            throw new BusinessLogicException("El Area de Conocimiento con el id " + entity.getId() + " ya existe");
        }
        else if (!(entity.getTipo().matches("([A-Z]|[a-z]|[0-9]|\\s)+")|| entity.getTipo().contains(" "))){
            LOGGER.log(Level.INFO, "El nombre del area de conocimiento no puede contener caracteres especiales");
            throw new BusinessLogicException("El nombre del area de conocimiento no puede contener caracteres especiales");
        }
        
        return persistence.create(entity);
        }
    
         /**
     * Obtiene la lista de los registros de Area De Conocimiento.
     *
     * @return Colección de objetos de AutorEntity.
     */
    public List<AreaDeConocimientoEntity> getAreas() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las areas de conocimiento");
        return persistence.findAll();
    }
    
     /**
     * Obtiene los datos de una instancia de un Area de Conocimiento a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de AreaDeConocimientoEntity con los datos del Area de Conocimiento consultado.
     */
    public AreaDeConocimientoEntity getArea(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una area de conocimiento con id = {0}", id);
        return persistence.find(id);
    }

    /**
     * Actualiza la información de una instancia de Area de Conocimiento.
     *
     * @param entity Instancia de AreaDeConocimientoEntity con los nuevos datos.
     * @return Instancia de AreaDeConocimientoEntity con los datos actualizados.
     * @throws BusinessLogicException Excepción cuando se incumple una regla de negocio.
     */
    public AreaDeConocimientoEntity updateArea(AreaDeConocimientoEntity entity) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una area de conocimineto");
        
        AreaDeConocimientoEntity buscado = persistence.find(entity.getId());
        if (buscado == null){
            LOGGER.log(Level.INFO, "El Area de Conocimiento con el id {0} no existe" , entity.getId());
            throw new BusinessLogicException("El Area de Conocimiento con el id " + entity.getId() + " no existe");
        }
        else if (!(entity.getTipo().matches("([A-Z]|[a-z]|[0-9]|\\s)+")|| entity.getTipo().contains(" "))){
            LOGGER.log(Level.INFO, "El nombre del area de conocimiento no puede contener caracteres especiales");
            throw new BusinessLogicException("El nombre del area de conocimiento no puede contener caracteres especiales");
        }
        
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Area de Conocimiento de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @throws BusinessLogicException Excepción cuando se incumple una regla de negocio.
     */
    public void deleteArea(Long id) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un area ");

        AreaDeConocimientoEntity buscado = persistence.find(id);
        if (buscado == null){
            LOGGER.log(Level.INFO, "El area de conocimiento con el id {0} no existe", id);
            throw new BusinessLogicException("El area de conocimiento con el id " + id + " no existe");
        }

        persistence.delete(id);
    }

}
