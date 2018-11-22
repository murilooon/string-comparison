package search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigInteger;

public class WordLocation {

    private int line;
    private int column;
    private long time;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    public Boolean FoiEncontrado(){
        if(getColumn()==-1 && getLine()==-1){
            return false; 
        }
        return true;
    }
    
    public void save(String metodo, String text, String word) {
        try{
            FileWriter writer = new FileWriter("src/main/resources/save.csv", true);
            BufferedWriter arquivo = new BufferedWriter(writer);
            if(line!=-1 && column!=-1){
                arquivo.write(text+","+word+","+metodo+","+line+","+column+","+time+";");
                arquivo.newLine();
                arquivo.close();
            }
            else{
                arquivo.write(text+","+word+","+"nao encontrado"+","+time+";");
                arquivo.newLine();
                arquivo.close();
            }
        } catch (Exception e){
            System.out.println("Erro ao gravar ocorrencia");
        }
    }
    

}