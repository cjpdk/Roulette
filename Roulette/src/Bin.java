import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author cjpdk
 *
 */
public class Bin
{
	Set<Outcome> winningOutcomes;
	
	/**
	 * 
	 */
	public Bin()
	{
		winningOutcomes = new TreeSet<>();
	}
	
	public Bin(Outcome[] outcomes)
	{
		this();
		for (Outcome outcome : outcomes)
		{
			add(outcome);
		}
	}
	
	public Bin(Collection<Outcome> outcomes)
	{
		this();
		winningOutcomes.addAll(outcomes);
	}
	
	public void add(Outcome outcome)
	{
		winningOutcomes.add(outcome);
	}
	
	@Override
	public String toString()
	{
		return winningOutcomes.toString();
	}
}