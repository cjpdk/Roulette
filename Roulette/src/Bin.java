import java.util.HashSet;

/**
 * 
 */

/**
 * @author cjpdk
 *
 */
public class Bin {
	
	HashSet<Outcome> winningOutcomes;
	
	/**
	 * 
	 */
	public Bin()
	{
		winningOutcomes = new HashSet<Outcome>();
	}
	
	void add(Outcome oc)
	{
		winningOutcomes.add(oc);
	}
	
	public String toString()
	{
		return winningOutcomes.toString();
	}
}