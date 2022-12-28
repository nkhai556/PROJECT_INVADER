package Entity;


import static Game.Panel.getTilesize;
import static Game.Texture.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.awt.*;

public class E_Basic extends Enemy implements Villians {

    private int speed = 2;
    private BufferedImage sprite;
    private int width = getTilesize() * 3/2;
    private int height = getTilesize() * 3/2;
    
    
    

    public E_Basic(int x, int y, int limit) {
        super.x = x;
        super.y = y;
        super.HP = 3;
        this.sprite = getE_BASIC();
        super.hurtbox = new Rectangle(x,y, width, height);
        super.limit = limit;
        super.bullets = new LinkedList<>();
    }
    

    @Override
    public void shoot() {
        E_Bullet tempBullet;
        for (int i = 0; i < bullets.size(); i++) {
            tempBullet = bullets.get(i);
            if (tempBullet.stateLive != true){
                removeBullet(tempBullet);
                Player.Damaged();
            } 
            if (tempBullet.getY() > limit) {
                removeBullet(tempBullet);
            }
            tempBullet.move();
        }
        if (cooldown >= 120){
            addBullet();
            cooldown = 0;
        }
    }

    @Override
    public void move() {
        
        y+= speed;
        hurtbox.y += speed;
        cooldown ++;
        shoot();
        
    }
    
    @Override
    public void render(Graphics g){
        E_Bullet tempBullet;
        g.drawImage(sprite, x, y, width, height, null);
        for (int i = 0; i < bullets.size(); i++) {
            tempBullet = bullets.get(i);
            tempBullet.draw(g);
        }
    }

    @Override
    public void removeBullet (E_Bullet bill){
        bullets.remove(bill);
    }

    public void addBullet (){
        bullets.add(new EB_Straight(x + getTilesize()/4, y + getTilesize()));
    }
}