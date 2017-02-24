import java.util.Scanner;

/**
 * The main game logic.
 * 
 * @author Otakar Andrysek and Ping-Chun Chung
 * @version v1.1.1
 */

public class Game
{
    // Create board
    String[][] board = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
    int turn = 0;
    boolean gameOn = true;
    int whoPlayFirst = 0;

    public void startGame()
    {
        // Print pretty console start menu
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(" __          ________ _      _____ ____  __  __ ______   _______ ____  ");
        try{Thread.sleep(250);}catch(InterruptedException e){System.out.println(e);}
        System.out.println(" \\ \\        / /  ____| |    / ____/ __ \\|  \\/  |  ____| |__   __/ __ \\ ");
        try{Thread.sleep(250);}catch(InterruptedException e){System.out.println(e);}
        System.out.println("  \\ \\  /\\  / /| |__  | |   | |   | |  | | \\  / | |__       | | | |  | |");
        try{Thread.sleep(250);}catch(InterruptedException e){System.out.println(e);}
        System.out.println("   \\ \\/  \\/ / |  __| | |   | |   | |  | | |\\/| |  __|      | | | |  | |");
        try{Thread.sleep(250);}catch(InterruptedException e){System.out.println(e);}
        System.out.println("    \\  /\\  /  | |____| |___| |___| |__| | |  | | |____     | | | |__| |");
        try{Thread.sleep(250);}catch(InterruptedException e){System.out.println(e);}
        System.out.println("  ___\\/__\\/___|______|______\\_____\\____/|_|  |_|______|___ |_|__\\____/ ");
        try{Thread.sleep(250);}catch(InterruptedException e){System.out.println(e);}
        System.out.println(" |__   __|_   _/ ____| |__   __|/\\   / ____| |__   __/ __ \\|  ____|    ");
        try{Thread.sleep(250);}catch(InterruptedException e){System.out.println(e);}
        System.out.println("    | |    | || |   ______| |  /  \\ | |   ______| | | |  | | |__       ");
        try{Thread.sleep(250);}catch(InterruptedException e){System.out.println(e);}
        System.out.println("    | |    | || |  |______| | / /\\ \\| |  |______| | | |  | |  __|      ");
        try{Thread.sleep(250);}catch(InterruptedException e){System.out.println(e);}
        System.out.println("    | |   _| || |____     | |/ ____ \\ |____     | | | |__| | |____     ");
        try{Thread.sleep(250);}catch(InterruptedException e){System.out.println(e);}
        System.out.println("    |_|  |_____\\_____|    |_/_/    \\_\\_____|    |_|  \\____/|______|    ");;
        try{Thread.sleep(3000);}catch(InterruptedException e){System.out.println(e);}
    }

    /**
     * This method will print out the board to the players
     */
    public void printBoard(String[][] board)
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("                                 +-------+");
        for (int i = 0; i < board.length; i++) {
            System.out.print("                                 | ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("                                 +-------+\n\n\n\n");
    }

    /**
     * This method will act as a turn
     */
    public String[][] playerPlay(int y, int x, String player)
    {
        boolean legal = false;
        // Modify the board based off user entry
        board[y][x] = player;
        return board;
    }

    /**
     * This method check if the grid is empty
     */
    public boolean isLegal(int y, int x)
    {
        if (board[y][x] != "-")
        {
            //System.out.println("Invalid move!");
            return false;
        }
        else
        {
            return true;
        }
    }
    
    /**
     * This method return "X" or "O" win on which line
     */
    public int getWinningLine()
    {
        for(int i=0; i<3; i++)
        {
            if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals("-"))//3 rows
                return i+1;
            else if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals("-"))//3 columns
                return i+4;
        }
        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[1][1].equals("-"))// diagonal from top left to bottom right
            return 7;
        else if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[1][1].equals("-"))// diagonal from top right to bottom left
            return 8;
        else
            return 0;
    }

    /**
     * This method checks the board for any winning combinations or checks if the board is full
     */
    public int checkBoard(String[][] board, int turn)
    {
        // Win by row one
        if (board [0][0] == "X" && board [1][0] == "X" && board [2][0] == "X")
        {
            turn = 2;
        }
        else if (board [0][0] == "O" && board [1][0] == "O" && board [2][0] == "O")
        {
            turn = 3;
        }
        // Win by row two
        else if (board [0][1] == "X" && board [1][1] == "X" && board [2][1] == "X")
        {
            turn = 2;
        }
        else if (board [0][1] == "O" && board [1][1] == "O" && board [2][1] == "O")
        {
            turn = 3;
        }
        // Win by row three
        else if (board [0][2] == "X" && board [1][2] == "X" && board [2][2] == "X")
        {
            turn = 2;
        }
        else if (board [0][2] == "O" && board [1][2] == "O" && board [2][2] == "O")
        {
            turn = 3;
        }

        // Win by column one
        else if (board [0][0] == "X" && board [0][1] == "X" && board [0][2] == "X")
        {
            turn = 2;
        }
        else if (board [0][0] == "O" && board [0][1] == "O" && board [0][2] == "O")
        {
            turn = 3;
        }
        // Win by column two
        else if (board [1][0] == "X" && board [1][1] == "X" && board [1][2] == "X")
        {
            turn = 2;
        }
        else if (board [1][0] == "O" && board [1][1] == "O" && board [1][2] == "O")
        {
            turn = 3;
        }
        // Win by column three
        else if (board [2][0] == "X" && board [2][1] == "X" && board [2][2] == "X")
        {
            turn = 2;
        }
        else if (board [2][0] == "O" && board [2][1] == "O" && board [2][2] == "O")
        {
            turn = 3;
        }

        // Win by diagonal from top left to bottom right
        else if (board [0][0] == "X" && board [1][1] == "X" && board [2][2] == "X")
        {
            turn = 2;
        }
        else if (board [0][0] == "O" && board [1][1] == "O" && board [2][2] == "O")
        {
            turn = 3;
        }
        // Win by diagonal from top right to bottom left
        else if (board [0][2] == "X" && board [1][1] == "X" && board [2][0] == "X")
        {
            turn = 2;
        }
        else if (board [0][2] == "O" && board [1][1] == "O" && board [2][0] == "O")
        {
            turn = 3;
        }

        // There might be a tie game
        else
        {
            for (int j = 0; j<board[0].length; j++)
            {
                for (int i = 0; i<board.length; i++)
                {
                    if (board[i][j] == "-")
                    {
                        return turn;
                    }
                }
            }
            turn = 4;
        }
        return turn;
    }
    
    /**
     * This method cleans the board
     */
    public void resetGame()
    {
        for(int i=0; i<3; i++)
        {
            for(int n=0; n<3; n++)
            {
                board[i][n] = "-";
            }
        }
    }
    
    /**
     * This method decides who plays first in every game
     */
    public void SwitchWhoPlayFirst()
    {
        whoPlayFirst++;
        whoPlayFirst%=2;
    }
}
