/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.leona.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Nicolas Leona
 */
@Entity
public class Log implements Serializable {  
    private static final long serialVersionUID = 1L;

    //Propriedades
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     Long id;
    private String idObservacao;
    private String nomeObservacao;
    private String acao;
    private String usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdObservacao() {
        return idObservacao;
    }

    public void setIdObservacao(String idObservacao) {
        this.idObservacao = idObservacao;
    }

    public String getNomeObservacao() {
        return nomeObservacao;
    }

    public void setNomeObservacao(String nomeObservacao) {
        this.nomeObservacao = nomeObservacao;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof Estacao)) {
            return false;
        }
        Estacao other = (Estacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.leona.server.model.Log[ id=" + id + " ]";
    }
}
