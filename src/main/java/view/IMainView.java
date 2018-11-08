package view;

import java.util.List;

public interface IMainView {
   public List<String> getListFiles();
   public void setTextResultValue(String values);
   public String getTextResultValue();
   public String getTextWordToFind();
}
