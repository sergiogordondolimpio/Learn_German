package Utilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Utilities {

    public static ImageIcon getImage(String path, int width, int height){
        //take the image, resize and put in the label
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(getPath(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(width, height,
                Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);
        imageIcon.getImage();
        return imageIcon;
    }


    /**
     * Return the path of the image
     * @param file
     * @return
     */
    public static String getPath(String file) {
        String path = "C:/Users/Usuario/Desktop/images/" + file + ".jpg";
        File tmpDir = new File(path);
        if (tmpDir.exists())
            return path;
        else
            return "C:/Users/Usuario/Desktop/images/not_found.jpg";
    }


}
