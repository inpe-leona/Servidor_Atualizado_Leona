package br.leona.servidor.service;

import br.com.caelum.vraptor.ioc.Component;
import br.leona.server.dao.ConsultasChatDao;
import br.leona.server.model.Chat;
import java.io.Serializable;
import java.util.List;
import org.esfinge.querybuilder.QueryBuilder;

@Component
public class ChatService implements Serializable{
    
    ConsultasChatDao dao = QueryBuilder.create(ConsultasChatDao.class);
    
    public List<Chat> cadastrar(Chat c){        
        if (dao.save(c) !=  null){
            return dao.list();            
        }else{
            return null;    
        }
    }
    
}
