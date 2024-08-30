package First;

import java.util.Scanner;

public class numberGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        printWelcomeMessage();

        int totalGuesses = getTotalGuesses(in);
        int secretNumber = generateSecretNumber();
        playGame(in, totalGuesses, secretNumber);

        in.close();
    }

    private static void printWelcomeMessage() {
        System.out.println("===================================");
        System.out.println("        Welcome to Number Game     ");
        System.out.println("===================================");
        System.out.println("Try to guess the number between 1 and 100!");
    }

    private static int getTotalGuesses(Scanner in) {
        System.out.print("Enter the number of guesses you want: ");
        return in.nextInt();
    }

    private static int generateSecretNumber() {
        double number = Math.random() * 100;
        return (int) number + 1; // Adding one Number Because what if Computer Genrate 0.somthing it will convert to zero that's why
    }

    private static void playGame(Scanner in, int totalGuesses, int secretNumber) {
        boolean hasWon = false;

        for (int i = 0; i < totalGuesses; i++) {
            System.out.println("\nGuess the number (Attempt " + (i + 1) + " of " + totalGuesses + "):");
            System.out.print("Your Guess: ");
            int userGuess = in.nextInt();

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number!");
                hasWon = true;
                break;
            } else {
                System.out.println("Incorrect Guess.");
                if (secretNumber > userGuess) {
                    System.out.println("Hint: The number is greater than " + userGuess);
                } else {
                    System.out.println("Hint: The number is smaller than " + userGuess);
                }
                System.out.println("Guesses left: " + (totalGuesses - i - 1));
            }
        }
       

        if (!hasWon) {
            System.out.println("\nSorry, you've run out of guesses. The correct number was: " + secretNumber);
        }

        System.out.println("===================================");
        System.out.println("          Game Over                ");
        System.out.println("===================================");
    }
}

