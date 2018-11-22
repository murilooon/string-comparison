package search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class BoyerMooreSearch extends ISearchStrategyDecorator{

    String text, word;
    private int R;
    private int[] right;
    
    @Override
    public void prepareSearch(String text, String word) {
        this.text = text;
        this.word = word;
        R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;
        for (int j = 0; j < word.length(); j++)
            right[word.charAt(j)] = j;
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
                startTimer();
                
                while((line = reader.readLine()) != null){
                    int m = word.length();
                    int n = line.length();
                    if(n!=0){
                        int skip;
                        for (int i = 0; i <= n - m; i += skip) {
                            skip = 0;
                            for (int j = m-1; j >= 0; j--) {
                                if (word.charAt(j) != line.charAt(i+j)) {
                                    skip = Math.max(1, j - right[line.charAt(i+j)]);
                                    break;
                                }
                            }
                            if (skip == 0){
                                stopTimer();
                                busca.setTime(timer);
                                busca.setLine(line_index);
                                busca.setColumn(i);
                                busca.save("BOYER", text, word);
                                return busca;
                            }
                        }
                    }
                    line_index++;
                }
                stopTimer();
                busca.setTime(timer);
            } catch (IOException ex) {System.out.println("Erro na leitura da linha");}
        } catch (FileNotFoundException e) {System.out.println("O arquivo não foi localizado");}
        //nao encontrado
        busca.setLine(-1);
        busca.setColumn(-1);
        busca.save("BOYER", text, word);
        return busca;
    }
    
}