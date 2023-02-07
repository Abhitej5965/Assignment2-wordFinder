package org.Main;

import Model.SearchInput;
import Model.SearchResult;
import Service.WordFinderImplementation;

public class Main {
    public static void main(String[] args) {
        WordFinderImplementation wordFinder = new WordFinderImplementation();
        SearchInput searchInput = new SearchInput("platform", "/home/abhitejk_500313/Desktop/ImportantFolders/ImportantFiles");
        SearchResult result = wordFinder.searchWord(searchInput);
        System.out.println(result);
    }
}