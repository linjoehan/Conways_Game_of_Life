public class ConwaysViewer
{
    ConwaysByLinjoehan gamestate;
    
    public static void main(String args[])
    {
        ConwaysViewer viewer = new ConwaysViewer();
        viewer.run();
    }
    
    private void run()
    {
        gamestate = new ConwaysByLinjoehan();
        
        intro();
        gamestate.print();
    }
    
    private void intro()
    {
        System.out.println("Conways Game of Life by linjoehan");
        System.out.println("For best experience maximise this window");
    }
}