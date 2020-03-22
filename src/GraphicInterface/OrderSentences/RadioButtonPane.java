package GraphicInterface.OrderSentences;

import Utilities.UtilOrderSentences;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class RadioButtonPane extends JPanel {
    UtilOrderSentences utilOrderSentences = new UtilOrderSentences();
    private JRadioButton radioButton1 = new JRadioButton();
    private JRadioButton radioButton2 = new JRadioButton();
    private JRadioButton radioButton3 = new JRadioButton();
    private JRadioButton radioButton4 = new JRadioButton();
    private JRadioButton radioButton5 = new JRadioButton();
    private JRadioButton radioButton6 = new JRadioButton();
    private JRadioButton radioButton7 = new JRadioButton();
    private JRadioButton radioButton8 = new JRadioButton();
    private JRadioButton radioButton9 = new JRadioButton();
    private JRadioButton radioButton10 = new JRadioButton();

    private JRadioButton[] radioButtons = new JRadioButton[]{
            radioButton1, radioButton2, radioButton3, radioButton4, radioButton5,
            radioButton6, radioButton7, radioButton8, radioButton9, radioButton10
    };

    private List<String> words = new ArrayList<>();

    public RadioButtonPane(){
        words = utilOrderSentences.getWords();
        Collections.shuffle(words);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addJRadioButtons();
        addTextJRadioButtons(words);

    }

    /**
     * Set the text of radiobuttons with every word of the sentence,
     * and set selected the first radiobutton
     * @param words
     */
    private void addTextJRadioButtons(List<String> words){
        radioButton1.setSelected(true);
        for (int i=0; i < words.size(); i++){
            radioButtons[i].setText(words.get(i));
            radioButtons[i].setVisible(true);
        }
    }

    /**
     * Add the radioButtons but not visible, then with addTextRadioButtons
     * make visible only if it has a word
     */
    private void addJRadioButtons(){
        ButtonGroup buttonGroup = new ButtonGroup();

        for (int i=0; i < 10; i++){
            buttonGroup.add(radioButtons[i]);
            radioButtons[i].setVisible(false);
            add(radioButtons[i]);
        }
    }

    /**
     * Return the word of the radioButton selected
     * @return
     */
    public String getWord(){
        String word = "";
        for (int i=0; i < words.size(); i++) {
            if (radioButtons[i].isSelected()){
                word = radioButtons[i].getText();
            }
        }
        return word;
    }

}
