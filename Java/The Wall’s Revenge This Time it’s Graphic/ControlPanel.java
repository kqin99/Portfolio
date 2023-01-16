/*Keyuan Qin
 * kqin
 * lab01
 * MW 12:30-1:45
 * I did not collaborate with anyone on this assignment
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/*
 * ControlPanel to control Trebuchets' velocity and angel
 * 
 * It contains two sliders and one button. 
 * Reference to another panel is needed here because two button
 * need to have same state.
 */
public class ControlPanel extends JPanel {
	static Primitives p=new Primitives();
	private int id;
	private JSlider angel;
	private JSlider velocity;
	private JButton launch;
	private ControlPanel other;
	private GameScene gs;
	private JLabel angelLabel;
	private JLabel velocityLabel;
	private boolean ready;
	public ControlPanel(int id, GameScene gs) {
		super();
		setLayout(new FlowLayout());
		this.id = id;
		this.angel = new JSlider(0, 90);
		this.angel.setValue(45);
		this.angelLabel = new JLabel("Angel: 45 Degree");
		this.velocity = new JSlider(0, 200);
		this.velocity.setValue(50);
		this.velocityLabel = new JLabel("Velocity: 50 Pixels");
		this.launch = new JButton("Launch!");
		add(new JLabel("Player " + String.valueOf(id)));
		add(this.angel);
		add(this.angelLabel);
		add(this.velocity);
		add(this.velocityLabel);
		add(this.launch);
		this.gs = gs;
		this.ready = false;
		this.launch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ready = true;
				launch.setEnabled(false);
				angel.setEnabled(false);
				velocity.setEnabled(false);
				if (other.ready) {
					if (id == 1) {
						gs.launch(angel.getValue(), velocity.getValue(), other.angel.getValue(), other.velocity.getValue());
					} else {
						gs.launch(other.angel.getValue(), other.velocity.getValue(), angel.getValue(), velocity.getValue());
					}
					ready = false;
					other.ready = false;
					launch.setEnabled(true);
					angel.setEnabled(true);
					velocity.setEnabled(true);
					other.launch.setEnabled(true);
					other.angel.setEnabled(true);
					other.velocity.setEnabled(true);
				}
			}
		});
		this.angel.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				angelLabel.setText(String.format("Angel: %d Degree", angel.getValue()));
				repaint();
			}
		});
		this.velocity.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				velocityLabel.setText(String.format("Velocity: %d Pixels", velocity.getValue()));
				repaint();
			}
		});
	}
	public void setOthers(ControlPanel cp) {
		this.other = cp;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, p.getScreenHeight());
	}
}
