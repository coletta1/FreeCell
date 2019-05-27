/**
 * File Name: FreeCell.java
 * Description: Creates an implementation of the methods used by the cell classes
 * @author Rohan Jairam
 * @author Mohini Tangri
 * @author Alexander Caines
 * @author Mickey Brown
 * @author Coletta Fuller
 * @version 1.0
 *Date 12/7/2018
 */

import java.util.*;
import propackage.*;

public class FreeCell extends AbstractCell<Card>{
	/**
	 * This method is the constructor for a FreeCell
	 */
	public FreeCell(){
		super();
	}
	/**
	*@param source of type CellInterface<Card>
	*@return true if the freecell can be moved to and else otherwise
	*/
	public boolean canMoveFrom(CellInterface<Card> source){
		if(this.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}

}
