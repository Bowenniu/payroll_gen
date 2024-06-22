/*
 * Students, build off this class. We are providing one sample test case as file reading is new to
 * you.
 * 
 * NOTE: you may end up changing this completely depending on how you setup your project.
 * 
 * we are just using .main() as we know that is an entry point that we specified.
 * 
 */

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import student.HourlyEmployee;
import student.IPayStub;

public class PayRollTest {

    @Test 
    public void testNegativeHourlyRate() {
    
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("Luffy", "s192", -40.00, 20000.00, 4530.00,0.00);
        });
        assertEquals("Hourly rate cannot be negative.", exception.getMessage());
    }

    @Test 
    public void testNegativeHoursWorked() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Luffy", "s192", 40.00, 20000.00, 4530.00, 0.00);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            hourlyEmployee.runPayroll(-10.0);
        });
        assertEquals("Hours worked cannot be negative.", exception.getMessage());
    }

     @Test 
    public void testHourlyEmployeeSalary() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Luffy", "s192", 40.00, 20000.00, 4530.00, 0.00);
        double hoursWorked = 50;
        double expectedSalary = 40.00 * hoursWorked;
        double expectedNetIncome = expectedSalary - expectedSalary * 0.15;
        double expectedYtdEarnings = 20000.00 + expectedSalary;
        double expectedYtdTaxesPaid = 4530.00 + expectedSalary * 0.15;

        IPayStub payStub = hourlyEmployee.runPayroll(hoursWorked);
        double actualNetIncome = payStub.getPay();

        assertEquals(expectedNetIncome, actualNetIncome, 0.01, "Hourly wage employee net income is correct.");
        assertEquals(expectedYtdEarnings, hourlyEmployee.getYTDEarnings(), 0.01, "YTD earnings are correct.");
        assertEquals(expectedYtdTaxesPaid, hourlyEmployee.getYTDTaxesPaid(), 0.01, "YTD taxes paid are correct.");
    }
}



