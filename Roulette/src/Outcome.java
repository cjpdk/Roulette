/**
 * 
 */


/**
 * @author cjpdk
 *
 */
public class Outcome implements Comparable<Outcome>
{
	String name;
	int odds;
	
	Outcome(String name, int odds)
	{
		this.name = name;
		this.odds = odds;
	}
	
	int winAmount(int wager)
	{
		return wager*odds;
	}
	
	boolean equals(Outcome other)
	{
		return this.name == other.name;
	}
	
	@Override
	public int hashCode()
	{
		return name.hashCode();
	}
	
	@Override
	public String toString()
	{
		StringBuffer str = new StringBuffer();
		str.append(name);
		str.append(" (");
		str.append(odds);
		str.append(":1)");
		return str.toString();
	}

	@Override
	public int compareTo(Outcome o)
	{
		return hashCode()-o.hashCode();
	}	
}