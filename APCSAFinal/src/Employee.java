public class Employee {
	private String fName;
	private String lName;
	private String jobTitle;
	private String SSN;
	private double hourlyPay;
	private double annualIncome;
	private int weeklyHours;
	
	
	private static int IDNumber = 0;
	
	/**
     * Default constructor for the Employee class.
     * Initializes the employee with default values and increments the ID number.
     */
	public Employee() {
		// Set default values for class attributes
		setfName("firstName");
		setlName("lastName");
		setJobTitle("jobTitle");
		setHourlyPay(0.0);
		setWeeklyHours(0);
		setIDNumber(Employee.IDNumber);
		setSSN("000-00-0000");
		
		// Determine annual income based on the weekly hours and pay
		setAnnualIncome(getWeeklyHours() * getHourlyPay());
		
		// Increment the employee ID number
		Employee.IDNumber++;
	}
	
	/**
     * Overloaded constructor for the Employee class.
     * Initializes the employee with the entered values and increments the ID number.
     * The annual income is automatically calculated based on the hourly pay and weekly hours.
     *
     * @param fName       The first name of the employee.
     * @param lName       The last name of the employee.
     * @param jobTitle    The job title of the employee.
     * @param hourlyPay   The hourly pay rate of the employee.
     * @param weeklyHours The number of hours the employee works per week.
     */
	public Employee(String fName, String lName, String jobTitle, 
			String SSN, double hourlyPay, int weeklyHours) {

		// Set the user defined values for class attributes
		setfName(fName);
		setlName(lName);
		setJobTitle(jobTitle);
		setHourlyPay(hourlyPay);
		setWeeklyHours(weeklyHours);
		setSSN(SSN);
		setIDNumber(Employee.IDNumber);
		
		// Determine annual income based on the weekly hours and pay
		setAnnualIncome(getWeeklyHours() * getHourlyPay());

		// Increment the employee ID number
		Employee.IDNumber++;
	}
	
	
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

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}
}
