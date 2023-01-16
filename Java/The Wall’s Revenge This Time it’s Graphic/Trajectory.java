/*Keyuan Qin
 * kqin
 * lab01
 * MW 12:30-1:45
 * I did not collaborate with anyone on this assignment
 */
import java.awt.Color;
import java.awt.Graphics;
/*
 * Class to control trajectory of two players.
 * 
 * It will store x, y list separated for easy drawing purpose
 */
public class Trajectory {
	static Primitives p=new Primitives();
	private int xPos[];
	private int yPos[];
	private int numDrawSize;
	private BrickWall bw;
	private Trebuchets player;
	private boolean left;
	private Trebuchets other;
	
	public Trajectory(BrickWall bw, Trebuchets player, Trebuchets other, boolean left) {
		int size = p.getScreenWidth() - 10 - p.getTrebuchetsWidth();
		this.bw = bw;
		this.player = player;
		this.other = other;
		this.left = left;
		xPos = new int[size];
		yPos = new int[size];
		this.numDrawSize = 0;
	}
	public void updateTrajectory(int angle, int velocity) {
		double tanTheta = Math.tan(Math.toRadians(angle));
		double cosTheta = Math.cos(Math.toRadians(angle));
		double part2 = p.getG() / (2 * Math.pow(velocity * cosTheta, 2));
		this.numDrawSize = 0;
		for (int i = 0; i < 590; i ++) {
			int x;
			if (left) {
				x = 50 + i;
			} else {
				x = 590 - i;
			}
			double y_rel = i * tanTheta - Math.pow(i, 2) * part2;
			int y = (int) (p.getScreenHeight() - p.getTrebuchetsHeight() - y_rel);
			if (y < 0.0 || y > p.getScreenHeight()) {
				player.addPoints(-10);
				break;
			}
			int ret = bw.hitBrick(x, y, left);
			if (ret == 1) {
				player.addPoints(10);
				break;
			} else if (ret == 2) {
				player.addPoints(200);
				break;
			}
			if (other.contains(x, y)) {
				player.addPoints(bw.ifBoomed() ? 150 : 500);
				other.markDestory();
				break;
			}
			xPos[i] = x;
			yPos[i] = y;
			this.numDrawSize ++;
		}
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawPolyline(xPos, yPos, this.numDrawSize);
	}
}
