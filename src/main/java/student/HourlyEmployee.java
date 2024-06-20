package student;

public class HourlyEmployee implements IEmployee {
    /**
     * The name of the hourly employee.
     */
    private String name;
    /**
     * The ID of the hourly employee.
     */
    private String id;
    /**
     * The hourly pay rate of the employee.
     */
    private double payRate;
    /**
     * The year-to-dates earning of the hourly employee.
     */
    private double ytdEarnings;
    /**
     * The year-to-dates tax paid of the hourly employee.
     */
    private double ytdTaxesPaid;
    /**
     * The pre-tax deductions of the hourly employee.
     */
    private double pretaxDeductions;
    /**
     * The total hours that the employee has worked.
     */
    private double hoursWorked;

    /**
     * 
     * @param name the name of the hourly employee.
     * @param id the id of the hourly employee.
     * @param payRate the hourly pay rate of the hourly employee.
     * @param ytdEarnings the year-to-date earning of the hourly employee.
     * @param ytdTaxesPaid the year-to-date tax payment of the hourly employee.
     * @param pretaxDeductions the pre-tax deductions (insurances, mediacals) of the employee.
     */
    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings,
    double ytdTaxesPaid, double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public double getPayRate() {
        return payRate;
    }

    @Override
    public double getYTDEarnings() {
        return ytdEarnings;
    }

    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }

    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }

    /**
     * 
     * @param payRate the hourly pay rate of the hourly paid employee.
     */
    public void setHourlyRate(double payRate) {
        this.payRate = payRate;
    }

    /**
     * 
     * @param hoursWorked the total hours worked of the hourly paid employee.
     */
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) { //if the employee worked 0 or less hours, don't need to be paid.
            return null;
        }
        double netPay;
        if (hoursWorked <= 40) {
            netPay = payRate * hoursWorked; // first 40 hours total pay
        } else {
            netPay = payRate * 40 + payRate * 1.5 * (hoursWorked - 40); // first 40 hours total pay + overtime pay
        }
        double medicare = netPay * 0.0145; //Medical care requires 1.45%
        double socialSecurity = netPay * 0.062; //Social security requires 6.2%
        double withholding = netPay * 0.15; // Withholding requires 15%
        double totalTax = medicare + socialSecurity + withholding; //Total tax collected

        double netIncome = netPay - pretaxDeductions - totalTax;

        ytdEarnings += netPay;
        ytdTaxesPaid += netPay;

        return new PayStub(name, netIncome, totalTax, ytdEarnings, ytdTaxesPaid);
    }

    /**
     * 
     * @return return the new paystub including name, net income, total tax, 
     * year-to-date earnings and year-to-date tax paid.
     */
    public double calculateSalary() {
        return runPayroll(hoursWorked).getPay();
    }
    @Override
    public String toCSV() {
        return String.format("HOURLY,%s,%s,%.2f,%.2f,%.2f,%.2f",
        name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
    }
}
