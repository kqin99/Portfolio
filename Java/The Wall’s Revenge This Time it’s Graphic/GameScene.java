/*Keyuan Qin
 * kqin
 * lab01
 * MW 12:30-1:45
 * I did not collaborate with anyone on this assignment
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
/*
 * Main game screen on shooting game
 * 
 * Store all necessary gaming objects.
 * It also provide entry to start each round. The paint function
 * is responsible for coordinating drawing objects.
 */
public class GameScene extends JComponent {
	static Primitives p=new Primitives();
	private Background bg;
	private BrickWall bw;
	private Trebuchets player[];
	private Trajectory trajectory[];

	public GameScene() {
		bg = new Background();
		bw = new BrickWall();
		player = new Trebuchets[2];
		trajectory = new Trajectory[2];
		player[0] = new Trebuchets(1, true);
		player[1] = new Trebuchets(2, false);
		trajectory[0] = new Trajectory(bw, player[0], player[1], true);
		trajectory[1] = new Trajectory(bw, player[1], player[0], false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		bg.paintComponent(g);
		bw.paintComponent(g);
		player[0].paintComponent(g);
		player[1].paintComponent(g);
		trajectory[0].paintComponent(g);
		trajectory[1].paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawString("Player #1:" + player[0].getPointsString(), 0, 20);
		g.drawString("Player #2:" + player[1].getPointsString(), 0, 40);
		if (bw.bombTimeLeft >= 0) {
			g.drawString("Time left to boom: " + bw.getTimeLeftString(), 0, 60);
		} else {
			g.drawString("Bomb already boomed!", 0, 60);
		}
		if (player[0].ifDestory()) {
			g.drawString("Player 2 Wins!", 0, 80);
		} else if (player[1].ifDestory()) {
			g.drawString("Player 1 Wins!", 0, 80);
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(p.getScreenWidth(), p.getScreenHeight());
	}
	
	public void launch(int a1, int v1, int a2, int v2) {
		trajectory[0].updateTrajectory(a1, v1);
		trajectory[1].updateTrajectory(a2, v2);
		bw.reduceTime();
		if (bw.ifBoomed() && bw.bombTimeLeft == 0) {
			bw.bombTimeLeft = -1;
			player[0].addPoints(-400);
			player[1].addPoints(-400);
		}
		repaint();
	}
}
