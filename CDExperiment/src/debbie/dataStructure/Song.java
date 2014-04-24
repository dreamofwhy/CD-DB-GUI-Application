package debbie.dataStructure;

/**
 * A class to hold song information
 * 
 * @author debbie heisler
 *
 */

public class Song 
{
	String mName = null;
	
	/**
	 * Constructs a new Song
	 * 
	 * @param title the name of the song
	 */
	public Song (String title)
	{
		mName = title;
	}
	
	/**
	 * Returns the name of the song
	 * 
	 * @return the name of the song
	 */
	public String getName()
	{
		return mName;
	}
	
	/**
	 * Converts a song to a string
	 * 
	 * @return the song as a string
	 */
	public String toString()
	{
		return mName;
	}
}
