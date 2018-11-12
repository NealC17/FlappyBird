package snakeGen1;

import java.awt.*;

import javax.swing.*;


public class Snake extends JPanel{
	private int x,y;
	public static final int width = 20;
	private Rectangle[] body;
	private Color color;
	
	Snake(int x, int y){
		this.x=x;
		this.y=y;
		color = Color.green;
		
		
		body = new Rectangle[100];
		
		
	}
	
	public void newPos(){
		for(int i = 0; i < body.length;i++){
			body[i]=new Rectangle(x,y+width*i,width,width);
		}
	}
	
	
}
