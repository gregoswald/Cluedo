package ui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class BoardFrame extends JFrame implements MouseListener {
	BoardCanvas canvas;
	public BoardFrame(){
		canvas = new BoardCanvas();
		setLayout(new BorderLayout()); 
		add(canvas, BorderLayout.CENTER); //Lays out board in center, adds the canvas
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false); //prevents board from being resizable
		setVisible(true); 
		addMouseListener(this);
		
		
	}
	
	@Override

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * Will need to check that click space is not invalid. Will not move until release event.
	 */
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
