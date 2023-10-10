package Hangman;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("The game will be available soon");
        String correctAnswer = "java";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String userAnswer = scanner.nextLine();
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Congratulations!");
        } else {
            while (!userAnswer.equals(correctAnswer)) {
                System.out.println("Wrong! Try again ");
                System.out.print("Enter the word: ");
                userAnswer = scanner.nextLine();
            }
            System.out.println("Congratulations!");
        }
    }
}
