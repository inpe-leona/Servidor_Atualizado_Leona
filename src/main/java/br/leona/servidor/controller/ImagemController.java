package br.leona.servidor.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.leona.servidor.service.ImagemService;

@Resource
public class ImagemController {
    private Result result;
    private ImagemService imagemService;
        
    public ImagemController(Result r){
        this.result = r;
        this.imagemService = new ImagemService();
    }   
}
