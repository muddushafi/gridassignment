/*    
    Copyright (C) 2012 http://software-talk.org/ (developer@software-talk.org)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package codingexam.services;

import codingexam.model.AbstractCell;
import codingexam.model.Cell;

/**
 * A simple Factory for example nodes.
 */
public class GridFactory implements NodeFactory {

        @Override
        public AbstractCell createNode(int x, int y, int gCosts) {
            return new Cell(x, y, gCosts);
        }

}
