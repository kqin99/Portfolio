package Runner.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Runner.Game;
import Runner.entity.Entity;

public class KeyInput implements KeyListener {

	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en:Game.handler.entity){
			switch(key){
			case KeyEvent.VK_W:
				en.setVely(-5);
				break;
			case KeyEvent.VK_S:
				en.setVely(5);
				break;
			case KeyEvent.VK_A:
				en.setVelx(-5);
				break;
			case KeyEvent.VK_D:
				en.setVelx(5);
				break;
			}
		}
	
		
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(Entity en:Game.handler.entity){
			switch(key){
			case KeyEvent.VK_W:
				en.setVely(0);
				break;
			case KeyEvent.VK_S:
				en.setVely(0);
				break;
			case KeyEvent.VK_A:
				en.setVelx(-5);
				break;
			case KeyEvent.VK_D:
				en.setVelx(5);
				break;
			}
		}
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

}
