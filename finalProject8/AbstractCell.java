/**
 * File Name: AbstractCell.java
 * Description: Creates an implementation of the methods used by the cell classes
 * @author Rohan Jairam
 * @author Mohini Tangri
 * @author Alexander Caines
 * @author Mickey Brown
 * @author Coletta Fuller
 * @version 1.0
 * Date 11/14/2018
 */

import java.util.*;
import propackage.*;

abstract public class AbstractCell<Card> implements CellInterface<Card>{
  protected ArrayList<Card> cards;
  private Card sourceCard;


  /**
   * This constructs an array list of cards
   */
  public AbstractCell(){
    this.cards = new ArrayList<Card>();
  }

  /**
   * This method returns the cell
   */
  public ArrayList<Card> getCell(){
    return cards;
  }



  /**
   * The canMoveTo method moves a card from a cell to a cell
   * @param movedCard the card from another cell that is to be moved
   * @param topCard the card on the top of the other cell
   * @return true if the card can be moved into the cell and false if it cannot
   */
   public boolean canMoveFrom(CellInterface<Card> source) {
     if (!source.isEmpty() && !(source instanceof HomeCell)) {
       return true;
     }
     else{
       return false;
     }
   }


   /**
    * This method moves a card from one cell to another
    * @param source an instance of a foreign cell
    */
    public boolean moveFrom(CellInterface<Card> source){
      boolean success = true;
    		if(this.canMoveFrom(source)){
          if(source instanceof FreeCell){
            sourceCard = source.get(0);
          }
          else{
            sourceCard = source.get(source.size()-1);
          }
    			source.remove();
          if (this instanceof HomeCell && !this.isEmpty()){
            this.remove();
          }
          cards.add(sourceCard);
          success = true;
          return success;
    		}
        else{
          System.out.println("AbstractCell error");
          success = false;
          return success;
        }
    }



  /**
   * Checks if the cell is empty
   * @return true if the size of the cell is 0 and false otherwise
   */
  public boolean isEmpty(){
    if(this.size() == 0){
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * The size() method returns the size of the cell
   * @return cards.size() an integer equal to the number of cards in the cell
   */
  public int size(){
    return cards.size();
  }

  /**
   * The remove() method functions in the same way as a stack's pop method
   * @return card an object of type Card that has just been removed from a cell
   */
  public Card remove(Card c){
    if(cards.isEmpty() == true){
      throw new NullPointerException("You cannot remove from an empty list");
    }
    else{
      Card card = cards.get(c);
      cards.remove(c);
      return card;
    }
  }

  /**
   * The add method adds a card to a cell.
   * @param card A cell's card
   * @return true if the addition was sucessful and false otherweise
   */
  public boolean add(Card card){//try making this void if any problems
    return cards.add(card);
  }

  /**
   * The get method returns the item at a certain index
   * @param i integer index
   * @return cards.get(i) the item at the index i
   */
  public Card get(int i){
    if(i<0){
      return card;
    }
    else{
      return cards.get(i);
    }
  }
  /**
   * Returns card at end of list
   */
  public Card peek(){
    return cards.get(this.size() - 1);
  }


  /**
   * The toString method returns the string representation fo teh items in a cell
   * @return cardsString String representation of the items in a cell
   */
  public String toString(){
    String cardsString = "";
    for (Card c: cards){
      cardsString+=c+"\n";
    }
    return cardsString;
  }
  /** Creates an iterator of list of cards **/
  public Iterator<Card> iterator(){
    return cards.iterator();
  }
  /**
   * The clear method removes all of the cardsString
   */
  public void clear(){
    while (!(cards.isEmpty())){
      cards.remove(0);
    }
  }

}
