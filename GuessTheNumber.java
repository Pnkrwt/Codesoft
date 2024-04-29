package Codsoft;

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int attempts = 5;
        int score = 0;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Let's see if you can guess it.");

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            boolean guessedCorrectly = false;

            System.out.println("\nNew round! You have " + attempts + " attempts.");

            for (int attempt = 1; attempt <= attempts; attempt++) {
                System.out.print("Enter your guess (between " + minRange + " and " + maxRange + "): ");
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame over! Your score: " + score);
        scanner.close();
    }
}