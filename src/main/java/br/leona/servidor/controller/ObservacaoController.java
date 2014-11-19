package br.leona.servidor.controller;

import br.leona.servidor.mocks.PantIlt;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.leona.servidor.service.ObservacaoService;

@Resource
public class ObservacaoController {
    
    private ObservacaoService obsService;
    private PantIlt p;
    private Result result;
    
    public ObservacaoController(ObservacaoService os, PantIlt pp, Result result){
        this.obsService = os;
        this.p = pp;
        this.result = result;
    }
    
    @Post
    @Path("/movimentaresquerda")    
    public void movimentarEsquerda(PantIlt p){
        System.out.println("Graus: "+p.getGraus());
        int m = obsService.movimentar(p,"L");
        
        if (m==1){
            result.forwardTo("WEB-INF/jsp/index/pantilt.jsp");
        }else{
            System.out.println("Não Moveu para Esquerda");
        }
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
    }
    
    @Get
    @Path("pantilt")
    public void paginaPantilt(){
        PantIlt pa = new PantIlt();
        result
                .include("pantilt", pa)
                .forwardTo("WEB-INF/jsp/index/pantilt.jsp");
    }
    
}