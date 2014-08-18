package ui;
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
	private Player[] players;
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
						board[y][x].setOccupied(new Plum());
						System.out.print('1');
					}
					else if(nextToken.equals("2")){ //Miss Scarlett
						board[y][x] = new Square(Type.SCARLETT);
						board[y][x].setOccupied(new Scarlett());
						System.out.print('2');
					}
					else if(nextToken.equals("3")){ //Col. Mustard
						board[y][x] = new Square(Type.MUSTARD);
						board[y][x].setOccupied(new Mustard());
						System.out.print('3');
					}
					else if(nextToken.equals("4")){ //Mrs Peacock
						board[y][x] = new Square(Type.PEACOCK);
						board[y][x].setOccupied(new Peacock());
						System.out.print('4');
					}
					else if(nextToken.equals("5")){ //Mr. Green
						board[y][x] = new Square(Type.GREEN);
						board[y][x].setOccupied(new Green());
						System.out.print('5');
					}
					else if(nextToken.equals("6")){ //Mrs White
						board[y][x] = new Square(Type.WHITE);
						board[y][x].setOccupied(new White());
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
	public void rollDice(){
		dieOne = rand.nextInt(6) + 1;
		dieTwo = rand.nextInt(6) + 1;
		System.out.println(dieOne);
		System.out.println(dieTwo);
	}
	
	public void startGame(){
		
	}
	
	public void createHand(){
		
	}
	public void addPlayer(int playerNo, Player character){
		if(playerNo <= 6 && playerNo >= 0){
			players[playerNo] = character;
		}
	}



}