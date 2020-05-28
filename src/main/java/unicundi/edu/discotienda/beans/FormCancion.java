/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author PIPE
 */
@Named(value = "formCancion")
@ViewScoped
public class FormCancion implements Serializable {

    @Inject
    private FormArtista seervice;
    /**
     * Creates a new instance of FormCancion
     */
    public FormCancion() {
    }
    
}
