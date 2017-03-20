import java.util.InputMismatchException;
import java.util.Scanner;


public class OBS {

	private int destinationRadial, to;
	private boolean validInput, toward;
	
	Scanner input = new Scanner( System.in );
	
	//default constructor
	
	/*
	 * Sets the radial the plane wants to follow
	 * Accepts user input from (0-359)
	 * 
	 * Sets the direction the plane is heading in relation to station
	 * Accepts user input in which 1 means towards the station and 0 means away
	 * 
	 * Uses 0 or 1 int values to set toward boolean
	 * */
	public void setHeading(){
		while(!validInput){
			try{
				System.out.println("Set Heading:\n"
							+ "Enter desired radial (integer between 0 - 359)");
				destinationRadial = input.nextInt();
				if(destinationRadial>=0 && destinationRadial<=359){
					validInput=true;
				}
			}catch(InputMismatchException exception){
				System.out.println("This is not an integer");
				input.next();
			}
			
		}
		validInput=false;
		while(!validInput){
			try{
				System.out.println("Set direction: \nEnter 0 to indicate the plane is"
						+ " heading away from the VOR station\nEnter 1 to indicate the"
						+ " plane is heading toward the VOR station");
				to = input.nextInt();
				if(to == 1 || to == 0){
					validInput = true;
				}
				
			}catch(InputMismatchException exception){
				System.out.println("This is not an integer");
				input.next();
			}
		}
		if(to == 1){
			toward = true;
		}
		else{
			toward = false;
		}
	}
	
	/*
	 * Allows access to the destination Radial
	 * To be used by the VOR system
	 * */
	public int getHeading(){
		return destinationRadial;
	}
	
	/*
	 * Allows access to the direction
	 * To be used by the VOR system
	 * */
	public boolean getDirection(){
		return toward;
	}	
}
