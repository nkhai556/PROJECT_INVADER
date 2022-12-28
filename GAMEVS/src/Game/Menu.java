package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;

import java.awt.Rectangle;
import java.awt.Graphics2D;
public class Menu {

    public Rectangle playButton = new Rectangle(Panel.WIDTH/2+120,150,100,50);


    public void update() {
        
        
    }


    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.drawString("GAME", Panel.WIDTH/2, 100);
        g2d.draw(playButton);
        g.drawString("Play", playButton.x+20, playButton.y+20);

        
    }
}
