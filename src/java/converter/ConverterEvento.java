package converter;

import dao.DAOGenerico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Evento;

@FacesConverter("converterEvento")
public class ConverterEvento implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id!=null && !id.isEmpty()) {
            DAOGenerico<Evento> dao = new DAOGenerico<Evento>(Evento.class);
            return dao.buscarPorId(new Long (id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o!=null){
            Evento evento = (Evento) o;
            return String.valueOf(evento.getId());
        }
        return null;
    }
}
