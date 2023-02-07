package org.Main;

import Model.IndividualSearchResult;
import Model.SearchInput;
import Model.SearchResult;
import Service.WordFinderImplementation;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.*;

public class WordFinderImplementationTest {

    @Test
    public void TestWordFinder() {
        IndividualSearchResult individualSearchResult1 = new IndividualSearchResult("platform", "file3.txt", 1, 90);
        IndividualSearchResult individualSearchResult2 = new IndividualSearchResult("platform", "file3.txt", 3, 67);
        IndividualSearchResult individualSearchResult3 = new IndividualSearchResult("platform", "file3.txt", 7, 56);
        IndividualSearchResult individualSearchResult4 = new IndividualSearchResult("platform", "file3.txt", 7, 267);
        IndividualSearchResult individualSearchResult5 = new IndividualSearchResult("platform", "file2.txt", 1, 37);
        IndividualSearchResult individualSearchResult6 = new IndividualSearchResult("platform", "file2.txt", 1, 271);
        IndividualSearchResult individualSearchResult7 = new IndividualSearchResult("platform", "file1.txt", 1, 47);
        IndividualSearchResult individualSearchResult8 = new IndividualSearchResult("platform", "file1.txt", 1, 95);
        IndividualSearchResult individualSearchResult9 = new IndividualSearchResult("platform", "file1.txt", 1, 209);
        IndividualSearchResult individualSearchResult10 = new IndividualSearchResult("platform", "file1.txt", 2, 10);
        IndividualSearchResult individualSearchResult11 = new IndividualSearchResult("platform", "file1.txt", 2, 105);
        IndividualSearchResult individualSearchResult12 = new IndividualSearchResult("platform", "file1.txt", 3, 19);
        List<IndividualSearchResult> listIndividualSearchResult = new ArrayList<>();
        listIndividualSearchResult.add(individualSearchResult1);
        listIndividualSearchResult.add(individualSearchResult2);
        listIndividualSearchResult.add(individualSearchResult3);
        listIndividualSearchResult.add(individualSearchResult4);
        listIndividualSearchResult.add(individualSearchResult5);
        listIndividualSearchResult.add(individualSearchResult6);
        listIndividualSearchResult.add(individualSearchResult7);
        listIndividualSearchResult.add(individualSearchResult8);
        listIndividualSearchResult.add(individualSearchResult9);
        listIndividualSearchResult.add(individualSearchResult10);
        listIndividualSearchResult.add(individualSearchResult11);
        listIndividualSearchResult.add(individualSearchResult12);
        SearchResult searchResult = new SearchResult(3, listIndividualSearchResult);
        System.out.println(searchResult);
        SearchInput searchInput = new SearchInput("platform", "/home/abhitejk_500313/Desktop/ImportantFolders/ImportantFiles");
        WordFinderImplementation wordFinderImplementation = new WordFinderImplementation();
        Assert.assertEquals(searchResult.toString().trim(), wordFinderImplementation.searchWord(searchInput).toString().trim());
    }

}