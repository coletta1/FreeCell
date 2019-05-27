import javax.swing.JFrame;
import java.awt.*;
import propackage.Deck;

/**
 * File Name: FreeCellApp.java
 * Description: Creates an implementation of the methods used by the cell classes
 * @author Rohan Jairam
 * @author Mohini Tangri
 * @author Alexander Caines
 * @author Mickey Brown
 * @author Coletta Fuller
 * @version 1.0
 *Date 11/14/2018
 */
public class FreeCellApp{

    public static void main(String[] args){
        final JFrame view = new MainView();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setBackground(Color.GREEN);
        view.setSize(900, 600);
        view.setVisible(true);
    }
}
