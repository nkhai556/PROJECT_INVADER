package Entity;

import static Game.Panel.getTilesize;
import static Game.Texture.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;


public class E_Strong extends Enemy implements Villians{
    
    private int speed = 1;
    private BufferedImage sprite;
    private int width = getTilesize() * 3;
    private int height =  getTilesize() * 3;

    public E_Strong(int x, int y) {
        super.x = x;
        super.y = y;
        super.HP = 8;
        this.sprite = getE_STRONG();
        super.hurtbox = new Rectangle(x,y,width,height);
        super.bullets = new LinkedList<>();
    }

    @Override
    public void shoot() {

    }

    @Override
    public void move() {
        y+= speed;
        hurtbox.y += speed;
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(sprite, x, y, width, height, null);
    }
}