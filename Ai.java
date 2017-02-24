import java.util.*;

/**
 * The main AI for tic-tac-toe. Attempts to win my getting three in a row.
 * 
 * @author Ping-Chun Chung and Otakar Andrysek
 * @version v1.0.1
 */

public class Ai
{
    // Generate a line to win
    public String[] createLineArr(String[][] b)
    {
        String[] arr = new String[8]; 
        for(int i=0; i<3; i++)
        {
            arr[i] = b[i][0]+b[i][1]+b[i][2];
            arr[i+3] = b[0][i]+b[1][i]+b[2][i];
        }
        arr[6] = b[0][0]+b[1][1]+b[2][2];
        arr[7] = b[0][2]+b[1][1]+b[2][0];

        return arr;
    }

    // Find the next location to place symbol
    public int[] absLocation(String[][] b)
    {
        String[] arr = new String[8];
        int[] move = new int[2];
        for(int i=0; i<8; i++)
        {
            arr[i] = createLineArr(b)[i];

            if (countLetter(arr[i],"O") ==2 && countLetter(arr[i],"-")==1)
            {                
                if (i<=2)
                {
                    move[0] = i;
                    move[1] = arr[i].indexOf("-");
                    return move;
                }
                else if (i<=5)
                {
                    move[0] = arr[i].indexOf("-");
                    move[1] = i-3;
                    return move;
                }
                else if (i==6)
                {
                    move[0] = arr[i].indexOf("-");
                    move[1] = arr[i].indexOf("-");
                    return move;
                }
                else if (i==7)
                {
                    move[0] = arr[i].indexOf("-");
                    move[1] = 2 - move[0];
                    return move;
                }
            }

        }
        return null;
    }

    // Calculated out the next move
    public int calculatePoint(String[][] b, int firstPlay)
    {
        String[] arr = new String[8]; 

        int totalPoint = 0;
        for(int i=0; i<8; i++)
        {
            arr[i] = createLineArr(b)[i];

            int x,o,e,point;
            x = countLetter(arr[i],"X");
            o = countLetter(arr[i],"O");
            e = countLetter(arr[i],"-");

            if (o == 3){
                point = 500;
            }
            else if (o == 2 & x == 0){
                point = 10;
            }
            else if (o == 1 && x == 0){
                point = 1;
            }
            else if (x == 3){
                point = -100;
            }
            else if (x == 2 && o == 0){
                point = -50;
            }
            else if (x == 1 && o == 0){
                point = -3;
            }
            else {
                point = 0;
            }
            totalPoint+=point;
        }
        return totalPoint;
    }

    // Different logic for when game is nearing its end
    public boolean almostLose(String[][] b, int y, int x)
    {
        String[] arr = new String[8];
        String[][] newB = new String[3][3];
        for (int i=0; i<3; i++)
        {
            for (int n=0; n<3; n++)
            {
                newB[i][n] = b[i][n];
            }
        }
        newB[y][x] = "A";
        for(int i=0; i<8; i++)
        {
            arr[i] = createLineArr(newB)[i];
            if (countLetter(arr[i],"X") == 2 && countLetter(arr[i],"A") == 1)
                return true;
        }
        return false;
    }

    public int countLetter(String str, String letter)
    {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            if (str.substring(i,i+1).equals(letter))
                counter++;
        }
        return counter;
    }

    public int[] getMove(String[][] b, int firstPlay)
    {
        int maxPoint = -9999;
        int point;
        int newPoint;
        int[] move = new int[2];
        boolean boardEmpty = true;
        String[][] newBoard = new String[3][3];
        for (int i=0; i<3; i++)
        {
            for (int n=0; n<3; n++)
            {
                for (int ii=0; ii<3; ii++)
                {
                    for (int nn=0; nn<3; nn++)
                    {   
                        newBoard[ii][nn] = b[ii][nn];
                        if (!b[ii][nn].equals("-"))
                            boardEmpty = false;
                    }
                }

                if (newBoard[i][n].equals("-"))
                {
                    newBoard[i][n] = "O";
                    point = calculatePoint(newBoard, firstPlay);

                    if (absLocation(newBoard) != null)
                    {
                        String[][] newNewBoard = new String[3][3];
                        int y,x;
                        for (int ii=0; ii<3; ii++)
                        {
                            for (int nn=0; nn<3; nn++)
                            {   
                                newNewBoard[ii][nn] = newBoard[ii][nn];
                            }
                        }
                        y = absLocation(newBoard)[0];
                        x = absLocation(newBoard)[1];
                        newNewBoard[y][x] = "X";
                        newPoint = calculatePoint(newNewBoard, firstPlay);
                        if (newPoint < point && newPoint < -30)
                            point = newPoint;
                    }                   
                    
                    if (almostLose(newBoard,i,n))
                        point = 300;
                        
                    if (point > maxPoint)
                    {
                        maxPoint = point;
                        move[0] = i;
                        move[1] = n;
                    }
                }
                try{Thread.sleep(50);}catch(InterruptedException e){System.out.println(e);}
            }
        }
        
        // We have nothing to work off of, let's just be random
        if (boardEmpty)
        {
            move[0]=(int)(Math.random()*3);
            move[1]=(int)(Math.random()*3);
        }
        return move;
    }
}
