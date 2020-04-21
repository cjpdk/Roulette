import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author cjpdk
 *
 */
class OutcomeTest {

	Outcome o1;
	Outcome o2;
	Outcome o3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		o1 = new Outcome("Red", 1);
		o2 = new Outcome("Red", 2);
		o3 = new Outcome("Black", 1);
	}
	
	@Test
	/**
	 * 
	 */
	void testNotNull()
	{
		assertNotNull(o1);
		assertNotNull(o2);
		assertNotNull(o3);
	}
	
	/**
	 * Test method for {@link Outcome#winAmount(int)}.
	 */
	@Test
	void testWinAmount()
	{
		assertEquals(10, o1.winAmount(10));
		assertEquals(200, o2.winAmount(100));
		assertEquals(42, o3.winAmount(42));
	}

	/**
	 * Test method for {@link Outcome#equals(Outcome)}.
	 */
	@Test
	void testEqualsOutcome()
	{
		assertTrue(o1.equals(o2));
		assertFalse(o1.equals(o3));
		assertFalse(o2.equals(o3));
	}

	/**
	 * Test method for {@link Outcome#toString()}.
	 */
	@Test
	void testToString()
	{
		assertEquals("Red (1:1)", o1.toString());
		assertEquals("Red (2:1)", o2.toString());
		assertEquals("Black (1:1)", o3.toString());
	}
}