import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//	⦁	Cover your solution by unit tests.

class CustomLinkedListTest {

	@Test
	void testAdd() {
		CustomLinkedList<Number> testAddList = new CustomLinkedList<>();
		assertThrows(IndexOutOfBoundsException.class, () -> { testAddList.add(1, 1); });
		assertThrows(IndexOutOfBoundsException.class, () -> { testAddList.get(0); });
		
		testAddList.add(10, 0);
		// list contains: 10
		assertEquals(testAddList.get(0), 10);
		
		testAddList.add(20, 0);
		// list contains: 20, 10
		
		testAddList.add(30, 2);
		// list contains: 20, 10, 30
		
		testAddList.add(40, 3);
		// list contains: 20, 10, 30, 40

		testAddList.add(50, 3);
		// list contains: 20, 10, 30, 50, 40

		assertEquals(testAddList.get(0), 20);
		assertEquals(testAddList.get(1), 10);
		assertEquals(testAddList.get(2), 30);
		assertEquals(testAddList.get(3), 50);
		assertEquals(testAddList.get(4), 40);
	}
	

	@Test
	void testRemove() {
		CustomLinkedList<Number> testRemoveList = new CustomLinkedList<>();
		assertThrows(IndexOutOfBoundsException.class, () -> { testRemoveList.remove(0); });

		testRemoveList.add(10, 0);
		assertThrows(IndexOutOfBoundsException.class, () -> { testRemoveList.remove(1); });
		assertEquals(testRemoveList.get(0), 10);
		
		testRemoveList.add(10, 0);
		testRemoveList.add(20, 0);
		testRemoveList.add(30, 2);
		testRemoveList.add(40, 3);
		testRemoveList.add(50, 3);
		// list contains: 20, 10, 30, 50, 40
		
		assertEquals(testRemoveList.remove(2), 30);
		assertEquals(testRemoveList.remove(2), 50);
		assertEquals(testRemoveList.remove(2), 40);

		// list contains: 20, 10,
		assertEquals(testRemoveList.get(0), 20);
		assertEquals(testRemoveList.get(1), 10);
	}
	
	@Test
	void testSize() {
		CustomLinkedList<Number> testSizeList = new CustomLinkedList<>();
		assertEquals(testSizeList.size(), 0);
		
		testSizeList.add(10, 0);
		assertEquals(testSizeList.size(), 1);
		
		testSizeList.add(20, 0);
		testSizeList.add(30, 0);
		assertEquals(testSizeList.size(), 3);
	}

}
