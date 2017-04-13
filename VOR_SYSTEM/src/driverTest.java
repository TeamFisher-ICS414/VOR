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
		vorTest.deflectionCalc();
		assertEquals(0, vorTest.difference);
		assertEquals(true, vorTest.goodSignal);

		vorTest = new VORSystem(45, goodRadio.produceSignal());
		vorTest.deflectionCalc();
		assertEquals(0, vorTest.difference);
		assertEquals(true, vorTest.goodSignal);

		vorTest = new VORSystem(355, maxRadio.produceSignal());
		vorTest.deflectionCalc();
		assertEquals(0, vorTest.difference);
		assertEquals(true, vorTest.goodSignal);

		//difference >180
		vorTest = new VORSystem(1, maxRadio.produceSignal());
		vorTest.deflectionCalc();
		assertEquals(-6, vorTest.deflection);
		assertEquals(true, vorTest.goodSignal);

		//difference <-181
		vorTest = new VORSystem(182, minRadio.produceSignal());
		vorTest.deflectionCalc();
		assertEquals(178, vorTest.deflection);
		assertEquals(true, vorTest.goodSignal);

		//difference <180 && >-181
		vorTest = new VORSystem(30, goodRadio.produceSignal());
		vorTest.deflectionCalc();
		assertEquals(15, vorTest.deflection);
		assertEquals(true, vorTest.goodSignal);
		
		//abeam
		vorTest = new VORSystem(89, minRadio.produceSignal());
		vorTest.deflectionCalc();
		assertEquals(false, vorTest.goodSignal);
		
		vorTest = new VORSystem(90, minRadio.produceSignal());
		vorTest.deflectionCalc();
		assertEquals(false, vorTest.goodSignal);
		
		vorTest = new VORSystem(91, minRadio.produceSignal());
		vorTest.deflectionCalc();
		assertEquals(false, vorTest.goodSignal);
		
//direction()
		//center on radial
		vorTest = new VORSystem(0, minRadio.produceSignal());
		vorTest.deflectionCalc();
		vorTest.direction();
		assertEquals("CENTERED", vorTest.turn);
		
		//center exact opposite of radial
		vorTest = new VORSystem(180, minRadio.produceSignal());
		vorTest.deflectionCalc();
		//System.out.println("deflection is "+vorTest.deflection);
		vorTest.direction();
		assertEquals("CENTERED", vorTest.turn);
		
		//left
		vorTest = new VORSystem(1, maxRadio.produceSignal());
		vorTest.deflectionCalc();
		vorTest.direction();
		assertEquals("LEFT", vorTest.turn);
		
		//right
		vorTest = new VORSystem(30, goodRadio.produceSignal());
		vorTest.deflectionCalc();
		vorTest.direction();
		assertEquals("RIGHT", vorTest.turn);
//tofrom()
		//to
		vorTest = new VORSystem(182, minRadio.produceSignal());
		vorTest.deflectionCalc();
		vorTest.direction();
		vorTest.toFrom();
		assertEquals("TO", vorTest.direction);

		//180 toward

		//from
		vorTest = new VORSystem(30, goodRadio.produceSignal());
		vorTest.deflectionCalc();
		vorTest.direction();
		vorTest.toFrom();
		assertEquals("FROM", vorTest.direction);
	}

}
