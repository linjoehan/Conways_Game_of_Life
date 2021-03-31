import java.awt.*;

public class ConwaysByLinjoehan implements ConwaysGameOfLife
{
    final static int ROWS = 30;
    final static int COLS = 60;
    
    private int generation;
    private char[][] board;
    
    public ConwaysByLinjoehan()
    {
        generation = 0;
        board = new char[ROWS][COLS];
        
        for(int row = 0;row<ROWS;row++)
        {
            for(int col = 0;col<COLS;col++)
            {
                board[row][col] = ' ';
            }
        }
    }
    
    public void print()
    {
        //print column numbers first row
        System.out.print("  ");
        for(int i = 0;i<COLS+1;i++)
        {
            if(i==0)
            {
                System.out.print(" ");
            }
            else if(i<10)
            {
                System.out.print(" ");
            }
            else
            {
                System.out.print(i/10);
            }
        }
        System.out.print("\n");
        
        //print column numbers in second row
        System.out.print("  ");
        for(int i = 0;i<COLS+1;i++)
        {
            if(i==0)
            {
                System.out.print(" ");
            }
            else
            {
                System.out.print(i%10);
            }
        }
        System.out.print("\n");
        
        
        //Top boarder
        System.out.print("  +");
        for(int i = 0;i<COLS;i++)
        {
            System.out.print("-");
        }
        System.out.print("+\n");
        
        //board state
        for(int row = 0;row<ROWS;row++)
        {
            //Print row numbers
            if(row + 1<10)
            {
                System.out.print(" ");
            }
            System.out.print(row+1);
            
            System.out.print("|");
            for(int col = 0;col<COLS;col++)
            {
                System.out.print(board[row][col]);
            }
            System.out.print("|\n");
        }
        
        //Bottom boarder
        System.out.print("  +");
        for(int i = 0;i<COLS;i++)
        {
            System.out.print("-");
        }
        System.out.print("+\n");
        
        System.out.println("Generation: " + generation);
    }
    
    public void flipState(int row,int col)
    {
        if(0<= row && row < ROWS && 0<= col && col < COLS)
        {
            switch (board[row][col])
            {
                case ' ':
                {
                    board[row][col] = 'O';
                }break;
                case 'O':
                {
                    board[row][col] = ' ';
                }break;
            }
        }
        else
        {
            System.out.println("ERROR: Row and Column is not within the bounds of the board");
        }
    }
    
    public boolean liveCellWithFewerThanTwoLiveNeighboursDies(Point point)
    {
        return false;
    }
    
    public boolean liveCellWithTwoOrThreeLiveNeighboursLives(Point point)
    {
        return false;
    }
    
    public boolean liveCellWithMoreThanThreeLiveNeighboursDies(Point point)
    {
        return false;
    }
    
    public boolean deadCellWithExactlyThreeLiveNeighboursBecomesAlive(Point point)
    {
        return false;
    }
}