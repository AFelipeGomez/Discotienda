/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import unicundi.edu.discotienda.BeansLogica.ServicioCancion;
import unicundi.edu.discotienda.Model.Artista;
import unicundi.edu.discotienda.Model.Disco;

/**
 *
 * @author PIPE
 */
@Named(value = "formCancion")
@RequestScoped
public class FormCancion implements Serializable{ 
        
    private String disco="xx";
    private String nombre;
    private String duracion;
    private String formato;
    private String precio;
    List<Disco> listaDisco;
    List<Artista> listaArtista;
    @Inject
    private ServicioCancion service;
    /**
     * Creates a new instance of FormCancion
     */
    public FormCancion() {
        
    }
    
    @PostConstruct
    public void ini(){
        
    }
    
    
    public void agregarCancion(){
    
    }
    
    public void listarCancion(){
        
    }
    
    public void actualizarCancion(){
        
    }
    
    public void eliminarCancion(){
        
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public List<Disco> getListaDisco() {
        return listaDisco;
    }

    public void setListaDisco(List<Disco> listaDisco) {
        this.listaDisco = listaDisco;
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

    public ServicioCancion getService() {
        return service;
    }

    public void setService(ServicioCancion service) {
        this.service = service;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }
           
    
            
    
    
    
}
