package br.leona.servidor.service;

import br.com.caelum.vraptor.ioc.Component;
import br.leona.server.dao.ConsultasUsuarioDao;
//import br.leona.basico.dao.DaoFactory;
//import br.leona.basico.dao.UsuarioDao;
//import br.leona.basico.model.Usuario;
import br.leona.server.model.Usuario;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.esfinge.querybuilder.QueryBuilder;

@Component
public class UsuarioService implements Serializable {

    private static final long serialVersionUID = -1917047398280846082L;
    ConsultasUsuarioDao dao = QueryBuilder.create(ConsultasUsuarioDao.class);
    
    public String cadastrar(Usuario u) throws NoSuchAlgorithmException {
        try{
            if ((u.getEmail().equals(""))||(u.getSenha().equals(""))){
             return "Campos obrigatórios em branco";
         }else{
             u.setSenha(criptografar(u.getSenha()));
             u.setStatus("Inativo");
             u.setTipo("2");
             String s = verificarString(u.getSenha());
             if(s=="ok"){
                dao.save(u);
                System.out.println("Salvou");
                return "OK";
             }else{
                 return s;
             }
         }         
        }catch(Exception e){
            System.out.println("Erro: "+e);
            return "Erro no servidor";
        }                 
    }

    private String criptografar(String senha) throws NoSuchAlgorithmException {        
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.reset();
        byte[] buffer = senha.getBytes();
        md.update(buffer);
        byte[] digest = md.digest();

        String hexStr = "";
        for (int i = 0; i < digest.length; i++) {
            hexStr += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);
        }
        return hexStr;        
    }
    
    private String verificarString(String senha) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
        String minusculas = letras.toLowerCase();
        String numeros = "0123456789";
        String temMaiuscula = "";
        String temMinuscula = "";
        String temNumero = "";
        if (senha.length() >= 8) {
            for (int j = 0; j < senha.length(); j++) {
                for (int i = 0; i < letras.length(); i++) {
                    if (senha.charAt(j) == letras.charAt(i)) {
                        temMaiuscula = "ok";
                    }
                }
                for (int k = 0; k < minusculas.length(); k++) {
                    if (senha.charAt(j) == minusculas.charAt(k)) {
                        temMinuscula = "ok";
                    }
                }
                for (int h = 0; h < numeros.length(); h++) {
                    if (senha.charAt(j) == numeros.charAt(h)) {
                        temNumero = "ok";
                    }
                }
            }
            if ((temMaiuscula == "") || (temMinuscula == "") || (temNumero == "")) {
                senha = "Deve ter minimo 1 maiuscula - 1 minuscula - 1 numero";
            } else {
                senha = "ok";
            }
        } else {
            senha = "Mínimo 8 caracteres.";
        }

        return senha;
    }

    public Usuario logar(Usuario usuario) {
        try {

            String senha = criptografar(usuario.getSenha());
            return dao.getUsuarioByEmailAndSenha(usuario.getEmail(), senha);
            
        } catch (Exception e) {
            return null;
        }
    }

    public List<Usuario> listaUsuarios() {
        System.out.println("List Service");
        return dao.list();
    }

    public Usuario retornarUsuario(Usuario usuario) {
        return dao.getById(usuario.getId());
    }

    public void editar(Usuario usuario) {
        dao.save(usuario);
    }
}
