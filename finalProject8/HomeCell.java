/**
 * File Name: HomeCell.java
 * Description: Creates an implementation of the methods used by the cell classes
 * @author Rohan Jairam
 * @author Mohini Tangri
 * @author Alexander Caines
 * @author Mickey Brown
 * @author Coletta Fuller
 * @version 1.0
 * Date 12/7/2018
 */


import propackage.*;
import java.util.*;


public class HomeCell extends AbstractCell<Card>{

  /**
	 * This method constructs a homecell
	 */
	public HomeCell(){
		super();
	}

	/**
	 * The canMoveFrom method makes sure that the client does not try to move a homeCell's card to another cell
	 * @param source an object of type CellInterface<Card>
	 * @return false or true depending on if it can be moved to HomeCell
	 */
	public boolean canMoveFrom(CellInterface<Card> source){

				Card sourceCard = source.get(source.size()-1);
				if (source instanceof HomeCell) {
					return false;
				}

				if (this.isEmpty() && !(source instanceof HomeCell)){
						if(sourceCard.getRank() == 1){
							return true;
						}
						else{
							return false;
						}
					}
					else{
						Card thisCard = this.get(this.size()-1);
						if((sourceCard.suitComparison(thisCard) == true)&&(sourceCard.rankComparison(thisCard) == -1) && (sourceCard.colorComparison(thisCard) == true)){
							return true;
					}
						else{
							return false;
						}
			}
		}

}
