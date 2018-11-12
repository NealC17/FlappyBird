package snake_GeneticAlgorhythm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Food{
	private int[] x,y;
	private int i;

	public static final int width=Snake4.width/2;
	
	
	public Food(){
		x = new int[]{250,300,120,50,5,60,100,190,100,10};
		
		y = new int[]{250,50,30,45,59,101,90};
		
		
		setNewPos();
	}
	
	
	
	public void drawFood(Graphics g){
		
		g.fillOval(x[i]-width/2, y[i]-width/2, width, width);
	}	
	
	public int getX(){return x[i];}
	public int getY(){return y[i];}
	
	public void setNewPos(){
		
		i++;
		if(i==9)i=1;
	}
}
