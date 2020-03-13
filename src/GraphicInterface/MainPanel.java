package GraphicInterface;

import GraphicInterface.Articles.PanelArticles;
import GraphicInterface.Praposition.PrepositionPanel;

import javax.swing.*;

/**
 * This is the Main panel with a JTabbedPane, now is only the panelArticles
 * then gonna be the other games
 */
public class MainPanel extends JTabbedPane {
    PanelArticles panelArticles = new PanelArticles();
    PrepositionPanel prepositionPanel = new PrepositionPanel();

    public MainPanel(){
        add("Die Artikel",panelArticles);
        add("Die Präposition", prepositionPanel);
    }
}
