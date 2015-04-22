package br.leona.servidor.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.leona.server.model.Observacao;
import br.leona.servidor.service.ImagemService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Resource
public class ImagemController {

    private Result result;
    private HttpServletRequest request;
    private ImagemService imagemService;
    private IndexController indexController;

    public ImagemController(Result r, HttpServletRequest request) {
        this.result = r;
        this.imagemService = new ImagemService();
        this.indexController = new IndexController(r);
        this.request = request;
    }

    @Post
    @Path("/verImagensNome")
 
    public void verImagensNome(Observacao observacao) {

        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("img"));
        session.setAttribute("nome", observacao.getNome());
        List<String> caminho = imagemService.pegarCaminhosImagens(observacao.getNome());
        //List<String> caminho = new ArrayList<>();
        System.out.println("caminho: " + caminho);
        indexController.paginaImagens(caminho);
    }
}
