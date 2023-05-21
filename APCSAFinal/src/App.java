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
	 * Login Process for the app
	 * Gets user input for username and password
	 * Then checks the manager list for the username
	 * and password.
	 * 
	 * Returns true if username and password match
	 * Returns false if username or password do not match
	 * 
	 * Uses the username exists and password matches helper methods
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
	 * Checks if the users login is valid by comparing first the SSN
	 * to each manager in the list and if the SSN matches then it checks
	 * the password. If the password also matches true will be returned.
	 * @param SSN - the managers SSN
	 * @param password - the managers password
	 * @return
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
	 * Gets a users String input and returns it
	 * @param prompt
	 * @return
	 */
	public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt);
        return scanner.nextLine();
    }
	
	/**
	 * Validates the ssn the user inputed matches the desired input criteria
	 * the criteria is as follows and is represented by the regular expression
	 * used after sanitizing (removing all white spaces) the string 
	 * 
	 * ###-##-####
	 * where #s represent digits
	 * and -s represent dashes
	 * 
	 * @param ssn
	 * @return 
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
