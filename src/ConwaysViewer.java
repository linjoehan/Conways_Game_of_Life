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
                //gamestate.updateFrame();
                updateframes--;
            }
            else
            {
                menu();
            }
            wait(1000);
        }
    }
    
    private void intro()
    {
        System.out.println("Conways Game of Life by linjoehan");
        System.out.println("For best experience maximise this window");
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }
    
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
            System.out.println("Input is not a recognised option");
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
                
            }break;
            case 2 :
            {
                
            }break;
            case 3 :
            {
                
            }break;
            default :
            {
                System.out.println("Input is not a recognised option");
            }
        }
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