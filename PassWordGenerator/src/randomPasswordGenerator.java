import java.util.Random;
import java.util.ArrayList; // import the ArrayList class


public class randomPasswordGenerator {
    private static String numbersList = "0123456789";
    private static String lowercaseLettersList = "abcdefghijklmnopqrstuvwxyz";
    private static String uppercaseLettersList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String symbolsList = "!@#$%&*";
	
	public static String passwordGenerator(boolean upperCase,boolean lowerCase,boolean numbers,boolean symbols,boolean words,int length)
	{
		Random rand = new Random(); 
		int numberOfcharacterCategories = 0;
		String generatedPassword = "";
		
		ArrayList<String> passwordCategories = new ArrayList<String>();
		
		/*  if(words) {
			numberOfcharacterCategories++;
			passwordCategories.add(); } */
		if(upperCase) {
			numberOfcharacterCategories++;
			passwordCategories.add(uppercaseLettersList); }
		if(lowerCase) {
			numberOfcharacterCategories++;
		passwordCategories.add(lowercaseLettersList); }
		if(numbers) {
			numberOfcharacterCategories++;
			passwordCategories.add(numbersList); }
		if(symbols) {
			numberOfcharacterCategories++;
			passwordCategories.add(symbolsList); }
		
		if(numberOfcharacterCategories>0)
		    for (int i = 0; i < length; i++ )
		    {
		        switch(rand.nextInt(numberOfcharacterCategories))
		        {
		            case 0:
		            	generatedPassword += passwordCategories.get(0).charAt(rand.nextInt(passwordCategories.get(0).length()));
		                break;
		            case 1:
		            	generatedPassword += passwordCategories.get(1).charAt(rand.nextInt(passwordCategories.get(1).length()));
		                break;
		            case 2:
		            	generatedPassword += passwordCategories.get(2).charAt(rand.nextInt(passwordCategories.get(2).length()));
		                break;
		            case 3:
		            	generatedPassword += passwordCategories.get(3).charAt(rand.nextInt(passwordCategories.get(3).length()));
		                break;
		            default:
		            	generatedPassword += " ";
		            	break;
		        }
		        
		    }
		return generatedPassword;
	}

}
