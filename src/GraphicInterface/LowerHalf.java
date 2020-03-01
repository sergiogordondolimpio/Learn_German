package GraphicInterface;

import DataBase.GenerateWords;
import DataBase.ManageFile;
import DataBase.WordsData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowerHalf extends JPanel implements ActionListener{
    //that implements is for the buttons
    private JButton buttonStart = new JButton();
    private JButton buttonNext = new JButton();
    private JButton buttonPrev = new JButton();
    private JButton buttonFinish = new JButton();
    WordsData wordsDataShow = (new WordsData(null, null));
    ManageFile manageFile = new ManageFile();

    private FormListener formListener;

    private StringListener stringListener;
    //we don't need upperhalf anymore because we use the StringListener interface
    //to send the text
    private UpperHalf upperHalf = new UpperHalf();
    private GenerateWords generateWords = new GenerateWords();
    public static int i = 0;
    public static int j = 0;
    public static List<WordsData>wordsDataList = new ArrayList<WordsData>();
    public static List<WordsData> wordsDataListResult = new ArrayList<WordsData>();
    public static boolean startShuffle = true;

   public LowerHalf() {
       buttonNext.setPreferredSize(new Dimension(100, 20));
       buttonNext.setText("Nächster");
       buttonNext.setAlignmentY(Component.BOTTOM_ALIGNMENT);
       buttonNext.setVisible(false);
       buttonStart.setPreferredSize(new Dimension(100, 20));
       buttonStart.setText(" Starten");
       buttonStart.setAlignmentY(Component.BOTTOM_ALIGNMENT);
       buttonPrev.setPreferredSize(new Dimension(100, 20));
       buttonPrev.setText("  Vorig ");
       buttonPrev.setAlignmentY(Component.BOTTOM_ALIGNMENT);
       buttonPrev.setVisible(false);
       buttonFinish.setText("  Fertig ");
       buttonFinish.setAlignmentY(Component.BOTTOM_ALIGNMENT);
       buttonFinish.setVisible(false);

       //addActionListener is an implement, make access  to the function:
       //public void actionPerformed(ActionEvent e)
       buttonNext.addActionListener(this);
       buttonStart.addActionListener(this);
       buttonPrev.addActionListener(this);
       buttonFinish.addActionListener(this);

       setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
       Dimension dimension = getPreferredSize();
       dimension.height = 50;
       setPreferredSize(dimension);
       Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
       Border innerBorder = BorderFactory.createTitledBorder("");
       setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));
       add(buttonStart);
       add(buttonPrev);
       add(buttonNext);
       add(buttonFinish);
   }

    /**
     * Now we use a method to set the StringListener Interface
     *
     * public void setUpperHalf(UpperHalf upperHalf){
     *         this.upperHalf = upperHalf;
     *    }
     * this function use before makes a reference to the panel upperHalf, so can be
     * access for the buttons
     * @param listener
     */
    public void setStringListener(StringListener listener){
        this.stringListener = listener;
    }



    /**
     * Invoked when an action occurs, in the button, select what button
     * and depend the button is the action, in this case make a change
     * in the word of the label in the panel upperHalf
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == buttonNext){
            //generateResult();
            FormEvent formEvent = new FormEvent(this);
            if(formListener != null) {
                formListener.formEventOcurred(formEvent);
            }
            i++;
            //when we have ten words, you must to finish and see the result
            if ((i + 1) % 10 == 0 && i != 0 ) { buttonNext.setVisible(false); }
            if ((i - 1) % 10 == 0 ){buttonPrev.setVisible(true);}
            //upperHalf.appendText(showText());
            stringListener.textEmitted(showText());
            //System.out.println(upperHalf.getWord());
        }else if (clicked == buttonPrev){

            i--;
            if ((i + 2) % 10 == 0){buttonNext.setVisible(true);}
            if(i % 10 == 0){buttonPrev.setVisible(false);}
            //upperHalf.appendText(showText());
            stringListener.textEmitted(showText());
        }else if (clicked == buttonStart){
            //only in the first start make the shuffle
            if (startShuffle) {
                wordsDataListResultShuffle();
                startShuffle = false;
            }
            //upperHalf.appendText(showText());
            stringListener.textEmitted(showText());
            buttonFinish.setVisible(true);
            buttonStart.setVisible(false);
            buttonNext.setVisible(true);
        }else{
            buttonFinish.setVisible(false);
            buttonStart.setVisible(true);
            buttonPrev.setVisible(false);
            buttonNext.setVisible(false);
            //generateResult();
            JOptionPane.showMessageDialog(LowerHalf.this, new TextArea(showResult()), "Das Resultat", 1);


        }
    }

    /**
     * Get the list, but for the file user.csv in the desktop,
     * then the function make a shuffle
     */
    private void wordsDataListResultShuffle() {
        //wordsDataList = generateWords.getWordsDataList();
        wordsDataList = manageFile.readCsv();
        Collections.shuffle(wordsDataList);
        for (int x = 0; x < wordsDataList.size(); x++){
            wordsDataListResult.add(x, new WordsData(wordsDataList.get(x).getWord(), "Der"));
        }
    }

    /**
     * make a list with the element selected in combobox and label, so
     * we can use this list to compare the original list and see the difference
     * if we have
     */
   /* private void generateResult() {
        wordsDataListResult.set(i, new WordsData(upperHalf.getWord(),upperHalf.getArticle()));
        System.out.println("generateResult " + i + wordsDataListResult.get(i).getArticles() + wordsDataListResult.get(i).getWord());
    }

    */

    public void generateResult(String word, String article) {
        wordsDataListResult.set(i, new WordsData(word, article));
        System.out.println("generateResult " + i + wordsDataListResult.get(i).getArticles() + wordsDataListResult.get(i).getWord());
    }

    /**
     * show the result in a label when click the button finish
     */
    private String showResult() {
        String result = "";
        int countGood = 0;
        int countBad = 0;
        int l;

        if (i % 10 != 0) {
            //j save the last word, when the finish is before the tenth word
            j = i;
            //l is the first word to show, every 10 words
            l = i;
            while (l % 10 != 0){
                l--;
                System.out.println(l);
            }
            for (int k = l; k <= j; k++){
                if (wordsDataList.get(k).getArticles().equals(wordsDataListResult.get(k).getArticles())){
                    System.out.println("Es igual: " + wordsDataListResult.get(k).getArticles() + " " + wordsDataListResult.get(k).getWord());
                    result += wordsDataListResult.get(k).getArticles() + " " + wordsDataListResult.get(k).getWord() + "\n";
                    countGood++;
                }else{
                    System.out.println("Es distinto: " + wordsDataListResult.get(k).getArticles() + " " + wordsDataListResult.get(k).getWord()
                            + "\n" + wordsDataList.get(k).getArticles() + " " + wordsDataList.get(k).getWord());

                    result += wordsDataListResult.get(k).getArticles() + " " + wordsDataListResult.get(k).getWord();
                    if(wordsDataListResult.get(k).getWord().length() < 9)
                        result += "\t\t\t||\t" ;
                    else if(wordsDataListResult.get(k).getWord().length() < 14)
                        result += "\t\t||\t" ;
                    else
                        result += "\t||\t" ;
                    result += wordsDataList.get(k).getArticles() + " " + wordsDataList.get(k).getWord()
                            + "\n";
                    countBad++;
                }
            }

            result += "\nRecht : " + countGood + "     Unrecth: " + countBad;
            //return i in the next 10 word
            while (i % 10 != 0) {
                System.out.println(i);
                i++;
            }
        }
        return result;
    }

    /**
     * return the word and the artilce of the list for send to the Label
     * of panel UpperHalf, in a WordsData
     * @return
     */
    private WordsData showText() {
         wordsDataShow.setWord(wordsDataList.get(i).getWord());
         wordsDataShow.setArticles(wordsDataListResult.get(i).getArticles());

        System.out.println("showText " + i + wordsDataListResult.get(i).getArticles() + " " +
                wordsDataListResult.get(i).getWord() + " " +
                wordsDataList.get(i).getWord()
         );
         return wordsDataShow;
    }

    /**
     * this function can access to the change in the Jcomponent of UpperHalf panel
     * and is use for PanelArticles
     * @param upperHalf
     */
    public void setUpperHalf(UpperHalf upperHalf){
              this.upperHalf = upperHalf;
         }


}
