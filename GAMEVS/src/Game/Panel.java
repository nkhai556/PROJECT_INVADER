package Game;

import Entity.*;

import java.awt.*;
import javax.swing.*;

import Input.KeyManager;
import Input.MouseManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gamestates.Gamestate;
import Gamestates.Menu;
import Gamestates.MouseInput;
import Gamestates.Gamestate.*;


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

    static Timer timer;
    static int second=0;
    JLabel l1;
    
    public Panel() {
        Key = new KeyManager(this);
        this.addKeyListener(Key);
        this.addMouseListener(new MouseManager(this));
        setPanelSize();
        this.setFocusable(true);
        
        new Texture();
        write();
        simpleTimer();
        timer.start();

        menu = new Menu();
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

        if(Gamestate.state == Gamestate.PLAYING){
            bg.update();
            spawn.update();
            player.update();
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


    public static void stopTimer(){
        timer.stop();
    }

    public void simpleTimer(){
        timer = new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                    second++;
                
                
                l1.setText(""+ second);
                
            }
        });
    };
    
    private void write(){

        l1= new JLabel("");
        l1.setBounds(500,600,300,400);
        this.add(l1);
    }



    public static int getSecond() {
        return second;
    }
}

