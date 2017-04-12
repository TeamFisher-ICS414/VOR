import static org.junit.Assert.*;

import org.junit.Test;


public class driverTest {

	boolean good = true;
	boolean bad = false; 
	
	@Test
	public void testRadio() {	
		radio radioTest;
//produceSignal() test
		radioTest =  new radio(0,bad);
		assertEquals(-0, radioTest.produceSignal());
		
		radioTest =  new radio(360,bad);
		assertEquals(-360, radioTest.produceSignal());
		
		radioTest= new radio(0,good);
		assertEquals(0, radioTest.produceSignal());
		
		radioTest = new radio(360, good);
		assertEquals(0, radioTest.produceSignal());
	}
	
	@Test
	public void testVORSystem(){
		boolean good = true;
		boolean bad = false;
		radio goodRadio, badRadio, minRadio, maxRadio;
		VORSystem vorTest;
		
//signalValidate() test
		goodRadio = new radio(45,good);
		badRadio = new radio(45, bad);
		
		vorTest = new VORSystem(0, goodRadio.produceSignal());
		assertEquals(true, vorTest.signalValidate());
		
		vorTest = new VORSystem(0, badRadio.produceSignal());
		assertEquals(false, vorTest.signalValidate());
		
//deflectionCalc() test
		minRadio = new radio(0, good);
		maxRadio = new radio(355, good);
		
		//first conditional
		vorTest = new VORSystem(0, badRadio.produceSignal());
		vorTest.deflectionCalc();
		assertEquals(false, vorTest.goodSignal);
		
		assertEquals(false, vorTest.goodSignal);
		//on center
		vorTest = new VORSystem(0, minRadio.produceSignal());
		assertEquals(0, vorTest.deflection);
		
		//
		vorTest = new VORSystem(0, goodRadio.produceSignal());
		vorTest = new VORSystem(0, maxRadio.produceSignal());
		
	}

}
