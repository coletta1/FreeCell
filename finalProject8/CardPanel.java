import propackage.*;


import javax.swing.*;
import java.awt.*;

/**
 * Represents the GUI component for painting an image of a playing card.
 * @author lambertk
 *
 */
public class CardPanel extends AbstractPanel{
    CellInterface<Card> drawCell;

    /**
     * Constructor to display a given card's image.
     * @param c the card to display.
     */

    public CardPanel(CellInterface<Card> c){
      this(c, null);
    }

    /**
     * Constructor for an empty panel, displays a wire frame.
     */
    public CardPanel(CellInterface<Card> c, ViewInformer view){
        super(c, view);
        this.drawCell = c;
        repaint();
    }




    /**
     * Paints the card's face image if a card is present, otherwise, paints the back side image.
     */
    public void paintComponent(Graphics g){
    	Icon image;
    	if (this.drawCell.size() == 0){
    		image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
    	}
    	else{
        Card currentCard = drawCell.peek();
    		image = currentCard.getImage();
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
    		image.paintIcon(this, g, x, y);
    	}
    }



}
