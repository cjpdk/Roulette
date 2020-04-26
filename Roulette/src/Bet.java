/**
 * 
 */

/**
 * @author cjpdk
 *
 */
public class Bet {
	
	int amountBet;
	Outcome chosenOutcome;
	
	/**
	 * 
	 */
	public Bet(int n, Outcome oc)
	{
		amountBet = n;
		chosenOutcome = oc;
	}
	
	public int winAmount()
	{
		return amountBet + chosenOutcome.winAmount(amountBet);
	}
	
	public int loseAmount()
	{
		return amountBet;
	}
	
	public String toString()
	{
		return "€" + amountBet + " on " + chosenOutcome;
	}
}