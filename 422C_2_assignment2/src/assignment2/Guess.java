package assignment2;
import java.util.Scanner;

public class Guess {
	//instance variables for the Guess class
	private String myGuess;
	private boolean invalid;
	private boolean dontHide = true;
	
	public boolean getDontHide() {
		return dontHide;
	}

	public boolean getInvalid() {
		return invalid;
	}

	/*********************************************
	 * askForGuess method
	 * preconditions: set up scanner
	 * postconditions: none
	 * 
	 * *******************************************
	 */
	public void askForGuess(Scanner myScanner) {
		System.out.println("What is your next guess?");
		System.out.println("Type in the characters for your guess and press enter.");
		System.out.println("Enter guess: ");
		myGuess = myScanner.nextLine();
		invalid = false;
	}
	/*********************************************
	 * replyToGuess method
	 * preconditions: secretCode, a set up list, configured game
	 * postconditions: winOrLose is updated and invalid flag is set for invalid guesses
	 * 
	 * 
	 * *******************************************
	 */
	public boolean replyToGuess(String secretCode, History myList, GameConfiguration config, Limit countdown) {
		dontHide = true;
		if(myGuess.equals("HISTORY")) {
			myList.printList();     //print all previous valid guesses
			invalid = true;
			return false;
		}
		if(secretCode.length()!=myGuess.length()) {
			System.out.println(myGuess + " -> INVALID GUESS");      //set invalid flag if guess is too long
			System.out.println("");
			invalid = true;
			dontHide = false;
			return false;
		}
		if(secretCode.equals(myGuess)) {       //determine if the guess is correct
			int blackPins = 0;
			String duplicateCode = secretCode;
			String duplicateGuess = myGuess;
			for(int i=0;i<duplicateCode.length();i++) {
				if(duplicateGuess.charAt(i)==duplicateCode.charAt(i)) {
					blackPins++;
					duplicateCode = duplicateCode.substring(0,i) + duplicateCode.substring(i+1);
					duplicateGuess = duplicateGuess.substring(0,i) + duplicateGuess.substring(i+1);
					i--;
				}
			}
			System.out.println(myGuess + " -> Result: " + blackPins + "B_0W - You Win !!");
			System.out.println("");
			System.out.println("Are you ready for another game (Y/N):");
			return true;
		}else {
			//check for invalid characters
			boolean charCheck = false;
			for(int i=0;i<myGuess.length();i++) {
				for(int j=0;j<config.colors.length;j++) {
					if(myGuess.charAt(i)==config.colors[j].charAt(0)) {
						charCheck = true;
					}
				}
				if(charCheck==false) {
					System.out.println(myGuess + " -> INVALID GUESS");
					System.out.println("");
					dontHide = false;
					invalid = true;
					return false;
				}
				charCheck = false;
			}
			//determine black pins
			int blackPins = 0;
			String duplicateCode = secretCode;
			String duplicateGuess = myGuess;
			for(int i=0;i<duplicateCode.length();i++) {
				if(duplicateGuess.charAt(i)==duplicateCode.charAt(i)) {
					blackPins++;
					duplicateCode = duplicateCode.substring(0,i) + duplicateCode.substring(i+1); //eliminate already accounted for pegs of guess by splicing string
					duplicateGuess = duplicateGuess.substring(0,i) + duplicateGuess.substring(i+1);
					i--;
				}
			}
			//determine white pins
			int whitePins = 0;
			boolean found = false;
			for(int i=0;i<duplicateCode.length();i++) {
				for(int j=0;j<duplicateGuess.length();j++) {
					if((found==false)&&(duplicateCode.charAt(i)==duplicateGuess.charAt(j))) {
						whitePins++;
						found = true;
						duplicateCode = duplicateCode.substring(0,i) + duplicateCode.substring(i+1); //remove that char from secretCode
						duplicateGuess = duplicateGuess.substring(0,j) + duplicateGuess.substring(j+1);
						i--;
						j--;
					}
				}
				found = false;
			}
			
			String pegs = blackPins + "B_" + whitePins + "W";
			Node myNode = new Node(null, myGuess, pegs);
			myList.pushNode(myNode);
			if(countdown.getGuessesRemaining()>1) {
				System.out.println(myGuess + " -> Result: " + blackPins + "B_" + whitePins + "W");   //output pins to the screen
			}
				//System.out.println("");
			
			return false;
		}
	}
	
}
