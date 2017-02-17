import java.util.Scanner;

/**
 * Write a description of class game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * This method scans user input and passes it to the method that called it
     
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
     * This method will print out the board to the players
     */
    public static void printBoard(String[][] board)
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * This method will act as a turn for player one
     */
    public static String[][] player1Play(String[][] board)
    {
        // Do something
        
        System.out.println("Player 1 (X) it is your turn.");
        System.out.println("Enter a location (X,Y) to insert your symbol.");
        //x,y = scanInput();
        Scanner reader = new Scanner(System.in).useDelimiter("\\D");  
        System.out.println("The delimiter use is "+reader.delimiter());
        System.out.println("Enter a number followed by a comma and another number [X,Y]: ");
        int x = reader.nextInt(); // Scans the next token of the input as an int.
        int y = reader.nextInt(); // Scans the next token of the input as an int.
        System.out.println(x);
        System.out.println(y);
        reader.close();
        
        // Modify the board based off user entry
        board[x-1][y-1] = "X";
        
        return board;
    }
    
    /**
     * This method will act as a turn for player two
     */
    public static String[][] player2Play(String[][] board)
    {
        // Do something
        
        System.out.println("Player 2 (X) it is your turn.");
        System.out.println("Enter a location (X,Y) to insert your symbol.");
        //x,y = scanInput();
        Scanner reader = new Scanner(System.in).useDelimiter("\\D");  
        System.out.println("The delimiter use is "+reader.delimiter());
        System.out.println("Enter a number followed by a comma and another number [X,Y]: ");
        int x = reader.nextInt(); // Scans the next token of the input as an int.
        int y = reader.nextInt(); // Scans the next token of the input as an int.
        System.out.println(x);
        System.out.println(y);
        reader.close();
        
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
        // Do something
        return turn;
    }
    
    /**
     * An example of a method - replace this comment with your own
     */
    public static void main()
    {
        int turn = 0;
        boolean gameOn = true;
        String[][] board = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
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
        System.out.println("Error 1");
    }
}