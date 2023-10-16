package CoffeeMachine;
import java.util.Scanner;

public class Resources {
    public static int water = 400;
    public static int milk = 540;
    public static int beans = 120;
    public static int money = 550;
    public static int cups = 9;

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

    void status() {
        System.out.print("The coffee machine has: ");
        System.out.println(String.format("%d ml of water", water));
        System.out.println(String.format("%d ml of milk", milk));
        System.out.println(String.format("%d g of beans", beans));
        System.out.println(String.format("%d cups", cups));
        System.out.println(String.format("%d grn of money", money));
    }

    void take() {
        System.out.println("I gave you " + money + " grn");
        money = 0;
    }

    void espresso() {
        if ((water - 250) >= 0 && (beans - 16) >= 0) {
            water -= 250;
            beans -= 16;
            cups -= 1;
            money += 4;
        } else {
            System.out.println("Sorry, not enough " + notEnough(250, 0, 16));
        }
    }

    void latte() {
        if ((water - 350) >= 0 && (milk - 75) >= 0 && (beans - 20) >= 0) {
            water -= 350;
            milk -= 75;
            beans -= 20;
            cups -= 1;
            money += 7;
        } else {
            System.out.println("Sorry, not enough " + notEnough(200, 100, 12));
        }
    }

    void cappuccino() {
        if ((water - 200) >= 0 && (milk - 100) >= 0 && (beans - 12) >= 0) {
            water -= 200;
            milk -= 100;
            beans -= 12;
            cups -= 1;
            money += 6;
        } else {
            System.out.println("Sorry, not enough " + notEnough(200, 100, 12));
        }
    }

    String notEnough(int a, int b, int c) {
        if ((water - a) < 0) {
            return "water";
        } else if ((milk - b) < 0) {
            return "milk";
        } else if ((beans - c) < 0) {
            return "beans";
        } else {
            return "cups";
        }
    }
}
