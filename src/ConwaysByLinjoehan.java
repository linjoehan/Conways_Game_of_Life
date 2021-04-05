import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.Random;

public class ConwaysByLinjoehan implements ConwaysGameOfLife
{
    final static int ROWS = 30;
    final static int COLS = 80;
    
    private int generation;
    boolean[][] board;
    
    public ConwaysByLinjoehan()
    {
        generation = 0;
        board = new boolean[ROWS][COLS];
        
        for(int row = 0;row<ROWS;row++)
        {
            for(int col = 0;col<COLS;col++)
            {
                board[row][col] = false;
            }
        }
    }
    
    //Prints a formatted state of the board
    public void print()
    {
        String outputBuffer = "";
        //print column numbers first row
        outputBuffer += "  ";
        for(int i = 0;i<COLS+1;i++)
        {
            if(i==0)
            {
                outputBuffer += " ";
            }
            else if(i<10)
            {
                outputBuffer += " ";
            }
            else
            {
                outputBuffer += Integer.toString(i/10);
            }
        }
        outputBuffer += "\n";
        
        //print column numbers in second row
        outputBuffer += "  ";
        for(int i = 0;i<COLS+1;i++)
        {
            if(i==0)
            {
                outputBuffer += " ";
            }
            else
            {
                outputBuffer += Integer.toString(i%10);
            }
        }
        outputBuffer += "\n";
        
        
        //Top boarder
        outputBuffer += "  +";
        for(int i = 0;i<COLS;i++)
        {
            outputBuffer += "-";
        }
        outputBuffer += "+\n";
        
        //board state
        for(int row = 0;row<ROWS;row++)
        {
            //Print row numbers
            if(row + 1<10)
            {
                outputBuffer += " ";
            }
            outputBuffer += Integer.toString(row+1);
            
            outputBuffer += "|";
            for(int col = 0;col<COLS;col++)
            {
                outputBuffer += (board[row][col] ? "O" : " ");
            }
            outputBuffer += "|\n";
        }
        
        //Bottom boarder
        outputBuffer += "  +";
        for(int i = 0;i<COLS;i++)
        {
            outputBuffer += "-";
        }
        outputBuffer += "+\n";
        
        outputBuffer += "Generation: " + Integer.toString(generation);
        
        System.out.println(outputBuffer);
    }
    
    //flips a cell between alive and dead
    public void flipState(int row,int col)
    {
        if(0<= row && row < ROWS && 0<= col && col < COLS)
        {
            board[row][col] = !board[row][col];
        }
        else
        {
            System.out.println("ERROR: Row and Column is not within the bounds of the board");
        }
    }
    
    //loads states from file
    public void loadFromFile(String filename)
    {
        clearstate();
        
        BufferedReader fileReader;
        try
        {
            fileReader = new BufferedReader(new FileReader(filename));
            String line = fileReader.readLine();
            for(int row = 0;line != null && row < ROWS;row++)
            {
                if(line.length() != COLS)
                {
                    System.out.println("WARN: Input file is not the correct size a truncated state will be loaded");
                }
                for(int col = 0;col < line.length() && col < COLS;col++)
                {
                    switch(line.charAt(col))
                    {
                        case ' ':
                        {
                            board[row][col] = false;
                        }break;
                        case 'O':
                        {
                            board[row][col] = true;
                        }break;
                        default:
                        {
                            System.out.println("ERROR: input file is not is the correct format");
                        }
                    }
                }
                
                line = fileReader.readLine();
            }
        }
        catch(IOException e)
        {
            System.out.println("Could not read file");
            return;
        }
    }
    
    public void fillRandom()
    {
        Random rand = new Random();
        for(int row = 0;row<ROWS;row++)
        {
            for(int col = 0;col<COLS;col++)
            {
                int a = rand.nextInt(2);
                switch(a)
                {
                    case 0:
                    {
                        board[row][col] = false;
                    }break;
                    case 1:
                    {
                        board[row][col] = true;
                    }break;
                }
            }
        }
    }
    
    //Updates the board based on the game of life rules
    public void updateFrame()
    {
        boolean[][] nextBoard = new boolean[ROWS][COLS];
        
        for(int row = 0;row<ROWS;row++)
        {
            for(int col = 0;col<COLS;col++)
            {
                int aliveNeighbours = countNeighbours(row,col); //counts of neighbour cells thats alive
                
                if(board[row][col] == false && aliveNeighbours == 3) //if cell is currently dead and has 3 alive neighbours set it to alive
                {
                    nextBoard[row][col] = true;
                }
                else if(board[row][col] == true && (aliveNeighbours < 2 || aliveNeighbours > 3)) //if cell is alive and has to few or to many alive neighbours change cell to dead
                {
                    nextBoard[row][col] = false;
                }
                else
                {
                    nextBoard[row][col] = board[row][col];
                }
            }
        }
        
        //update board to next state
        for(int row = 0;row<ROWS;row++)
        {
            for(int col = 0;col<COLS;col++)
            {
                board[row][col] = nextBoard[row][col];
            }
        }
        
        generation++;
    }
    
    public boolean liveCellWithFewerThanTwoLiveNeighboursDies(Point point)
    {
        int row = point.y;
        int col = point.x;
        int aliveNeighbours = countNeighbours(row,col);
        
        return (board[row][col]== true && aliveNeighbours < 2);
    }
    
    public boolean liveCellWithTwoOrThreeLiveNeighboursLives(Point point)
    {
        int row = point.y;
        int col = point.x;
        int aliveNeighbours = countNeighbours(row,col);
        
        return (board[row][col]== true && 2<= aliveNeighbours && aliveNeighbours <= 3);
    }
    
    public boolean liveCellWithMoreThanThreeLiveNeighboursDies(Point point)
    {
        int row = point.y;
        int col = point.x;
        int aliveNeighbours = countNeighbours(row,col);
        
        return (board[row][col]== true && aliveNeighbours > 3);
    }
    
    public boolean deadCellWithExactlyThreeLiveNeighboursBecomesAlive(Point point)
    {
        int row = point.y;
        int col = point.x;
        int aliveNeighbours = countNeighbours(row,col);
        
        return (board[row][col]== false && aliveNeighbours == 3);
    }
    
    //sets all cells to dead
    private void clearstate()
    {
        for(int row = 0;row<ROWS;row++)
        {
            for(int col = 0;col < COLS;col++)
            {
                board[row][col] = false;
            }
        }
    }
    
    //counts alive neighbours to a cell
    private int countNeighbours(int row,int col)
    {
        int res = 0;
        for(int row_delta = -1;row_delta<=1;row_delta++)
        {
            for(int col_delta = -1;col_delta<=1;col_delta++)
            {
                if(Math.abs(row_delta) + Math.abs(col_delta) > 0)
                {
                    int target_row = row + row_delta;
                    int target_col = col + col_delta;
                    
                    if(0<= target_row && target_row < ROWS && 0<= target_col && target_col < COLS)
                    {
                        if(board[target_row][target_col] == true)
                        {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
    
    //Game of life states are considered equal when the board is in the same state
    boolean equals(ConwaysByLinjoehan state)
    {
        boolean res = true;
        for(int row = 0;row<ROWS && res;row++)
        {
            for(int col = 0;col<COLS && res;col++)
            {
                res = state.board[row][col] == board[row][col];
            }
        }
        return res;
    }
}