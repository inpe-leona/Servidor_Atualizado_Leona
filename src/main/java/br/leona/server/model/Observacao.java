package br.leona.server.model;

import java.io.Serializable;
//import java.sql.Date;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Observacao implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //Propriedades
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String dataInicio; 
    private String dataFim;
    private String horaInicio;
    private String horaFim;
    private String estacao; 
    private String Observadores; 
    private String totalElts; 
    private String CenárioObservacao; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {        
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {        
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }
    
    public String getEstacao() {
        return estacao;
    }

    public void setEstacao(String estacao) {
        this.estacao = estacao;
    }

    public String getObservadores() {
        return Observadores;
    }

    public void setObservadores(String Observadores) {
        this.Observadores = Observadores;
    }

    public String getTotalElts() {
        return totalElts;
    }

    public void setTotalElts(String totalElts) {
        this.totalElts = totalElts;
    }

    public String getCenárioObservacao() {
        return CenárioObservacao;
    }

    public void setCenárioObservacao(String CenárioObservacao) {
        this.CenárioObservacao = CenárioObservacao;
    }
    
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observacao)) {
            return false;
        }
        Observacao other = (Observacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Observacao[ id=" + id + " ]";
    }
} 
