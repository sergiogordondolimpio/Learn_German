package GraphicInterface;

import DataBase.WordsData;

import javax.swing.*;
import java.awt.*;

public class PanelArticles extends JPanel {
    UpperHalf upperHalf;
    LowerHalf lowerHalf;
    private String Word;


    public PanelArticles(){
        upperHalf = new UpperHalf();
        lowerHalf = new LowerHalf();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEtchedBorder());
        add(upperHalf);
        add(lowerHalf);



        //now the reference to the text is in the StringListener

        lowerHalf.setStringListener(new StringListener() {
            @Override
            public void textEmitted(WordsData wordsData) {
               upperHalf.appendText(wordsData);
            }
        });

        /**
         * this function make a joint between lowerHalf and UpperHalf class
         * we can use an interface like StringListener too
         * This join is important to see the change between JComponent because the
         * main panel is the only have access to the change
         */
        lowerHalf.setUpperHalf(upperHalf);

    }

}
