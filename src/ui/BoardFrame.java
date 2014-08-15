package ui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BoardFrame extends JFrame implements MouseListener,MouseMotionListener{
	int mouseClickX;
	int mouseClickY;
	private static int windowHeight = 850;
	private int sidePanelWidth = 250;
	BoardCanvas canvas;
	private JPanel sidePanel;
	private JScrollPane textSP;
	private static JTextArea textOutput;
	private GridBagConstraints grid;
	public BoardFrame(){
		super("CLUEDO");		
		canvas = new BoardCanvas(new Board());
		setLayout(new BorderLayout()); 
		setupComponents();
		
		add(canvas, BorderLayout.WEST); //Lays out board in center, adds the canvas
		add(sidePanel, BorderLayout.EAST);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false); //prevents board from being resizable
		setVisible(true); 
		addMouseListener(this);
		
		


	}
	private void setupComponents(){
		// Setup the grid
				grid = new GridBagConstraints();
				
		// Setup the side panel
				sidePanel = new JPanel(new GridBagLayout());
				sidePanel.setSize(sidePanelWidth, windowHeight);
				sidePanel.setBackground(Color.gray);
				
				// Setup components to go into the sidePanel
				// Text Area
				textOutput = new JTextArea(5, 25);
				textOutput.setEditable(false);
				textOutput.setText("  Welcome to Cluedo");
				textSP = new JScrollPane(textOutput);
				sidePanel.add(textSP, grid);
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
