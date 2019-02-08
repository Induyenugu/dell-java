import java.util.List;

public class Controller {

	/* Member variables */

	Timesheet timesheet;
	ConsoleUtils consoleUtils;

	/* Constructor */

	public Controller() {
		this.timesheet = new Timesheet();
		this.consoleUtils = new ConsoleUtils();
	}

	/* Methods */

	/*
	 * Runs the program
	 */
	public void start() {

		consoleUtils.printHelp(); // Print the action menu

		boolean quit = false;
		while (!quit) {

			// Prompt the user for input, collect input, parse into parts
			String input = consoleUtils.promptString("> ");
			String[] actionParts = input.split(" ");
			String action = actionParts[0].trim(); // Primary action

			// Figure out what to do depending on the user's primary action
			if (action.equals("add")) {

				processAddAction();

			} else if (action.equals("delete")) {

				processDeleteAction(actionParts);

			} else if (action.equals("stop")) {

				processStopAction(actionParts);

			} else if (action.equals("list")) {

				processListAction(actionParts);

			} else if (action.equals("quit")) {

				quit = true;
				System.out.println("You Quit the project ");

			} else if (action.equals("help")) {

				processHelpAction();

			} else if (action.length() == 0) {

				// do nothing.

			} else {

				System.out.println("PLease enter valid commands as specified: ");

			}
		}

	}

	/*
	 * The user requested that a given TimesheetEntry be stopped (marked as
	 * complete) This method conveys that request to the Timesheet
	 */
	public void processStopAction(String[] actionParts) {

		if (actionParts.length > 2) {
			consoleUtils.error("Too many inputs to stop command");
			return;
		}

		boolean validinteger = false;
		validinteger = tryParseInt(actionParts[1]);
		if (!validinteger)
			consoleUtils.error(" Error parsing the id");

		int id = Integer.parseInt(actionParts[1]);
		
		TimesheetEntry stopentry = timesheet.get(id);
		if (stopentry != null) {
			timesheet.stop(stopentry);
			System.out.println("The project " + stopentry.getProjectName() + " has been successfully stopped");

		} else {
			System.out.println("The project with Id" + id + " not found");
		}

	}

	/*
	 * The user requested that a given TimesheetEntry be deleted This method conveys
	 * that request to the Timesheet
	 */
	public void processDeleteAction(String[] actionParts) {

		if (actionParts.length > 2) {
			consoleUtils.error("Too many inputs to delete command");
			return;
		}
		boolean validinteger = false;

		validinteger = tryParseInt(actionParts[1]);
		if (!validinteger)
			consoleUtils.error(" Error parsing the id");

		int id = Integer.parseInt(actionParts[1]);

		TimesheetEntry deleteentry = timesheet.get(id);
		if (deleteentry != null) {
			timesheet.delete(deleteentry);
			System.out.println("The project " + deleteentry.getProjectName() + " has been successfully deleted");
		} else {
			System.out.println("The project with Id" + id + " not found");
		}
	}

	/*
	 * The user wants to view a list of timesheet entries This method conveys that
	 * request to the Timesheet, along with any special options (active-only, filter
	 * by project name)
	 */
	public void processListAction(String[] actionParts) {

		if (actionParts.length > 3) {
			consoleUtils.error("Too many inputs to list command");
			return;
		}

		boolean activeOnly = false;
		String projectName = "";
		if (actionParts.length > 1) {
			// if the action part contains -a then make active only flag as true
			// if action part contains other than -a and List take it as project name
			for (String actionpart : actionParts) {
				if (actionpart.equalsIgnoreCase("-a")) {
					activeOnly = true;
				} else if (!actionpart.isEmpty() && !actionpart.equalsIgnoreCase("list")) {
					projectName = actionpart;
				}
			}
		}

		consoleUtils.printList(timesheet.gettimesheetEntries(projectName, activeOnly));

	}

	/*
	 * The user wants to add a new entry to the Timesheet This method conveys that
	 * request to the Timesheet, along with the specified project name and task
	 * description
	 */
	public void processAddAction() {

		String project = consoleUtils.promptString("Project Name (one word only):");
		String description = consoleUtils.promptString("Task:");
		boolean validprojectname = false;
		while (!validprojectname) {
			validprojectname = ValidateProjectName(project);
			if (!validprojectname)
				project = consoleUtils.promptString("please enter project Name again(one word only):");

		}
		timesheet.add(project, description);
		System.out.println("Added project " + project + " to the list");

	}

	private boolean ValidateProjectName(String project) {
		if (project.isEmpty() || project.split(" ").length > 1) {
			return false;
		}
		return true;

	}

	boolean tryParseInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void processHelpAction() {

		consoleUtils.printHelp();

		// Your code here
	}
}