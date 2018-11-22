
package search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AhoCorasickSearch implements ISearchStrategy{

    String text, word;
    
    @Override
    public void prepareSearch(String text, String word) {
        this.text = text;
        this.word = word;
    }

    @Override
    public WordLocation search() {
        return null;
    }
    
    
}
