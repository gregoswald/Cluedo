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
	private int square_x = 0;
	private int square_y = 0;
	private int piece_x = 0;
	private int piece_y = 0;
	private int piece_size = grid_size-1;
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
		g.setColor(Color.GRAY);
		g.fillRect(0,0,canvas_width,canvas_height);
		g.setColor(Color.BLACK);
		drawGrid(g);
		

		g.setColor(Color.GREEN);
		g.fillOval(piece_x,piece_y,piece_size,piece_size);
	}
	
	public void setSquare(int x,int y){
		square_x = x/grid_size;
		square_y = (y/grid_size)-1;
	}
	public void setPiece(){
		piece_size = grid_size-1;
		piece_x = square_x*grid_size+1;
		piece_y = square_y*grid_size+1;
	}
	public void selectPiece(){
		//is there a piece in the current square or whatever should probs go here
		piece_x = piece_x-3;
		piece_y = piece_y-3;
		piece_size = piece_size+6;
	}
	public void movePiece(int x,int y){
		System.out.println("x:"+x+" y:"+y);
		piece_x = x;
		piece_y = y;
		
	}
	

}
