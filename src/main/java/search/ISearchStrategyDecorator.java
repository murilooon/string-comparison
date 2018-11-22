
package search;


public class ISearchStrategyDecorator implements ISearchStrategy{

    public ISearchStrategy strategy;
    public long timer;
    
    @Override
    public void prepareSearch(String text, String word) {
        strategy.prepareSearch(text, word);
    }

    @Override
    public WordLocation search() {
        return strategy.search();
    }
    
    public void startTimer(){
        timer = System.currentTimeMillis();
    }
    
    public void stopTimer(){
        timer = System.currentTimeMillis() - timer;
    }
    
}
