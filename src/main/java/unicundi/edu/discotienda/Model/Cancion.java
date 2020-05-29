/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.Model;

/**
 *
 * @author PIPE
 */
public class Cancion {

    private Integer id;
    private Integer idDisco;
    private String nombre;
    private String duracion;
    private String formato;
    private Integer precio;
    private String nombreDisco;
    
    public Cancion(){
        
    }

    public Cancion(Integer id, Integer idDisco, String nombre, String duracion, String formato, Integer precio, String nombreDisco) {
        this.id = id;
        this.idDisco = idDisco;
        this.nombre = nombre;
        this.duracion = duracion;
        this.formato = formato;
        this.precio = precio;
        this.nombreDisco = nombreDisco;
    }

    

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }
    

}
