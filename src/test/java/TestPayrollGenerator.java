/*
 * Students, build off this class. We are providing one sample test case as file reading is new to
 * you.
 * 
 * NOTE: you may end up changing this completely depending on how you setup your project.
 * 
 * we are just using .main() as we know that is an entry point that we specified.
 * 
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import student.HourlyEmployee;
import student.PayrollGenerator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestPayrollGenerator {

    @TempDir
    static Path tempDir;   


    @Test
    public void testFinalPayStub() throws IOException {
        // copy employees.csv into tempDir
        Path employees = tempDir.resolve("employees.csv");
        Files.copy(Paths.get("resources/employees.csv"), employees);

        // get the path of the paystubs.csv
        Path payStubs = tempDir.resolve("paystubs.csv");



        String[] args = {"-e", employees.toString(), "-t", "resources/time_cards.csv", // allowed,
                                                                                       // this isn't
                                                                                       // modified -
                                                                                       // so safe
                "-o", payStubs.toString()};

        // run main method
        PayrollGenerator.main(args);


        List<String> actualPayStubsLines = Files.readAllLines (payStubs);
        String actualPayStubs = String.join("\n", actualPayStubsLines);
        
        System.out.println("Actual Pay Stubs:");
        System.out.println(actualPayStubs);

        String expectedPayStubs = Files
                .readString(Paths.get("resources/original/pay_stubs_solution_to_original.csv"));
                
        assertEquals(expectedPayStubs,actualPayStubs);


        // you could also read lines and compared the lists

    }

    @Test //Test to check if the hourly employee's salary will be calculated correctly.
     public void testHourlyEmployeeSalary() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Luffy", "s192", 30.00, 20000, 4530, 0);
        hourlyEmployee.setHourlyRate(40.00);
        hourlyEmployee.setHoursWorked(50);
        double expectedPayStubs = 1701.7;
        double actualPayStubs = hourlyEmployee.calculateSalary();
        assertEquals(expectedPayStubs, actualPayStubs, "Hourly wage employee salary is correct.");
    }
}


