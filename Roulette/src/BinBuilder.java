/**
 * 
 */

/**
 * @author cjpdk
 *
 */

public class BinBuilder
{
	private static int ZERO_ZERO = 37;
	private static int STRAIGHT_BET = 35;
	private static int SPLIT_BET = 17;
	private static int STREET_BET = 11;
	private static int CORNER_BET = 8;
	private static int FIVE_BET = 6;
	private static int LINE_BET = 5;
	private static int COLUMN_AND_DOZEN_BET = 2;
	private static int EVEN_BET = 1;
	private static int[] REDS = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
	
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
			String outcomeName = "Straight " + i;
			Outcome straightOutcome = new Outcome(outcomeName, STRAIGHT_BET);
			wheel.addOutcome(i, straightOutcome);
		}
	}
	
	void buildSplitBets(Wheel wheel)
	{
		for (int i=1; i<=34; i+=3)
		{
			String outcomeName = "Split " + i + "-" + (i+1);
			Outcome splitOutcome = new Outcome(outcomeName, SPLIT_BET);
			wheel.addOutcome(i, splitOutcome);
			wheel.addOutcome(i+1, splitOutcome);
			outcomeName = "Split " + (i+1) + "-" + (i+2);
			splitOutcome = new Outcome(outcomeName, SPLIT_BET);
			wheel.addOutcome(i+1, splitOutcome);
			wheel.addOutcome(i+2, splitOutcome);
		}
		for (int i=1; i<=33; i++)
		{
			String outcomeName = "Split " + i + "-" + (i+3);
			Outcome splitOutcome = new Outcome(outcomeName, SPLIT_BET);
			wheel.addOutcome(i, splitOutcome);
			wheel.addOutcome(i+3, splitOutcome);
		}
	}
	
	void buildStreetBets(Wheel wheel)
	{
		for (int i=1; i<=34; i+=3)
		{
			String outcomeName = "Street " + i + "-" + (i+1) + "-" + (i+2);
			Outcome streetOutcome = new Outcome(outcomeName, STREET_BET);
			wheel.addOutcome(i, streetOutcome);
			wheel.addOutcome(i+1, streetOutcome);
			wheel.addOutcome(i+2, streetOutcome);
		}
	}
	
	void buildCornerBets(Wheel wheel)
	{
		for (int i=1; i<=31; i+=3)
		{
			String outcomeName = "Corner " + i + "-" + (i+1) + "-" + (i+3) + "-" + (i+4);
			Outcome cornerOutcome = new Outcome(outcomeName, CORNER_BET);
			wheel.addOutcome(i, cornerOutcome);
			wheel.addOutcome(i+1, cornerOutcome);
			wheel.addOutcome(i+3, cornerOutcome);
			wheel.addOutcome(i+4, cornerOutcome);
			outcomeName = "Corner " + (i+1) + "-" + (i+2) + "-" + (i+4) + "-" + (i+5);
			cornerOutcome = new Outcome(outcomeName, CORNER_BET);
			wheel.addOutcome(i+1, cornerOutcome);
			wheel.addOutcome(i+2, cornerOutcome);
			wheel.addOutcome(i+4, cornerOutcome);
			wheel.addOutcome(i+5, cornerOutcome);
		}
	}
	
	void buildLineBets(Wheel wheel)
	{
		for (int i=1; i<=31; i+=3)
		{
			String outcomeName = "Line " + i + "-" + (i+1) + "-" + (i+2) + "-" + (i+3) + "-" + (i+4) + "-" + (i+5);
			Outcome lineOutcome = new Outcome(outcomeName, LINE_BET);
			wheel.addOutcome(i, lineOutcome);
			wheel.addOutcome(i+1, lineOutcome);
			wheel.addOutcome(i+2, lineOutcome);
			wheel.addOutcome(i+3, lineOutcome);
			wheel.addOutcome(i+4, lineOutcome);
			wheel.addOutcome(i+5, lineOutcome);
		}
	}
	
	void buildColumnAndDozenBets(Wheel wheel)
	{
		Outcome column1outcome = new Outcome("Column 1", COLUMN_AND_DOZEN_BET);
		Outcome column2outcome = new Outcome("Column 2", COLUMN_AND_DOZEN_BET);
		Outcome column3outcome = new Outcome("Column 3", COLUMN_AND_DOZEN_BET);
		Outcome dozen1outcome = new Outcome("1st Dozen", COLUMN_AND_DOZEN_BET);
		Outcome dozen2outcome = new Outcome("2nd Dozen", COLUMN_AND_DOZEN_BET);
		Outcome dozen3outcome = new Outcome("3rd Dozen", COLUMN_AND_DOZEN_BET);
		for (int i=1; i<=36; i++)
		{
			if (i%3 == 1)
			{
				wheel.addOutcome(i, column1outcome);
			}
			else if (i%3 == 2)
			{
				wheel.addOutcome(i, column2outcome);
			}
			else
			{
				wheel.addOutcome(i, column3outcome);
			}
			if (i <= 12)
			{
				wheel.addOutcome(i, dozen1outcome);
			}
			else if (i <= 24)
			{
				wheel.addOutcome(i, dozen2outcome);
			}
			else
			{
				wheel.addOutcome(i, dozen3outcome);
			}
		}
	}
	
	void buildEvenBets(Wheel wheel)
	{
		Outcome redOutcome = new Outcome("Red", EVEN_BET);
		Outcome blackOutcome = new Outcome("Black", EVEN_BET);
		Outcome oddOutcome = new Outcome("Odd", EVEN_BET);
		Outcome evenOutcome = new Outcome("Even", EVEN_BET);
		Outcome loOutcome = new Outcome("Lo (1-18)", EVEN_BET);
		Outcome hiOutcome = new Outcome("Hi (19-36)", EVEN_BET);
		for (int i=1; i<=36; i++)
		{
			if (isRed(i))
			{
				wheel.addOutcome(i, redOutcome);
			}
			else
			{
				wheel.addOutcome(i, blackOutcome);
			}
			if (i%2==1)
			{
				wheel.addOutcome(i, oddOutcome);
			}
			else
			{
				wheel.addOutcome(i, evenOutcome);
			}
			if (i<=18)
			{
				wheel.addOutcome(i, loOutcome);
			}
			else
			{
				wheel.addOutcome(i, hiOutcome);
			}
		}
	}
	
	private boolean isRed(int n)
	{
		for (int redNumber : REDS)
		{
			if (n == redNumber)
			{
				return true;
			}
		}
		return false;
	}
}