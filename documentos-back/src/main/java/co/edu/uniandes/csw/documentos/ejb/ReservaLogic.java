/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.documentos.ejb;

import co.edu.uniandes.csw.documentos.entities.ReservaEntity;
import co.edu.uniandes.csw.documentos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.documentos.persistence.ReservaPersistence;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author f.marroquin10
 */
@Stateless
public class ReservaLogic {

    private static final Logger LOGGER = Logger.getLogger(ReservaLogic.class.getName());

    @Inject
    private ReservaPersistence persistence;

    /**
     * Se encarga de crear una Reserva en la base de datos.
     *
     * @param entity Objeto de ReservaEntity con los datos nuevos
     * @return Objeto de ReservaEntity con los datos nuevos y su ID.
     * @throws co.edu.uniandes.csw.documentos.exceptions.BusinessLogicException
     */
    public ReservaEntity createReserva(ReservaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de crear una Reserva ");
        ReservaEntity buscado = persistence.find(entity.getId());
        if (buscado != null) {
            LOGGER.log(Level.INFO, "La Reserva con el id {0} ya existe ", entity.getId());
            throw new BusinessLogicException("La Reserva con el id  ya existe");

        } else if (entity.getId() == null || entity.getFecha() == null) {
            LOGGER.log(Level.INFO, "los atributos son nulos o invalidos");
            throw new BusinessLogicException("los atributos son nulos o invalidos");

        } else if (entity.getCosto() < 0) {
            LOGGER.log(Level.INFO, "La Reserva tiene un valor menor a cero");
            throw new BusinessLogicException("La Reserva tiene un valor menor a cero");

        } else {

            return persistence.create(entity);
        }

    }

    /**
     * Obtiene la lista de los registros de Reservaes de un Documento dado.
     *
     * @return Colección de objetos de ReservaEntity.
     */
    public List<ReservaEntity> getReservas() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las Reservaes");

        return persistence.findAll();
    }

    /**
     * Obtiene los datos de una instancia de un Reserva a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de ReservaEntity con los datos de la Reserva
     * consultada.
     */
    public ReservaEntity getReserva(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una Reserva con id = {0}", id);
        if (id == null) {
            LOGGER.log(Level.INFO, "el id no puede ser nulo");
            throw new BusinessLogicException("el id no puede ser nulo");

        }
        ReservaEntity reserva = persistence.find(id);
        if (reserva == null) {
            throw new BusinessLogicException("la reserva no existe");
        }
        return reserva;
    }

    /**
     * Actualiza la información de una instancia de Reserva.
     *
     * @param entity Instancia de ReservaEntity con los nuevos datos.
     * @return Instancia de ReservaEntity con los datos actualizados.
     */
    public ReservaEntity updateReserva(ReservaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una Reserva ");
        double cero = 0.0;
        ReservaEntity buscado = persistence.find(entity.getId());
        if (buscado == null) {
            LOGGER.log(Level.INFO, "La Reserva con el id {0} no existe ", entity.getId());
            throw new BusinessLogicException("La Reserva con el id dado no existe ");

        } else if (entity.getId() == null || entity.getFecha() == null || entity.getCosto() == cero) {

            LOGGER.log(Level.INFO, "los atributos son nulos o invalidos");
            throw new BusinessLogicException("los atributos son nulos o invalidos");

        } else if (entity.getCosto() < 0) {
            LOGGER.log(Level.INFO, "La Reserva tiene un valor menor a cero");
            throw new BusinessLogicException("La Reserva tiene un valor menor a cero");

        } else if (entity.getFecha().before(new Date())) {
            LOGGER.log(Level.INFO, "la fecha de la reserva es anterior a la fecha actual");
            throw new BusinessLogicException("la fecha de la reserva es anterior a la fecha actual");

        } else {
            return persistence.update(entity);
        }

    }

    /**
     * Elimina una instancia de Reserva de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteReserva(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un reserva ");
        if (id == null) {
            throw new BusinessLogicException("la reserva con el id dado no existe " + id);
        }

        ReservaEntity buscado = persistence.find(id);
        if (buscado == null) {
            LOGGER.log(Level.INFO, "la Reserva con el id {0} no existe ", id);
            throw new BusinessLogicException("la reserva con el id dado no existe " + id);

        } else {
            persistence.delete(id);
        }
    }

}
