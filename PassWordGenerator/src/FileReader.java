import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class

public class FileReader {
	
	public ArrayList<String> threeLetterWords = new ArrayList<String>();
	public ArrayList<String> fourLetterWords = new ArrayList<String>();
	public ArrayList<String> fiveLetterWords = new ArrayList<String>();

	public FileReader()
	{
		try {
			Scanner scanFile = new Scanner(new File("3LetterWords.txt"));
			String line;
			
			while(scanFile.hasNextLine())
			{
				line = scanFile.nextLine();
				
				threeLetterWords.add(line);
			}
			
			scanFile = new Scanner(new File("4LetterWords.txt"));
			
			while(scanFile.hasNextLine())
			{
				line = scanFile.nextLine();
				
				fourLetterWords.add(line);
			}
			
			scanFile = new Scanner(new File("5LetterWords.txt"));
			
			while(scanFile.hasNextLine())
			{
				line = scanFile.nextLine();
				
				fiveLetterWords.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
