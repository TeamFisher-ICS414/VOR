/*  
 * this is a hard-coded driver to test the VOR object
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean good = true;
		int radial = 93;
		int OBSInput = 90;
		int signalInput = -400;
		
		radio radio1 = new radio(radial, good);
		signalInput = radio1.produceSignal();
		VORSystem testSystem1 = new VORSystem(OBSInput, signalInput);
		System.out.println("Test 1 inputs: Good signal is "+good+"; signal's radial is "+radial+"; OBS desired radial is "+OBSInput+".");
		System.out.println("VOR object output:");
		testSystem1.output();
		System.out.println("");
		/*	Reduced to 1 set of inputs so that VOR object runs, test cases are handled in test classes
		radial = 80;
		radio radio2 = new radio(radial, good);
		signalInput = radio2.produceSignal();
		VORSystem testSystem2 = new VORSystem(OBSInput, signalInput);
		System.out.println("Test 2 inputs: Good signal is "+good+"; signal's radial is "+radial+"; OBS desired radial is "+OBSInput+".");
		System.out.println("VOR object output:");
		testSystem2.output();
		System.out.println("");
		
		OBSInput = 200;
		radio radio3 = new radio(radial, good);
		signalInput = radio3.produceSignal();
		VORSystem testSystem3 = new VORSystem(OBSInput, signalInput);
		System.out.println("Test 3 inputs: Good signal is "+good+"; signal's radial is "+radial+"; OBS desired radial is "+OBSInput+".");
		System.out.println("VOR object output:");
		testSystem3.output();
		System.out.println("");
		
		OBSInput = 171;
		radio radio4 = new radio(radial, good);
		signalInput = radio4.produceSignal();
		VORSystem testSystem4 = new VORSystem(OBSInput, signalInput);
		System.out.println("Test 4 inputs: Good signal is "+good+"; signal's radial is "+radial+"; OBS desired radial is "+OBSInput+".");
		System.out.println("VOR object output:");
		testSystem4.output();
		System.out.println("");
		
		OBSInput = 200;
		good = false;
		radio radio5 = new radio(radial, good);
		signalInput = radio5.produceSignal();
		VORSystem testSystem5 = new VORSystem(OBSInput, signalInput);
		System.out.println("Test 5 inputs: Good signal is "+good+"; signal's radial is "+radial+"; OBS desired radial is "+OBSInput+".");
		System.out.println("VOR object output:");
		testSystem5.output();
		System.out.println("");
		*/
	}
}

