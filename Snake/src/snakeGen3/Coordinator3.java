package snakeGen3;

import javax.swing.JFrame;

public class Coordinator3 {

	public static final int boardWidth = 800, boardHeight = 800;
	JFrame frame;
	static Snake3 s ;
	
	public Coordinator3(){
		
		Snake3 s = new Snake3();
		frame = new JFrame("game ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,Coordinator3.boardWidth+Snake3.width/2,Coordinator3.boardHeight+Snake3.width*3/2);

		frame.getContentPane().add(s);
		frame.addKeyListener(s);

		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		System.out.println();
		Coordinator3 a = new Coordinator3();
		

	}

}
