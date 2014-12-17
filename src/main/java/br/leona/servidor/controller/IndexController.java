package br.leona.servidor.controller;
    
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.leona.server.model.Estacao;
import br.leona.server.model.Observacao;
import br.leona.server.model.Servico;
import br.leona.server.model.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
//import br.leona.basico.model.Usuario;

@Resource
public class IndexController {
    
    private Result result;
    private HttpServletRequest request;
    
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
    @Path("/servicosEstacao")
    public void paginaServicosEstacao(){
        EstacaoController e = new EstacaoController(result);
        Estacao es = new Estacao();
        List<Servico> listS = e.listServicos(es);
        result.forwardTo(RedirecionarPaginasController.LISTAGEM_SERVICOS);
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
        HttpSession session = request.getSession();
        String azimute = (String) session.getAttribute("azimute");
        String elevacao = (String) session.getAttribute("elevacao");
        result
                .include("observation", o)
                .include("positionazi", elevacao)
                .include("positionele", azimute)
                .forwardTo(RedirecionarPaginasController.VISUALIZAR_OBSERVACAO);
    }
    //endregion
}
