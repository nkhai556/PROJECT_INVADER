package Gamestates;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.Format;

import Game.Panel;

public class GameOver implements Statemethod {

    private Font titleFont;
    private Font timeFont;
    private Panel panel;
    private int time;
    public Rectangle retryButton;
    public GameOver (Panel panel2){
        this.panel = panel2;
        this.titleFont = new Font("Serif", Font.BOLD, 40);
        this.timeFont = new Font("Serif", Font.BOLD, 20);
        retryButton = new Rectangle(panel.returnWidth()/2 - panel.returnWidth()/8 ,150,100,50);
        
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void draw(Graphics g) {
        this.time = Panel.getSecond();
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.setFont(titleFont);
        g.drawString("YOU HAD FALLEN", panel.returnWidth()/2 - panel.returnWidth()/3, panel.returnHeight()/2 -20);
        g.setFont(timeFont);
        g.drawString(String.format("You've survived for %d seconds...", time), panel.returnWidth()/4, panel.returnHeight()/2 + 20);
        g.drawString(String.format("Try again?"), panel.returnWidth()/4+100, panel.returnHeight()/2 + 40);
        
        g2d.draw(retryButton);
        g.drawString("Retry", retryButton.x +20, retryButton.y+30);
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
