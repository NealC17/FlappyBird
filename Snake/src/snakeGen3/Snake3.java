package snakeGen3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.Timer;

import snakeGen1.Coordinator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake3 extends JPanel implements KeyListener, ActionListener{

	JPanel panel;
	Timer tm;
	public static final int length=20;
	public static final int velocity= length;
	
	private int vx ,vy;
	private int[] x;
	private int[] y;
	private boolean[] shown;
	
	private int shownUpTo;

	public static final int width=20;
	public static final int speed = width;
	private int lastX;
	private int lastY;
	public static final int arrayLength =Coordinator3.boardHeight*Coordinator3.boardWidth ;

	private boolean upDirection,downDirection,leftDirection,rightDirection;



	public Snake3(){
		shownUpTo=1;
		tm = new Timer(120,this );
		x = new int[arrayLength];
		y=new int[arrayLength];
		shown = new boolean[arrayLength];
		
		x[0]=Coordinator.boardWidth/2;
		y[0]=Coordinator.boardHeight/2;

		for(int i = 1; i < x.length; i ++){
			x[i]=x[0]+i*width;
			y[i]=y[0];
			
		}
		tm.start();
		upDirection=false;
		downDirection=false;
		leftDirection=false;
		rightDirection=false;





		


	}

	public int getLastX(){
		return lastX;
	}

	public int getLastY(){
		return lastY;
	}


	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.red);
		g.fillOval(x[0], y[0], width, width);

		g.setColor(Color.green);
		for(int i = 1; i < x.length;i++){
			if(shown[i])g.fillOval(x[i], y[i], width, width);
			
		}
	}


	public void keyReleased(KeyEvent e) { }
	public void keyTyped(KeyEvent e) { }
	public void keyPressed(KeyEvent e) {	
		int code = e.getKeyCode();


		if (code == KeyEvent.VK_DOWN){
			upDirection=false;
			downDirection=true;
			leftDirection=false;
			rightDirection=false;

		}
		else if (code == KeyEvent.VK_UP){
			upDirection=true;
			downDirection=false;
			leftDirection=false;
			rightDirection=false;


		}
		else if (code == KeyEvent.VK_LEFT){
			upDirection=false;
			downDirection=false;
			leftDirection=true;
			rightDirection=false;


		}
		else if (code == KeyEvent.VK_RIGHT){
			upDirection=false;
			downDirection=false;
			leftDirection=false;
			rightDirection=true;

		}
		else if(code == KeyEvent.VK_SPACE){
			shownUpTo++;
			for(int i = 1; i < shownUpTo;i++){
				shown[i]=true;
			}
		}
	}


	public void move() {
		x[0]+=vx;
		y[0]+=vy;

		for (int z = x.length-1; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (leftDirection&&(!rightDirection)) {
			x[0] -= speed;
		}
		else if (rightDirection&&(!leftDirection)) {
			x[0] += speed;
		}
		else if (upDirection&&(!downDirection)) {
			y[0] -= speed;
		}
		else if (downDirection&&(!upDirection)) {
			y[0] += speed;
		}
		
		


	}

	public void actionPerformed(ActionEvent e) { 
		move();

		this.repaint();
	}


}
