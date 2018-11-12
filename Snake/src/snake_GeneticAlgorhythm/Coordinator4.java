package snake_GeneticAlgorhythm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import snakeGen1.Snake;


public class Coordinator4 extends JPanel{

	public static final int boardWidth =30*Snake4.width, boardHeight = 30*Snake4.width;
	static JFrame frame;
	static Snake4[] s;
	static boolean gameOn;
	private static double sum = 0;

	public Coordinator4(){

		s = new Snake4[100];

		for(int i = 0; i < s.length;i++){
			s[i]=new Snake4();
			this.add(s[i]);
		}

		frame = new JFrame("game ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,Coordinator4.boardWidth+Snake4.width,Coordinator4.boardHeight+Snake4.width);
		this.setBackground(Color.black);
		frame.getContentPane().add(this);

		frame.setVisible(true);


	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0; i < s.length;i++){
			if(!s[i].isDead())s[i].paintComponent(g);
		}
	}

	public static void main(String[] args) {

		Coordinator4 a = new Coordinator4();

		while(true){

			for(int i = 0; i < s.length;i++){
				s[i].isCollided();
				s[i].move();
				s[i].eatenFood();
				
			}
			
			if(allSnakesDead()){
				calculateFitnessSum();
				doNaturalSelection();
				//crossOver();
				mutateBabies();
				
				
			}
			
			
			
			frame.repaint();
			try {
				Thread.sleep(62);
			} catch (InterruptedException e) { }
		}



	}


	private static void mutateBabies() {
		
		for(int i = 0; i < s.length;i++){
			s[i].mutate();
		}
		
		
	}

	public static boolean allSnakesDead(){
		for(int i = 0; i < s.length;i++){
			if(!s[i].isDead())return false;
		}
		return true;
	}

	public static void doNaturalSelection(){
		Snake4 parent;
		Snake4[] newSnakes = new Snake4[s.length];
		for(int i = 0; i < newSnakes.length;i++){
			//select parent based on fitness
			 parent = selectParent();
			
			parent.setXY(300);
			//force them to reproduce
			newSnakes[i]=parent.reproduce();
		}
		
		
		s=newSnakes;
	}
	private static void calculateFitness(){
		
		for(int i = 0; i < s.length;i++){
			s[i].calculateFitness();
		}
	}
	private static void calculateFitnessSum(){
		calculateFitness();
		for(int i = 0; i < s.length;i++){
			sum+=s[i].fitness;
		}
	}

	private static Snake4 selectParent() {
		double rand= Math.random()*sum, runningSum=0;
		System.out.println(rand + " " + sum);
		for(int i = 0; i < s.length;i++){
			runningSum+=s[i].fitness;
			if(runningSum>rand) return s[i];
		}
	
		return s[s.length-1];
	}
}
