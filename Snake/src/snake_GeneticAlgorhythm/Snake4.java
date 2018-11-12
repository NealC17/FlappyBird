package snake_GeneticAlgorhythm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.Timer;

import snakeGen1.Coordinator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake4 extends JPanel{



	private int vx ,vy;
	private int[] x;
	private int[] y, direction;
	private boolean[] shown;
	private Food f;
	private int shownUpTo;
	private int dCount, dotsEaten;
	
	public static final int width=30;
	public static final int speed = width;
	private int lastX;
	private int lastY;
	public static final int arrayLength =Coordinator.boardHeight*Coordinator.boardWidth ;

	private boolean upDirection,downDirection,leftDirection,rightDirection;

	double fitness;

	private boolean isDead;
	private Color c;
	private int count = 0;


	public Snake4(){
		
		int a = (int)(Math.random()*100);
		if(a>75)c=Color.red;
		else if(a>50)c=Color.blue;
		else if(a>25)c=Color.green;
		else c=Color.magenta;
		
		dCount=0;
		shownUpTo=1;
		x = new int[arrayLength];
		y=new int[arrayLength];
		shown = new boolean[arrayLength];
		direction = new int[arrayLength];
		
		
		f=new Food();

		x[0]=250;
		y[0]=250;

		for(int i = 1; i < x.length; i ++){
			x[i]=x[0]+i*width;
			y[i]=y[0];
			direction[i]=(int)(Math.random()*8);
			
		}
		upDirection=false;
		downDirection=false;
		leftDirection=false;
		rightDirection=false;

	}

	public int getLastX(){
		lastX=x[0];
		return lastX;
	}

	public int getLastY(){
		lastY=y[0];
		return lastY;
	}


	public void paintComponent(Graphics g){

		g.setColor(c);

		f.drawFood(g);


		g.fillRect(x[0], y[0], width, width);

		g.setColor(Color.black);
		g.drawRect(x[0], y[0], width, width);
		
		for(int i = 1; i < x.length;i++){
			if(shown[i]){
				
				g.setColor(Color.white);
				g.fillRect(x[i], y[i], width, width);
				g.setColor(Color.black);
				g.drawRect(x[i], y[i], width, width);
			}
			

		}
	}


	
	public void move() {
		if(isDead)return;
		count ++;
		x[0]+=vx;
		y[0]+=vy;

		if(direction[dCount]==0){
			upDirection=true;
			downDirection=false;
			leftDirection=false;
			rightDirection=false;
		}
		else if(direction[dCount]==1){
			upDirection=false;
			downDirection=true;
			leftDirection=false;
			rightDirection=false;
		}
		else if(direction[dCount]==2){
			upDirection=false;
			downDirection=false;
			leftDirection=true;
			rightDirection=false;
		}
		else if(direction[dCount]==3){
			upDirection=false;
			downDirection=false;
			leftDirection=false;
			rightDirection=true;
		}
		
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

		dCount++;
		if(dCount>=direction.length)isDead= true;

	}

	
	
	


	public void isCollided() {	
		if(x[0]<0||x[0]>Coordinator4.boardWidth+width||y[0]<0||y[0]>Coordinator4.boardWidth-width){
			isDead= true;
		}
		for(int i = 1; i < x.length;i++){
			if(x[i]==x[0]&&y[i]==y[0]&&shown[i]){
				isDead=true;
			}
		}
	}

	public void eatenFood(){

		if(f.getX()>=x[0]&& f.getX()<=x[0]+width && f.getY()>=y[0] && f.getY()<=y[0]+width){
			
			dotsEaten++;
			shownUpTo+=3;
			for(int i = 1; i < shownUpTo;i++){
				shown[i]=true;
			}

			f.setNewPos();

		}

	}

	public boolean isDead() {
		return isDead;
	}
	
	public void crossOver(){
		
	}
	
	public void calculateFitness(){
		//fitness function
		fitness=(dotsEaten*dotsEaten);
		//fitness=dotsEaten;
	}

	public Snake4 reproduce() {
		
		Snake4 baby = new Snake4();
		
		baby.clone(x,y);
		
		return baby;
		
	}

	private void clone(int[] x2, int[] y2) {
		
		this.x=x2;
		this.y=y2;
		
	}

	public void mutate() {
		double mutationRate = 0.99;
		
		for(int i = 2; i < x.length;i++){
			if(Math.random()<mutationRate){
				x[i]=(int)(Math.random()*8);
				y[i]=(int)(Math.random()*8);
			}
		}
		
		
	}
	
	public void setXY(int a){
		x[0]=a;
		y[0]=a;
		}

}
