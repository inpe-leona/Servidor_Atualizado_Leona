package br.leona.servidor.controller;

import br.leona.servidor.mocks.PantIlt;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.leona.server.model.Observacao;
import br.leona.servidor.service.ObservacaoService;
import java.util.List;
import javax.swing.JOptionPane;

@Resource
public class ObservacaoController {
    
    private ObservacaoService obsService;
    private IndexController indexController;
    private PantIlt p;
    private Result result;
    
    public ObservacaoController(Result result){
        this.obsService = new ObservacaoService();
        this.indexController = new IndexController(result);
        this.p = new PantIlt();
        this.result = result;
    }
    
    @Post
    @Path("/cadastrarObservacao")
    public void cadastrarObservacao(Observacao observacao){
        String resposta = obsService.cadastrar(observacao);        
        if (resposta == "OK"){
            indexController.paginaListagemObservacao();
        }else{
            JOptionPane.showMessageDialog(null, resposta);
            indexController.paginaCadastroObservacao();
        } 
    }
    
    @Post
    @Path("/verObservacao")
    public void verObservacao(Observacao observacao){
        System.out.println("Veio Aqui");
        Observacao o = obsService.buscarObservacao(observacao);
        indexController.paginaVisualizacaoObservacao(o);        
    }
    
    /*@Post
    @Path("/movimentaresquerda")    
    public void movimentarEsquerda(PantIlt pantilt){
        System.out.println("Graus: "+pantilt.getGraus());
        obsService.movimentar(pantilt,"L");                
    }
    
    @Post
    @Path("/movimentardireita")    
    public void movimentarDireita(PantIlt p){
        System.out.println("Graus: "+p.getGraus());
        int m = obsService.movimentar(p,"R");
        
        if (m==1){
            result.forwardTo("WEB-INF/jsp/index/pantilt.jsp");
        }else{
            System.out.println("Não Moveu para Esquerda");
        }
    }
    @Post
    @Path("/movimentarcima")    
    public void movimentarCima(PantIlt p){
        System.out.println("Graus: "+p.getGraus());
        int m = obsService.movimentar(p,"U");
        
        if (m==1){
            result.forwardTo("WEB-INF/jsp/index/pantilt.jsp");
        }else{
            System.out.println("Não Moveu para Esquerda");
        }
    }
    
    @Post
    @Path("/movimentarbaixa")    
    public void movimentarBaixa(PantIlt p){
        System.out.println("Graus: "+p.getGraus());
        int m = obsService.movimentar(p,"D");
        
        if (m==1){
            result.forwardTo("WEB-INF/jsp/index/pantilt.jsp");
        }else{
            System.out.println("Não Moveu para Esquerda");
        }
    }
    
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

    public List<Observacao> listObservacoes() {
        return obsService.listObservacoes();
    }
    
}