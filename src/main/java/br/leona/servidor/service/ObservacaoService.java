package br.leona.servidor.service;

import br.com.caelum.vraptor.ioc.Component;
import br.leona.server.dao.ConsultasLogDao;
import br.leona.server.dao.ConsultasObservacaoDao;
import br.leona.server.model.Log;
import br.leona.server.model.Observacao;
import java.io.Serializable;
import java.util.List;
import org.esfinge.querybuilder.QueryBuilder;

@Component
public class ObservacaoService implements Serializable{
    
    ConsultasObservacaoDao dao = QueryBuilder.create(ConsultasObservacaoDao.class);
    ConsultasLogDao log = QueryBuilder.create(ConsultasLogDao.class);

    public int movimentar(int p, String l) {
        System.out.println("Graus: "+p);
        int r = 0;
        if (l == "azimute"){
             
            /*try { // Call Web Service Operation
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                // TODO initialize WS operation arguments here
                
                // TODO process result here
                java.lang.String result = port.moverAzimute(p);
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }*/
            r = 1;
            System.out.println("Movimentou pra Esquerda");
        }
        if (l == "elevacao"){
            
            /*try { // Call Web Service Operation
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                // TODO initialize WS operation arguments here
                // TODO process result here
                java.lang.String result = port.moverElevacao(p);
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }*/
            r = 1;
            System.out.println("Movimentou pra Cima");
        }
        if (l == "OFF"){
            r = 1;
            
            System.out.println("Desligou");
        }
        if (l == "ON"){
            r = 1;           

            System.out.println("Ligou");
        }
        if (l == "RESET"){
            r = 1;
            
            System.out.println("Resetou");
        }
        return r;
    }

    public String cadastrar(Observacao observacao) {
        String resposta = validarCampos(observacao);
        System.out.println("Resposta: "+resposta);
        if (resposta == ""){
            dao.save(observacao);    
            resposta = "OK";
        }
        return resposta;
    }
    
    private String validarCampos(Observacao observacao) {  
        System.out.println(observacao.getEstacao());
        System.out.println(observacao.getDataInicio());
        System.out.println(observacao.getHoraFim());
        System.out.println(observacao.getHoraInicio());
        if ((observacao.getDataFim() == null)||(observacao.getNome() == null)||(observacao.getDataInicio() == null)||(observacao.getEstacao()== null)||(observacao.getHoraFim() == null)||(observacao.getHoraInicio() == null)){
            return "Campos Obrigatórios em Branco";
        }else{
            return "";
        }
    }
    
    public List<Observacao> listObservacoes() {
        return dao.list();
    }

    public Observacao buscarObservacao(Observacao observacao) {
        return dao.getById(observacao.getId());
    }

    public void gravar(int g) {
        if (g == 1){
            //inicia gravacao
        }else{
            //pausa gravacao
        }
    }
    
    public void salvarLog(String id, String nome, String movimentacao, int graus) {
        Log l = new Log();
        l.setAcao("Movimentou "+movimentacao+" em "+graus+" graus");
        l.setIdObservacao(id);
        l.setNomeObservacao(nome);
        l.setUsuario("Nicolas");//Colocar a sessão de usuario logado aqui
        log.save(l);
    }

    
    
}