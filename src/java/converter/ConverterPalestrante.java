package converter;

import dao.DAOGenerico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Participante;

@FacesConverter("converterPalestrante")
public class ConverterPalestrante implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id!=null && !id.isEmpty()){
            DAOGenerico<Participante> dao = new DAOGenerico<Participante>(Participante.class);
            return dao.buscarPorId(new Long (id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
     if(o!=null){
            Participante participante = (Participante) o;
            return String.valueOf(participante.getId());
        }
        return null;
    }
    
}
