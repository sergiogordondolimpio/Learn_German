package GraphicInterface;

import DataBase.WordsData;

public class FromDocumentListener {
    WordsData wordsData;

    public FromDocumentListener(WordsData wordsData) {
        this.wordsData = wordsData;
    }

    public WordsData getWordsData() {
        return wordsData;
    }
}
