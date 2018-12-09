package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ArtigoSubmetido;
import modelo.Evento;
import modelo.SubmeterArtigo;

@ManagedBean
@ViewScoped
public class ArtigoSubmetidoMB {
 
    private ArtigoSubmetido artigoSubmetido;
    private List<ArtigoSubmetido> listaArtigoSubmetido;
    private DAOGenerico<ArtigoSubmetido> daoArtigoSubmetido;
    private SubmeterArtigo submeterArtigo;
    private Evento evento;
    
    public ArtigoSubmetidoMB(){
        criarObjetos();
        preencherListaArtigoSubmetido();
    }
    
    private void criarObjetos(){
        artigoSubmetido = new ArtigoSubmetido();
        listaArtigoSubmetido = new ArrayList<ArtigoSubmetido>();
        daoArtigoSubmetido = new DAOGenerico<ArtigoSubmetido>(ArtigoSubmetido.class);
    }
    
    private void preencherListaArtigoSubmetido(){
        listaArtigoSubmetido = daoArtigoSubmetido.buscarTodos();
    }
    
    public void remover(Long id) {
        daoArtigoSubmetido.excluir(id);
        preencherListaArtigoSubmetido();
    }
    
     public void inserir() {
        if (artigoSubmetido.getId() == null) {
            daoArtigoSubmetido.salvar(artigoSubmetido);
        } else {
            daoArtigoSubmetido.alterar(artigoSubmetido);
        }
        preencherListaArtigoSubmetido();
        artigoSubmetido = new ArtigoSubmetido();
    }

    public ArtigoSubmetido getArtigoSubmetido() {
        return artigoSubmetido;
    }

    public void setArtigoSubmetido(ArtigoSubmetido artigoSubmetido) {
        this.artigoSubmetido = artigoSubmetido;
    }

    public List<ArtigoSubmetido> getListaArtigoSubmetido() {
        return listaArtigoSubmetido;
    }

    public void setListaArtigoSubmetido(List<ArtigoSubmetido> listaArtigoSubmetido) {
        this.listaArtigoSubmetido = listaArtigoSubmetido;
    }

    public DAOGenerico<ArtigoSubmetido> getDaoArtigoSubmetido() {
        return daoArtigoSubmetido;
    }

    public void setDaoArtigoSubmetido(DAOGenerico<ArtigoSubmetido> daoArtigoSubmetido) {
        this.daoArtigoSubmetido = daoArtigoSubmetido;
    }

    public SubmeterArtigo getSubmeterArtigo() {
        return submeterArtigo;
    }

    public void setSubmeterArtigo(SubmeterArtigo submeterArtigo) {
        this.submeterArtigo = submeterArtigo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
