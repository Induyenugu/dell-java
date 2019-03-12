import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleUtils {

	/* Member variables */
	
    private Scanner scanner;
    private DateTimeFormatter timeFormatter;
    
    /* Constructor */
    
    public ConsoleUtils(){
        scanner = new Scanner(System.in);
        timeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm");
    }

	/* Methods */
	
	/*
	 * Prints the menu of actions to the console
	 */
    public void printHelp(){
        System.out.println("Available Commands: ");        
        System.out.println("  add                   to add an item");
        System.out.println("  delete ID             delete an item");
        System.out.println("  mark done   			update item to done");
        System.out.println("  list pending   		List all pending items");
        System.out.println("  list done   			List all completed items");
        System.out.println("  list all   			List all items");
        System.out.println("  help                  display available commands");
        System.out.println("  quit                  quit to exit");
        System.out.println();

    }

	/*
	 * Prints an informational message to the console
	 */
    public void info(String msg){
        System.out.println("["+msg+"]");
        System.out.println();
    }

	/*
	 * Prints an error message to the console
	 */
    public void error(String msg){
        System.out.println("[ERROR: "+msg+"]");
        System.out.println();
        }

	/*
	 * Prompts the user to enter input
	 * Returns the text entered by the user
	 */
    public String promptString(String label){
        System.out.print(label+" ");
        return scanner.nextLine();
    }

	/*
	 * Prints a list of TimesheetEntry objects in a pretty table
	 */
    public void printList(List<ToDo> entries){
        int longestProject =  7;

        for(ToDo entry : entries){
            if(entry.getDescription().length() > longestProject){
                longestProject = entry.getDescription().length();
            }           
        }

        String projectHeader = String.format("%"+longestProject+"s", "Project");
        String projectUnderline = "";
        for(int i=0;i<longestProject;i++){
            projectUnderline+="-";
        }        
       

        System.out.println("  ID  | "+projectHeader    +" |Status         ");
        System.out.println("-----+-"+projectUnderline+"-+----------------");

        for(ToDo entry : entries){
            String project = String.format("%-"+longestProject+"s", entry.getDescription());
           
            String status = entry.getCompletedFlag()?"Done":"Pending";
          
            String line = String.format(" %2s | %s | %s ", entry.getId(), project, status);
            System.out.println(line);
        }

        if(entries.size() == 1){
            System.out.println("[1 entry]");
        } else {
            System.out.println("["+entries.size()+" entries]");
        }

        System.out.println();
    }
}