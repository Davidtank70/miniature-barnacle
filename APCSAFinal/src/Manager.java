import java.util.Scanner;
import java.util.ArrayList;

/*
 * Manager subclass extends Employee superclass
 */
public class Manager extends Employee {
	private int employeeCount;
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
	
	/**
	 * Prints how many off task employees there are and adds them
	 * to an array.
	 * 
	 * @return An array containing all off task employees
	 */
	public ArrayList<Employee> offTaskEmployees() {
		ArrayList<Employee> retArr = new ArrayList<>();
		
		for (int i = 0; i < employeesManaged.size(); i++) {
			Employee employee = employeesManaged.get(i);
			if (!employee.isOnTask()) {
				retArr.add(employee);
			}
		}
		
		System.out.println("You have " + retArr.size() + " employees off task.");
		return retArr;
	}	
	
	/**
	 * Helper method to see if an employee with the specified
	 * IDNumber is in the list of managed employees.
	 * 
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
	 * Overrides default toString method to return a string containing
	 * useful information about a manager object.
	 * 
	 * @return A string containing all information about a manager
	 */
	public String toString() {
		String retString = super.toString()
				+ "\n\tSecurity Question: " + getSecurityQuestion()
				+ "\n\tSecurity Answer: " + getSecurityAnswer()
				+ "\n\tPassword: " + getPassword()
				+ "\n\t# Employees Managed: " + getEmployeesManaged().size();
		return retString;
	}
	
	/*
	 * Adds a new employee to the manager's employeesManaged array.
	 */
	public void addEmployee(Employee employee) {
		this.employeesManaged.add(employee);
	}
	
	/**
	 * Getter and setter methods to work with class variables.
	 * 
	 * @return The value of a class level variable.
	 */
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
