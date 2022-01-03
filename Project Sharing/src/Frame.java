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

//3:23.59 is World Record
public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	boolean dead = false;
	boolean titleScreen = true;
	int diameter = 35;
	int length = 35;
	int coinsPerLevel=3;
	int enemies=18;
	private int curLevel=0;
	int deaths = 1;
	int maxLevel = 8;
	boolean levelSelect = false;
	int frameCount = 0;
	boolean levelBeat = false;
	//CREATE THE OBJECT (STEP 1)
	
	Background 	bg 	= new Background(100, 0, true);//(x,y, titleScreen)
	Background bg2 = new Background(100,0, false);
	Player p = new Player(500, 380); //(x,y)
	private int coins = 0;
	
	//2d array for coin positions
	Coin [][] levelC=new Coin[maxLevel+1][3]; {
		levelC[0][0]=new Coin(500, 100, true);//(x,y,exists)
		levelC[0][1]=new Coin(500, 100, true);
		levelC[0][2]=new Coin(500, 100, true);
		
		levelC[1][0]=new Coin(505, 75, true);
		levelC[1][1]=new Coin(505, 175, true);
		levelC[1][2]=new Coin(505, 360, true);
		
		levelC[2][0]=new Coin(250, 230, true);
		levelC[2][1]=new Coin(450, 230, true);
		levelC[2][2]=new Coin(650, 230, true);
		
		levelC[3][0]=new Coin(250, 230, true);
		levelC[3][1]=new Coin(450, 230, true);
		levelC[3][2]=new Coin(650, 230, true);
		
		levelC[4][0]=new Coin(400, 50, true);
		levelC[4][1]=new Coin(505, 175, true);
		levelC[4][2]=new Coin(400, 380, true);
		
		levelC[5][0]=new Coin(500, 250, true);
		levelC[5][1]=new Coin(500, 250, true);
		levelC[5][2]=new Coin(500, 250, true);
		
		levelC[6][0]=new Coin(300, 100, true);
		levelC[6][1]=new Coin(500, 250, true);
		levelC[6][2]=new Coin(700, 400, true);
		
		levelC[7][0]=new Coin(475, 230, true);
		levelC[7][1]=new Coin(475, 230, true);
		levelC[7][2]=new Coin(475, 230, true);
		
		levelC[8][0]=new Coin(475, 230, true);
		levelC[8][1]=new Coin(475, 230, true);
		levelC[8][2]=new Coin(475, 230, true);
		
		

	


	}
	//String array stores the message for each level
	String[] levelMessage = new String[maxLevel+1];{
			levelMessage[0] = "Collect the coins, go to the green rectangle";
			levelMessage[1] = "99% of people can't get past this level! ;)";
			levelMessage[2] = "Ok that's enough with the free levels";
			levelMessage[3] = "GAS GAS GAS GONNA STEP ON THE GAS";
			levelMessage[4] = "You won't beat this";
			levelMessage[5] = "Rectangles o_O";
			levelMessage[6] = "JOEJOEJOEJOEJOEJOEJOEJOEJOEJEOJOEJEOEJOEJOEJOE";
			levelMessage[7] = "Oh you thought you could cheese the last level?";
	}
	
			//2d array stores enemies
	Enemy[][] levelE=new Enemy[maxLevel+1][enemies]; {
		levelE[0][0] = new Enemy(100, 0, 8, 8, 100, 0, 500, 435, false);//(x,y,vx,vy,minX,minY,maxX,maxY,rectangle)
		levelE[0][1] = new Enemy(900, 0, 3, 0, 600, 0, 900, 300, false);
		levelE[0][2] = new Enemy(800, 0, 0, 5, 100, 150, 900, 350, false);
		levelE[0][3] = new Enemy(500, 330, 0, 0, 100, 0, 900, 500, false);
		levelE[0][4] = new Enemy(600, 0, 0, 3, 100, 0, 900, 300, false);
		levelE[0][5]= new Enemy(400, 0, 0, 3, 100, 0, 900, 300, false);
		levelE[0][6] = new Enemy(600, 300, 0, 40, 100, 300, 900, 500, false);
		levelE[0][7] = new Enemy(400, 300, 40, 0, 400, 0, 600, 500, false);
		levelE[0][8] = new Enemy(400, 300, 0, 40, 0, 300, 900, 500, false);
		levelE[0][9] = new Enemy(400, 500, 0, 40, 0, 300, 900, 500, false);
		levelE[0][10] = new Enemy(600, 500, 0, 40, 100, 300, 900, 500, false);
		levelE[0][11] = new Enemy(600, 300, 40, 0, 400, 0, 600, 500, false);
		levelE[0][12] = new Enemy(500, 50, 5, 0, 300, 0, 700, 500, false);
		levelE[0][13] = new Enemy(500, 0, 0, 5, 100, 0, 900, 500, false);
		levelE[0][14] = new Enemy(500, 0, 0, 5, 100, 0, 900, 500, false);
		levelE[0][15] = new Enemy(500, 0, 0, 5, 100, 0, 900, 500, false);
		levelE[0][16] = new Enemy(500, 0, 0, 5, 100, 0, 900, 500, false);
		levelE[0][17] = new Enemy(500, 0, 0, 5, 100, 0, 900, 500, false);
		
		
		levelE[1][0] = new Enemy(100, 0, 0, 15, 100, 0, 900, 500, false);
		levelE[1][1] = new Enemy(200, 0, 0, 15, 100, 0, 900, 500, false);
		levelE[1][2] = new Enemy(500, 450-diameter, 0, 0, 100, 0, 900, 500, false);
		levelE[1][3] = new Enemy(500, 330-diameter, 0, 0, 100, 0, 900, 500, false);
		levelE[1][4] = new Enemy(500, 0, 0, 15, 100, 0, 900, 500, false);
		levelE[1][5]= new Enemy(600, 0, 0, 15, 100, 0, 900, 500, false);
		levelE[1][6] = new Enemy(500, 250-diameter, 0, 0, 100, 0, 900, 500, false);
		levelE[1][7] = new Enemy(500, 150-diameter, 0, 0, 100, 0, 900, 500, false);
		levelE[1][8] = new Enemy(0, 350, 15, 0, 100, 0, 900, 500, false);
		levelE[1][9] = new Enemy(250, 150, 15, 0, 100, 0, 900, 500, false);
		levelE[1][10] = new Enemy(500, 50-diameter, 0, 0, 100, 0, 900, 500, false);
		levelE[1][11] = new Enemy(500, 50-diameter, 0, 0, 100, 0, 900, 500, false);
		levelE[1][12] = new Enemy(500, 50-diameter, 0, 0, 100, 0, 900, 500, false);
		levelE[1][13] = new Enemy(500, 50-diameter, 0, 0, 100, 0, 900, 500, false);
		levelE[1][14] = new Enemy(500, 50-diameter, 0, 0, 100, 0, 900, 500, false);
		levelE[1][15] = new Enemy(500, 50-diameter, 0, 0, 100, 0, 900, 500, false);
		levelE[1][16] = new Enemy(500, 50-diameter, 0, 0, 100, 0, 900, 500, false);
		levelE[1][17] = new Enemy(500, 50-diameter, 0, 0, 100, 0, 900, 500, false);

		
		levelE[2][0] = new Enemy(100, 0, 20, 20, 100, 0, 900, 500, true);
		levelE[2][1] = new Enemy(900, 500, 20, 20, 100, 0, 900, 500, true);
		levelE[2][2] = new Enemy(900, 500, 20, 20, 100, 0, 900, 500, true);
		levelE[2][3] = new Enemy(325, 150, 14, 14, 325, 150, 675, 350, true);
		levelE[2][4] = new Enemy(100, 0, 0, 12, 100, 0, 900, 500, false);
		levelE[2][5] = new Enemy(200, 0, 0, 12, 100, 0, 900, 500, false);
		levelE[2][6] = new Enemy(300, 500-diameter, 0, 12, 100, 0, 900, 500, false);
		levelE[2][7] = new Enemy(400, 500-diameter, 0, 12, 100, 0, 900, 500, false);
		levelE[2][8] = new Enemy(500, 0, 0, 12, 100, 0, 900, 500, false);
		levelE[2][9] =  new Enemy(600, 0, 0, 12, 100, 0, 900, 500, false);
		levelE[2][10] = new Enemy(700, 500-diameter, 0, 12, 100, 0, 900, 500, false);
		levelE[2][11] = new Enemy(800, 500-diameter, 0, 12, 100, 0, 900, 500, false);
		levelE[2][12] = new Enemy(800, 500-diameter, 0, 12, 100, 0, 900, 500, false);
		levelE[2][13] = new Enemy(800, 500-diameter, 0, 12, 100, 0, 900, 500, false);
		levelE[2][14] = new Enemy(800, 500-diameter, 0, 12, 100, 0, 900, 500, false);
		levelE[2][15] = new Enemy(800, 500-diameter, 0, 12, 100, 0, 900, 500, false);
		levelE[2][16] = new Enemy(800, 500-diameter, 0, 12, 100, 0, 900, 500, false);
		levelE[2][17] = new Enemy(800, 500-diameter, 0, 12, 100, 0, 900, 500, false);


		levelE[3][0] = new Enemy(100, 0, 0, 20, 100, 0, 900, 500, false);
		levelE[3][1] = new Enemy(160, 500-diameter, 0, 20, 100, 0, 900, 500, false);
		levelE[3][2] = new Enemy(220, 0, 0, 20, 100, 0, 900, 500, false);
		levelE[3][3] = new Enemy(280, 500-diameter, 0, 20, 100, 0, 900, 500, false);
		levelE[3][4] = new Enemy(340, 0, 0, 20, 100, 0, 900, 500, false);
		levelE[3][5]= new Enemy(400, 500-diameter, 0, 20, 100, 0, 900, 500, false);
		levelE[3][6] = new Enemy(460, 0, 0, 20, 100, 0, 900, 500, false);
		levelE[3][7] = new Enemy(520, 500-diameter, 0, 20, 100, 0, 900, 500, false);
		levelE[3][8] = new Enemy(580, 0, 0, 20, 100, 0, 900, 500, false);
		levelE[3][9] = new Enemy(640, 500-diameter, 0, 20, 100, 0, 900, 500, false);
		levelE[3][10] = new Enemy(700, 0, 0, 20, 100, 0, 900, 500, false);
		levelE[3][11] = new Enemy(760, 500-diameter, 0, 20, 100, 0, 900, 500, false);
		levelE[3][12] = new Enemy(820, 0, 0, 20, 100, 0, 900, 500, false);
		levelE[3][13] = new Enemy(820, 0, 0, 20, 100, 0, 900, 500, false);
		levelE[3][14] = new Enemy(820, 0, 0, 20, 100, 0, 900, 500, false);
		levelE[3][15] = new Enemy(820, 0, 0, 20, 100, 0, 900, 500, false);
		levelE[3][16] = new Enemy(820, 0, 0, 20, 100, 0, 900, 500, false);
		levelE[3][17] = new Enemy(820, 0, 0, 20, 100, 0, 900, 500, false);
		

		levelE[4][0] = new Enemy(100, 50, 50, 0, 100, 0, 900, 500, false);
		levelE[4][1] = new Enemy(100, 380, 50, 0, 100, 0, 900, 500, false);
		levelE[4][2] = new Enemy(500, 100, 50, 0, 100, 0, 900, 500, false);
		levelE[4][3] = new Enemy(500, 350, 50, 0, 100, 0, 900, 500, false);
		levelE[4][4] = new Enemy(500, 150, 50, 0, 100, 0, 900, 500, false);
		levelE[4][5]= new Enemy(500, 0, 0, 25, 100, 0, 900, 500, false);
		levelE[4][6] = new Enemy(500, 310, 50, 0, 100, 0, 900, 500, false);
		levelE[4][7] = new Enemy(500, 0, 0, 0, 100, 0, 900, 500, false);
		levelE[4][8] = new Enemy(500, 460, 0, 0, 100, 0, 900, 500, false);
		levelE[4][9] = new Enemy(500, 200, 15, 0, 100, 0, 900, 500, false);
		levelE[4][10] = new Enemy(100, 250, -15, 0, 100, 0, 900, 500, false);
		levelE[4][11] = new Enemy(100, 250, -15, 0, 100, 0, 900, 500, false);
		levelE[4][12] = new Enemy(100, 250, -15, 0, 100, 0, 900, 500, false);
		levelE[4][13] = new Enemy(100, 250, -15, 0, 100, 0, 900, 500, false);
		levelE[4][14] = new Enemy(100, 250, -15, 0, 100, 0, 900, 500, false);
		levelE[4][15] = new Enemy(100, 250, -15, 0, 100, 0, 900, 500, false);
		levelE[4][16] = new Enemy(100, 250, -15, 0, 100, 0, 900, 500, false);
		levelE[4][17] = new Enemy(100, 250, -15, 0, 100, 0, 900, 500, false);

		levelE[5][0] = new Enemy(100, 0, 0, 30, 100, 0, 900, 500, false);
		levelE[5][1] = new Enemy(200, 0, 0, 30, 100, 0, 900, 500, false);
		levelE[5][2] = new Enemy(300, 500-diameter, 0, 30, 100, 0, 900, 500, false);
		levelE[5][3] = new Enemy(400, 500-diameter, 0, 30, 100, 0, 900, 500, false);
		levelE[5][4] = new Enemy(500, 0, 0, 30, 100, 0, 900, 500, false);
		levelE[5][5]= new Enemy(600, 0, 0, 30, 100, 0, 900, 500, false);
		levelE[5][6] = new Enemy(700, 500-diameter, 0, 30, 100, 0, 900, 500, false);
		levelE[5][7] = new Enemy(800, 500-diameter, 0, 30, 100, 0, 900, 500, false);
		levelE[5][8] = new Enemy(450, 250, 8, 8, 100, 0, 900, 500, false);
		levelE[5][9] = new Enemy(400, 150, -8, 8, 100, 0, 900, 500, false);
		levelE[5][10] = new Enemy(200, 450, -8, -8, 100, 0, 900, 500, false);
		levelE[5][11] = new Enemy(200, 150, 8, -8, 100, 0, 900, 500, false);
		levelE[5][12] = new Enemy(200, 150, 8, -8, 100, 0, 900, 500, false);
		levelE[5][13] = new Enemy(200, 150, 8, -8, 100, 0, 900, 500, false);
		levelE[5][14] = new Enemy(200, 150, 8, -8, 100, 0, 900, 500, false);
		levelE[5][15] = new Enemy(200, 150, 8, -8, 100, 0, 900, 500, false);
		levelE[5][16] = new Enemy(200, 150, 8, -8, 100, 0, 900, 500, false);
		levelE[5][17] = new Enemy(200, 150, 8, -8, 100, 0, 900, 500, false);
	
		levelE[6][0] = new Enemy(200, 0, 12, 12, 200, 0, 500, 500, true);
		levelE[6][1] = new Enemy(200, 0, 12, 12, 450, 0, 850, 500, true);
		levelE[6][2] = new Enemy(600, 0, 18, 18, 600, 300, 800, 500, true);
		levelE[6][3] = new Enemy(100, 0, 12, 12, 200, 0, 800, 500, true);
		levelE[6][4] = new Enemy(200, 0, 12, 12, 200, 0, 650, 450, true);
		levelE[6][5]= new Enemy(200, 100, 12, 12, 200, 0, 650, 500, true);
		levelE[6][6] = new Enemy(500, 100, 18, 18, 300, 0, 500, 400, true);
		levelE[6][7] = new Enemy(600, 100, 12, 12, 300, 0, 700, 200, true);
		levelE[6][8] = new Enemy(200, 100, 12, 12, 300, 0, 500, 300, true);
		levelE[6][9] = new Enemy(200, 100, 12, 12, 300, 200, 500, 500, true);
		levelE[6][10] = new Enemy(100, 0, 18, 18, 100, 100, 850, 500, true);
		levelE[6][11] = new Enemy(200, 0, 18, 18, 100, 0, 850, 500, true);
		levelE[6][12] = new Enemy(300, 0, 18, 18, 100, 0, 600, 500, true);
		levelE[6][13] = new Enemy(400, 0, 18, 18, 100, 0, 800, 500, true);
		levelE[6][14] = new Enemy(400, 0, 18, 18, 100, 0, 850, 500, true);
		levelE[6][15] = new Enemy(400, 0, 18, 18, 100, 0, 800, 500, true);
		levelE[6][16] = new Enemy(400, 0, 18, 18, 100, 0, 850, 500, true);
		levelE[6][17] = new Enemy(400, 0, 18, 18, 100, 0, 800, 500, true);

		levelE[7][0] = new Enemy(100, 0, 0, 13, 100, 0, 900, 500, false);
		levelE[7][1] = new Enemy(250, 0, 0, 13, 100, 0, 900, 500, false);
		levelE[7][2] = new Enemy(400, 0, 0, 13, 100, 0, 900, 500, false);
		levelE[7][3] = new Enemy(550, 0, 0, 13, 100, 0, 900, 500, false);
		levelE[7][4] = new Enemy(700, 0, 0, 13, 100, 0, 900, 500, false);
		levelE[7][5] = new Enemy(850, 0, 0, 13, 100, 0, 900, 500, false);		
		levelE[7][6] = new Enemy(175, 500-diameter, 0, -13, 100, 0, 900, 500, false);
		levelE[7][7]= new Enemy(325, 500-diameter, 0, -13, 100, 0, 900, 500, false);
		levelE[7][8] = new Enemy(475, 500-diameter, 0, -13, 100, 0, 900, 500, false);
		levelE[7][9] = new Enemy(625, 500-diameter, 0, -13, 100, 0, 900, 500, false);
		levelE[7][10] = new Enemy(775, 500-diameter, 0, -13, 100, 0, 900, 500, false);
		levelE[7][11] = new Enemy(700, 0, 0, 13, 100, 0, 900, 500, false);	
		levelE[7][12] = new Enemy(100, 20, 22, 0, 100, 0, 880, 500, false);
		levelE[7][13] = new Enemy(100, 220, 22, 0, 100, 0, 880, 500, false);
		levelE[7][14] = new Enemy(100, 420, 22, 0, 100, 0, 880, 500, false);
		levelE[7][15] = new Enemy(880, 120, -22, 0, 100, 0, 880, 500, false);
		levelE[7][16] = new Enemy(880, 320, -22, 0, 100, 0, 880, 500, false);
		levelE[7][17] = new Enemy(880, 320, -22, 0, 100, 0, 880, 500, false);
		
		levelE[8][0] = new Enemy(100, 0, 0, 13, 100, 0, 900, 500, false);
		levelE[8][1] = new Enemy(250, 0, 0, 13, 100, 0, 900, 500, false);
		levelE[8][2] = new Enemy(400, 0, 0, 13, 100, 0, 900, 500, false);
		levelE[8][3] = new Enemy(550, 0, 0, 13, 100, 0, 900, 500, false);
		levelE[8][4] = new Enemy(700, 0, 0, 13, 100, 0, 900, 500, false);
		levelE[8][5] = new Enemy(700, 0, 0, 13, 100, 0, 900, 500, false);		
		levelE[8][6] = new Enemy(175, 500-diameter, 0, -13, 100, 0, 900, 500, false);
		levelE[8][7]= new Enemy(325, 500-diameter, 0, -13, 100, 0, 900, 500, false);
		levelE[8][8] = new Enemy(475, 500-diameter, 0, -13, 100, 0, 900, 500, false);
		levelE[8][9] = new Enemy(625, 500-diameter, 0, -13, 100, 0, 900, 500, false);
		levelE[8][10] = new Enemy(775, 500-diameter, 0, -13, 100, 0, 900, 500, false);
		levelE[8][11] = new Enemy(100, 42, 22, 0, 100, 0, 880, 500, false);	
		levelE[8][12] = new Enemy(880, 100, -22, 0, 100, 0, 880, 500, false);
		levelE[8][13] = new Enemy(100, 168, 22, 0, 100, 0, 880, 500, false);
		levelE[8][14] = new Enemy(880, 236, -22, 0, 100, 0, 880, 500, false);
		levelE[8][15] = new Enemy(100, 304, 22, 0, 100, 0, 880, 500, false);
		levelE[8][16] = new Enemy(880, 372, -22, 0, 100, 0, 880, 500, false);
		levelE[8][17] = new Enemy(100, 440, 22, 0, 100, 0, 880, 500, false);
		
		
		//69 is how far away enemies can be in y without hitting the player
	}



	public void paint(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.green);
		Font font = new Font("Joeaaaaaaaaaaaaa", Font.PLAIN, 50);
		g.setFont(font);
		if(curLevel != 0) {
			titleScreen = false;
		}
		if(titleScreen == true) {//since the title screen level is different to the other levels, these only occur on the title screen
			bg.paint(g);
			g.setColor(Color.black);
			g.drawString("Level", 750, 100);
			g.drawString("Select", 750, 150);
			g.drawString("New", 750, 400);
			g.drawString("Game", 750, 450);
			g.setColor(Color.blue);
			g.fillRect(900, 0, 100, 200);
			g.setColor(Color.red);
			g.fillRect(900, 300, 100, 200);
			g.setColor(Color.green);
		}
		else {
			
			bg2.paint(g);
			g.fillRect(900, 0, 100, 500);
			
		}
		
		g.fillRect(0, 0, 100, 500);
		p.paint(g);	
		for(int i=0;i<enemies;i++) {
			levelE[curLevel][i].paint(g);//checks for collision with the player for each enemy in the current level
		}
		for(int i=0;i<coinsPerLevel;i++) {
			levelC[curLevel][i].paint(g);//checks for collision with the player for each coin in the current level
		}
		if(levelBeat == true) {
			frameCount++;
		}
		if(frameCount <= 60 && levelBeat == true) {//for 60 frames after a level is beat, a message is shown
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(Color.white);
			g.drawString(levelMessage[curLevel], 10, 250);
			p.stopX();
			p.stopY();
			if(frameCount == 60 && curLevel != maxLevel) {
				curLevel++;
			}
		}
		else {
			frameCount = 0;
			levelBeat = false;
			
		}
		for(int i = 0;i<enemies;i++) {
			if(collision(levelE[curLevel][i], p) == true) {//kills the player if they collide with an enemy
				dead = true;
				p.isDead(true);

				
			}
		}
		
		for(int i=0;i<coinsPerLevel;i++) {
			if(collision(levelC[curLevel][i], p)==true) {//makes the coin disappear and adds to the coin counter if a coin collides with the player
				levelC[curLevel][i].disappear();
				coins++;
			}
		}
		if(titleScreen == true && p.getX()>=900 && p.getY() <= 200) {//goes into level select if the player goes to the level select box
			levelSelect = true;
			deaths = 0;
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(Color.white);
			g.drawString("Select level 1-" + maxLevel, 10, 250);
			g.drawString("Type in the number of the level you want to ", 10, 350);
			g.drawString("play", 10, 450);
		}
		if(titleScreen == true && p.getX()>=900 && p.getY() >= 300) {//starts new game if the player goes to the new game box on the title screen
			titleScreen = false;
			p.setX(0);
			levelBeat = true;
			bg.setTitleScreen(false);
			deaths = 1;
			p.setX(0);
			p.setY(250);
			
		}
		if(dead == true) {
			for(int i=0;i<coinsPerLevel;i++) {
				levelC[curLevel][i].appear();//makes the coins reappear if the player dies
			}
			p.setX(0);
			p.setY(250);
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(Color.white);
			g.drawString("lol you lost press r to restart", 10, 250);
			g.drawString(deaths + " deaths", 10, 350);
			g.drawString("press m for main menu", 10, 450);
		}
		if(p.getX() >= 900&&checkCoins(curLevel) && titleScreen == false&& curLevel!=maxLevel) {//goes to next level if the player makes it to the end of a level which isn't the last level
			levelBeat = true;                                                                   //and they have collected all of the coins
			p.setX(0);
			p.setY(250);
			frameCount = 0;

			
			
			
			/*
			curLevel++;
			for(int i=0;i<coinsPerLevel;i++) {
				levelC[curLevel][i].appear();
			}
			*/
		}
		else if (p.getX() >= 900&&checkCoins(curLevel) && titleScreen == false&& curLevel==maxLevel) {//finishes the game if the player beats the last level
			p.stopX();
			p.stopY();
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(Color.white);
			g.drawString("dub nice", 10, 250);
			g.drawString(deaths + " deaths", 10, 350);
		}
	}
	public double dist(int x1, int y1, int x2, int y2) {
		int squareDist=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);//checks each corner of the player for collision
		return Math.sqrt(squareDist);
	}

	public boolean collision(Enemy e, Player p) {//checks for collision between player and enemy
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
	
	public boolean collision(Coin c, Player p) {//checks for collision between player and coin
		int ecenterx=c.getX()+diameter/2;
		int ecentery=c.getY()+diameter/2;
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
	public boolean checkCoins(int level) {
		for(int i=0;i<3;i++) {
			if(levelC[level][i].getExists()) {
				return false;
			}
		}
		return true;
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
			if(arg0.getKeyCode() == 87 && levelSelect == false) {
				p.goUp();
			}
			if(arg0.getKeyCode() == 65&& levelSelect == false) {
				p.goLeft();
			}
			if(arg0.getKeyCode() == 83&& levelSelect == false) {
				p.goDown();
			}
			if(arg0.getKeyCode() == 68&& levelSelect == false) {
				p.goRight();
			}
			if(dead == true && arg0.getKeyCode() == 82) {//resets the level if the player is dead and presses r
				dead = false;
				p.isDead(false);
				p.setX(50);
				p.setY(200);
				deaths++;
			}
			if(arg0.getKeyCode() == 49 && levelSelect == true) {//keys for each level in level select
				curLevel = 1;
				titleScreen = false;
				bg.setTitleScreen(false);
				p.setX(0);
				p.setY(250);
				levelSelect = false;
			}
			if(arg0.getKeyCode() == 50 && levelSelect == true) {
				curLevel = 2;
				titleScreen = false;
				bg.setTitleScreen(false);
				p.setX(0);
				p.setY(250);
				levelSelect = false;
			}
			if(arg0.getKeyCode() == 51 && levelSelect == true) {
				curLevel = 3;
				titleScreen = false;
				bg.setTitleScreen(false);
				p.setX(0);
				p.setY(250);
				levelSelect = false;
			}
			if(arg0.getKeyCode() == 52 && levelSelect == true) {
				curLevel = 4;
				titleScreen = false;
				bg.setTitleScreen(false);
				p.setX(0);
				p.setY(250);
				levelSelect = false;
			}
			if(arg0.getKeyCode() == 53 && levelSelect == true) {
				curLevel = 5;
				titleScreen = false;
				bg.setTitleScreen(false);
				p.setX(0);
				p.setY(250);
				levelSelect = false;
			}
			if(arg0.getKeyCode() == 54 && levelSelect == true) {
				curLevel = 6;
				titleScreen = false;
				bg.setTitleScreen(false);
				p.setX(0);
				p.setY(250);
				levelSelect = false;
			}
			if(arg0.getKeyCode() == 55 && levelSelect == true) {
				curLevel = 7;
				titleScreen = false;
				bg.setTitleScreen(false);
				p.setX(0);
				p.setY(250);
				levelSelect = false;
			}
			if(arg0.getKeyCode() == 56 && levelSelect == true) {
				curLevel = 8;
				titleScreen = false;
				bg.setTitleScreen(false);
				p.setX(0);
				p.setY(250);
				levelSelect = false;
			}
			if(arg0.getKeyCode() == 77 && dead == true) {//goes back to the title screen
				titleScreen = true;
				p.setX(50);
				p.setY(250);
				dead = false;
				p.isDead(false);
				curLevel = 0;
			}
			}

	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == 87 || arg0.getKeyCode() == 83) {//stops player when key is released
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




