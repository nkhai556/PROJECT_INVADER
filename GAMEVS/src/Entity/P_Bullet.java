package Entity;

import static Game.Panel.getTilesize;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.Texture;


public class P_Bullet {

    private int x;
    private int y;
    private int speed = 15;
    private int dmg = 1;
    private Rectangle hitbox;
    private int width = getTilesize();
    private int height = getTilesize();
    

    public P_Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        hitbox = new Rectangle (x,y, width,height);

    }

    public void move() {
        
        this.y -= speed;
        this.hitbox.y -= speed;
        
    }

    public void draw(Graphics g) {
        g.drawImage(Texture.getP_BULLET(), x, y, width, height, null);
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getDamage(){
        return dmg;
    }
    public void setDamage(int dmg){
        this.dmg = dmg;
    }
    public Rectangle getHitBox(){
        return hitbox;
    }
}
