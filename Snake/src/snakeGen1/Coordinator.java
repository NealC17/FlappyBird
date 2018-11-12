package snakeGen1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Coordinator extends JPanel implements KeyListener, ActionListener{

	JPanel panel;
	JFrame frame;
	Timer tm;

	private int x = (int)(Math.random()*400), vx = 0;
	private int y = (int)(Math.random()*600), vy=5;
	public static final int boardWidth = 800, boardHeight = 800;

	Coordinator(){
		tm = new Timer(10,this );
		

		frame = new JFrame("game ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,boardWidth+Snake.width/2,boardHeight+Snake.width*3/2);

		frame.getContentPane().add(this);
		

		frame.setVisible(true);
		frame.addKeyListener(this);
		tm.start();


	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.black);
		g.fillRect(x, y, Snake.width, Snake.width);



	}

	public static void main(String args[]){

		Coordinator c = new Coordinator();
		


	}

	public void keyTyped(KeyEvent e) { }
	public void keyPressed(KeyEvent e) {	
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_DOWN){
			vy = 5;
			vx = 0;
		}
		else if (code == KeyEvent.VK_UP){
			vy = -5;
			vx = 0;
		}
		else if (code == KeyEvent.VK_LEFT){
			vy = 0;
			vx = -5;
		}
		else if (code == KeyEvent.VK_RIGHT){
			vy = 0;
			vx = 5;

		}
	}
	public void keyReleased(KeyEvent e) {}

	public void actionPerformed(ActionEvent e) { 

		
		x+=vx;
		y+=vy;

		this.repaint();


	}
}
