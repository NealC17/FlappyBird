package snakeGen2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.Timer;

import snakeGen1.Coordinator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake2 extends JPanel implements KeyListener, ActionListener{

	JPanel panel;
	Timer tm;
	public static final int length=20;
	public static final int velocity= length;
	private int vx ,vy;

	private int[] x;
	private int[] y;

	public static final int width=20;
	public static final int speed = width;
	private int lastX;
	private int lastY;
	public static final int arrayLength = Coordinator.boardHeight*Coordinator.boardWidth;
	
	private boolean upDirection,downDirection,leftDirection,rightDirection;



	Snake2(){
		tm = new Timer(240,this );
		x = new int[3];
		y=new int[3];

		x[0]=Coordinator.boardWidth/2; 
		y[0]=Coordinator.boardHeight/2;

		x[1]=Coordinator.boardWidth/2; 
		y[1]=Coordinator.boardHeight/2+width;
		
		x[2]=Coordinator.boardWidth/2; 
		y[2]=Coordinator.boardHeight/2+width*2;
		upDirection=false;
		downDirection=false;
		leftDirection=false;
		rightDirection=true;





		tm.start();


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
		g.fillOval(x[i], y[i], width, width);
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

			//s3.follow(s2);
		}
		else if (code == KeyEvent.VK_UP){
			upDirection=true;
			downDirection=false;
			leftDirection=false;
			rightDirection=false;


			//s3.follow(s2);
		}
		else if (code == KeyEvent.VK_LEFT){
			upDirection=false;
			downDirection=false;
			leftDirection=true;
			rightDirection=false;

			
			//s3.follow(s2)
		}
		else if (code == KeyEvent.VK_RIGHT){
			upDirection=false;
			downDirection=false;
			leftDirection=false;
			rightDirection=true;

		}
	}
	

	public void move() {
		x[0]+=vx;
		y[0]+=vy;

		for (int z = x.length-1; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (leftDirection) {
			x[0] -= speed;
		}

		if (rightDirection) {
			x[0] += speed;
		}

		if (upDirection) {
			y[0] -= speed;
		}

		if (downDirection) {
			y[0] += speed;
		}


	}

	public void actionPerformed(ActionEvent e) { 
		move();

		this.repaint();
	}

	
}
