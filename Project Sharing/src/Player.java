import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.swing.JFrame;

public class Player{
	
	//add location attributes
	private Image img; 	
	private AffineTransform tx;
	private int x = 0;
	private int y = 0;
	private int vx;
	private int vy;
	private int maxX = 950;
	private int maxY = 430;
	private int minX = 10;
	private int minY = 10;
	private boolean dead;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		img = getImage("/imgs/Player.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void goLeft() {
		vx = -6;
	}
	public void goRight() {
		vx = 6;
	}
	public void goDown() {
		vy = 6;

	
	}
	public void goUp() {
		vy = -6;
	}
	public void stopX() {
		vx = 0;
	}
	public void stopY() {
		vy = 0;
	}
	public void isDead(boolean dead) {
		this.dead = dead;
		}
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actualy picture location
		update();
		
		
		
		
		g2.drawImage(img, tx, null);
		
		

	}
	/* update the picture variable location */
	private void update() {
		if(dead == false) {
			x += vx;
			y += vy;
		}
		
		if(this.x <= minX) {
			x = minX;
		}
		if(this.x >= maxX) {
			x = maxX;
		}
		if(this.y >= maxY) {
			y = maxY;
		}
		if(this.y <= minY) {
			y = minY;
		}
		
		tx.setToTranslation(x, y);
		tx.scale(0.5, 0.5);
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.5, 0.5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Player.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
