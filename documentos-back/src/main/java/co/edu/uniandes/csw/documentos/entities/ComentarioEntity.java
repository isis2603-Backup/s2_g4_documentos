/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.documentos.entities;

import java.util.Date;
impoert javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author n.sotelo
 */
@Entity
public class ComentarioEntity implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    private Long id;
    private String comentario;
    @Temporal(javax.persitence.TemporalType.DATE)
    private Date fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
   
    
}
