/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.leona.servidor.mocks.PantIlt;
import br.leona.servidor.service.ObservacaoService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas Leona
 */
public class PantIltTest {
    
    private static PantIlt p;
    private static ObservacaoService obsService;
    
    public PantIltTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        p = new PantIlt();
        obsService = new ObservacaoService();
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

    //@Test
    public void moverPantIlt(){
        p.setGraus("10");
        assertEquals(1, obsService.movimentar(5, "L"));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
