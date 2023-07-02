import java.util.Random;

/**
 * 
 */

/**
 * @author cjpdk
 *
 */
@SuppressWarnings("serial")
public class NonRandom extends Random
{
	public long nextValue;
	
	NonRandom()
	{
		nextValue = 0;
	}
	
	@Override
	public void setSeed(long n)
	{
		nextValue = n;
	}
	
	@Override
	public int nextInt()
	{
		return (int) nextValue;
	}
}