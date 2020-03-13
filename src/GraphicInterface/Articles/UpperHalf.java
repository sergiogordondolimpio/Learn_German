package GraphicInterface.Articles;

import DataBase.GenerateWords;
import DataBase.WordsData;
import Utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UpperHalf extends JPanel implements ActionListener {
    private JComboBox comboBoxArticles = new JComboBox();
    private Label textWord = new Label();
    private JLabel imageLabel;
    private String article;
    private String word;
    private LowerHalf lowerHalf;
    private JButton buttonShow = new JButton();



    List<WordsData> wordsDataList = new ArrayList<WordsData>();
    GenerateWords generateWords = new GenerateWords();
    //String text = wordsDataList.get(1).getWord();
    public UpperHalf() {

        //can be select the article in this combobox
        comboBoxArticles.setPreferredSize(new Dimension(50, 50));
        comboBoxArticles.addItem("Der");
        comboBoxArticles.addItem("Die");
        comboBoxArticles.addItem("Das");
        comboBoxArticles.setBackground(Color.WHITE);

        //set up textWord
        textWord.setPreferredSize(new Dimension(100, 50));
        textWord.setBackground(Color.WHITE);
        textWord.setAlignment(Label.CENTER);

        //set up imageLabel
        imageLabel = new JLabel(Utilities.getImage(getWord(), 150, 200));
        imageLabel.setPreferredSize(new Dimension(150, 100));
        imageLabel.setBackground(Color.WHITE);

        //set buttonShow
        buttonShow.setPreferredSize(new Dimension(20,15));
        buttonShow.setIcon(Utilities.getImage("icon_visible", 20, 15));
        buttonShow.addActionListener(this);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        Dimension dimension = getPreferredSize();
        dimension.height = 300;
        setPreferredSize(dimension);

        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(5,0,0,5);
        add(comboBoxArticles, constraints);


        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(5,5,0,0);
        add(textWord, constraints);


        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.ipady = 120;      //make this component tall
        constraints.ipadx = 100;
        constraints.gridwidth = 0;
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(imageLabel, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.gridwidth = 0;
        constraints.ipady = 5;      //make this component tall
        constraints.ipadx = 5;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(2,130,70,0);
        add(buttonShow, constraints);



    }

    /**
    * Insert the image of the word in the label
    */
    @Override
    public void actionPerformed(ActionEvent event){
        this.imageLabel.setIcon(Utilities.getImage(getWord(),150,200));
    }


    /**
     * this function changes the word in the label
     */
    public void appendText(WordsData wordsData){
        textWord.setText(wordsData.getWord());
        comboBoxArticles.setSelectedItem(wordsData.getArticles());
    }

    /**
     * this function return to the LowerHalf the word of the label
     * @return
     */
    public String getWord() {
        return  textWord.getText();
    }

    /**
     * this function return to the LowerHalf the article in the combobox
     */
    public String getArticle(){
        return comboBoxArticles.getSelectedItem().toString();
    }






}
