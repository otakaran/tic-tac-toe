import java.util.Scanner;

/**
 * Write a description of class game here.
 * 
 * @author Otakar Andrysek
 * @version 1.0
 */
public class game
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class game
     */
    public game()
    {
        // initialise instance variables
    }

    /**
     * This method is broken becuase I do not know how to pass more than one variable outside 
     * of this method back to the method that called it :(
     
    public static int scanInput()
    {
        // Reading from System.in
        Scanner reader = new Scanner(System.in).useDelimiter("\\D");  
        System.out.println("The delimiter use is "+reader.delimiter());
        System.out.println("Enter a number followed by a comma and another number [X,Y]: ");
        int x = reader.nextInt(); // Scans the next token of the input as an int.
        int y = reader.nextInt(); // Scans the next token of the input as an int.
        System.out.println(x);
        System.out.println(y);
        reader.close();
        return x,y;
    }
    */
    
    /**
     * This method declares that player two is the winner and ends the game
     */
    public static void startGame()
    {
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
    public static void printBoard(String[][] board)
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
     * This method will act as a turn for player one
     */
    public static String[][] player1Play(String[][] board)
    {
        boolean legal = false;
        int x = 0;
        int y = 0;
        System.out.println("Player 1 (X) it is your turn.");
        //x,y = scanInput(); TODO
        while (legal == false)
        {
            Scanner reader = new Scanner(System.in).useDelimiter("\\D");  
            System.out.println("Enter a number followed by a comma and another number [X,Y]: ");
            x = reader.nextInt(); // Scans the next token of the input as an int.
            y = reader.nextInt(); // Scans the next token of the input as an int.
            reader.close();
            if (board[x-1][y-1] == "O")
            {
                legal = false;
                System.out.println("Invalid move!");
            }
            else
            {
                legal = true;
            }
        }
        
        // Modify the board based off user entry
        board[x-1][y-1] = "X";
        return board;
    }
    
    /**
     * This method will act as a turn for player two
     */
    public static String[][] player2Play(String[][] board)
    {
        boolean legal = false;
        int x = 0;
        int y = 0;
        System.out.println("Player 2 (O) it is your turn.");
        //x,y = scanInput(); TODO
        while (legal == false)
        {
            Scanner reader = new Scanner(System.in).useDelimiter("\\D");  
            System.out.println("Enter a number followed by a comma and another number [X,Y]: ");
            x = reader.nextInt(); // Scans the next token of the input as an int.
            y = reader.nextInt(); // Scans the next token of the input as an int.
            reader.close();
            if (board[x-1][y-1] == "X")
            {
                legal = false;
                System.out.println("Invalid move!");
            }
            else
            {
                legal = true;
            }
        }
        
        // Modify the board based off user entry
        board[x-1][y-1] = "O";
        return board;
    }
    
    /**
     * This method declares that player one is the winner and ends the game
     */
    public static boolean player1Win(boolean gameOn)
    {
        System.out.println();
        System.out.println("Congratulations! Player 1 won the game.");
        gameOn = false;
        return gameOn;
    }
    
    /**
     * This method declares that player two is the winner and ends the game
     */
    public static boolean player2Win(boolean gameOn)
    {
        System.out.println();
        System.out.println("Congratulations! Player 2 won the game.");
        gameOn = false;
        return gameOn;
    }
    
    /**
     * This method declares that there is a tie game and ends the game
     */
    public static boolean tiedGame(boolean gameOn)
    {
        System.out.println();
        System.out.println("Looks like there was a tie. Play again?");
        gameOn = false;
        return gameOn;
    }
    
    /**
     * This method checks the board for any winning combinations or checks if the board is full
     */
    public static int checkBoard(String[][] board, int turn)
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
     * An example of a method - replace this comment with your own
     */
    public static void main()
    {
        startGame(); // WIP
        int turn = 0;
        boolean gameOn = true;
        // Create board
        String[][] board = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        
        // Run segments based on player turn
        while (turn <= 4 && gameOn == true)
        {
            printBoard(board);
            if (turn == 0)
            {
                // Player "X" will go
                board = player1Play(board);
                turn ++;
            }
            else if (turn == 1)
            {
                // Player "O" will go
                board = player2Play(board);
                turn --;
            }
            else if (turn == 2)
            {
                // Player "X" wins
                gameOn = player1Win(gameOn);
            }
            else if (turn == 3)
            {
                // Player "O" wins
                gameOn = player2Win(gameOn);
            }
            else if (turn == 4)
            {
                // There is a tie
                gameOn = tiedGame(gameOn);
            }
            turn = checkBoard(board, turn);
        }
        // Todo: Loop game?
    }
}