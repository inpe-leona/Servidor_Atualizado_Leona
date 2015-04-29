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
            
            try { // Call Web Service Operation
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                // TODO initialize WS operation arguments here
                int graus = 0;
                // TODO process result here
                java.lang.String result = port.moverAzimute(p);
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            } 

            r = 1;
            System.out.println("Movimentou pra Esquerda");
        }
        if (l == "elevacao"){
            
            try { // Call Web Service Operation
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                // TODO initialize WS operation arguments here
                int graus = 0;
                // TODO process result here
                java.lang.String result = port.moverElevacao(p);
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
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
            
            try { // Call Web Service Operation
                br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
                br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
                // TODO process result here
                int result = port.resetPantilt();
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

            System.out.println("Resetou");
        }
        return r;
    }

    public String cadastrar(Observacao observacao) throws ParseException {
        String resposta = validarCampos(observacao);
        String nomeObs = observacao.getNome();
        nomeObs = nomeObs.replaceAll(" ", "_");
        observacao.setNome(nomeObs);
        System.out.println("Resposta: "+resposta);
        if (resposta == ""){
            dao.save(observacao); 
            agendarLigarDesligarCamera(observacao);
            agendarTransmissao(observacao);
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
    
    public void iniciarTransmissao(){
        
        try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            port.iniciarTransmissao();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
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
                .withIdentity("newJob", "group4")
                .build();
            Trigger triggerInicial = TriggerBuilder
                .newTrigger()
                .withIdentity("newTrigger", "group4")
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
                .withIdentity("newJob", "group5")
                .build();
            Trigger triggerInicial = TriggerBuilder
                .newTrigger()
                .withIdentity("newTrigger", "group5")
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
    
    public void agendarTransmissao(Observacao obs) throws ParseException{
        String dataInicial = obs.getDataInicio() + " "+obs.getHoraInicio()+":00";        //Colocar no formato
        String dataFimCaptura = obs.getDataFim() + " "+obs.getHoraFim()+":00";      
        System.out.println("obs: "+dataFimCaptura);
        char campo0 = obs.getHoraInicio().charAt(0);
        char campo1 = obs.getHoraInicio().charAt(1);
        char campo2 = obs.getHoraInicio().charAt(2);
        char campo3 = obs.getHoraInicio().charAt(3);
        char campo4 = obs.getHoraInicio().charAt(4);
        int c4 = obs.getHoraInicio().charAt(4);
        c4 = c4+1;
        char sc4 = (char) c4;
        
        String a = String.valueOf(campo0);
        String b = String.valueOf(campo1);
        String c = String.valueOf(campo3);
        String d = String.valueOf(sc4);
        String dataCaptura = obs.getDataInicio() + " "+a+b+":"+c+d+":00";   
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
        Date dateI = null;  
        dateI = df.parse(dataInicial); 
        Date dateC = null;
        dateC = df.parse(dataCaptura);
        Date dateFC = null;
        dateFC = df.parse(dataFimCaptura);
        try {
            System.out.println("Iniciar Transmissao");
            SchedulerFactory schedFact = new StdSchedulerFactory();
            Scheduler sched = schedFact.getScheduler();
            sched.start();
            JobDetail job = JobBuilder.newJob(IniciarTransmissao.class)
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
            System.out.println("Iniciar Captura");
            SchedulerFactory schedFact = new StdSchedulerFactory();
            Scheduler sched = schedFact.getScheduler();
            sched.start();
            JobDetail job = JobBuilder.newJob(IniciarCaptura.class)
                .withIdentity("newJob", "group2")
                .build();
            Trigger triggerInicial = TriggerBuilder
                .newTrigger()
                .withIdentity("newTrigger", "group2")
                .startAt(dateC)
                //.withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(15, 15))
                .build();
            sched.scheduleJob(job, triggerInicial);
           } catch (Exception e) {
            System.out.println("erro");
            e.printStackTrace();
        }
         
        try {
            System.out.println("Parar Captura");
            SchedulerFactory schedFact = new StdSchedulerFactory();
            Scheduler sched = schedFact.getScheduler();
            sched.start();
            JobDetail job = JobBuilder.newJob(PararCaptura.class)
                .withIdentity("newJob", "group3")
                .build();
            Trigger triggerInicial = TriggerBuilder
                .newTrigger()
                .withIdentity("newTrigger", "group3")
                .startAt(dateFC)
                //.withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(15, 15))
                .build();
            sched.scheduleJob(job, triggerInicial);
           } catch (Exception e) {
            System.out.println("erro");
            e.printStackTrace();
        }
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
                .withIdentity("newJob", "group6")
                .build();
            Trigger triggerInicial = TriggerBuilder
                .newTrigger()
                .withIdentity("newTrigger", "group6")
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