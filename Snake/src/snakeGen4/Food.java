package snakeGen4;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Food{
	private int x,y;
	private Color color;
	public static final int width=Snake4.width/2;
	
	
	public Food(){
		x=(int)(Math.random()*Coordinator4.boardWidth);
		y=(int)(Math.random()*(Coordinator4.boardHeight));
	}
	
	
	
	public void drawFood(Graphics g){
		g.setColor(Color.blue);
		g.fillOval(x-width/2, y-width/2, width, width);
	}	
	
	public int getX(){return x;}
	public int getY(){return y;}
	
	public void setNewPos(int[] xx, int[] yy, boolean[] shown){
		x=(int)(Math.random()*Coordinator4.boardWidth);
		y=(int)(Math.random()*(Coordinator4.boardHeight));
		
		
		for(int i = 0; i < Snake4.arrayLength;i++){
			if(xx[i]==xx[0]&&yy[i]==yy[0]&&shown[i]){
				setNewPos(xx,yy,shown);
			}
		}
		
	}
}
