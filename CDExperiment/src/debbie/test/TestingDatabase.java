/**
 * 
 */
package debbie.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
		// information_schema, CDCollection
		DBWrapper dbWrapper = new DBWrapper(FILELOCATION);
		dbWrapper.connectToDB();
		
		// assert verbatim test query returns two items
		
		dbWrapper.closeDB();
	}

}
