import java.util.Objects;
import java.util.Scanner;

public class GameLogic {
    public static AbstractPlayer playerOne;
    public static AbstractPlayer playerTwo;


    public static void createPlayers() {
        createPlayerOne();
        createPlayerTwo();
    }

    public static void createPlayerOne() {
        Scanner scannerInput = new Scanner(System.in);
        // ask if player one is human
        System.out.println("Is player one human? (y/n)");
        String inputIsHuman = scannerInput.nextLine();

        // evaluate whether player two is human based on input given by user
        inputIsHuman = inputIsHuman.trim().toLowerCase();
        boolean isHuman = inputIsHuman.equals("y") || inputIsHuman.equals("yes");

        if (isHuman) {
            // ask for the player's name
            System.out.println("Enter player one's name: ");
            String userName = scannerInput.nextLine();
            // create a HumanPlayer object with userName given by user
            playerOne = new HumanPlayer(userName);
        } else {
            // create a ComputerPlayer object (default name is computer)
            playerOne = new ComputerPlayer("computer");
        }

    }

    public static void createPlayerTwo() {
        Scanner scannerInput = new Scanner(System.in);

        // ask if player two is human
        System.out.println("Is player two human? (y/n)");
        String inputIsHuman = scannerInput.nextLine();

        // evaluate whether player two is human based on input given by user
        inputIsHuman = inputIsHuman.trim().toLowerCase();
        boolean isHuman = inputIsHuman.equals("y") || inputIsHuman.equals("yes");

        if (isHuman) {
            // ask for the player's name
            System.out.println("Enter player two's name: ");
            String userName = scannerInput.nextLine();
            // create a HumanPlayer object with userName given by user
            playerTwo = new HumanPlayer(userName);
        } else {
            // create a ComputerPlayer object (default name is computer)
            playerTwo = new ComputerPlayer("computer");
        }
    }

    public static void showPlayerMoves() {
        System.out.println(playerOne.returnName() + " chose to use " + playerOne.returnMove());
        System.out.println(playerTwo.returnName() + " chose to use " + playerTwo.returnMove());
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to Rock, Scissors, Paper!");
    }

    public static void goodbyeMessage() {
        System.out.println("Thanks for playing!");
    }

}
