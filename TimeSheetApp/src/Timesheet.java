import java.util.ArrayList;
import java.util.List;

public class Timesheet {

	// region for declaring member variables
	private List<TimesheetEntry> database;

	public Timesheet() {
		database = new ArrayList<TimesheetEntry>();
	}

	public void add(String project, String task) {
		TimesheetEntry timesheetentry = new TimesheetEntry(project, task);
		database.add(timesheetentry);
	}

	public List<TimesheetEntry> gettimesheetEntries(String projectname, boolean activeOnly) {

		// check to find list of active entries in current database
		List<TimesheetEntry> activeentries = new ArrayList<TimesheetEntry>();
		for (TimesheetEntry entry : database) {
			if ((activeOnly ? entry.getEndTime() == null : true)
					&& (projectname.isEmpty() ? true : entry.getProjectName().equalsIgnoreCase(projectname)))
				activeentries.add(entry);
		}

		if (activeOnly || !projectname.isEmpty()) {
			// returns filtered list based on active flag and active entries
			return activeentries;
		}

		// returns full list of activeonly is set to false
		return database;
	}

	public TimesheetEntry get(int id) {
		for (TimesheetEntry entry : database) {
			if (entry.getId() == id)
				return entry;
		}
		return null;
	}

	public void delete(TimesheetEntry deleteentry) {

		database.remove(deleteentry);

	}

	public void stop(TimesheetEntry stopentry) {
		for (TimesheetEntry entry : database) {
			if (entry.getId() == stopentry.getId())
			{
				if(entry.getEndTime()!=null)
				{
					throw new IllegalArgumentException("You input "+stopentry.getProjectName() + " is  already have end time");
				}
				entry.updateEndTime();
			}
				
		}
	}

}
