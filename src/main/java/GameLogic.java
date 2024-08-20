import java.util.Objects;
import java.util.Scanner;

public class GameLogic {
    public static AbstractPlayer playerOne;
    public static AbstractPlayer playerTwo;

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

    public static void takeTurn(String player) {
        Scanner scannerInput = new Scanner(System.in);

        if (Objects.equals(player, "playerOne")) {
            if (playerOne instanceof HumanPlayer) {
                System.out.println(playerOne.returnName() + " it's your turn!");
                System.out.println("Choose your move ('rock', 'scissors', or 'paper'): ");
                String playerMove = scannerInput.nextLine();
                ((HumanPlayer) playerOne).setMove(playerMove);
            } else if (playerOne instanceof ComputerPlayer) {
                ((ComputerPlayer) playerOne).chooseRandomMove();
            }
        } else if (Objects.equals(player, "playerTwo")) {
            if (playerTwo instanceof HumanPlayer) {
                System.out.println(playerTwo.returnName() + " it's your turn!");
                System.out.println("Choose your move ('rock', 'scissors', or 'paper'): ");
                String playerMove = scannerInput.nextLine();
                ((HumanPlayer) playerTwo).setMove(playerMove);
            } else if (playerTwo instanceof ComputerPlayer) {
                ((ComputerPlayer) playerTwo).chooseRandomMove();
            }
        }
    }

    public static void showPlayerMoves() {
        System.out.println(playerOne.returnName() + " chose to use " + playerOne.returnMove());
        System.out.println(playerTwo.returnName() + " chose to use " + playerTwo.returnMove());
    }

    public static void showOutcome() {
        Move playerOneMove = playerOne.returnMove();
        Move playerTwoMove = playerTwo.returnMove();

        if (playerOneMove == playerTwoMove) {
            System.out.println("it's a draw!");
        } else if (playerOneMove == Move.ROCK && playerTwoMove == Move.SCISSORS || playerOneMove == Move.PAPER && playerTwoMove == Move.ROCK || playerOneMove == Move.SCISSORS && playerTwoMove == Move.PAPER) {
            System.out.println(playerOne.returnName() + " wins!");
        } else {
            System.out.println(playerTwo.returnName() + " wins!");
        }
    }
}
