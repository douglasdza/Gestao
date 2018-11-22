package converter;

import dao.DAOGenerico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.ArtigoSubmetido;

@FacesConverter("converterParecerFinal")
public class ConverterParecerFinal implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (id != null && !id.isEmpty()) {
            DAOGenerico<ArtigoSubmetido> dao = new DAOGenerico<ArtigoSubmetido>(ArtigoSubmetido.class);
            return dao.buscarPorId(new Long(id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null) {
            ArtigoSubmetido artigoSubmetido = (ArtigoSubmetido) o;
            return String.valueOf(artigoSubmetido.getId());
        }
        return null;
    }

}
