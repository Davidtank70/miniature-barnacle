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
		setIDNumber(this.IDNumber);
		
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
		String retString = "ID - " + getIDNumber() + ".) Name: " + getfName() + " " + getlName()
				+ "\n\tTitle: " + getJobTitle()
				+ "\n\tSalary: " + getAnnualIncome()
				+ "\n\tSSN: " + getSsn();
		return retString;
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

	public int getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(int iDNumber) {
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
}
