/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import unicundi.edu.discotienda.BeansLogica.ServicioArtista;
import unicundi.edu.discotienda.Model.Artista;

/**
 *
 * @author PIPE
 */
@Named(value = "formArtista")
@RequestScoped
public class FormArtista implements Serializable {

    private List<Artista> listaArtista;
    private int id;
    private String nombre;
    private String generoMusical;

    @Inject
    private ServicioArtista service;

    /**
     * Creates a new instance of FormArtista
     */
    public FormArtista() {
    }

    @PostConstruct
    public void init() {
       consultarArtista();
        System.out.println("Entro init");

        this.listaArtista = service.getListaArtista();

    }

    public void agregarArtista() {
        System.out.println("Entro al metodo Agregar");
        service.agregarArtista(nombre, generoMusical);
    }

    public void editarArtista(RowEditEvent event) {
       service.actualizarArtista(event);
        
    }

    public void cancelarEdicion(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void eliminarArtista(Artista artista) {
        System.out.println("Entro metodoeliminar");
        service.eliminarArtista(artista);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void consultarArtista() {
        service.listarArtista();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

}
