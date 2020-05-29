/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.BeansLogica;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import unicundi.edu.discotienda.Model.Cancion;
import unicundi.edu.discotienda.Model.Disco;

/**
 *
 * @author PIPE
 */
@Named(value = "servicioCancion")
@RequestScoped
public class ServicioCancion {
    
    List<Cancion> listCancion;

    @Inject
    private ServicioSentencia service;

    /**
     * Creates a new instance of ServicioCancion
     */
    public ServicioCancion() {
    }

    public void agregarCancion(Integer idDisco, String nombre, String duracion, String formato, Integer precio) {
        System.out.println("Entro agregar Disco ServicioDsco");
        Cancion cancion = new Cancion();
        cancion.setIdDisco(idDisco);
        cancion.setNombre(nombre);
        cancion.setDuracion(duracion);
        cancion.setFormato(formato);
        cancion.setPrecio(precio);
        String sql = "INSERT INTO cancion (id_disco,nombre,duracion,formato,precio)"
                + " VALUES('" + cancion.getIdDisco() + "','" + cancion.getNombre() + "','" + cancion.getDuracion() + "','" + cancion.getFormato() + "','" + cancion.getPrecio() + "')";

        System.out.println("Sentencia" + sql);
        service.transaccionesSql(sql);
        System.out.println("Paso instancia servicio transaccion");
        FacesMessage message = new FacesMessage("Cancion Guardada");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void listarCancion() {
        System.out.println("Entro listar Disco");
        listCancion = new ArrayList<>();

        try {

            Statement st = service.conex.createStatement();
            String sql = "SELECT cancion.id, cancion.id_disco,cancion.nombre,cancion.duracion,cancion.formato,cancion.precio,disco.nombre AS nombreadisco"
                    + " FROM cancion INNER JOIN disco ON cancion.id_disco=disco.id";
                    
            System.out.println("Sql " + sql);
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                System.out.println("Entro a lista");
                listCancion.add(new Cancion(result.getInt("id"), result.getInt("id_disco"), result.getString("nombre"), result.getString("duracion"), result.getString("formato"),result.getInt("precio"), result.getString("nombreadisco")));
            }
        } catch (Exception e) {
            System.out.println("Entro excepcion metodo listar" + e.getMessage());
        }

    }

    public void actualizarCancion(RowEditEvent event) {
         System.out.println("Entro metodo actualizacion");
       Cancion cancion= (Cancion) event.getObject();                    
        String Sql = "UPDATE cancion SET nombre='"+cancion.getNombre()+"',duracion='"+cancion.getDuracion()+"',precio='"+cancion.getPrecio()+"' WHERE id="+cancion.getId()+";";
        System.out.println("Sql"+Sql); 
        service.transaccionesSql(Sql);        
        FacesMessage message = new FacesMessage("Actualizo Cancion" + cancion.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, message);


    }

    public void eliminarCancion(Cancion cancion) {
         System.out.println("Entro metodo eliminar");
       Cancion canciones=cancion;
       
        String Sql = "DELETE FROM cancion WHERE id" + "=" + canciones.getId() + ";";
        System.out.println("Sql delete"+Sql);
        service.transaccionesSql(Sql);    
        FacesMessage message = new FacesMessage("Se Elimino la Cancion: " + canciones.getNombre());        
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Cancion> getListCancion() {
        return listCancion;
    }

    public void setListCancion(List<Cancion> listCancion) {
        this.listCancion = listCancion;
    }

}
