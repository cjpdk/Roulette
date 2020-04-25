import java.util.Random;

/**
 * 
 */

/**
 * @author cjpdk
 *
 */
public class NonRandom extends Random {
	
	int nextValue;
	
	NonRandom()
	{
		nextValue = 1;
	}
	
	void setSeed(int n)
	{
		nextValue = n;
	}
	
	int choice(int[] list)
	{
		return list[nextValue];
	}
}