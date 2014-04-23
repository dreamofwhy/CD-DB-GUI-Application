/**
 * 
 */
package debbie.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import debbie.DB.DBWrapper;

/**
 * Tests for debbie.DB.DBWrapper
 * 
 * @author debbie
 */
@RunWith(JUnit4.class)
public class TestingDatabase 
{
	private static String FILELOCATION = "/Users/debbie/Workspaces/dbConnectionInfo.txt";

	@Test
	public void testDatabaseConnection() 
	{
		
		DBWrapper dbWrapper = new DBWrapper(FILELOCATION);
		
		assertNotNull("dbWrapper should not be null.", dbWrapper);
		assertTrue("Could not connect to database, should be true", 
				dbWrapper.connectToDB());
		
		dbWrapper.closeDB();
	}
	
	@Test
	public void testDatabaseQuery()
	{
		String query = "show tables";
		
		String albums = "Albums";
		String artists = "Artists";
		String songs = "Songs";
		String songsOnAlbums = "SongsOnAlbums";
		String songsPerformedByArtists = "SongsPerformedByArtists";
		String songsWrittenByArtists = "SongsWrittenByArtists";
		ArrayList<String> tableList = new ArrayList<String>(Arrays.asList(new String[]{
				albums, artists, songs, songsOnAlbums, songsPerformedByArtists,
				songsWrittenByArtists
		}));
	
		DBWrapper dbWrapper = new DBWrapper(FILELOCATION);
		dbWrapper.connectToDB();
		
		ResultSet resultSet = dbWrapper.queryVerbatim(query);
		
		// assert verbatim test query returns the list of tables
		try {
			while (resultSet.next())
			{
				String name  = resultSet.getString(1);
				//System.out.println(name);
				assertTrue("Not in list " + name, tableList.contains(name));
			}
		}
		catch (SQLException sqle)
		{
			System.err.println("Error with test query." + sqle);
			fail("Could not execute query");
		}
		catch (java.lang.NullPointerException npe)
		{
			fail("The resultSet is null.");
		}
		dbWrapper.closeDB();
	}

}
