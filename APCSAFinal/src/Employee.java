import java.util.ArrayList;
import java.util.Random;

public class Employee {
	// Instance variables
	private String fName;
	private String lName;
	private String jobTitle;
	private String ssn;
	private double hourlyPay;
	private double annualIncome;
	private int weeklyHours;
	private boolean isOnTask; //This is temporary, used for offTaskEmployees() method
	private int employeeIDNumber = 0;
	
	// static instance variable
	private static int IDNumber = 0;
	
	/**
	* Initializes the Employee object with default values and increments the ID number.
	* Calls the overloaded constructor to set the attribute values.
	* This is the default constructor for the Employee class.
	*/
	public Employee() {
		// Set default values for class attributes
		this("firstName", "lastName", "jobTitle", "000-00-0000", 0.0, 0);
	}
	
	/**
	* Initializes the Employee object with the entered values and increments the ID number.
	* The annual income is automatically calculated based on the hourly pay and weekly hours.
	*
	* @param fName - The first name of the employee.
	* @param lName - The last name of the employee.
	* @param jobTitle - The job title of the employee.
	* @param hourlyPay - The hourly pay rate of the employee.
	* @param weeklyHours - The number of hours the employee works per week.
	*
	* This is the overloaded constructor for the Employee class.
	*/
	public Employee(String fName, String lName, String jobTitle, 
			String ssn, double hourlyPay, int weeklyHours) {
		// Set the user defined values for class attributes
		setfName(fName);
		setlName(lName);
		setJobTitle(jobTitle);
		setHourlyPay(hourlyPay);
		setWeeklyHours(weeklyHours);
		setSsn(ssn);
		setEmployeeIDNumber(this.IDNumber);
		
		// Determine annual income based on the weekly hours and pay
		setAnnualIncome(getWeeklyHours() * getHourlyPay());

		// Increment the employee ID number
		Employee.IDNumber++;
	}
	
	/**
	 * Overrides default toString method to return a string containing
	 * useful information about an employee object.
	 * 
	 * @return A string containing all information about an employee.
	 */
	public String toString() {
		String retString = "ID - " + getEmployeeIDNumber() + ".) Name: " + getfName() + " " + getlName()
				+ "\n\tTitle: " + getJobTitle()
				+ "\n\tSalary: " + getAnnualIncome()
				+ "\n\tSSN: " + getSsn();
		return retString;
	}
	
	public static ArrayList<Employee> generateEmployeeList() {
        String[] firstNames = {"John", "Jane", "Michael", "Emily", "David", "Olivia", "Daniel", "Sophia", "Andrew", "Isabella"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Davis", "Wilson", "Miller", "Anderson", "Taylor", "Clark", "Thomas"};
        String[] ssnNumbers = {"111-11-1111", "222-22-2222", "333-33-3333", "444-44-4444", "555-55-5555", "666-66-6666", "777-77-7777", "888-88-8888", "999-99-9999", "000-00-0000"};
        String[] jobTitles = {"Manager", "Engineer", "Salesperson", "Designer", "Administrator", "Accountant", "Developer", "Analyst", "Assistant", "Supervisor"};

        ArrayList<Employee> employeeList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            String fName = firstNames[random.nextInt(firstNames.length)];
            String lName = lastNames[random.nextInt(lastNames.length)];
            String jobTitle = jobTitles[random.nextInt(jobTitles.length)];
            String ssn = ssnNumbers[random.nextInt(ssnNumbers.length)];
            double hourlyPay = 10.0 + i; // Increase hourly pay by 1 for each employee
            int weeklyHours = 40; // Assume all employees work 40 hours per week

            Employee employee = new Employee(fName, lName, jobTitle, ssn, hourlyPay, weeklyHours);
            employeeList.add(employee);
        }

        return employeeList;
    }
	
	
	// =========================
	// Getter and setter methods
	
	/**
	 * Sets the annual income of the employee.
	 * Note: This method is automatically called during object initialization to calculate 
	 * the annual income based on the hourly pay rate and weekly hours worked.
	 *
	 * @param annualIncome The annual income to be set for the employee. 
	 */
	private void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getHourlyPay() {
		return hourlyPay;
	}

	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	public int getWeeklyHours() {
		return weeklyHours;
	}

	public void setWeeklyHours(int weeklyHours) {
		this.weeklyHours = weeklyHours;
	}

	public static int getIDNumber() {
		return IDNumber;
	}

	public static void setIDNumber(int iDNumber) {
		IDNumber = iDNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String Ssn) {
		this.ssn = Ssn;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	/*
	 * The following two methods are temporary until a better solution is found.
	 * Used in offTaskEmployees() method
	 */
	public boolean isOnTask() {
		return isOnTask;
	}

	public void setOnTask(boolean isOnTask) {
		this.isOnTask = isOnTask;
	}

	public int getEmployeeIDNumber() {
		return employeeIDNumber;
	}

	public void setEmployeeIDNumber(int employeeIDNumber) {
		this.employeeIDNumber = employeeIDNumber;
	}
	
}
