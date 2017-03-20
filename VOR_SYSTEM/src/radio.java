import java.util.InputMismatchException;
import java.util.Scanner;

public class radio {
	
	private int currentRadial;
	private boolean validInput;
	
	Scanner input = new Scanner( System.in );

	//default constructor
	
	/*
	 * This function sets the intercept radial for the fake radio
	 * Accepts user input from (0-359), as specified in assignment
	 * Negative values are accepted and handled by the VORSystem function signalValidate()
	 * */
	public void setRadio(){
		while(!validInput){
			try{
				System.out.println("Enter the radial that the VOR station is sending"
						+ " to the plane (integer between 0 - 359)\nEnter a negative"
						+ " number to indicate a BAD signal due being out of range");
				currentRadial = input.nextInt();
				if(currentRadial<=359){	
					validInput=true;
				}
			}catch(InputMismatchException exception){
				System.out.println("This is not an integer");
				input.next();
			}
		}
	}
	
	/*
	 * Used to get the fake radio interceptRadial
	 * to be passed to VOR Object
	 * */
	public int getRadio(){
		return currentRadial;
	}
}
