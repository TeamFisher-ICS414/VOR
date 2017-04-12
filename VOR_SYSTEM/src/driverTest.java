import static org.junit.Assert.*;

import org.junit.Test;


public class driverTest {

	@Test
	public void testRadio() {
		boolean good = true;
		boolean bad = false;
		
		radio radioTest1 = new radio(0,good);
		assertEquals(0, radioTest1.produceSignal());
	}
	
	@Test
	public void test2(){
		
	}

}
