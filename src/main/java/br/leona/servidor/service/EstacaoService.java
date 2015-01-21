package br.leona.servidor.service;

import br.leona.server.dao.ConsultasEstacaoDao;
import br.leona.server.model.Estacao;
import br.leona.server.model.Servico;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.*; 
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import org.esfinge.querybuilder.QueryBuilder;

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
              
        salvarImagem2("C:\\data\\node.png");
        
        return "ok";
    }
    public String salvarImagem2(String caminho) throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
        boolean retorno = true;
        Connection con = getConexao();
        try {
             // retrieve image            
            File outputfile = new File("C:\\data\\node.png");
            File a = new File("C:\\");
            BufferedImage bi = ImageIO.read(a);      
            ImageIO.write(bi, "png", outputfile);
            
            /*BufferedImage image = ImageIO.read(new File(caminho));      
            System.out.println("1");
            File img = new File(caminho);     
            System.out.println("2");
            ImageIO.write(image, "C:\\Users\\Nicolas Leona\\Desktop", img);
            System.out.println("3");
            System.out.println(img);*/
        } catch (IOException e) {
        
        }
        

        return "oi";
    }
    public String salvarImagem(String caminho) throws SQLException, FileNotFoundException, ClassNotFoundException{
        boolean retorno = true;  
         Connection con = getConexao();
            try{  
                File img = new File(caminho);  
                System.out.println("Pegou Caminho");
                FileInputStream inputStream = new FileInputStream(img);  
                PreparedStatement pstm = con.prepareStatement("INSERT INTO img(imagem)" +  
                        "VALUE(?)");  
                pstm.setBinaryStream(1, inputStream,(int)img.length());  
                System.out.println("Marcou a String");
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
