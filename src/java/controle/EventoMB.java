package controle;

//Classe mais importante
import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Curso;
import modelo.Participante;
import modelo.Evento;
import util.ChamarRelatorio;

@ManagedBean
@ViewScoped
public class EventoMB {
    
    private Evento evento;
    private List<Evento> listaEventos;
    private DAOGenerico<Evento> daoEvento;
    private Curso curso;
    private Participante participante;
    private String nomeEvento="";
    
    public EventoMB(){
        criarObjetos();
        preencherListaEventos();        
    }
    
    private void criarObjetos(){
        evento = new Evento();
        listaEventos = new ArrayList<Evento>();
        daoEvento = new DAOGenerico<Evento>(Evento.class);
    }
    
    private void preencherListaEventos(){
        listaEventos = daoEvento.buscarTodos();
    }
    
	
	public void chamarRelatorioConexao() {
		//String consulta = "SELECT *from Evento";
		HashMap param = new HashMap<>();
		param.put("EVENTO", "SDFSDFDSF");
		ChamarRelatorio.relatorioConexao("listaEventos", 
				"listaEventos", param);
	}
    
    
    public void remover(Long id){
        daoEvento.excluir(id);
        preencherListaEventos();
    }
    
    public void inserir() {
        if (evento.getId() == null) {
            daoEvento.salvar(evento);
        } else {
            daoEvento.alterar(evento);
        }
        preencherListaEventos();
        evento = new Evento();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }

    public DAOGenerico<Evento> getDaoEvento() {
        return daoEvento;
    }

    public void setDaoEvento(DAOGenerico<Evento> daoEvento) {
        this.daoEvento = daoEvento;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }
}
