public class Main {

    public static void main(String[] args) {
        // outer loop to restart the entire game when needed
        while (true) {
            // welcome message
            GameLogic.welcomeMessage();
            // set up new game
            Game game = new Game();
            GameLogic.createPlayers();

            // inner loop to control the gameplay for multiple rounds
            while (game.playGame) {
                // each player takes their turn
                game.takeTurns();
                GameLogic.showPlayerMoves();

                //check who won the round and display total scores
                game.evaluateMoves();
                game.getScores();

                // ask the user if they want to play again or restart the game
                String gameContinue = game.checkIfContinue();
                if (gameContinue.equals("r") || gameContinue.equals("restart")) {
                    break; // break out of the inner loop to restart the game
                }
                // exit the game if the user chooses anything other than 'y' or 'yes'
                else if (!game.playGame) {
                    GameLogic.goodbyeMessage();
                    return; // exit the program entirely
                }
            }
        }
    }
}