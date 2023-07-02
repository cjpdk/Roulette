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
class OutcomeTest
{
	Outcome red1, red2, black;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		red1 = new Outcome("Red", 1);
		red2 = new Outcome("Red", 2);
		black = new Outcome("Black", 1);
	}
	
	/**
	 * Test method for {@link Outcome#Outcome(String, int)}.
	 */
	@Test
	void testOutcome()
	{
		assertNotNull(red1);
		assertNotNull(red2);
		assertNotNull(black);
	}
	
	/**
	 * Test method for {@link Outcome#winAmount(int)}.
	 */
	@Test
	void testWinAmount()
	{
		assertEquals(10, red1.winAmount(10));
		assertEquals(200, red2.winAmount(100));
		assertEquals(42, black.winAmount(42));
	}
	
	/**
	 * Test method for {@link Outcome#equals(Outcome)}.
	 */
	@Test
	void testEquals()
	{
		assertTrue(red1.equals(red2));
		assertFalse(red1.equals(black));
		assertFalse(red2.equals(black));
	}
	
	/**
	 * Test method for {@link Outcome#hashCode()}.
	 */
	@Test
	void testHashCode()
	{
		assertTrue(red1.hashCode() == red2.hashCode());
		assertFalse(red1.hashCode() == black.hashCode());
		assertFalse(red2.hashCode() == black.hashCode());
	}
	
	/**
	 * Test method for {@link Outcome#toString()}.
	 */
	@Test
	void testToString()
	{
		assertEquals("Red (1:1)", red1.toString());
		assertEquals("Red (2:1)", red2.toString());
		assertEquals("Black (1:1)", black.toString());
	}
}