package debbie.dataStructure;

/**
 * A class to hold album information
 * 
 * @author debbie heisler
 * @version 1.0
 * @since 2014-04-23
 */

public class Album 
{
	private String mTitle = null;
	private Integer mYear = null;
	
	/**
	 * Constructs a new Album from the title and year
	 * 
	 * @param title title of album
	 * @param year year album was released
	 */
	public Album(String title, Integer year)
	{
		mTitle = title;
		mYear = year;
	}
	
	/**
	 * Constructs a new Album form the title and year
	 * 
	 * @param title  title of album
	 * @param year   year album was released
	 */
	public Album(String title, int year)
	{
		this(title, new Integer(year));
	}
	
	/**
	 * Returns the title of this album
	 * 
	 * @return  title of this album
	 */
	public String getTitle()
	{
		return mTitle;
	}
	
	/**
	 * Returns the year album published
	 * 
	 * @return year album published
	 */
	public Integer getYear()
	{
		return mYear;
	}
	
	/**
	 * Converts Album into a string
	 * 
	 * @return  a string representation of the Album
	 */
	@Override
	public String toString()
	{
		return mTitle + ", " + mYear;
	}
}
