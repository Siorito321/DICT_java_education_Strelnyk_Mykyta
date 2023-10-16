package CoffeeMachine;
import java.util.Scanner;
public class CoffeeMachine {
    public static void main (String args[]){
        Resources resources = new Resources();
        while (true) {
            if (!menu(resources)) {
                break;
            };
        }
    }

//    static void basicCupCalc() {
//        System.out.print("Write how many cups you want: ");
//        Scanner scanner = new Scanner(System.in);
//        String nCups = scanner.nextLine();
//        int answer = Integer.parseInt(nCups);
//        System.out.println(String.format("For %d cups of coffee you will need ", answer));
//        System.out.println(String.format("%d ml of water", answer * 200));
//        System.out.println(String.format("%d ml of milk", answer * 50));
//        System.out.println(String.format("%d g of beans", answer * 15));
//    }

    static  boolean menu(Resources resources) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String answer = scanner.nextLine();
        switch (answer) {
            case "buy" -> buy(resources);
            case "fill" -> resources.fill();
            case "take" -> resources.take();
            case "exit" -> {
                return false;
            }
            case "remaining" -> resources.status();
            default -> System.out.println("Incorrect input!");
        }
        return true;
    }

    static void buy(Resources resources) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino or back to return to main menu:");
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                resources.espresso();
                System.out.println("I gave you Espresso");
                break;
            case "2":
                resources.latte();
                System.out.println("I gave you Latte");
                break;
            case "3":
                resources.cappuccino();
                System.out.println("I gave you Cappuccino");
                break;
            case "back":
                System.out.println("Operation interrupted");
                break;
            default:
                System.out.println("Incorrect input!");
                break;
        }
    }
}
