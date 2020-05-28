/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import unicundi.edu.discotienda.BeansLogica.ServiceArtista;

/**
 *
 * @author PIPE
 */
@Named(value = "formArtista")
@ViewScoped
public class FormArtista implements Serializable{

    private String nombre;
    private String generoMusical;
    private String prueba;
            
    @Inject
    private ServiceArtista service;
    /**
     * Creates a new instance of FormArtista
     */
    public FormArtista() {
    }

    public void agragarArtista() {

        service.agregarArtista(nombre, generoMusical);
        
    }

    public void editarArtista(RowEditEvent event) {

    }

    public void cancelarEdicion(RowEditEvent event) {

    }

    public void eliminarArtista() {

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

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

}
