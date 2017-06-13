package codingexam.grid.tests;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import codingexam.grid.Grid;
import codingexam.services.GridServices;
import codingexam.utils.ArrayUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GridProjectApplicationTests {
	@Autowired
	private GridServices gridServices;
	
	@Test
	public void contextLoads() {
		
	}
	
	    @Test
	    public void passArrayAsANewLineDelimiterStringToLowestPathAlgorithmToPopulateGridWithCosts() {
	    	Grid a= new Grid(0, 0, 1, 2);
	    	int[][] costs = ArrayUtils.arrayFromString("3 4");
	    	a.setGrid(costs);
	    	System.out.println(a.getGrid().toString());
	        assertEquals(a.getGrid()[0][0].getHCost(),3);
	        assertEquals(a.getGrid()[0][1].getHCost(),4);
	    }
	    
	    @Test
	    public void testOneForFindingLowestPath() {
	    	int[][] costs = ArrayUtils.arrayFromString("3 4 1 2 8 6\n6 1 8 2 7 4\n5 9 3 9 9 5\n8 4 1 3 2 6");
	        Map<String,String> gridoutput = gridServices.getGridLowestPath(0, 0, 4, 6, costs);
	        assertEquals(gridoutput.get("pathfound"),"true" );
	        assertEquals(gridoutput.get("path"), "(3, 5 )6->(3, 5 )6->(3, 4 )2->(2, 3 )9->(1, 2 )8->(0, 1 )4" );
	        assertEquals(gridoutput.get("cost"), "26" );

	    }
	    
	    @Test
	    public void testTwoForFindingLowestPath() {
	        int[][] costs2 = ArrayUtils.arrayFromString("3 7 8 8 6 4\n3 4 1 2 8 6\n6 1 8 2 7 4\n5 9 3 9 9 5\n8 4 1 3 2 6\n3 7 2 1 2 3");
	        Map<String,String> gridoutput = gridServices.getGridLowestPath(0, 0, 6, 6, costs2);
	        assertEquals(gridoutput.get("pathfound"),"true" );
	        assertEquals(gridoutput.get("path"), "(5, 5 )3->(5, 5 )3->(4, 4 )2->(3, 3 )9->(2, 2 )8->(1, 1 )4" );
	        assertEquals(gridoutput.get("cost"), "26" );

	    }
	    
	    @Test
	    public void testThreeForFindingLowestPath() {
	    	int[][] costs3 = ArrayUtils.arrayFromString("19 10 19 10 19\n21 23 20 19 12\n20 12 20 11 10");
	    	Map<String,String> gridoutput = gridServices.getGridLowestPath(0, 0, 3, 5, costs3);
	        assertEquals(gridoutput.get("pathfound"),"true" );
	        assertEquals(gridoutput.get("path"), "(2, 4 )10->(2, 4 )10->(2, 3 )11->(1, 2 )20->(0, 1 )10" );
	        assertEquals(gridoutput.get("cost"), "60" );

	    }
	    
//    	gridServices.getGridLowestPath(0, 0, 4, 6, costs);
    	
//        a.test("One", costs, 4, 6, 0, 0, 4, 6, new int[][]{}); 
//        
//        int[][] costs2 = ArrayUtils.arrayFromString("3 7 8 8 6 4\n3 4 1 2 8 6\n6 1 8 2 7 4\n5 9 3 9 9 5\n8 4 1 3 2 6\n3 7 2 1 2 3");
//        a.test("Tw0", costs2, 6, 6, 0, 0, 6, 6, new int[][]{}); 
//        
//        int[][] costs3 = ArrayUtils.arrayFromString("19 10 19 10 19\n21 23 20 19 12\n20 12 20 11 10");
//        a.test("Three", costs3, 3, 5, 0, 0, 3, 5, new int[][]{}); 
        

//        assertThat(
//                equalTo(new AStar2(0,0,2,2).setGrid(ArrayUtils.arrayFromString("1 2 3\n6 7 8 9"), }));
	 

}
