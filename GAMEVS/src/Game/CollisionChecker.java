package Game;


import Entity.*;


public class CollisionChecker {
    
    public static boolean CollisionOn(Enemy e, P_Bullet b){
            if(b.getHitBox().intersects(e.getHurtBox())){
                return true;
            }
        return false;
    }
    public static boolean playerCollisionOnBullets (E_Bullet eb){
        if (Player.getHurtBox().intersects(eb.getHitBox())){
            return true;
        }
        return false;
    }
    public static boolean playerCollisionOnEnemies (Enemy e){
        if (Player.getHurtBox().intersects(e.getHurtBox())){
            return true;
        }
        return false;
    }
}
