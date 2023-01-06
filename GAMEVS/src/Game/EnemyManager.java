package Game;

import Entity.*;
import static Game.Panel.getTilesize;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class EnemyManager {

    private LinkedList<Enemy> enemies;
    private Enemy tempEnemy;
    private Panel panel;

    private Random rand;

    private Player player;

    public EnemyManager(Panel panel) {
        enemies = new LinkedList<>();
        this.panel = panel;
        this.rand = new Random();
    }

    public void update() {
        if (rand.nextInt((100 - 0) + 1) + 0 <= 2) {
            addEnemies();

        }
        for (int i = 0; i < enemies.size(); i++) {
            tempEnemy = enemies.get(i);
            if (tempEnemy.getState() != true){
                removeEnemies(tempEnemy);
            }
            if (tempEnemy.getY() > panel.getHeight()) {
                removeEnemies(tempEnemy);
            }
            tempEnemy.move();
        }

    }

    public void render(Graphics g) {
        for (int i = 0; i < enemies.size(); i++) {
            tempEnemy = enemies.get(i);
            tempEnemy.render(g);
        }
    }

    private void addEnemies() {
        int index = rand.nextInt((4 - 0) + 1) + 0;
        switch (index){
            case (0) -> 
                enemies.add(new E_Basic(rand.nextInt(((panel.getWidth() - getTilesize()*3) - 0) + 1) + 0, -getTilesize()*2, panel.getHeight()));
            case (1) ->
                enemies.add(new E_Strong(rand.nextInt(((panel.getWidth() - getTilesize()*3) - 0) + 1) + 0, -getTilesize()*2));
            case (2) ->
                enemies.add(new E_Sniper(rand.nextInt(((panel.getWidth() - getTilesize()*3) - 0) + 1) + 0, -getTilesize()*2, panel.getHeight(),player));
            case (3) ->
                enemies.add(new E_Summoner(rand.nextInt(((panel.getWidth() - getTilesize()*3) - 0) + 1) + 0, -getTilesize()*2, panel.getHeight(),player));
            }
    }

    private void removeEnemies(Enemy enemy) {
        enemies.remove(enemy);
    }

    public LinkedList<Enemy> getEnemyList (){
        return enemies;
    }
    public void setPlayerInfo(Player player){
        this.player = player;
    }
    public void resetEnemy(){
        enemies.clear();
        }
    }
}

