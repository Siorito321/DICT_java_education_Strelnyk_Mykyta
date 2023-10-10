package Hangman;
import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("The game will be available soon");
        String [] answers = {"python", "java", " javascript", "kotlin"};
        Random random = new Random();
        int select = random.nextInt(answers.length);
        String correctAnswer = answers[select];
        Scanner scanner = new Scanner(System.in);
        String tip = "";
        for (int i = 0; i < correctAnswer.length(); i++) {
            if (i < 2) {
                tip += correctAnswer.charAt(i);
            } else {
                tip += "-";
            }
        }
        System.out.println(String.format("Tip: the words is %s!", tip));
        System.out.print("Enter the word: ");
        String userAnswer = scanner.nextLine();
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Congratulations!");
        } else {
            while (!userAnswer.equals(correctAnswer)) {
                System.out.println("Wrong! Try again ");
                System.out.println(String.format("Tip: the words is %s!", tip));
                System.out.print("Enter the word: ");
                userAnswer = scanner.nextLine();
            }
            System.out.println("Congratulations!");
        }
    }
}
