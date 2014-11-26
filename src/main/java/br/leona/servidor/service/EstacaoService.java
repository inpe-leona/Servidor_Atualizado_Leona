package br.leona.servidor.service;

import br.leona.server.dao.ConsultasEstacaoDao;
import br.leona.server.model.Estacao;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.esfinge.querybuilder.QueryBuilder;

public class EstacaoService {

    ConsultasEstacaoDao dao = QueryBuilder.create(ConsultasEstacaoDao.class);
    
    public List<Estacao> listaEstacoes() {
        List<Estacao> listE = dao.list();   
        return listE;
    }    

    public String cadastrar(Estacao estacao) {
        String resposta = "";
        if ((estacao.getNome().equals(""))||(estacao.getIp().equals(""))||(estacao.getCidade().equals(""))){
            resposta = "Campos Obrigatórios em Branco";
        }else{
            resposta = "OK";
            estacao.setStatus("Ativo");
            dao.save(estacao);
        }
        return resposta;
    }

    public Estacao buscarEstacaoId(Estacao estacao) {
        return dao.getById(estacao.getId());
    }

    public String pingar(String ip) throws UnknownHostException {
        String r = "";
        try {
        InetAddress address = null;
        System.out.println("IP: "+ip);
        address = InetAddress.getByName(ip);
        
        
            if (address.isReachable(5000)) {
                long nanos = 0;
                long millis = 0;
                long iterations = 0;
                while (true) {
                    iterations++;
                    try {
                        nanos = System.nanoTime();
                        address.isReachable(500); // this invocation is the offender  
                        nanos = System.nanoTime() - nanos;
                    } catch (IOException e) {
                        System.out.println("Failed to reach host");
                    }
                    millis = Math.round(nanos / Math.pow(10, 6));
                    System.out.println("Resposta do IP: " + address.getHostAddress() + " com de tempo=" + millis + " ms");                        
                    try {
                        Thread.sleep(Math.max(0, 1000 - millis));
                        break;
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                System.out.println("iterations: " + iterations);
                r = "c";
            } else {
                System.out.println("Host " + address.getHostName() + " is not reachable even once.");
                r = "e";
            }
        } catch (IOException e) {
            System.out.println("Network error.");
            r = "e";
        }
        System.out.println("Pingou");
        if (r == "e"){
            System.out.println("Inativo");
            return "Inativo";
        }else{
            System.out.println("Ativo");
            return "Ativo";
        }
    }

    public void editar(Estacao e) {
        dao.save(e);
    }
}
