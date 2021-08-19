package assignment2;

import java.util.Scanner;

public class Game {
	
	//private instance variables
	private boolean isTesting;
	private String secretCode;
	private Scanner myScanner;
	private GameConfiguration config;
	
	/************************************************
	 * Game constructors
	 * 
	 * **********************************************
	 */
	public Game(Boolean isTesting, Scanner myScanner, GameConfiguration config) {
		this.isTesting = isTesting;
		//secretCode = generator.getNewSecretCode();
		this.myScanner = myScanner;
		this.config = config;
	}
	
	public Game() {
		this.isTesting = false;
	}
	
	/*
	 * runGame method called by Driver
	 * Preconditions: Scanner and secretcode generator set up
	 * Postcondtions: none
	 */
	
	public void runGame() {
		//System.out.println("Welcome to Mastermind.");                   //print out start of game
		System.out.println("Welcome to Mastermind. Here are the rules.");
		System.out.println("");
		System.out.println("This is a text version of the classic board game Mastermind.");
		System.out.println("");
		/*System.out.println("The computer will think of a secret code. The code consists of 4\r\n" + 
				"colored pegs. The pegs MUST be one of six colors: blue, green,\r\n" + 
				"orange, purple, red, or yellow. A color may appear more than once in\r\n" + 
				"the code. You try to guess what colored pegs are in the code and\r\n" + 
				"what order they are in. After you make a valid guess the result\r\n" + 
				"(feedback) will be displayed.");
				*/
		System.out.println("The computer will think of a secret code. The code consists of 4 colored pegs. The pegs MUST be one of six colors: blue, green, orange, purple, red, or yellow. A color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in. After you make a valid guess the result (feedback) will be displayed.");
		System.out.println("");
		/*System.out.println("The result consists of a black peg for each peg you have guessed\r\n" + 
				"exactly correct (color and position) in your guess. For each peg in\r\n" + 
				"the guess that is the correct color, but is out of position, you get\r\n" + 
				"a white peg. For each peg, which is fully incorrect, you get no\r\n" + 
				"feedback. ");
				*/
		System.out.println("The result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess. For each peg in the guess that is the correct color, but is out of position, you get a white peg. For each peg, which is fully incorrect, you get no feedback.");
		System.out.println("");
		/*
		System.out.println("Only the first letter of the color is displayed. B for Blue, R for\r\n" + 
				"Red, and so forth. When entering guesses you only need to enter the\r\n" + 
				"first character of each color as a capital letter.");
				*/
		System.out.println("Only the first letter of the color is displayed. B for Blue, R for Red, and so forth. When entering guesses you only need to enter the first character of each color as a capital letter.");
		System.out.println("");
		System.out.println("You have 12 guesses to figure out the secret code or you lose the game. Are you ready to play? (Y/N):");
		/*System.out.println("You have 12 guesses to figure out the secret code or you lose the\r\n" + 
				"game. Are you ready to play? (Y/N):");
				*/
		String yesOrNo = myScanner.nextLine();
		boolean winOrLose = false;
		boolean invalid = false;
		while(yesOrNo.equals("Y")) {                //continue until the user types "N"
			//start new game
			History myList = new History();
			//secretCode = generator.getNewSecretCode();
			secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
			Limit countdown = new Limit(config);
			Guess myGuess = new Guess();
			if(isTesting) {                                     //print the secret code if in testing mode
				System.out.println("Generating secret code ...(for this example the secret code is " + secretCode + ")");
			}else {
				System.out.println("Generating secret code ...");
			}
			/*************************
			 * test secret code
			 * ***********************
			 */
			//secretCode = "OPGB";
			
			System.out.println("");
			winOrLose = false;
			boolean dontHide = true;
			//game loop
			while(winOrLose==false) {
				if(dontHide) {
					System.out.println("You have " + countdown.getGuessesRemaining() + " guesses left.");//print guesses left
				}
				myGuess.askForGuess(myScanner);                                  //get guess from user
				winOrLose = myGuess.replyToGuess(secretCode, myList, config, countdown);    //compute reply to guess
				dontHide = myGuess.getDontHide();
				if(winOrLose) {
					yesOrNo = myScanner.nextLine();
				}else {
					winOrLose = countdown.calculateGuessesRemaining(myGuess.getInvalid(), secretCode); //calculate remaining guesses
					if(winOrLose) {
						yesOrNo = myScanner.nextLine();
					}
					invalid = false;
				}
			}	
		}
		
	}

}
