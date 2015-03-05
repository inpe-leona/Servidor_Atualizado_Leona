package br.leona.server.dao;

import br.leona.server.model.Usuario;
import java.io.Serializable;
import java.util.List;
import org.esfinge.querybuilder.QueryBuilder;

public class DaoFactory{
    
    public static ConsultasUsuarioDao createConsultasUsuario(){
        ConsultasUsuarioDao dao = QueryBuilder.create(ConsultasUsuarioDao.class);
        return dao;
    }
    
    //ConsultasUsuarioDao cud = QueryBuilder.create(ConsultasUsuarioDao.class);
    private ConsultasUsuarioDao cud;
    private ConsultasEstacaoDao ced;
    
    public DaoFactory(){
        this.cud = QueryBuilder.create(ConsultasUsuarioDao.class);
    }
    
    public List<Usuario> getUsuarioByNome(String nome){
        return cud.getUsuarioByNome(nome);
    }
    
    public Usuario getUsuarioByEmailAndSenha(String email, String senha){
        return cud.getUsuarioByEmailAndSenha(email, senha);
    }
    
    public Usuario getUsuarioByEmail(String email){
        return cud.getUsuarioByEmail(email);
    }
    
    public Usuario getById(Long id){
        return cud.getById(id);
    }
    
    public List<Usuario> list(){
        return cud.list();
    }
    
    public Usuario save(Usuario u){
        return cud.save(u);
    }
    
    public void delete(Usuario usuario){
        cud.delete(usuario.getId());
    }
    
}
