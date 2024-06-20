package student;

public class TimeCard {
    /**
     * The string id of the employee.
     */
    private String employeeId;
    /**
     * The hours of the employee total worked.
     */
    private int hoursWorked;

    /**
     * 
     * @param employeeId The string id of the employee.
     * @param hoursWorked The hours of the employee total worked.
     */
    public TimeCard(String employeeId, int hoursWorked) {
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
    }
    /**
     * 
     * @return The id of the employee.
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * 
     * @return the total hours worked of the
     */
    public int getHoursWorked() {
        return hoursWorked;
    }
    
}
