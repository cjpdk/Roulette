/**
 * 
 */

/**
 * @author cjpdk
 *
 */
public class Bet
{
	int amountBet;
	Outcome chosenOutcome;
	
	/**
	 * 
	 */
	public Bet(int money, Outcome outcome)
	{
		amountBet = money;
		chosenOutcome = outcome;
	}
	
	public int winAmount()
	{
		return amountBet + chosenOutcome.winAmount(amountBet);
	}
	
	public int loseAmount()
	{
		return amountBet;
	}
	
	@Override
	public String toString()
	{
		StringBuffer str = new StringBuffer("€");
		str.append(amountBet);
		str.append(" on ");
		str.append(chosenOutcome.toString());
		return str.toString();
	}
}