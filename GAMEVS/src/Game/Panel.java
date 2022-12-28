package Game;

import Entity.*;

import java.awt.*;
import javax.swing.*;

import Input.KeyManager;
import Input.MouseManager;

import Gamestates.Gamestate;
import Gamestates.Menu;


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
    private int tick = 0;

    static Timer timer;
    static int second=0;
    JLabel l1;
    
    public Panel() {
        Key = new KeyManager();
        this.addKeyListener(Key);
        this.addMouseListener(new MouseManager(this));
        setPanelSize();
        this.setFocusable(true);
        
        new Texture();

        this.menu = new Menu(this);
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
        this.setBackground(new Color(48, 97, 181));

    }

    public void update() {

        if(Gamestate.state == Gamestate.PLAYING){
            tick ++;
            bg.update();
            spawn.update();
            player.update();
            if (tick >= 60){
                second ++;
                tick =0;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if(Gamestate.state == Gamestate.PLAYING){
            bg.render(g);
            spawn.render(g);
            player.render(g);
        }else if (Gamestate.state == Gamestate.MENU ){
            menu.draw(g);
        }
        }

    
    
    public static int getTilesize() {
        return tilesize;
    }

    public int returnWidth(){
        return this.width;
    }

    public int returnHeight(){
        return this.height;
    }

 
    
    public static int getSecond() {
        return second;
    }
}

