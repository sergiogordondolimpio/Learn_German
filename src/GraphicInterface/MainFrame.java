package GraphicInterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private MainPanel mainPanel;
    /**
     * This constructor make the main frame and this characteristics
     * To see different types of Layout: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
     */
    public MainFrame(){
        super("Lernen Deutsch");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        setLayout(new BorderLayout());

        mainPanel = new MainPanel();
        add(mainPanel);
    }
}
