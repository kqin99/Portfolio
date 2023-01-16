package Runner.graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private BufferedImage sheet;
	public SpriteSheet(String path){
		try {
			sheet = ImageIO.read(getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private File getResource(String path) {
		// TODO Auto-generated method stub
		return null;
	}
}