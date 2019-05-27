/**
 * File Name: Tableau.java
 * Description: Creates an implementation of the methods used by the cell classes
 * @author Rohan Jairam
 * @author Mohini Tangri
 * @author Alexander Caines
 * @author Mickey Brown
 * @author Coletta Fuller
 * @version 1.0
 *Date 12/7/2018
 */

import propackage.*;
import java.util.*;

public class Tableau extends AbstractCell<Card>{
	private CellInterface<Card> tcell;
	private ArrayList<Card> tempList;
	/**
   * Constructs a Tableau
	 */
	public Tableau() {
		super();
		this.tempList = new ArrayList<Card>();


	}

	/**
	 * The get method returns the item at a certain index
	 * @param i integer index
	 * @return The item at the index i
	 */
	public Card get(int i){
		return cards.get(i);
	}



	 /**
	  * The inOrder function checks if a card of one tableau can be moved onto that of another cell
	  * @return true if the card can be moved and false otherwise
	  */
	 public boolean inOrder(){
	   boolean inOrder=false;
	   if(cards.size() < 2){
	     inOrder = true;
	     return inOrder;
	   }
	   else{
	     for(int i =0;i<cards.size()-1;i++){
	       Card currentCard = cards.get(i);
	       Card nextCard = cards.get(i+1);
	       if((currentCard.rankComparison(nextCard)==-1)&&(currentCard.colorComparison(nextCard) == false)){//should compare cards
	         inOrder = true;
	       }
	       else{
	         inOrder = false;
	       }
	     }
	     return inOrder;
	   }
	 }

	/**
	 * This method checks if cards or a group of cards can be moved.
	 * @return true or false depending on if the cards can be moved.
	 */
  public boolean moveFrom(CellInterface<Card> source){
		int i =1;
		int j = 2;

		Card sourceCard1 = source.get(source.size()-i);
		Card sourceCard2 = source.get(source.size()-j);

		Card card = sourceCard1;
		tempList.add(card);
		while ((sourceCard1.rankComparison(sourceCard2)== 1) && (sourceCard1.colorComparison(sourceCard2)==false) && source.size()>j) {

			i++;
			j++;
			Card card1 = source.get(source.size()-i);
			tempList.add(card1);



			sourceCard1 = source.get(source.size()-i);
			sourceCard2 = source.get(source.size()-j);
		}

		int count =tempList.size();
		while(count>0){
			source.remove();
			count--;
		}


		while(tempList.size()>0){
			source.add(tempList.get(0));
			tempList.remove(0);

		}
			int counter = 0;
			while (this.canMoveFrom(source)){
				counter ++;
				cards.add(source.remove());
			}
			if (counter >0) {
				return true;
			}
			else {
				return false;
			}
		}

	/**
	 * This method tests if something can be moved from a tableau
	 * @return true or false depending on if the conditions are satisfied
	 */
	public boolean canMoveFrom(CellInterface<Card> source){
		boolean result = false;
		if(super.canMoveFrom(source)) {
			Card sourceCard = source.get(source.size()-1);
			Card thisCard = this.get(this.size()-1);
			if((sourceCard.rankComparison(thisCard)==1) && (sourceCard.colorComparison(thisCard)==false)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

}
