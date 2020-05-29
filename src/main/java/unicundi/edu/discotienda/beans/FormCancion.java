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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import unicundi.edu.discotienda.BeansLogica.ServicioDisco;
import unicundi.edu.discotienda.BeansLogica.ServicioCancion;
import unicundi.edu.discotienda.Model.Artista;
import unicundi.edu.discotienda.Model.Disco;
import unicundi.edu.discotienda.Model.Cancion;


/**
 *
 * @author PIPE
 */
@Named(value = "formCancion")
@RequestScoped
public class FormCancion implements Serializable{ 
        
    private String discos;
    private Integer idDisco;
    private Integer idArtista;
    private String nombre;
    private String duracion;
    private String formato;
    private Integer precio;
    List<Disco> listaDisco;
    List<Cancion> listaCanciones;
    private Disco disco;
    
    @Inject
    private ServicioCancion service;
    
    @Inject
    private ServicioDisco servicio;
    
   
    /**
     * Creates a new instance of FormCancion
     */
    public FormCancion() {
         System.out.println("Inicio constructor FormCancion");
    }
    
    @PostConstruct
    public void ini(){
        consultarCanciones();
        this.listaCanciones=service.getListCancion();
        disco = new Disco();
        consultarDisco();
        this.listaDisco=servicio.getListaDisco();
        
        
        
        System.out.println("Inicio init FormCancion");
        
        
    }
    
    
    public void agregarCancion(){
        System.out.println("Entro metodo Agregar Cancion");
        System.out.println("idDisco"+idDisco);
        service.agregarCancion(idDisco,nombre,duracion,formato,precio);
        
    
    }
    
    public void listarCancion(){
        service.listarCancion();
        
    }
    
    public void actualizarCancion(RowEditEvent event){
        service.actualizarCancion(event);
    }
    public void cancelarActualizacion(RowEditEvent event){
         FacesMessage msg = new FacesMessage("Edicion Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
    
    public void eliminarCancion(Cancion cancion){
        service.eliminarCancion(cancion);
        
    }
    
    public void consultarDisco(){
        servicio.listarDisco();
    }
    public void consultarCanciones(){
       service.listarCancion();
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

   

    public List<Disco> getListaDisco() {
        return listaDisco;
    }

    public void setListaDisco(List<Disco> listaDisco) {
        this.listaDisco = listaDisco;
    }

    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

 

    public ServicioCancion getService() {
        return service;
    }

    public void setService(ServicioCancion service) {
        this.service = service;
    }


    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getDiscos() {
        return discos;
    }

    public void setDiscos(String discos) {
        this.discos = discos;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public ServicioDisco getServicio() {
        return servicio;
    }

    public void setServicio(ServicioDisco servicio) {
        this.servicio = servicio;
    }
           
    
            
    
    
    
}
