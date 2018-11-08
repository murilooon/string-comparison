
package search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class KMPSearch implements ISearchStrategy{
 
    String text, word;
    private int[][] dfa;
    int M, R;
    
    @Override
    public void prepareSearch(String text, String word){
        this.text = text;
        this.word = word;
    
        M = word.length();
        R = 256;
        dfa = new int[R][M];
        dfa[word.charAt(0)][0] = 1;

        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X];
            dfa[word.charAt(j)][j] = j+1;
            X = dfa[word.charAt(j)][X];
        }
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
                    int j, M = word.length();
                    int i, N = line.length();
                    if (N!=0){
                        for (i = 0, j = 0; i < N && j < M; i++)
                            j = dfa[line.charAt(i)][j];
                        if (j == M){
                            busca.setLine(line_index);
                            busca.setColumn(i-M);
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