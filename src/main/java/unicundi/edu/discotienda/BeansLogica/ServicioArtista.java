/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.BeansLogica;

import java.sql.Connection;
import java.sql.DriverManager;
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
import unicundi.edu.discotienda.Model.Conexion;

/**
 *
 * @author PIPE
 */
@Named(value = "servicioArtista")
@RequestScoped
public class ServicioArtista {

    private Integer id;
    private List<Artista> listaArtista;
    @Inject
    private ServicioSentencia service;

    /**
     * Creates a new instance of ServicioArtista
     */
    public ServicioArtista() {
        listaArtista = new ArrayList<>();

    }

    @PostConstruct
    public void init() {
       
    }

    public void agregarArtista(String nombre, String generoMusical) {

        Artista artista = new Artista();

        artista.setNombre(nombre);
        artista.setGeneroMusical(generoMusical);

        String sql = "INSERT INTO artista (nombre,generoMusical) VALUES('" + artista.getNombre() + "','" + artista.getGeneroMusical() + "')";

        System.out.println("Nombre" + artista.getNombre());
        System.out.println("Sentencia" + sql);
        service.transaccionesSql(sql);
        System.out.println("Paso intsacio servicio");
        FacesMessage message = new FacesMessage("Artista guardado");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void listarArtista() {
        System.out.println("Entro listar");
        listaArtista = new ArrayList<>();      

        try {
            

            Statement st = service.conex.createStatement();
            String sql = "SELECT id, nombre, generoMusical  FROM artista";
            System.out.println("Sql "+sql);
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                System.out.println("Entro a lista");
                int id = Integer.parseInt(result.getString("id"));
                listaArtista.add(new Artista(id, result.getString("nombre"), result.getString("generoMusical")));
            }
        } catch (Exception e) {
            System.out.println("Entro excepcion metodo listar");
        }
    }
    
   public void actualizarArtista(RowEditEvent event){
       System.out.println("Entro metodo actualizacion");
        Artista artista = (Artista) event.getObject();
        this.id = artista.getId();
       System.out.println("Id "+id);        
        String Sql = "UPDATE artista SET nombre='"+artista.getNombre()+"',generoMusical='"+artista.getGeneroMusical()+"' WHERE id="+artista.getId()+";";
        System.out.println("Sql"+Sql); 
        service.transaccionesSql(Sql);        
        FacesMessage message = new FacesMessage("Actualizo Artista " + artista.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, message);

        
    }
   
   public void eliminarArtista(Artista artista){
       System.out.println("Entro metodo eliminar");
       Artista artistas= artista; 
        String Sql = "DELETE FROM artista WHERE id" + "=" + artistas.getId() + ";";
        System.out.println("Sql delete"+Sql);
        service.transaccionesSql(Sql);    
        FacesMessage message = new FacesMessage("Se Elimino el artista: " + artistas.getNombre());        
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        
   }

    
    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

}
