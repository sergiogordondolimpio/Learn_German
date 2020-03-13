package GraphicInterface.Praposition;

import DataBase.ManageFile;
import DataBase.WordsData;
import Utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class PrepositionPanel extends JPanel implements ActionListener, MouseListener {
    //Jcomponents of the panelResult
    private JLabel labelResult = new JLabel();
    private JLabel labelImage = new JLabel();
    private JButton buttonResult = new JButton();
    private JButton buttonNext = new JButton();

    //Component of panelInformation
    private JButton buttonArticles = new JButton();
    private JLabel labelImageInformation = new JLabel();
    private JLabel labelWord = new JLabel();

    //an array of articles to add in the sentenceToCorrect
    private String articles[] = new String[] {
            "der","die","das","den", "dem", "des"
    };
    //list of word with article
    private List<WordsData> wordsDataList = new ArrayList<>();

    private String sentenceToCorrect = "";
    private String sentenceCorrect = "";
    //list of the sentences
    private List<String> sentencesCorrect = new ArrayList<>();
    //this array is gonna be an split of the words in the sentenceCorrect
    private String wordsOfSentence[] = new String[20];
    private int countOfSentences = 0;

    //textfields of the panelExercise
    JTextField jTextField1 = new JTextField();
    JTextField jTextField2 = new JTextField();
    JTextField jTextField3 = new JTextField();
    JTextField jTextField4 = new JTextField();
    JTextField jTextField5 = new JTextField();
    JTextField jTextField6 = new JTextField();
    JTextField jTextField7 = new JTextField();
    JTextField jTextField8 = new JTextField();
    JTextField jTextField9 = new JTextField();
    JTextField jTextField10 = new JTextField();
    JTextField jTextFields[] = {jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7
                        ,jTextField8,jTextField9,jTextField10};

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public PrepositionPanel() {
        sentencesCorrect = ManageFile.readPrepositionCsv("C:\\Users\\Usuario\\Desktop\\usersPrepositions.csv");
        wordsDataList = ManageFile.readCsv("C:\\Users\\Usuario\\Desktop\\users.csv");
        Collections.shuffle(sentencesCorrect);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(panelExercise());
        add(panelResult());
        add(panelInformation());
    }

    private JPanel panelInformation() {
        JPanel panelInformation = new JPanel();
        panelInformation.setLayout(new GridBagLayout());

        buttonArticles.setText("Artikle");
        buttonArticles.setPreferredSize(new Dimension(80,30));
        buttonArticles.addActionListener(this);

        labelWord.setPreferredSize(new Dimension(80,30));
        labelWord.setOpaque(true);
        labelWord.setBackground(Color.white);
        labelWord.setText("word");

        labelImageInformation.setPreferredSize(new Dimension(100,100));
        labelImageInformation.setOpaque(true);
        labelImageInformation.setBackground(Color.white);

        Insets insets = new Insets(100, 20, 10, 20);
        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0.1, 0.1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        panelInformation.add(buttonArticles, gbc);

        insets.set(10,20,100,20);
        gbc = new GridBagConstraints(0, 1, 1, 1, 0.1, 0.1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        panelInformation.add(labelWord, gbc);


        insets.set(30,20,30,20);
        gbc = new GridBagConstraints(1, 0, 1, 2, 0.2, 0.2,
              GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        panelInformation.add(labelImageInformation, gbc);

        return panelInformation;
    }


    private JPanel panelResult () {
            JPanel panelResult = new JPanel();
            panelResult.setPreferredSize(new Dimension(200, 100));

            //set button
            buttonNext.setText("Nächster");
            buttonNext.addActionListener(this);
            buttonResult.setText("Ok");
            buttonResult.addActionListener(this);


            panelResult.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            panelResult.add(buttonResult);
            panelResult.add(buttonNext);
            panelResult.add(labelImage);
            panelResult.add(labelResult);

            return panelResult;
        }

        private JPanel panelExercise () {
            JPanel panelExercise = new JPanel();
            panelExercise.setPreferredSize(new Dimension(200, 100));
            panelExercise.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

            //only add the textfields but not visible
            for (int i = 0; i < 10; i++) {
                panelExercise.add(jTextFields[i]);
                jTextFields[i].setVisible(false);
            }

        return panelExercise;
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == buttonResult) {
            labelResult.setText(sentenceCorrect);
            getSentenceToCorrect();
            setLabelImage();
            sentenceToCorrect = "";
        }else if (clicked == buttonNext){
            //obtain an array with every word of the sentence
            wordsOfSentence = sentencesCorrect.get(countOfSentences).split(" ");
            sentenceCorrect = sentencesCorrect.get(countOfSentences);
            countOfSentences++;

            //for of the textfield creation of words
            for (int i = 0; i < 10; i++) {
                if (i < wordsOfSentence.length) {
                    jTextFields[i].setVisible(true);
                    customizeTextFields(i, wordsOfSentence[i]);

                    this.revalidate();
                    this.repaint();
                }else{
                    jTextFields[i].setVisible(false);
                }
            }
        }else{
            labelImageInformation.setIcon(Utilities.getImage("artikle",labelImageInformation.getWidth(), labelImageInformation.getHeight()));
        }
    }

    /**
     * Set the size, alignment and editable of the array of jtextfiel.
     * If the word is an article, set the dimension and make editable
     * @param i
     * @param word
     */
    private void customizeTextFields(int i, String word) {
        jTextFields[i].setHorizontalAlignment(JTextField.CENTER);
        jTextFields[i].addMouseListener(this);
        if (Arrays.asList(articles).contains(word)) {
            jTextFields[i].setPreferredSize(new Dimension(50,20));
            jTextFields[i].setText(articles[0]);
            jTextFields[i].setEditable(true);
        }else {
            jTextFields[i].setText(word);
            jTextFields[i].setEditable(false);
            jTextFields[i].setColumns(word.length() + 2);
        }

    }


    /**
     * Set the image to the labelImage, if is correct the sentence show
     * an ok sign
     */
    private void setLabelImage(){
        if (sentenceToCorrect.equals(sentenceCorrect)){
            labelImage.setIcon(Utilities.getImage("ok",50,50));
        }else{
            labelImage.setIcon(Utilities.getImage("wrong",50,50));
        }
    }

    /**
     * get the sentence adding every word of the textfields, that sentence is
     * complete with the article that put the user
     * @return
     */
    private String getSentenceToCorrect(){
        for (int i = 0; i < wordsOfSentence.length; i++){
            sentenceToCorrect += jTextFields[i].getText();
            if (!(i + 1 == wordsOfSentence.length)){
                sentenceToCorrect+= " ";
            }
        }
        return sentenceToCorrect;
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        JTextField component = (JTextField)e.getSource();

        for (int i = 0; i < 10; i++) {
            //search what component is clicked
            if (component == jTextFields[i]){
                //if the component has an articles clear the text
                if (Arrays.asList(articles).contains(jTextFields[i].getText())) {
                    jTextFields[i].setText("");
                }else {
                   //show the article of the word, definition, image, etc
                    for (WordsData wordsData:wordsDataList) {
                        if (wordsData.getWord().equals(jTextFields[i].getText())) {
                                labelWord.setText(
                                        wordsData.getArticles() + " " +
                                        wordsData.getWord());
                                labelImageInformation.setIcon(Utilities.getImage(wordsData.getWord(),
                                        labelImageInformation.getWidth(), labelImageInformation.getHeight()));
                                continue;
                        }
                    }
                }
            }
        }
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
