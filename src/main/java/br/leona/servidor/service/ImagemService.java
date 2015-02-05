package br.leona.servidor.service;

public class ImagemService {

    public void iniciarGravacao() {
        try { // Call Web Service Operation
            
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            
            port.iniciarCaptura();
        } catch (Exception ex) {
            System.out.println("Erro ao iniciar gravação: "+ex);
        }
        System.out.println("Iniciou Gravação");
    }
    
    public void pararGravacao(){
        
        try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            port.pararCaptura();
            
        } catch (Exception ex) {
            System.out.println("Erro ao parar gravação: "+ex);
        }     
        System.out.println("Parou Gravação");
    }
    
    public void ligarCamera(){        
        try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            // TODO process result here
            int result = port.ligarCamera();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            System.out.println("Erro ao ligar câmera: "+ex);
        }
        System.out.println("Ligou Câmera");
    }
    
    public void pararCamera(){
        try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            // TODO process result here
            int result = port.desligarCamera();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            System.out.println("Erro ao parar câmera: "+ex);
        }
        System.out.println("Parou Câmera");
    }
    
}