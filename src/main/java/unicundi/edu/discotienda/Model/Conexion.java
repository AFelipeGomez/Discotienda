/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PIPE
 */
public class Conexion {

    Connection conex;

    public Conexion() {
        System.out.println("Entro Constructor Conexion");
    }

    public void conexionDataBase() throws SQLException {
         System.out.println("Entro metodoConexionBase");
        try {
            String url = "jdbc:mysql://localhost:3306/discotienda";
            String usuario = "root";
            String clave = "";
             System.out.println("Antes de Driver");            
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Despues de Driver");            
            this.conex = DriverManager.getConnection(url, "root", "");            
            System.out.println("Conexion Establecida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en conexion");
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       

    }

   

    public Connection getConex() {
        return conex;
    }

   
    
}
