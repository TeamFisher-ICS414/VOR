import static org.junit.Assert.*;
import org.junit.Test;

public class VORQuadrantsSystemTest {
	boolean good = true;
	boolean bad = false;
	radio testRadio;
	VORSystem vorTest;
	
	@Test
	public void test1() {
		testRadio = new radio(126,bad);
		vorTest = new VORSystem(96,testRadio.produceSignal());
		vorTest.output();
		assertFalse(vorTest.goodSignal);
	}
	
	@Test
	public void test2() {
		testRadio = new radio(360,good);
		vorTest = new VORSystem(0,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("FROM", vorTest.direction);
		assertEquals("CENTERED", vorTest.turn);
		assertEquals("0 dots", vorTest.dots);
	}

	@Test
	public void test3() {
		testRadio = new radio(182,good);
		vorTest = new VORSystem(181,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("FROM", vorTest.direction);
		assertEquals("RIGHT", vorTest.turn);
		assertEquals("0 dots", vorTest.dots);
	}
	
	@Test
	public void test4() {
		testRadio = new radio(253,good);
		vorTest = new VORSystem(251,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("FROM", vorTest.direction);
		assertEquals("RIGHT", vorTest.turn);
		assertEquals("1 dot", vorTest.dots);
	}
	
	@Test
	public void test5() {
		testRadio = new radio(126,good);
		vorTest = new VORSystem(96,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("FROM", vorTest.direction);
		assertEquals("RIGHT", vorTest.turn);
		assertEquals("FULL", vorTest.dots);
	}
	
	@Test
	public void test6() {
		testRadio = new radio(81,good);
		vorTest = new VORSystem(350,testRadio.produceSignal());
		vorTest.output();
		assertFalse(vorTest.goodSignal);
	}
	
	@Test
	public void test7() {
		testRadio = new radio(126,good);
		vorTest = new VORSystem(34,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("TO", vorTest.direction);
		assertEquals("RIGHT", vorTest.turn);
		assertEquals("FULL", vorTest.dots);
	}
	
	@Test
	public void test8() {
		testRadio = new radio(260,good);
		vorTest = new VORSystem(85,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("TO", vorTest.direction);
		assertEquals("RIGHT", vorTest.turn);
		assertEquals("2 dots", vorTest.dots);
	}
	
	@Test
	public void test9() {
		testRadio = new radio(220,good);
		vorTest = new VORSystem(41,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("TO", vorTest.direction);
		assertEquals("RIGHT", vorTest.turn);
		assertEquals("0 dots", vorTest.dots);
	}
	
	@Test
	public void test10() {
		testRadio = new radio(296,good);
		vorTest = new VORSystem(116,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("TO", vorTest.direction);
		assertEquals("CENTERED", vorTest.turn);
		assertEquals("0 dots", vorTest.dots);
	}
	
	@Test
	public void test11() {
		testRadio = new radio(254,good);
		vorTest = new VORSystem(73,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("TO", vorTest.direction);
		assertEquals("LEFT", vorTest.turn);
		assertEquals("0 dots", vorTest.dots);
	}
	
	@Test
	public void test12() {
		testRadio = new radio(236,good);
		vorTest = new VORSystem(50,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("TO", vorTest.direction);
		assertEquals("LEFT", vorTest.turn);
		assertEquals("3 dots", vorTest.dots);
	}
	
	@Test
	public void test13() {
		testRadio = new radio(188,good);
		vorTest = new VORSystem(341,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("TO", vorTest.direction);
		assertEquals("LEFT", vorTest.turn);
		assertEquals("FULL", vorTest.dots);
	}
	
	@Test
	public void test14() {
		testRadio = new radio(91,good);
		vorTest = new VORSystem(181,testRadio.produceSignal());
		vorTest.output();
		assertFalse(vorTest.goodSignal);
	}
	
	@Test
	public void test15() {
		testRadio = new radio(325,good);
		vorTest = new VORSystem(21,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("FROM", vorTest.direction);
		assertEquals("LEFT", vorTest.turn);
		assertEquals("FULL", vorTest.dots);
	}
	
	@Test
	public void test16() {
		testRadio = new radio(279,good);
		vorTest = new VORSystem(288,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("FROM", vorTest.direction);
		assertEquals("LEFT", vorTest.turn);
		assertEquals("4 dots", vorTest.dots);
	}
	
	@Test
	public void test17() {
		testRadio = new radio(236,good);
		vorTest = new VORSystem(237,testRadio.produceSignal());
		vorTest.output();
		assertTrue(vorTest.goodSignal);
		assertEquals("FROM", vorTest.direction);
		assertEquals("LEFT", vorTest.turn);
		assertEquals("0 dots", vorTest.dots);
	}
}
