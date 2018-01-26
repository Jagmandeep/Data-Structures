import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/*
 * Author Jagmandeep Singh
 * date 5 April 2017
 * Course Data Structure
 * Objective: Making tree of words
 *  
 */
public class Main {
	public static void main(String [] args){

		Scanner input = new Scanner(System.in);
		Scanner inFile = null;
		Dictionary dictionary = new Dictionary();
		int menuChoice = 1;
		while (menuChoice !=0 ) 
			do{
				System.out.println("Press 1 to clear whole tree\n"
						+ "2 to add from keyboard \n"
						+ "3 to add words from file\n"
						+ "4 to search for a word count\n"
						+ "5  to display number of nodes\n"
						+ "0 to quit");
				/*
				 * Checks whether user entered integer or some other character
				 */
				if (input. hasNextInt())
					menuChoice = input.nextInt();
				else {
					input.next();
					System.out.println("Invalid menu choice....reenter: ");
					menuChoice = -1;
				}
				switch(menuChoice){
				case 1:
					dictionary.clearTree();
					break;
				case 2:
					dictionary.addFromKeyboard(input);
					System.out.println("Word added");
					break;

				case 3:
					inFile = openFile(input);
					if (inFile != null) {
						while (inFile.hasNext())
							dictionary.readFromFile(inFile);				
					}
					System.out.println("Words added to file");
					break;
				case 4:
					System.out.println("Please enter word you want to count");
					String wordToCount = input.next();
					dictionary.wordCount(wordToCount);
					break;
				case 5:
					dictionary.numOfWordsInDictionary();
					break;

				}

			}while (menuChoice < 0 || menuChoice > 6);
	}
	public static Scanner openFile(Scanner in) {
		String fileName = new String();
		Scanner inFile = null;

		System.out.print("\n\nEnter name of file to process: ");
		fileName = in.next();

		File file = new File(fileName);
		try {
			if (file.exists()) {
				inFile = new Scanner(file);
			}
			else System.out.println ("File does not exist.....");
			return inFile;
		} catch (IOException e) {
			System.out.println("Could not open file...." + fileName + "exiting");
			return null;
		}
	}// end openFile method
}
