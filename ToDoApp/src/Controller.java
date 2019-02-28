import java.io.IOException;
import java.util.List;

public class Controller {

	/* Member variables */

	Dao todoList;
	ConsoleUtils consoleUtils;

	/* Constructor */

	public Controller()  {
		
		this.todoList = new Dao();
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

			} else if (input.equals("delete")) {

				processDeleteAction();

			} else if (input.equals("mark done")) {

				processMarkAction();

			} else if (input.equals("list pending") || input.equals("list done") || input.equals("list all")) {

				processListAction(actionParts);

			} else if (input.equals("quit")) {

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
	 * complete) This method conveys that request to the ToDoLIst
	 */
	public void processMarkAction() {

		String input = consoleUtils.promptString("Please enter the Id to be deleted ");		
		
		boolean validinteger = false;

		validinteger = tryParseInt(input);
		if (!validinteger)
			consoleUtils.error(" Error parsing the id");

		int id = Integer.parseInt(input);
		
		if (todoList.update(id)>0)
		System.out.println("The project with Id " + id + " has been successfully marked done");
		else {
			System.out.println("The project with Id" + id + " not found");
			}

	}

	/*
	 * The user requested that a given ToDoLIstEntry be deleted This method conveys
	 * that request to the ToDoLIst
	 */
	public void processDeleteAction() {

		String input = consoleUtils.promptString("Please enter the Id to be deleted ");		
		
		boolean validinteger = false;

		validinteger = tryParseInt(input);
		if (!validinteger)
			consoleUtils.error(" Error parsing the id");

		int id = Integer.parseInt(input);

		if (todoList.delete(id)>0)
			System.out.println("The project with id " + id+ " has been successfully deleted");
			else {
				System.out.println("The project with Id" + id + " not found");
				}
		
	}

	/*
	 * The user wants to view a list of ToDoLIst entries This method conveys that
	 * request to the ToDoLIst, along with any special options (active-only, filter
	 * by project name)
	 */
	public void processListAction(String[] actionParts) {	


		consoleUtils.printList(todoList.getToDoEntries(actionParts[1].trim()));

	}

	/*
	 * The user wants to add a new entry to the ToDoLIst This method conveys that
	 * request to the ToDoLIst, along with the specified project name and task
	 * description
	 */
	public void processAddAction() {

		String description = consoleUtils.promptString("Task:");		
		todoList.add(description);
		System.out.println("Added project " + description + " to the list");

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