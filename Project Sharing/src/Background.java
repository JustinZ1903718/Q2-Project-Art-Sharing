import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background{
	
	//add location attributes
	private Image img; 	
	private AffineTransform tx;
	private boolean titleScreen = true;

	public Background(int x, int y, boolean titleScreen) {
		
		this.titleScreen = titleScreen;
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
		if(titleScreen == false) {//regular background
			img = getImage("/imgs/Background.png"); //load the image for Tree
			tx.scale(65,65);
		}
		else {//title screen background
			img = getImage("/imgs/Title.png");
			tx.scale(10,8);
		}//use your variables
	}

	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actualy picture location
		update();
		
		
		
		
		g2.drawImage(img, tx, null);
		
		

	}
	public void setTitleScreen(boolean titleScreen) {
		this.titleScreen = titleScreen;
	}
	/* update the picture variable location */
	private void update() {
		
		
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
