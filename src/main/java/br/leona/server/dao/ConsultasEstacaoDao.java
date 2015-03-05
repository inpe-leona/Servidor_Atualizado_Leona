package br.leona.server.dao;

import br.leona.server.model.Estacao;
import java.util.List;
import org.esfinge.querybuilder.Repository;

public interface ConsultasEstacaoDao extends Repository<Estacao> {
    
    public Estacao getEstacaoByNome(String nome);
    public List<Estacao> getEstacaoByCidade(String cidade);
    public Estacao getEstacaoByIp(String ip);
    
} 