package ui;
import game.Card;
import game.Envelope;
import game.Green;
import game.Mustard;
import game.Peacock;
import game.Player;
import game.Plum;
import game.Room;
import game.Scarlett;
import game.Square.Type;
import game.Square;
import game.White;
import game.playerCard;
import game.roomCard;
import game.weaponCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Class Which constitutes the board logic within the Game
 * @author Jarred Hone, Greg Oswald
 *
 */

public class Board {
	private int dieOne;
	private int dieTwo;
	private Random rand = new Random();
	private Player[] players = new Player[7];
	private boolean solved;
	private Player winner;
	private int currentTurn;
	private final Square[][] board = new Square[27][26]; //2D Array representing the board
	private final Room STUDY = new Room(); 
	private final Room HALL = new Room();
	private final Room LOUNGE = new Room();
	private final Room DINING = new Room();
	private final Room BALLROOM = new Room(); 
	private final Room CONSERVATORY = new Room(); 
	private final Room LIBRARY = new Room(); 
	private final Room BILLIARDROOM = new Room();
	private Envelope envelope;
	List<Card> deck = new ArrayList<Card>();
	public Board(){
		fillInitialArray();

	}
	public Square[][] getBoardArray(){
		return board;
	}
	
	
	/**
	 * Fills array with initial values from a text file using a parser - should only need to be called once and the base board will never change.
	 *	
	 * 
	 * @throws IOException 
	 * @throws FileNotFoundException
	 */
	private void fillInitialArray(){
		try{
			//Set up file reader
			int y=0;
			String nextToken;
			String line;
			BufferedReader fReader = new BufferedReader(new FileReader("parse.txt"));
			System.out.println("CHARS AS THEY ARE PARSED:");
			String[] chars;
			while(((line = fReader.readLine())!= null)){
				chars = line.split(" ");
				for(int x=0; x<board[0].length; x++){
					nextToken = chars[x];
					//TODO Still needs to parse a nextToken for stairs which are a type of portal. They are not in the text file yet though
					if(nextToken.equals("s")){ //study
						board[y][x] = new Square(Type.STUDY);	
						System.out.print("s");
					}
					else if(nextToken.equals("w")){ //wall
						board[y][x] = new Square(Type.WALL);
						System.out.print("w");
					}
					else if(nextToken.equals("h")){ //hall
						board[y][x] = new Square(Type.HALL);
						System.out.print("h");
					}
					else if(nextToken.equals("_")||nextToken.equals("|")){ //door
						board[y][x] = new Square(Type.BORDER);
						System.out.print(".");
					}
					else if(nextToken.equals("d")){ //door
						board[y][x] = new Square(Type.DOOR);
						System.out.print("d");
					}
					else if(nextToken.equals("l")){ //Lounge
						board[y][x] = new Square(Type.LOUNGE);
						System.out.print("l");
					}
					else if(nextToken.equals("i")){ //Library
						board[y][x] = new Square(Type.LIBRARY);
						System.out.print("i");
					}
					else if(nextToken.equals("f")){ //Library
						board[y][x] = new Square(Type.FLOOR);
						System.out.print("f");
					}
					else if(nextToken.equals("0")){ //Cellar
						board[y][x] = new Square(Type.CELLAR);
						System.out.print("0");
					}
					else if(nextToken.equals("p")){ //dining room
						board[y][x] = new Square(Type.DININGROOM);
						System.out.print("p");
					}
					else if(nextToken.equals("t")){ //Billiard Room
						board[y][x] = new Square(Type.BILLIARDROOM);
						System.out.print("t");
					}
					else if(nextToken.equals("b")){ //Ballroom
						board[y][x] = new Square(Type.BALLROOM);
						System.out.print("b");
					}
					else if(nextToken.equals("k")){ //Kitchen
						board[y][x] = new Square(Type.KITCHEN);
						System.out.print("k");
					}
					else if(nextToken.equals("c")){ //Conservatory
						board[y][x] = new Square(Type.CONSERVATORY);
						System.out.print("c");
					}
					/**
					 * Special Case - The Spawn points for the players.
					 */
					else if(nextToken.equals("1")){ //Professor Plum
						board[y][x] = new Square(Type.PLUM);
						if(players[5]!=null){
						board[y][x].setOccupied(new Plum());
						}
						System.out.print('1');
					}
					else if(nextToken.equals("2")){ //Miss Scarlett
						board[y][x] = new Square(Type.SCARLETT);
						if(players[0]!=null){
						board[y][x].setOccupied(new Scarlett());
						}
						System.out.print('2');
					}
					else if(nextToken.equals("3")){ //Col. Mustard
						board[y][x] = new Square(Type.MUSTARD);
						if(players[1]!=null){
						board[y][x].setOccupied(new Mustard());
						}
						System.out.print('3');
					}
					else if(nextToken.equals("4")){ //Mrs Peacock
						board[y][x] = new Square(Type.PEACOCK);
						if(players[4]!=null){
						board[y][x].setOccupied(new Peacock());
						}
						System.out.print('4');
					}
					else if(nextToken.equals("5")){ //Mr. Green
						board[y][x] = new Square(Type.GREEN);
						if(players[3]!=null){
						board[y][x].setOccupied(new Green());
						}
						System.out.print('5');
					}
					else if(nextToken.equals("6")){ //Mrs White
						board[y][x] = new Square(Type.WHITE);
						if(players[2]!=null){
						board[y][x].setOccupied(new White());
						}
						System.out.print('6');
					}

				}
				System.out.println("  line:"+y);
				y++;
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File was not found");
		}
		catch(IOException e){
			System.out.println("IO Exception");
		}
		System.out.println("ARRAY CONTENTS:");
		for(int i = 0; i < 27; i++)
		{
			for(int j = 0; j < 26; j++)
			{
				if(board[i][j]==null){System.out.print("**null**");};
				if(board[i][j] != null){
					//System.out.print(board[i][j].getID()+",");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * Method to roll dice (Calculates number between 1 and 6 for two dice)
	 */
	public void rollDice(){
		dieOne = rand.nextInt(6) + 1;
		dieTwo = rand.nextInt(6) + 1;
		//System.out.println(dieOne); //Helper Method
		//System.out.println(dieTwo); //Helper Method
	}

	public void startGame(){
		int i = 0;
		while(players[i]!=null){
			//board[0][0].setOccupied(players[i]);
		}
	}


	/**
	 * Checks if the player is making a valid move - To be used in movement constraints which are unimplemented currently
	 * @param fromX
	 * @param fromY
	 * @param toX
	 * @param toY
	 * @return true or false, where true means a valid move based on dice roll + wall collision
	 */
	public boolean validMove( int fromX, int fromY,int toX, int toY){
		//not more spaces than than dice roll
		//with in bounds of board(wich is grid_size*1 less that canvas i beleive)
		//not out of turn
		//can only enter room through door


		if(board[toX][toY].getID().equals(Square.Type.BALLROOM)){
			return false;
		}
		if(board[toX][toY].getID().equals(Square.Type.BILLIARDROOM)){
			return false;
		}
		if(board[toX][toY].getID().equals(Square.Type.BORDER)){
			return false;
		}
		if(board[toX][toY].getID().equals(Square.Type.CELLAR)){
			return false;
		}
		if(board[toX][toY].getID().equals(Square.Type.CONSERVATORY)){
			return false;
		}
		if(board[toX][toY].getID().equals(Square.Type.DININGROOM)){
			return false;
		}
		if(board[toX][toY].getID().equals(Square.Type.HALL)){
			return false;
		}
		if(board[toX][toY].getID().equals(Square.Type.LOUNGE)){
			return false;
		}
		if(board[toX][toY].getID().equals(Square.Type.KITCHEN)){
			return false;
		}
		if(board[toX][toY].getID().equals(Square.Type.LIBRARY)){
			return false;
		}
		if(board[toX][toY].getID().equals(Square.Type.STUDY)){
			return false;
		}

		return true;
	}


	/**
	 * Unimplemented Feature - Create Hand for Player
	 */
	public void createHand(){

	}

	/**
	 * Adds a player to the list of players, used in boardFrame when creating new players
	 * @param playerNo
	 * @param character
	 */
	public void addPlayer(int playerNo, Player character){
		if(playerNo <= 6 && playerNo >= 0){
			players[playerNo] = character;
		}
	}


	/**
	 * Creates a deck out of randomised cards, leaving one in each category out for the envelope	
	 */
	public void makeDeck(){
		List<Card> people = new ArrayList<Card>();
		List<Card> weapons = new ArrayList<Card>();
		List<Card> rooms = new ArrayList<Card>();
		Card envelopeRoom;
		Card envelopeWeapon;
		Card envelopePerson;

		//Deals with room cards
		rooms.add(new roomCard("Kitchen"));
		rooms.add(new roomCard("Ballroom"));
		rooms.add(new roomCard("Conservatory"));
		rooms.add(new roomCard("Diningroom"));
		rooms.add(new roomCard("Billiardroom"));
		rooms.add(new roomCard("Library"));
		rooms.add(new roomCard("Lounge"));
		rooms.add(new roomCard("Hall"));
		rooms.add(new roomCard("Study"));
		Collections.shuffle(rooms);
		envelopeRoom = rooms.remove(rooms.size());

		//Deals with weapon cards
		weapons.add(new weaponCard("CandleStick"));
		weapons.add(new weaponCard("Dagger"));
		weapons.add(new weaponCard("Lead Pipe"));
		weapons.add(new weaponCard("Revolver"));
		weapons.add(new weaponCard("Rope"));
		weapons.add(new weaponCard("Spanner"));
		Collections.shuffle(weapons);
		envelopeWeapon = weapons.remove(weapons.size());

		//Deals with player cards
		people.add(new playerCard("Miss Scarlett"));
		people.add(new playerCard("Colonel Mustard"));
		people.add(new playerCard("Mrs. White"));
		people.add(new playerCard("The Reverend Green"));
		people.add(new playerCard("Mrs. Peacock"));
		people.add(new playerCard("Professor Plum"));
		Collections.shuffle(weapons);
		envelopePerson = people.remove(people.size());

		//Make the envelope from the 3 cards left over
		makeEnvelope(envelopePerson, envelopeWeapon, envelopeRoom);
		
		//Make Deck
		deck.addAll(people);
		deck.addAll(weapons);
		deck.addAll(rooms);
		Collections.shuffle(deck);
		
		




	}


	/**
	 * Takes the three leftover cards from the deck and creates the envolope
	 * @param murderer
	 * @param murderWeapon
	 * @param murderRoom
	 */

	public void makeEnvelope(Card murderer, Card murderWeapon, Card murderRoom){

		envelope = new Envelope(murderer, murderWeapon, murderRoom);


	}


	/**
	 *  Getter Method for the Envelope
	 * @return the Envelope
	 */
	public Envelope getEnvelope(){
		return envelope;
	}


	/**
	 * Getter method for the player
	 * @param playerNumber
	 * @return the player and int x in the list of players
	 */
	public Player getPlayer(int playerNumber){
		return players[playerNumber];
	}
	
	public List getDeck(){
		return deck;
	}
	

}