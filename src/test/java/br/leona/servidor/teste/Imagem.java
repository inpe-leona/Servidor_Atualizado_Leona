package br.leona.servidor.teste;

import br.leona.servidor.service.ImagemService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Imagem {
    
    private static ImagemService imgService; 
    
    public Imagem() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        imgService = new ImagemService();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void iniciarGravacao(){
        imgService.iniciarGravacao();
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
