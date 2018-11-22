package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Evento;
import modelo.Participante;
import modelo.SubEvento;

@ManagedBean
@ViewScoped
public class SubEventoMB {
    
    private SubEvento subevento;
    private List<SubEvento> listaSubEventos;
    private DAOGenerico<SubEvento> daoSubEvento;
    private Evento evento;
    private Participante participante;
    
    public SubEventoMB(){
        criarObjetos();
        preencherListaSubEventos();
    }
    
    private void criarObjetos(){
        subevento = new SubEvento();
        listaSubEventos = new ArrayList<SubEvento>();
        daoSubEvento = new DAOGenerico<SubEvento>(SubEvento.class);
    }
    
    private void preencherListaSubEventos(){
        listaSubEventos = daoSubEvento.buscarTodos();
    }
    
    public void remover(Long id){
        daoSubEvento.excluir(id);
        preencherListaSubEventos();
    }
    
    public void inserir() {
        if (subevento.getId() == null) {
            daoSubEvento.salvar(subevento);
        } else {
            daoSubEvento.alterar(subevento);
        }
        preencherListaSubEventos();
        evento = new Evento();
    }

    public SubEvento getSubevento() {
        return subevento;
    }

    public void setSubevento(SubEvento subevento) {
        this.subevento = subevento;
    }

    public List<SubEvento> getListaSubEventos() {
        return listaSubEventos;
    }

    public void setListaSubEventos(List<SubEvento> listaSubEventos) {
        this.listaSubEventos = listaSubEventos;
    }

    public DAOGenerico<SubEvento> getDaoSubEvento() {
        return daoSubEvento;
    }

    public void setDaoSubEvento(DAOGenerico<SubEvento> daoSubEvento) {
        this.daoSubEvento = daoSubEvento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }    
}
