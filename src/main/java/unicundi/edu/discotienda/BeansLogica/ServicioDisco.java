/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.BeansLogica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import unicundi.edu.discotienda.Model.Artista;
import unicundi.edu.discotienda.Model.Disco;

/**
 *
 * @author Usuario
 */
@Named(value = "servicioDisco")
@RequestScoped
public class ServicioDisco {

    private Integer id;
    private List<Disco> listaDisco;
    private List<Artista> listaArtista;
    
    @Inject
    private ServicioSentencia service;

    /**
     * Creates a new instance of ServicioDisco
     */
    public ServicioDisco() {
        listaDisco = new ArrayList<>();
    }

    @PostConstruct
    public void init() {

    }

    public void agregarDisco(Integer idArtista, String nombre, String fechaLanzamiento, Integer precio) {

        Disco disco = new Disco();

        disco.setIdArtista(idArtista);
        disco.setNombre(nombre);
        disco.setNombre(fechaLanzamiento);
        disco.setPrecio(precio);

        String sql = "INSERT INTO disco (idArtista,nombre,fechaLanzamiento,precio) VALUES('" + disco.getIdArtista() + "','" + disco.getNombre()+ "','" + disco.getFechaLanzamiento() + "','" + disco.getPrecio() + "')";

        System.out.println("idArtista" + disco.getNombre());
        System.out.println("Sentencia" + sql);
        service.transaccionesSql(sql);
        System.out.println("Paso instancia servicio");
        FacesMessage message = new FacesMessage("Disco guardado");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void listarDisco() {
        System.out.println("Entro listar");
        listaDisco = new ArrayList<>();

        try {

            Statement st = service.conex.createStatement();
            String sql = "SELECT id, idArtista, nombre, fechaLanzamiento, precio  FROM disco";
            System.out.println("Sql " + sql);
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                System.out.println("Entro a lista");
                int id = Integer.parseInt(result.getString("id"));
                int idArtista = Integer.parseInt(result.getString("idArtista"));
                int precio = Integer.parseInt(result.getString("precio"));
 
                listaDisco.add(new Disco(id, idArtista, result.getString("nombre"),result.getString("fechaLanzamiento"), precio));
            }
        } catch (Exception e) {
            System.out.println("Entro excepcion metodo listar");
        }
    }
    
    public void listarArtista() throws SQLException {
        listaArtista = new ArrayList<>();
        Statement st = service.conex.createStatement();
        try {
            String sql = "SELECT id , nombre, generoMusical FROM artista";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                System.out.println("Entro a lista de artistas");
                int id = Integer.parseInt(result.getString("id"));
                listaArtista.add(new Artista(id, result.getString("nombre"), result.getString("generoMusical")));
            }
        } catch (Exception e) {

        }
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
    
   

}
