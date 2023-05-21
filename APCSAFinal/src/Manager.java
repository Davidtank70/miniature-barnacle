import java.util.ArrayList;

public class Manager extends Employee {
	private ArrayList<Employee> employees;
	private String securityQuestion;
	private String securityAnswer;
	private String password;
	
	// Test comment
	public Manager() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
