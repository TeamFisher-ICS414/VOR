import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean good = true;
		int radial = 93;
		int OBSInput = 90;
		int signalInput = -400;
		String outputStr = "";
		
		radio radio1 = new radio(radial, good);
		
		signalInput = radio1.produceSignal();
		
		VORSystem testSystem = new VORSystem(OBSInput, signalInput);
		
		outputStr = testSystem.output();
				
		System.out.println("foo");
	}
}

