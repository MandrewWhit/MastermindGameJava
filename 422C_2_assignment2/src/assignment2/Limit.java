package assignment2;

public class Limit {
	
	//instance variables
	private int guessesRemaining;
	//Limit constructor
	public Limit(GameConfiguration config) {
		this.guessesRemaining = config.guessNumber;
	}
	/****************************************************************************************
	 * calculateGuessesRemaining method
	 * if guess is not invalid decrement guess count
	 * determine if the player is out of guesses
	 * 
	 * preconditions: invalid flag is set properly, secretCode exists
	 * postconditions: guess count is updated and if no more guesses remain, game ends
	 * 
	 * **************************************************************************************
	 */
	public boolean calculateGuessesRemaining(boolean invalid, String secretCode) {
		if(invalid==false) {         //if invalid flag is set, don't decrement guess count
			guessesRemaining--;
			if(guessesRemaining<=0) {
				System.out.println("Sorry, you are out of guesses. You lose, boo-hoo.");
				System.out.println("");
				System.out.println("Are you ready for another game? (Y/N):");
				return true;
			}else {
				System.out.println("");
				return false;
			}
		}else {
			return false;
		}
	}
	//getter method
	public int getGuessesRemaining() {
		return guessesRemaining;
	}

}
