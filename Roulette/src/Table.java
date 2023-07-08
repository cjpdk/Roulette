/**
 * 
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 */
public class Table
{
	List<Bet> bets;
	int limit;
	/**
	 * 
	 */
	public Table()
	{
		bets = new LinkedList<>();
		limit = 1000;
	}
	
	boolean isValid(Bet bet)
	{
		return sumOfBets() + bet.amountBet <= limit;
	}
	
	void placeBet(Bet bet) throws InvalidBetException
	{
		if (isValid(bet))
		{
			bets.add(bet);
		}
		if (sumOfBets() > limit)
		{
			throw new InvalidBetException("Bet " + bet.toString() + " cannot be added to the Table");
		}
	}
	
	private int sumOfBets()
	{
		int sumOfBets = 0;
		for (Bet b : bets)
		{
			sumOfBets += b.amountBet;
		}
		return sumOfBets;
	}
	
	Iterator<Bet> iterator()
	{
		return bets.listIterator();
	}
	
	@Override
	public String toString()
	{
		return bets.toString();
	}
}
