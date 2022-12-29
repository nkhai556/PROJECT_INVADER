package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Entity.Player;
import Game.Panel;
import Gamestates.Gamestate;
public class MouseManager implements MouseListener {
	
	Panel panel;
	
	public MouseManager (Panel panel) {
		this.panel=panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	       // TODO Auto-generated method stub
		if (Gamestate.state == Gamestate.DEAD){
			int mx = e.getX();
			int my = e.getY();
			if(mx>= panel.returnWidth()/2 - panel.returnWidth()/8  && mx <= panel.returnWidth()+100){
				//new Rectangle(Panel.WIDTH/2+120,150,100,50);
				if(my >= 150  &&  my<=200){
					panel.reset();
					
				}
			}
		}
		if (Gamestate.state == Gamestate.MENU){
		   int mx = e.getX();
		   int my = e.getY();
		   if(mx>= panel.returnWidth()/2 - panel.returnWidth()/8  && mx <= panel.returnWidth()+100){
			   //new Rectangle(Panel.WIDTH/2+120,150,100,50);
			   if(my >= 150  &&  my<=200){
				   Gamestate.state = Gamestate.PLAYING;
			   }
		   }
		   if(mx>= panel.returnWidth()/2 - panel.returnWidth()/8 && mx <= panel.returnWidth() + 100){
			//new Rectangle(Panel.WIDTH/2+120,150,100,50);
			if(my >= 250  &&  my<=300){
				System.exit(1);
			}
		}
	}
   
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("!");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}