package CreditCalculator;
import org.apache.commons.cli.*;
import java.util.Scanner;
public class Parser {
//    public void userConsoleInput() {
//        Options options = new Options();
//        options.addOption("t", false, "The type of payment: 'annuity' or 'diff'");
//        options.addOption("payment", false, "The monthly payment amount");
//        options.addOption("principal", false, "The loan principal amount");
//        options.addOption("periods", false, "The number of payments required to pay off the loan");
//        options.addOption("interest", false, "The annual interest rate");
//
//        CommandLineParser parser = new DefaultParser();
//
//        try {
//            CommandLine cmd = parser.parse(options, args);
//        } catch (ParseException e) {
//            System.err.println("Error parsing command line options: " + e.getMessage());
//        }
//    }
//    }

    public void userInput() {
        float[] answers = new float[5];
        //0 loan principal 1 monthly payment 2 n-of-payments(vary from context) 3 loan interest 4 annuity payment
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to calculate?");
        System.out.println("type \"m\" – for number of monthly payments,");
        System.out.println("type \"a\" – for the annuity monthly payment:");
        System.out.println("type \"p\" – for the loan principal:");
        char operation = scanner.nextLine().charAt(0);
        try {
            if (operation != 'm' && operation != 'a' && operation != 'p') {
                throw new Exception("Incorrect operation");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        try {
            if (operation == 'a' | operation == 'm') {
                System.out.println("Enter loan principle");
                answers[0] = Float.parseFloat(scanner.nextLine());
            }
            if (operation == 'p') {
                System.out.println("Enter the annuity payment:");
                answers[4] = Float.parseFloat(scanner.nextLine());
            }
            if (operation == 'a' | operation == 'p') {
                System.out.println("Enter the number of periods:");
                answers[2] = Float.parseFloat(scanner.nextLine());
            }
            if (operation == 'm') {
                System.out.println("Enter the monthly payment:");
                answers[1] = Float.parseFloat(scanner.nextLine());
            }
            System.out.println("Enter the loan interest:");
            answers[3] = Float.parseFloat(scanner.nextLine());
        } catch (NumberFormatException ex) {System.out.println("You should have entered numbers only, not gibberish!");}
        parserHandler(operation, answers);
    }

    public void parserHandler(char operation, float[] values) {
        Operations operations = new Operations();
        switch (operation) {
            case 'm' :
                operations.number_of_payments(values[0], values[1], values[3]);
                break;
            case 'a' :
                operations.annuity(values[3], values[2], values[0]);
                break;
            case 'p' :
                operations.principal(values[3], values[2], values[4]);
                break;
        }
    }
}

