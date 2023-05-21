import java.util.ArrayList;
import java.util.*;

public class App {
	private ArrayList<Manager> managerList;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		String helloPrompt = "Welcome, please enter your credentials.";
		String userNamePrompt = "Please enter your username: ";
		String passwordPrompt = "Please enter your password: ";
		String invalidUsername = "Username invalid back to login...";
		String invalidPassword = "Password invalid back to login...";
		String loginValid = "Login valid. Entering application.";
		
		System.out.println(helloPrompt);
		
		System.out.println(userNamePrompt);
		String SSN = scanner.next();
		System.out.println(passwordPrompt);
		String password = scanner.next();
		
		if (loginIsValid(SSN, password)) {
			System.out.println(loginValid);
			return true;
		}
		return false;
		
	}


	private boolean loginIsValid(String SSN, String password) {
		boolean userNameValid = false;
		boolean passValid = false;
		
		for (Manager manager : managerList) {
			if (manager.getSSN().equals(manager.getSSN())) {
				userNameValid = true;
				if (manager.getPassword().equals(password)) {
					passValid = true;
				}
				break;
			}
		}
		
		return false;
	}
	
	
}
