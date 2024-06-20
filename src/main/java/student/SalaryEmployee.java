package student;

public class SalaryEmployee implements IEmployee {
    /**
     * The name of the salaray employee.
     */
    private String name;
    /**
     * The id of the salary paid employee.
     */
    private String id;
    /**
     * The pay rate of the salary employee.
     */
    private double payRate;
    /**
     * The year-to-date earnings of the salary employee.
     */
    private double ytdEarnings;
    /**
     * The year-to-date tax paid of the salary employee.
     */
    private double ytdTaxesPaid;
    /**
     * The pre tax deductions of the salary employee.
     */
    private double pretaxDeductions;

    /**
     * 
     * @param name the name of the employee.
     * @param id the id of the employee.
     * @param payRate the pay rate of the employee.
     * @param ytdEarnings the year-to-date earnings of the employee.
     * @param ytdTaxesPaid the year-to-date tax paid of the employee.
     * @param pretaxDeductions the pre tax deductions of the employee.
     */
    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings,
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

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }
        double netPay = payRate / 24;

        double medicare = netPay * 0.0145; //Medical care requires 1.45%
        double socialSecurity = netPay * 0.062; //Social security requires 6.2%
        double withholding = netPay * 0.15; // Withholding requires 15%
        double totalTax = medicare + socialSecurity + withholding; //Total tax collected

        double netIncome = netPay - pretaxDeductions - totalTax;

        ytdEarnings += netPay;
        ytdTaxesPaid += netPay;

        return new PayStub(name, netIncome, totalTax, ytdEarnings, ytdTaxesPaid);
    }

    @Override
    public String toCSV() {
        return String.format("SALARY,%s,%s,%.2f,%.2f,%.2f,%.2f",
        name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
    }
    
}
