import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Coin {
	private int x;
	private int y;
	private int diameter=15;
	private Image img; 	
	private boolean exists;
	private AffineTransform tx;
	
	public Coin(int x, int y, boolean exists) {
		this.x=x;
		this.y=y;
		this.exists=exists;
		img = getImage("/imgs/Coin.png");
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y);
	}
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;

		//call update to update the actualy picture location
		
		if(exists) {//stores whether the coin should be painted
			g2.drawImage(img, tx, null);
		}
		

	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	public void disappear() {
		exists=false;
	}
	public boolean getExists() {
		return exists;
	}
	public void appear() {
		exists=true;
	}
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(2, 2);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Enemy.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}


