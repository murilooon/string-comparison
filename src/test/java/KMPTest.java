import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import search.KMPSearch;
import search.WordLocation;

/**
 *
 * @author ericapetersc
 */
public class KMPTest {
    
    public KMPTest() {
    }
    
    @Test
     public void shouldFindShakespeare() {
         KMPSearch kmp = new KMPSearch();
         kmp.prepareSearch("KingLear.txt", "deservings");
         WordLocation locate = kmp.search(); 
         assertTrue("Deve ser verdadeiro", locate.FoiEncontrado());   
    }
     
    @Test
     public void shouldNotFindShakespeare() {
         KMPSearch kmp = new KMPSearch();
         kmp.prepareSearch("KingLear.txt", "Murilo");
         WordLocation locate = kmp.search(); 
         assertFalse("Deve ser falso", locate.FoiEncontrado());   
     } 
}
