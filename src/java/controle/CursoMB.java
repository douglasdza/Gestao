package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Curso;

@ManagedBean
@ViewScoped
public class CursoMB {
    
    private Curso curso;
    private List<Curso> listaCursos;
    private DAOGenerico<Curso> daoCurso;
    
    public CursoMB(){
        criarObjetos();
        preencherListaCursos();        
    }
    
    private void criarObjetos(){
        curso = new Curso();
        listaCursos = new ArrayList<Curso>();
        daoCurso = new DAOGenerico<Curso>(Curso.class);
    }
    
    private void preencherListaCursos(){
        listaCursos = daoCurso.buscarTodos();
    }
    
    public void remover(Long id){
        daoCurso.excluir(id);
        preencherListaCursos();
    }
    
    public void inserir() {
        if (curso.getId() == null) {
            daoCurso.salvar(curso);
        } else {
            daoCurso.alterar(curso);
        }
        preencherListaCursos();
        curso = new Curso();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public DAOGenerico<Curso> getDaoCurso() {
        return daoCurso;
    }

    public void setDaoCurso(DAOGenerico<Curso> daoCurso) {
        this.daoCurso = daoCurso;
    }
}