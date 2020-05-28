/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.BeansLogica;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import unicundi.edu.discotienda.Model.Conexion;

/**
 *
 * @author PIPE
 */
@Named(value = "servicioSentencia")
@RequestScoped
public class ServicioSentencia implements Serializable{

    Connection conex;

    /**
     * Creates a new instance of ServicioSentencia
     */
    public ServicioSentencia() {
       System.out.println("Entro Constructor servicioSentencia");
       try {
           System.out.println("Entro try");
            Conexion conexion = new Conexion();            
            conexion.conexionDataBase();            
            this.conex = conexion.getConex();
            System.out.println("Conexion Exitosa");
        } catch (SQLException ex) {
             System.out.println("Error init obtener conexion"+ex.getMessage());
            //Logger.getLogger(ServiceBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @PostConstruct
    public void init(){
        
         /*System.out.println("Entro PostConstructor servicioSentencia");
         try {
            Conexion conexion = new Conexion();            
            conexion.conexionDataBase();            
            this.conex = conexion.getConex();
            System.out.println("Conexion Exitosa");
        } catch (SQLException ex) {
             System.out.println("Error init obtener conexion"+ex.getMessage());
            //Logger.getLogger(ServiceBd.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
    
      public void transaccionesSql(String sql) {
        System.out.println("Entro en meto sql");
        try {
            System.out.println("Entro en meto sql");
            PreparedStatement ps = null;
            String sentencia = sql;
            ps = this.conex.prepareStatement(sentencia);
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println("Error en transaccion sql");
            Logger.getLogger(unicundi.edu.discotienda.BeansLogica.ServiceBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
