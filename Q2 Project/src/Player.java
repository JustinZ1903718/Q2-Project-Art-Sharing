import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player{
	
	//add location attributes
	private Image img; 	
	private AffineTransform tx;
	private int x;
	private int y;
	private int vx;
	private int vy;

	public Player(int x, int y) {
		this.x = 100;
		this.y = 100;
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
	public void goLeft() {
		vx= -6;
	}
	public void goRight() {
		vx = 6;
	}
	public void goDown() {
		vy= 6;
	}
	public void goUp() {
		vy = -6;
	}
	public void stopX() {
		vx = 0;
	}
	public void stopY() {
		vy=0;
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
		x += vx;
		y += vy;
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
