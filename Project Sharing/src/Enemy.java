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
	public int minX=100;
	public int minY=0;
	public int maxX=900;
	public int maxY=500;
	private int curVx;
	private int curVy;
	private int diameter = 35;
	private Image img; 	
	private AffineTransform tx;
	private boolean rectangle;
	
	public Enemy(int x, int y, int vx, int vy, int minX, int minY, int maxX, int maxY, boolean rectangle) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.minX = minX;
		this.maxY = maxX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		curVx = vx;
		this.rectangle = rectangle;
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
		if(!rectangle) {//does regular linear movement
			y+=vy;
			x+=vx;
			if(y+2*diameter>maxY) {
				y=maxY-2*diameter;
				vy=-vy;
			}
			if(y<minY) {
				y=minY;
				vy=-vy;
			}
			//change 64 based on your own enemy size
			if(x+diameter>=maxX) {
				x=maxX-diameter;
				vx=-vx;
			}
			if(x<minX) {
				x=minX;
				vx=-vx;
			}
		}
		if(rectangle) {//only moves one direction at a time and changes direction when it approaches max/min x/y
			x+=curVx;
			y+=curVy;
			if(curVy==0) {
				if(x+diameter>maxX) {
					x=maxX-diameter;
					curVx=0;
					curVy=vy;	
				}
				if(x<minX) {
					x=minX;
					curVx=0;
					curVy=-vy;	
				}
			}
			if(curVx==0) {
				if(y+2*diameter>maxY) {
					y=maxY-2*diameter;
					curVx=-vx;
					curVy=0;	
				}
				if(y<minY) {
					y=minY;
					curVx=vx;
					curVy=0;	
				}
			}
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


