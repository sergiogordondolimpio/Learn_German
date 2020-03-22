package GraphicInterface.OrderSentences;

import Utilities.UtilOrderSentences;
import Utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPane extends JPanel implements ActionListener{
    //RadioButtonPane radioButtonPane = new RadioButtonPane();
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
        JButton clicked = (JButton) e.getSource();
        if (clicked == buttonResult){
            System.out.println("textfield"+textFieldPane.getSentence());
            System.out.println(utilOrderSentences.getSentence());
            if (textFieldPane.getSentence().equals(utilOrderSentences.getSentence())){
                setIconResult(Utilities.getImage("ok",50,50), "");
            }else{
                setIconResult(Utilities.getImage("wrong",50,50), utilOrderSentences.getSentence());
            }
        }else{

        }
    }

    public void setIconResult(ImageIcon imageIcon, String result){
        labelIcon.setIcon(imageIcon);
        labelResult.setText(result);
    }

    public void setTextFieldPane(TextFieldPane textFieldPane){
        this.textFieldPane = textFieldPane;
    }
}

