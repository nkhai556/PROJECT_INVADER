package Entity;

import static Game.Panel.getTilesize;
import java.awt.image.BufferedImage;

import Game.CollisionChecker;
import Game.Texture;

import java.awt.*;

public class EB_Straight extends E_Bullet{
    private int speed;
    private BufferedImage sprite;
    int width = getTilesize()/2;
    int height = getTilesize()/2;

    public EB_Straight(int x, int y) {
        super.x = x;
        super.y = y;
        super.hitbox = new Rectangle (x,y,width,height);
        this.speed = 5;
        this.sprite = Texture.getE_BULLET1();
    }
    
    @Override
    public void move (){
        super.y += speed;
        super.hitbox.y += speed;
        if (CollisionChecker.playerCollisionOnBullets(this)){
            super.stateLive = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, width, height, null);
    }

    
}