package br.leona.servidor.service;

import br.com.caelum.vraptor.ioc.Component;
import br.leona.server.dao.ConsultasUsuarioDao;
//import br.leona.basico.dao.DaoFactory;
//import br.leona.basico.dao.UsuarioDao;
//import br.leona.basico.model.Usuario;
import br.leona.server.model.Usuario;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Properties;
import org.esfinge.querybuilder.QueryBuilder;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class UsuarioService implements Serializable {

    private static final long serialVersionUID = -1917047398280846082L;
    ConsultasUsuarioDao dao = QueryBuilder.create(ConsultasUsuarioDao.class);
    
    public String cadastrar(Usuario u) throws NoSuchAlgorithmException {
        try{
            if ((u.getEmail().equals(""))||(u.getSenha().equals(""))){
             return "Campos obrigatórios em branco";
         }else{             
             u.setStatus("Inativo");
             u.setTipo("Comum");
                System.out.println("Senha A: "+u.getSenha());
             String s = verificarString(u.getSenha());
             System.out.println("Senha B: "+s);
             if(s=="ok"){
                u.setSenha(criptografar(u.getSenha()));
                dao.save(u);
                enviarEmailAdm(u.getEmail());
                System.out.println("Salvou");
                return "OK";
             }else{
                 return s;
             }
         }         
        }catch(Exception e){
            System.out.println("Erro: "+e);
            return "Erro no servidor";
        }                 
    }

    private String criptografar(String senha) throws NoSuchAlgorithmException {        
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.reset();
        byte[] buffer = senha.getBytes();
        md.update(buffer);
        byte[] digest = md.digest();

        String hexStr = "";
        for (int i = 0; i < digest.length; i++) {
            hexStr += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);
        }
        return hexStr;        
    }
    
    private String verificarString(String senha) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
        String minusculas = letras.toLowerCase();
        String numeros = "0123456789";
        String temMaiuscula = "";
        String temMinuscula = "";
        String temNumero = "";
        if (senha.length() >= 8) {
            for (int j = 0; j < senha.length(); j++) {
                for (int i = 0; i < letras.length(); i++) {
                    if (senha.charAt(j) == letras.charAt(i)) {
                        temMaiuscula = "ok";
                    }
                }
                for (int k = 0; k < minusculas.length(); k++) {
                    if (senha.charAt(j) == minusculas.charAt(k)) {
                        temMinuscula = "ok";
                    }
                }
                for (int h = 0; h < numeros.length(); h++) {
                    if (senha.charAt(j) == numeros.charAt(h)) {
                        temNumero = "ok";
                    }
                }
            }
            if ((temMaiuscula == "") || (temMinuscula == "") || (temNumero == "")) {
                senha = "Deve ter minimo 1 maiuscula - 1 minuscula - 1 numero";
            } else {
                senha = "ok";
            }
        } else {
            senha = "Mínimo 8 caracteres.";
        }

        return senha;
    }

    public Usuario logar(Usuario usuario) {
        try {

            String senha = criptografar(usuario.getSenha());
            return dao.getUsuarioByEmailAndSenha(usuario.getEmail(), senha);
            
        } catch (Exception e) {
            return null;
        }
    }

    public List<Usuario> listaUsuarios() {
        System.out.println("List Service");
        return dao.list();
    }

    public Usuario retornarUsuario(Usuario usuario) {
        System.out.println("id: "+usuario.getId());
        System.out.println("tipo: "+usuario.getTipo());
        Usuario u = dao.getById(usuario.getId());
        System.out.println("id: "+u.getId());
        System.out.println("tipo: "+u.getTipo());
        return u;
    }

    public void editar(Usuario usuario) {
        dao.save(usuario);
    }

    private void enviarEmailAdm(String email) {
        Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("nicolas.rfontes@gmail.com", "nicolas165"); //Colocar Email do LEONA depois
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("nicolas.rfontes@gmail.com")); //Remetente - Colocar Email do LEONA depois

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse("nicolas.rfontes@gmail.com");  //Trocar para Fernanda DEPOIS

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Cadastro LEONA");//Assunto
                  message.setText(" Há um novo cadastro no LEONA.\n Email: "+email);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

                  System.out.println("Feito!!!");

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
    }

    public void lembrarSenha(String email) {
        Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("nicolas.rfontes@gmail.com", "nicolas165"); //Colocar Email do LEONA depois
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("nicolas.rfontes@gmail.com")); //Remetente - Colocar Email do LEONA depois

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(email);  //Trocar para Fernanda DEPOIS

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Lembrete de Senha LEONA");//Assunto
                  message.setText(" Sua senha é: ");
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

                  System.out.println("Feito!!!");

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
    }
}
