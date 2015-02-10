package br.leona.servidor.service;

import br.leona.server.dao.ConsultasEstacaoDao;
import br.leona.server.model.Estacao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.esfinge.querybuilder.QueryBuilder;

public class ImagemService {

    ConsultasEstacaoDao dao = QueryBuilder.create(ConsultasEstacaoDao.class);
    
    public void iniciarGravacao() {
        /*try { // Call Web Service Operation
            
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            
            port.iniciarCaptura();
        } catch (Exception ex) {
            System.out.println("Erro ao iniciar gravação: "+ex);
        }*/
        System.out.println("Iniciou Gravação");
    }
    
    public void pararGravacao(){
        
        /*try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            port.pararCaptura();
            
        } catch (Exception ex) {
            System.out.println("Erro ao parar gravação: "+ex);
        }  */   
        System.out.println("Parou Gravação");
    }
    
    public void ligarCamera(){        
        /*try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            // TODO process result here
            int result = port.ligarCamera();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            System.out.println("Erro ao ligar câmera: "+ex);
        }*/
        System.out.println("Ligou Câmera");
    }
    
    public void pararCamera(){
        /*try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            // TODO process result here
            int result = port.desligarCamera();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            System.out.println("Erro ao parar câmera: "+ex);
        }*/
        System.out.println("Parou Câmera");
    }

    public Estacao buscarEstacaoIP(String ip) {
        return dao.getEstacaoByIp(ip);
    }

    public void buscarImagens() throws IOException {
        FTPClient f = new FTPClient();
        f.connect("150.163.46.137");
        f.login("nicolas", "nicolas");        
        FTPFile[] files = f.listFiles();        
        System.out.println("Pegou arquivos: " + files.length);
        FTPFile[] files2 = f.listFiles("/ProjetoLeona");        
        System.out.println("Pegou arquivos: " + files2.length);
        FTPFile[] files3 = f.listFiles("/Evento_05022015_162229");        
        System.out.println("Pegou arquivos: " + files3.length);
        for (int i = 0; i < files.length; i++) {            
            if (i > 1) {
                File fa = new File("C:/receiver/ftproot/ProjetoLeona/"+files[i].getName());
                if (fa.mkdir()){                      
                    FTPFile[] pastaEvento = f.listFiles("/ftproot/ProjetoLeona/"+files[i].getName());
                    System.out.println("Criou: "+pastaEvento.length);
                    for (int j = 2; j< pastaEvento.length; j++){
                        System.out.println("Arquivos: "+pastaEvento[j].getName());
                        String pathLocal = "C:/receiver";                
                        String stringUrl = "ftp://nicolas:nicolas@150.163.46.208/ftproot/ProjetoLeona/"+files[i].getName()+"/"+pastaEvento[j].getName();
                        URL url = new URL(stringUrl);
                        String nomeArquivoLocal = url.getFile();
                        InputStream is = url.openStream();
                        File arq = new File(pathLocal + nomeArquivoLocal);
                        FileOutputStream fos = new FileOutputStream(pathLocal + nomeArquivoLocal);
                        int umByte = 0;
                        while ((umByte = is.read()) != -1) {
                            fos.write(umByte);
                        }
                        is.close();
                        fos.close();
                    }
                    JOptionPane.showMessageDialog(null,"Imagens Coletadas");
                }else{
                    System.out.println("nao criou");
                }
            }
        }
        System.out.println("Buscando Imagens...");
    }
    
}