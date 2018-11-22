package util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

//O objetivo desta classe é fazer a validação de nomes
//Sempre que vc precisar validar alguma informação genérica cria uma classe dessa, que é um validador
//Por exemplo, se precisar validar uma e-mail, recomendo criar uma classe dessa
//Uma classe só valida uma informação, tipo nome, email, cpf, etc
//a estrutura sempre vai ser padrão, só vai mudar a implementação do método validate
@FacesValidator("validarNome")
public class ValidarNome implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        // O valor do campo sempre vai estar na variável "o" (Object o).

        // Convertendo o Object para String:
        String nome = (String) o;

        // Criar regras para validação de Nomes
        // 1. Deve ter mais de 8 caracteres.
        // 2. Precisa de espaço para separar nomes.
        // 3. Não pode ter caracteres especiais.
        if (nome.length() < 8 || !nome.contains(" ") || nome.contains("@")) {
            // Caso não atenda as valiudações, vamos retornar uma mensagem ao usuário.
            FacesMessage msg = new FacesMessage("Nome deve ter mais de 8 caracteres e não pode conter caracteres especiais");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}