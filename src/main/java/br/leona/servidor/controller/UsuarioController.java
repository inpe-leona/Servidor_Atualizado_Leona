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
    @Path("/logarUsuario")
    public void logarUsuario(Usuario usuario){
        /*Usuario u = usuService.logar(usuario);
        if (u==null){
            JOptionPane.showMessageDialog(null, "Usuário não encontrado");
        }else{
            if (u.getStatus().equals("Inativo")){
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");    
            }else{
                if (u.getTipo().equals("1")){*/
                    indexController.paginaMenuAdm(usuario);
               /* }else{
                    indexController.paginaMenu(usuario);
                }
            }
        }*/
    }

    public List<Usuario> listaUsuarios() {
        System.out.println("List Controller");
        return usuService.listaUsuarios();
    }
    
    @Post
    @Path("/alterarStatusUsuario")
    public void alterarStatusUsuario(Usuario usuario){
        usuario = usuService.retornarUsuario(usuario);
        if (usuario.getStatus().equals("Ativo")) {
            usuario.setStatus("Inativo");
        } else {
            usuario.setStatus("Ativo");
        }
        usuService.editar(usuario);
        //serviceUser.enviarEmailComSenha(usuario.getEmail(), "Cadastro Ativado", " Olá "+usuario.getNome()+"\n Estamos entrando em contato para informá-lo que seu cadastro na Rede LEONA já está ativado. \n\n Obrigado!!");                        
        indexController.paginaListagemUsuario();
    }
}
