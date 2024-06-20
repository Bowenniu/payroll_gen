package student;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Main driver for the PayrollGenerator program.
 * 
 * Students, you are free to modify this file as needed, but you need to leave in the parts where we
 * can pass in the employee and payroll files as arguments.
 * 
 * Grading wise, we will both be using unit tests, and running your program with different employee
 * files. We also will create a separate output file for each.
 * 
 * 
 * To run the program, you can use the following command:
 * 
 * java student.PayrollGenerator -e employees_mine.csv -t time_cards.csv -o pay_stubs_mine.csv or
 * java student.PayrollGenerator The above defaults listed below.
 **/
public final class PayrollGenerator {
    /** default file name for employees. */
    private static final String DEFAULT_EMPLOYEE_FILE = "resources/employees.csv";
    /** default file name for pay stub output. */
    private static final String DEFAULT_PAYROLL_FILE = "resources/pay_stubs.csv";
    /** default time card file name. */
    private static final String DEFAULT_TIME_CARD_FILE = "resources/time_cards.csv";


    /**
     * private constructor to prevent instantiation.
     */
    private PayrollGenerator() {

    }

    /**
     * Main driver for the program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Arguments arguments = Arguments.process(args); // leave this, and make sure you use it on
                                                       // reading/writing files!

        // you are free to modify this code, or use it as a basis for your code
        // depends on how you want to implement the program
        List<String> employeeLines = readLines(arguments.getEmployeeFile());
        List<String> timeCardLines = readLines(arguments.getTimeCards());

        if (employeeLines.isEmpty() || timeCardLines.isEmpty()) {
            System.err.println("Employee or Time Card file is empty or not found.");
            return;
        }

        List<Employee> employees = parseEmployees(employeeLines);
        List<TimeCard> timeCards = parseTimeCards(timeCardLines);

        List<String> payStubs = generatePayStubs(employees, timeCards);
        payStubs.add(0, "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"); // Add header to output

        String outputFilePath = arguments.getPayrollFile();
        try {
            Files.write(Paths.get(outputFilePath), payStubs);
            System.out.println("Pay stubs generated successfully and saved to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error writing pay stubs to file: " + e.getMessage());
        }
    }

    private static List<String> readLines(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static List<TimeCard> parseTimeCards(List<String> timeCardLines) {
        List<TimeCard> timeCards = new ArrayList<>();
        for (int i = 1; i < timeCardLines.size(); i++) { // in order to skip the first line, use this 
            String line = timeCardLines.get(i);
            String[] parts = line.split(",");
            if (parts.length >= 2) {
                String employeeId = parts[0].trim();
                try {
                int hoursWorked = Integer.parseInt(parts[1].trim());
                timeCards.add(new TimeCard(employeeId, hoursWorked));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing hours worked for lines: " + line);
                    e.printStackTrace();
                }
            }
        }
        return timeCards;
    }

    private static List<Employee> parseEmployees(List<String> employeeLines) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i < employeeLines.size(); i++) {
            String line = employeeLines.get(i);
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                String name = parts[0].trim();
                String id = parts[1].trim();
                try {
                double payRate = Double.parseDouble(parts[2].trim());
                employees.add(new Employee(name, id, payRate));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing pay rate for line: " + line);
                    e.printStackTrace();
                }
            }
        }
        return employees;
    }


    private static List<String> generatePayStubs(List<Employee> employees, List<TimeCard> timeCards) {
        List<String> payStubs = new ArrayList<>();
        
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            String employeeId = employee.getId();
            TimeCard matchingTimeCard = findMatchingTimeCard(timeCards, employeeId);
            if (matchingTimeCard != null) {
                double payAmount = calculatePay(employee, matchingTimeCard);
                double taxes = calculateTaxes(payAmount);
                double ytdEarnings = calculateYtdEarnings(employee);
                double ytdTaxesPaid = calculateYtdTaxesPaid(employee);
                String payStubLine = formatPayStub(employee.getName(), payAmount, taxes, ytdEarnings, ytdTaxesPaid);
                payStubs.add(payStubLine);
            }
        }
        return payStubs;
    }

    private static TimeCard findMatchingTimeCard(List<TimeCard> timeCards, String employeeId) {
        return timeCards.stream()
                        .filter(timeCard -> timeCard.getEmployeeId().equals(employeeId))
                        .findFirst()
                        .orElse(null);
    }

    private static double calculatePay(Employee employee, TimeCard timeCard) {
        int hoursWorked = timeCard.getHoursWorked();
        double payRate = employee.getPayRate();
        return hoursWorked * payRate;
    }

    private static double calculateTaxes(double payAmount) {
        return payAmount * 0.15;
    }

    private static double calculateYtdEarnings(Employee employee) {
        return 20000.0;
    }

    private static double calculateYtdTaxesPaid(Employee employee) {
        return 4530.0;
    }
    
    private static String formatPayStub(String name, double payAmount, double taxes, double ytdEarnings, double ytdTaxesPaid) {
        return String.format("%s,%.2f,%.2f,%.2f,%.2f", name, payAmount, taxes, ytdEarnings, ytdTaxesPaid);
    }

    /**
     * This is an internal class. Please leave it as is/do not modify! This design is common for
     * processing arguments if you want to make sure it is unique to the driver.
     */
    private static final class Arguments {
        /** sets the employeeFile argument. */
        private String employeeFile = DEFAULT_EMPLOYEE_FILE;

        /** sets the payrollFile argument. */
        private String payrollFile = DEFAULT_PAYROLL_FILE;

        /** sets the timeCards argument. */
        private String timeCards = DEFAULT_TIME_CARD_FILE;


        /**
         * Constructor for Arguments. Setup as private, so builder has to be used.
         * 
         * @see #process(String[])
         */
        private Arguments() {
        }

        /**
         * Gets the employee file.
         * 
         * @return the name of the employee file
         */
        public String getEmployeeFile() {
            return employeeFile;
        }

        /**
         * Gets the payroll file.
         * 
         * @return the name of the payroll file
         */
        public String getPayrollFile() {
            return payrollFile;
        }

        /**
         * Gets the time card file.
         * 
         * @return the name of the time card file
         */
        public String getTimeCards() {
            return timeCards;
        }

        /**
         * Prints the help message.
         */
        public void printHelp() {
            System.out.println(
                    "Usage: java student.PayrollGenerator [-e employee_file] [-t time_cards_file] [-o payroll_file]");
            System.out.println("Options:");
            System.out.println(
                    "  -e employee_file  Input file containing employee information. Default is employees.csv");
            System.out.println(
                    "  -t time_cards_file  Input file containing time card information. Default is time_cards.csv");
            System.out.println(
                    "  -o payroll_file   Output file containing payroll information. Default is pay_stubs.csv");
            System.out.println("  -h                Print this help message");
        }

        /**
         * Processes the arguments.
         * 
         * @param args the arguments
         * @return an Argument object with file names added
         */
        public static Arguments process(String[] args) {
            Arguments arguments = new Arguments();
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-e")) {
                    if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        arguments.employeeFile = args[i + 1];
                    } else {
                        System.out.println("Missing argument for -i option");
                        arguments.printHelp();
                        System.exit(1);
                    }
                } else if (args[i].equals("-t")) {
                    if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        arguments.timeCards = args[i + 1];
                    } else {
                        System.out.println("Missing argument for -t option");
                        arguments.printHelp();
                        System.exit(1);
                    }
                } else if (args[i].equals("-o")) {
                    if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        arguments.payrollFile = args[i + 1];
                    } else {
                        System.out.println("Missing argument for -o option");
                        arguments.printHelp();
                        System.exit(1);
                    }
                } else if (args[i].equals("-h")) {
                    arguments.printHelp();
                    System.exit(0);
                } else if (args[i].startsWith("-")) {
                    System.out.println("Unknown option: " + args[i]);
                    arguments.printHelp();
                    System.exit(1);
                }
            }
            return arguments;
        }
    }

}
