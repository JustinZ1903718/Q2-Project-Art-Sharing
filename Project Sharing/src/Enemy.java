import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Enemy {

	private int x;
	private int y;
	private int vx;
	private int vy;
	private int r;
	public int minx=100;
	public int miny=0;
	public int maxx=900;
	public int maxy=500;
	private Image img; 	
	private AffineTransform tx;
	
	public Enemy(int x, int y, int vx, int vy) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		img = getImage("/imgs/Enemy.png");
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y);
	}
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;

		//call update to update the actualy picture location
		update();
		g2.drawImage(img, tx, null);
		

	}
	private void update() { 
		y+=vy;
		x+=vx;
		if(y+64>=maxy) {
			y=maxy-64;
			vy=-vy;
		}
		if(y<=miny) {
			y=miny;
			vy=-vy;
		}
		//change 64 based on your own enemy size
		if(x+64>=maxx) {
			x=maxx-64;
			vx=-vx;
		}
		if(x<=minx) {
			x=minx;
			vx=-vx;
		}
		tx.setToTranslation(x, y);
		tx.scale(0.07	, 0.07);
		
	}
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	public int getx() {
		return this.x;
	}
	
	public int gety() {
		return this.y;
	}
	
	public int getr() {
		return this.r;
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.07, 0.07);
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


