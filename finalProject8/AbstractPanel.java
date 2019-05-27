/**
 * File Name: AbstractPanel.java
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


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


abstract public class AbstractPanel<Card> extends JPanel implements ViewInformer{
  protected Card card;
  protected CellInterface<Card> drawCell;
  protected ViewInformer view;


  /**
  *This is the first construcctor in the chain of constructors that handles an innstantiation with a card parameter,
  *sufficing the proteccted instantiations of the panel and card
  */
  public AbstractPanel(CellInterface<Card> cell, ViewInformer view){//AskLambert: don't forget to support entire cells and not just the first card
    this.drawCell = cell;
    this.view = view;
    this.addMouseListener(new PanelListener());

    if(cell.size() != 0){
      this.card = cell.get(cell.size()-1);
    }
    setBackground(Color.green);

  }

  public CellInterface<Card> getCell(){
    return drawCell;
  }

  /**
   * Resets the panel's card and refreshes the panel.
   * @param c the card to be displayed.
   */
  public void setCard(Card c){
    card = c;
    repaint();
  }

  /**
   * Gets the card
   * @return card
   */
  public Card getCard(){
    return card;
  }

  /**
   * Analyzes press of Panel
   */
  public void panelPressed(AbstractPanel panel){
    view.panelPressed(this);
  }

  /**
   * Paints the card's face image if a card is present, otherwise, paints the back side image.
   */
   abstract public void paintComponent(Graphics g);

   /**
    * Functionality for mouse mousePressed
    */
   private class PanelListener extends MouseAdapter {
    public void mousePressed(MouseEvent e){
      view.panelPressed(AbstractPanel.this);
    }
  }
}
