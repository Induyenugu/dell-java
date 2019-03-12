import java.time.LocalDateTime;

public class TimesheetEntry {
	
	/* 
	 * region for declaring member variables
	 */
	private String projectName;
	private String task;
	private int id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;	
	private static int NEXTID = 1;

	/**
	 * Constructor that accepts projectName and task Name
	 */
	public TimesheetEntry(String myProject, String myTask)
	{
		projectName=myProject;
		task=myTask;
		startTime=LocalDateTime.now();
		id=NEXTID;
		NEXTID++;		
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @return the task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the startTime
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public LocalDateTime getEndTime() {
		return endTime;
	}

	/**
	 * @return the nEXTID
	 */
	public static int getNEXTID() {
		return NEXTID;
	}

	
	public void updateEndTime()
	{
		if(endTime==null)
		{
			endTime=LocalDateTime.now();
		}
	}
	

}
