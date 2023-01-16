/*Keyuan Qin
 * kqin
 * Proj4
 * MW 12:30-1:45
 * I did not collaborate with anyone on this assignment
 */
package Runner;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import Runner.Input.KeyInput;
import Runner.entity.enemy.Player;
import Runner.title.Wall;

public class Game extends Canvas implements Runnable{
	public static final int Width = 320;
	public static final int Height = 240;
	public static final int Scale = 4;
	public static final String Title = "EndlessRunner";
	
	private Thread thread;
	private boolean running= false;
	
	public static Handler handler;
	
	public Game(){
		Dimension size = new Dimension(Width*Scale,Height*Scale);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
	}
	
	private void init(){
		handler =  new Handler();
		
		addKeyListener(new KeyInput());
		
		handler.addEntity(new Player(444,555,64,64,true, id.Player,handler));
		handler.addTitle(new Wall(300,300,64,64,true,id.wall,handler));
	}
	
	public synchronized void start(){
		if(running) return;
		running =true;
		thread = new Thread(this,"Thread");
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		init();
		requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0.0;
		double ns = 1000000000/60.0;
		int frames = 0;
		int ticks = 0;
		while(running){
			long now = System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime = now;
			while(delta>=1){
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis()-timer>1000){
				timer+=1000;
				System.out.println(frames + " Frames Per Second" + ticks + "Updates Per Second");
				frames = 0;
				ticks = 0;
			}
		}
		stop();
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs==null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		handler.render(g);
		g.dispose();
		bs.show();
	}
	
	public void tick(){
		handler.tick();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame(Title);
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.start();
	}

}
