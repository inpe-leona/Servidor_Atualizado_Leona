package br.leona.servidor.service;

import br.leona.server.dao.ConsultasEstacaoDao;
import br.leona.server.model.Estacao;
import br.leona.server.model.Servico;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.*; 
import java.util.List;
import javax.imageio.ImageIO;
import org.esfinge.querybuilder.QueryBuilder;
import org.hibernate.connection.DriverManagerConnectionProvider;

public class EstacaoService {

    ConsultasEstacaoDao dao = QueryBuilder.create(ConsultasEstacaoDao.class);
    
    public List<Estacao> listaEstacoes() {
        List<Estacao> listE = dao.list();   
        return listE;
    }    

    public String cadastrar(Estacao estacao) {
        String resposta = "";
        if ((estacao.getNome().equals(""))||(estacao.getIp().equals(""))||(estacao.getCidade().equals(""))){
            resposta = "Campos Obrigatórios em Branco";
        }else{
            resposta = "OK";
            estacao.setStatus("Ativo");
            dao.save(estacao);
        }
        return resposta;
    }

    public Estacao buscarEstacaoId(Estacao estacao) {
        return dao.getById(estacao.getId());
    }

    public String buscarImagem(Estacao estacao) throws MalformedURLException, IOException, SQLException, FileNotFoundException, ClassNotFoundException{
        
        try{
            /*java.net.URL url = new URL("https://fbcdn-sphotos-g-a.akamaihd.net/hphotos-ak-xpa1/v/t1.0-9/10645207_1546719082218097_3828434421908380376_n.jpg?oh=959b78a473dfd327d0b2f9cb0cfc11ec&oe=553A600D&__gda__=1429186663_fd62d5590f96bb97c7541fd2a162d1a1");
            Image imagem = ImageIO.read(url);   */
            
        }catch(Exception e){
            
        }        
        salvarImagem("http://www.ufla.br/ascom/wp-content/uploads/2012/01/20.01-logoTesteAnpad.jpg");
        return "ok";
    }
    
    public String salvarImagem(String caminho) throws SQLException, FileNotFoundException, ClassNotFoundException{
        boolean retorno = true;  
         Connection con = getConexao();
            try{  
                File img = new File(caminho);  
                FileInputStream inputStream = new FileInputStream(img);  
                PreparedStatement pstm = con.prepareStatement("INSERT INTO img(imagem)" +  
                        "VALUE(?)");  
                pstm.setBinaryStream(1, inputStream,(int)img.length());  
                  
                pstm.execute();  
            }catch(SQLException sqle){  
                sqle.printStackTrace();  
            }  
            return "oi";
    }
    
    public static Connection getConexao() throws SQLException{   
        try {  
          Class.forName("com.mysql.jdbc.Driver");  
          System.out.println("Conectando ao banco");  
        }   
        catch (ClassNotFoundException e){  
          System.out.println("Classe não encontrada");  
        }  
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/teste","root","root");  
    }
    
    public String pingar(String ip) throws UnknownHostException {
        String r = "";
        try {
        InetAddress address = null;
        System.out.println("IP: "+ip);
        address = InetAddress.getByName(ip);
        
        
            if (address.isReachable(5000)) {
                long nanos = 0;
                long millis = 0;
                long iterations = 0;
                while (true) {
                    iterations++;
                    try {
                        nanos = System.nanoTime();
                        address.isReachable(500); // this invocation is the offender  
                        nanos = System.nanoTime() - nanos;
                    } catch (IOException e) {
                        System.out.println("Failed to reach host");
                    }
                    millis = Math.round(nanos / Math.pow(10, 6));
                    System.out.println("Resposta do IP: " + address.getHostAddress() + " com de tempo=" + millis + " ms");                        
                    try {
                        Thread.sleep(Math.max(0, 1000 - millis));
                        break;
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                System.out.println("iterations: " + iterations);
                r = "c";
            } else {
                System.out.println("Host " + address.getHostName() + " is not reachable even once.");
                r = "e";
            }
        } catch (IOException e) {
            System.out.println("Network error.");
            r = "e";
        }
        System.out.println("Pingou");
        if (r == "e"){
            System.out.println("Inativo");
            return "Inativo";
        }else{
            System.out.println("Ativo");
            return "Ativo";
        }
    }

    public void editar(Estacao e) {
        dao.save(e);
    }

    public List<Servico> listaServicos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
