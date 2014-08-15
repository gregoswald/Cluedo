package ui;
import game.Room;
import game.Square.Type;
import game.Square;

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

	private Square[][] board = new Square[25][24]; //2D Array representing the board
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
	 * @throws IOException 
	 */
	private void fillInitialArray(){

//I spent a few hours trying to debug this, it appears to fill the array partially. the values in the array are in the correct order but i cant figure out why only some values will go in
		try{
			//Read File and set up Scanner
			int x=0;
			char nextToken;
			String line;
			BufferedReader br = new BufferedReader(new FileReader("parse.txt"));
			//text = new File("parse.txt");
			//System.out.println(text);
			//Scanner scan = new Scanner(text);
			char[] chars;
			while(((line = br.readLine())!= null)){
				System.out.println(line);
				chars = line.toCharArray();
				//While there is a next line of input

				for(int y=0; y<board[x].length; y++){
					nextToken = chars[y];



					/**
					 * Parsing Begins
					 */ 

					//TODO Still needs to parse a nextToken for stairs which are a type of portal. They are not in the text file yet though
					if(nextToken == ('s')){ //study
						board[x][y] = new Square(Type.STUDY);	


					}
					else if(nextToken==('w')){ //wall
						board[x][y] = new Square(Type.WALL);

					}
					else if(nextToken==('h')){ //hall
						board[x][y] = new Square(Type.HALL);

					}
					else if(nextToken==('d')){ //door
						board[x][y] = new Square(Type.DOOR);

					}
					else if(nextToken==('l')){ //Lounge
						board[x][y] = new Square(Type.LOUNGE);

					}
					else if(nextToken==('i')){ //Library
						board[x][y] = new Square(Type.LIBRARY);

					}
					else if(nextToken==('0')){ //Cellar
						board[x][y] = new Square(Type.CELLAR);

					}
					else if(nextToken==('p')){ //dining room
						board[x][y] = new Square(Type.DININGROOM);

					}
					else if(nextToken==('t')){ //Billiard Room
						board[x][y] = new Square(Type.BILLIARDROOM);

					}
					else if(nextToken==('b')){ //Ballroom
						board[x][y] = new Square(Type.BALLROOM);

					}
					else if(nextToken==('k')){ //Kitchen
						board[x][y] = new Square(Type.KITCHEN);

					}
					else if(nextToken==('c')){ //Conservatory
						board[x][y] = new Square(Type.CONSERVATORY);

					}
					/**
					 * Special Case - The Spawn points for the players.
					 */
					else if(nextToken==('1')){ //Professor Plum
						board[x][y] = new Square(Type.PLUM);

					}
					else if(nextToken==('2')){ //Miss Scarlett
						board[x][y] = new Square(Type.SCARLETT);

					}
					else if(nextToken==('3')){ //Col. Mustard
						board[x][y] = new Square(Type.MUSTARD);

					}
					else if(nextToken==('4')){ //Mrs Peacock
						board[x][y] = new Square(Type.PEACOCK);

					}
					else if(nextToken==('5')){ //Mr. Green
						board[x][y] = new Square(Type.GREEN);

					}
					else if(nextToken==('6')){ //Mrs White
						board[x][y] = new Square(Type.WHITE);

					}

				}
				x++;
			}
			for(int i = 0; i < 20; i++)
			{
				for(int j = 0; j < 20; j++)
				{
					if(board[i][j] != null){
						System.out.print(board[i][j].getID().toString());
					}
				}
				System.out.println();
			}





		}
		catch(FileNotFoundException e){
			System.out.println("File was not found");
		}
		catch(IOException e){
			System.out.println("IO Exception");
		}


	}
}