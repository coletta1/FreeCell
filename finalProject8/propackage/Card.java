package propackage;


import javax.swing.*;

/**
 * Represents a playing card with a suit,
 * rank, image, and face up status.
 * @author lambertk
 *
 */
public class Card implements Comparable<Card>{


    private Suit suit;
    private int rank;
    private boolean faceUp;
    private Icon image;
    private static Icon CARD_BACK;

    /**
     * Constructor.
     * @param suit the card's suit
     * @param rank the card's rank
     */
    public Card(Suit suit, int rank){
    	this.suit = suit;
    	this.rank = rank;
    	faceUp = false;

      image = getImageFromFile(rank, suit);
    	if (CARD_BACK == null)
    		CARD_BACK = getBackFromFile();
    }

    /**
     * Returns the card's face image if its face is up or its back side image otherwise.
     * @return the card's face image or the back side image
     */
    public Icon getImage(){
    	if (faceUp)
    	    return image;
    	else
    	    return CARD_BACK;
    }

    /**
     * Returns the back side image of a card.
     * @return the back side image of a card
     */
    public static Icon getBack(){
    	if (CARD_BACK == null)
    	    new Card(Suit.spade, 1);
    	return CARD_BACK;
    }

    /**
     * Turns the card over, negating its face up status.
     */
    public void turn(){
    	faceUp = ! faceUp;
    }

    private Icon getImageFromFile(int rank, Suit suit){
    	String fileName = "DECK/";
    	fileName += rank;
    	fileName += Character.toUpperCase(suit.toString().charAt(0));
    	fileName += ".GIF";
    	return new ImageIcon(getClass().getResource(fileName));
    }

    private Icon getBackFromFile(){
    	String fileName = "DECK/CARDBACK.GIF";
    	return new ImageIcon(getClass().getResource(fileName));
    }

    /**
     * Returns the card's face up status.
     * @return true if face up or false otherwise
     */
    public boolean isFaceUp(){
       return faceUp;
    }

    /**
     * Returns the card's suit.
     * @return the card's suit
     */
    public Suit getSuit(){
        return suit;
    }

    /**
     * Returns the card's rank
     * @return the card's rank
     */
    public int getRank(){
        return rank;
    }

    /**
     * Compares two cards with respect to rank
     * @return 0 if equal, less than 0 if less, greater than 0 if greater
     */
    public int compareTo(Card other){
        return this.rank - other.rank;
    }

    /**
     * Returns the string representation of the card (rank of suit)
     * @return the string representation of the card
     */
    public String toString(){
        return rankToString(rank) + " of " + suit;
    }

    static private String rankToString(int rank){
        if (rank >= 2 && rank <= 10) return rank + "";
        else if (rank == 11) return "Jack";
        else if (rank == 12) return "Queen";
        else if (rank == 13) return "King";
        else return "Ace";
    }
    /**
     * The colorComparison method checks whether or not the cards are of the same color or not
     * @param card A card from a cell
     * @return true if the color of the two cards is the same and false otherwise
     */
    public boolean colorComparison(Card card){
      String card1Color = "";
      String card2Color = "";

      Suit thisSuit = this.getSuit();
      Suit cardSuit = card.getSuit();

      if ((thisSuit == Suit.heart)||(thisSuit == Suit.diamond)){//turn the suit for the movedCard into color
        card1Color = "RED";
      }
      else{
        card1Color = "BLACK";
      }

      if ((cardSuit == Suit.heart)||(cardSuit == Suit.diamond)){//turn the suit for the tableauCard into color
        card2Color = "RED";
      }
      else{
        card2Color = "BLACK";
      }

      if(card1Color == card2Color){
        return true;
      }
      else{
        return false;
      }
    }

    /**
     * The suitComparison method compares the suits of two different cards
     * @param card A card from a cell
     * @return true if the cards share the same suit and false otherwise
     */
    public boolean suitComparison(Card card){
      Suit thisSuit = this.getSuit();
      Suit cardSuit = card.getSuit();

      return thisSuit == cardSuit;
    }

    /**
     * The rankComparison method compares the ranks of two cards
     * @param card A card from a cell
     * @return Integers are returned by rankComparison based on if the first card is of the same rank as the second card, the first card 's rank is one less than the second card's, or the first card's is one rank more than the second card's
     */
    public int rankComparison(Card card){
      int thisRank = this.getRank();
      int cardRank = card.getRank();

      if(thisRank==cardRank-1){
        return 1;
      }
      else if(thisRank == cardRank){
        return 0;
      }
      else{
        return -1; //card1Rank = card2Rank+1
      }
    }
  }
