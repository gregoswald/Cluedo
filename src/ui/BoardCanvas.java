package ui;

import java.awt.Dimension;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.JPanel;

public class BoardCanvas extends JPanel{

	private int canvas_width = 600;
	private int canvas_height = 600;

	public Dimension getPreferredSize(){
		return new Dimension(canvas_width,canvas_height);
	}

	public void drawGrid(int grid_lines,Graphics g){
		int grid_size = (int)canvas_width / grid_lines;
		int count = 0;
		while(count < grid_lines+1){
			g.setColor(Color.BLACK);
			g.drawLine(0,grid_size*count,canvas_height,grid_size*count);
			g.drawLine(grid_size*count,0,grid_size*count,canvas_height);
			count++;
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		drawGrid(26,g);
		//g.fillRect(10, 10, 10, 10); //Not correct dimensions will need draw algorithm for a grid based on 2D array in Board.java
}
	/**
	 * Will move player piece x squares up or down
	 * @param x Moves piece x squares up or down on the board - (Negative is down, Positive up)
	 */
	public void movePieceX(int x){

	}
	/**
	 * Will move player piece y squares left or right 
	 * @param y Moves piece y squares up or down on the board - (Negative left, Positive Right)
	 */
	public void movePieceY(int y){

	}

}
