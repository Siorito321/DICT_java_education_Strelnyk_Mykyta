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
        Operations operations = new Operations();
        Scanner scanner = new Scanner(System.in);
        int principal = 0;
        System.out.println("Enter the loan principal:");
        try {principal = Integer.parseInt(scanner.nextLine());}
        catch (NumberFormatException n) {
            System.out.println("It should be a number!");
            System.exit(1);
        }
        System.out.println("What do you want to calculate?");
        System.out.println("type \"m\" – for number of monthly payments,");
        System.out.println("type \"p\" – for the monthly payment:");
        char operation = scanner.nextLine().charAt(0);
        try {
            if (operation != 'm' && operation != 'p') {
                throw new Exception("Incorrect operation");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        switch (operation) {
            case 'p' :
                System.out.println("Enter the monthly payment:");
                float months = scanner.nextFloat();
                System.out.println("The monthly payment is " + operations.payments(months, (float)principal));
            case 'm' :
                System.out.println("Enter the monthly payment:");
                float payment = scanner.nextFloat();
                operations.number_of_payments((float)principal,payment);
        }
    }
}

