package Hangman;
import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("The game will be available soon");
        String [] answers = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String state = "play";
        while (!state.equals("exit")) {
            int select = random.nextInt(answers.length);
            String correctAnswer = answers[select];
            Scanner scanner = new Scanner(System.in);
            int lives = 8;
            String line = "";
            for (int i = 0; i < correctAnswer.length(); i++) {
                line += "-";
            }
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: ");
            state = scanner.nextLine();
            if (state.equals("exit")) {
                continue;
            } else if (!state.equals("play")) {
                System.out.println("Unrecognized command, repeat please");
                continue;
            }
            while (lives > 0) {
                System.out.println(String.format("The word is %s!", line));
                if (!line.contains("-")) {
                    System.out.println("Congratulations! You won!");
                    break;
                }
                System.out.println(String.format("You currently have %s lives!", lives));
                System.out.print("Enter the letter: ");
                String userAnswer = scanner.nextLine();
                if (userAnswer.length() > 1 | userAnswer.isEmpty()) {
                    System.out.println("Sorry, your answer should contain only one letter! Try again");
                    continue;
                }
                char userChar = userAnswer.charAt(0);
                if (Character.isUpperCase(userChar)) {
                    System.out.println("Sorry, your answer should contain only lower case letter! Try again");
                    continue;
                }
                if (line.contains(String.valueOf(userChar))) {
                    System.out.println("Sorry,You have already found this letter. Try again");
                    continue;
                }
                if (!correctAnswer.contains(String.valueOf(userChar))) {
                    String[] insults = {
                            "Such a loser you are!",
                            "Such a disappointment you are.",
                            "Such a mess you are.",
                            "How pathetic you are.",
                            "Such a bore you are.",
                            "Such a joke you are.",
                            "Such a failure you are.",
                            "Such a hopeless case you are.",
                            "Such a letdown you are."
                    };
                    int new_select = random.nextInt(insults.length);
                    System.out.println(String.format("Sorry, your answer is wrong. %s Try again", insults[new_select]));
                    lives--;
                    continue;
                } else {
                    System.out.println("Good work, here`s an updated word for ya:");
                    String subLine = "";
                    for (int i = 0; i < correctAnswer.length(); i++) {
                        if (correctAnswer.charAt(i) == userChar) {
                            subLine += userChar;
                        } else if (line.charAt(i) != '-') {
                            subLine += line.charAt(i);
                        } else {
                            subLine += "-";
                        }
                    }
                    line = subLine;
                }
            }
            if (lives == 0) {
                System.out.println("Oh, wait. Looks like you can`t. Wanna try from the start?");
            }
        }
        System.out.println("Thanks for playing!");
    }
}
