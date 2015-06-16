package br.leona.servidor.service;

import br.leona.server.dao.ConsultasEstacaoDao;
import br.leona.server.model.Estacao;
import br.leona.server.model.Observacao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.esfinge.querybuilder.QueryBuilder;

public class ImagemService {

    ConsultasEstacaoDao dao = QueryBuilder.create(ConsultasEstacaoDao.class);

    public void iniciarGravacao() {
        
       /* try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            port.iniciarCaptura();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }*/

        System.out.println("Iniciou Gravação");
    }

    public void pararGravacao() {
        
       /* try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            port.pararCaptura();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }*/
        
        System.out.println("Parou Gravação");
    }
    
    public void ligarCamera()  {
        System.out.println("Ligou Câmera");
       /* try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            // TODO process result here
            int result = port.ligarCamera();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }*/
        
    }

    public void pararCamera() {
       /* try { // Call Web Service Operation
            br.leona.estacao.controller.ControllerServices_Service service = new br.leona.estacao.controller.ControllerServices_Service();
            br.leona.estacao.controller.ControllerServices port = service.getControllerServicesPort();
            // TODO process result here
            int result = port.desligarCamera();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }*/
        System.out.println("Parou Câmera");
    }

    public Estacao buscarEstacaoIP(String ip) {
        return dao.getEstacaoByIp(ip);
    }

    public void buscarImagens() throws IOException, ParseException {
        FTPClient f = new FTPClient();
        f.connect("150.163.46.137");
        f.login("nicolas", "nicolas");
        FTPFile[] files = f.listFiles("/ProjetoLeona");
        System.out.println("Pegou arquivos: " + files.length);
        for (int i = 0; i < files.length; i++) {
            if (i > 0) {
                if (!files[i].getName().equals("..")) {
                    ObservacaoService obs = new ObservacaoService();
                    Observacao o = new Observacao();
                    o.setNome(files[i].getName());
                    obs.cadastrar(o);
                    File fa = new File("C:/Servidor_Leona/src/main/webapp/resources/ProjetoLeona/" + files[i].getName());
                    //File fa = new File("C:/receiver/ProjetoLeona/"+files[i].getName());
                    System.out.println("nome do arquivo criado: " + fa.getName());
                    if (fa.mkdir()) {
                        FTPFile[] pastaEvento = f.listFiles("/ProjetoLeona/" + files[i].getName());
                        System.out.println("Criou: " + pastaEvento.length);
                        for (int j = 2; j < pastaEvento.length; j++) {
                            System.out.println("Arquivos: " + pastaEvento[j].getName());
                            String pathLocal = "C:/Servidor_Leona/src/main/webapp/resources";
                            //String pathLocal = "C:/receiver";                
                            String stringUrl = "ftp://nicolas:nicolas@150.163.46.137/ProjetoLeona/" + files[i].getName() + "/" + pastaEvento[j].getName();
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
                        System.out.println("Imagens Coletadas");
                    } else {
                        System.out.println("nao criou");
                    }
                }
            }
        }
        System.out.println("Buscando Imagens...");
    }

    public List<String> pegarCaminhosImagens(String nome) {
        System.out.println("nome:" + nome);
        File diretorio = new File("C:/Servidor_Leona/src/main/webapp/resources/ProjetoLeona/" + nome);
        System.out.println("Diretorio: " + diretorio.getName());
        File[] arquivos = diretorio.listFiles();
        List<String> listS = new ArrayList<String>();
        for (int i = 0; i < arquivos.length; i++) {
            System.out.println("resources/ProjetoLeona/" + nome + "/" + arquivos[i].getName());
            String a = "resources/ProjetoLeona/" + nome + "/" + arquivos[i].getName();
            listS.add(a);
        }
        return listS;
    }
}
