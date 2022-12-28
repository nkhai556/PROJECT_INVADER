package Game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import Entity.Player;

public class Texture {
    private static BufferedImage player, E_GRUNT, E_STRONG, E_SNIPER, E_SUMMONER, BG, P_BULLET, E_BULLET1;
    
    public Texture (){
        try {
            player = ImageIO.read(getClass().getResourceAsStream("/RES/Sprite/PLAYER.png"));
            E_GRUNT = ImageIO.read(getClass().getResourceAsStream("/RES/Sprite/Wisp.png"));
            E_STRONG = ImageIO.read(getClass().getResourceAsStream("/RES/Sprite/Umbrella.png"));
            E_SNIPER = ImageIO.read(getClass().getResourceAsStream("/RES/Sprite/Lantern.png"));
            E_SUMMONER = ImageIO.read(getClass().getResourceAsStream("/RES/Sprite/Strong.png"));
            BG        = ImageIO.read(getClass().getResourceAsStream("/RES/Sprite/BG.png"));
            P_BULLET = ImageIO.read(getClass().getResourceAsStream("/RES/Sprite/Windblade.png"));
            E_BULLET1 = ImageIO.read(getClass().getResourceAsStream("/RES/Sprite/GhastFlame.png"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BufferedImage getPlayer() {
        return player;
    }

    public static BufferedImage getE_BASIC() {
        return E_GRUNT;
    }

    public static BufferedImage getE_STRONG() {
        return E_STRONG;
    }

    public static BufferedImage getE_SNIPER() {
        return E_SNIPER;
    }
    public static BufferedImage getP_BULLET() {
        return P_BULLET;
    }
    public static BufferedImage getE_BULLET1() {
        return E_BULLET1;
    }
    public static BufferedImage getBG() {
        return BG;
    }
    public static BufferedImage getE_SUMMONER() {
        return E_SUMMONER;
    }
}