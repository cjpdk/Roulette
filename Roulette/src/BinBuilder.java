/**
 * 
 */

/**
 * @author cjpdk
 *
 */

public class BinBuilder {

	private static int STRAIGHT_BET = 35;
	private static int SPLIT_BET = 17;
	private static int STREET_BET = 11;
	private static int CORNER_BET = 8;
	private static int FIVE_BET = 6;
	private static int LINE_BET = 5;
	private static int COL_DOZEN_BET = 2;
	private static int EVEN_BET = 1;
	private static int ZERO_ZERO = 37;
	
	/**
	 * 
	 */
	public BinBuilder() { }
	
	void buildBins (Wheel wheel)
	{
		buildZeroBets(wheel);
		buildStraightBets(wheel);
		buildSplitBets(wheel);
		buildStreetBets(wheel);
		buildCornerBets(wheel);
		buildLineBets(wheel);
		buildColumnAndDozenBets(wheel);
		buildEvenBets(wheel);
	}
	
	void buildZeroBets(Wheel wheel)
	{
		Outcome straightZero = new Outcome("Straight 0", STRAIGHT_BET);
		Outcome straightZeroZero = new Outcome("Straight 00", STRAIGHT_BET);
		Outcome fiveBet = new Outcome("Five 00-0-1-2-3", FIVE_BET);
		wheel.addOutcome(0, straightZero);
		wheel.addOutcome(0, fiveBet);
		wheel.addOutcome(ZERO_ZERO, straightZeroZero);
		wheel.addOutcome(ZERO_ZERO, fiveBet);
	}
	
	void buildStraightBets(Wheel wheel)
	{
		for (int i=1; i<=36; i++)
		{
			String ocName = "Straight " + i;
			Outcome straightOc = new Outcome(ocName, STRAIGHT_BET);
			wheel.addOutcome(i, straightOc);
		}
	}
	
	void buildSplitBets(Wheel wheel)
	{
		for (int i=1; i<=34; i+=3)
		{
			String ocName = "Split " + i + "-" + (i+1);
			Outcome splitOc = new Outcome(ocName, SPLIT_BET);
			wheel.addOutcome(i, splitOc);
			wheel.addOutcome(i+1, splitOc);
			ocName = "Split " + (i+1) + "-" + (i+2);
			splitOc = new Outcome(ocName, SPLIT_BET);
			wheel.addOutcome(i+1, splitOc);
			wheel.addOutcome(i+2, splitOc);
		}
		for (int i=1; i<=33; i++)
		{
			String ocName = "Split " + i + "-" + (i+3);
			Outcome splitOc = new Outcome(ocName, SPLIT_BET);
			wheel.addOutcome(i, splitOc);
			wheel.addOutcome(i+3, splitOc);
		}
	}
	
	void buildStreetBets(Wheel wheel)
	{
		for (int i=1; i<=34; i+=3)
		{
			String ocName = "Street " + i + "-" + (i+1) + "-" + (i+2);
			Outcome streetOc = new Outcome(ocName, STREET_BET);
			wheel.addOutcome(i, streetOc);
			wheel.addOutcome(i+1, streetOc);
			wheel.addOutcome(i+2, streetOc);
		}
	}
	
	void buildCornerBets(Wheel wheel)
	{
		for (int i=1; i<=31; i+=3)
		{
			String ocName = "Corner " + i + "-" + (i+1) + "-" + (i+3) + "-" + (i+4);
			Outcome cornerOc = new Outcome(ocName, CORNER_BET);
			wheel.addOutcome(i, cornerOc);
			wheel.addOutcome(i+1, cornerOc);
			wheel.addOutcome(i+3, cornerOc);
			wheel.addOutcome(i+4, cornerOc);
			ocName = "Corner " + (i+1) + "-" + (i+2) + "-" + (i+4) + "-" + (i+5);
			cornerOc = new Outcome(ocName, CORNER_BET);
			wheel.addOutcome(i+1, cornerOc);
			wheel.addOutcome(i+2, cornerOc);
			wheel.addOutcome(i+4, cornerOc);
			wheel.addOutcome(i+5, cornerOc);
		}
	}
	
	void buildLineBets(Wheel wheel)
	{
		for (int i=1; i<=31; i+=3)
		{
			String ocName = "Line " + i + "-" + (i+1) + "-" + (i+2) + "-" + (i+3) + "-" + (i+4) + "-" + (i+5);
			Outcome lineOc = new Outcome(ocName, LINE_BET);
			wheel.addOutcome(i, lineOc);
			wheel.addOutcome(i+1, lineOc);
			wheel.addOutcome(i+2, lineOc);
			wheel.addOutcome(i+3, lineOc);
			wheel.addOutcome(i+4, lineOc);
			wheel.addOutcome(i+5, lineOc);
		}
	}
	
	void buildColumnAndDozenBets(Wheel wheel)
	{
		Outcome column1oc = new Outcome("Column 1", COL_DOZEN_BET);
		Outcome column2oc = new Outcome("Column 2", COL_DOZEN_BET);
		Outcome column3oc = new Outcome("Column 3", COL_DOZEN_BET);
		Outcome dozen1oc = new Outcome("1st Dozen", COL_DOZEN_BET);
		Outcome dozen2oc = new Outcome("2nd Dozen", COL_DOZEN_BET);
		Outcome dozen3oc = new Outcome("3rd Dozen", COL_DOZEN_BET);
		
		for (int i=1; i<=36; i++)
		{
			if (i%3 == 1)
			{
				wheel.addOutcome(i, column1oc);
			}
			else if (i%3 == 2)
			{
				wheel.addOutcome(i, column2oc);
			}
			else
			{
				wheel.addOutcome(i, column3oc);
			}
			
			if (i <= 12)
			{
				wheel.addOutcome(i, dozen1oc);
			}
			else if (i <= 24)
			{
				wheel.addOutcome(i, dozen2oc);
			}
			else
			{
				wheel.addOutcome(i, dozen3oc);
			}
		}
	}
	
	void buildEvenBets(Wheel wheel)
	{
		Outcome redOc = new Outcome("Red", EVEN_BET);
		Outcome blackOc = new Outcome("Black", EVEN_BET);
		Outcome oddOc = new Outcome("Odd", EVEN_BET);
		Outcome evenOc = new Outcome("Even", EVEN_BET);
		Outcome loOc = new Outcome("Lo (1-18)", EVEN_BET);
		Outcome hiOc = new Outcome("Hi (19-36)", EVEN_BET);
		
		for (int i=1; i<=36; i++)
		{
			switch (i)
			{
				case 1:
				case 3:
				case 5:
				case 7:
				case 9:
				case 12:
				case 14:
				case 16:
				case 18:
				case 19:
				case 21:
				case 23:
				case 25:
				case 27:
				case 30:
				case 32:
				case 34:
				case 36:
					wheel.addOutcome(i, redOc);
					break;
				default:
					wheel.addOutcome(i, blackOc);
					break;
			}
			
			if (i%2==1)
			{
				wheel.addOutcome(i, oddOc);
			}
			else
			{
				wheel.addOutcome(i, evenOc);
			}
			
			if (i<=18)
			{
				wheel.addOutcome(i, loOc);
			}
			else
			{
				wheel.addOutcome(i, hiOc);
			}
		}
	}
}