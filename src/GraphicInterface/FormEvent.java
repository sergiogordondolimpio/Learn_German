package GraphicInterface;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String article;
    private String word;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String article, String word) {
        super(source);

        this.article = article;
        this.word = word;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
