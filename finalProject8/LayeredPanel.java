
/**
 * File Name: LayeredPanel.java
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

 import javax.swing.*;
 import java.awt.*;
 import java.util.ArrayList;

public class LayeredPanel extends AbstractPanel{
    CellInterface<Card> drawCell;
    /**
     * Constructor to display a given card's image.
     * @param cell the card to display.
     */
    public LayeredPanel(CellInterface<Card> cell){
      this(cell, null);
    }


    public LayeredPanel(CellInterface<Card> cell, ViewInformer view){
      super(cell, view);
      this.drawCell = cell;
      repaint();
    }


    /**
     * Paints the card's face image if a card is present, otherwise, paints the back side image.
     */
    public void paintComponent(Graphics g){
    	//super.paintComponent(g);
    	Icon image;
    	if (this.drawCell.size() == 0){
    		image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = ((getHeight() - image.getIconHeight()) / 2)-100;
    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
    	}
    	else{
        int offset = 0;
        for (int i = 0; i < this.drawCell.size(); i++){
          Card currentCard = drawCell.get(i);
          image = currentCard.getImage();

          int x = (getWidth() - image.getIconWidth()) / 2;
          int y = ((getHeight() - image.getIconHeight()) / 2)-100;
          offset=offset+20;
          image.paintIcon(this, g, x, y + offset);
        }
    	}
    }


}
