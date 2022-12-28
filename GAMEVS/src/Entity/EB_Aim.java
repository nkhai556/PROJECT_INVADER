package Entity;

import static Game.Panel.getTilesize;
import java.awt.image.BufferedImage;

import Game.CollisionChecker;
import Game.Texture;

import java.awt.*;

public class EB_Aim extends E_Bullet{
    
    private int speed;
    private BufferedImage sprite;
    int width = (int)(getTilesize()* 0.75);
    int height = (int)(getTilesize() * 0.75);
    private double angle;
    
    public EB_Aim(int x, int y, int Px, int Py) {
        super.x = x;
        super.y = y;
        super.hitbox = new Rectangle (x,y,width,height);
        this.speed = 7;
        aiming(Py, Px);
        this.sprite = Texture.getE_BULLET1();
    }
    
    @Override
    public void move (){
        super.y += speed * Math.sin(angle);
        super.x += speed * Math.cos(angle);
        super.hitbox.y += speed * Math.sin(angle);
        super.hitbox.x += speed * Math.cos(angle);
        if (CollisionChecker.playerCollisionOnBullets(this)){
            super.stateLive = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, width, height, null);
    }

    private void aiming(int Py, int Px){
        angle = Math.atan2(Py - y, Px - x) - 0.05;
    }
}
