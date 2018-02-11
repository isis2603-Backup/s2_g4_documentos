/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.documentos.dtos;

/**
 * DocumentoDTO Objetode transferencia de datos de Bookzon. Los DTO contienen las
 * representaciones de los JSON que se transfierene entre el cliente y el servidor.
 * 
 * Al serializarse como JSON esta clase implemente el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": Long,
 *      "nombre": String,
 *      "calificacionPromedio": Double,
 *      "descripcion": String,
 *      "precio": Double,
 *      "caratula": String
 *  }
 * </pre>
 * por ejemplo un documento se representa asi:<br>
 * 
 * <pre>
 * 
 *  {
 *      "id": 1203,
 *      "nombre": "Amor en los tiempos del colera",
 *      "calificacion promedio": 4,1,
 *      "descripcion" : "El amor en los tiempos del cólera es una novela del escritor colombiano Gabriel García Márquez, publicada en 1985.Es una novela dedicada al verdadero amor. La novela se inspiró en la forma en que se desarrolló la relación de los padres de García Márquez. Para escribirla se entrevistó durante varios días con sus padres, cada uno por separado, para encontrar más detalles de cómo iba a escribir la novela.",
 *      "precio" : 20500,
 *      "caratula" : "https://imagessl1.casadellibro.com/a/l/t0/51/9788497592451.jpg"
 *  }
 * </pre>
 * @author Ernesto Viana
 */
public class DocumentoDTO {
    
    /**
     * Constructor por defecto
     */
    public DocumentoDTO() {
        
    }
    
    private Long id;
    private String nombre;
    private Double calificacionPromedio;
    private String descripcion;
    private Double precio;
    private String caratula;

    /**
     * 
     * @return El id del documento
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id el nuevo id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return El nombre del documento.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * 
     * @param nombre el nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return calificacion promedio dada por los usuarios al documento.
     */
    public Double getCalificacionPromedio() {
        return calificacionPromedio;
    }
    
    /**
     * 
     * @param calificacionPromedio nueva calificacion.
     */
    public void setCalificacionPromedio(Double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }
    
    /**
     * 
     * @return Descripcion del documento.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     * @param descripcion nueva Descricion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * 
     * @return precio del documento.
     */
    public Double getPrecio() {
        return precio;
    }
    
    /**
     * 
     * @param precio nuevo precio
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * 
     * @return cadena de caracteres que contiene un link a la imagen.
     */
    public String getCaratula() {
        return caratula;
    }

    /**
     * 
     * @param caratula nueva Caratula.
     */
    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }
    
    
    
}
