package GraphicInterface.OrderSentences;

import Utilities.UtilOrderSentences;

import javax.swing.*;

public class OrderSentences extends JPanel {
    ResultPane resultPane = new ResultPane();
    UtilOrderSentences utilOrderSentences = new UtilOrderSentences();
    ButtonPane buttonPane = new ButtonPane();
    TextFieldPane textfieldPane = new TextFieldPane();
    RadioButtonPane radioButtonPane = new RadioButtonPane();

    public OrderSentences(){

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(radioButtonPane);
        add(textfieldPane);
        //add(buttonPane);
        add(resultPane);

        textfieldPane.setRadioButtonPane(radioButtonPane);
        resultPane.setTextFieldPane(textfieldPane);
    }



}
