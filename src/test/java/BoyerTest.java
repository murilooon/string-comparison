import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import search.BoyerMooreSearch;
import search.WordLocation;

/**
 *
 * @author ericapetersc
 */
public class BoyerTest {
    
    public BoyerTest() {
    }
    
    @Test
     public void shouldFindShakespeare() {
         BoyerMooreSearch boyer = new BoyerMooreSearch();
         boyer.prepareSearch("Hamlet.txt", "peal");
         WordLocation locate = boyer.search(); 
         assertTrue("Deve ser verdadeiro", locate.FoiEncontrado());   
    }
     
    @Test
     public void shouldNotFindShakespeare() {
         BoyerMooreSearch boyer = new BoyerMooreSearch();
         boyer.prepareSearch("Hamlet.txt", "Erica");
         WordLocation locate = boyer.search(); 
         assertFalse("Deve ser falso", locate.FoiEncontrado());   
     } 
}

