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

    private Connection conex;
    private String url;
    private String usuario;
    private String calve;

    public Conexion() {
        this.url = "jdbc:mysql://localhost:8080/discotienda?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.usuario = "root";
        this.calve = "";
        this.conex = null;

    }

    public void conexionDataBase() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conex = DriverManager.getConnection(url, usuario, calve);
            } catch (SQLException ex) {
                System.out.println("Error Conexion" + ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro Class" + ex.getMessage());
        }

    }

    public Conexion(Connection conexion) {

        this.conex = conexion;
    }

    public Connection getConex() {
        return conex;
    }

    public void setConex(Connection conex) {
        this.conex = conex;
    }
    
}
