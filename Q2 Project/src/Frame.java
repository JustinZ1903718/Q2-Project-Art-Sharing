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
	
	//CREATE THE OBJECT (STEP 1)
	Background 	bg 	= new Background(0, 0);
	Player p = new Player(100, 100);
	Enemy e = new Enemy(200, 200, 0, 0);
	public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
		p.paint(g);
		e.paint(g);
		Font font = new Font("Joeaaaaaaaaaaaaa", Font.PLAIN, 50);
		g.setFont(font);
		if(p.getX()<=e.getx()&&p.getX()+32<=e.getx()&&p.getY()>=e.gety()&&p.getY()+32>=e.gety()) {
			g.setColor(Color.white);
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(Color.white);
			g.drawString("You lost lol press r to restart", 10, 250);
		}
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		JFrame f = new JFrame("World's Game");
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
