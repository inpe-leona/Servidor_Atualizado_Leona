/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.leona.servidor.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 *
 * @author Nicolas Leona
 */
public class DesligarCamera  implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //Colocar o método de desligar camera
        System.out.println("Desligou");
        try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            // TODO process result here
            int result = port.desligarCamera();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        //Colocar o método de buscar as imagens
        ImagemService im = new ImagemService();
        try {
            im.buscarImagens();
        } catch (IOException ex) {
            Logger.getLogger(DesligarCamera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DesligarCamera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
