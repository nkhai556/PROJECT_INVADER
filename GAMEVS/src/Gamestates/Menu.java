package Gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.Graphics2D;
public class Menu implements Statemethod {

    public Rectangle playButton = new Rectangle(Panel.WIDTH/2+120,150,100,50);
    public Rectangle quitButton = new Rectangle(Panel.WIDTH/2+120,250,100,50);
    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void draw(Graphics g) {

        // TODO Auto-generated method stub
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.drawString("GAME", Panel.WIDTH/2, 100);
        g2d.draw(playButton);
        g.drawString("Play", playButton.x+20, playButton.y+20);
        g2d.draw(quitButton);
        g.drawString("Quit", quitButton.x+20, quitButton.y+20);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
