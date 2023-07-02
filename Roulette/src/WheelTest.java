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
class WheelTest
{
	Outcome red, black, zero, five;
	NonRandom rng;
	Wheel wheel;
	BinBuilder binFactory;
	String bin2str, bin18str, bin33str;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		red = new Outcome("Red", 1);
		black = new Outcome("Black", 1);
		zero = new Outcome("Straight 0", 35);
		five = new Outcome("Five 00-0-1-2-3", 6);
		
		rng = new NonRandom();
		wheel = new Wheel(rng);
		
		binFactory = new BinBuilder();
		binFactory.buildBins(wheel);
		
		bin2str = "[1st Dozen (2:1), Straight 2 (35:1), Street 1-2-3 (11:1), Line 1-2-3-4-5-6 (5:1), Split 1-2 (17:1), Split 2-3 (17:1), Split 2-5 (17:1), Corner 1-2-4-5 (8:1), Column 2 (2:1), Lo (1-18) (1:1), Corner 2-3-5-6 (8:1), Even (1:1), Black (1:1)]";
		bin18str = "[Line 13-14-15-16-17-18 (5:1), Street 16-17-18 (11:1), Corner 14-15-17-18 (8:1), 2nd Dozen (2:1), Split 15-18 (17:1), Split 17-18 (17:1), Split 18-21 (17:1), Corner 17-18-20-21 (8:1), Straight 18 (35:1), Column 3 (2:1), Lo (1-18) (1:1), Line 16-17-18-19-20-21 (5:1), Red (1:1), Even (1:1)]";
		bin33str = "[Black (1:1), Hi (19-36) (1:1), Corner 29-30-32-33 (8:1), Line 31-32-33-34-35-36 (5:1), Line 28-29-30-31-32-33 (5:1), Split 30-33 (17:1), Split 32-33 (17:1), Split 33-36 (17:1), 3rd Dozen (2:1), Corner 32-33-35-36 (8:1), Straight 33 (35:1), Street 31-32-33 (11:1), Column 3 (2:1), Odd (1:1)]";
	}
	
	/**
	 * Test method for {@link Wheel#Wheel(java.util.Random)}.
	 */
	@Test
	final void testWheel()
	{
		assertNotNull(binFactory);
		assertNotNull(rng);
		assertNotNull(wheel);
	}
	
	/**
	 * Test method for {@link Wheel#addOutcome(int, Outcome)}.
	 */
	@Test
	final void testAddOutcome()
	{
		binFactory.buildBins(wheel);
		assertTrue(wheel.outcomes.contains(red));
		assertTrue(wheel.outcomes.contains(black));
		assertTrue(wheel.outcomes.contains(zero));
		assertTrue(wheel.outcomes.contains(five));
	}
	
	/**
	 * Test method for {@link Wheel#next()}.
	 */
	@Test
	final void testNext()
	{
		binFactory.buildBins(wheel);
		wheel.rng.setSeed(2);
		assertEquals(bin2str, wheel.next().toString());
		wheel.rng.setSeed(18);
		assertEquals(bin18str, wheel.next().toString());
		wheel.rng.setSeed(33);
		assertEquals(bin33str, wheel.next().toString());
		wheel.rng.setSeed(40);
		assertEquals(bin2str, wheel.next().toString());
		wheel.rng.setSeed(94);
		assertEquals(bin18str, wheel.next().toString());
		wheel.rng.setSeed(147);
		assertEquals(bin33str, wheel.next().toString());
	}
	
	/**
	 * Test method for {@link Wheel#get(int)}.
	 */
	@Test
	final void testGet()
	{
		binFactory.buildBins(wheel);
		assertEquals(bin2str, wheel.get(2).toString());
		assertEquals(bin18str, wheel.get(18).toString());
		assertEquals(bin33str, wheel.get(33).toString());
	}
}