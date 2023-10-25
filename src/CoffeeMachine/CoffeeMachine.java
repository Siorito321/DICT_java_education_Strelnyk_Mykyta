package CoffeeMachine;
import java.util.Scanner;
public class CoffeeMachine {
    static int state = 1;
    /*1 - menu, 2 - buy, 3 - fill*/

    public static void main (String args[]){
        Resources resources = new Resources();
        while (true) {
            answerHandler(state, resources);
        }
    }

    static void menu(Resources resources, String answer) {
        switch (answer) {
            case "buy" -> state = 2;
            case "fill" -> state = 3;
            case "take" -> resources.take();
            case "exit" -> {
                System.exit(0);
            }
            case "remaining" -> resources.status();
            default -> System.out.println("Incorrect input!");
        }
    }

    static void buy(Resources resources, String answer) {
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

    static void answerHandler(int s, Resources resources) {
        Scanner scanner = new Scanner(System.in);
        String[] outputOptions = {"Write action (buy, fill, take, remaining, exit):",
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino or back to return to main menu:"};
        switch (s) {
            case 1:
                System.out.println(outputOptions[0]);
                break;
            case 2:
                System.out.println(outputOptions[1]);
                break;
            case 3:
                if (resources.row == 0) {
                    resources.row = 1;
                }
                resources.fillAsk();
                break;
        }
        String answer = scanner.nextLine();

        switch (s) {
            case 1:
                menu(resources, answer);
                break;
            case 2:
                buy(resources, answer);
                state = 1;
                break;
            case 3:
                resources.fill(answer);
                if (resources.row > 4) {
                    resources.row = 0;
                    state = 1;
                }
                break;
        }
    }
}
