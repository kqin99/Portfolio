package Runner.title;

import java.awt.Color;
import java.awt.Graphics;

import Runner.Handler;
import Runner.id;

public class Wall extends Title {

	public Wall(int x, int y, int width, int height, boolean solid, Runner.id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
	}
	
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	
	public void tick(){
		
	}


}
