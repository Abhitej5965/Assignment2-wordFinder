package Service;

import Model.IndividualSearchResult;
import Model.SearchInput;
import Model.SearchResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordFinderImplementation implements WordFinder {
    SearchResult searchResult = new SearchResult();
    int wordFoundInFiles = 0;
    List<IndividualSearchResult> listOfIndividualSearchResults = new ArrayList<>();
    IndividualSearchResult individualSearchResult = null;

    @Override
    public SearchResult searchWord(SearchInput searchInput) {

        String word = searchInput.getWordName();

        int Flag = 0;
        File directory = new File(searchInput.getFilePath());
        File[] files = directory.listFiles();
        try {
            for (File individualFile : files) {
                if (individualFile.isFile()) {
                    int wordLength = searchInput.getWordName().length();
                    int lineNumber = 0;
                    BufferedReader br = new BufferedReader(new FileReader(individualFile));

                    String line;
                    while ((line = br.readLine()) != null) {
                        lineNumber++;
                        int lineLength = line.length();
                        for (int i = 0; i < lineLength - wordLength + 1; i++) {

                            int j = 0;
                            while (j < wordLength && line.toLowerCase().charAt(i + j) == word.toLowerCase().charAt(j)) {
                                j++;
                            }
                            if (j == wordLength) {
                                Flag++;
                                individualSearchResult = new IndividualSearchResult(word, individualFile.getName(), lineNumber, i);
                                listOfIndividualSearchResults.add(individualSearchResult);
                            }

                        }
                    }

                    if (Flag > 0) {
                        wordFoundInFiles++;
                    }
                } else if (individualFile.isDirectory()) {
                    searchInput.setWordName(searchInput.getWordName());
                    searchInput.setFilePath(individualFile.getPath());
                    searchWord(searchInput);
                }
            }


        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        searchResult.setTotalFiles(wordFoundInFiles);
        searchResult.setIndividualSearchResults(listOfIndividualSearchResults);
        return searchResult;
    }
}

