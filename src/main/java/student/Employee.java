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
     * The year-to-date earning of the employee.
     */
    private double ytdEarings;
    /**
     * The year-to-date taxes paid of the employee.
     */
    private double ytdTaxesPaid;
   
    /**
     * 
     * @param name name of the employee.
     * @param id id of the employee.
     * @param payRate pay rate of the employee.
     * @param ytdEarings year-to-date earnings of the employees.
     * @param ytdTaxesPaid year-to-date taxes paid of the employees.
     */
    public Employee(String name, String id, double payRate, double ytdEarings, double ytdTaxesPaid) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarings = ytdEarings;
        this.ytdTaxesPaid = ytdTaxesPaid;
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

    /**
     * 
     * @param payRate the pay rate of the employee.
     */
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    /**
     * 
     * @param ytdEarings the year-to-date earning of the employee.
     */
    public void setYtdEarnings(double ytdEarings) {
        this.ytdEarings = ytdEarings;
    }
    
    /**
     * 
     * @param ytdTaxesPaid the year-to-date taxes paid of the employee.
     */
    public void setYtdTaxesPaid(double ytdTaxesPaid) {
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    /**
     * 
     * @return payRate of the employee.
     */
    public double calculateSalary() {
        return payRate;
    }
}
