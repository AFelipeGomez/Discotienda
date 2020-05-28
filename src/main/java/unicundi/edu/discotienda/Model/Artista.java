/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.Model;

import java.io.Serializable;

/**
 *
 * @author PIPE
 */
public class Artista implements Serializable {

    private Integer id;
    private String nombre;
    private String generoMusical;

    public Artista(Integer id, String nombre, String generoMusical) {
        this.id = id;
        this.nombre = nombre;
        this.generoMusical = generoMusical;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
}
