package assignment2;

public class CheckGuess {
	public static  Response checkGuess(String currentGuess, String secretCode) {
		// TODO for your extra credit part testing.  Do not turn this in.
		if(secretCode.equals(currentGuess)) {       //determine if the guess is correct
			int blackPins = 0;
			String duplicateCode = secretCode;
			String duplicateGuess = currentGuess;
			for(int i=0;i<duplicateCode.length();i++) {
				if(duplicateGuess.charAt(i)==duplicateCode.charAt(i)) {
					blackPins++;
					duplicateCode = duplicateCode.substring(0,i) + duplicateCode.substring(i+1);
					duplicateGuess = duplicateGuess.substring(0,i) + duplicateGuess.substring(i+1);
					i--;
				}
			}

			return new Response(blackPins, 0);
		}else {
			
			//determine black pins
			int blackPins = 0;
			String duplicateCode = secretCode;
			String duplicateGuess = currentGuess;
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
			return new Response(blackPins, whitePins);
		}
		
		
		

	}
}
