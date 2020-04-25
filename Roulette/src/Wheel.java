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
		if (index < 0 || index >= 38)
		{
			return null;
		}
		else return bins[index];
	}
	
	public static void main(String[] args) {
		NonRandom rng = new NonRandom();
		Wheel w = new Wheel(rng);
		for (int i=0; i<38; i++)
		{
			Outcome o = new Outcome("Single " + i, i);
			w.addOutcome(i, o);
		}
		w.rng.setSeed(23);
		for (int i=0; i<5; i++)
		{
			System.out.println(w.next());
		}
	}
}