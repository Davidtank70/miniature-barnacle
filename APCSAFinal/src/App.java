import java.util.ArrayList;
import java.util.*;

public class App {
	private ArrayList<Manager> managerList = new ArrayList<Manager>();
	
	public static void main(String[] args) {
		// Ensure at least 1 manager.
		App app = new App();
		Manager masterKey = new Manager("Joe", "Bill", "Admin", "123-45-6789", 25.5, 40, "What color is the sky?", "Blue", "Eclipse");
        app.addManager(masterKey);
		app.loginProcess();
		app.application();
	}
	
	private void application() {
		displayMenu();
	}
	
	private void displayMenu() {
		// TODO Display with options 1-9 the menu options
		// upon selection of the menu option run the associated method
	}
	
	private void viewEmployees() { // 1 on action diagram
		// TODO for every employee under the signed in manager print their associated information
		// in a format of "fName", "lName", "Salary"$, "jobTitle", "EmployeeID" for each employee
	}
	
	private void viewSpecificEmployee() { // 2 on action diagram
		// TODO ask if the user would like to see all employees under them
		// if so run viewEmployees()
		// then ask for the employee ID of the employee they would like to view
		// search all employees for this ID and if one is found display all associated info.
	}
	
	private void viewCompanyStats() { // 3 on action diagram
		// TODO tally the total company salaries and calculate tax information
		// also calculate any and all other statistics that come to mind
	}
	
	private void promoteEmployee() { // 4 on action diagram
		// TODO change the employee productiveness stat within a pseudo-random range
		// depending on how big of a promotion they recieved, (%increase of their pay)
	}
	
	private void hireEmployee() { // 5 on action diagram
		// TODO within certain conditions generate an employee to be hired
		// ask for confirmation before hiring employee, also add an option
		// to hire up to 5 at a time (recommended to go into employee class
		// and make a method to generate this employee and then you 
		// can add that to the employee list here
	}
	
	private void fireEmployee() { // 6 on action diagram
		// TODO remove an employee from the managers employee list
	}
	
	private void exitProgram() { // 7 on action diagram
		// TODO exit the program and display a goodbye message
	}
	
	private void sendToLogin() { // 8 on action diagram
		// TODO send the user to login and display a message stating this happened
	}
	
	private void addNewManager() { // 9 on action diagram
		// TODO add a new manager to the manager list
		// recommended to go into manager class and make a method that will
		// prompt for all associated manager info and then call the overloaded
		// constructor using that info to make a manager and then add that manager to 
		// to the manager list
	}
	
	/**
	* Performs the login process for the app.
	* Retrieves user input for SSN and password,
	* and then checks the manager list for a match
	* of the entered SSN and password.
	*
	* Returns true if the SSN and password match,
	* false if either the SSN or password do not match.
	*
	* Utilizes helper methods to check if the SSN exists
	* and if the password matches.
	*/
	private boolean loginProcess() {
		Scanner scanner = new Scanner(System.in);
		String ssn = "";
		
		// declare and initialize prompts
		final String helloPrompt = "Welcome, please enter your credentials.";
		final String userNamePrompt = "Please enter your ssn \"###-##-####\": ";
		final String passwordPrompt = "Please enter your password (ensure you type it properly): ";
		final String invalidPassword = "Password invalid back to login...";
		final String loginValid = "Login valid. Entering application.";
		final String loginInvalid = "Login invalid. Exiting Epplication.";
		
		//  login process
		System.out.println(helloPrompt);
		
		// get the users ssn and password
		while (!validateSsnInput(ssn)) ssn = getStringInput(userNamePrompt);
		String password = getStringInput(passwordPrompt);
		
		if (userIsValid(ssn, password)) {
			System.out.println(loginValid);
			return true;
		} else {
			System.out.println(loginInvalid);
		}
		
		return false;
		
	}


	/**
	* Checks if the user's login is valid by first comparing the SSN
	* to each manager in the list. If the SSN matches, it then checks
	* the password. If both the SSN and password match, it returns true.
	*
	* @param ssn - The SSN of the manager.
	* @param password - The password of the manager.
	* @return true if the login is valid, false otherwise.
	*/
	private boolean userIsValid(String ssn, String password) {
		boolean ssnValid = false;
		boolean passValid = false;
		
		for (Manager manager : this.managerList) {
			if (manager.getSsn().equals(ssn)) {
				ssnValid = true;
				if (manager.getPassword().equals(password)) {
					passValid = true;
				}
				break;
			}
		}
		
		return ssnValid && passValid;
	}
	
	/**
	* Retrieves a user's string input and returns it.
	*
	* @param prompt - The message prompting the user for input.
	* @return The user's string input.
	*/
	public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt);
        return scanner.nextLine();
    }
	
	/**
	* Validates whether the user input for SSN matches the desired criteria.
	* The criteria are as follows, represented by the regular expression
	* applied after sanitizing (removing all white spaces) the string:
	*
	* ###-##-####
	* where # represents a digit
	* and - represents a dash
	*
	* @param ssn - The user-input SSN to be validated.
	* @return true if the SSN matches the desired criteria, false otherwise.
	*/
	public static boolean validateSsnInput(String ssn) {
		String sanitizedString = ssn.replaceAll("\\s+", "");
		return sanitizedString.matches("\\d{3}-\\d{2}-\\d{4}");
	}
	
	/**
	 * Adds a manager to the managerList given a manager object
	 * @param manager
	 */
	public void addManager (Manager manager) {
		this.managerList.add(manager);
	}
	
	
}
