import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {
	/*
	 * Author Jagmandeep Singh
	 * date 5 April 2017
	 * Course Data Structure
	 * Objective: Making tree of words
	 *  
	 */
	private TreeMap <String,Integer > tree = new TreeMap <String,Integer>();

	public Dictionary(){

	}

	public void clearTree(){
		tree.clear();
		System.out.println("Tree cleared");
	}

	public void addFromKeyboard(Scanner input){
		System.out.println("Enter word to add to your dictionary");
		String key = input.next();
		addNode(key);		//adds stripped string to tree.


	}

	public void readFromFile(Scanner in){
		String key = in.next();
		addNode(key);
	}

	public void numOfWordsInDictionary(){
		System.out.println(tree.size());
	}

	public void wordCount(String key){
		int count =0;
		if(tree.isEmpty()){
			System.out.println("Tree is empty");
		}
		else{
			if(tree.containsKey(key)){
				key = stripString(key);
				count = tree.get(key);
				System.out.println(key+" appeared "+ count + " times.");
			}
			else	System.out.println("Word is not present");
		}
	}

	public String stripString(String toStrip){
		return toStrip.toLowerCase().replaceAll("[\\W]", "");		// "\\W" strips non word characters from string
	}																//[^a-zA-Z] this strips numbers too

	public void addNode(String key){
		key = stripString(key);
		if(tree.containsKey(key)){
			tree.replace(key, tree.get(key) + 1);	// gets the value from tree than adds one to that value 
		}
		else{
			tree.put(key, 1);
		}
	}
}