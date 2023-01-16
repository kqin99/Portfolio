/*Keyuan Qin
 * kqin
 * lab01
 * MW 12:30-1:45
 * I did not collaborate with anyone on this assignment
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JComponent;
/*
 * BrickWall Class
 * 
 * A 2D matrix is defined in this class to keep track
 * all states of bricks.
 */
public class BrickWall {
	static Primitives p=new Primitives();
	private Brick bricks[][];
	private boolean ifBombed;
	public int bombTimeLeft;
	public BrickWall() {
		this.bricks = new Brick[20][5];
		for (int i = 0; i < 20; i ++) {
			for (int j = 0; j < 5; j ++) {
				this.bricks[i][j] = new Brick(240+j*p.getBrickWidth(), 
						i*p.getBrickHeight(), p.getBrickWidth(), p.getBrickHeight());
			}
		}
		this.bricks[10][2].ifBomb = true;
		this.ifBombed = false;
		this.bombTimeLeft = 10;
	}
	public void reduceTime() {
		if (ifBombed) {
			return;
		}
		bombTimeLeft --;
		if (bombTimeLeft == 0) {
			boom();
			ifBombed = true;
		}
	}
	private void boom() {
		int boomx = -1;
		boolean found = false;
		for (int i = 0; i < 20; i ++) {
			for (int j = 0; j <5; j ++) {
				if (bricks[i][j].ifBomb) {
					boomx = i;
					found = true;
					break;
				}
			}
			if (found) {
				break;
			}
		}
		if (!found) {
			return;
		}
		ifBombed = true;
		bombTimeLeft = -1;
		int startx = boomx-2;
		int endx = Math.min(boomx+2, 19);
		removeRow(startx, endx);
	}
	private void removeRow(int start, int end) {
		while (start > 0) {
			copyRow(start-1, end);
			start --;
			end --;
		}
		while (end >= 0) {
			deleteRow(end);
			end --;
		}
	}
	private void copyRow(int from, int dest) {
		for (int j = 0; j < 5; j ++) {
			bricks[dest][j].ifBomb = bricks[from][j].ifBomb;
			bricks[dest][j].ifDestoried = bricks[from][j].ifDestoried;
		}
	}
	private void deleteRow(int r) {
		for (int j = 0; j < 5; j ++) {
			bricks[r][j].ifDestoried = true;
		}
	}
	public void paintComponent(Graphics g) {
		for (int i = 0; i < 20; i ++) {
			for (int j = 0;j < 5; j ++) {
				Brick b = bricks[i][j];
				if (b.ifHit) {
					g.setColor(Color.PINK);
					b.ifHit = false;
				} else if (b.ifDestoried) {
					g.setColor(Color.GRAY);
				} else if (b.ifBomb) {
					g.setColor(Color.GREEN);
				} else {
					g.setColor(Color.RED);
				}
				g.fillRect(b.x, b.y, b.width, b.height);
			}
		}
	}
	// if nonhit return 0
	// if hit normal return 1
	// if hit bomb return 2
	public int hitBrick(int x, int y, boolean left) {
		Point p = new Point(x, y);
		if (left) {
			for (int i = 0; i < 20; i ++) {
				for (int j = 0; j < 5; j ++) {
					if (bricks[i][j].ifDestoried) {
						continue;
					}
					if (bricks[i][j].contains(p)) {
						bricks[i][j].ifDestoried = true;
						if (bricks[i][j].ifBomb) {
							boom();
						} else if (allRowDestoried(i)) {
							removeRow(i, i);
						}
						bricks[i][j].ifHit = true;
						return bricks[i][j].ifBomb ? 2 : 1;
					}
				}
			}
			return 0;
		} else {
			for (int i = 0; i < 20; i ++) {
				for (int j = 4; j >= 0; j --) {
					if (bricks[i][j].ifDestoried) {
						continue;
					}
					if (bricks[i][j].contains(p)) {
						bricks[i][j].ifDestoried = true;
						if (bricks[i][j].ifBomb) {
							boom();
						} else if (allRowDestoried(i)) {
							removeRow(i, i);
						}
						bricks[i][j].ifHit = true;
						return bricks[i][j].ifBomb ? 2 : 1;
					}
				}
			}
			return 0;
		}
	}
	private boolean allRowDestoried(int r) {
		for (int j = 0; j < 5; j ++) {
			if (!bricks[r][j].ifDestoried) {
				return false;
			}
		}
		return true;
	}
	public boolean ifBoomed() {
		return ifBombed;
	}
	public String getTimeLeftString() {
		return String.valueOf(bombTimeLeft);
	}
	/*
	 * Internal class to represent the state of a single brick.
	 * 
	 * Basically it will extend Rectangle class and add three more fields
	 * A brick can have four states:
	 * 1. If hit in current round
	 * 2. If bomb
	 * 3. Already destroyed
	 * 4. Never hit.
	 */
	public class Brick extends Rectangle {
		public boolean ifHit;
		public boolean ifDestoried;
		public boolean ifBomb;
		public Brick(int x, int y, int w, int h) {
			super(x, y, w, h);
			this.ifHit = false;
			this.ifDestoried = false;
			this.ifBomb = false;
		}
	}
}