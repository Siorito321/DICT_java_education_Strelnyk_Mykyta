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
    }
}
