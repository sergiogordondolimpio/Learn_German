package Utilities;

import DataBase.ManageFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilOrderSentences {
    private List<String> sentences = new ArrayList<>();
    private int count = 0;
    private List<String> words = new ArrayList<>();

    public UtilOrderSentences(){
        sentences = ManageFile.readSentencesCsv("C:/Users/Usuario/Desktop/usersSentences.csv");
    }

    /**
     * Get the List of sentences of the file, and make a List
     * of the words of the sentences.
     * the count is counting every sentences that was split
     * @return words
     */
    public List<String> getWords(){
        words = Arrays.asList(sentences.get(count).split(" "));
        count++;
        return words;
    }

    /**
     * Return the sentences without split
     * @return
     */
    public String getSentence(){
        return sentences.get(count);
    }


}
