package br.leona.servidor.service;

public class ImagemService {

    public void iniciarGravacao() {
        ligarCamera();
        System.out.println("Iniciou Gravação");
    }
    
    public void pararGravacao(){        
        System.out.println("Parou Gravação");
        pararCamera();
    }
    
    private void ligarCamera(){
        System.out.println("Ligou Câmera");
    }
    
    private void pararCamera(){
        System.out.println("Parou Câmera");
    }
}