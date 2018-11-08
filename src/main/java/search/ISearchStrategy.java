package search;

public interface ISearchStrategy {
    
    public abstract void prepareSearch(String text, String word);
    
    public abstract WordLocation search();
}
