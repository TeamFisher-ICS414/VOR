import java.util.InputMismatchException;
import java.util.Scanner;

public class radio {
	
	private int currentRadial;
	private boolean validInput;
	private int signalValue;
	
	public radio(int radial, boolean goodBad) {
		validInput = goodBad;
		currentRadial = radial;
	}
	
	public int produceSignal() {
		if (validInput == false) {
			signalValue = ((-1)*currentRadial);
		} else {
			if (currentRadial == 360) {
				signalValue = 0; 
			}else{
				signalValue = currentRadial;	
			}
		}
		return signalValue;
	}
	/* Bill edit: I'm removing this function and creating a constructor. Driver/GUI will handle I/O
	Scanner input = new Scanner( System.in );
*/
	//default constructor
	
	/*
	 * This function sets the intercept radial for the fake radio
	 * Accepts user input from (0-359), as specified in assignment
	 * Negative values are accepted and handled by the VORSystem function signalValidate()
	 * */
	
	/* Bill edit: I'm removing this function and creating a constructor. Driver/GUI will handle I/O
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
	*/
	
	/*
	 * Used to get the fake radio interceptRadial
	 * to be passed to VOR Object
	 * */
	
	/* Bill edit: I'm swapping out for a parameter to be passed
	public int getRadio(){
		return currentRadial;
	}
	*/
}

