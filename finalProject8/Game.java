/**
 * File Name: Game.java
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

public class Game{
  private List<FreeCell> freeList;
  private List<HomeCell> homeList;
  private List<Tableau> tableauList;
  private int moveCounter;

    Card movedCard;
    Card topCard;

    /**
    *The Game constructor construccts four freecells, four homecells and eight tableaus, dealing cards to each
    */
    public Game(){
      freeList = new ArrayList<FreeCell>();
      homeList = new ArrayList<HomeCell>();
      tableauList = new ArrayList<Tableau>();

      for (int i = 4; i>0; i--){
        FreeCell freeCell = new FreeCell();
        freeList.add(freeCell);
      }
      for (int i = 4; i>0; i--){
        HomeCell homeCell = new HomeCell();
        homeList.add(homeCell);
      }
      for (int i = 8; i>0; i--){
        Tableau tableau = new Tableau();
        tableauList.add(tableau);
      }
      dealCards();
    }

    /**
    *The Game constructor construccts four freecells, four homecells and eight tableaus, dealing cards to each
    *Only relative to the loadGame method in MainView
    */
    public Game(ArrayList<FreeCell> freeList, ArrayList<HomeCell> homeList, ArrayList<Tableau> tableauList){
      this.freeList = freeList;
      this.homeList = homeList;
      this.tableauList = tableauList;

      for (int i = 4; i>0; i--){
        FreeCell freeCell = new FreeCell();
        freeList.add(freeCell);
      }
      for (int i = 4; i>0; i--){
        HomeCell homeCell = new HomeCell();
        homeList.add(homeCell);
      }
      for (int i = 8; i>0; i--){
        Tableau tableau = new Tableau();
        tableauList.add(tableau);
      }
      dealCards();
    }


    public int getMoveCounter(){
      return moveCounter;
    }
 /**
  * This method deals a deck of 52 cards to the tableaux, 6 in four and
  * 7 in four.
  */
  public void dealCards(){
    Deck deck = new Deck();

    deck.shuffle();
    deck.shuffle();
    boolean b = true;
    while(tableauList.get(7).size()<7){
      for (int i =3; i>=0; i--){
        Card card = deck.deal();
        card.turn();
        tableauList.get(i).add(card);
      }
      if(!(deck.isEmpty())){
        for (int i =7; i>=4; i--){
          Card card = deck.deal();
          card.turn();
          tableauList.get(i).add(card);
        }
      }
      else{
        break;
      }

    }
  }

  /**
   * gameMove method returns a boolean regarding whether the sourceCell can move to the
   * destinationCell
   *@param sourceCell of type CellInterface<Card>
   *@param destinationCell of type CellInterface<Card>
   * @return sourceCell.moveTo(destinationCell)
   */
  public boolean gameMove(CellInterface<Card> sourceCell, CellInterface<Card> destinationCell){
    boolean success = destinationCell.moveFrom(sourceCell);
    moveCounter++;
    return success;
  }


  /**
   * Method for obtaining the i-th tableau
   *@param i referring to the integer index in a list of tableaux
   *@return tableau at index i
   */
  public Tableau tableauGet(int i) {
    return  tableauList.get(i);

  }

  /**
   * Method for obtaining the i-th free cell
   *@param i referring to the integer index in a list of freecells
   *@return freecell at index i
   */
  public FreeCell freeGet(int i) {
    return freeList.get(i);
  }

  /**
   * Method for obtaining the i-th home cell
   *@param i referring to the integer index in a list of homecells
   *@return homecell at index i
   */
  public HomeCell homeGet(int i) {
    return homeList.get(i);
  }

  /**
  *Method that creates a new game instance by repopulating all of the cells with new cards
  */
  public void newGame(){
    for (int i = 3; i>=0; i--){
      if (!this.freeGet(i).isEmpty()){
      this.freeGet(i).clear();
      }
      else{
      }
    }

    for (int i = 3; i>=0; i--){
      if (!this.homeGet(i).isEmpty()){
      this.homeGet(i).clear();
      }
    }


    for (int i = 7; i>=0; i--){
      if (!this.tableauGet(i).isEmpty()){
      this.tableauGet(i).clear();
      }
    }
    dealCards();
  }

    /**
     * This method checks if a player is automatically a winner.
     * @return true or false depending on if a player is a winner.
     */
    public boolean hasWinner() {
      int tableauCount = 0;
      for (Tableau tableau : tableauList) {
        if (tableau.inOrder()) {
          tableauCount += 1;
        }
        else {
          return false;
        }
        if (tableauCount == 8) {
          return true;
        }
        else {
          return false;
        }
      }
      return false;
    }



    /**
     * This method checks if a player is automatically a loser.
     * @return true or false depending on if a player is a loser.
     */
    public boolean hasLoser() {

      for (int i = 0; i < freeList.size(); i++) {
        if(freeGet(i).isEmpty()){
          return false;
        }
      }

      for (int i = 0; i < tableauList.size(); i++) {
          for (int j = i+1; j < tableauList.size(); j++) {
            if (tableauGet(j).canMoveFrom(tableauGet(i))){
              return false;
            }
          }
        }

      for (int i = 0; i < tableauList.size(); i++) {
          for (int j = i+1; j < homeList.size(); j++) {
            if (homeGet(j).canMoveFrom(tableauGet(i))){
              return false;
            }
          }
        }

        for (int i = 0; i < freeList.size(); i++) {
            for (int j = i+1; j < tableauList.size(); j++) {
              if (freeGet(j).canMoveFrom(tableauGet(i))){
                return false;
              }
            }
          }

        for (int i = 0; i < freeList.size(); i++) {
            for (int j = i+1; j < homeList.size(); j++) {
              if ((homeGet(i).canMoveFrom(freeGet(j)))){
                return false;
              }
            }
          }
        return true;

      }
    }
