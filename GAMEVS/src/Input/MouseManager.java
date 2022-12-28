package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Game.Panel;
public class MouseManager implements MouseListener {
	
	Panel panel;
	
	public MouseManager (Panel panel) {
		this.panel=panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
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