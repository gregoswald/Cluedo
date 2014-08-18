package ui;
import game.Envelope;
import game.Green;
import game.Mustard;
import game.Peacock;
import game.Plum;
import game.Scarlett;
import game.White;

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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class BoardFrame extends JFrame implements MouseListener,MouseMotionListener{
	int mouseClickX;
	int mouseClickY;
	private static int windowHeight = 850;
	private int sidePanelWidth = 250;
	private final BoardCanvas canvas;
	private JPanel sidePanel;
	private JScrollPane textSP;
	private static JTextArea textOutput;
	private GridBagConstraints grid;
	private JButton accuseButton;
	private JButton endTurnButton;
	private JButton revealCardsButton;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JButton diceRollButton;
	public BoardFrame(){
		super("CLUEDO");		
		canvas = new BoardCanvas(new Board());
		setLayout(new BorderLayout()); 
		setupComponents();
		add(menuBar, BorderLayout.NORTH);
		add(canvas, BorderLayout.WEST); //Lays out board in center, adds the canvas
		add(sidePanel, BorderLayout.EAST);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false); //prevents board from being resizable
		setVisible(true); 
		addMouseListener(this);




	}

	/**
	 * Method which sets up the main window components for the game
	 */

	private void setupComponents(){
		// Setup grid
		grid = new GridBagConstraints();
		// Setup JMenuBar

		// MenuBar
		menuBar = new JMenuBar();
		// Menu	
		menu = new JMenu("Menu");
		menu.getAccessibleContext().setAccessibleDescription(
				"Menu Bar");
		//create menuitems
		menuItem = startNewGame();

		//add items
		menuBar.add(menu);
		menu.add(menuItem);


		// Setup sidepanel
		sidePanel = new JPanel(new GridBagLayout());
		sidePanel.setSize(sidePanelWidth, windowHeight);
		sidePanel.setBackground(Color.gray);

		// Setup components for sidePanel
		// Text Area
		textOutput = new JTextArea(5, 25);
		textOutput.setEditable(false);
		textOutput.setText("  Welcome to Cluedo");
		textSP = new JScrollPane(textOutput);
		accuseButton = newAccuseButton();
		endTurnButton = newEndTurnButton();
		revealCardsButton = newRevealCardsButton();
		diceRollButton = newDiceRollButton(canvas);
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
		grid.gridx = 1;
		grid.gridy = 3;
		sidePanel.add(diceRollButton, grid);

	}
	/**
	 * Method which starts a new game with 2-6 players
	 * @return JMenuItem stating asking how many players in the new game, then starting a new game
	 */
	private JMenuItem startNewGame(){
		JMenuItem startNewGameItem = new JMenuItem("New Game");
		startNewGameItem.addActionListener(new ActionListener(){

			private JButton submitButton;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				final Window mainWindow = SwingUtilities.windowForComponent(menuItem);
				final JDialog title = new JDialog(mainWindow, "New Game");

				title.setLocation(200,250);
				title.setModal(true);

				//Number of Players Panel
				JPanel numberPlayersPanel = new JPanel();

				//Using Radio Buttons for Characters 2-6 players (Cant have one, 1 player would be pointless)
				final JRadioButton player2 = new JRadioButton("2 Players");
				player2.setActionCommand("Play with 2 Players");
				player2.setSelected(true);

				final JRadioButton player3 = new JRadioButton("3 Players");
				player3.setActionCommand("Play with 3 Players");
				player3.setSelected(true);

				final JRadioButton player4 = new JRadioButton("4 Players");
				player4.setActionCommand("Play with 4 Players");
				player4.setSelected(true);

				final JRadioButton player5 = new JRadioButton("5 Players");
				player5.setActionCommand("Play with 5 Players");
				player5.setSelected(true);

				final JRadioButton player6 = new JRadioButton("6 Players");
				player6.setActionCommand("Play with 6 Players");
				player6.setSelected(true);

				//Make a group for the buttons
				final ButtonGroup buttonGroup = new ButtonGroup();
				buttonGroup.add(player2);
				buttonGroup.add(player3);
				buttonGroup.add(player4);
				buttonGroup.add(player5);
				buttonGroup.add(player6);

				//Submit button and logic for new game window
				submitButton = new JButton("Submit");
				submitButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						int players;
						if(player2.isSelected()){
							players = 2;
							//enterPlayerName(2);
						}
						else if(player3.isSelected()){
							players = 3;
							//enterPlayerName(3);

						}
						else if(player4.isSelected()){
							players = 4;
							//enterPlayerName(4);
						}
						else if(player5.isSelected()){
							players = 5;
							//enterPlayerName(5);
						}
						else{
							players = 6;
							//enterPlayerName(6);
						}

						//Now that number of players is established, set the player characters

						canvas.getGameBoard().addPlayer(0, new Scarlett());
						if(players >= 2){
							canvas.getGameBoard().addPlayer(1, new Mustard());

						}
						if(players >= 3){
							canvas.getGameBoard().addPlayer(2, new White());
						}
						if(players >= 4){
							canvas.getGameBoard().addPlayer(3, new Green());
						}
						if(players >= 5){
							canvas.getGameBoard().addPlayer(4, new Peacock());
						}
						if(players >= 6){
							canvas.getGameBoard().addPlayer(5, new Plum());
						}


						//start the game again
						//Envelope envelope = new Envelope();

						title.dispose();
						canvas.repaint();
					}

				});
				numberPlayersPanel.add(player2);
				numberPlayersPanel.add(player3);
				numberPlayersPanel.add(player4);
				numberPlayersPanel.add(player5);
				numberPlayersPanel.add(player6);
				numberPlayersPanel.add(submitButton);
				title.add(numberPlayersPanel);
				title.pack();
				title.setVisible(true);







			}

		});




		return startNewGameItem;
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
		System.out.println(e.getX()+":"+e.getY());
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
	/**
	 * Method that creates a button containing logic for the accusations - Past being a nice interface, actually does nothing yet as accuse is unimplemented as of yet
	 * @return Button containing logic for accuse Window
	 */
	public static JButton newAccuseButton(){
		final JButton button = new JButton("   Accuse   ");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Window window = SwingUtilities.windowForComponent(button);
				final JDialog dialog = new JDialog(window, "Accuse");
				dialog.setLocation(200, 350);
				dialog.setModal(true);
				JPanel cardsPanel = new JPanel();




				//DropDowns
				String[] murderersList = { "Miss Scarlett", "Col. Mustard", "Mrs. White", "Reverand Green", "Mrs. Peacock", "Prof. Plum"};
				final JComboBox<String> murderers = new JComboBox<String>(murderersList);
				String[] murderItemsList = { "Candlestick", "Dagger", "Lead Pipe", "Revolver", "Rope", "Spanner"};
				final JComboBox<String> murderItems = new JComboBox<String>(murderItemsList);
				String[] murderRoomList = {"Kitchen", "Ball Room", "Conservatory", "Dining Room", "Billiard Room", "Library", "Lounge", "Hall", "Study"}; 
				final JComboBox<String> murderRoom = new JComboBox<String>(murderRoomList);

				//Needs a check somewhere for whether the player is in a room

				//


				final JButton submit = new JButton("Submit");
				submit.addActionListener(new ActionListener() {


					public void actionPerformed(ActionEvent arg0) {

						dialog.dispose();
					}

				});

				//Could possibly add something to distinguish between accusing and checking within rooms?
				cardsPanel.add(murderers);
				cardsPanel.add(murderItems);
				cardsPanel.add(murderRoom);
				cardsPanel.add(submit);
				dialog.add(cardsPanel);
				dialog.pack();
				dialog.setVisible(true);




			}

		});
		return button;

	}


	/**
	 * Method which creates "End Turn" Button with its logic (For ending players turn and passing to the next player), and returns it
	 *
	 * @return JButton containing logic for Ending turn
	 */
	public static JButton newEndTurnButton(){
		final JButton button = new JButton("  End Turn  ");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {


			}

		});
		return button;

	}



	/**
	 * Method which creates "Reveal Cards" Button with its logic (For hiding and revealing the players hand), and returns it
	 *
	 * @return JButton containing logic for Hiding and Revealing Cards
	 */
	public static JButton newRevealCardsButton(){
		final JButton button = new JButton("Reveal Cards");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {


			}

		});
		return button;

	}



	/**
	 * Method which creates "Roll Dice" Button with its logic, and returns it
	 * @param canvas
	 * @return JButton containing logic for rolling dice
	 */
	public static JButton newDiceRollButton(final BoardCanvas canvas){
		final JButton button = new JButton("Roll Dice");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {canvas.getGameBoard().rollDice();}
		});
		return button;

	}


	/**
	 * Method which contains logic for setting up the players in the game
	 * @param players - Int describing how many players are to be in the game
	 */


	public void enterPlayerName(int players){
		if(players >=6){
			Window player6Window = SwingUtilities.windowForComponent(menuItem);
			JDialog player6Name = new JDialog(player6Window, "Player 6: Enter Name");
			player6Name.setLocation(200,250);
			player6Name.setModal(true);
			player6Name.pack();
			player6Name.setVisible(true);
		}

		if(players >= 5){
			Window player5Window = SwingUtilities.windowForComponent(menuItem);
			JDialog player5Name = new JDialog(player5Window, "Player 5: Enter Name");
			player5Name.setLocation(200,250);
			player5Name.setModal(true);
			player5Name.pack();
			player5Name.setVisible(true);
		}

		if(players >= 4){
			Window player4Window = SwingUtilities.windowForComponent(menuItem);
			JDialog player4Name = new JDialog(player4Window, "Player 4: Enter Name");
			player4Name.setLocation(200,250);
			player4Name.setModal(true);
			player4Name.pack();
			player4Name.setVisible(true);
		}

		if(players >= 3){
			Window player3Window = SwingUtilities.windowForComponent(menuItem);
			JDialog player3Name = new JDialog(player3Window, "Player 3: Enter Name");
			player3Name.setLocation(200,250);
			player3Name.setModal(true);
			player3Name.pack();
			player3Name.setVisible(true);
		}
		if(players >= 2){
			Window player2Window = SwingUtilities.windowForComponent(menuItem);
			JDialog player2Name = new JDialog(player2Window, "Player 2: Enter Name");
			player2Name.setLocation(200,250);
			player2Name.setModal(true);
			player2Name.pack();
			player2Name.setVisible(true);
		}
		if(players >= 1){
			Window player1Window = SwingUtilities.windowForComponent(menuItem);
			JDialog player1Name = new JDialog(player1Window, "Player 1: Enter Name");
			player1Name.setLocation(200,250);
			player1Name.setModal(true);
			player1Name.pack();
			player1Name.setVisible(true);
		}

	}

}
