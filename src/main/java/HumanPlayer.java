public class HumanPlayer extends AbstractPlayer {
    // field to store the player's current move. default is ROCK.
    private Move playerMove = Move.ROCK;

    // constructor that passes the player's name to its superclass (AbstractPlayer)
    public HumanPlayer(String name) {
        super(name);
    }

    // implements the returnMove method to fulfill the contract of the Player interface,
    @Override
    public Move returnMove() {
        return playerMove;
    }

    // method to set the player's move based on the input string
    public void setMove(String move) {
        switch (move.toLowerCase()) {
            case "rock":
                playerMove = Move.ROCK;
                break;
            case "paper":
                playerMove = Move.PAPER;
                break;
            case "scissors":
                playerMove = Move.SCISSORS;
                break;
            default:
                System.out.println("Invalid entry. Defaulting to ROCK.");
                playerMove = Move.ROCK;
                break;
        }
    }
}
