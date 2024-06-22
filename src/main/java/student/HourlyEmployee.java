package student;

public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(String name, String id, int payRate, int ytdEarnings,
    int ytdTaxesPaid, int pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid);
        this.hourlyRate = payRate;
    }

    /**
     * 
     * @param payRate the hourly pay rate of the hourly paid employee.
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * 
     * @param hoursWorked the total hours worked of the hourly paid employee.
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary(){
       double salary = hourlyRate * hoursWorked;
       if (salary < 0) {
            throw new IllegalArgumentException("Salary can not be negative.");
       }
       return salary;
    }
}
