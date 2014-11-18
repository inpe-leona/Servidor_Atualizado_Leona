package br.leona.servidor.controller;

import br.leona.servidor.mocks.PantIlt;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.leona.servidor.service.ObservacaoService;

@Resource
public class ObservacaoController {
    
    private ObservacaoService obsService;
    private PantIlt p;
    
    
    public ObservacaoController(ObservacaoService os, PantIlt pp){
        this.obsService = os;
        this.p = pp;
    }
    
    @Post
    @Path("/movimentaresquerda")    
    public void movimentarEsquerda(PantIlt p){
        int m = obsService.movimentar(p,"L");
        
        if (m==1){
            System.out.println("Moveu para Esquerda");
        }else{
            System.out.println("Não Moveu para Esquerda");
        }
    }
    
}
