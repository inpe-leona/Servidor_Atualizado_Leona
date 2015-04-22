package br.leona.servidor.controller;
    
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.download.InputStreamDownload;
import br.leona.server.model.Estacao;
import br.leona.server.model.Observacao;
import br.leona.server.model.Servico;
import br.leona.server.model.Usuario;
import br.leona.servidor.service.ObservacaoService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
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

    IndexController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //region Index
    @Path("/")
    public void index() throws FileNotFoundException{
         
    }
    
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
    
    @Path("/relatorioUsuarios")
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
    public void paginaListagemObservacao() throws ParseException{
        
        ObservacaoController o = new ObservacaoController(result, request);
        List<Observacao> listO = o.listObservacoes();
        
        result
                .include("observacaoList", listO)
                .forwardTo(RedirecionarPaginasController.LISTAGEM_OBSERVACAO);
    }
    

    @Path("/visualizacaoObservacao")
    void paginaVisualizacaoObservacao(Observacao o) {
        
        result
                .include("observation", o)
                .forwardTo(RedirecionarPaginasController.VISUALIZAR_OBSERVACAO);
    }
    //endregion
    
    ////////////////////////////////// Novos Métodos
    @Path("/imagem")
    public void paginaGestaoImagens(){
        result
                .forwardTo(RedirecionarPaginasController.GESTAO_IMAGEM);
    }

    public void paginaPastaImagem(List<Observacao> listO) {
        result
                .include("pastas", listO)
                .forwardTo(RedirecionarPaginasController.PASTAIMAGEM);
    }

    void paginaImagens(List<String> caminho) {
        result
                .forwardTo(RedirecionarPaginasController.IMAGENSOBS);
    }
    
    @Path("/observacao")
    public void paginaGestaoObservacoes(){
        result
                .forwardTo(RedirecionarPaginasController.GESTAO_OBSERVACAO);
    }
    @Path("/cadastroObservacao")
    public void paginaCadastroObservacao(){
        result.forwardTo(RedirecionarPaginasController.CADASTRO_OBSERVACAO);
    }

    void paginaMensagemOkObservacao() {
        result.forwardTo(RedirecionarPaginasController.CADASTRO_OBSERVACAO_OK);
    }
    @Path("/relatorioObservacao")
    public void paginaRelatorioObservacao() throws ParseException{
        ObservacaoController o = new ObservacaoController(result, request);
        List<Observacao> listO = o.listObservacoes();
        
        result
                .include("observacaoList", listO)
                .forwardTo(RedirecionarPaginasController.LISTAGEM_OBSERVACAO);
    }
    @Path("/usuario")
    public void paginaGestaoUsuarios(){
        result
                .forwardTo(RedirecionarPaginasController.GESTAO_USUARIO);
    }
    @Path("/estacao")
    public void paginaGestaoEstaca(){
        result
                .forwardTo(RedirecionarPaginasController.GESTAO_ESTACAO);
    }

    void paginaCadastroEstacaoSucesso() {
        result.forwardTo(RedirecionarPaginasController.CADASTRO_ESTACAO_SUCESSO);
    }
    
    @Path("/relatorioEstacoes")
    public void paginaRelatorioEstacoes(){
        EstacaoController ec = new EstacaoController(result);
        List<Estacao> listE = ec.listaEstacoes();
        result
                .include("estacaoList", listE)
                .forwardTo(RedirecionarPaginasController.LISTAGEM_ESTACAO);
    }

    void paginaLogin2() {
        result.forwardTo(RedirecionarPaginasController.LOGIN2);
    }
    
}
