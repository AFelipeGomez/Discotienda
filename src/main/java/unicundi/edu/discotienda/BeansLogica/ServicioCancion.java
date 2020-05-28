/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.BeansLogica;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import unicundi.edu.discotienda.Model.Cancion;
import unicundi.edu.discotienda.Model.Disco;

/**
 *
 * @author PIPE
 */
@Named(value = "servicioCancion")
@RequestScoped
public class ServicioCancion {

    @Inject
    private ServicioSentencia service;

    /**
     * Creates a new instance of ServicioCancion
     */
    public ServicioCancion() {
    }

    public void agregarCancion(String nombre,String duracion,String formato,Integer precio) {
        Integer idDisco=1;
        Integer idArtista=6;
        Disco disco = new Disco();
        Cancion cancion = new Cancion();
        cancion.setNombre(nombre);
        cancion.setDuracion(duracion);
        cancion.setFormato(formato);
        cancion.setPrecio(precio);
        
        //this.idAlbum = Integer.parseInt(cancionFormulario.getNombreAlbum());
        String Sql = " INSERT INTO cancion(id_Artista,id_Disco,nombre,duracion+formatio+precio) VALUES ('" +idDisco+ "'," + "'" + idArtista + "'," + "'" + cancion.getNombre() +"',"+cancion.getDuracion() + "',"+cancion.getFormato() + "',"+cancion.getPrecio() + ");";
        System.out.println("Nombre" + cancion.getNombre());
        System.out.println("Sentencia" + Sql);
        service.transaccionesSql(Sql);
        System.out.println("Paso Servicio");
        FacesMessage message = new FacesMessage("Cancion Guardada ");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void listarCancion() {

    }

    public void actualizarCancion() {

    }

    public void eliminarCancion() {

    }

}
