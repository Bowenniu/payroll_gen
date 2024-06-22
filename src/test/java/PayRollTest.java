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

public class PayRollTest {

    @Test 
    public void testNegativeHourlyRate() {
    
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("Luffy", "s192", -40.00, 20000.00, 4530.00,0.00);
        });
        assertEquals("Hourly rate cannot be negative.", exception.getMessage());
    }
}


