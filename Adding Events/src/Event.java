/**   This class models an event.
 *	  Author:  Linda Crane
 *    Assignment 2 update - added isGreater method
 *    
 *	  Data fields:   date:  OurDate - the day/month/year of the event
 *                   time: Time - the hour/minute that event starts at
 *					 description: String - a description of event
 *				
 *    Methods:  default constructor
 *				initial constructors
 *              getDate: OurDate - returns date of event
 *				getTime: Time - returns time of event
 *			
 *              toString: String - displays event to a String
 *              inputEvent (Scanner, String) - prompts (if String parameter starts with 'y') input 
 *                                             from Scanner parameter  for all data fields
 *              isEqual (Event): boolean - compares date and time in two objects and returns true/false if they are equal 
 *           ** isGreater (Event): boolean - compares date and time in two objects and returns true if object in class (this)
 *                                           is greater than parameter object; else returns false                               
 */
import java.util.*;
public class Event {
	private OurDate date = new OurDate();
	private OurTime time = new OurTime();
	private String description = new String();
	List<String> nodes = new LinkedList<String>();

	public Event() {
	}
	public Event (OurDate date, OurTime time, String description ){
		this.date = new OurDate(date);
		this.time = new OurTime (time);
		this.description = new String (description);

	}
	public Event (int day, int month, int year, int hour, int minute, String description){
		this.date = new OurDate (day, month, year);
		this.time = new OurTime (hour, minute);
		this.description = new String (description);

	}

	// get methods
	public OurDate getDate() { return date;}
	public OurTime getTime() { return time; }



	// accessor methods and mutators
	public String toString() {
		String list = "[ ";
		for (int i =0 ; i<nodes.size();i++){
			list += nodes.get(i);
			if (i != nodes.size()-1){
				list +=", ";
			}
		}
		list +=" ]";
		return new String("     " + date + " " + time + " " + description+"\n\t"+list);
	}

	public boolean inputEvent(Scanner in, String prompt) {
		if (!date.inputDate(in, prompt)) {
			return false;
		}
		if (!time.inputTime(in,prompt)) {
			return false;
		}
		if (prompt.charAt(0) == 'n'){	//file read
			this.description = in.next();
			int NotesSize = -1;
			do{
				if (in. hasNextInt())
					NotesSize = in.nextInt();	//takes number of nodes user wants to enter
				else {
					in.next();	//invalid input from file
					NotesSize = -1;
				}
			}while(NotesSize == -1);
			for(int i=0;i<NotesSize;i++)
			{
				String data = in.next();	//takes data from file
				nodes.add(data);
			}
		}
		if (prompt.charAt(0) == 'y'){
			System.out.print ("Enter event description: ");
			this.description = in.next();

			System.out.println("Enter how many notes you would like to add:");	
			int NotesSize = -1;
			do{
				if (in. hasNextInt())
					NotesSize = in.nextInt();
				else {
					in.next();
					System.out.println("Invalid entry");
					NotesSize = -1;
				}
			}while(NotesSize == -1);
			for(int i=0;i<NotesSize;i++)
			{
				System.out.println("Enter data for node");
				String data = in.next();
				nodes.add(data);
			}
		}
		return true;
	}

	public boolean isEqual (Event rhs) {
		return (this.date.isEqual(rhs.date) && this.time.isEqual(rhs.time));
	}

	public boolean isGreater (Event rhs) {
		if (this.date.isGreater (rhs.date))
			return true;
		else if (this.date.isEqual(rhs.date) && this.time.isGreater (rhs.time))
			return true;
		return false;

	}

	public void addNode(Scanner in){
		System.out.println("Enter note");
		String data = in.next();
		nodes.add(data);
		System.out.println("Note added");
	}

	public void removeNode(Scanner in){

		//Event to add has been found 	
		int indexOfNode =-1;
		if(nodes.isEmpty()){
			System.out.println("No note to delete");
			return;
		}else{
			System.out.println("Current notes for this event are:");
			displayNode();
			do{
				System.out.println("Enter index of note to delete");
				if (in.hasNextInt()){
					indexOfNode = in.nextInt();
				}
				else{
					in.next();
					System.out.println("Invalid choice....reenter: ");
					indexOfNode = -1;
				}
			}while(indexOfNode < 0 || indexOfNode >= nodes.size());

			nodes.remove(indexOfNode);
			System.out.println("Note deleted");
		}
	}

	public void displayNode(){
		for (int i =0 ; i<nodes.size();i++){
			System.out.println(i+" "+nodes.get(i));
		}
	}
}
