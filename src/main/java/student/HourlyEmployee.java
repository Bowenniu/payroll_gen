package student;

public class HourlyEmployee implements IEmployee {
    private String name;
    private String id;
    private double hourlyRate;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double pretaxDeductions;

    public HourlyEmployee(String name, String id, double hourlyRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate cannot be negative.");
        }
        this.name = name;
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }
    /**
     * 
     * @param hourlyRate employee's hourly payment
     */
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate cannot be negative.");
        }
        this.hourlyRate = hourlyRate;
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
        return hourlyRate;
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
            throw new IllegalArgumentException("Hours worked cannot be negative.");
        }

        double salary = calculateSalary(hoursWorked);
        double taxes = calculateTaxes(salary);
        double netIncome = salary - pretaxDeductions - taxes;

        ytdEarnings += salary;
        ytdTaxesPaid += taxes;

        return new PayStub(name, netIncome, taxes, ytdEarnings, ytdTaxesPaid);
    }

    @Override
    public String toCSV() {
        return String.format("HOURLY,%s,%s,%.2f,%.2f,%.2f,%.2f",
                name, id, hourlyRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
    }

    private double calculateSalary(double hoursWorked) {
        return hourlyRate * hoursWorked;
    }

    private double calculateTaxes(double salary) {
        return salary * 0.15;
    }
}