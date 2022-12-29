package Game;

import java.awt.*;

import Entity.Player;

public class UI {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Font font;
    private Panel panel;


    public UI(Panel panel) {
        this.panel = panel;
        y1 = 20;
        x1 = 0;
        x2 = panel.returnWidth() - panel.returnWidth()/4;
        y2 = 20;
        font = new Font("Serif", Font.BOLD, 20);
    }

    public void update(){
        
     } 

    public void render (Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(String.format(" HEALTH: %d",  Player.getHP()), x1, y1);
        g.drawString(String.format(" TIME: %d",  Panel.getSecond()), x2, y2);
        
    }
}

