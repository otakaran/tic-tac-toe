import java.util.*;
/**
 * Write a description of class Ai here.
 * 
 * @author Ping-Chun Chung
 * @version v1.0
 */
public class Ai
{

    /**
     * Constructor for objects of class Ai
     */
    public Ai()
    {
    }

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
                //System.out.print(" o3");
            }
            else if (o == 2 & x == 0){
                point = 10;
                //System.out.print(" o2");
            }
            else if (o == 1 && x == 0){
                point = 1;
                //System.out.print(" o1");
            }
            else if (x == 3){
                point = -100;
                //System.out.print(" x3");
            }
            else if (x == 2 && o == 0){
                point = -50;
                //System.out.print(" x2");
            }
            else if (x == 1 && o == 0){
                point = -3;
                //System.out.print(" x1");
            }
            else {
                point = 0;
                //System.out.print(" 00");
            }
            totalPoint+=point;
        }
        return totalPoint;
    }

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
        int conuter = 0;
        for (int i = 0; i < 3; i++) {
            if (str.substring(i,i+1).equals(letter))
                conuter++;
        }
        return conuter;
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
                //System.out.println("");
                //System.out.print(((i)*3+n+1)+" ");
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
                    //System.out.print(" point:" + point);

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
                        
                        /*
                        System.out.print(" newPoint:" + point);
                        System.out.print("  ");
                        for (int d=0; d<3; d++)
                        {
                            for (int e=0; e<3; e++)
                            {   
                                System.out.print(newNewBoard[d][e]);
                            }
                            System.out.print(" ");
                        }
                        */
                    }                   
                    
                    if (almostLose(newBoard,i,n))
                        point = 300;
                        
                    if (point > maxPoint)
                    {
                        maxPoint = point;
                        move[0] = i;
                        move[1] = n;
                    }
                    /*
                    for (int d=0; d<3; d++)
                    {
                        for (int e=0; e<3; e++)
                        {   
                            System.out.print(newBoard[d][e]);
                        }
                        System.out.print(" ");
                    }

                    if (absLocation(newBoard) != null)
                        System.out.print("  "+absLocation(newBoard)[0]+absLocation(newBoard)[1]);
                    else
                        System.out.print("    ");
                    System.out.print("  move:"+move[0]+move[1]);
                    */
                }
                try{Thread.sleep(50);}catch(InterruptedException e){System.out.println(e);}
            }
        }
        
        if (boardEmpty)
        {
            move[0]=(int)(Math.random()*3);
            move[1]=(int)(Math.random()*3);
        }
        return move;
    }
}
