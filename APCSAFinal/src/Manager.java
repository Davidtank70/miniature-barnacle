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
	 * 
	 */
	public void addEmployee(Employee employee) {
		this.employeesManaged.add(employee);
	}
	
	/*
	 * 
	 */
	public void viewEmployees() {
		for (int i = 0; i < employeesManaged.size(); i++) {
			Employee employee = employeesManaged.get(i);
			System.out.println(employee.getfName() + " " + employee.getlName() + ", SSN: " + employee.getSsn());
		}
	}
	
	/*
	 * 
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
	 * 
	 */
	public void viewEmployeesInfo(Employee employee) {
		String info = "FName: " + employee.getfName() + "\n"
					+ "Lname: " + employee.getlName() + "\n"
					+ "Title: " + employee.getJobTitle() + "\n"
					+ "Annual Pay: " + employee.getAnnualIncome() + "\n"
					+ "SSN: " + employee.getSsn() + "\n"
					+ "MemID: " + employee.getIDNumber() + "\n";
		System.out.println(info);
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
