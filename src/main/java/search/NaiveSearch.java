
package search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class NaiveSearch implements ISearchStrategy {
    
    String text, word;
    
    @Override
    public void prepareSearch(String text, String word){
        this.text = text;
        this.word = word;
    }
    
    @Override
    public WordLocation search() {
        
        WordLocation busca = new WordLocation();
        String line = "";
        BufferedReader reader;
        int line_index = 0;
        
        try{
            reader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(text).getPath()));
            try {
                while((line = reader.readLine()) != null){
                    int n = line.length();
                    int m = word.length();
                    for (int i = 0; i < n - m; i++) {
                        int j = 0;
                        while (j < m && line.charAt(i + j) == word.charAt(j))
                            j++;
                        if(j==m){
                            busca.setLine(line_index);
                            busca.setColumn(i);
                            return busca;
                        }
                    }
                    line_index++;
                }
            } catch (IOException ex) {System.out.println("Erro na leitura da linha");}
        } catch (FileNotFoundException e) {System.out.println("O arquivo não foi localizado");}
        
        return null;
    }
    
}
