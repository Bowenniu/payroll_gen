package student;

public class PayStub implements IPayStub {
    /**
     * The name of the employee.
     */
    private String employeeName;
    /**
     * The total pay before text of the employee.
     */
    private double netPay;
    /**
     * The tax paid of the employee.
     */
    private double taxesPaid;
    /**
     * The year-to-date earning of the employee.
     */
    private double ytdEarnings;
    /**
     * The year-to-date tax paid of the employee.
     */
    private double ytdTaxesPaid;

    /**
     * 
     * @param employeeName the name of the employee.
     * @param netPay the total income before tax of the employee.
     * @param taxesPaid the tax paid of the employee.
     * @param ytdEarnings the year-to-date earning of the employee.
     * @param ytdTaxesPaid the year-to-date tax paid of the employee.
     */
    public PayStub(String employeeName, double netPay, double taxesPaid,
    double ytdEarnings, double ytdTaxesPaid) {
        this.employeeName = employeeName;
        this.netPay = netPay;
        this.taxesPaid = taxesPaid;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    @Override
    public double getPay() {
        return netPay;
    }

    @Override
    public double getTaxesPaid() {
       return taxesPaid;
    }
    /**
     * 
     * @return the year-to-date earning.
     */
    public double getYTDEarnings() {
        return ytdEarnings;
    }
    /**
     * 
     * @return the year-to-date taxes paid.
     */
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }
    /**
     * 
     * @return the name of the employee.
     */
    public String getEmployeeName() {
        return employeeName;
    }    
}
