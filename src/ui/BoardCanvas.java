package ui;

import game.Room.Type;
import game.Square;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.JPanel;

public class BoardCanvas extends JPanel{

	private int canvas_width = 600;
	private int canvas_height = 600;
	private final int grid_lines = 24;
	private final int grid_lines_v = 23;
	private final int grid_size = (int)canvas_width / grid_lines;
	private int square_x = 0;
	private int square_y = 0;
	private int piece_x = 0;
	private int piece_y = 0;
	private int piece_size = grid_size-1;
	private Board board;

	public BoardCanvas(Board gameBoard){
		this.board = gameBoard;

	}
	public Board getGameBoard(){
		return board;
	}
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
	/**
	 * draws a square on the board.
	 * @param 
	 * @param 
	 */
	public void drawSquare(){
		Square[][] squares = board.getBoardArray();
		int x = 0;
		int y = 0;
		while(x<squares.length){
			while(y<squares[x].length){
				switch(squares[x][y].getID().ordinal()){
				case 1:
				
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 11:
				case 12:
				case 13:
				case 14:
				case 15:
				case 16:
				case 17:
				case 18:
				case 19:
				case 20:
				case 21:
				case 22:
				}
			}
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(0,0,canvas_width,canvas_height);
		g.setColor(Color.BLACK);
		drawGrid(g);


		g.setColor(Color.GREEN);
		g.fillOval(piece_x,piece_y,piece_size,piece_size);
	}
	//square selection logic stuff, needs refactoring.
	/**
	 * this probably needs renaming it returns the grid 
	 * postition of a square the  mouse clicks in
	 * @param x
	 * @param y
	 */
	public void setSquare(int x,int y){
		square_x = x/grid_size;
		square_y = (y/grid_size)-1;//the -1 is a "black"magic number im not sure why but this wont work with out it.
	}
	/**
	 * this also may need a rename this converts
	 * an arbitrary x y to an x y
	 * Relative to the grid
	 * kinda like a snap to grid.
	 */
	public void setPiece(){
		piece_size = grid_size-1;
		piece_x = square_x*grid_size+1;
		piece_y = square_y*grid_size+1;
	}
	/**
	 * all this dose atm is that thing where the peice gets bigger when you click
	 */
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


	public void setNextPicture(){

	}

}
