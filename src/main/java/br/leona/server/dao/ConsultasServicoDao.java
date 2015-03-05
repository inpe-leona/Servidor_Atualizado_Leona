package br.leona.server.dao;

import br.leona.server.model.Servico;
import java.util.List;
import org.esfinge.querybuilder.Repository;

public interface ConsultasServicoDao extends Repository<Servico> {    
    public List<Servico> getServico();    
} 