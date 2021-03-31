import java.awt.*;

public class ConwaysByLinjoehan implements ConwaysGameOfLife
{
    final static int ROWS = 50;
    final static int COLS = 50;
    
    private int generation;
    private char[][] gamestate;
    
    public ConwaysByLinjoehan()
    {
        generation = 0;
        gamestate = new char[ROWS][COLS];
        
        for(int row = 0;row<ROWS;row++)
        {
            for(int col = 0;col<COLS;col++)
            {
                gamestate[row][col] = ' ';
            }
        }
    }
    
    public void print()
    {
        for(int row = 0;row<ROWS;row++)
        {
            System.out.print("|");
            for(int col = 0;col<COLS;col++)
            {
                System.out.print(gamestate[row][col]);
            }
            System.out.print("|\n");
        }
        System.out.println("Generation: " + generation);
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