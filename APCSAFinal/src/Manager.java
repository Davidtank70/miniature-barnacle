import java.util.ArrayList;

public class Manager extends Employee {
	private ArrayList<Employee> employees;
	private String securityQuestion;
	private String securityAnswer;
	private String password;
	
	public Manager() {
		super();
	}
	
	/**
	 * Overloaded constructor to create a manager, uses the super constructor
	 * from the employee superclass for the shared variables. 
	 * @param fName
	 * @param lName
	 * @param jobTitle
	 * @param ssn
	 * @param hourlyPay
	 * @param weeklyHours
	 * @param securityQuestion
	 * @param securityAnswer
	 * @param password
	 */
	public Manager(String fName, String lName, String jobTitle, String ssn, double hourlyPay, 
			int weeklyHours, String securityQuestion, String securityAnswer, String password) {
		
		super(fName, lName, jobTitle, ssn, hourlyPay, weeklyHours);
		
		setSecurityQuestion(securityQuestion);
		setSecurityAnswer(securityAnswer);
		setPassword(password);
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
	
}
