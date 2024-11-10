import java.util.Scanner;

public class Task_1_NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetNumber;
        int userGuess;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            // Generating a random number between 1 and 100
            targetNumber = (int) (Math.random() * 100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("A number has been generated between 1 and 100...");

            // Running the loop until the user guesses the correct number
            while (!guessedCorrectly) {
                attempts++;
                System.out.print("Enter your guess: ");
                userGuess = sc.nextInt();

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                } else if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed it right in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            // Asking if the user wants to play again or not
            System.out.print("Press Y to continue or press any key to exit: ");
            String playAgain = sc.next();
            if (!playAgain.equalsIgnoreCase("Y")) {
                break;
            }
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        sc.close();
    }
}
