import java.util.Random;

public class ComputerPlayer extends AbstractPlayer {
    // stores the randomly picked move (0 for ROCK, 1 for PAPER, 2 for SCISSORS)
    private int randomMoveNumber = 0;

    // constructor that passes the player's name to its superclass (AbstractPlayer)
    public ComputerPlayer(String name) {
        super(name);
    }

    // implements the returnMove method to fulfill the contract of the Player interface
    @Override
    public Move returnMove() {
        switch (randomMoveNumber) {
            case 0:
                return Move.ROCK;
            case 1:
                return Move.PAPER;
            default:
                return Move.SCISSORS;
        }
    }

    // method to choose a random move by generating a random number between 0 and 2.
    public void chooseRandomMove() {
        Random rand = new Random();
        randomMoveNumber = rand.nextInt(3); // Generates 0, 1, or 2 randomly
    }
}