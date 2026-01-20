package Task1_NumberGame;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        boolean playAgain = true;

        System.out.println("WELCOME TO THE NUMBER GAME");

        while (playAgain) {

            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 6;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + "attempts.");

            while (attempts < maxAttempts) {
                System.out.println("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You have guessed the number.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }
            }
            if (!guessedCorrectly) {
                System.out.println("You've used all attempts.");
                System.out.println("the correct number was:" + numberToGuess);
            }

            System.out.println("Your current score:" + score);

            System.out.println("Do you want to play again? (yes/no):");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("Yes")) {
                playAgain = false;
            }
        }
        System.out.println("\n Game Over! Final Score:" + score);
        sc.close();
    }
}
