import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

/**
 * 
 */

/**
 * @author cjpdk
 *
 */
public class Wheel
{
	Vector<Bin> bins;
	Set<Outcome> outcomes;
	Random rng;
	
	/**
	 * 
	 */
	public Wheel(Random random)
	{
		bins = new Vector<>(38);
		for (int i=0; i<38; i++)
		{
			bins.add(new Bin());
		}
		outcomes = new TreeSet<>();
		rng = random;
	}
	
	void addOutcome(int index, Outcome outcome)
	{
		bins.get(index).add(outcome);
		outcomes.add(outcome);
	}
	
	Bin next()
	{
		return get(rng.nextInt()%38);
	}
	
	Bin get(int index)
	{
		return bins.get(index);
	}
}