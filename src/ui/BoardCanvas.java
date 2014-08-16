package ui;

import game.Room.Type;
import game.Square;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.JPanel;

public class BoardCanvas extends JPanel{

	private int canvas_width = 812;
	private int canvas_height = 812;
	private final int grid_lines = 28;
	private final int grid_lines_v = 28;
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
	 * returns the color of the type of sq,
	 * returns null if passed a square that
	 * isnt part of the board. 
	 * @param 
	 * @param 
	 */
	private Color getBoardSqColor(Square sq){
		switch(sq.getID().ordinal()){
		case 0://lounge
		case 1://study 
		case 2://library
		case 3://cellar
		case 4://hall
		case 5://billard room
		case 6://ballroom
		case 7://kitchen
		case 8://conservitory
		case 9://diningroom
			return Color.LIGHT_GRAY;
		case 10://floor
			return null;
		case 11://portal
			return Color.ORANGE;
		case 12:
			return Color.DARK_GRAY;
		default:
			return null;
		}
	}


	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0,0,canvas_height,canvas_width);
		g.setColor(Color.BLACK);
		drawGrid(g);
		g.drawRect(1, 1,canvas_height-1,canvas_width-1);
		g.drawRect(2, 2,canvas_height-3,canvas_width-3);
		g.drawRect(3, 3,canvas_height-5,canvas_width-5);
		g.drawRect(4, 4,canvas_height-7,canvas_width-7);
		g.drawRect(5, 5,canvas_height-9,canvas_width-9);
		g.drawRect(6, 6,canvas_height-11,canvas_width-11);
		g.drawRect(7, 7,canvas_height-13,canvas_width-13);
		g.drawRect(8, 8,canvas_height-15,canvas_width-15);
		g.drawRect(9, 9,canvas_height-17,canvas_width-17);
		g.drawRect(10, 10,canvas_height-19,canvas_width-19);
		Square[][] squares = board.getBoardArray();
		int countY = 0;
		while(countY<squares.length){
			int countX = 0;
				while(countX<squares[0].length){
				//System.out.println("Drawing a:"+squares[countY][countX].getID()+"in square"+countY+":"+countX);
				Color currentColor = getBoardSqColor(squares[countY][countX]);
				if(currentColor!=null){
					g.setColor(currentColor);
					square_x = countX;
					square_y = countY;
					setPiece();
					g.fillRect(piece_x,piece_y,piece_size+1,piece_size+1);
					}
				countX++;
			}

			countY++;
		}

		
		g.setColor(Color.GREEN);
		g.fillOval(piece_x,piece_y,piece_size,piece_size);
	}
	//square selection logic stuff, needs refactoring.
	/**
	 * this probably needs renaming it sets the grid 
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
