package ui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class BoardFrame extends JFrame implements MouseListener,MouseMotionListener{
	int mouseClickX;
	int mouseClickY;
	
	BoardCanvas canvas;
	public BoardFrame(){
		super("CLUEDO");		
		canvas = new BoardCanvas(new Board());
		setLayout(new BorderLayout()); 
		add(canvas, BorderLayout.CENTER); //Lays out board in center, adds the canvas
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false); //prevents board from being resizable
		setVisible(true); 
		addMouseListener(this);


	}
	public BoardCanvas getCanvas(){
		return canvas;
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
		// TODO Auto-generated method stub2

	}
	@Override
	public void mousePressed(MouseEvent e) {
		canvas.selectPiece();
		canvas.repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		canvas.setSquare(e.getX(), e.getY());
		canvas.setPiece();
		//int count =0;
		//while(count < 300){
		//	canvas.movePiece(count, count);
		//	canvas.repaint();
		//count++;
		//}
		canvas.repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		canvas.movePiece(e.getX(), e.getY());
		canvas.repaint();
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}



}
