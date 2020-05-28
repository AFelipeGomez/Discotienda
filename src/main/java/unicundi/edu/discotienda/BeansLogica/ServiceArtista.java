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
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import unicundi.edu.discotienda.Model.Artista;
import unicundi.edu.discotienda.Model.Conexion;

/**
 *
 * @author PIPE
 */
@Named(value = "formularioArtista")
@ViewScoped
public class ServiceArtista implements Serializable {

    
    Conexion conex = new Conexion();
    Artista artista;

    /**
     * Creates a new instance of FormularioArtista
     */
    public void agregarArtista(String nombre, String generoMusical) {
        try {
            artista = new Artista(1,nombre, generoMusical);

            PreparedStatement ps = null;
            Connection conexion = conex.getConex();
            String sql = "INSERT INTO artista (nombre,generoMusical) VALUES(?,?)";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, artista.getNombre());
            ps.setString(2, artista.getGeneroMusical());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceArtista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
