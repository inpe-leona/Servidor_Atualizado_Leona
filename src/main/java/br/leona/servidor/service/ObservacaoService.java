package br.leona.servidor.service;

import br.leona.servidor.mocks.PantIlt;

public class ObservacaoService {

    public int movimentar(PantIlt p, String l) {
        try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            // TODO initialize WS operation arguments here
            java.lang.String graus = "10";
            // TODO process result here
            int result = port.moverEsquerda(graus);
            System.out.println("Result = "+result);
            return result;
        } catch (Exception ex) {
            return 0;
        }
    }
    
}
