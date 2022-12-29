package Entity;


import Game.CollisionChecker;
import Game.EnemyManager;
import Game.Game;
import Game.Panel;
import Gamestates.Gamestate;

import static Game.Panel.getTilesize;
import static Game.Texture.*;
import Input.KeyManager;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Player {

    private KeyManager Key;
    private Panel panel;
    private static int HP = 5;
    private int x = 200;
    private int y = 300;
    private int speed = 5;
    private static Rectangle hurtbox;
    private BufferedImage sprite;
    private LinkedList<P_Bullet> b;
    private P_Bullet TempBullet;
    private EnemyManager enemyM;
    private LinkedList<Enemy> enemies;
    private Enemy tempEnemy;
    private int width;
    private int height;
    private int tick = 0;

    public Player(Panel panel, KeyManager Key, EnemyManager EnemyM) {
        this.b          = new LinkedList<>();
        this.panel      = panel;
        this.Key        = Key;
        this.sprite     = getPlayer();
        this.enemyM     = EnemyM;
        this.enemies    = EnemyM.getEnemyList();
        this.width      = getTilesize() * 2;
        this.height     = getTilesize() * 2;
        hurtbox         = new Rectangle (x + width/4 + width/8, y + width/3, width/4,height/4);
    }

    public void update() {
        //Bullet collision check
        for (int i = 0; i < b.size(); i++) {
            TempBullet = b.get(i);

            for (int j = 0; j<enemyM.getEnemyList().size(); j++){
                if(CollisionChecker.CollisionOn(enemies.get(j), TempBullet)){
                    System.out.println("Collision Detected");
                    enemies.get(j).hurt(TempBullet.getDamage());
                    removeBullet(TempBullet);
                }
            }
            
            if (TempBullet.getY() < 0) {
                removeBullet(TempBullet);
            }
            TempBullet.move();
        }
        //Collision check
        for (int i = 0; i<enemyM.getEnemyList().size(); i++){
            tempEnemy = enemies.get(i);
            if(CollisionChecker.playerCollisionOnEnemies(tempEnemy)){
                System.out.println("Collision Detected");
                Damaged();
                enemies.remove(tempEnemy);
            }
        }
        //Keypress check
        if (Key.downPressed) {
            moveDown();
        } else if (Key.upPressed) {
            moveUp();
        } else if (Key.leftPressed) {
            moveLeft();
        } else if (Key.rightPressed) {
            moveRight();
        } 
        if (Key.shootPressed) {
            tick ++;
            if (tick == 1 || tick == 5){
                shoot();
                tick = 1;
            }
        }
    }
    //rendering method
    public void render(Graphics g) { 
        g.drawImage(sprite, x, y, width, height, null);
        for (int i = 0; i < b.size(); i++) {
            TempBullet = b.get(i);
            TempBullet.draw(g);
        }
        
    }


    //adding bullet to the list so it can move and render
    private void shoot() {
        b.add(new P_Bullet(x + width/4, y - width/2));
    }

    //control
    private void moveRight() {
        if (x + getTilesize() < panel.getWidth()) {
            this.x += speed;
            hurtbox.x += speed;
        }
    }
    private void moveLeft() {
        if (x > 0) {
            this.x -= speed;
            hurtbox.x -= speed;
        }
    }
    private void moveUp() {
        if (y > 0) {
            this.y -= speed;
            hurtbox.y -= speed;
        }
    }
    private void moveDown() {
        if (y + getTilesize() < panel.getHeight()) {
            this.y += speed;
            hurtbox.y += speed;
        }
    }

    //Reduce HP when hit
    public static void Damaged() {
        HP--;
        if(HP>=0){
            System.out.println(HP + " HP left");
        }

        if(HP==0){
            System.out.println("You are dead!");
            System.out.print("You've survived for: "+ Panel.getSecond()+" seconds!\n");
            Gamestate.state = Gamestate.DEAD;
            //Game.stopGameLoop();
            

        }
    }

    //remove bullet out of list to make it disappear
    private void removeBullet(P_Bullet bill) {
        this.b.remove(bill);
    }

    //get methods (only these are pulic)
    public int getPlayerX (){
        return x;
    }
    public int getPlayerY (){
        return y;
    }
    
    public static Rectangle getHurtBox (){
        return hurtbox;
    }

    public static int getHP() {
        return HP;
    }
    public void setHP(int hP) {
        HP = hP;
    }
}
