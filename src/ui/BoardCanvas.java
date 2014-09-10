package ui;

import game.Green;
import game.Mustard;
import game.Peacock;
import game.Player;
import game.Plum;
import game.Room.Type;
import game.Scarlett;
import game.Square;
import game.White;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.Random;

import javax.swing.*;

public class BoardCanvas extends JPanel{

	private int canvas_width = 624;
	private int canvas_height = 675;
	private final int grid_lines = 26;
	private final int grid_lines_y = 27;
	private final int grid_size = (int)canvas_width / grid_lines;
	private final int grid_size_y = (int)canvas_height / grid_lines_y;
	private Player selected;
	private int current_square_x = 0;
	private int current_square_y = 0;
	private int dest_square_x = 0;
	private int dest_square_y = 0;
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
	/**
	 * returns the color of the type of sq,
	 * returns null if passed a square that
	 * isnt part of the board. 
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
		case 12://door
			return Color.DARK_GRAY;
		case 13://border
			return Color.CYAN;
		default:
			return null;
		}
	}
	/**
	 * Gets colour for player Pieces
	 * @param p
	 * @return
	 */
	private Color getPColor(Player p){
		if(p instanceof White ){
			return Color.WHITE;
		}
		else if(p instanceof Green){
			return Color.GREEN;
		}
		else if(p instanceof Peacock){
			return Color.BLUE;
		}
		else if(p instanceof Plum){
			return Color.pink;
		}
		else if(p instanceof Scarlett){
			return Color.RED;
		}
		return Color.yellow;
	}
	
	
	/**
	 * Paints canvas 
	 */
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0,0,canvas_width,canvas_height);
		g.setColor(Color.BLACK);
		int count = 0;
		while(count < grid_lines+1){
			g.setColor(Color.BLACK);
			g.drawLine(0,grid_size_y*count,canvas_height,grid_size_y*count);
			g.drawLine(grid_size*count,0,grid_size*count,canvas_height);
			count++;
		}
		Square[][] boardSquares = board.getBoardArray();
		int countY = 0;
		while(countY<boardSquares.length){
			int countX = 0;
			while(countX<boardSquares[0].length){
				//System.out.println("Drawing a:"+squares[countY][countX].getID()+"in square"+countY+":"+countX);
				int sqx = countX*grid_size;
				int sqy = countY*grid_size_y;
				Color currentColor = getBoardSqColor(boardSquares[countY][countX]);
				if(currentColor!=null){
					g.setColor(currentColor);
					g.fillRect(sqx,sqy,grid_size,grid_size_y);
				}
				if(boardSquares[countY][countX].getOccupied()!=null){
					g.setColor(getPColor(boardSquares[countY][countX].getOccupied()));
					g.fillOval(sqx,sqy,piece_size,piece_size);
					g.setColor(Color.black);
					g.drawOval(sqx,sqy,piece_size,piece_size);
					g.drawOval(sqx+5,sqy+5,piece_size-10,piece_size-10);
					g.drawOval(sqx+8,sqy+8,piece_size-16,piece_size-16);
				}
				countX++;
			}
			countY++;
		}
		((Graphics2D)g).setStroke(new BasicStroke(2f));
		g.setColor(Color.black);
		g.drawRect(0, 0,canvas_width-1,canvas_height-1);
	}
	
	
	/**
	 * Algorithm which detects where a piece has been move too after being detected
	 * @param x
	 * @param y
	 */
	public void setPiece(int x,int y){
		//if((x>grid_size)&&(x<grid_size*grid_lines)&&(y>grid_size_y)&&(y<grid_size_y*grid_lines_y)){
		dest_square_x = x/grid_size;
		dest_square_y = (y/grid_size_y)-2;
		if(board.getBoardArray()[dest_square_y][dest_square_x].getOccupied()==null&&selected!=null){
			
			board.getBoardArray()[dest_square_y][dest_square_x].setOccupied(selected);
			board.getBoardArray()[current_square_y][current_square_x].setOccupied(null);
			selected.setPos(board.getBoardArray()[current_square_y][current_square_x]);
			selected = null;
		
			
		}
		//}
		else{
			board.getBoardArray()[current_square_y][current_square_x].setOccupied(selected);
			selected = null;
		}
	}
	
	
	/**
	 * Algorithm which detects when a piece is clicked, so that it may be dragged
	 * @param x
	 * @param y
	 */
	public void selectPiece(int x,int y){
		if(x>0&&x<canvas_width&&y>0&&y<canvas_height){
		current_square_x = x/grid_size;
		current_square_y = (y/grid_size_y)-2; 
		if(board.getBoardArray()[current_square_y][current_square_x].getOccupied()!=null){
			selected = board.getBoardArray()[current_square_y][current_square_x].getOccupied();
			System.out.println("SELECTED:"+board.getBoardArray()[current_square_y][current_square_x].getOccupied()+" @"+current_square_x+":"+current_square_y);
		}
	}
	}
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void movePiece(int x,int y){
		System.out.println("x:"+x+" y:"+y);
		piece_x = x;
		piece_y = y;
	}
	
	
	public void setNextPicture(){

	}

}
