package GraphicInterface;

import GraphicInterface.Articles.PanelArticles;
import GraphicInterface.OrderSentences.OrderSentences;
import GraphicInterface.Praposition.PrepositionPanel;

import javax.swing.*;

/**
 * This is the Main panel with a JTabbedPane, now is only the panelArticles
 * then gonna be the other games
 */
public class MainPanel extends JTabbedPane {
    PanelArticles panelArticles = new PanelArticles();
    PrepositionPanel prepositionPanel = new PrepositionPanel();
    OrderSentences orderSentences = new OrderSentences();

    public MainPanel(){
        add("Die Artikel",panelArticles);
        add("Die Präposition", prepositionPanel);
        add("Satz bestellen", orderSentences);
    }
}
