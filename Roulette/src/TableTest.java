import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableTest
{
	Table table;
	Outcome outcome;
	Bet bet1, bet2;
	List<Bet> testList;
	
	@BeforeEach
	void setup()
	{
		table = new Table();
		outcome = new Outcome("Red", 1);
		bet1 = new Bet(1000, outcome);
		bet2 = new Bet(1001, outcome);
		testList = new LinkedList<Bet>();
	}
	
	@Test
	void testTable()
	{
		assertNotNull(table);
		assertNotNull(outcome);
		assertNotNull(bet1);
		assertNotNull(bet2);
		assertNotNull(testList);
	}
	
	@Test
	void testIsValid()
	{
		assertTrue(table.isValid(bet1));
		assertFalse(table.isValid(bet2));
	}
	
	@Test
	void testPlaceBet() throws InvalidBetException
	{
		assertEquals(table.bets, testList);
		testList.add(bet1);
		table.placeBet(bet1);
		assertEquals(table.bets, testList);
		testList.add(bet2);
		table.placeBet(bet2);
		assertNotEquals(table.bets, testList);
	}
	
	@Test
	void testIterator() throws InvalidBetException
	{
		assertTrue(iteratorEquals(table.iterator(),testList.listIterator()));
		testList.add(bet1);
		table.placeBet(bet1);
		assertTrue(iteratorEquals(table.iterator(),testList.listIterator()));
		testList.add(bet2);
		table.placeBet(bet2);
		assertFalse(iteratorEquals(table.iterator(),testList.listIterator()));
	}
	
	private boolean iteratorEquals(Iterator<Bet> a, Iterator<Bet> b)
	{
	    while (a.hasNext() && b.hasNext())
	    {
	        if (!a.next().equals(b.next()))
	        {
	            return false;
	        }
	    }
	    if (a.hasNext() || b.hasNext())
	    {
	        return false;
	    }
		return true;
	}
	
	@Test
	void testToString() throws InvalidBetException
	{
		assertEquals(testList.toString(), table.bets.toString());
		testList.add(bet1);
		table.placeBet(bet1);
		assertEquals(testList.toString(), table.bets.toString());
		testList.add(bet2);
		table.placeBet(bet2);
		assertNotEquals(testList.toString(), table.bets.toString());
	}
}
