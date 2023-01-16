package Runner.entity.enemy;

import java.awt.Color;
import java.awt.Graphics;

import Runner.Handler;
import Runner.entity.Entity;

public class Player extends Entity{

	public Player(int x, int y, int width, int height, boolean solid, Runner.id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}

	public void tick() {
		x+=Velx;
		y+=Vely;
		if(x<=0) x = 0;
		if(y<=0) y = 0;
		if(x+width>=1280) x = 1280-width;
		if(y+height>=960) y = 960-height;
	}



}
