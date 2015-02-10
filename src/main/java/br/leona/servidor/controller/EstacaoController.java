package br.leona.servidor.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.leona.server.model.Estacao;
import br.leona.server.model.Servico;
import br.leona.servidor.service.EstacaoService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

@Resource
public class EstacaoController {
    
    private IndexController indexController;
    private EstacaoService estService;
    private Result result;
    
    public EstacaoController(Result r){
        this.indexController = new IndexController(r);
        this.estService = new EstacaoService();
        this.result = r;
    }
    
    @Get
    @Path("buscarEstacao")
    public Estacao buscarEstacao(){
        Estacao estacao = new Estacao();
        estacao.setIp("150.163.46.137");
        return estService.buscarEstacaoId(estacao);
    }
    
    
    //////////////ANTIGOS
    public List<Estacao> listaEstacoes(){
        return estService.listaEstacoes();
    }
    
    @Post
    @Path("/cadastrarEstacao")
    public void cadastrarEstacao(Estacao estacao){
        String resposta = estService.cadastrar(estacao);        
        if (resposta == "OK"){
            indexController.paginaListagemEstacao();
        }else{
            JOptionPane.showMessageDialog(null, resposta);
            indexController.paginaCadastroEstacao();
        } 
    }
    
    @Post
    @Path("/ping")
    public void pingarEstacao(Estacao estacao) throws UnknownHostException{
        Estacao e = estService.buscarEstacaoId(estacao);
        e.setStatus(estService.pingar(e.getIp()));
        estService.editar(e);
        indexController.paginaListagemEstacao();        
    }

    public List<Servico> listServicos(Estacao e) {
        return estService.listaServicos();
    }    
    
    @Get
    @Path("/img")
    public void salvarImagem() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException{
        estService.buscarImagem(null);    
    }
}
