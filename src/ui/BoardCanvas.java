package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.JPanel;

public class BoardCanvas extends JPanel{
	
	private int canvas_width = 600;
	private int canvas_height = 600;
	private final int grid_lines = 26;
	private final int grid_size = (int)canvas_width / grid_lines;
	private int player_token_x = 0;
	private int player_token_y = 0;
	public Dimension getPreferredSize(){
		return new Dimension(canvas_width,canvas_height);
	}

	public void drawGrid(Graphics g){
		 int count = 0;
		while(count < grid_lines+1){
			g.setColor(Color.BLACK);
			g.drawLine(0,grid_size*count,canvas_height,grid_size*count);
			g.drawLine(grid_size*count,0,grid_size*count,canvas_height);
			count++;
		}
	}
	public void drawCube(int x, int y){
		
	}
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		drawGrid(g);
		//g.fillRect(10, 10, 10, 10); //Not correct dimensions will need draw algorithm for a grid based on 2D array in Board.java
		g.setColor(Color.GREEN);
		g.fillRect(player_token_x,player_token_y,grid_size-1,grid_size-1);
	}
	/**
	 * Will move player piece x squares up or down
	 * @param x Moves piece x squares up or down on the board - (Negative is down, Positive up)
	 */
	public void movePiece(int x,int y){
		player_token_x = (x%26)*grid_size+1;
		player_token_y = (y%26)*grid_size+1;
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		System.out.println(x%26);
		System.out.println(y%26);
	}
	

}
