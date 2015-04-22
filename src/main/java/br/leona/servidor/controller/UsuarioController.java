package br.leona.servidor.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.leona.server.model.Usuario;
import br.leona.servidor.service.UsuarioService;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.swing.JOptionPane;

@Resource
public class UsuarioController {
    
    private UsuarioService usuService;
    private IndexController indexController;
    private Result r;
    
    public UsuarioController(Result r){
        this.usuService = new UsuarioService();
        this.indexController = new IndexController(r);
    }
    
    @Post
    @Path("/cadastrarUsuario")
    public void cadastrarUsuario(Usuario usuario) throws NoSuchAlgorithmException{        
        String resposta = usuService.cadastrar(usuario);        
        if (resposta == "OK"){
            indexController.paginaCadastroUsuarioSucesso();
        }else{
            JOptionPane.showMessageDialog(null, resposta);
            indexController.paginaCadastroUsuario(usuario);
        }  
    }
    @Post
    @Path("/enviaremailsenha")
    public void paginaLembrarSenha(Usuario usuario){
        usuService.lembrarSenha(usuario.getEmail());
        indexController.paginaLembrarSenha();        
    }
    @Post
    @Path("/logarUsuario")
    public void logarUsuario(Usuario usuario){
        if ((usuario.getEmail()==null)||(usuario.getSenha()==null)){
            indexController.paginaLogin2();
        }else{
            Usuario u = usuService.logar(usuario);
            if (u==null){
                    indexController.paginaLogin2();
            }else{
                if (u.getStatus().equals("Inativo")){  
                    indexController.paginaLogin2(); 
                }else{
                    System.out.println("oi: "+u.getTipo());
                    if (u.getTipo().equals("Administrador")){
                        indexController.paginaMenuAdm(usuario);
                    }else{
                        indexController.paginaMenu(usuario);
                    }
                }
            }
        }
    }

    public List<Usuario> listaUsuarios() {
        List<Usuario> listU = usuService.listaUsuarios();
        for(int i=0;i<listU.size();i++){
            if (listU.get(i).getTipo().equals("Administrador")){
                listU.get(i).setTipo("Administrador");
            }else if(listU.get(i).getTipo().equals("Comum")){
                listU.get(i).setTipo("Comum");
            }else{
                listU.get(i).setTipo("Observador");
            }
            
        }
        return listU;
    }
    
    @Post
    @Path("/alterarTipoUsuario")
    public void alterarTipoUsuario(Usuario usuario){
        System.out.println(usuario.getTipo());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getStatus());
        
        usuario = usuService.retornarUsuario(usuario);
        System.out.println(usuario.getTipo());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getStatus());
        if (usuario.getTipo().equals("Comum")) {
            usuario.setTipo("Observador");
        } else {
            usuario.setTipo("Comum");
        }
        usuService.editar(usuario);
        indexController.paginaListagemUsuario();
    }
    @Post
    @Path("/alterarStatusUsuario")
    public void alterarStatusUsuario(Usuario usuario){
        System.out.println(usuario.getTipo());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getStatus());
        
        usuario = usuService.retornarUsuario(usuario);
        System.out.println(usuario.getTipo());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getStatus());
        if (usuario.getStatus().equals("Ativo")) {
            usuario.setStatus("Inativo");
        } else {
            usuario.setStatus("Ativo");
        }
        usuService.editar(usuario);
        indexController.paginaListagemUsuario();
    }
}
