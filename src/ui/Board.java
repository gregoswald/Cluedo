package ui;
import game.Room;
import game.Room.Type;
import game.Square;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Class Which constitutes the board logic within the Game
 * @author Jarred Hone
 *
 */
public class Board {
	private Square[][] board = new Square[26][26]; //2D Array representing the board < -- Uninitialised
	public Board(){

	}
	/**
	 * Fills array with initial values from a text file using a parser - should only need to be called once and the base board will never change.
	 */
	private void fillInitialArray(){
		int x = 0;
		int y = 0;
		try{
			//Read File and set up Scanner
			File text = new File("parse.txt");
			Scanner scan = new Scanner(text);
			while(scan.hasNextLine()){ //While there is a next line of input
				String line = scan.nextLine(); //Store the entire next line as a string
				Scanner lineSplit = new Scanner(line); //New scanner on the string line to break it into parts.
				for(int i=0; i<line.length();i++){ //Loops along the line
					String letter = lineSplit.next(); //The letter we will be dealing with in the current iteration.
					/**
					 * Parsing Begins
					 */
					if(letter.equals('S')){ //study

					}
					else if(letter.equals('w')){ //wall

					}
					else if(letter.equals('h')){ //hall

					}
					else if(letter.equals('d')){ //door

					}
					else if(letter.equals('l')){ //Lounge

					}
					else if(letter.equals('i')){ //Library

					}
					else if(letter.equals('0')){ //Cellar

					}
					else if(letter.equals('p')){ //dining room

					}
					else if(letter.equals('t')){ //Billiard Room

					}
					else if(letter.equals('b')){ //Ballroom

					}
					else if(letter.equals('k')){ //Kitchen

					}
					else if(letter.equals('c')){ //Conservatory

					}
					/**
					 * Special Case - The Spawn points for the players.
					 */
					else if(letter.equals('1')){ //Professor Plum

					}
					else if(letter.equals('2')){ //Miss Scarlett

					}
					else if(letter.equals('3')){ //Col. Mustard

					}
					else if(letter.equals('4')){ //Mrs Peacock

					}
					else if(letter.equals('5')){ //Mr. Green

					}
					else if(letter.equals('6')){ //Mrs White

					}
					else{ //Letter was unrecognised.
						
					}
				}


			}
		}
		catch(FileNotFoundException e){
			System.out.println("File was not found");
		}


	}
}
