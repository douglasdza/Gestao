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
@Table(name="sub_evento")
public class SubEvento implements Serializable{
    
    private static final long serialVersionUID = 1L;    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;    
    private String nomeSubEvento;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataSubEvento;
        
    @ManyToOne
    private Evento evento;
    
    @ManyToOne
    private Participante participante;
    
    private String cargaHoraria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSubEvento() {
        return nomeSubEvento;
    }

    public void setNomeSubEvento(String nomeSubEvento) {
        this.nomeSubEvento = nomeSubEvento;
    }

    public Date getDataSubEvento() {
        return dataSubEvento;
    }

    public void setDataSubEvento(Date dataSubEvento) {
        this.dataSubEvento = dataSubEvento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final SubEvento other = (SubEvento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }    
}
