/**
 * File Name: MainView.java
 * Description: Creates an implementation of the methods used by the cell classes
 * @author Rohan Jairam
 * @author Mohini Tangri
 * @author Alexander Caines
 * @author Mickey Brown
 * @author Coletta Fuller
 * @version 1.0
 * Date 12/7/2018
 */

import javax.swing.*;

import propackage.*;
import java.io.*;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.PrintWriter;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MainView extends JFrame{
	private ViewInformer view;
	private AbstractPanel fromPanel;
	private Game game = new Game();
	private JFrame frame = new JFrame();
	private CellInterface<Card> currentCell;
	private CellInterface<Card> toCell;
	private int x;
	private int y;
	private JLabel moveLabel;

		/**
     * Constructs the main view
	   * with card panels and new game button.
     */
    public MainView(){
			final AppViewInformer view = new AppViewInformer();

			Container pane = getContentPane();
			pane.setLayout(new GridBagLayout());
			pane.setBackground(new java.awt.Color(100, 166, 166));
			GridBagConstraints constraints = new GridBagConstraints();
			fromPanel = null;

			//Creates labels and buttons
			JLabel freeLabel = new JLabel("Free Cells");
			constraints.gridwidth = 4;
			constraints.gridx = 0;
			constraints.gridy = 0;
			pane.add(freeLabel, constraints);

			JLabel homeLabel = new JLabel("Home Cells");
			constraints.gridx = 4;
			pane.add(homeLabel, constraints);
			moveLabel = new JLabel("Moves: " + game.getMoveCounter());
			constraints.gridx=2;
	    pane.add(moveLabel, constraints);

			JButton newGame = new JButton("New Game");
			constraints.gridx=1;
	    constraints.gridy=3;
	    constraints.gridwidth=4;
			//constraints.fill = GridBagConstraints.HORIZONTAL;
	    pane.add(newGame, constraints);

			JButton saveGame = new JButton("Save");
			constraints.gridx=2;
			//pane.add(saveGame, constraints);

			JButton loadGame = new JButton("Load Game");
			constraints.gridx=3;
			//pane.add(loadGame, constraints);

			JButton changeBackground = new JButton("Change Background");
			constraints.gridx=3;
			pane.add(changeBackground, constraints);

			newGame.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
						game.newGame();
						repaint();
				}
			});

			saveGame.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					File file = new File("FileGameState.txt");
					try{
						PrintWriter printWriter = new PrintWriter("FileGameState.txt");

						for(int i =0;i<8;i++){
							CellInterface<Card> tableau = game.tableauGet(i);
							for(int j=0;j<tableau.size();j++){
								//writing
								printWriter.println(tableau.get(j));
							}
							printWriter.println();
						}

						for(int i =0;i<4;i++){
							CellInterface<Card> home = game.homeGet(i);
							printWriter.println();
							for(int j=0;j<home.size();j++){
								//writing
								printWriter.print(home.get(j));
							}
							printWriter.println();

						}
						for(int i =0;i<4;i++){
							CellInterface<Card> free = game.freeGet(i);
							printWriter.println();
							for(int j=0;j<free.size();j++){
								//writing
								printWriter.print(free.get(j));
							}
							printWriter.println();

						}
						printWriter.close();

					}
					catch (FileNotFoundException ex){
						System.out.println(ex);
					}
				}
			});

			loadGame.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int cellCount =0;
					// game.newGame();
					// repaint();
					Card card = new Card(Suit.spade, 1);
					try{
						BufferedReader in = new BufferedReader(new FileReader("FileGameState.txt"));

						ArrayList<Card> freeList = new ArrayList<Card>();
						ArrayList<Card> homeList = new ArrayList<Card>();
						ArrayList<Card> tableauList = new ArrayList<Card>();
						ArrayList<Card> tempList = new ArrayList<Card>();

						ArrayList<ArrayList<Card>> freeCellList = new ArrayList<ArrayList<Card>>();
						ArrayList<ArrayList<Card>> homeCellList = new ArrayList<ArrayList<Card>>();
						ArrayList<ArrayList<Card>> tableauCellList = new ArrayList<ArrayList<Card>>();

						String line = in.readLine();
						if(line == ""){
							cellCount++;
							if(cellCount<8){
								for(int i = tempList.size()-1;i>-1;i--){
									tableauList.add(tempList.get(i));
								}
								tableauCellList.add(tableauList);
								tableauList.clear();
							}
							else if(cellCount<12){
								for(int i = tempList.size()-1;i>-1;i--){
									freeList.add(tempList.get(i));
								}
								freeCellList.add(freeList);
								freeList.clear();
							}
							else if(cellCount<16){
								for(int i = tempList.size()-1;i>-1;i--){
									homeList.add(tempList.get(i));
								}
								homeCellList.add(homeList);
								homeList.clear();
							}
							//go to the next cell
						}
						else{
							StringTokenizer tk =new StringTokenizer(line);
							String rank = tk.nextToken();
							int rrank = 0;
							String garbage =tk.nextToken();
							String suit = tk.nextToken();
							if(suit=="diamonds"){
								if(rank=="King"){
									rrank = 13;
								}
								if(rank=="Queen"){
									rrank = 12;
								}
								if(rank=="Ace"){
									rrank = 1;
								}
								if(rank=="Jack"){
									rrank = 11;
								}
								card = new Card(Suit.diamond, rrank);
							}
							if(suit=="hearts"){
								if(rank=="King"){
									rrank = 13;
								}
								if(rank=="Queen"){
									rrank = 12;
								}
								if(rank=="Ace"){
									rrank = 1;
								}
								if(rank=="Jack"){
									rrank = 11;
								}
								card = new Card(Suit.heart, rrank);
							}
							if(suit=="clubs"){
								if(rank=="King"){
									rrank = 13;
								}
								if(rank=="Queen"){
									rrank = 12;
								}
								if(rank=="Ace"){
									rrank = 1;
								}
								if(rank=="Jack"){
									rrank = 11;
								}
								card = new Card(Suit.club, rrank);
							}
							if(suit=="spades"){
								if(rank=="King"){
									rrank = 13;
								}
								if(rank=="Queen"){
									rrank = 12;
								}
								if(rank=="Ace"){
									rrank = 1;
								}
								if(rank=="Jack"){
									rrank = 11;
								}
								card = new Card(Suit.spade, rrank);
							}

							tempList.add(card);
						}



					}
					catch(IOException ex){
						System.out.println("Could not find file "+ex);
					}
				}


			});




			game.dealCards();


			constraints.gridx = 0;
			constraints.gridy = 1;

			// Free cells
			constraints.fill = GridBagConstraints.BOTH;
	    constraints.weightx = 50;
	    constraints.weighty = 50;
	    constraints.gridx = 0;
    	constraints.gridy = 1;
    	constraints.gridwidth = 1;
			for(int i =0; i < 4; i++){
				CellInterface<Card> cell = game.freeGet(i);
				CardPanel panel = new CardPanel(cell, view);
				pane.add(panel, constraints);
				constraints.gridx++;
			}

			//Home cells
			for(int i =0; i < 4; i++){
				CellInterface<Card> cell = game.homeGet(i);
				CardPanel panel = new CardPanel(cell, view);
				pane.add(panel, constraints);
				constraints.gridx++;
			}


			//Tableaux
			constraints.gridx = 0;
	    constraints.weighty = 100;
	    constraints.weightx = 100;
    	constraints.gridy = 2;
			for(int i =0; i < 8; i++){
				CellInterface<Card> cell = game.tableauGet(i);
				LayeredPanel icon = new LayeredPanel(cell, view);
					pane.add(icon, constraints);
					constraints.gridx++;
			}


			changeBackground.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Random rand = new Random();
					pane.setBackground(new java.awt.Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
				}
			});


		}

		private class AppViewInformer implements ViewInformer{
			/**
			 * This method analyzes the press of a panel.
			 */
			 public void panelPressed(AbstractPanel panel){
 						// if (game.hasLoser()) {
 						// 	JOptionPane.showMessageDialog(frame, "You have lost :(");
 						// }
 						if(fromPanel == null){
 							fromPanel = panel;
 						}
    				else if (fromPanel == panel) {
							/* Way to implement the double click feature, can't figure out better way but am trying to move it to tableau*/
 // 							if (fromPanel == panel) {
 // 								CellInterface<Card> fromCell = fromPanel.getCell();
 // 								Card fromCard = fromCell.get(fromCell.size()-1);
 // 								for(int i =0;i<=3;i++){
 // 								CellInterface<Card> checkHome = game.homeGet(i);
 //
 // 								if(checkHome.canMoveFrom(fromCell)){
 // 									fromCell.remove(fromCard);
 // 									checkHome.add(fromCard);
 // 								}
 // }
  								fromPanel = null;
							}
 							else {
 							CellInterface<Card> fromCell = fromPanel.getCell();
 							CellInterface<Card> currentCell = panel.getCell();



 									if(game.gameMove(fromCell, currentCell)){

										moveLabel.setText("Move: "+game.getMoveCounter());
 										repaint();


 									}
 									else{
 										JOptionPane.showMessageDialog(frame, "Illegal move");
 									}


 								fromPanel = null;

 								if(game.hasWinner()){
 									JOptionPane.showMessageDialog(frame, "You have won!");
 								}
 								// else if(game.hasLoser()){
 								// 	JOptionPane.showMessageDialog(frame, "You have no more moves");
 								// 	fromPanel = null;
 								// }
 								}
 							}
 							//repaint();
 						}



 			}
