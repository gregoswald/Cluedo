package ui;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.JPanel;

public class BoardCanvas extends JPanel{



	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(10, 10, 10, 10); //Not correct dimensions will need draw algorithm for a grid based on 2D array in Board.java
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
