package DataBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class generates a List with the class that has got the word
 * and the article
 */
public class GenerateWords {
    public List<WordsData> wordsDataList = new ArrayList<WordsData>();
    private String filePath = "C:\\Users\\Usuario\\Desktop\\users.csv";

    public List<WordsData> getWordsDataList() {
        wordsDataList.add(new WordsData("Engel", "Der"));
        wordsDataList.add(new WordsData("Film", "Der"));
        wordsDataList.add(new WordsData("Salat", "Der"));
        wordsDataList.add(new WordsData("Glass", "Das"));
        wordsDataList.add(new WordsData("Milch", "Die"));
        wordsDataList.add(new WordsData("Schublade", "Die"));
        wordsDataList.add(new WordsData("Tasse", "Die"));
        wordsDataList.add(new WordsData("Unwelt", "Die"));
        wordsDataList.add(new WordsData("Landschaft", "Die"));
        wordsDataList.add(new WordsData("Orange", "Die"));
        wordsDataList.add(new WordsData("Arbeit", "Die"));
        wordsDataList.add(new WordsData("Stadt", "Die"));
        wordsDataList.add(new WordsData("Banane", "Die"));
        wordsDataList.add(new WordsData("Birne", "Die"));
        wordsDataList.add(new WordsData("Butter", "Die"));
        wordsDataList.add(new WordsData("Cola", "Die"));
        wordsDataList.add(new WordsData("Pommes", "Die"));
        wordsDataList.add(new WordsData("Apfelschorle", "Die"));
        wordsDataList.add(new WordsData("E-mail", "Die"));
        wordsDataList.add(new WordsData("Nachtish", "Der"));
        wordsDataList.add(new WordsData("Teller", "Der"));
        wordsDataList.add(new WordsData("Schrank", "Der"));
        wordsDataList.add(new WordsData("Schrank", "Der"));
        wordsDataList.add(new WordsData("Urlaub", "Der"));
        wordsDataList.add(new WordsData("Vormittag", "Der"));
        wordsDataList.add(new WordsData("Geburstag", "Der"));
        wordsDataList.add(new WordsData("Sekt", "Der"));
        wordsDataList.add(new WordsData("Boden", "Der"));
        wordsDataList.add(new WordsData("Müll", "Der"));
        wordsDataList.add(new WordsData("Fluss", "Der"));
        wordsDataList.add(new WordsData("Preis", "Der"));
        wordsDataList.add(new WordsData("See", "Der"));
        wordsDataList.add(new WordsData("Apfel", "Der"));
        wordsDataList.add(new WordsData("Kaffe", "Der"));
        wordsDataList.add(new WordsData("Obstsalat", "Der"));
        wordsDataList.add(new WordsData("Schinker", "Der"));
        wordsDataList.add(new WordsData("Tee", "Der"));
        wordsDataList.add(new WordsData("Zucker", "Der"));
        wordsDataList.add(new WordsData("Kino", "Das"));
        wordsDataList.add(new WordsData("Messer", "Das"));
        wordsDataList.add(new WordsData("Regal", "Das"));
        wordsDataList.add(new WordsData("Tisch", "Das"));
        wordsDataList.add(new WordsData("Benzin", "Das"));
        wordsDataList.add(new WordsData("Fahrrad", "Das"));
        wordsDataList.add(new WordsData("Grillfleisch", "Das"));
        wordsDataList.add(new WordsData("Dorf", "Das"));
        wordsDataList.add(new WordsData("Sofa", "Das"));
        wordsDataList.add(new WordsData("Konzert", "Das"));
        wordsDataList.add(new WordsData("Kleid", "Das"));
        wordsDataList.add(new WordsData("Angebot", "Das"));
        wordsDataList.add(new WordsData("Museum", "Das"));
        wordsDataList.add(new WordsData("Ei", "Das"));
        wordsDataList.add(new WordsData("Brötchen", "Das"));
        wordsDataList.add(new WordsData("Brot", "Das"));
        wordsDataList.add(new WordsData("Bier", "Das"));

        //here make a schuffle of the list
        Collections.shuffle(wordsDataList);
        //manageFile.writeCsv(filePath,wordsDataList);
        return wordsDataList;
    }

    /**
     * this function return a schuffle of the list
     * @param wordsDataList
     */
    public void setWordsDataList(List<WordsData> wordsDataList) {

        this.wordsDataList = wordsDataList;
    }

}
