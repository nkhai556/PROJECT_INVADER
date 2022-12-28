package Game;

import java.awt.image.BufferedImage;
import java.awt.*;

public class BG {
    private int x1 = 0;
    private int y1;
    private int x2 = 0;
    private int y2;
    private int width = 524;
    private int height = 832;
    private BufferedImage BG1;
    private BufferedImage BG2;
    private int speed = 2;
    private Panel panel;

    public BG(Panel panel) {
        this.BG1 = Texture.getBG();
        this.BG2 = Texture.getBG();
        this.panel = panel;
        y1 = 0;
        y2 = y1 - height;
    }

    public void update(){
        y1 += speed;
        y2 += speed;
        if (y1 > panel.getHeight() ){
            y1 = y2 - height;
        }
        else if (y2 > panel.getHeight()){
            y2 = y1 - height;
        } 
    }

    public void render (Graphics g){
        
        g.drawImage(BG1, x1, y1, width, height,null);
        g.drawImage(BG2, x2, y2, width, height,null);
        
    }
}
