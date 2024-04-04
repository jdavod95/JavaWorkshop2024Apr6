import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//⦁	Cover your solution by unit tests.

class CustomStringTest {
	
	@Test
	void testReplace() {
		assertEquals(new CustomString("teszt".toCharArray()).replace('t', 'c'),
				new CustomString("ceszc".toCharArray()));
		
		assertEquals(new CustomString("teszt".toCharArray()).replace('a', 'b'),
				new CustomString("teszt".toCharArray()));
		
		assertEquals(new CustomString("teszt2".toCharArray()).replace('2', ' '),
				new CustomString("teszt ".toCharArray()));
	}
	
	@Test
	void testConcat() {	
		assertEquals(new CustomString("concat ".toCharArray()).concat(
					new CustomString("teszt".toCharArray())),
				new CustomString("concat teszt".toCharArray()));
	}
	
	@Test
	void testUppercase() {	
		assertEquals(new CustomString("teszt".toCharArray()).toUppercase(),
				new CustomString("TESZT".toCharArray()));
		
		assertEquals(new CustomString("teSZt -Special{ }-".toCharArray()).toUppercase(),
				new CustomString("TESZT -SPECIAL{ }-".toCharArray()));
	}
}
