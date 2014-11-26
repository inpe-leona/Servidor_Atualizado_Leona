package br.leona.servidor.service;

import br.leona.server.dao.ConsultasEstacaoDao;
import br.leona.server.dao.ConsultasObservacaoDao;
import br.leona.server.model.Observacao;
import br.leona.servidor.mocks.PantIlt;
import java.util.List;
import org.esfinge.querybuilder.QueryBuilder;

public class ObservacaoService {
    
    ConsultasObservacaoDao dao = QueryBuilder.create(ConsultasObservacaoDao.class);

    public int movimentar(int p, String l) {
        System.out.println("Graus: "+p);
        int r = 0;
        if (l == "L"){
           /* try { 
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                
                
                
                int result = port.moverEsquerda(p.getGraus());
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
*/
            r = 1;
            System.out.println("Movimentou pra Esquerda");
        }
        if (l == "U"){
          /* try { // Call Web Service Operation
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                // TODO initialize WS operation arguments here
                
                // TODO process result here
                System.out.println("CHEGOU NO UP");
                int result = port.moverCima(Integer.parseInt(p.getGraus()));
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }*/

            r = 1;
            System.out.println("Movimentou pra Cima");
        }
        if (l == "R"){
            /*try { // Call Web Service Operation
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                // TODO initialize WS operation arguments here
                int graus = 0;
                // TODO process result here
                int result = port.moverDireita(Integer.parseInt(p.getGraus()));
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }*/

            r = 1;
            System.out.println("Movimentou pra Direita");
        }
        if (l == "D"){
            /*try { // Call Web Service Operation
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                // TODO initialize WS operation arguments here
                int graus = 0;
                // TODO process result here
                int result = port.moverBaixo(Integer.parseInt(p.getGraus()));
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }*/

            r = 1;
            System.out.println("Movimentou pra Baixo");
        }
        if (l == "OFF"){
            r = 1;
            /*try { // Call Web Service Operation
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                
                int result = port.ligarDesligarCamera(0);
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }*/
            System.out.println("Desligou");
        }
        if (l == "ON"){
            r = 1;
            /*try { // Call Web Service Operation
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                
                int result = port.ligarDesligarCamera(1);
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }*/

            System.out.println("Ligou");
        }
        if (l == "RESET"){
            r = 1;
            /*try { // Call Web Service Operation
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                // TODO process result here
                int result = port.resetPantilt();
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }*/

            System.out.println("Resetou");
        }
        return r;
    }

    public String cadastrar(Observacao observacao) {
        String resposta = "";
        dao.save(observacao);
        resposta = "OK";
        return resposta;
    }

    public List<Observacao> listObservacoes() {
        return dao.list();
    }

    public Observacao buscarObservacao(Observacao observacao) {
        return dao.getById(observacao.getId());
    }
    
}