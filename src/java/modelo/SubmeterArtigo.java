package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="submeter_artigo")
public class SubmeterArtigo implements Serializable{
    
    private static final long serialVersionUID = 1L;    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String tituloArtigo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtArtigoSubmetido;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date anoArtigoPublicado;
    
    private String autor;    
    private String orientador;
    private String resumoArtigo;
    private String artigoAvaliado;
    private String artigoFinal;
    private String codigoCNPQ;
    private String coautor;
    private String linkDrive;
    
    private String rejeitarArtigo;
    private String aprovarArtigo;
    private String aprovarArtigoRessalva;
    
    @ManyToOne
    private Curso curso;
    
    @ManyToOne
    private ArtigoSubmetido artigoSubmetido;
    
    @ManyToOne
    private Evento evento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloArtigo() {
        return tituloArtigo;
    }

    public void setTituloArtigo(String tituloArtigo) {
        this.tituloArtigo = tituloArtigo;
    }

    public Date getDtArtigoSubmetido() {
        return dtArtigoSubmetido;
    }

    public void setDtArtigoSubmetido(Date dtArtigoSubmetido) {
        this.dtArtigoSubmetido = dtArtigoSubmetido;
    }

    public Date getAnoArtigoPublicado() {
        return anoArtigoPublicado;
    }

    public void setAnoArtigoPublicado(Date anoArtigoPublicado) {
        this.anoArtigoPublicado = anoArtigoPublicado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getResumoArtigo() {
        return resumoArtigo;
    }

    public void setResumoArtigo(String resumoArtigo) {
        this.resumoArtigo = resumoArtigo;
    }

    public String getArtigoAvaliado() {
        return artigoAvaliado;
    }

    public void setArtigoAvaliado(String artigoAvaliado) {
        this.artigoAvaliado = artigoAvaliado;
    }

    public String getArtigoFinal() {
        return artigoFinal;
    }

    public void setArtigoFinal(String artigoFinal) {
        this.artigoFinal = artigoFinal;
    }

    public String getCodigoCNPQ() {
        return codigoCNPQ;
    }

    public void setCodigoCNPQ(String codigoCNPQ) {
        this.codigoCNPQ = codigoCNPQ;
    }

    public String getCoautor() {
        return coautor;
    }

    public void setCoautor(String coautor) {
        this.coautor = coautor;
    }

    public String getLinkDrive() {
        return linkDrive;
    }

    public void setLinkDrive(String linkDrive) {
        this.linkDrive = linkDrive;
    }

    public String getRejeitarArtigo() {
        return rejeitarArtigo;
    }

    public void setRejeitarArtigo(String rejeitarArtigo) {
        this.rejeitarArtigo = rejeitarArtigo;
    }

    public String getAprovarArtigo() {
        return aprovarArtigo;
    }

    public void setAprovarArtigo(String aprovarArtigo) {
        this.aprovarArtigo = aprovarArtigo;
    }

    public String getAprovarArtigoRessalva() {
        return aprovarArtigoRessalva;
    }

    public void setAprovarArtigoRessalva(String aprovarArtigoRessalva) {
        this.aprovarArtigoRessalva = aprovarArtigoRessalva;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ArtigoSubmetido getArtigoSubmetido() {
        return artigoSubmetido;
    }

    public void setArtigoSubmetido(ArtigoSubmetido artigoSubmetido) {
        this.artigoSubmetido = artigoSubmetido;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SubmeterArtigo other = (SubmeterArtigo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}