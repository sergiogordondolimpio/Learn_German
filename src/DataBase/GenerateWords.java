package DataBase;

import java.util.ArrayList;
import java.util.List;

/**
 * This class generates a List with the class that has got the word
 * and the article
 */
public class GenerateWords {
    public List<WordsData> wordsDataList = new ArrayList<WordsData>();

    public List<WordsData> getWordsDataList() {
        wordsDataList.add(new WordsData("Engel", "Der"));
        wordsDataList.add(new WordsData("Film", "Der"));
        wordsDataList.add(new WordsData("Salat", "Der"));
        wordsDataList.add(new WordsData("Glass", "Das"));
        wordsDataList.add(new WordsData("Milch", "Die"));
        return wordsDataList;
    }

    public void setWordsDataList(List<WordsData> wordsDataList) {
        this.wordsDataList = wordsDataList;
    }
}
