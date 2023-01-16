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
/**
 * Background class to hold all info in background
 */
public class Background extends Rectangle {
	static Primitives p=new Primitives();
	public Background() {
		super(0, 0, p.getScreenWidth(), p.getScreenHeight());
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, this.width, this.height);
	}
	
}
