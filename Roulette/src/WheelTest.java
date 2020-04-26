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
class WheelTest {
	
	Outcome red, black, s1;
	NonRandom r;
	Wheel wheel;
	BinBuilder binFactory;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		red = new Outcome("Red", 1);
		black = new Outcome("Black", 1);
		s1 = new Outcome("Single 1", 36);
		r = new NonRandom();
		wheel = new Wheel(r);
		binFactory = new BinBuilder();
	}
	
	/**
	 * Test method for {@link Wheel#Wheel(java.util.Random)}.
	 */
	@Test
	final void testWheel()
	{
		assertNotNull(r);
		assertNotNull(wheel);
	}
	
	/**
	 * Test method for {@link Wheel#addOutcome(int, Outcome)}.
	 */
	@Test
	final void testAddOutcome()
	{
		Bin tmpBin = new Bin();
		tmpBin.add(red);
		tmpBin.add(s1);
		wheel.addOutcome(1, red);
		wheel.addOutcome(1, s1);
		assertEquals(tmpBin.winningOutcomes, wheel.bins[1].winningOutcomes);
	}
	
	/**
	 * Test method for {@link Wheel#next()}.
	 */
	@Test
	final void testNext()
	{
		Bin tmpBin = new Bin();
		tmpBin.add(black);
		wheel.addOutcome(17, black);
		wheel.rng.setSeed(23);
		Bin nextBin = wheel.next();
		assertEquals(tmpBin.winningOutcomes, nextBin.winningOutcomes);
	}
	
	/**
	 * Test method for {@link Wheel#get(int)}.
	 */
	@Test
	final void testGet()
	{
		binFactory.buildBins(wheel);
		Bin b0 = wheel.get(0);
		Bin tmpBin = new Bin();
		tmpBin.add(new Outcome("Straight 0", 35));
		tmpBin.add(new Outcome("Five 00-0-1-2-3", 6));
		assertEquals(tmpBin.winningOutcomes.toString(), b0.winningOutcomes.toString());
	}
}