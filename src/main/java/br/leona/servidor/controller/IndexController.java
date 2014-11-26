package br.leona.servidor.controller;
    
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.leona.server.model.Estacao;
import br.leona.server.model.Observacao;
import br.leona.server.model.Usuario;
import java.util.List;
//import br.leona.basico.model.Usuario;

@Resource
public class IndexController {
    
    private Result result;
    
    public IndexController(Result r){
        this.result = r;
    }
    
    //region Index
    @Path("/")
    public void index(){}
    
    @Path("/contato")
    public void paginaContato(){
        result.forwardTo(RedirecionarPaginasController.CONTATO);
    }
    
    @Path("/login")
    public void paginaLogin(){
        result.forwardTo(RedirecionarPaginasController.LOGIN);
    }
    
    @Path("/lembrarsenha")
    public void paginaLembrarSenha(){
        result.forwardTo(RedirecionarPaginasController.LEMBRARSENHA);
    }
    //endregion
    
    //region Usuário    
    @Path("/cadastroUsuario")
    public void paginaCadastroUsuario(Usuario usuario){
        result.forwardTo(RedirecionarPaginasController.CADASTRO_USUARIO);
    }     

    public void paginaCadastroUsuarioSucesso() {
        result.forwardTo(RedirecionarPaginasController.CADASTRO_USUARIO_SUCESSO);
    }

    public void paginaMenu(Usuario usuario) {
        result.forwardTo(RedirecionarPaginasController.MENU);
    }

    public void paginaMenuAdm(Usuario usuario) {
        result.forwardTo(RedirecionarPaginasController.MENU_ADM);
    }
    
    @Path("/listagemUsuarios")
    public void paginaListagemUsuario(){
        UsuarioController u = new UsuarioController(result);
        List<Usuario> listU = u.listaUsuarios();
        result
                .include("usuarioList", listU)
                .forwardTo(RedirecionarPaginasController.LISTAGEM_USUARIO);
    }
    //endregion
    
    //region Estacao
    @Path("/listagemEstacao")
    public void paginaListagemEstacao(){
        EstacaoController e = new EstacaoController(result);
        List<Estacao> listE = e.listaEstacoes(); 
        result
                .include("estacaoList", listE)
                .forwardTo(RedirecionarPaginasController.LISTAGEM_ESTACAO);
    }  
    @Path("/cadastroEstacao")
    public void paginaCadastroEstacao(){
        result.forwardTo(RedirecionarPaginasController.CADASTRO_ESTACAO);
    }
    //endregion
    
    //region Observacao
    @Path("/listagemObservacao")
    public void paginaListagemObservacao(){
        ObservacaoController o = new ObservacaoController(result);
        List<Observacao> listO = o.listObservacoes();
        
        result
                .include("observacaoList", listO)
                .forwardTo(RedirecionarPaginasController.LISTAGEM_OBSERVACAO);
    }
    @Path("/cadastroObservacao")
    public void paginaCadastroObservacao(){
        result.forwardTo(RedirecionarPaginasController.CADASTRO_OBSERVACAO);
    }

    @Path("/visualizacaoObservacao")
    void paginaVisualizacaoObservacao(Observacao o) {
        result
                .include("observation", o)
                .forwardTo(RedirecionarPaginasController.VISUALIZAR_OBSERVACAO);
    }
    //endregion
}
