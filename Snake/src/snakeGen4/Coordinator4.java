package snakeGen4;

import javax.swing.JFrame;

import snakeGen1.Coordinator;
import snakeGen1.Snake;

public class Coordinator4{

	public static final int boardWidth =30*Snake4.width, boardHeight = 30*Snake4.width;
	static JFrame frame;
	static Snake4 s ;
	static boolean gameOn;
	
	public Coordinator4(){
		
		s = new Snake4();
		frame = new JFrame("game ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,Coordinator4.boardWidth+Snake4.width,Coordinator4.boardHeight+Snake4.width);

		frame.getContentPane().add(s);
		frame.addKeyListener(s);
		
		frame.setVisible(true);
		
		gameOn = true;
		
	}

	public static void main(String[] args) {
		
		Coordinator4 a = new Coordinator4();
		
		while(!s.isCollided()){
			s.move();
			s.eatenFood();
			frame.repaint();
			try {
				Thread.sleep(75);
			} catch (InterruptedException e) { }
		}
		

	}

	

}
