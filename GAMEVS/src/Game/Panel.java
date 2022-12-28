package Game;

import Entity.*;
import java.awt.*;
import javax.swing.*;


import Input.KeyManager;
import Input.MouseManager;

public class Panel extends JPanel {

    private int height = 640;
    private int width = 524;
    private static int tilesize = 32;
    KeyManager Key;
    int xdel = 0;
    int ydel = 0;
    private Menu menu;
    private Player player;
    private BG bg;
    private EnemyManager spawn;
    
    public Panel() {
        Key = new KeyManager(this);
        this.addKeyListener(Key);
        this.addMouseListener(new MouseManager(this));
        setPanelSize();
        this.setFocusable(true);
        
        new Texture();

        this.bg = new BG(this);
        this.spawn = new EnemyManager(this);
        this.player = new Player(this, Key, spawn);
        spawn.setPlayerInfo(player);
        
    }

    

    private void setPanelSize() {
        Dimension size = new Dimension(width, height);
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
        this.setBackground(Color.gray);

    }

    public void update() {

        
            bg.update();
            spawn.update();
            player.update();
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
            bg.render(g);
            spawn.render(g);
            player.render(g);
        }

    
    
    public static int getTilesize() {
        return tilesize;
    }
}

