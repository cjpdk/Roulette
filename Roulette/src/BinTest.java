import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author cjpdk
 *
 */
class BinTest
{
	Outcome red, zero;
	Bin bin1, bin2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		red = new Outcome("Red", 1);
		zero = new Outcome("Single 0", 35);
		bin1 = new Bin();
		bin2 = new Bin();
		bin1.add(red);
		bin2.add(red);
		bin2.add(zero);
	}
	
	/**
	 * Test method for {@link Bin#Bin()}.
	 */
	@Test
	void testBin()
	{
		assertNotNull(red);
		assertNotNull(zero);
		assertNotNull(bin1);
		assertNotNull(bin2);
	}
	
	/**
	 * Test method for {@link Bin#add(Outcome)}.
	 */
	@Test
	void testAdd()
	{
		Set<Outcome> bin1outcomes = new TreeSet<>();
		bin1outcomes.add(red);
		Set<Outcome> bin2outcomes = new TreeSet<>();
		bin2outcomes.add(red);
		bin2outcomes.add(zero);
		
		assertEquals(bin1outcomes, bin1.winningOutcomes);
		assertEquals(bin2outcomes, bin2.winningOutcomes);
	}
	
	/**
	 * Test method for {@link Bin#toString()}.
	 */
	@Test
	void testToString()
	{
		String bin1str = "[Red (1:1)]";
		String bin2str = "[Red (1:1), Single 0 (35:1)]";
		
		assertEquals(bin1str, bin1.toString());
		assertEquals(bin2str, bin2.toString());
	}
}