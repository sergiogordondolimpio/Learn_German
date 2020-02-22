package GraphicInterface;

import DataBase.GenerateWords;
import DataBase.WordsData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    public void showMenu(){


        JFrame frame = new JFrame("Lernen Deutsch");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.add(tabbedPanel());


    }

    private Component tabbedPanel() {
        JTabbedPane tabbedPanel = new JTabbedPane();
        tabbedPanel.add("Die Artikel",panelArticles());
        return tabbedPanel;
    }

    private Component panelArticles() {
        JPanel panelArticles = new JPanel();
        CardLayout cardLayout = new CardLayout();
        panelArticles.setLayout(cardLayout);
        panelArticles.add(panelStart(), "1");
        panelArticles.add(panelFinish(),"2");
        cardLayout.show(panelArticles,"1");
        return panelArticles;
    }

    //this gonna show the results with the corrections
    private Component panelFinish() {
        JPanel panelFinish = new JPanel();

        return panelFinish;
    }

    //the first panel with the start button
    private Component panelStart() {
        JPanel panelStart = new JPanel();

        panelStart.setLayout(new BoxLayout(panelStart, BoxLayout.Y_AXIS));
        panelStart.add(upperHalf());
        panelStart.add(lowerHalf());

        return panelStart;
    }

    //the lower half with the buttons
    private Component lowerHalf() {
        JPanel lowerHalf = new JPanel();
        JButton buttonStart = new JButton();
        JButton buttonNext = new JButton();
        JButton buttonPrev = new JButton();

        buttonNext.setPreferredSize(new Dimension(100,20));
        buttonNext.setText("Nächster");
        buttonNext.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        buttonStart.setPreferredSize(new Dimension(100,20));
        buttonStart.setText(" Starten");
        buttonStart.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        buttonPrev.setPreferredSize(new Dimension(100,20));
        buttonPrev.setText("  Vorig ");
        buttonPrev.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        buttonStart.addActionListener(new ChangeText());

        lowerHalf.setLayout(new BoxLayout(lowerHalf,BoxLayout.LINE_AXIS));
        lowerHalf.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        lowerHalf.add(buttonNext);
        lowerHalf.add(buttonStart);
        lowerHalf.add(buttonPrev);
        return lowerHalf;

    }



    //this panel has the word with the article in the top
    //and the image in the bottom
    private Component upperHalf(){
        JPanel upperHalf = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JComboBox comboBoxArticles = new JComboBox();
        Label textWord = new Label();


        List<WordsData> wordsDataList = new ArrayList<WordsData>();
        GenerateWords generateWords = new GenerateWords();
        //String text = wordsDataList.get(1).getWord();
        String text = "Hola";

        //can be select the article in this combobox
        comboBoxArticles.setPreferredSize(new Dimension(50,50));
        comboBoxArticles.addItem("DER");
        comboBoxArticles.addItem("DIE");
        comboBoxArticles.addItem("DAS");
        comboBoxArticles.setBackground(Color.WHITE);
        textWord.setPreferredSize(new Dimension(100,50));
        textWord.setBackground(Color.WHITE);
        textWord.setAlignment(Label.CENTER);
        textWord.setText(text);
        topPanel.setLayout(new FlowLayout());
        topPanel.setMaximumSize(new Dimension(500,100));
        topPanel.add(comboBoxArticles);
        topPanel.add(textWord);

        //take the image, resize and put in the label
        JLabel imageLabel = new JLabel();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("C:/Users/Usuario/IdeaProjects/Learn German/images/engel.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(150, 200,
                Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);
        imageIcon.getImage();
        imageLabel.setIcon(imageIcon);
        //put the label in the bottom panel
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(imageLabel);

        upperHalf.setLayout(new BoxLayout(upperHalf, BoxLayout.Y_AXIS));
        upperHalf.setPreferredSize(new Dimension(500,350));
        upperHalf.add(topPanel);
        upperHalf.add(bottomPanel);
        return upperHalf;
    }

    private class ChangeText implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
