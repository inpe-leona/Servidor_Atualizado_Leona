
package br.leona.servidor.service;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class IniciarTransmissao implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //Colocar o método de ligar camera
        System.out.println("Iniciou transmisssao");
        
       /* 
        try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            port.iniciarTransmissao();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
*/

        
        


    }
}
