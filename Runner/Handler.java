/*Keyuan Qin
 * kqin
 * Proj4
 * MW 12:30-1:45
 * I did not collaborate with anyone on this assignment
 */
package Runner;

import java.awt.Graphics;
import java.util.LinkedList;

import Runner.entity.Entity;
import Runner.title.Title;

public class Handler {
	public LinkedList<Entity> entity = new LinkedList<Entity>();
	public LinkedList<Title> title = new LinkedList<Title>();

public void render(Graphics g){
	for(Entity en:entity){
		en.render(g);
	}
	
	for(Title ti:title){
		ti.render(g);
	}
}

public void tick(){
	for(Entity en:entity){
		en.tick();
	}
	
	for(Title ti:title){
		ti.tick();
	}
	}

public void addEntity(Entity en){
	entity.add(en);
}
public void removeEntity(Entity en){
	entity.remove(en);
}
public void addTitle(Title ti){
	title.add(ti);
}
public void removeTitle(Title ti){
	title.remove(ti);
}
}