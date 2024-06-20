package student;

public class Employee {
    /**
     * The name of the employee.
     */
    private String name;
    /**
     * The ID of the employee.
     */
    private String id;
    /**
     * The pay rate of the employee.
     */
    private double payRate;
    /**
     * The year-to-date earning of the employee
     */
    private double ytdEarings;
    /**
     * The year-to-date taxes paid of the employee
     */
    private double ytdTaxesPaid;
    /**
     * 
     * @param name the name of the employee.
     * @param id the id of the employee.
     * @param payRate the pay rate of the employee.
     */
    public Employee(String name, String id, double payRate) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarings = 0.0;
        this.ytdTaxesPaid = 0.0;
    }

    /**
     * 
     * @return the name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return the id of the employee.
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @return the pay rate of the employee.
     */
    public double getPayRate() {
        return payRate;
    }
    /**
     * 
     * @return the year-to-date earnings of the employee.
     */
    public double getYtdEarnings() {
        return ytdEarings;
    }
    /**
     * 
     * @return the year-to-date taxes paid by the employees.
     */
    public double getYtdTaxesPaid() {
        return ytdTaxesPaid;
    }
}
