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
class BetTest {
	
	Outcome red, zerozero;
	Bet bet1, bet2, bet3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		red = new Outcome("Red", 1);
		zerozero = new Outcome("Straight 00", 35);
		bet1 = new Bet(20, red);
		bet2 = new Bet(50, red);
		bet3 = new Bet(50, zerozero);
	}
	
	/**
	 * Test method for {@link Bet#Bet(int, Outcome)}.
	 */
	@Test
	final void testBet()
	{
		assertNotNull(bet1);
		assertNotNull(bet2);
		assertNotNull(bet3);
	}
	
	/**
	 * Test method for {@link Bet#winAmount()}.
	 */
	@Test
	final void testWinAmount()
	{
		assertEquals(40, bet1.winAmount());
		assertEquals(100, bet2.winAmount());
		assertEquals(1800, bet3.winAmount());
	}
	
	/**
	 * Test method for {@link Bet#loseAmount()}.
	 */
	@Test
	final void testLoseAmount()
	{
		assertEquals(20, bet1.loseAmount());
		assertEquals(50, bet2.loseAmount());
		assertEquals(50, bet3.loseAmount());
	}
	
	/**
	 * Test method for {@link Bet#toString()}.
	 */
	@Test
	final void testToString()
	{
		assertEquals("€20 on Red (1:1)", bet1.toString());
		assertEquals("€50 on Red (1:1)", bet2.toString());
		assertEquals("€50 on Straight 00 (35:1)", bet3.toString());
	}
}