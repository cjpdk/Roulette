import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author cjpdk
 *
 */
class BinTest {
	
	Outcome red, black;
	Bin b1, b2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		red = new Outcome("Red", 1);
		black = new Outcome("Black", 1);
		b1 = new Bin();
		b2 = new Bin();
		b1.add(red);
		b1.add(black);
		b2.add(red);
	}
	
	/**
	 * Test method for {@link Bin#Bin()}.
	 */
	@Test
	void testBin()
	{
		assertNotNull(red);
		assertNotNull(black);
		assertNotNull(b1);
		assertNotNull(b2);
	}
	
	/**
	 * Test method for {@link Bin#add(Outcome)}.
	 */
	@Test
	void testAdd()
	{
		ArrayList<Outcome> b1ocs = new ArrayList<Outcome>();
		b1ocs.add(red);
		b1ocs.add(black);
		ArrayList<Outcome> b2ocs = new ArrayList<Outcome>();
		b2ocs.add(red);
		assertEquals(b1ocs, b1.winningOutcomes);
		assertEquals(b2ocs, b2.winningOutcomes);
	}
	
	/**
	 * Test method for {@link Bin#toString()}.
	 */
	@Test
	void testToString()
	{
		String b1str = "[Red (1:1), Black (1:1)]";
		String b2str = "[Red (1:1)]";
		assertEquals(b1str, b1.toString());
		assertEquals(b2str, b2.toString());
	}
}