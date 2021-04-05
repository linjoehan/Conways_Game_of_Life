
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.awt.*;

public class TestUnits
{
    ConwaysByLinjoehan emptystate = new ConwaysByLinjoehan();
    ConwaysByLinjoehan teststate = new ConwaysByLinjoehan();
    /*
    Setting up a test state
    Number of alive Neighbours        | 0 | 1 | 2 | 3 | 4 |
                                      |   |   |   | 11|111|
                                      |012|345|678|901|234|
                              --------|---|---|---|---|---|
                                     0|   | O | O | O | O |
                              Dead   1|   |   |   |O  |  O|
                                     2|   |   | O |O  |O O|
                              --------|---|---|---|---|---|
                                     3|   | O | O | O | O |
                              Alive  4| O | O | O |OO | OO|
                                     5|   |   | O |O  |O O|
                              -----------------------------
    */
    
    
    @Before 
    public void setUp() 
    {
        teststate.loadFromFile("./loadstates/test_state.txt");
    }
   
    @Test
    public void testFlipState()
    {
        //Setup
        ConwaysByLinjoehan state = new ConwaysByLinjoehan();
        
        //test that a cell has been changed
        state.flipState(0,0);
        assertFalse(state.equals(emptystate));
        
        //test that a cell has been changed back
        state.flipState(0,0);
        assertTrue(state.equals(emptystate));
    }
    
    @Test
    public void testClearstate()
    {
        //setup
        ConwaysByLinjoehan state = new ConwaysByLinjoehan();
        state.loadFromFile("./loadstates/test_state.txt");
        
        //perform
        state.clearstate();
        
        //test
        assertTrue(state.equals(emptystate));
    }
    
    
    @Test
    public void testLiveCellWithFewerThanTwoLiveNeighboursDies()
    {
        //Uses teststate to run tests
        
        assertEquals( teststate.liveCellWithFewerThanTwoLiveNeighboursDies(new Point( 1,1)) , false);//dead cell with 0 live neighbours
        assertEquals( teststate.liveCellWithFewerThanTwoLiveNeighboursDies(new Point( 4,1)) , false);//dead cell with 1 live neighbour
        assertEquals( teststate.liveCellWithFewerThanTwoLiveNeighboursDies(new Point( 7,1)) , false);//dead cell with 2 live neighbours
        assertEquals( teststate.liveCellWithFewerThanTwoLiveNeighboursDies(new Point(10,1)) , false);//dead cell with 3 live neighbours
        assertEquals( teststate.liveCellWithFewerThanTwoLiveNeighboursDies(new Point(13,1)) , false);//dead cell with 4 live neighbours
        assertEquals( teststate.liveCellWithFewerThanTwoLiveNeighboursDies(new Point( 1,4)) , true) ;//live cell with 0 live neighbours
        assertEquals( teststate.liveCellWithFewerThanTwoLiveNeighboursDies(new Point( 4,4)) , true) ;//live cell with 1 live neighbour
        assertEquals( teststate.liveCellWithFewerThanTwoLiveNeighboursDies(new Point( 7,4)) , false);//live cell with 2 live neighbours
        assertEquals( teststate.liveCellWithFewerThanTwoLiveNeighboursDies(new Point(10,4)) , false);//live cell with 3 live neighbours
        assertEquals( teststate.liveCellWithFewerThanTwoLiveNeighboursDies(new Point(13,4)) , false);//live cell with 4 live neighbours
    }
    
    @Test
    public void testLiveCellWithTwoOrThreeLiveNeighboursLives()
    {
        //Uses teststate to run tests
        
        assertEquals( teststate.liveCellWithTwoOrThreeLiveNeighboursLives(new Point( 1,1)) , false);//dead cell with 0 live neighbours
        assertEquals( teststate.liveCellWithTwoOrThreeLiveNeighboursLives(new Point( 4,1)) , false);//dead cell with 1 live neighbour
        assertEquals( teststate.liveCellWithTwoOrThreeLiveNeighboursLives(new Point( 7,1)) , false);//dead cell with 2 live neighbours
        assertEquals( teststate.liveCellWithTwoOrThreeLiveNeighboursLives(new Point(10,1)) , false);//dead cell with 3 live neighbours
        assertEquals( teststate.liveCellWithTwoOrThreeLiveNeighboursLives(new Point(13,1)) , false);//dead cell with 4 live neighbours
        assertEquals( teststate.liveCellWithTwoOrThreeLiveNeighboursLives(new Point( 1,4)) , false);//live cell with 0 live neighbours
        assertEquals( teststate.liveCellWithTwoOrThreeLiveNeighboursLives(new Point( 4,4)) , false);//live cell with 1 live neighbour
        assertEquals( teststate.liveCellWithTwoOrThreeLiveNeighboursLives(new Point( 7,4)) , true );//live cell with 2 live neighbours
        assertEquals( teststate.liveCellWithTwoOrThreeLiveNeighboursLives(new Point(10,4)) , true );//live cell with 3 live neighbours
        assertEquals( teststate.liveCellWithTwoOrThreeLiveNeighboursLives(new Point(13,4)) , false);//live cell with 4 live neighbours
    }
    
    @Test
    public void testLiveCellWithMoreThanThreeLiveNeighboursDies()
    {
        //Uses teststate to run tests
        
        assertEquals( teststate.liveCellWithMoreThanThreeLiveNeighboursDies(new Point( 1,1)) , false);//dead cell with 0 live neighbours
        assertEquals( teststate.liveCellWithMoreThanThreeLiveNeighboursDies(new Point( 4,1)) , false);//dead cell with 1 live neighbour
        assertEquals( teststate.liveCellWithMoreThanThreeLiveNeighboursDies(new Point( 7,1)) , false);//dead cell with 2 live neighbours
        assertEquals( teststate.liveCellWithMoreThanThreeLiveNeighboursDies(new Point(10,1)) , false);//dead cell with 3 live neighbours
        assertEquals( teststate.liveCellWithMoreThanThreeLiveNeighboursDies(new Point(13,1)) , false);//dead cell with 4 live neighbours
        assertEquals( teststate.liveCellWithMoreThanThreeLiveNeighboursDies(new Point( 1,4)) , false);//live cell with 0 live neighbours
        assertEquals( teststate.liveCellWithMoreThanThreeLiveNeighboursDies(new Point( 4,4)) , false);//live cell with 1 live neighbour
        assertEquals( teststate.liveCellWithMoreThanThreeLiveNeighboursDies(new Point( 7,4)) , false);//live cell with 2 live neighbours
        assertEquals( teststate.liveCellWithMoreThanThreeLiveNeighboursDies(new Point(10,4)) , false);//live cell with 3 live neighbours
        assertEquals( teststate.liveCellWithMoreThanThreeLiveNeighboursDies(new Point(13,4)) , true );//live cell with 4 live neighbours
    }
    
    @Test
    public void testDeadCellWithExactlyThreeLiveNeighboursBecomesAlive()
    {
        //Uses teststate to run tests
        
        assertEquals( teststate.deadCellWithExactlyThreeLiveNeighboursBecomesAlive(new Point( 1,1)) , false);//dead cell with 0 live neighbours
        assertEquals( teststate.deadCellWithExactlyThreeLiveNeighboursBecomesAlive(new Point( 4,1)) , false);//dead cell with 1 live neighbour
        assertEquals( teststate.deadCellWithExactlyThreeLiveNeighboursBecomesAlive(new Point( 7,1)) , false);//dead cell with 2 live neighbours
        assertEquals( teststate.deadCellWithExactlyThreeLiveNeighboursBecomesAlive(new Point(10,1)) , true );//dead cell with 3 live neighbours
        assertEquals( teststate.deadCellWithExactlyThreeLiveNeighboursBecomesAlive(new Point(13,1)) , false);//dead cell with 4 live neighbours
        assertEquals( teststate.deadCellWithExactlyThreeLiveNeighboursBecomesAlive(new Point( 1,4)) , false);//live cell with 0 live neighbours
        assertEquals( teststate.deadCellWithExactlyThreeLiveNeighboursBecomesAlive(new Point( 4,4)) , false);//live cell with 1 live neighbour
        assertEquals( teststate.deadCellWithExactlyThreeLiveNeighboursBecomesAlive(new Point( 7,4)) , false);//live cell with 2 live neighbours
        assertEquals( teststate.deadCellWithExactlyThreeLiveNeighboursBecomesAlive(new Point(10,4)) , false);//live cell with 3 live neighbours
        assertEquals( teststate.deadCellWithExactlyThreeLiveNeighboursBecomesAlive(new Point(13,4)) , false);//live cell with 4 live neighbours
    }
    
}