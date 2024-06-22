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

public class HourlyEmployeeTest {
    @Test 
    public void testNegativeSalary() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Luffy", "s192", -40, 20000, 4530);
        hourlyEmployee.setHourlyRate(-40);
        hourlyEmployee.setHoursWorked(50);
        String expectedMessage = "Salary can not be negative.";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            hourlyEmployee.calculateSalary();
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test //Test to check if the hourly employee's salary will be calculated correctly.
     public void testHourlyEmployeeSalary() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Luffy", "s192", 30.00, 20000, 4530);
        hourlyEmployee.setHourlyRate(40.00);
        hourlyEmployee.setHoursWorked(50);
        double expectedPayStubs = 2000.0;
        double actualPayStubs = hourlyEmployee.calculateSalary();
        assertEquals(expectedPayStubs, actualPayStubs, "Hourly wage employee salary is correct.");
    }
}


