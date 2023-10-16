package CoffeeMachine;
import java.util.Scanner;
public class CoffeeMachine {
    public static void main (String args[]){
        IngredientStatus ingredients = new IngredientStatus();
        ingredients.fill();
        ingredients.possibleCups();
    }

    static void basicCupCalc() {
        System.out.print("Write how many cups you want: ");
        Scanner scanner = new Scanner(System.in);
        String nCups = scanner.nextLine();
        int answer = Integer.parseInt(nCups);
        System.out.println(String.format("For %d cups of coffee you will need ", answer));
        System.out.println(String.format("%d ml of water", answer * 200));
        System.out.println(String.format("%d ml of milk", answer * 50));
        System.out.println(String.format("%d g of beans", answer * 15));
    }
}
