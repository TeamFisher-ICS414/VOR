import java.util.InputMismatchException;
import java.util.Scanner;

public class radio {
	
	private int currentRadial;
	private boolean validInput;
	
	Scanner input = new Scanner( System.in );

	//default constructor
	
	public void setRadio(){
		while(!validInput){
			try{
				System.out.println("Enter the radial that the VOR station is sending"
						+ " to the plane (integer between 0 - 359)\nEnter a negative"
						+ " number to indicate a BAD signal");
				currentRadial = input.nextInt();
				if(/*currentRadial>=0 && */currentRadial<=359){
					validInput=true;
				}
			}catch(InputMismatchException exception){
				System.out.println("This is not an integer");
				input.next();
			}
		}
	}
	public int getRadio(){
		return currentRadial;
	}
}
