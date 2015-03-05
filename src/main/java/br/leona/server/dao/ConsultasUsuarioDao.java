package br.leona.server.dao;

import br.leona.server.model.Usuario;
import java.util.List; 
import org.esfinge.querybuilder.Repository;

public interface ConsultasUsuarioDao extends Repository<Usuario>{

    List<Usuario> getUsuarioByNome(String nome);
    Usuario getUsuarioByEmailAndSenha(String email, String senha);
    Usuario getUsuarioByEmail(String email);   
    Usuario getUsuarioByEmailAndSenhaAndStatus(String email, String senha, String status);
} 