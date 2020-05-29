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

        System.out.println("Entro agregar Disco ServicioDsco");
        Disco disco = new Disco();
        disco.setIdArtista(idArtista);
        disco.setNombre(nombre);
        disco.setFechaLanzamiento(fechaLanzamiento);
        disco.setPrecio(precio);
        String sql = "INSERT INTO disco (idArtista,nombre,fechaLanzamiento,precio) VALUES('" + disco.getIdArtista() + "','" + disco.getNombre() + "','" + disco.getFechaLanzamiento() + "','" + disco.getPrecio() + "')";

        System.out.println("idArtista" + disco.getNombre());
        System.out.println("Sentencia" + sql);
        service.transaccionesSql(sql);
        System.out.println("Paso instancia servicio transaccion");
        FacesMessage message = new FacesMessage("Disco guardado");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void listarDisco() {
        System.out.println("Entro listar Disco");
        listaDisco = new ArrayList<>();

        try {

            Statement st = service.conex.createStatement();
            String sql = "SELECT disco.id,disco.idArtista,disco.nombre,disco.fechaLanzamiento,disco.precio,artista.nombre AS nombreartista"
                    + " FROM disco "
                    + "INNER JOIN artista ON disco.idArtista=artista.id;";
            System.out.println("Sql " + sql);
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                System.out.println("Entro a lista");
                listaDisco.add(new Disco(result.getInt("id"), result.getInt("idArtista"), result.getString("nombre"), result.getString("fechaLanzamiento"), result.getInt("precio"),result.getString("nombreartista")));
            }
        } catch (Exception e) {
            System.out.println("Entro excepcion metodo listar"+e.getMessage());
        }
    }
    
     public void actualizarDisco(RowEditEvent event){
       System.out.println("Entro metodo actualizacion");
       Disco disco = (Disco) event.getObject();                    
        String Sql = "UPDATE disco SET nombre='"+disco.getNombre()+"',fechaLanzamiento='"+disco.getFechaLanzamiento()+"',precio='"+disco.getPrecio()+"' WHERE id="+disco.getId()+";";
        System.out.println("Sql"+Sql); 
        service.transaccionesSql(Sql);        
        FacesMessage message = new FacesMessage("Actualizo Artista " + disco.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, message);

        
    }
     
    public void eliminarDisco(Disco disco){
       System.out.println("Entro metodo eliminar");
       Disco discos=disco;
       
        String Sql = "DELETE FROM disco WHERE id" + "=" + discos.getId() + ";";
        System.out.println("Sql delete"+Sql);
        service.transaccionesSql(Sql);    
        FacesMessage message = new FacesMessage("Se Elimino el disco: " + discos.getNombre());        
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        
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
