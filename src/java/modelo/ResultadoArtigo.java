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
@Table(name="resultado_artigo")
public class ResultadoArtigo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String resultadoArtigo;
    
    @ManyToOne
    private SubmeterArtigo submeterArtigo;
    
    @ManyToOne
    private ArtigoSubmetido artigoSubmetido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResultadoArtigo() {
        return resultadoArtigo;
    }

    public void setResultadoArtigo(String resultadoArtigo) {
        this.resultadoArtigo = resultadoArtigo;
    }

    public SubmeterArtigo getSubmeterArtigo() {
        return submeterArtigo;
    }

    public void setSubmeterArtigo(SubmeterArtigo submeterArtigo) {
        this.submeterArtigo = submeterArtigo;
    }

    public ArtigoSubmetido getArtigoSubmetido() {
        return artigoSubmetido;
    }

    public void setArtigoSubmetido(ArtigoSubmetido artigoSubmetido) {
        this.artigoSubmetido = artigoSubmetido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final ResultadoArtigo other = (ResultadoArtigo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
