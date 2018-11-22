
import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import search.NaiveSearch;
import search.WordLocation;

/**
 *
 * @author ericapetersc
 */
public class NaiveTest {
    
    public NaiveTest() {
    }
    
    @Test
     public void shouldFindShakespeare() {
         NaiveSearch naive = new NaiveSearch();
         naive.prepareSearch("Macbeth.txt", "cauldron");
         WordLocation locate = naive.search(); 
         assertTrue("Deve ser verdadeiro", locate.FoiEncontrado());   
    }
     
    @Test
     public void shouldNotFindShakespeare() {
         NaiveSearch naive = new NaiveSearch();
         naive.prepareSearch("Macbeth.txt", "Ruivo");
         WordLocation locate = naive.search(); 
         assertFalse("Deve ser falso", locate.FoiEncontrado());   
     } 
}
