package Entity;

import static Game.Panel.getTilesize;
import static Game.Texture.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import java.awt.*;

public class E_Sniper extends Enemy implements Villians {
    
    private int speed = 7;
    private BufferedImage sprite;
    private int width = getTilesize() * 2;
    private int height = getTilesize() * 2;
    private Player player;

    
    
    

    public E_Sniper(int x, int y, int limit, Player player) {
        super.x = x;
        super.y = y;
        super.HP = 5;
        this.sprite = getE_SNIPER();
        super.hurtbox = new Rectangle(x,y,width,height);
        super.limit = limit;
        super.bullets = new LinkedList<>();
        this.player = player;
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
            addBullet(player.getPlayerX(), player.getPlayerY());
            cooldown = 0;
        }
    }

    @Override
    public void move() {
        if(y < limit * 0.15){
            y+= speed;
            hurtbox.y += speed;
        }
        else {
            cooldown ++;
            shoot();
        }
       
        
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

    public void addBullet (int Px, int Py){
        bullets.add(new EB_Aim(x + width/4, y + getTilesize(), Px, Py));
    }
}
