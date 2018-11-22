/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
//import jdk.management.resource.ThrottledMeter;

/**
 *
 * @author Frank
 */
@FacesValidator("validarPerfil")
public class ValidacaoPerfil implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String perfil = (String) o;
        if(!perfil.equals("COMUM") && !perfil.equals("ADMINISTRADOR")){
            FacesMessage msg = new FacesMessage("Perfil Inválido - Inserir COMUM ou ADMINISTRADOR");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
}
