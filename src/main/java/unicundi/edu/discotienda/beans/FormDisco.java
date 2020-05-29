/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.beans;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import unicundi.edu.discotienda.BeansLogica.ServicioArtista;
import unicundi.edu.discotienda.BeansLogica.ServicioDisco;
import unicundi.edu.discotienda.Model.Artista;
import unicundi.edu.discotienda.Model.Disco;

/**
 *
 * @author Usuario
 */
@Named(value = "formDisco")
@RequestScoped
public class FormDisco implements Serializable {

    private List<Disco> listaDisco;
    private List<Artista> listaArtista;
    private Artista artista;

    private Integer idArtista;
    private String nombre;
    private Date fecha;
    
    private String fechaLanzamiento;
    private Integer precio;
     private LocalDate date;

    @Inject
    private ServicioDisco service;

    @Inject
    private ServicioArtista serviceArtista;

    /**
     * Creates a new instance of FormDisco
     */
    public FormDisco() {
    }

    @PostConstruct
    public void init() {
        consultarDisco();
        this.listaDisco = service.getListaDisco();
        artista = new Artista();
        System.out.println("Entro init");
        consultarArtista();
        System.out.println("despues de consultar");
        this.listaArtista = serviceArtista.getListaArtista();
        
        
        System.out.println("Listo Artistas");

        
    }

    public void agregarDisco() {
        System.out.println("Entro al metodo Agregar");        
        service.agregarDisco(idArtista, nombre, fecha.toString(), precio);
    }

    public void editarDisco(RowEditEvent event) {
        service.actualizarDisco(event);

    }

    public void cancelarEdicion(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void eliminarDisco(Disco disco) {
        System.out.println("Entro metodoeliminar");
        service.eliminarDisco(disco);

    }

    public void consultarDisco() {
        System.out.println("Entro Consulta Disco");
        service.listarDisco();
    }

    public void consultarArtista() {
        System.out.println("entro método consultar");
        serviceArtista.listarArtista();

    }
    
    public void agregarCanciones(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/AdminCancion.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(FormDisco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Disco> getListaDisco() {
        return listaDisco;
    }

    public void setListaDisco(List<Disco> listaDisco) {
        this.listaDisco = listaDisco;
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

    public ServicioDisco getService() {
        return service;
    }

    public void setService(ServicioDisco service) {
        this.service = service;
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public ServicioArtista getServiceArtista() {
        return serviceArtista;
    }

    public void setServiceArtista(ServicioArtista serviceArtista) {
        this.serviceArtista = serviceArtista;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   


    

}
