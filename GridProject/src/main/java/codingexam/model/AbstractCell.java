
package codingexam.model;

/**
 * This class represents a GridNode. 
 * <p>
 * An <code>GridNode</code> has x- and y-coordinates.
 * A previous GridNode may be set, as well as the
 * <code>fCosts</code>, <code>gCosts</code> and <code>hCosts</code>.
 * <p>
 * <p>
 * <code>fCosts</code>: <code>gCosts</code> + <code>hCosts</code>
 * <p>
 * <code>gCosts</code>: calculated costs from start GridNode to this GridNode
 * <p>
 * <code>hCosts</code>: estimated costs to get from this GridNode to end GridNode
 * <p>
 * <p>
 * A subclass has to override the heuristic function
 * <p>
 * <code>sethCosts(GridNode endAbstractNode)</code>
 * <p>
 * @see GridNode#sethCosts(AbstractCell endNode) example Implementation using manhatten method
 * <p>
 *
 * @version 1.0
 */
public abstract class AbstractCell {

    private int xPosition;
    private int yPosition;
    private int hCost = 0; //Heuristic cost
    private int fCost = 0; //G+H
    private Cell parent; 

    private boolean walkable;

    /** the previous GridNode of this one on the currently calculated path. */
    private AbstractCell previous;
    
    /** weather or not the move from previous to this AbstractNode is diagonally. */
    private boolean diagonally;

    /** calculated costs from start GridNode to this GridNode. */
    private int gCosts;
    
    /**
     * constructs a GridNode with given coordinates.
     *
     * @param xPosition
     * @param yPosition
     */
    public AbstractCell(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.walkable = true;
    }

    /**
     * constructs a GridNode with given coordinates.
     *
     * @param xPosition
     * @param yPosition
     */
    public AbstractCell(int xPosition, int yPosition, int gCosts) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.gCosts = gCosts;
        this.walkable = true;
    }

    /**
     * returns weather or not the move from the <code>previousAbstractNode</code> was
     * diagonally. If it is not diagonal, it is sideways.
     *
     * @return
     */
    public boolean isDiagonaly() {
        return diagonally;
    }

    /**
     * sets weather or not the move from the <code>previousAbstractNode</code> was
     * diagonally. If it is not diagonal, it is sideways.
     *
     * @param isDiagonaly
     */
    public void setIsDiagonaly(boolean isDiagonaly) {
        this.diagonally = isDiagonaly;
    }
    /**
     * sets x and y coordinates.
     *
     * @param x
     * @param y
     */
    public void setCoordinates(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    /**
     * @return the xPosition
     */
    public int getXPosition() {
        return xPosition;
    }

    /**
     * @return the yPosition
     */
    public int getYPosition() {
        return yPosition;
    }

    /**
     * @return the walkable
     */
    public boolean isWalkable() {
        return walkable;
    }

    /**
     * @param walkable the walkable to set
     */
    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    /**
     * returns the node set as previous node on the current path.
     *
     * @return the previous
     */
    public AbstractCell getPrevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(AbstractCell previous) {
        this.previous = previous;
    }

    
    public int getFCost() {
		return fCost;
	}

	public void setFCost(int fCost) {
		this.fCost = fCost;
	}

	/**
     * returns estimated costs to get from this AbstractNode to end AbstractNode.
     *
     * @return the hCost
     */
    public int getHCost() {
        return hCost;
    }

    /**
     * sets hCost.
     *
     * @param hCost the hCost to set
     */
    public void setHCost(int hCosts) {
        this.hCost = hCosts;
    }
    
    

    public Cell getParent() {
		return parent;
	}

	public void setParent(Cell parent) {
		this.parent = parent;
	}

	/**
     * returns a String containing the coordinates, as well as h, f and g
     * costs.
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + getXPosition() + ", " + getYPosition() + " )" + getHCost();
    }

    /**
     * returns weather the coordinates of AbstractNodes are equal.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractCell other = (AbstractCell) obj;
        if (this.xPosition != other.xPosition) {
            return false;
        }
        if (this.yPosition != other.yPosition) {
            return false;
        }
        return true;
    }

    /**
     * returns hash code calculated with coordinates.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.xPosition;
        hash = 17 * hash + this.yPosition;
        return hash;
    }

}