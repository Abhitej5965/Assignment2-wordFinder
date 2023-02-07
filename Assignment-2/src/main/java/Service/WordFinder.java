package Service;

import Model.SearchInput;
import Model.SearchResult;

public interface WordFinder {
    public SearchResult searchWord(SearchInput searchInput);
}
