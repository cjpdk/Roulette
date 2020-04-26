import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author cjpdk
 *
 */
class BinBuilderTest {
	
	BinBuilder binFactory;
	Random rng;
	Wheel wheel;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		binFactory = new BinBuilder();
		rng = new Random();
		wheel = new Wheel(rng);
	}
	
	/**
	 * Test method for {@link BinBuilder#BinBuilder()}.
	 */
	@Test
	final void testBinBuilder()
	{
		assertNotNull(binFactory);
	}
	
	/**
	 * Test method for {@link BinBuilder#buildBins(Wheel)}.
	 */
	@Test
	final void testBuildBins()
	{
		binFactory.buildBins(wheel);
	}
	
	/**
	 * Test method for {@link BinBuilder#buildZeroBets(Wheel)}.
	 */
	@Test
	final void testBuildZeroBets()
	{
		binFactory.buildZeroBets(wheel);
	}
	
	/**
	 * Test method for {@link BinBuilder#buildStraightBets(Wheel)}.
	 */
	@Test
	final void testBuildStraightBets()
	{
		binFactory.buildStraightBets(wheel);
	}
	
	/**
	 * Test method for {@link BinBuilder#buildSplitBets(Wheel)}.
	 */
	@Test
	final void testBuildSplitBets()
	{
		binFactory.buildSplitBets(wheel);
	}
	
	/**
	 * Test method for {@link BinBuilder#buildStreetBets(Wheel)}.
	 */
	@Test
	final void testBuildStreetBets()
	{
		binFactory.buildStreetBets(wheel);
	}
	
	/**
	 * Test method for {@link BinBuilder#buildCornerBets(Wheel)}.
	 */
	@Test
	final void testBuildCornerBets()
	{
		binFactory.buildCornerBets(wheel);
	}
	
	/**
	 * Test method for {@link BinBuilder#buildLineBets(Wheel)}.
	 */
	@Test
	final void testBuildLineBets()
	{
		binFactory.buildLineBets(wheel);
	}
	
	/**
	 * Test method for {@link BinBuilder#buildColumnAndDozenBets(Wheel)}.
	 */
	@Test
	final void testBuildColumnAndDozenBets()
	{
		binFactory.buildColumnAndDozenBets(wheel);
	}
	
	/**
	 * Test method for {@link BinBuilder#buildEvenBets(Wheel)}.
	 */
	@Test
	final void testBuildEvenBets()
	{
		binFactory.buildEvenBets(wheel);
	}
}