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
