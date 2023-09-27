package ChatBot;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is SomeBot");
        System.out.println("I was created in 2023");
        System.out.println("Please remind me your name.");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        System.out.println(String.format("What a great name you have, %s!", answer));
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();
        int age = (num1 * 70 + num2 * 21 + num3 * 15) % 105;
        System.out.println(String.format("Your age is %d!", age));
        System.out.println("Now I will prove to you that I can count to any number you want!");
        int GNumber = in.nextInt();;
        for (int i = 1; i <= GNumber; i++) {
            System.out.println(String.format("\"%d!\"", i));
        }
        System.out.println("Now answer my question. How many letters in word \"Java\"?");
        for (int i = 1; i <= 4; i++) {
            System.out.println(String.format("%d. %d", i, i));
        }
        int i = in.nextInt();;
        while (i != 4) {
            System.out.println("Incorrect");
            i = in.nextInt();
        }
        System.out.println("Correct!");
        System.out.println("Good bye, have a nice day!");
    }
}
