import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		radio station = new radio();
		OBS pilot = new OBS();
		
		station.setRadio();
		pilot.setHeading();
		
		VORSystem vor = new VORSystem(pilot, station.getRadio());
		vor.output();
	}
}

