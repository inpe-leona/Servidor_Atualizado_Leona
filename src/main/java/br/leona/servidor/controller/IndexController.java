package br.leona.servidor.controller;
    
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;


@Resource
public class IndexController {
    
    private Result result;
    
    public IndexController(Result r){
        this.result = r;
    }
    
    @Path("/")
    public void index(){}
}
