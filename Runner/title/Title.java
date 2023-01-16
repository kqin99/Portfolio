package Runner.title;

import java.awt.Graphics;

import Runner.Handler;
import Runner.id;

public class Title {
	
	public int x,y;
	public int width,height;
	public boolean solid;
	public int Velx,Vely;
	public id id;
	public Handler handler;
	
	public Title(int x, int y, int width, int height, boolean solid, id id,Handler handler){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.solid = solid;
		this.id = id;
		this.handler = handler;
	}
	
	public void render(Graphics g){
		
	}
	
	public void tick(){
		x+=Velx;
		y+=Vely;
	}
	
	public void die(){
		handler.removeTitle(this);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public id getid(){
		return id;
	}
	
	public boolean isSolid() {
		return solid;
	}

	public void setVelx(int velx) {
		Velx = velx;
	}

	public void setVely(int vely) {
		Vely = vely;
	}
}
