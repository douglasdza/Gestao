package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ResultadoArtigo;

@ManagedBean
@ViewScoped
public class ResultadoArtigoMB {
    
    private ResultadoArtigo resultadoartigo;
    private List<ResultadoArtigo> listaResultadoArtigos;
    private DAOGenerico<ResultadoArtigo> daoResultadoArtigo;
    private SubmeterArtigoMB submeterArtigoMB;
    private ArtigoSubmetidoMB artigoSubmetidoMB;
    
    public ResultadoArtigoMB(){
        criarObjetos();
        preencherListaResultadoArtigo();
    }
    
    private void criarObjetos(){
        resultadoartigo = new ResultadoArtigo();
        listaResultadoArtigos = new ArrayList<ResultadoArtigo>();
        daoResultadoArtigo = new DAOGenerico<ResultadoArtigo>(ResultadoArtigo.class);
    }
    
    public void preencherListaResultadoArtigo(){
        listaResultadoArtigos = daoResultadoArtigo.buscarTodos();
    }
    
    public void remover(Long id){
        daoResultadoArtigo.excluir(id);
        preencherListaResultadoArtigo();
    }
    
    public void inserir(){
        if (resultadoartigo.getId() == null) {
            daoResultadoArtigo.salvar(resultadoartigo);            
        } else {
            daoResultadoArtigo.alterar(resultadoartigo);
        }
        preencherListaResultadoArtigo();
        resultadoartigo = new ResultadoArtigo();
    }

    public ResultadoArtigo getResultadoartigo() {
        return resultadoartigo;
    }

    public void setResultadoartigo(ResultadoArtigo resultadoartigo) {
        this.resultadoartigo = resultadoartigo;
    }

    public List<ResultadoArtigo> getListaResultadoArtigos() {
        return listaResultadoArtigos;
    }

    public void setListaResultadoArtigos(List<ResultadoArtigo> listaResultadoArtigos) {
        this.listaResultadoArtigos = listaResultadoArtigos;
    }

    public DAOGenerico<ResultadoArtigo> getDaoResultadoArtigo() {
        return daoResultadoArtigo;
    }

    public void setDaoResultadoArtigo(DAOGenerico<ResultadoArtigo> daoResultadoArtigo) {
        this.daoResultadoArtigo = daoResultadoArtigo;
    }

    public SubmeterArtigoMB getSubmeterArtigoMB() {
        return submeterArtigoMB;
    }

    public void setSubmeterArtigoMB(SubmeterArtigoMB submeterArtigoMB) {
        this.submeterArtigoMB = submeterArtigoMB;
    }

    public ArtigoSubmetidoMB getArtigoSubmetidoMB() {
        return artigoSubmetidoMB;
    }

    public void setArtigoSubmetidoMB(ArtigoSubmetidoMB artigoSubmetidoMB) {
        this.artigoSubmetidoMB = artigoSubmetidoMB;
    }
}
