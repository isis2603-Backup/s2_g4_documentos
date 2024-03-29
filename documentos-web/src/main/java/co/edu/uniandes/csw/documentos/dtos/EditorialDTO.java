/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.documentos.dtos;
import co.edu.uniandes.csw.documentos.entities.EditorialEntity;

/**
  * EditorialDTO Objeto de transferencia de datos de una editorial . Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      
 *      "nombre": string,
 *      
 *   }
 * </pre>
 * Por ejemplo una editorial se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      
 *      "nombre": "Torre de Babel"
 *   }
 *
 * </pre>
 */
public class EditorialDTO 
{  
    private long id;
    private String nombre;
/**
 * Constructor por defecto
 */
    public EditorialDTO() 
    {
     //constructor por defecto
    }
   public EditorialDTO(EditorialEntity entidad)
    {
        if (entidad!=null)
        {      this.id= entidad.getId();
               this.nombre= entidad.getNombre();
        }
     
    }
/**
 * 
 * @param nombre nuevo de la editorial 
 */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
/**
 * 
 * @return el nombre de la editorial
 */
    public String getNombre() {
        return nombre;
    }
  
     public EditorialEntity toEntity()
        {
            EditorialEntity rta= new EditorialEntity();
           
           rta.setId(this.id);
   
     rta.setNombre(this.nombre);
     
          
           return rta;
        }
   
}
