import java.util.ArrayList;
import java.util.*;

public class App {
	private ArrayList<Manager> managerList = new ArrayList<Manager>();
	private ArrayList<Integer> pagesVisited = new ArrayList<Integer>();
	private Manager activeManager;
	
	//Employer FICA tax rate for 2023, may be temporary
	private static final double TAX_RATE = 0.0765;
	
	public static void main(String[] args) {
		// Ensure at least 1 manager.
		App app = new App();
		Manager masterKey = new Manager("Joe", "Bill", "Admin", "123-45-6789", 25.5, 40, "What color is the sky?", "Blue", "Eclipse");
        app.addManager(masterKey);
        
        if (app.loginProcess()) {
        	
    		app.application();
        }
	}
	
	private void application() {
		displayMenu();
	}
	
	private void displayMenu() {
		// TODO Display with options 1-9 the menu options
		// upon selection of the menu option run the associated method
		System.out.println("Welcome to the Company Manager Login page, "
				+ "please choose one the following options listed below:\n"
				+ "1. View Employees\n"
				+ "2. View Specific Employee\n"
				+ "3. View Company Stats\n"
				+ "4. Promote Employee\n"
				+ "5. Hire Employee\n"
				+ "6. Fire Employee\n"
				+ "7. Exit Program\n"
				+ "8. Switch Account\n"
				+ "9. Add Manager\n");
	}
	
	/*
	 * Adds a page to the pagesVisited array list
	 */
	private void addPage(int page) {
		getPagesVisited().add(page);
	}
	
	/*
	 * Displays basic information about the employees under a manager
	 */
	public void viewEmployees() { // 1 on action diagram
		addPage(1);
		ArrayList<Employee> employeeArr = getActiveManager().getEmployeesManaged();
		
		for (int i = 0; i < employeeArr.size(); i++) {
			Employee employee = employeeArr.get(i);
			System.out.println(i + 1 + ".) " + employee.getfName() + " " + employee.getlName() + ":\n\tSalary: $"
					+ employee.getAnnualIncome() + "\n\tJob title: " + employee.getJobTitle() + "\n\tID Number: " 
					+ employee.getIDNumber() + "\n");
		}
	}
	
	/*
	 * Views all info on an employee that was found by searching through user IDs,
	 * or prints an error message of invalid input is entered
	 */
	private void viewSpecificEmployee() { // 2 on action diagram
		addPage(2);
		final String inputPrompt = "Which ID number would you like to view all of the details for? (or -1 to exit): ";
		final String errorMsg = "ID could not be found or an incorrect input was entered. Please enter something valid.";
		
		while (true) {
			String usrInput = getStringInput(inputPrompt);
			Employee employee = getEmployeeByID(usrInput);
			
			if (usrInput.equals("-1")) {
				break;
			} else if (employee != null) {
				employee.toString();
				break;
			} else  {
				System.out.println(errorMsg);
			}
		}
	}
	
	/**
	 * Finds and returns an employee by using their ID
	 * 
	 * @param employeeID - An employee's ID as a string
	 * @return The employee that was found by searching the array, or null otherwise
	 */
	private Employee getEmployeeByID(String employeeID) {
		ArrayList<Employee> employeeArr = getActiveManager().getEmployeesManaged();
		Employee retEmployee = null;
		
		for (int i = 0; i < employeeArr.size(); i++) {
			if (Integer.toString(employeeArr.get(i).getIDNumber()).equals(employeeID)) {
				retEmployee = employeeArr.get(i);
			}
		}
		
		return retEmployee;
	}
	
	/*
	 * Prints company stats like total company salaries
	 */
	private void viewCompanyStats() { // 3 on action diagram
		addPage(3);
		double employeeSalaries = getTotalEmployeeSalaries();
		double managerSalaries = getTotalManagerSalares();
		double companySalaries = employeeSalaries + managerSalaries;
		String output = "Total Normal Employee Salaries Pre-Tax: %.2f"
				+ "Total Manager Salaries Pre-Tax: %.2f"
				+ "Total Worker Salaries Pre-Tax: %.2f%n"
				+ "---------------------------------------------"
				+ "Total Normal Employee Salaries Post-Tax: %.2f"
				+ "Total Manager Salaries Post-Tax: %.2f"
				+ "Total Worker Salaries Post-Tax: %.2f%n%n";
		System.out.printf(output, employeeSalaries, managerSalaries, companySalaries, 
				removeTax(employeeSalaries), removeTax(managerSalaries), removeTax(companySalaries));
		// TODO tally the total company salaries and calculate tax information
		// also calculate any and all other statistics that come to mind
	}
	
	/**
	 * Retrieves and returns the total salaries of all manager's employees
	 * 
	 * @return A double containing the total salaries of all manager's employees
	 */
	public double getTotalEmployeeSalaries() {
		double total = 0.0;
		
		for (int i = 0; i < getManagerList().size(); i++) {
			for (int k = 0; k < getManagerList().get(i).getEmployeesManaged().size(); i++) {
				total += getManagerList().get(i).getEmployeesManaged().get(k).getAnnualIncome();
			}
		}
		
		return total;
	}
	
	/**
	 * Retrieves and returns the total salaries of all managers
	 * 
	 * @return A double containing the total salaries of all managers
	 */
	public double getTotalManagerSalares() {
		double total = 0.0;
		
		for (int i = 0; i < getManagerList().size(); i++) {
			total += getManagerList().get(i).getAnnualIncome();
		}
		
		return total;
	}
	
	/**
	 * Subtracts the total tax from the salary
	 * 
	 * @return A double with the tax removed from the salary
	 */
	public double removeTax(double salary) {
		return salary - (salary * TAX_RATE);
	}
	
	private void promoteEmployee() { // 4 on action diagram
		addPage(4);
		// TODO change the employee productiveness stat within a pseudo-random range
		// depending on how big of a promotion they recieved, (%increase of their pay)
	}
	
	private void hireEmployee() { // 5 on action diagram
		addPage(5);
		// TODO within certain conditions generate an employee to be hired
		// ask for confirmation before hiring employee, also add an option
		// to hire up to 5 at a time (recommended to go into employee class
		// and make a method to generate this employee and then you 
		// can add that to the employee list here
	}
	
	/*
	 * Removes an employee from active manager's managed employees by
	 * finding their ID. Will print an error message if improper input
	 * is entered.
	 */
	private void fireEmployee() { // 6 on action diagram
		addPage(6);
		ArrayList<Employee> employees = getActiveManager().getEmployeesManaged();
		final String getIdPrompt = "What's the ID of the employee you'd like to remove? (or -1 to exit): ";
		final String errorPrompt = "ID could not be found or an incorrect input was entered. Please enter something valid.";
		final String repeatPrompt = "Do you want to remove another employee? (y/n): ";
		final String successPrompt = "You now have %d employees remaining. Employee removed:%n%n%s%n%n";
		
		boolean run = true;
		while (run) {
			int usrInput = getIntInput(getIdPrompt);
			int index = getIdIndex(usrInput);
			
			if (usrInput == -1) {
				run = false;
			} else {
				if (index > -1 ) {
					System.out.printf(successPrompt, employees.size() - 1, employees.get(index));
					employees.remove(index);
					run = userContinues(repeatPrompt);
				} else {
					System.out.println(errorPrompt);
				}
			}
		}
		
		// TODO remove an employee from the managers employee list
	}
	
	/**
	 * Returns true or false if the user wants to continue or not, or prints
	 * an error message if the user's input doesn't contain y or n
	 * 
	 * @param prompt - A string containing the prompt to be asked
	 * @return true if the user enters y, false if the user enters x
	 */
	private boolean userContinues(String prompt) {
		final String errorPrompt = "Invalid input. Please enter something that matches the given values.";
		
		while (true) {
			String response = getStringInput(prompt).toLowerCase();
			
			if (response.indexOf("n") > -1) {
				return false;
			} else if (response.indexOf("y") == -1) {
				System.out.println(errorPrompt);
			} else {
				return true;
			}
		}
	}
	
	/**
	 * Gets the index that a specific ID is found at, or -1 otherwise
	 * 
	 * @param IDNumber - The ID to search for
	 * @return An index containing the index that IDNumber was found at, -1 otherwise
	 */
	private int getIdIndex(int IDNumber) {
		ArrayList<Employee> employees = getActiveManager().getEmployeesManaged();
		int index = -1;
		
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getIDNumber() == IDNumber) {
				index = i;
			}
		}
		
		return index;
	}
	
	/*
	 * Displays goodbye message to the working manager then closes program
	 * 
	 * This can be made more complicated, wasn't really sure if it was supposed to be this simple.
	 * The pages visited thing can also be deleted if need be, was just something to code and add 
	 * functionality.
	 */
	private void exitProgram() { // 7 on action diagram
		addPage(7);
		String goodbyeMsg = " %n%nGoodbye, %s.%nYou visited " 
					+ "the following pages in this order:%n%s";
		System.out.printf(goodbyeMsg, getActiveManager().getfName(), getPageOrder());
		System.exit(0);
	}
	
	/**
	 * Gets the order of pages that the user visited during their time using
	 * the program
	 * 
	 * @return A string containing the pages visited
	 */
	private String getPageOrder() {
		ArrayList<Integer> pageArr = getPagesVisited();
		String retString = "[" + pageArr.get(0);
		
		for (int i = 1; i < pageArr.size(); i++) {
			retString += ", " + pageArr.get(i);
		}
		
		return retString + "]";
	}
	
	private void sendToLogin() { // 8 on action diagram
		addPage(8);
		// TODO send the user to login and display a message stating this happened
	}
	
	private void addNewManager() { // 9 on action diagram
		addPage(9);
		addManager(Manager.managerCreationWizzard());
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
		final String invalidSsn = "Please enter a valid ssn incuding all numbers and dashes";
		final String passwordPrompt = "Please enter your password (ensure you type it properly): ";
		final String invalidPassword = "Password invalid back to login...";
		final String loginValid = "Login valid. Entering application.";
		final String loginInvalid = "Login invalid, back to login....";
		
		//  login process
		System.out.println(helloPrompt);
		
		// get the users ssn 
		// if it is typed imporperly ask again until done right
		while (!validSsnInput(ssn)) {
			ssn = getStringInput(userNamePrompt);
			if (!validSsnInput(ssn)) {
				System.out.println(invalidSsn);
			}
		}
		
		// get the users password input
		String password = getStringInput(passwordPrompt);
		
		// determine if the users ssn and password match
		// any of the managers, if they do logon success.
		if (managerIsValid(ssn, password)) {
			System.out.println(loginValid);
			return true;
		} else {
			System.out.println(loginInvalid);
		}
		
		return false;
		
	}
	

	
	private Manager setActiveManager(String ssn) {
		for (Manager manager : managerList) {
			if (manager.getSsn() == ssn) {
				setActiveManager(manager);
			}
		}
		return null;
	}

	/**
	 * Helper method for logging in
	 * 
	 * Checks if the user's login is valid by first comparing the SSN
	 * to each manager in the list. If the SSN matches, it then checks
	 * the password. If both the SSN and password match, it returns true.
	 *
	 * @param ssn - The SSN of the manager.
	 * @param password - The password of the manager.
	 * @return true if the login is valid, false otherwise.
	 */
	private boolean managerIsValid(String ssn, String password) {
		boolean ssnValid = false;
		boolean passValid = false;
		
		for (Manager manager : getManagerList()) {
			if (manager.getSsn().equals(ssn)) {
				ssnValid = true;
				if (manager.getPassword().equals(password)) {
					passValid = true;
				}
				break;
			}
		}
		
		if (ssnValid && passValid) {
			setActiveManager(ssn);
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
	 * Retrieves a user's double input and returns it.
	 * 
	 * @param prompt - The message prompting the user for input.
	 * @return The user's double input
	 */
	public static double getDoubleInput(String prompt) {
		return Double.parseDouble(getStringInput(prompt));
	}
	
	/**
	 * Retrieves a user's int input and returns it.
	 * 
	 * @param prompt - The message prompting the user for input.
	 * @return The user's int input
	 */
	public static int getIntInput(String prompt) {
		return Integer.parseInt(getStringInput(prompt));
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
	public static boolean validSsnInput(String ssn) {
		String sanitizedString = ssn.replaceAll("\\s+", "");
		return sanitizedString.matches("\\d{3}-\\d{2}-\\d{4}");
	}
	
	/**
	 * Adds a manager to the managerList given a manager object
	 * 
	 * @param manager
	 */
	public void addManager(Manager manager) {
		getManagerList().add(manager);
	}

	public Manager getActiveManager() {
		return activeManager;
	}

	public void setActiveManager(Manager activeManager) {
		this.activeManager = activeManager;
	}

	private ArrayList<Integer> getPagesVisited() {
		return pagesVisited;
	}

	private ArrayList<Manager> getManagerList() {
		return managerList;
	}
}
