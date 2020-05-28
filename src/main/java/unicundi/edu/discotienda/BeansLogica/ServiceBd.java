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
import unicundi.edu.discotienda.Model.Conexion;

/**
 *
 * @author PIPE
 */
public class ServiceBd implements Serializable {

    Connection conex;

    /**
     * Creates a new instance of ServiceBd
     */
    public ServiceBd() {
        try {
            Conexion conexion = new Conexion();
            conexion.conexionDataBase();
            this.conex = conexion.getConex();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void transaccionesSql(String sql) {
        System.out.println("Entro en meto sql");
        try {
            PreparedStatement ps = null;
            String sentencia = sql;
            ps = this.conex.prepareStatement(sentencia);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error en transaccion sql");
            Logger.getLogger(unicundi.edu.discotienda.BeansLogica.ServiceBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
