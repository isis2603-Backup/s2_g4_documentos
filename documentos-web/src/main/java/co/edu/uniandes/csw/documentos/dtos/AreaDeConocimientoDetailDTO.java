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
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.documentos.dtos;

import java.util.List;

/**
 * Clase que extiende de {@link AreaDeConocimientoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link AreaDeConocimientoDTO}
 * @author Camilojaravila
 */
public class AreaDeConocimientoDetailDTO extends AreaDeConocimientoDTO {

    private List<DocumentoDTO> documentos;
    
    /**
     * Constructor por defecto
     */
    public AreaDeConocimientoDetailDTO() {
    super();
    
    }
 
    /**
     * @return los documentos que contienen el area de conocimiento
     */
    public List<DocumentoDTO> getDocumentos() {
        return documentos;
    }

    /**
     * @param documentos Una nueva lista con todos los documentos de las areas de conocimiento 
     */
    public void setDocumentos(List<DocumentoDTO> documentos) {
        this.documentos = documentos;
    }

    
}
