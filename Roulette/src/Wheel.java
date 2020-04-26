import java.util.Random;

/**
 * 
 */

/**
 * @author cjpdk
 *
 */
public class Wheel {
	
	Bin[] bins;
	Random rng;
	
	/**
	 * 
	 */
	public Wheel(Random r)
	{
		bins = new Bin[38];
		for (int i=0; i<38; i++)
		{
			bins[i] = new Bin();
		}
		rng = r;
	}
	
	void addOutcome(int index, Outcome oc)
	{
		bins[index].add(oc);
	}
	
	Bin next()
	{
		int index = rng.nextInt(38);
		return bins[index];
	}
	
	Bin get(int index)
	{
		return bins[index];
	}
}