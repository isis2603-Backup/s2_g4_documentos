/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.documentos.dtos;

import co.edu.uniandes.csw.documentos.entities.AreaDeConocimientoEntity;
import co.edu.uniandes.csw.documentos.entities.AutorEntity;
import co.edu.uniandes.csw.documentos.entities.ComentarioEntity;
import co.edu.uniandes.csw.documentos.entities.CursoEntity;
import co.edu.uniandes.csw.documentos.entities.DocumentoEntity;
import co.edu.uniandes.csw.documentos.entities.ImagenEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link DocumentoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del documento vaya a la documentacion de {@link DocumentoDTO}
 * @author Ernesto Viana
 */
public class DocumentoDetailDTO extends DocumentoDTO {
    
    
    /**
     * Constructor por defecto
     */
    public DocumentoDetailDTO(){
        super();
    }
    
    /**
     * Constructor  a partir de un entity.
     * @param entity  entidad documento.
     */
    public DocumentoDetailDTO(DocumentoEntity entity){
        
        super(entity);
        if(entity.getAreas() != null) {
            areas = new ArrayList<>();
            for(AreaDeConocimientoEntity entityArea : entity.getAreas()) {
                areas.add(new AreaDeConocimientoDTO(entityArea));
            }
        } 
        if(entity.getAutores() != null) {
            autores = new ArrayList<>();
            for(AutorEntity entityAutor : entity.getAutores()) {
                autores.add(new AutorDTO(entityAutor));
            }
        }
        if(entity.getComentarios() != null) {
            comentarios = new ArrayList<>();
            for(ComentarioEntity entityComentario : entity.getComentarios()){
                comentarios.add(new ComentarioDTO(entityComentario));
            }
        }
        if(entity.getCursos() != null){
            cursos = new ArrayList<>();
            for(CursoEntity entityCurso : entity.getCursos()){
                cursos.add(new CursoDTO(entityCurso));
            }
        }
        if(entity.getImagenes() != null) {
            imagenes = new ArrayList<>();
            for(ImagenEntity entityImagen : entity.getImagenes()) {
                imagenes.add(new ImagenDTO(entityImagen));
            }
        }
        
    }
    
    /**
     * Metodo que convierte a entity.
     * @return entity convertido.
     */
    @Override
    public DocumentoEntity toEntity() {
        DocumentoEntity documentoE = super.toEntity();
        if(this.getAreas() != null) {
            List<AreaDeConocimientoEntity> areasEntity = new ArrayList<>();
            for(AreaDeConocimientoDTO dtoAreas : getAreas()){
              areasEntity.add(dtoAreas.toEntity());
            }
            documentoE.setAreas(areasEntity);
        }
        if(this.getAutores() != null) {
            List<AutorEntity> autoresEntity = new ArrayList<>();
            for(AutorDTO dtoAutores : getAutores()) {
                autoresEntity.add(dtoAutores.toEntity());
            }
            documentoE.setAutores(autoresEntity);
        }
        if(this.getComentarios() != null) {
            List<ComentarioEntity> comentariosEntity = new ArrayList<>();
            for(ComentarioDTO dtoComentarios : getComentarios()) {
              comentariosEntity.add(dtoComentarios.toEntity());
            }
            documentoE.setComentarios(comentariosEntity);
        }
        if(this.getCursos() != null) {
            List<CursoEntity> cursosEntity = new ArrayList<>();
            for(CursoDTO dtoCursos : getCursos()) {
              cursosEntity.add(dtoCursos.toEntity());
            }
            documentoE.setCursos(cursosEntity);
        }
        if(this.getImagenes() != null) {
            List<ImagenEntity> imagenesEntity = new ArrayList<>();
            for(ImagenDTO dtoImagenes : getImagenes()) {
                imagenesEntity.add(dtoImagenes.toEntity());
            }
            documentoE.setImagenes(imagenesEntity);
        }
        
        return documentoE;
    }
    
    /**
     * Relacion a varias imagenes
     */
    private List<ImagenDTO> imagenes;
    
    /**
     * Relacion de uno a muchos autores
     */
    private List<AutorDTO> autores;
    
    /**
     * Relacion de uno a muchas areas de conocimiento.
     */
    private List<AreaDeConocimientoDTO> areas;
    
    /**
     * Relacion de cero a muchos comentarios.
     */
    private List<ComentarioDTO> comentarios;
    
    /**
     * Relacion de 0 a 1 curso.
     */
    private List<CursoDTO> cursos;

    /**
     * Devuelve las imagenes asociadas a este documento.
     * @return lista de dtos de las imagenes.
     */
    public List<ImagenDTO> getImagenes() {
        return imagenes;
    }

    /**
     * Modifica las imagenes de este documento.
     * @param imagenes Las nuevas imagenes.
     */
    public void setImagenes(List<ImagenDTO> imagenes) {
        this.imagenes = imagenes;
    }

    /**
     * Devuelve los autores asociados a este documento.
     * @return lista de autores del documento.
     */
    public List<AutorDTO> getAutores() {
        return autores;
    }

    /**
     * Modifica los autores asociados a este documento.
     * @param autores Lista de autores nuevos.
     */
    public void setAutores(List<AutorDTO> autores) {
        this.autores = autores;
    }

    /**
     * Devuelve las areas de conocimiento de un documento.
     * @return lista de areas de conocimiento del documento.
     */
    public List<AreaDeConocimientoDTO> getAreas() {
        return areas;
    }

    /**
     * Modifica las areas de conocimiento.
     * @param areas Areas de conocimiento nuevas del documento.
     */
    public void setAreas(List<AreaDeConocimientoDTO> areas) {
        this.areas = areas;
    }

    /**
     * Devuelve los comentarios asociados a este documento.
     * @return Lista de comentarios del documento.
     */
    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    /**
     * Modifica los comentarios de este documento.
     * @param comentarios nuevos de este documento.
     */
    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Devuelve el curso al cual pertenece el documento.
     * @return el curso del documento.
     */
    public List<CursoDTO> getCursos() {
        return cursos;
    }

    /**
     * Modifica el curso del documento
     * @param cursos del documento.
     */
    public void setCursos(List<CursoDTO> cursos) {
        this.cursos = cursos;
    }
    
    
    
    
}
