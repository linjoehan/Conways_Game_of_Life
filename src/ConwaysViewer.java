import java.util.Scanner;
import java.util.InputMismatchException;

public class ConwaysViewer
{
    Scanner scanner;
    ConwaysByLinjoehan gamestate;
    boolean running; // Keeps the programme running
    int updateframes; // Tracks the number of frames to run
    
    public static void main(String args[])
    {
        ConwaysViewer viewer = new ConwaysViewer();
        viewer.run();
    }
    
    private void run()
    {
        //init class variables
        scanner = new Scanner(System.in);
        gamestate = new ConwaysByLinjoehan();
        running = true;
        updateframes = 0;
        
        intro();
        
        //gameloop
        while(running)
        {
            gamestate.print();
            if(updateframes > 0)
            {
                gamestate.updateFrame();
                updateframes--;
            }
            else
            {
                menu();
            }
            wait(200);
        }
    }
    
    //Intro to the game
    private void intro()
    {
        System.out.println("Conways Game of Life by linjoehan");
        System.out.println("For best experience maximise this window");
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }
    
    //Main menu when nothing needs to be done
    private void menu()
    {
        System.out.println(" 1 - Load predefined state");
        System.out.println(" 2 - Edit cell in state manually");
        System.out.println(" 3 - Run simulation for a selected number of frames");
        System.out.println(" 0 - Exit");
        System.out.print("Enter Option number:");
        
        int option;
        try
        {
            option = scanner.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Input is not an integer");
            scanner.nextLine();
            return;
        }
        
        switch(option)
        {
            case 0 :
            {
                System.out.println("Thanks for playing... Exiting");
                running = false;
            }break;
            case 1 :
            {
                menuLoadState();
            }break;
            case 2 :
            {
                menuEditState();
            }break;
            case 3 :
            {
                menuRunState();
            }break;
            default :
            {
                errorInput("Input is not a recognised option");
                scanner.nextLine();
            }
        }
    }
    
    private void menuLoadState()
    {
        System.out.println("States:");
        System.out.println(" 0 - Randomly fill state");
        System.out.println(" 1 - Still life forms");
        System.out.println(" 2 - Oscillators");
        System.out.println(" 3 - Glider gun");
        System.out.println(" 4 - Glider gun and Eater");
        
        System.out.println("Enter State to load:");
        
        int option;
        try
        {
            option = scanner.nextInt();
        }
        catch(InputMismatchException e)
        {
            errorInput("Input is not an integer");
            scanner.nextLine();
            return;
        }
        
        switch(option)
        {
            case 0:
            {
                gamestate.fillRandom();
            }break;
            case 1:
            {
                gamestate.loadFromFile("./loadstates/still_life.txt");
            }break;
            case 2:
            {
                gamestate.loadFromFile("./loadstates/oscillators.txt");
            }break;
            case 3:
            {
                gamestate.loadFromFile("./loadstates/glidergun.txt");
            }break;
            case 4:
            {
                gamestate.loadFromFile("./loadstates/glidergun_and_eater.txt");
            }break;
            default:
            {
                errorInput("Input is not a recognised option");
                scanner.nextLine();
            }
        }
    }
    
    private void menuEditState()
    {
        int row;int col;
        System.out.println("Flip the state of");
        
        //Get row
        System.out.print("Row:");
        try
        {
            row = scanner.nextInt();
        }
        catch(InputMismatchException e)
        {
            errorInput("Input is not an integer");
            scanner.nextLine();
            return;
        }
        
        //Get column
        System.out.print("Row:");
        try
        {
            col = scanner.nextInt();
        }
        catch(InputMismatchException e)
        {
            errorInput("Input is not an integer");
            scanner.nextLine();
            return;
        }
        
        gamestate.flipState(row-1,col-1);
    }
    
    private void menuRunState()
    {
        System.out.println("How many frames do you want to simulate:");
        
        int input;
        try
        {
            input = scanner.nextInt();
        }
        catch(InputMismatchException e)
        {
            errorInput("Input is not an integer");
            scanner.nextLine();
            return;
        }
        updateframes = input;
    }
    
    private void errorInput(String message)
    {
        System.out.println(message);
        wait(800);
    }
    
    private void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}