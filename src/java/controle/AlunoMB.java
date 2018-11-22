package controle;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import dao.DAOGenerico;
import javax.faces.bean.ViewScoped;
import modelo.Aluno;
import modelo.Estado;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class AlunoMB {

//    private Aluno aluno = new Aluno();;
    private Aluno aluno;
    private List<Aluno> listaAlunos;
    private DAOGenerico<Aluno> daoAluno;
    private Usuario usuario;
    private Estado estado;

    public AlunoMB() {
        super();
        criarObjetos();
        preencherListaAlunos();
        listaAlunos = daoAluno.buscarTodos();
    }
    
        private void criarObjetos() {
        aluno = new Aluno();
        listaAlunos = new ArrayList<Aluno>();
        daoAluno = new DAOGenerico<Aluno>(Aluno.class);
    }
        
    private void preencherListaAlunos() {
        listaAlunos = daoAluno.buscarTodos();
    }

    public void inserir() {
        if (aluno.getId() == null) {
            daoAluno.salvar(aluno);
        } else {
            daoAluno.alterar(aluno);
        }
        aluno = new Aluno();
        listaAlunos = daoAluno.buscarTodos();
    }

//    public void excluir(Aluno alu) {
//        daoAluno.excluir(alu.getId());
//        listaAlunos = daoAluno.buscarTodos();
//    }
    
    public void remover(Long id) {
        daoAluno.excluir(id);
        preencherListaAlunos();
    }


    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public DAOGenerico<Aluno> getDaoAluno() {
        return daoAluno;
    }

    public void setDaoAluno(DAOGenerico<Aluno> daoAluno) {
        this.daoAluno = daoAluno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }    
}
