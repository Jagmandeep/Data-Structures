import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Assign5 {

	public static void main(String[] args) {
		int display = 0 ; 
		int option;

		Scanner in = new Scanner (System.in);
		Scanner inFile = null;
		Dictionary dic = new Dictionary ();

		while (display >= 0){

			try {


				System.out.print( "\n  Enter 1 to clear dictionary,  ");
				System.out.print( "\n2 to add text from keyboard,  ");
				System.out.print( "\n3 to add text from a file,  ");
				System.out.print( "\n4 to search for a word count, ");
				System.out.print( "\n5 to display number of entries,  ");
				System.out.print( "\n6 to quit\n");

				option = in.nextInt();

				switch (option){

				case 1:

					dic.reset();
					continue;

				case 2:


					continue;

				case 3 :

					/*	inFile = openFile(in);
						if (inFile != null) {
							while (inFile.hasNext())
								treeMap.inputWord(inFile,"no");
						} // end of if */

					continue;

				case 4 :


					continue;

				case 5 :


					continue;

				case 6:

					break;

				default:

					System.out.println("Invalid option.");
					break;
				} // end of switch 
			}  catch (InputMismatchException e){
				System.out.print("Invalid option");


			} // end of catch 
			break;
		} // end of while loop
	} // end of main() 

	//********************openFile*********************************
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

} // end of class Assign5

