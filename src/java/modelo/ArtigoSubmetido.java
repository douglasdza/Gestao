package modelo;

import java.io.Serializable;
import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final ArtigoSubmetido other = (ArtigoSubmetido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
