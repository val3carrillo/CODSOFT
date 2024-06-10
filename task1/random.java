package task1;
import java.util.Random;
import java.util.Scanner;

/* 1. Generate a random number within a specified range, such as 1 to 100.

   2. Prompt the user to enter their guess for the generated number.

   3. Compare the user's guess with the generated number and provide feedback 
   on whether the guess is correct, too high, or too low.

   4. Repeat steps 2 and 3 until the user guesses the correct number.

   5. Limit the number of attempts the user has to guess the number.
   6. Add the option for multiple rounds, allowing the user to play again.
   7. Display the user's score, which can be based on the number of 
   attempts taken or rounds won.
*/
public class random{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        // max number of tries
        int maxAttemps = 10;
        int roundsWon = 0;
        boolean playAgain = true;
       

        while(playAgain){
            // Generate a random number between 1 and 100
            int randomNumber = rand.nextInt(100) + 1;
            int userGuess = 0; // need it to compare to randomNum
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess number between 1 and 100! ");

           // while u still have attempts left and u havent guessed correct
            while(attempts < maxAttemps && !guessedCorrectly){
                // Prompt the user to enter their guess
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + " of " + maxAttemps + "): ");
                userGuess = scanner.nextInt();
                attempts++; // increase number of attempts

                // Provide feedback on the user's guess
                if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                    guessedCorrectly = true;
                    roundsWon++;  // increment rounds won
                }
            }
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }
            
            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            // if user response equals yes then playAgain is true if it doesnt its false
            playAgain = response.equalsIgnoreCase("yes"); 
        }

        // outside of while loop
        System.out.println("Thank you for playing! Total rounds won: " + roundsWon);
        scanner.close();
    }
}