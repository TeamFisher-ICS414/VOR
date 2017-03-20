import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int currentRadial, destinationRadial;
		boolean signal, toward;
		
		radio station = new radio();
		OBS pilot = new OBS();
		
		station.setRadio();
		currentRadial = station.getRadio();
		
		pilot.setHeading();
		destinationRadial = pilot.getHeading();
		toward = pilot.getDirection();
	
		
	}

}
