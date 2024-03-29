/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.documentos.persistence;

import co.edu.uniandes.csw.documentos.entities.ImagenEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Camilojaravila
 */
@Stateless
public class ImagenPersistence {
    
    private static final Logger LOGGER=Logger.getLogger(ImagenEntity.class.getName());
    
    @PersistenceContext(unitName = "DocumentosPU")
    protected  EntityManager em;
    
    /**
     * 
     * @param entity. Objeto de tipo imagen que se creara en la base de datos
     * @return null si no existe ningun area de conocimiento con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public ImagenEntity create(ImagenEntity entity){
        LOGGER.info("Creando una imagen nueva");
        em.persist(entity);
        LOGGER.info("Creando una imagen nueva");
        return entity;
    }
    
    /**
     * 
     * @param id Id de la imagen
     * @return Imagen o null en caso de no encontrarlo
     */
    public ImagenEntity find(Long id){
        return em.find(ImagenEntity.class, id);
    }
    
    /**
     * 
     * @return Una lista con todas las imagenes en el sistema
     */
    public List<ImagenEntity> findAll() {
        LOGGER.info("Consultando todas las imagenes");
        TypedQuery query = em.createQuery("select u from ImagenEntity u", ImagenEntity.class);
        return query.getResultList();
    }
    
    /**
     * 
     * @param entity Imagen que se va a actualizar
     * @return La Imagen ya actualizada
     */
    public ImagenEntity update(ImagenEntity entity){
        Long id = entity.getId();
        LOGGER.log(Level.INFO, "Actualizando la imagen con id {0}", id);
        return em.merge(entity);
    }
    /**
     * 
     * @param id Id de la imagen
     */
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Actualizando la imagen con id {0}", id);
        ImagenEntity entity = find(id);
        em.remove(entity);
    }
}
