
package search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class RabinKarpSearch implements ISearchStrategy{
    
    String text, word;
    private long wordHash;
    private int M;
    private long Q;
    private int R = 256;
    private long RM;
    
    
    @Override
    public void prepareSearch(String text, String word){
        this.text = text;
        this.word = word;
        M = word.length();
        Q = RandomLongPrimo();
        RM = 1;
        for (int i = 1; i <= M-1; i++) // calcula R^(M-1)%Q
            RM = (R * RM) % Q;
        wordHash = hash(word, M);
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
                    int N = line.length();
                    if (N!=0){
                        long lineHash = hash(line, M);
                        if (wordHash == lineHash && check(line, 0)){
                            busca.setLine(line_index);
                            busca.setColumn(0);
                            return busca;
                        }
                        for (int i = 1; i <= N - M; i++) {
                            lineHash = (lineHash + Q - RM*line.charAt(i-1) % Q) % Q;
                            lineHash = (lineHash * R + line.charAt(i+M-1)) % Q;
                            if (wordHash == lineHash)
                                if (check(line, i)){
                                    busca.setLine(line_index);
                                    busca.setColumn(i);
                                    return busca;
                                } 
                        }
                    }   
                    line_index++;
                }
            } catch (IOException ex) {System.out.println("Erro na leitura da linha");}
        } catch (FileNotFoundException e) {System.out.println("O arquivo não foi localizado");}
        
        return null;
    }
    
    private long hash(String key, int M) {
      long h = 0;
      for (int j = 0; j < M; j++)
         h = (R * h + key.charAt(j)) % Q;
      return h;
   }
    
    private static long RandomLongPrimo(){
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
    
    public boolean check(String txt, int i) { 
      return true;
   }
}
