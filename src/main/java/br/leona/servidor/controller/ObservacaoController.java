package br.leona.servidor.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;

@Resource
public class ObservacaoController {
    
    @Post
    @Path("/movimentaresquerda")    
    public void movimentarEsquerda(PantIlt p){
        System.out.println("Moveu");                
    }
    
}
