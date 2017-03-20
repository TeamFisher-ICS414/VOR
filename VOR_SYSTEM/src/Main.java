import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int currentRadial, destinationRadial;
		boolean signal, input1, input2, input3;
		
		Scanner input = new Scanner( System.in );
		
		radio station = new radio();
		OBS pilot = new OBS();
		
		station.setRadio();
		currentRadial = station.getRadio();
		
		pilot.setHeading();
		destinationRadial = pilot.getHeading();
		
		if(currentRadial<0){
			signal = false;
		}
		else{
			signal = true;
		}
		
	}

}
