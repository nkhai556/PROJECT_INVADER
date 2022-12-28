package Gamestates;


import java.awt.*;
import Game.Panel;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Menu implements Statemethod {

    private Panel panel;
    public Rectangle playButton;
    public Rectangle quitButton;
    private Font menuFont;
    private Font buttonFont;
    

    public Menu (Panel panel2){
        this.panel = panel2;
        playButton = new Rectangle(panel.returnWidth()/2 - panel.returnWidth()/8 ,150,100,50);
        quitButton = new Rectangle(panel.returnWidth()/2 - panel.returnWidth()/8,250,100,50);
        menuFont = new Font("Serif", Font.BOLD, 40);
        buttonFont = new Font ("Serif", Font.BOLD, 30);
    }
    
    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void draw(Graphics g) {

        // TODO Auto-generated method stub
        Graphics2D g2d = (Graphics2D) g;
        g.setFont(menuFont);
        g.setColor(Color.WHITE);
        g.drawString("Yokai Hunt", panel.getWidth()/4 + panel.getWidth()/12, 100);
        g.setFont(buttonFont);
        g2d.draw(playButton);
        g.drawString("Play", playButton.x +20, playButton.y+30);
        g2d.draw(quitButton);
        g.drawString("Quit", quitButton.x +20, quitButton.y+30);
        
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
