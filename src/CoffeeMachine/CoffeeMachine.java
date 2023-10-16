package CoffeeMachine;
import java.util.Scanner;
public class CoffeeMachine {
    public static void main (String args[]){
        while (true) {
            menu();
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

    static  void menu() {
        Resources resources = new Resources();
        resources.status();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take):");
        String answer = scanner.nextLine();
        switch (answer) {
            case "buy" -> buy(resources);
            case "fill" -> resources.fill();
            case "take" -> resources.take();
            default -> System.out.println("Incorrect input!");
        }
    }

    static void buy(Resources resources) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int answer = Integer.parseInt(scanner.nextLine());
        switch (answer) {
            case 1:
                resources.espresso();
                break;
            case 2:
                resources.latte();
                break;
            case 3:
                resources.cappuccino();
                break;
            default:
                System.out.println("Incorrect input!");
        }
    }
}
