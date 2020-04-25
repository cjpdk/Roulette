import java.util.ArrayList;

/**
 * 
 */

/**
 * @author cjpdk
 *
 */
public class Bin {
	
	ArrayList<Outcome> winningOutcomes;
	
	/**
	 * 
	 */
	public Bin()
	{
		winningOutcomes = new ArrayList<Outcome>();
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