package CoffeeMachine;

public class Resources {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int money = 550;
    private int cups = 9;
    public int row = 0;

    void fillAsk() {
        switch (row) {
            case 1:
                System.out.print("Write how many ml of water to add to the coffee machine: ");
                break;
            case 2:
                System.out.print("Write how many ml of milk to add to the coffee machine : ");
                break;
            case 3:
                System.out.print("Write how many g of beans to add to the coffee machine: ");
                break;
            case 4:
                System.out.print("Write how many cups to add to the coffee machine: ");
                break;
        }
    }

    void fill(String input) {
        int inputInt = Integer.parseInt(input);
        switch (row) {
            case 1 -> water += inputInt;
            case 2 -> milk += inputInt;
            case 3 -> beans += inputInt;
            case 4 -> cups += inputInt;
        }
        row += 1;
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

    private String notEnough(int a, int b, int c) {
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
