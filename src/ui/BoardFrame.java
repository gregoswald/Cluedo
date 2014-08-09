package ui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class BoardFrame extends JFrame implements MouseListener{
	BoardCanvas canvas;
	public BoardFrame(){
		super("CLUEDO");		
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}



}
