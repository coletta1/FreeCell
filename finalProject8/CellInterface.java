/**
 * File Name: CellInterface.java
 * Description: Creates an implementation of the methods used by the cell classes
 * @author Rohan Jairam
 * @author Mohini Tangri
 * @author Alexander Caines
 * @author Mickey Brown
 * @author Coletta Fuller
 * @version 1.0
 *Date 12/7/2018
 */
import java.util.Collection;
import propackage.*;
import java.util.*;

public interface CellInterface<Card>{

  /**
   * The size() method returns the size of the cell
   * @return an integer equal to the number of cards in the cell
   */
  public int size();

  /**
   * The remove() method functions in the same way as a Stack's pop
   * @return card an object of type Card that has just been removed from a cell
   */
  public Card remove();

  /**
   * The get method returns the item at a certain index
   * @param i integer index
   */
  public Card get(int i);

  /**
  *The getCell method returns an arraylist of cards (a Cell)
  *@return arraylist of cards
  */
  public ArrayList<Card> getCell();


  /**
   * The add method adds a card to a cell.
   * @param card A cell's card
   * @return true if the addition was sucessful and false otherweise
   */
  public boolean add(Card card);//define in abstractcell as a default for homecell and freecells

  /**
   * The toString method returns the string representation fo teh items in a cell
   * @return String representation of the items in a cell
   */
  public String toString();

  /**
   * The clear method removes the cards
   */
  public void clear();



  /**
  *The moveTo method moves cards from one cell to another
  *@param cell of type CellInterface<Card>
  *@return true if a Cell moves cards to another cell and false if it does not
  */
  public boolean moveFrom(CellInterface<Card> source);

  /*
   * The canMoveFrom method checks if a card can be moved from a specific area
   * @return true if the card can be successfully moved
   */
  public boolean canMoveFrom(CellInterface<Card> source);

  /**
  *@return true if a Cell has no items in its hand and false otherwise
  */
  public boolean isEmpty();


}
