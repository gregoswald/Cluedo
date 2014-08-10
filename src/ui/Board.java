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
	String filename;
	private Square[][] board = new Square[26][26]; //2D Array representing the board < -- Uninitialised
	public Board(){
		fillInitialArray();
	}
	/**
	 * Fills array with initial values from a text file using a parser - should only need to be called once and the base board will never change.
	 */
	public void setFileName(String filename){
		this.filename = filename;
			
		}
		
	
	private void fillInitialArray(){
		int x = 0;
		int y = 0;
		try{
			//Read File and set up Scanner
			File text = new File(filename);
			Scanner scan = new Scanner(text);
			String letter = "x";
			while(scan.hasNextLine()){ //While there is a next line of input
				String line = scan.nextLine(); //Store the entire next line as a string
				Scanner lineSplit = new Scanner(line); //New scanner on the string line to break it into parts.
				for(x=0; x<line.length();x++){ //Loops along the line in sync with array 
					if(lineSplit.hasNext()){
					letter = lineSplit.next(); //The letter we will be dealing with in the current iteration.
					}
					/**
					 * Parsing Begins
					 */ 

					//TODO Still needs to parse a letter for stairs which are a type of portal. They are not in the text file yet though
					if(letter.equals('s')){ //study
						board[x][y] = new Square(Type.STUDY);	


					}
					else if(letter.equals('w')){ //wall
						board[x][y] = new Square(Type.WALL);

					}
					else if(letter.equals('h')){ //hall
						board[x][y] = new Square(Type.HALL);

					}
					else if(letter.equals('d')){ //door
						board[x][y] = new Square(Type.DOOR);

					}
					else if(letter.equals('l')){ //Lounge
						board[x][y] = new Square(Type.LOUNGE);

					}
					else if(letter.equals('i')){ //Library
						board[x][y] = new Square(Type.LIBRARY);

					}
					else if(letter.equals('0')){ //Cellar
						board[x][y] = new Square(Type.CELLAR);

					}
					else if(letter.equals('p')){ //dining room
						board[x][y] = new Square(Type.DININGROOM);

					}
					else if(letter.equals('t')){ //Billiard Room
						board[x][y] = new Square(Type.BILLIARDROOM);

					}
					else if(letter.equals('b')){ //Ballroom
						board[x][y] = new Square(Type.BALLROOM);

					}
					else if(letter.equals('k')){ //Kitchen
						board[x][y] = new Square(Type.KITCHEN);

					}
					else if(letter.equals('c')){ //Conservatory
						board[x][y] = new Square(Type.CONSERVATORY);

					}
					/**
					 * Special Case - The Spawn points for the players.
					 */
					else if(letter.equals('1')){ //Professor Plum
						board[x][y] = new Square(Type.PLUM);

					}
					else if(letter.equals('2')){ //Miss Scarlett
						board[x][y] = new Square(Type.SCARLETT);

					}
					else if(letter.equals('3')){ //Col. Mustard
						board[x][y] = new Square(Type.MUSTARD);

					}
					else if(letter.equals('4')){ //Mrs Peacock
						board[x][y] = new Square(Type.PEACOCK);

					}
					else if(letter.equals('5')){ //Mr. Green
						board[x][y] = new Square(Type.GREEN);

					}
					else if(letter.equals('6')){ //Mrs White
						board[x][y] = new Square(Type.WHITE);

					}
					else{ //Letter was unrecognised.

					}
				}

				y++; //increments y by 1, so that the 2D array drops down one.
				x=0; //Reset x back to 0 to start from the left again.
			}
			//function for testing - prints out the array
			for(int r=0; r<board.length; r++) {
				for(int c=0; c<board[r].length; c++)
					if(board[r][c]!= null){
					System.out.print(board[r][c] + " ");
					}
				System.out.println();
			}

		}
		catch(FileNotFoundException e){
			System.out.println("File was not found");
		}


	}
}
