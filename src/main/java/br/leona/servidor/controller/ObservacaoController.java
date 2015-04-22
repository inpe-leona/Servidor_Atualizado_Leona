package br.leona.servidor.controller;

import br.leona.servidor.mocks.PantIlt;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.leona.server.model.Observacao;
import br.leona.servidor.service.ObservacaoService;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@Resource
public class ObservacaoController {
    
    private ObservacaoService obsService;
    private IndexController indexController;
    private PantIlt p;
    private Result result;
    private HttpServletRequest request;
    
    public ObservacaoController(Result result, HttpServletRequest request){
        this.obsService = new ObservacaoService();
        this.indexController = new IndexController(result);
        this.p = new PantIlt();
        this.result = result;
        this.request = request;
    }
    
    
    @Get
    @Path("listaObservacoes")
    public void listaObservacoes() throws ParseException{
        List<Observacao> listO = obsService.listObservacoes();
        indexController.paginaPastaImagem(listO);
    }
    ///////////////Antigos
    @Post
    @Path("/cadastrarObservacao")
    public void cadastrarObservacao(Observacao observacao) throws ParseException{
        System.out.println(observacao.getEstacao());
        System.out.println("Cadastrar Controller");
        String resposta = obsService.cadastrar(observacao);        
        if (resposta == "OK"){
            indexController.paginaMensagemOkObservacao();
            //indexController.paginaListagemObservacao();
        }else{
            JOptionPane.showMessageDialog(null, resposta);
            indexController.paginaCadastroObservacao();
        } 
    }
    
    @Post
    @Path("/verObservacao")
    public void verObservacao(Observacao observacao){
        HttpSession session = request.getSession();
        session.setAttribute("obs", observacao);
        System.out.println("Veio Aqui");
        Observacao o = obsService.buscarObservacao(observacao);
        indexController.paginaVisualizacaoObservacao(o);        
    }
    
    /*
    
    @Post
    @Path("/movimentarreset")    
    public void movimentarReset(PantIlt p){
        System.out.println("Graus: "+p.getGraus());
        int m = obsService.movimentar(p,"RESET");
        
        if (m==1){
            result.forwardTo("WEB-INF/jsp/index/pantilt.jsp");
        }else{
            System.out.println("Não Moveu para Esquerda");
        }
    }
    
    @Post
    @Path("/movimentaroff")    
    public void movimentarOff(PantIlt p){
        System.out.println("Graus: "+p.getGraus());
        int m = obsService.movimentar(p,"OFF");
        
        if (m==1){
            result.forwardTo("WEB-INF/jsp/index/pantilt.jsp");
        }else{
            System.out.println("Não Moveu para Esquerda");
        }
    }
    
    @Post
    @Path("/movimentaron")    
    public void movimentarOn(PantIlt p){
        System.out.println("Graus: "+p.getGraus());
        int m = obsService.movimentar(p,"ON");
        
        if (m==1){
            result.forwardTo("WEB-INF/jsp/index/pantilt.jsp");
        }else{
            System.out.println("Não Moveu para Esquerda");
        }
    }*/
    
    @Get
    @Path("pantilt")
    public void paginaPantilt(){
        PantIlt pa = new PantIlt();
        result
                .include("pantilt", pa)
                .forwardTo("WEB-INF/jsp/index/pantilt.jsp");
    }

    public List<Observacao> listObservacoes() throws ParseException {
        return obsService.listObservacoes();
    }
    
}