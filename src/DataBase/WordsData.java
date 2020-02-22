package DataBase;

public class WordsData {
    private String word;
    private String articles;

    public WordsData(String word, String articles) {
        this.word = word;
        this.articles = articles;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getArticles() {
        return articles;
    }

    public void setArticles(String articles) {
        this.articles = articles;
    }
}
