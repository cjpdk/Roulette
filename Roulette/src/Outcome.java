/**
 * 
 */

/**
 * @author cjpdk
 *
 */
public class Outcome extends Object {
	
	String name;
	int odds;
	
	Outcome(String str, int n)
	{
		name = str;
		odds = n;
	}
	
	int winAmount(int wager)
	{
		return wager*odds;
	}
	
	boolean equals(Outcome other)
	{
		return this.name == other.name;
	}
	/*
	public int hashCode()
	{
		return toString().hashCode();
	}*/
	
	public String toString()
	{
		return name + " (" + odds + ":1)";
	}	
}