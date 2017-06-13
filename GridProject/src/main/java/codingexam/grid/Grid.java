package codingexam.grid;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import codingexam.model.Cell;

public class Grid {
    public static final int DIAGONAL_COST = 0;
    public static final int V_H_COST = 0;
    
    //Blocked cells are just null Cell values in grid
    private Cell [][] grid;
    
    private PriorityQueue<Cell> open;
     
    private boolean closed[][];
    private int startXPosition, startYPosition;
    private int endXPosition, endYPosition;
    
	public PriorityQueue<Cell> getOpen() {
		return open;
	}

	public void setOpen(PriorityQueue<Cell> open) {
		this.open = open;
	}

	public boolean[][] getClosed() {
		return closed;
	}

	public void setClosed(boolean[][] closed) {
		this.closed = closed;
	}

	public int getStartXPosition() {
		return startXPosition;
	}

	public void setStartXPosition(int startXPosition) {
		this.startXPosition = startXPosition;
	}

	public int getStartYPosition() {
		return startYPosition;
	}

	public void setStartYPosition(int startYPosition) {
		this.startYPosition = startYPosition;
	}

	public int getEndXPosition() {
		return endXPosition;
	}

	public void setEndXPosition(int endXPosition) {
		this.endXPosition = endXPosition;
	}

	public int getEndYPosition() {
		return endYPosition;
	}

	public void setEndYPosition(int endYPosition) {
		this.endYPosition = endYPosition;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

	public void setBlocked(int xPosition, int yPosition){
        this.grid[xPosition][yPosition] = null;
    }
    
    public void setStartCell(int xPosition, int yPosition){
        startXPosition = xPosition;
        startYPosition = yPosition;
    }
    
    public void setEndCell(int xPosition, int yPosition){
    	endXPosition = xPosition;
    	endYPosition = yPosition; 
    }
    
    public Cell[][] getGrid() {
		return this.grid;
	}

	public void setGrid(int[][] costs) {
    	this.grid = new Cell[endXPosition][endYPosition];
	    for(int i=0;i<endXPosition;++i){
	        for(int j=0;j<endYPosition;++j){
	            this.grid[i][j] = new Cell(i, j);
	            this.grid[i][j].setHCost(costs[i][j]);
	        }
	     } 
	}
	
    public Grid(int startXPosition, int startYPosition, int endXPosition, int endYPosition){
       	this.open = new PriorityQueue<>();
        this.closed = new boolean[endXPosition][endYPosition];
        setStartCell(startXPosition, startYPosition);  //Setting to 0,0 by default. Will be useful for the UI part
        //Set End Location
        setEndCell(endXPosition, endYPosition);
    }
    
    private void checkAndUpdateCost(Cell current, Cell t, int cost){
        if(t == null || closed[t.getXPosition()][t.getYPosition()])return;
        int t_final_cost = t.getHCost()+cost;
        
        boolean inOpen = open.contains(t);
        if(!inOpen || t_final_cost<t.getHCost()){
            t.setFCost(t_final_cost);
            t.setParent(current);
            if(!inOpen)open.add(t);
        }
    }
    
    public void lowestCostAlgorithm(Cell[][] grid){ 

        //add the start location to open list.
        open.add(grid[startXPosition][startYPosition]);
        
        Cell current;
        
        while(true){ 
            current = open.poll();
            if(current==null)break;
            closed[current.getXPosition()][current.getYPosition()]=true; 

            if(current.equals(grid[endXPosition-1][endYPosition-1])){
                return; 
            } 

            Cell t;  
            if(current.getXPosition()-1>=0){
                t = grid[current.getXPosition()-1][current.getYPosition()];
                checkAndUpdateCost(current, t, current.getFCost()+V_H_COST); 

                if(current.getYPosition()-1>=0){                      
                    t = grid[current.getXPosition()-1][current.getYPosition()-1];
                    checkAndUpdateCost(current, t, current.getFCost()+DIAGONAL_COST); 
                }

                if(current.getYPosition()+1<grid[0].length){
                    t = grid[current.getXPosition()-1][current.getYPosition()+1];
                    checkAndUpdateCost(current, t, current.getFCost()+DIAGONAL_COST); 
                }
            } 

            if(current.getYPosition()-1>=0){
                t = grid[current.getXPosition()][current.getYPosition()-1];
                checkAndUpdateCost(current, t, current.getFCost()+V_H_COST); 
            }

            if(current.getYPosition()+1<grid[0].length){
                t = grid[current.getXPosition()][current.getYPosition()+1];
                checkAndUpdateCost(current, t, current.getFCost()+V_H_COST); 
            }

            if(current.getXPosition()+1<grid.length){
                t = grid[current.getXPosition()+1][current.getYPosition()];
                checkAndUpdateCost(current, t, current.getFCost()+V_H_COST); 

                if(current.getYPosition()-1>=0){
                    t = grid[current.getXPosition()+1][current.getYPosition()-1];
                    checkAndUpdateCost(current, t, current.getFCost()+DIAGONAL_COST); 
                }
                
                if(current.getYPosition()+1<grid[0].length){
                   t = grid[current.getXPosition()+1][current.getYPosition()+1];
                    checkAndUpdateCost(current, t, current.getFCost()+DIAGONAL_COST); 
                }  
            }
        } 
    }
        
    public Map<String, String> getGridLowestPath(Cell[][] grid){
    	Map<String, String> output= new HashMap();
    	boolean passed = false;
	    int totalCost = 0;
	    String path = "";
        System.out.println("Path: ");
	    if(closed[endXPosition-1][endYPosition-1]){
	        //Trace back the path 
	         Cell current = grid[endXPosition-1][endYPosition-1];
	         path = path.concat(current.toString());
	         System.out.print(current);
	         while(current.getParent()!=null){
	             System.out.print(" -> "+current.getParent());
		         path = path.concat("->"  + current.toString());
	             current = current.getParent();
	             totalCost = totalCost + current.getHCost();
	         } 
	         System.out.println( "\nTotal Cost : " + totalCost);
	         System.out.println("Yes");
	         passed = true;
	    }else System.out.println("No possible path");
	    
	   output.put("cost", String.valueOf(totalCost));
	   output.put("pathfound", String.valueOf(passed));
	   output.put("path", String.valueOf(path));
	   return output;
    }

}