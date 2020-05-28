/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.Model;

/**
 *
 * @author Andres Gomez-Ruby Cardenas
 */
public class Disco {

    private Integer id;
    private Integer idArtista;
    private String nombre;
    private String fechaLanzamiento;
    private Integer precio;

    public Disco(Integer id, Integer idArtista, String nombre, String fechaLanzamiento, Integer precio) {
        this.id = id;
        this.idArtista = idArtista;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precio = precio;
    }

    public Disco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    
    

}
