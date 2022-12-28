package Entity;

import java.awt.*;


public class E_Bullet {
    int x;
    int y;
    Rectangle hitbox;
    int speed;
    boolean stateLive = true;


    public void move() {
    }

    public void draw(Graphics g) {
    }

    public Rectangle getHitBox(){
        return hitbox;
    }
    
    public int getY(){
        return y;
    }
}
