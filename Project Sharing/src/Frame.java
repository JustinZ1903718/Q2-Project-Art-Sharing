import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	boolean dead = false;
	int diameter = 25;
	int length = 25;
	int deaths = 0;
	//CREATE THE OBJECT (STEP 1)
	Background 	bg 	= new Background(100, 0);
	Player p = new Player(0, 0);

		Enemy[][] levelE=new Enemy[5][11]; {
		levelE[3][0] = new Enemy(100, 0, 0, 30);
		levelE[3][1] = new Enemy(200, 0, 0, 30);
		levelE[3][2] = new Enemy(300, 500-diameter, 0, 30);
		levelE[3][3] = new Enemy(400, 500-diameter, 0, 30);
		levelE[3][4] = new Enemy(500, 0, 0, 30);
		levelE[3][5]= new Enemy(600, 0, 0, 30);
		levelE[3][6] = new Enemy(700, 500-diameter, 0, 30);
		levelE[3][7] = new Enemy(800, 500-diameter, 0, 30);
		levelE[3][8] = new Enemy(450, 250, 12, 12);
		levelE[3][9] = new Enemy(400, 150, -12, 12);
		levelE[3][10] = new Enemy(200, 450, -12, -12);
	}



	public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
		g.setColor(Color.green);
		g.fillRect(0, 0, 100, 500);
		g.fillRect(900, 0, 100, 500);
		p.paint(g);
		Font font = new Font("Joeaaaaaaaaaaaaa", Font.PLAIN, 50);
		g.setFont(font);
		for(int i=0;i<11;i++) {
			levelE[3][i].paint(g);
		}
		System.out.println("x: " + p.getX());
		System.out.println("y: " + p.getY());
		for(int i = 0;i<11;i++) {
			if(collision(levelE[3][i], p) == true) {
				dead = true;
				p.isDead(true);
				deaths++;
				
			}
		}
		if(dead == true) {
			p.setX(50);
			p.setY(200);
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(Color.white);
			g.drawString("lol you lost press r to restart, " + deaths + " death(s)", 10, 250);
		}
		if(p.getX() >= 900) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(Color.white);
			g.drawString("dub nice - death(s):" + deaths, 10, 250);
		}
		
	}
	public double dist(int x1, int y1, int x2, int y2) {
		int squareDist=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
		return Math.sqrt(squareDist);
	}

	public boolean collision(Enemy e, Player p) {
		int ecenterx=e.getx()+diameter/2;
		int ecentery=e.gety()+diameter/2;
		int pcenterx=p.getX()+length/2;
		int pcentery=p.getY()+length/2;
		double dist=dist(ecenterx, ecentery, pcenterx, pcentery);
		if(dist<diameter/2+length/2) {
			return true;
		}
		
		double dist1=dist(p.getX(), p.getY(), ecenterx, ecentery);
		if(dist1<diameter/2) {
			return true;
		}
		double dist2=dist(p.getX()+length, p.getY(), ecenterx, ecentery);
		if(dist2<diameter/2) {
			return true;
		}
		double dist3=dist(p.getX(), p.getY()+length, ecenterx, ecentery);
		if(dist3<diameter/2) {
			return true;
		}
		double dist4=dist(p.getX()+length, p.getY()+length, ecenterx, ecentery);
		if(dist4<diameter/2) {
			return true;
		}
		
		return false;
	}


	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		JFrame f = new JFrame("World's Hardest Game-ed");
		f.setSize(new Dimension(1000, 500));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			System.out.println(arg0.getKeyCode());
			if(arg0.getKeyCode() == 87) {
				p.goUp();
			}
			if(arg0.getKeyCode() == 65) {
				p.goLeft();
			}
			if(arg0.getKeyCode() == 83) {
				p.goDown();
			}
			if(arg0.getKeyCode() == 68) {
				p.goRight();
			}
			if(dead == true && arg0.getKeyCode() == 82) {
				dead = false;
				p.isDead(false);
			}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == 87 || arg0.getKeyCode() == 83) {
			p.stopY();
		}
		if(arg0.getKeyCode() == 65 || arg0.getKeyCode() == 68) {
			p.stopX();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
