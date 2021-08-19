package assignment2;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
        
		boolean test = false;
		if(args.length>0) {
			if(args[0]=="1") {
				test = true;
			}
		}
		GameConfiguration config = new GameConfiguration();
		Scanner myScanner = new Scanner(System.in);//set up a scanner object
    	Game myGame = new Game(test, myScanner, config);//create a game object
    	myGame.runGame();//call the rungame method
		
    }
	
}
