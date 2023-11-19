import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    private final int MAX_ATTEMPTS = 4;
    private final int MAX_ROUNDS = 3;

    private int randomNumber;
    private boolean isMatch;

    public NumberGuessing() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
        isMatch = false;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("!!!!!!!!!! OASIS INFOBYTE TASK2 !!!!!!!!!!!");
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a number between 1 and 100.\nYou have 3 rounds to guess it, each with 4 attempts.");

        int totalScore = 0;

        for (int round = 1; round <= MAX_ROUNDS && !isMatch; round++) {
            System.out.println("\nRound " + round + " Begins Enjoy!!");
            int attempts = 0;

            while (attempts < MAX_ATTEMPTS && !isMatch) {
                System.out.print("Enter your guess (between 1 and 100): ");
                if (scanner.hasNextInt()) {
                    int inputNumber = scanner.nextInt();
                    if (isValidGuess(inputNumber)) {
                        attempts++;
                        processGuess(inputNumber);
                    } else {
                        System.out.println("Please enter a valid guess between 1 and 100.");
                    }
                } else {
                    System.out.println("Please enter a valid integer.");
                    scanner.next(); // Consume the invalid input
                }
            }

            if (isMatch) {
                int roundScore = MAX_ATTEMPTS - attempts + 1;
                totalScore += roundScore;
            } else {
                System.out.println("Sorry! You've reached the maximum number of attempts for this round.");
            }
        }


        if (isMatch) {
            System.out.println("Congratulations! You've guessed the correct number." +
                    "\nYour total score is: " + totalScore);
        } else {
            System.out.println("Game Over! You've completed all rounds. Better luck next time!");
        }

        scanner.close();
    }

    private void processGuess(int inputNumber) {
        if (inputNumber > randomNumber) {
            System.out.println("Too high! Try again.");
        } else if (inputNumber < randomNumber) {
            System.out.println("Too low! Try again.");
        } else {
            isMatch = true;
        }
    }

    private boolean isValidGuess(int guess) {
        return guess >= 1 && guess <= 100;
    }
}
