
package codingexam.services;

import codingexam.model.AbstractCell;

/**
 * A Factory that creates new instances of an implementation of the GridNode at given coordinates.
 * <p>
 * Must be implemented and given to Map instance on construction.
 *
 */
public interface NodeFactory {

    /**
     * creates new instances of an implementation of the <code>GridNode</code>.
     * In an implementation, this method should return a new node with its position
     * set at given x and y values.
     *
     * @param x position on the x-axis
     * @param y position on the y-axis
     * @return
     */
    public AbstractCell createNode(int x, int y, int gCosts);

}
