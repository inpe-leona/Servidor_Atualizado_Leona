package br.leona.servidor.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.leona.server.model.Estacao;
import br.leona.servidor.service.ImagemService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

@Resource
public class ImagemController {

    private Result result;
    private ImagemService imagemService;

    public ImagemController(Result r) {
        this.result = r;
        this.imagemService = new ImagemService();
    }   
}
