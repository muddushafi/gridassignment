package codingexam.services;

import java.util.Map;

import org.springframework.stereotype.Component;

import codingexam.grid.Grid;

@Component
public class GridServices {
	
	public Map<String, String> getGridLowestPath(int sRow, int sCol, int eRow, int eCol, int[][] costs){
        Grid aStar = new Grid(sRow,sCol, eRow, eCol);
        aStar.setGrid(costs); 
        aStar.getGrid()[sRow][sCol].setFCost(0);
        aStar.lowestCostAlgorithm(aStar.getGrid()); 
        return aStar.getGridLowestPath(aStar.getGrid());
	}

}
