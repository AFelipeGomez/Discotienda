/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicundi.edu.discotienda.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Usuario
 */
@Named(value = "validacionPersonalizada")
@RequestScoped
public class ValidacionPersonalizada {

    private String nombre;
    private Integer numero;

    /**
     * Creates a new instance of ValidacionPersonalizada
     */
    public ValidacionPersonalizada() {
    }

    public void validarLongitud(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        String texto = (String) arg2;
        if (texto.length() < 3) {
            throw new ValidatorException(new FacesMessage("Al menos debe tener 3 caracteres."));
        }

    }

    public void validarNumeroNegativo(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        Integer n = (Integer) arg2;
        if (n < 0) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se permiten valores negativos"));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
