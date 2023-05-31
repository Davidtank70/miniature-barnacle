import java.util.Scanner;
import java.util.ArrayList;

/*
 * Manager subclass extends Employee superclass
 */
public class Manager extends Employee {
	private int employeeCount = 0;
	private String securityQuestion;
	private String securityAnswer;
	private String password;
	private ArrayList<Employee> employeesManaged;
	
	
	public Manager() {
		super();
	}
	
	/**
	* Initializes a manager object by using the super constructor
	* from the Employee superclass to set the shared variables.
	*
	* @param fName - The first name of the manager.
	* @param lName - The last name of the manager.
	* @param jobTitle - The job title of the manager.
	* @param ssn - The SSN of the manager.
	* @param hourlyPay - The hourly pay rate of the manager.
	* @param weeklyHours - The number of hours the manager works per week.
	* @param securityQuestion - The security question for the manager's account.
	* @param securityAnswer - The security answer for the manager's account.
	* @param password - The password for the manager's account.
	*
	* This is the overloaded constructor for creating a manager.
	*/
	public Manager(String fName, String lName, String jobTitle, String ssn, double hourlyPay, 
			int weeklyHours, String securityQuestion, String securityAnswer, String password) {
		
		super(fName, lName, jobTitle, ssn, hourlyPay, weeklyHours);
		
		setSecurityQuestion(securityQuestion);
		setSecurityAnswer(securityAnswer);
		setPassword(password);
	}
	
	/*
	 * TODO: write a javadoc
	 */
	public void addEmployee(Employee employee) {
		this.employeesManaged.add(employee);
	}
	
	/*
	 * TODO: write a javadoc
	 */
	public void viewEmployees() {
		for (int i = 0; i < employeesManaged.size(); i++) {
			Employee employee = employeesManaged.get(i);
			System.out.println(employee.getfName() + " " + employee.getlName() + ", SSN: " + employee.getSsn());
		}
	}
	
	/*
	 * TODO: write a javadoc
	 */
	public void displayPay(int pay) {
		
	}
	
	/*
	 * TODO: write javadoc for method
	 */
	public ArrayList<Employee> offTaskEmployees() {
		return this.employeesManaged; // change this (only for compilation)
	}
	
	/*
	 * TODO: write a javadoc for this method
	 */
	public void viewAllEmployeeInfo() {
		
	}
	
	
	/**
	 * Helper method to see if an employee with the specified
	 * IDNumber is in the list of managed employees.
	 * @param IDNumber
	 * @return true or false if the employee exist
	 */
	public boolean employeeExists(int IDNumber) {
		boolean foundMatching = false;
		for (Employee employee : employeesManaged) {
			if (employee.getIDNumber() == IDNumber) {
				foundMatching = true;
			}
		}
		return foundMatching;
	}
	
	/**
	 * This method guides the user through a wizard-like process to create a new manager.
	 * It prompts the user for their first name, last name, role, SSN, hourly pay, weekly hours,
	 * security question, security answer, and password. It validates the SSN input and displays
     * the entered information for confirmation. Finally, it creates and returns a Manager object
     * with the entered information.
     * @return the Manager object created with the entered information
	 */
	public static Manager managerCreationWizzard() {
	    Scanner input = new Scanner(System.in);
	    boolean validSsnInput = false;
	    String ssn = "";

	    final String fNamePrompt = "Please enter your first name\nIf you have two please separate with a hyphen (no spaces).\n: ";
	    final String lNamePrompt = "Please enter your last name\nIf you have two please separate with a hyphen (no spaces).\n: ";
	    final String rolePrompt = "Please enter the role this person performs (one word).\n: ";
	    final String ssnPrompt = "Please enter your SSN in the format of ###-##-####.\n: ";
	    final String hourlyPayPrompt = "Please enter your weekly pay as dictated by your employer.\n: ";
	    final String weeklyHoursPrompt = "Please enter your weekly hours as dictated by your employer.\n: ";
	    final String securityQuestionPrompt = "Please create a security question only you know the answer to.\n: ";
	    final String securityAnswerPrompt = "Please enter the answer to the previous security question you entered.\n: ";
	    final String passwordPrompt = "Lastly, please create a password.\n: ";

	    String fName = App.getStringInput(fNamePrompt);
	    String lName = App.getStringInput(lNamePrompt);
	    String role = App.getStringInput(rolePrompt);

	    String securityQuestion = App.getStringInput(securityQuestionPrompt);
	    String securityAnswer = App.getStringInput(securityAnswerPrompt);
	    String password = App.getStringInput(passwordPrompt);

	    double hourlyPay = App.getDoubleInput(hourlyPayPrompt);
	    int weeklyHours = (int)App.getDoubleInput(weeklyHoursPrompt);

	    while (!validSsnInput) {
	        ssn = App.getStringInput(ssnPrompt);
	        validSsnInput = App.validSsnInput(ssn);
	    }

	    System.out.println("Your manager will be created with this information, is this correct?");
	    System.out.println("First Name: " + fName);
	    System.out.println("Last Name: " + lName);
	    System.out.println("Role: " + role);
	    System.out.println("SSN: " + ssn);
	    System.out.println("Hourly Pay: " + hourlyPay);
	    System.out.println("Weekly Hours: " + weeklyHours);
	    System.out.println("Security Question: " + securityQuestion);
	    System.out.println("Security Answer: " + securityAnswer);
	    System.out.println("Password: " + password);

	    // Create and return the manager object with the entered information
	    Manager newManager = new Manager(fName, lName, role, ssn, hourlyPay, weeklyHours, securityQuestion, securityAnswer, password);
	    return newManager;
	}
	
	// Getter and setter methods
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	public ArrayList<Employee> getEmployeesManaged() {
		return this.employeesManaged;
	}
	
	public void setEmployeesManaged(ArrayList<Employee> employeesManaged) {
		this.employeesManaged = employeesManaged;
	}
}
