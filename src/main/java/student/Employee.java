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
     * 
     * @param name the name of the employee.
     * @param id the id of the employee.
     * @param payRate the pay rate of the employee.
     */
    public Employee(String name, String id, double payRate) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
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
    
}
