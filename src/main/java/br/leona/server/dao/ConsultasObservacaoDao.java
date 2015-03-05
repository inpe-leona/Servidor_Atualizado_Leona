package br.leona.server.dao;

import br.leona.server.model.Observacao;
import java.util.List; 
import org.esfinge.querybuilder.Repository;

import org.esfinge.querybuilder.jpa1.JPALocalRepository; 


public interface ConsultasObservacaoDao extends Repository<Observacao> {
 
    List<Observacao> getObservacao();
    
    List<Observacao> getObservacaoByDataHoraInicio(String dataHoraInicio); 

    List<Observacao> getObservacaoByDataHoraFim(String dataHoraFim); 

    List<Observacao> getObservacaoByEstacoes(String Estacoes); 

    List<Observacao> getObservacaoByObservadores(String Observadores); 

    List<Observacao> getObservacaoByTotalElts(String totalElts); 

    List<Observacao> getObservacaoByCenarioObservacao(String CenárioObservacao); 
 } 
