package view;

import search.BoyerMooreSearch;
import search.KMPSearch;
import search.NaiveSearch;
import search.RabinKarpSearch;
import search.WordLocation;
import java.util.List;
import javax.swing.JOptionPane;


public class ViewController {
    
    public ResultsView view = new ResultsView();
    
    public void procuraPalavra(List<String> strings, String word){
        
        while(!strings.isEmpty()){
        
            String text = strings.get(0);
            strings.remove(0);
            
            NaiveSearch naive = new NaiveSearch();
            naive.prepareSearch(text, word);
            WordLocation buscaNaive = naive.search();
            
            RabinKarpSearch rabin = new RabinKarpSearch();
            rabin.prepareSearch(text, word);
            WordLocation buscaRabin = rabin.search();
            
            KMPSearch KPM = new KMPSearch();
            KPM.prepareSearch(text, word);
            WordLocation buscaKPM = KPM.search();
            
            BoyerMooreSearch boyer = new BoyerMooreSearch();
            boyer.prepareSearch(text, word);
            WordLocation buscaBoyer = boyer.search();
            
            if(buscaNaive.getLine()==-1 && buscaKPM.getLine()==-1 && buscaBoyer.getLine()==-1){
                JOptionPane.showMessageDialog(null, "A palavra "+word+" não foi encontrada no arquivo "+text);
                view.setVisible(true);
            }
            else
                colocaNaView(word, text, buscaNaive, buscaRabin, buscaKPM, buscaBoyer);
        }
    }
    
    public void colocaNaView(String word, String text, WordLocation buscaNaive, WordLocation buscaRabin, WordLocation buscaKPM, WordLocation buscaBoyer){
        view.setVisible(true);
        view.setCampoPalavra(word);
        view.setTabela(text, "NAIVE", buscaNaive);
        view.setTabela(text, "RABIN", buscaRabin);
        view.setTabela(text, "KPM", buscaKPM);
        view.setTabela(text, "BOYER", buscaBoyer);
    }
    
}
