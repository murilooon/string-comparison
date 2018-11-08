package search;

public class Main {
        public static void main(String[] args)
        {
            NaiveSearch naive = new NaiveSearch();
            naive.prepareSearch("file.txt", "King");
            WordLocation busca = naive.search();
            System.out.println("NAIVE - Palavra encontrada na linha "+busca.getLine()+" e na coluna "+busca.getColumn());
            
            RabinKarpSearch rabin = new RabinKarpSearch();
            rabin.prepareSearch("file.txt", "King");
            busca = rabin.search();
            System.out.println("RABIN - Palavra encontrada na linha "+busca.getLine()+" e na coluna "+busca.getColumn());
            
            KMPSearch KPM = new KMPSearch();
            KPM.prepareSearch("file.txt", "King");
            busca = KPM.search();
            System.out.println("KPM - Palavra encontrada na linha "+busca.getLine()+" e na coluna "+busca.getColumn());
            
            BoyerMooreSearch boyer = new BoyerMooreSearch();
            boyer.prepareSearch("file.txt", "King");
            busca = boyer.search();
            System.out.println("BOYER - Palavra encontrada na linha "+busca.getLine()+" e na coluna "+busca.getColumn());
            
            
        }
}
