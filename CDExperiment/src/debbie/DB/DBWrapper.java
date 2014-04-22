package debbie.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * A wrapper class for the database.  This class will send queries to the database and
 * return the data in a data structure.
 * 
 * @author debbie
 *
 */
public class DBWrapper 
{
	private static String DRIVER = "com.mysql.jdbc.Driver";
	
	private String url = null;
	private String dbName = null;
	private String userName = null;
	private String password = null;
	
	private Connection connect = null;
	
	/**
	 * Initializes the DBWrapper by reading in the given file and getting the 
	 * needed database parameters
	 * 
	 * @param fn the absolute location and the name of the file to be read in
	 */
	public DBWrapper(String fn)
	{
		Boolean readIn = readInFile(fn);
		
		System.out.println("readIn is " + readIn);
	}
	
	/**
	 * Internal main for testing and driving this class...for now...
	 * 
	 * @param args not used
	 */
	public static void main (String[] args)
	{
		String fileLocation = "/Users/debbie/Workspaces/dbConnectionInfo.txt";
		DBWrapper dbWrapper = new DBWrapper(fileLocation);
	}
	
	/**
	 * Reads in the given file name.  This text file should only contain the following
	 * pieces of information, each on a separate line
	 * jdbc:mysql://<machineName>:<port>/
	 * <database name>
	 * <userName>
	 * <password>
	 * 
	 * @param fn the absolute path for the file and the file name
	 * @return true if successfully read in the needed information, false otherwise
	 */
	private Boolean readInFile(String fn)
	{
		Boolean readInFile = false;
		BufferedReader fileReader = null;
		
		try {
			String line = null;
			
			fileReader = new BufferedReader(new FileReader(fn));
			
			if ((line = fileReader.readLine()) != null)
			{
				url = line.trim();
			}
			
			if ((line = fileReader.readLine()) != null)
			{
				dbName = line.trim();
			}
			
			if ((line = fileReader.readLine()) != null)
			{
				userName = line.trim();
			}
			
			if ((line = fileReader.readLine()) != null)
			{
				password = line.trim();
			}
			
			readInFile = (url != null) && (dbName != null) && 
					(userName != null) && (password != null);
			
			fileReader.close();
		}
		catch (IOException ioe)
		{
			System.out.println("There is a problem reading in " + fn + ".");
			System.out.println(ioe);
		}
		
		return readInFile;
	}

}
