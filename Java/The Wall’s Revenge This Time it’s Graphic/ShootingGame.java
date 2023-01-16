/*Keyuan Qin
 * kqin
 * lab01
 * MW 12:30-1:45
 * I did not collaborate with anyone on this assignment
 */
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
/*
 * The entry point of game
 */
public class ShootingGame {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Sooting Game");
		GameScene gs = new GameScene();
		frame.setLayout(new BorderLayout());
		ControlPanel panel1 = new ControlPanel(1, gs);
		ControlPanel panel2 = new ControlPanel(2, gs);
		panel1.setOthers(panel2);
		panel2.setOthers(panel1);
		frame.add(gs,BorderLayout.CENTER);
		frame.add(panel1, BorderLayout.WEST);
		frame.add(panel2, BorderLayout.EAST);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
