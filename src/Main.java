import GraphicInterface.MainFrame;

import javax.swing.*;
import java.applet.Applet;

public class Main extends Applet {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();

            }
        });
    }
}
