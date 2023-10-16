package CoffeeMachine;
import java.util.Scanner;

public class IngredientStatus {
    int water;
    int milk;
    int beans;

    void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many ml of water the coffee machine has: ");
        String waterS = scanner.nextLine();
        System.out.print("Write how many ml of milk the coffee machine has: ");
        String milkS = scanner.nextLine();
        System.out.print("Write how many g of beans the coffee machine has: ");
        String beansS = scanner.nextLine();
        water = Integer.parseInt(waterS);
        milk = Integer.parseInt(milkS);
        beans = Integer.parseInt(beansS);
    }

    void possibleCups() {
        int[] resourcesForMoment = {water, milk, beans};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many cups of coffee you want: ");
        String nCupsS = scanner.nextLine();
        int nCups = Integer.parseInt(nCupsS);
        int availableCups = 0;
        while ((water - 200) >= 0 && (milk - 50) >= 0 && (beans - 15) >= 0) {
            availableCups ++;
            water -= 200;
            milk -= 50;
            beans -= 15;
        }
        if (availableCups == nCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (availableCups < nCups) {
            System.out.println(String.format("No, I can make only %d cups of coffee ", availableCups));
        } else {
            System.out.println(String.format("Yes, I can make that amount of coffee (and even %d more than that) ",
                    availableCups - nCups));
        }
        water = resourcesForMoment[0];
        milk = resourcesForMoment[1];
        beans = resourcesForMoment[2];
    }
}
