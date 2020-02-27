package GraphicInterface;

import DataBase.GenerateWords;
import DataBase.WordsData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UpperHalf extends JPanel {
    private JComboBox comboBoxArticles = new JComboBox();
    private Label textWord = new Label();
    private String article;
    private String word;
    private LowerHalf lowerHalf;



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
        textWord.setPreferredSize(new Dimension(100, 50));
        textWord.setBackground(Color.WHITE);
        textWord.setAlignment(Label.CENTER);
        //textWord.setText(text);
        setLayout(new FlowLayout());
        Dimension dimension = getPreferredSize();
        dimension.height = 400;
        setPreferredSize(dimension);
        add(comboBoxArticles);
        add(textWord);


        //take the image, resize and put in the label
        JLabel imageLabel = new JLabel();
       /* BufferedImage img = null;
        try {
            img = ImageIO.read(new File("C:/Users/Usuario/IdeaProjects/Learn German/images/engel.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(150, 200,
                Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);
        imageIcon.getImage();
        imageLabel.setIcon(imageIcon);*/
        //put the label in the bottom panel
        //bottomPanel.setLayout(new FlowLayout());
        //bottomPanel.add(imageLabel);

    }

    /**
     * this function changes the word in the label
     * @param text
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
