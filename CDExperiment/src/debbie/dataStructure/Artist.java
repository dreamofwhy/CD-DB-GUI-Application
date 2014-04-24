package debbie.dataStructure;

/**
 * A class to hold artist information
 * 
 * @author debbie heisler
 *
 */

public class Artist 
{
	String mName = null;
	
	/**
	 * Constructs a new Artist
	 * 
	 * @param name the name of the artist
	 */
	public Artist(String name)
	{
		mName = name;
	}
	
	/**
	 * Returns the name of the artist
	 * 
	 * @return name of the artist
	 */
	public String getName()
	{
		return mName;
	}
	
	/**
	 * Converst an artist to a string
	 * 
	 * @return the name of the artist
	 */
	@Override
	public String toString()
	{
		return mName;
	}
	
	/**
	 * Compares two artists to see if they are the same by comparing
	 * the names of each of the artists
	 * @param other the other artists to compare
	 * @return true if the artist names are equal to each other, 
	 * false otherwise
	 */
	@Override
	public boolean equals(Object other)
	{
		return mName.equals(((Artist)other).getName());
	}
}
