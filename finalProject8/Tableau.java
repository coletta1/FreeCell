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
	 /**
   * Constructs a Tableau
	 */
	public Tableau() {
		super();
	}

	 /**
	 * The get method returns the item at a certain index
	 * @param i integer index
	 * @return The item at the index i
	 */
	public Card get(int i){
		if (!this.isEmpty()){
			return cards.get(i);
		}
		else{
			return null;
		}
	}

	public Card remove(Card c) {
		cards.remove(c);
		return c;
	}
	/**
   * Returns card at end of list/ bottom of tableau
   */
  public Card peek(){
    if (!this.isEmpty()){
			return cards.get(this.size() - 1);
  	}
		else{
			return null;
		}
	}
	 /**
	  * The inOrder function checks if a card of one tableau can be moved onto that of another cell
	  * @return true if the card can be moved and false otherwise
	  */
	 public boolean inOrder(){
	   boolean inOrder=false;
	   if(this.isEmpty() || this.size() == 1){
	     inOrder = true;
			 System.out.println("\033[32;1mOrder?:\033[0m" + inOrder); //in order if empty or has one item
			 return inOrder;
	   }
	   Card currentCard = cards.get(0);
		 for (Card card:cards){  //loop is fucked?
			 System.out.println("\033[31;1mCard:\033[0m" + card);
			 if (currentCard == card){
				 //inOrder = true;
				 //System.out.println("in order: " + inOrder);
			 }

	     else if((card.rankComparison(currentCard)==1)&&(card.colorComparison(currentCard) == false)){//should compare cards
				 		System.out.println("\033[35;1mPartial\033[0m" + currentCard);  //prints pink
					 currentCard = card;
					 System.out.println("\033[35;1mPartial\033[0m" + currentCard);  //prints pink
					 inOrder = true;
	       }
	       else{
	         inOrder = false;
					 return inOrder;
	       }
	     }
			 System.out.println("\033[32;1mOrder?:\033[0m" + inOrder); //in order if empty or has one item
	     return inOrder;
	   }



	 public ArrayList<Card> getTempList(Card c){
		 ArrayList<Card> tempList = new ArrayList<Card>();
		 Card currentCard = null;
		 Card nextCard = null;
		 ArrayList<Card> reversed = new ArrayList<Card>();

		 for (int i = cards.size()-1; i > -1; i --) {
			nextCard = cards.get(i);

			if (reversed.isEmpty()) {
				reversed.add(nextCard);
				currentCard = nextCard;
				if (!(c == null) && (!nextCard.colorComparison(c)==false) && (nextCard.rankComparison(c)==1)) {
					break;
				}
			}
			else if (((currentCard.rankComparison(nextCard)==1)&&(currentCard.colorComparison(nextCard) == false))){
				if ((!(c == null) && (nextCard.rankComparison(c)==1))&&(nextCard.colorComparison(c) == false)) {
						reversed.add(nextCard);
						break;
				}
				else {
					reversed.add(nextCard);
					currentCard = nextCard;
				}
			}
			else {
				break;
			}

		}
		for (int i = reversed.size()-1; i > -1; i --) {
			tempList.add(reversed.get(i));
		}

		return tempList;

		}
	/**
	 * This method checks if cards or a group of cards can be moved.
	 * @return true or false depending on if the cards can be moved.
	 */
  public boolean moveFrom(CellInterface<Card> source) {
		ArrayList<Card> tempList = new ArrayList<Card>();
		Card sourceCard = null;
		Card topCard = this.peek();
		if (canMoveFrom(source) == false) {
			return false;
		}
		if (source instanceof Tableau) {
			tempList = source.getTempList(topCard);
			for (Card c : tempList) {
				cards.add(c);
				source.remove(c);
			}
			return true;
		}
		else if (source instanceof FreeCell) {
			sourceCard = source.peek();
			cards.add(sourceCard);
			source.remove(sourceCard);
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
		Card sourceCard = source.peek();
		Card thisCard = this.peek();

		//can add to something currently empty
		if (thisCard == null){
			return true;
			}

		//cannot move from if there isn't a card in the source
		if (sourceCard == null){
			return false;
		}
		else{
			if (source instanceof Tableau){
				ArrayList<Card> tempList = source.getTempList(thisCard);
				sourceCard = tempList.get(0);
			}
			if((sourceCard.rankComparison(thisCard)==1) && (sourceCard.colorComparison(thisCard)==false)){
				return true;
			}
			else{
				return false;
			}
		}
	}
}
