package converter;

import dao.DAOGenerico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Curso;

@FacesConverter("converterCurso")
public class ConverterCurso implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id!=null && !id.isEmpty()){
            DAOGenerico<Curso> dao = new DAOGenerico<Curso>(Curso.class);
            return dao.buscarPorId(new Long (id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o!=null){
            Curso curso = (Curso) o;
            return String.valueOf(curso.getId());
        }
        return null;
    }    
}
