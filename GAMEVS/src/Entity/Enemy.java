package Entity;

import java.awt.*;
import java.util.LinkedList;

public class Enemy {
    int x,y;
    int speed;
    int HP;
    int limit;
    Rectangle hurtbox;
    LinkedList<E_Bullet> bullets;
    boolean Alive = true;
    int cooldown = 0;
    
    public void move(){
    }
    public void render(Graphics g){
    }
    public int getY(){
        return y;
    }
    public Rectangle getHurtBox(){
        return hurtbox;
    }
    public void hurt(int dmg){
        HP -= dmg;
        if (HP <= 0){
            Alive = false;
        }
    }
    public boolean getState (){
        return Alive;
    }
    
    public LinkedList<E_Bullet> getBullets (){
        return bullets;
    }
    
    public void removeBullet (E_Bullet bill){
        bullets.remove(bill);
    }
}
