package ui;
import game.Room;
import game.Square.Type;
import game.Square;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Class Which constitutes the board logic within the Game
 * @author Jarred Hone, Greg Oswald
 *
 */

public class Board {

	private Square[][] board = new Square[24][24]; //2D Array representing the board
	public Board(){
		fillInitialArray();// will cause nullPointerException() if uncommented
	}



	public Square[][] getBoardArray(){
		return board;
	}


	/**
	 * Fills array with initial values from a text file using a parser - should only need to be called once and the base board will never change.
	 *	
	 * Is working now!!! I was trying to parse chars instead of strings.
	 */
	private void fillInitialArray(){

		File text;
		try{
			//Read File and set up Scanner
			int lineLength;
			int cursor;
			text = new File("parse.txt");
			System.out.println(text);
			Scanner scan = new Scanner(text);
			String letter = "x";
			while(scan.hasNextLine()){ //While there is a next line of input
				String line = scan.nextLine(); //Store the entire next line as a string
				lineLength = line.length();

				for(int x=0; x<board.length;x++){ //Loops along the line in sync with array
					cursor = 0;
					for(int y=0; y<board[0].length; y++){
					
							letter = Character.toString(line.charAt(y));
							System.out.println(letter);
						
						/**
						 * Parsing Begins
						 */ 

						//TODO Still needs to parse a letter for stairs which are a type of portal. They are not in the text file yet though
						if(letter.equals("s")){ //study
							board[x][y] = new Square(Type.STUDY);	


						}
						else if(letter.equals("w")){ //wall
							board[x][y] = new Square(Type.WALL);

						}
						else if(letter.equals("h")){ //hall
							board[x][y] = new Square(Type.HALL);

						}
						else if(letter.equals("d")){ //door
							board[x][y] = new Square(Type.DOOR);

						}
						else if(letter.equals("l")){ //Lounge
							board[x][y] = new Square(Type.LOUNGE);

						}
						else if(letter.equals("i")){ //Library
							board[x][y] = new Square(Type.LIBRARY);

						}
						else if(letter.equals("0")){ //Cellar
							board[x][y] = new Square(Type.CELLAR);

						}
						else if(letter.equals("p")){ //dining room
							board[x][y] = new Square(Type.DININGROOM);

						}
						else if(letter.equals("t")){ //Billiard Room
							board[x][y] = new Square(Type.BILLIARDROOM);

						}
						else if(letter.equals("b")){ //Ballroom
							board[x][y] = new Square(Type.BALLROOM);

						}
						else if(letter.equals("k")){ //Kitchen
							board[x][y] = new Square(Type.KITCHEN);

						}
						else if(letter.equals("c")){ //Conservatory
							board[x][y] = new Square(Type.CONSERVATORY);

						}
						/**
						 * Special Case - The Spawn points for the players.
						 */
						else if(letter.equals("1")){ //Professor Plum
							board[x][y] = new Square(Type.PLUM);

						}
						else if(letter.equals("2")){ //Miss Scarlett
							board[x][y] = new Square(Type.SCARLETT);

						}
						else if(letter.equals("3")){ //Col. Mustard
							board[x][y] = new Square(Type.MUSTARD);

						}
						else if(letter.equals("4")){ //Mrs Peacock
							board[x][y] = new Square(Type.PEACOCK);

						}
						else if(letter.equals("5")){ //Mr. Green
							board[x][y] = new Square(Type.GREEN);

						}
						else if(letter.equals("6")){ //Mrs White
							board[x][y] = new Square(Type.WHITE);

						}
						
					}
				}


			}
			  for(int i = 0; i < 20; i++)
			   {
			      for(int j = 0; j < 20; j++)
			      {
			         System.out.print(board[i][j].getID().toString());
			      }
			      System.out.println();
			   }


		}
		catch(FileNotFoundException e){
			System.out.println("File was not found");
		}


	}
}