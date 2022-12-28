package Game;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame(Panel panel) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

