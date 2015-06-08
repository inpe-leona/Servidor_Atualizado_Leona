/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.leona.servidor.service;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Leona1
 */
public class PararCaptura implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //Colocar o método de ligar camera
        System.out.println("Parou captura");
        
        try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            port.pararCaptura();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }


    }
    
}
