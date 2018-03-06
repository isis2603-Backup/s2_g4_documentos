/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.documentos.ejb;

import co.edu.uniandes.csw.documentos.entities.PayPalEntity;
import co.edu.uniandes.csw.documentos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.documentos.persistence.PayPalPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author g.ospinaa
 */
@Stateless
public class PayPalLogic {
    
    private static final Logger LOGGER = Logger.getLogger(PayPalLogic.class.getName());

    @Inject
    private PayPalPersistence persistence;
    
    /**
     * Obtiene la lista de las cuentas PayPal
     * 
     * @return Coleccion de objetos PayPalEntity
     */
    public List<PayPalEntity> getPayPal()
    {
        LOGGER.log(Level.INFO,"Inicia proceso de consultar cuentas PayPal");
        return persistence.findAll();
    }
    
    /**
     * Obtiene los datos de una instancia de PayPal a partir de su ID.
     * 
     * @para id Identificacion de la cuenta
     * @return Instancia de PayPalENtity con los datos de la cuenta consultada
     */
    public PayPalEntity getPayPal(Long Id)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de encontrar cuenta con id = {0}", Id);
        if (persistence.find(Id) == null) {
            LOGGER.log(Level.SEVERE, "La cuenta con el id {0} no existe", Id);
        }
        return persistence.find(Id);
    }
    /**
     * Se encarga de crear una cuenta PayPal
     * 
     * @param payp cuenta de PayPal a crear
     * @return instancia de cuenta PayPal
     */
    public PayPalEntity createPayPal(PayPalEntity payp)
    {        
        LOGGER.log(Level.INFO, "Empezando la creacion de nueva cuenta PayPal");
        
        if(payp.getCorreoElectronico().contains("@"))
        {
            if(persistence.findByMail(payp.getCorreoElectronico()) == null)
            {
               if(persistence.find(payp.getId()) == null)
               {
                return persistence.create(payp);
               }
               LOGGER.log(Level.INFO, "El id de la cuenta no es valido");
               return null;
            }
            LOGGER.log(Level.INFO, "el mail de la cuenta PayPal ya esta registrado");
            return null;
            
        }
        LOGGER.log(Level.INFO, "El correo no es valido");
        return null;
    }
    
    /**
     * Actualiza la informacion de una instancia de PayPal.
     * 
     * @param payp Instancia de PayPal con los nuevos datos
     * @return Instancia de PayPal actualizada.
     */
    public PayPalEntity updatePayPal(PayPalEntity payp)
    {
       
         LOGGER.log(Level.INFO, "Comenzando proceso para actualizar instancia de PayPal");
         
         if(payp.getCorreoElectronico().contains("@"))
         {
             if(persistence.find(payp.getId()) != null)
                     {
                        return persistence.update(payp);
                     }
            LOGGER.log(Level.INFO, "El id a actualizar no existe, recuerde que el id no puede ser modificado");
            return null;
         }
         LOGGER.log(Level.INFO, "el mail que ingreso no es valido");
         return null;
         
        
    }
    
    /**
     * Elimina una instancia de PayPal de la base de datos.
     * 
     * @param Id Identificador de PayPal a borrar
     */
    public void deletePayPal(Long Id)
    {
        PayPalEntity busqueda = persistence.find(Id);        
        if(busqueda != null)
        {
         LOGGER.log(Level.INFO, "Comenzando proceso de eliminacion de Instancia de PayPal");
         persistence.delete(Id);
        }
        else{
        LOGGER.log(Level.INFO, "La cuenta con el correo {0} no existe", busqueda.getCorreoElectronico());
        //Void
        }
    }
    
    
    
    
}
