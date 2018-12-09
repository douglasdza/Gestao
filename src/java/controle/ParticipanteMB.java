package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Participante;
import java.util.Objects;
import util.ChamarRelatorio;

@ManagedBean
@ViewScoped
public class ParticipanteMB {

    private Participante participante;
    private List<Participante> listaParticipantes;
    private DAOGenerico<Participante> daoParticipante;
    private String nomePalestrante="";

    public ParticipanteMB() {
        criarObjetos();
        preencherListaParticipantes();
        //        Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //        String username;
        //       
        //        username = usuarioLogado.toString();
        //        System.out.println("Loga: "+username);
    }

    private void criarObjetos() {
        participante = new Participante();
        listaParticipantes = new ArrayList<Participante>();
        daoParticipante = new DAOGenerico<Participante>(Participante.class);
    }

    private void preencherListaParticipantes() {
        listaParticipantes = daoParticipante.buscarTodos();

    }

    	public void chamarRelatorioConexao() {
		//String consulta = "SELECT *from Evento";
		HashMap param = new HashMap<>();
		param.put("PARTICIPANTE", "SDFSDFDSF");
		ChamarRelatorio.relatorioConexao("listaPalestrantes", 
				"listaPalestrantes", param);
	}
    
    
    public void remover(Long id) {
        daoParticipante.excluir(id);
        preencherListaParticipantes();
    }

    public void inserir() {
        if (participante.getId() == null) {
            daoParticipante.salvar(participante);
        } else {
            daoParticipante.alterar(participante);
        }
        preencherListaParticipantes();
        participante = new Participante();

    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public List<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public DAOGenerico<Participante> getDaoParticipante() {
        return daoParticipante;
    }

    public void setDaoParticipante(DAOGenerico<Participante> daoParticipante) {
        this.daoParticipante = daoParticipante;
    }

    public String getNomePalestrante() {
        return nomePalestrante;
    }

    public void setNomePalestrante(String nomePalestrante) {
        this.nomePalestrante = nomePalestrante;
    }
}