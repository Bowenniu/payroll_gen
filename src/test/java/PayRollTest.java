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
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import student.HourlyEmployee;
import student.IPayStub;
import student.PayrollGenerator;

public class PayRollTest {

      @TempDir
    static Path tempDir;

    @Test
    public void testFinalPayStub() throws IOException {
        // copy employees.csv into tempDir
        Path employees = tempDir.resolve("employees.csv");
        Files.copy(Paths.get("resources/employees.csv"), employees);

        // get the path of the paystubs.csv
        Path payStubs = tempDir.resolve("paystubs.csv");



        String[] args = {"-e", employees.toString(), "-t", 
                "resources/time_cards.csv",
                "-o", payStubs.toString()};

        // run main method
        PayrollGenerator.main(args);



      try {
        String expectedPayStubs = Files
                .readString(Paths.get("resources/original/pay_stubs_solution_to_original.csv"));

        String actualPayStubs = Files.readString(payStubs);

        assertEquals(expectedPayStubs, actualPayStubs);
      } catch (IOException e) {
        fail("Error reading files");
      }

        // you could also read lines and compared the lists
    }
}



