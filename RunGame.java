/**
 * This class prepares and executes the game itself.
 * 
 * @author Ping-Chun Chung and Otakar Andrysek
 * @version v1.0.1
 */

public class RunGame
{
    // Instance variables
    Game game;
    GUI gui;
    Ai ai;
    boolean gameOn = true;
    public RunGame()
    {
        game = new Game();
        gui = new GUI(game);
        ai = new Ai();
        playGame();
    }
    
    
    public void playGame()
    {
        while(gameOn)
        {
            // Print the board
            if (gui.playGame){
                if (game.turn == 0)
                {
                    // Player "X" will go
                    gui.setGameBackground("X");
                }
                else if (game.turn == 1)
                {
                    // Player "O" will go  
                    gui.setGameBackground("O");
                    if (gui.vsCom)
                    {
                        int[] aiMove = ai.getMove(game.board,game.whoPlayFirst);
                        game.playerPlay(aiMove[0],aiMove[1],"O");
                        game.turn--;
                    }
                }
                else if (game.turn == 2)
                {
                    // Player "X" wins
                    gui.xScore++;
                    gui.xScoreLabel.setText(Integer.toString(gui.xScore));
                    gui.winningLine(game.getWinningLine());
                    try{Thread.sleep(1200);}catch(InterruptedException e){System.out.println(e);}
                    gui.displayWinScreen("X");
                    gui.playGame = false;
                }
                else if (game.turn == 3)
                {
                    // Player "O" wins
                    gui.oScore++;
                    gui.oScoreLabel.setText(Integer.toString(gui.oScore));
                    gui.winningLine(game.getWinningLine());
                    try{Thread.sleep(1200);}catch(InterruptedException e){System.out.println(e);}
                    gui.displayWinScreen("O");
                    gui.playGame = false;
                }
                else if (game.turn == 4)
                {
                    // There is a tie
                    try{Thread.sleep(1200);}catch(InterruptedException e){System.out.println(e);}
                    gui.displayWinScreen("tie");
                    gui.playGame = false;
                }
                game.turn = game.checkBoard(game.board, game.turn);
                gui.updataButtonIma();
            }
        }
    }

    // Main function
    public static void main(String[] args)
    {
        new RunGame();
    }
}
