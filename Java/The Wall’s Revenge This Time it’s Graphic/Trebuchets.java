/*Keyuan Qin
 * kqin
 * lab01
 * MW 12:30-1:45
 * I did not collaborate with anyone on this assignment
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
/*
 * Class to hold all information of players.
 */
public class Trebuchets extends Rectangle {
	static Primitives p=new Primitives();
	private int playerID;
	private int points;
	private boolean ifDestory;
	
	public Trebuchets(int id, boolean left) {
		super();
		this.y = p.getScreenHeight() - p.getTrebuchetsHeight();
		this.width = p.getTrebuchetsWidth();
		this.height = p.getTrebuchetsHeight();
		if (left) {
			this.x = 10;
		}
		else {
			this.x = p.getScreenWidth()-10-p.getTrebuchetsWidth();
		}
		this.points = 0;
		this.ifDestory = false;
		this.playerID = id;
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
	public int getPoints() {
		return points;
	}
	public String getPointsString() {
		return String.valueOf(points);
	}
	public void addPoints(int p) {
		points += p;
	}
	public void markDestory() {
		this.ifDestory = true;
	}
	public boolean ifDestory() {
		return this.ifDestory;
	}
}
