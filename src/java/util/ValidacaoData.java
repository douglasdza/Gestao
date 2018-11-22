package util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validarData")
public class ValidacaoData implements Validator{
    ValidacaoData calendario = new ValidacaoData();

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
