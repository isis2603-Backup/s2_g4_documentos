/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.documentos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import javax.persistence.ManyToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author n.sotelo
 */
@Entity
public class CursoEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String codigo;
    private String departamento;
    @PodamExclude
    @ManyToMany(mappedBy = "cursos")
    private List<DocumentoEntity> BibliografiaDelCurso; 
/**
 * 
 * @return Lista que represenata la bibliografia del curso 
 */
    public List<DocumentoEntity> getBibliografiaDelCurso() {
        return BibliografiaDelCurso;
    }
/**
 * 
 * @param BibliografiaDelCurso  Nueva lista que contiene la bibliografia del curso. 
 */
    public void setBibliografiaDelCurso(List<DocumentoEntity> BibliografiaDelCurso) {
        this.BibliografiaDelCurso = BibliografiaDelCurso;
    }
    
    

    /**
     * 
     * @return id que identifica al curso
     */
   
    public Long getId() {
        return id;
    }
    /**
     * 
     * @param id nuevo que se desea establecer al curso
     */

    public void setId(Long id) {
        this.id = id;
    }
    
/**
 * 
 * @return Nombre del curso
 */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * 
     * @param nombre nuevo para el curso 
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * 
 * @return codigo del curso
 */
    public String getCodigo() {
        return codigo;
    }
  /**
   * 
   * @param codigo nuevo codigo para el curso 
   */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
/**
 * 
 * @return departamento al cual pertence el curso 
 */
    public String getDepartamento() {
        return departamento;
    }
/**
 * 
 * @param departamento nuevo departamento al que pertenece el curso 
 */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
}
