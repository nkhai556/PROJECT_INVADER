package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Game.Panel;


public class KeyManager implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, shootPressed;
    private Panel panel;

    public KeyManager(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
            int code = e.getKeyCode();
            switch (code) {
                case KeyEvent.VK_A -> leftPressed = true;
                case KeyEvent.VK_S -> downPressed = true;
                case KeyEvent.VK_D -> rightPressed = true;
                case KeyEvent.VK_W -> upPressed = true;
                case KeyEvent.VK_UP -> upPressed = true;
                case KeyEvent.VK_DOWN -> downPressed = true;
                case KeyEvent.VK_LEFT -> leftPressed = true;
                case KeyEvent.VK_RIGHT -> rightPressed = true;
                case KeyEvent.VK_J -> shootPressed = true;
        }
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
            int code = e.getKeyCode();
            switch (code) {
                case KeyEvent.VK_A -> leftPressed = false;
                case KeyEvent.VK_S -> downPressed = false;
                case KeyEvent.VK_D -> rightPressed = false;
                case KeyEvent.VK_W -> upPressed = false;
                case KeyEvent.VK_UP -> upPressed = false;
                case KeyEvent.VK_DOWN -> downPressed = false;
                case KeyEvent.VK_LEFT -> leftPressed = false;
                case KeyEvent.VK_RIGHT -> rightPressed = false;
                case KeyEvent.VK_J -> shootPressed = false;
            }
        
    }

}