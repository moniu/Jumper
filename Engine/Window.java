package Engine;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    public Window(int width, int height, String name, Game game) {
        JFrame frame = new JFrame(name);

        frame.setPreferredSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(game);
    }
    
}