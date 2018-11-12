package snakeGen2;

import javax.swing.JFrame;

public class Coordinator2 {

	public static final int boardWidth = 800, boardHeight = 800;
	JFrame frame;
	Snake2 s,s1 ;
	
	Coordinator2(){
		
		Snake2 s = new Snake2();
		
		frame = new JFrame("game ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,Coordinator2.boardWidth+Snake2.width/2,Coordinator2.boardHeight+Snake2.width*3/2);

		frame.getContentPane().add(s);
		frame.addKeyListener(s);

		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		System.out.println();
		Coordinator2 a = new Coordinator2();

	}

}
