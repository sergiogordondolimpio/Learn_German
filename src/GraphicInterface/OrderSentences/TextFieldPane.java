package GraphicInterface.OrderSentences;

import Utilities.UtilOrderSentences;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TextFieldPane extends JPanel {
    UtilOrderSentences utilOrderSentences = new UtilOrderSentences();
    RadioButtonPane radioButtonPane = new RadioButtonPane();

    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextField textField5 = new JTextField();
    JTextField textField6 = new JTextField();
    JTextField textField7 = new JTextField();
    JTextField textField8 = new JTextField();
    JTextField textField9 = new JTextField();
    JTextField textField10 = new JTextField();

    JTextField[] textFields = new JTextField[]{
            textField1, textField2, textField3, textField4, textField5,
            textField6, textField7, textField8, textField9, textField10
    };

    public TextFieldPane() {

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addTextFields();
        addJTextTextFields();
    }

    private void addTextFields(){
        for (int i = 0; i < 10; i++) {
            textFields[i].setVisible(false);
            add(textFields[i]);
        }
    }

    /**
     * Add text to the textFields and make it visible, and set the
     * preferences and the mauseListener, this listener is use when the
     * textFields is click, in this case set the text to the textField, this
     * text is get for the text of the radioButton selected
     */
    private void addJTextTextFields() {
        List<String> words = utilOrderSentences.getWords();
        for (int i = 0; i < words.size(); i++) {
            textFields[i].setVisible(true);
            textFields[i].setColumns(10);
            textFields[i].setHorizontalAlignment(JTextField.CENTER);
            textFields[i].setEditable(false);
            int finalI = i;
            textFields[i].addMouseListener(new MouseAdapter() {
                /**
                 * {@inheritDoc}
                 *
                 * @param e
                 */
                @Override
                public void mouseClicked(MouseEvent e) {
                        textFields[finalI].setText(radioButtonPane.getWord());
                }
            });
        }
    }


    public void setRadioButtonPane(RadioButtonPane radioButtonPane) {
        this.radioButtonPane = radioButtonPane;
    }

    /**
     * Return a string with the sentence complete
     * @return
     */
    public String getSentence () {
        String sentence = "";
        for (int i = 0; i < 10; i++) {
            if (textFields[i].isVisible() == true) {
                sentence += textFields[i].getText() + " ";
            }
        }
        sentence = sentence.substring(0, sentence.length() - 1);
        return sentence;
    }

}
