import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // create a Scanner to read input from the user
        Scanner scannerInput = new Scanner(System.in);

        // outer loop to restart the entire game when needed
        while (true) {
            boolean playGame = true;
            System.out.println("Welcome to Rock, Scissors, Paper!");

            // initialise player objects for the game
            GameLogic.createPlayerOne();
            GameLogic.createPlayerTwo();

            // inner loop to control the gameplay for multiple rounds
            while (playGame) {
                // Each player takes their turn
                GameLogic.takeTurn("playerOne");
                GameLogic.takeTurn("playerTwo");

                // display both players' moves and determine the outcome of the round
                GameLogic.showPlayerMoves();
                GameLogic.showOutcome();

                // ask the user if they want to play again or restart the game
                System.out.println("Would you like to play again? y/n or r to restart");
                String inputPlayGame = scannerInput.nextLine().trim().toLowerCase();

                // continue playing if the user chooses 'y' or 'yes'
                playGame = inputPlayGame.equals("y") || inputPlayGame.equals("yes");

                // restart the game if the user chooses 'r' or 'restart'
                if (inputPlayGame.equals("r") || inputPlayGame.equals("restart")) {
                    break; // Break out of the inner loop to restart the game
                }
                // exit the game if the user chooses anything other than 'y' or 'yes'
                else if (!playGame) {
                    System.out.println("Thanks for playing!");
                    return; // exit the program entirely
                }
            }
        }
    }
}