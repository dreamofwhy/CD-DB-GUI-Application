package debbie.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * A wrapper class for the database.  This class will send queries to the database and
 * return the data in a data structure.
 * 
 * @author debbie heisler
 * @version 1.0
 */
public class DBWrapper 
{
	private static String DRIVER = "com.mysql.jdbc.Driver";
	
	private String mUrl = null;
	private String mDBName = null;
	private String mUserName = null;
	private String mPassword = null;
	
	private Connection connection = null;
	
	/**
	 * Initializes the DBWrapper by reading in the given file and getting the 
	 * needed database parameters
	 * 
	 * @param fn the absolute location and the name of the file to be read in
	 */
	public DBWrapper(String fn)
	{
		Boolean readIn = readInFile(fn);

		if (!readIn)
		{
			System.err.println("Unable to read in file parameters.");
		}
	}
	
	/**
	 * Connect to the database.  The needed parameters should have come in with the 
	 * creation of the class
	 * 
	 * @return true if able to connect to the database, false otherwise
	 */
	public Boolean connectToDB()
	{
		Boolean success = false;
		
		// there are values for everything, there should be no null pointer errors
		if ((mUrl != null) && (mDBName != null) && (mUserName != null) 
				&& (mPassword != null))
		{
			try {
				// load the driver
				Class.forName(DRIVER).newInstance();
				
				// set up connection
				connection = DriverManager.getConnection(mUrl+mDBName, mUserName, mPassword);
			}
			catch (Exception ex)
			{
				System.err.println("Problem connecting to the database.\n" + ex);
			}
		}
		
		if (connection != null)
		{
			success = true;
		}
		
		return success;
	}
	
	/**
	 * Closes the database connection.
	 */
	public void closeDB()
	{
		try {
			connection.close();
		}
		catch (SQLException sqle)
		{
			System.err.println("Problem closing database connectoin.\n" + sqle);
		}
	}
	
	/**
	 * Takes any query, submits it to the database and returns the result set.
	 * This can be dangerous.  Really only use for testing purposes.
	 * 
	 * @param query the query to send to the database.
	 * @return a ResultSet containing the results of the query
	 */
	public ResultSet queryVerbatim(String query)
	{
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		}
		catch (SQLException sqle)
		{
			System.err.println("Problem querying verbatim.\n" + sqle);
		}
		
		return resultSet;
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
				mUrl = line.trim();
			}
			
			if ((line = fileReader.readLine()) != null)
			{
				mDBName = line.trim();
			}
			
			if ((line = fileReader.readLine()) != null)
			{
				mUserName = line.trim();
			}
			
			if ((line = fileReader.readLine()) != null)
			{
				mPassword = line.trim();
			}
			
			readInFile = (mUrl != null) && (mDBName != null) && 
					(mUserName != null) && (mPassword != null);
			
			fileReader.close();
		}
		catch (IOException ioe)
		{
			System.err.println("There is a problem reading in " + fn + ".");
			System.err.println(ioe);
		}
		
		return readInFile;
	}

}
