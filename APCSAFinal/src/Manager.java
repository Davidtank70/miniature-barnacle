import java.util.Scanner;
import java.util.ArrayList;

/*
 * Manager subclass extends Employee superclass
 */
public class Manager extends Employee {
	private int employeeCount;
	private String securityQuestion;
	private String securityAnswer;
	private ArrayList<Emlpoyees> employeesManaged;
	
	
	/*
	 * 
	 */
	public Manager(int memberID, int SSN, double weeklyPay, String firstName, 
				   String lastName, String jobTitle, int employeeCount, String securityQuestion,
				   String securityAnswer, ArrayList<Employee> employeesManaged) {
		
		super(memberID, SSN, weeklyPay, firstName, lastName, jobTitle);
		setEmployeeCount(employeeCount);
		setSecurityQuestion(securityQuestion);
		setSecurityAnswer(securityAnswer);
		setEmployeesManaged(employeesManaged);
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
			
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + ", SSN: " + employee.getSSN());
		}
	}
	
	/*
	 * 
	 */
	public void displayPay(int pay) {
		
	}
	
	/*
	 * 
	 */
	public ArrayList<Employees> offTaskEmployees() {
		for () {
			
		}
	}
	
	/*
	 * 
	 */
	public void viewEmployeesInfo(Employee employee) {
		String info = "FName: " + employee.getFirstName() + "\n"
					+ "Lname: " + employee.getLastName() + "\n"
					+ "Title: " + employee.getJobTitle() + "\n"
					+ "Pay: " + employee.getWeeklyPay() + "\n"
					+ "SSN: " + employee.getSSN() + "\n"
					+ "MemID: " + employee.getMemberID() + "\n";
		
		System.out.println(info);
	}

	/*
	 * 
	 */
	public int getEmployeeCount() {
		return this.employeeCount;
	}

	/*
	 * 
	 */
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
	/*
	 * 
	 */
	public String getSecurityQuestion() {
		return this.securityQuestion;
	}

	/*
	 * 
	 */
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	/*
	 * 
	 */
	public String getSecurityAnswer() {
		return this.securityAnswer;
	}

	/*
	 * 
	 */
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	/*
	 * 
	 */
	public ArrayList<Employee> getEmployeesManaged() {
		return this.employeesManaged;
	}
	
	/*
	 * 
	 */
	public void setEmployeesManaged(ArrayList<Employee> employeesManaged) {
		this.employeesManaged = employeesManaged;
	}
}
