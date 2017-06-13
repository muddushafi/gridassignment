package codingexam.model;

/**
 * A simple Example implementation of a Node only overriding the sethCosts
 * method; uses manhatten method.
 */
public class Cell extends AbstractCell implements Comparable<Cell> {

        public Cell(int xPosition, int yPosition, int gCosts) {
            super(xPosition, yPosition, gCosts);
            // do other init stuff
        }

		public Cell(int xPosition, int yPosition) {
            super(xPosition, yPosition);
		}
		
		@Override
		public int compareTo(Cell arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

}