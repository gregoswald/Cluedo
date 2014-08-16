package ui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

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
	private JButton accuseButton;
	private JButton endTurnButton;
	private JButton revealCardsButton;
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
				accuseButton = newAccuseButton();
				endTurnButton = newEndTurnButton();
				revealCardsButton = newRevealCardsButton();
				//Add components
				grid.gridwidth = 3;
				grid.gridx = 0;
				grid.gridy = 0;
				sidePanel.add(textSP, grid);
				grid.gridwidth = 1;
				grid.gridx = 0;
				grid.gridy = 2;
				sidePanel.add(accuseButton, grid);
				grid.gridx = 1;
				sidePanel.add(endTurnButton, grid);
				grid.gridx = 2;
				sidePanel.add(revealCardsButton, grid);
				
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
		canvas.selectPiece(e.getX(), e.getY());
		canvas.repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		canvas.setPiece(e.getX(), e.getY());
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

public static JButton newAccuseButton(){
	final JButton button = new JButton("   Accuse   ");
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Window mainWindow = SwingUtilities.windowForComponent(button);
			final JDialog dialog = new JDialog(mainWindow, "Accuse");
			dialog.setLocation(50, 50);
			dialog.setSize(700,700);
			dialog.setModal(true);
			JPanel cardsPanel = new JPanel();
			dialog.add(cardsPanel);
			dialog.setVisible(true);
			
		}
		
	});
	return button;

}

public static JButton newEndTurnButton(){
	final JButton button = new JButton("  End Turn  ");
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			
		}
		
	});
	return button;

}

public static JButton newRevealCardsButton(){
	final JButton button = new JButton("Reveal Cards");
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			
		}
		
	});
	return button;

}

}
