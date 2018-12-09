package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="artigo_submetido")
public class ArtigoSubmetido implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String artigoSubmetidoAvaliado;
    private String artigoSubmetidoAprovar;
    private String artigoSubmetidoAprovarRessalva;
    private String artigoSubmetidoRejeitar;  
    private String justificativa;
    
    @ManyToOne
    private SubmeterArtigo submeterArtigo;
    
    @ManyToOne
    private Evento evento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtigoSubmetidoAvaliado() {
        return artigoSubmetidoAvaliado;
    }

    public void setArtigoSubmetidoAvaliado(String artigoSubmetidoAvaliado) {
        this.artigoSubmetidoAvaliado = artigoSubmetidoAvaliado;
    }

    public String getArtigoSubmetidoAprovar() {
        return artigoSubmetidoAprovar;
    }

    public void setArtigoSubmetidoAprovar(String artigoSubmetidoAprovar) {
        this.artigoSubmetidoAprovar = artigoSubmetidoAprovar;
    }

    public String getArtigoSubmetidoAprovarRessalva() {
        return artigoSubmetidoAprovarRessalva;
    }

    public void setArtigoSubmetidoAprovarRessalva(String artigoSubmetidoAprovarRessalva) {
        this.artigoSubmetidoAprovarRessalva = artigoSubmetidoAprovarRessalva;
    }

    public String getArtigoSubmetidoRejeitar() {
        return artigoSubmetidoRejeitar;
    }

    public void setArtigoSubmetidoRejeitar(String artigoSubmetidoRejeitar) {
        this.artigoSubmetidoRejeitar = artigoSubmetidoRejeitar;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
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
