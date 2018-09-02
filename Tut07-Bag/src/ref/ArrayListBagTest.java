package ref;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListBagTest {
	private ArrayListBag<Integer> integerBag;
	private ArrayListBag<Integer> anotherIntegerBag;
	private ArrayListBag<String> stringBag;
	
	@BeforeEach
	void setUp() throws Exception {
		this.integerBag = new ArrayListBag<>();
		this.anotherIntegerBag = new ArrayListBag<>();
		this.stringBag = new ArrayListBag<>();
	}

	@Test
	void testSingleAdd() {
		int expected = 10;
		long expectedSize = 1;
		
		integerBag.add(expected);
		
		assertTrue(integerBag.contains(expected));
		assertEquals(expectedSize, integerBag.size());
	}
	
	@Test
	void testMultipleAdd() {
		int expected = 10;
		long expectedSize = 100;
		
		for (int i = 0; i < 100; i++) {
			integerBag.add(expected);
		}
		
		assertTrue(integerBag.contains(expected));
		assertEquals(expectedSize, integerBag.size());
	}

	@Test
	void testEqualsWhenItemsDifferentOrder() {
		int item1 = 10;
		int item2 = 20;
		
		integerBag.add(item1);
		integerBag.add(item2);
		
		anotherIntegerBag.add(item2);
		anotherIntegerBag.add(item1);
				
		assertTrue(integerBag.equals(anotherIntegerBag));
	}
	
	@Test
	void testEqualsWhenDifferentTypes() {
		int item1 = 1;
		String item2 = "1";
		
		integerBag.add(item1);
		stringBag.add(item2);
		
		assertFalse(integerBag.equals(stringBag));
	}
}
