

public class ToDo {
	
	/* 
	 * region for declaring member variables
	 */

	private int id;
	private String description;
	private boolean completedFlag;
	

	/**
	 * Constructor that accepts projectName and task Name
	 */
	
	
	public ToDo( String description)
	{
		this.description=description;	
		
	}	
	
	public ToDo( int id, String description, boolean completedFlag)
	{
		this.description=description;
		this.id=id;
		this.completedFlag=completedFlag;
	}	
	
	/**
	 * @return the projectName
	 */
	public String getDescription() {
		return description;
	}
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the id
	 */
	public boolean getCompletedFlag() {
		return completedFlag;
	}
	
	
	
	

}
