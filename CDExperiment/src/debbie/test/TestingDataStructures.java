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
	public void songTest()
	{
		String title = "Another stupid song";
		
		Song mySong = new Song(title);
		
		assertEquals("The song name is wrong", title, mySong.getName());
		
		System.out.println(mySong);
	}
	
	@Test
	public void artistTest()
	{
		String name1 = "Bob Dylan";
		String name2 = "Tori Amos";
		
		Artist myArtist1 = new Artist(name1);
		Artist myArtist2 = new Artist(name2);
		
		assertEquals("The artist is not the artist", name1, myArtist1.getName());
		assertFalse("These are supposed to not be the same", myArtist1.equals(myArtist2));
		assertNotEquals("These are supposed to be different", myArtist1, myArtist2);
		
		System.out.println(myArtist1);
	}

}
