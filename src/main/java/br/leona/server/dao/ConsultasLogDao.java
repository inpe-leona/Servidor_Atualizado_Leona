package br.leona.server.dao;

import br.leona.server.model.Log;
import java.util.List; 
import org.esfinge.querybuilder.Repository;

import org.esfinge.querybuilder.jpa1.JPALocalRepository; 


public interface ConsultasLogDao extends Repository<Log> {
 
    List<Log> getLog();
    
    List<Log> getLogByIdObservacao(String idObs); 
    
 } 
