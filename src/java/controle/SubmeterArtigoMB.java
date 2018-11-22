package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.SubmeterArtigo;

@ManagedBean
@ViewScoped
public class SubmeterArtigoMB {

    private SubmeterArtigo submeterartigo;
    private List<SubmeterArtigo> listaArtigos;
    private DAOGenerico<SubmeterArtigo> daoSubmeterArtigo;
    private ArtigoSubmetidoMB artigosubmetido;

    public SubmeterArtigoMB() {
        criarObjetos();
        preencherListaArtigos();
    }

    private void criarObjetos() {
        submeterartigo = new SubmeterArtigo();
        listaArtigos = new ArrayList<SubmeterArtigo>();
        daoSubmeterArtigo = new DAOGenerico<SubmeterArtigo>(SubmeterArtigo.class);
    }

    private void preencherListaArtigos() {
        listaArtigos = daoSubmeterArtigo.buscarTodos();
    }

    public void remover(Long id) {
        daoSubmeterArtigo.excluir(id);
        preencherListaArtigos();
    }

    public void inserir() {
        //temos que transformar aquilo em um link
        if(submeterartigo.getLinkDrive()!=null){
            String link = "<a target=\"_blank\" href=\""+
                        submeterartigo.getLinkDrive() +"\">Acessar o artigo</a>";
            submeterartigo.setLinkDrive(link);
        }
        if (submeterartigo.getId() == null) {
            daoSubmeterArtigo.salvar(submeterartigo);
        } else {
            daoSubmeterArtigo.alterar(submeterartigo);
        }
        preencherListaArtigos();
        submeterartigo = new SubmeterArtigo();
    }

    public SubmeterArtigo getSubmeterartigo() {
        return submeterartigo;
    }

    public void setSubmeterartigo(SubmeterArtigo submeterartigo) {
        this.submeterartigo = submeterartigo;
    }

    public List<SubmeterArtigo> getListaArtigos() {
        return listaArtigos;
    }

    public void setListaArtigos(List<SubmeterArtigo> listaArtigos) {
        this.listaArtigos = listaArtigos;
    }

    public DAOGenerico<SubmeterArtigo> getDaoSubmeterArtigo() {
        return daoSubmeterArtigo;
    }

    public void setDaoSubmeterArtigo(DAOGenerico<SubmeterArtigo> daoSubmeterArtigo) {
        this.daoSubmeterArtigo = daoSubmeterArtigo;
    }

    public ArtigoSubmetidoMB getArtigoSubmetidoMB() {
        return artigosubmetido;
    }

    public void setArtigoSubmetidoMB(ArtigoSubmetidoMB artigoSubmetidoMB) {
        this.artigosubmetido = artigoSubmetidoMB;
    }
}
