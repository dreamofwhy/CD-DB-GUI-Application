package debbie.test;

/**
 * Tests the various data structures
 * 
 * @author debbie heisler
 */

import static org.junit.Assert.*;

import org.junit.Test;

import debbie.dataStructure.*;

public class TestingDataStructures 
{

	@Test
	public void albumTest() 
	{
		String title = "A Boring Album Title";
		int year = 2014;
		
		Album myAlbum = new Album(title, year);
		
		assertEquals("The album title is wrong", title, myAlbum.getTitle());
		assertEquals("The year is wrong", new Integer(year), myAlbum.getYear());
		
		System.out.println(myAlbum);
	}
	
	@Test
	public void artistTest()
	{
		
	}
	
	@Test
	public void songTest()
	{
		
	}

}
