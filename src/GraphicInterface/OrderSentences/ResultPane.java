package GraphicInterface.OrderSentences;

import Utilities.UtilOrderSentences;
import Utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultPane extends JPanel implements ActionListener{
    RadioButtonPane radioButtonPane = new RadioButtonPane();
    UtilOrderSentences utilOrderSentences = new UtilOrderSentences();
    TextFieldPane textFieldPane = new TextFieldPane();
    JButton buttonResult = new JButton("Ok");
    JButton buttonNext = new JButton("Nächster");
    JLabel labelIcon = new JLabel();
    JLabel labelResult = new JLabel();



    public ResultPane(){

        buttonNext.addActionListener(this);
        buttonResult.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT, 10,10));

        add(buttonResult);
        add(labelIcon);
        add(labelResult);
        add(buttonNext);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonResult){
            System.out.println("textfield: "+textFieldPane.getSentence());
            System.out.println(utilOrderSentences.getSentence());
            if (textFieldPane.getSentence().equals(utilOrderSentences.getSentence())){
                setIconResult(Utilities.getImage("ok",50,50), utilOrderSentences.getSentence());
            }else{
                setIconResult(Utilities.getImage("wrong",50,50), utilOrderSentences.getSentence());
            }
        }else{
            List<String> words = new ArrayList<>();
            words = utilOrderSentences.getWords();
            Collections.shuffle(words);
            radioButtonPane.addTextJRadioButtons(words);
            textFieldPane.addJTextTextFields(words);
            System.out.println(words);
        }
    }

    public void setIconResult(ImageIcon imageIcon, String result){
        labelIcon.setIcon(imageIcon);
        labelResult.setText(result);
    }

    public void setTextFieldPane(TextFieldPane textFieldPane){
        this.textFieldPane = textFieldPane;
    }

    public void setRadioButtonPane(RadioButtonPane radioButtonPane){
        this.radioButtonPane = radioButtonPane;
    }
}

