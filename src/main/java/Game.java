import java.util.Objects;
import java.util.Scanner;

public class Game extends GameLogic {
    private int playerOneScore;
    private int playerTwoScore;
    public boolean playGame;
    Scanner scannerInput = new Scanner(System.in);

    // constructor method
    public Game() {
        playerOneScore = 0;
        playerTwoScore = 0;
        playGame = true;
    }

    public void takeTurn(String player) {
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

    public void takeTurns() {
        takeTurn("playerOne");
        takeTurn("playerTwo");
    }

    public void getScores() {
        System.out.println("playerOne's score is " + playerOneScore);
        System.out.println("playerTwo's score is " + playerTwoScore);
    }

    public void addPoint(AbstractPlayer player) {
        if (player == playerOne) {
            playerOneScore++;
        } else {
            playerTwoScore++;
        }
    }

    public void evaluateMoves() {
        Move playerOneMove = playerOne.returnMove();
        Move playerTwoMove = playerTwo.returnMove();

        if (playerOneMove == playerTwoMove) {
            System.out.println("it's a draw!");
        } else if (playerOneMove == Move.ROCK && playerTwoMove == Move.SCISSORS || playerOneMove == Move.PAPER && playerTwoMove == Move.ROCK || playerOneMove == Move.SCISSORS && playerTwoMove == Move.PAPER) {
            System.out.println(playerOne.returnName() + " wins!");
            addPoint(playerOne);
        } else {
            System.out.println(playerTwo.returnName() + " wins!");
            addPoint(playerTwo);
        }
    }

    public String checkIfContinue() {
        System.out.println("Would you like to play again? y/n or r to restart");
        String inputPlayGame = scannerInput.nextLine().trim().toLowerCase();
        playGame = inputPlayGame.equals("y") || inputPlayGame.equals("yes");
        return inputPlayGame;
    }
}
