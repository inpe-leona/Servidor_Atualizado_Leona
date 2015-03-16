package br.leona.servidor.service;

import br.com.caelum.vraptor.ioc.Component;
import br.leona.server.dao.ConsultasLogDao;
import br.leona.server.dao.ConsultasObservacaoDao;
import br.leona.server.model.Log;
import br.leona.server.model.Observacao;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.esfinge.querybuilder.QueryBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

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

    public String cadastrar(Observacao observacao) throws ParseException {
        String resposta = validarCampos(observacao);
        System.out.println("Resposta: "+resposta);
        if (resposta == ""){
            dao.save(observacao);   
            agendarLigarDesligarCamera(observacao);
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
    
    public void salvarLog(String id, String nome, String movimentacao, int graus) {
        Log l = new Log();
        l.setAcao("Movimentou "+movimentacao+" em "+graus+" graus");
        l.setIdObservacao(id);
        l.setNomeObservacao(nome);
        l.setUsuario("Nicolas");//Colocar a sessão de usuario logado aqui
        log.save(l);
    }
    
    public int agendarStatusObservacao(Observacao obs) throws ParseException{
        return 1;
    }
    
    public int agendarLigarDesligarCamera(Observacao obs) throws ParseException{
        String dataInicial = obs.getDataInicio() + " "+obs.getHoraInicio()+":00";        //Colocar no formato
        String dataFinal = obs.getDataFim() + " "+obs.getHoraFim()+":00";      
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
        Date dateI = null;  
        dateI = df.parse(dataInicial); 
        System.out.println("D: "+dateI);
        Date dateF = null;  
        dateF = df.parse(dataFinal); 
        
        try {
            System.out.println("Ligar");
            SchedulerFactory schedFact = new StdSchedulerFactory();
            Scheduler sched = schedFact.getScheduler();
            sched.start();
            JobDetail job = JobBuilder.newJob(LigarCamera.class)
                .withIdentity("newJob", "group1")
                .build();
            Trigger triggerInicial = TriggerBuilder
                .newTrigger()
                .withIdentity("newTrigger", "group1")
                .startAt(dateI)
                //.withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(15, 15))
                .build();
            sched.scheduleJob(job, triggerInicial);
           } catch (Exception e) {
            System.out.println("erro");
            e.printStackTrace();
        }
        
         try {
            System.out.println("Desligar");
            SchedulerFactory schedFact = new StdSchedulerFactory();
            Scheduler sched = schedFact.getScheduler();
            sched.start();
            JobDetail job = JobBuilder.newJob(DesligarCamera.class)
                .withIdentity("newJob", "group2")
                .build();
            Trigger triggerInicial = TriggerBuilder
                .newTrigger()
                .withIdentity("newTrigger", "group2")
                .startAt(dateF)
                //.withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(15, 15))
                .build();
            sched.scheduleJob(job, triggerInicial);
           } catch (Exception e) {
            System.out.println("erro");
            e.printStackTrace();
        }
        
        return 1;
    }
    
    public void quartz() throws ParseException{
        String dateString = "10/03/2015 16:32:30";    
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
        Date dateDate = null;  
        dateDate = df.parse(dateString);  

        try {
            SchedulerFactory schedFact = new StdSchedulerFactory();
            Scheduler sched = schedFact.getScheduler();
            sched.start();
            JobDetail job = JobBuilder.newJob()
                .withIdentity("newJob", "group1")
                .build();
            Trigger triggerInicial = TriggerBuilder
                .newTrigger()
                .withIdentity("newTrigger", "group1")
                .startAt(dateDate)
                //.withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(15, 15))
                .build();
            sched.scheduleJob(job, triggerInicial);
           } catch (Exception e) {
            System.out.println("erro");
            e.printStackTrace();
        }
    }
}