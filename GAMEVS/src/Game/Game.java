package Game;

import javax.swing.JLabel;

public class Game implements Runnable {
	
	private Panel panel;
	private static Thread gameThread;
	private final int FPS_SET = 60;
	private int frames = 0;
    JLabel counterLabel;
	public Game () {
		panel = new Panel();
		
		new GameFrame(panel);
		panel.requestFocusInWindow();
		startGameLoop();
	}
	
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
    public static void stopGameLoop(){
        gameThread.stop();
    }
        @Override
	public void run() {
            double drawInterval = 1000000000/FPS_SET;
            double nextDrawTime = System.nanoTime() + drawInterval;
            
            while (gameThread != null){
                panel.update();
                panel.repaint();
                
                frames++;
                if (frames >= 60){
                    System.out.println(frames);
                    frames = 0;
                }
                try {
                    double remainingTime = nextDrawTime - System.nanoTime();
                    remainingTime /= 1000000;
                    
                    if (remainingTime < 0){
                        remainingTime = 0;
                    }
                    Thread.sleep((long)remainingTime);
                    
                    nextDrawTime += drawInterval;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
		
	}
}