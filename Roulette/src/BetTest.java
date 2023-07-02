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
class BetTest
{
	Outcome red, col1, zero;
	Bet bet1, bet2, bet3, bet4;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		red = new Outcome("Red", 1);
		col1 = new Outcome("Column 1", 2);
		zero= new Outcome("Straight 0", 35);
		bet1 = new Bet(20, red);
		bet2 = new Bet(50, red);
		bet3 = new Bet(100, col1);
		bet4 = new Bet(77, zero);
	}
	
	/**
	 * Test method for {@link Bet#Bet(int, Outcome)}.
	 */
	@Test
	final void testBet()
	{
		assertNotNull(red);
		assertNotNull(col1);
		assertNotNull(zero);
		assertNotNull(bet1);
		assertNotNull(bet2);
		assertNotNull(bet3);
		assertNotNull(bet4);
	}
	
	/**
	 * Test method for {@link Bet#winAmount()}.
	 */
	@Test
	final void testWinAmount()
	{
		assertEquals(40, bet1.winAmount());
		assertEquals(100, bet2.winAmount());
		assertEquals(300, bet3.winAmount());
		assertEquals(2772, bet4.winAmount());
	}
	
	/**
	 * Test method for {@link Bet#loseAmount()}.
	 */
	@Test
	final void testLoseAmount()
	{
		assertEquals(20, bet1.loseAmount());
		assertEquals(50, bet2.loseAmount());
		assertEquals(100, bet3.loseAmount());
		assertEquals(77, bet4.loseAmount());
	}
	
	/**
	 * Test method for {@link Bet#toString()}.
	 */
	@Test
	final void testToString()
	{
		assertEquals("€20 on Red (1:1)", bet1.toString());
		assertEquals("€50 on Red (1:1)", bet2.toString());
		assertEquals("€100 on Column 1 (2:1)", bet3.toString());
		assertEquals("€77 on Straight 0 (35:1)", bet4.toString());
	}
}