import javax.swing.JOptionPane;					//imported java library
import javax.swing.border.Border;				//imported java library
import java.awt.EventQueue;						//imported java library
import javax.swing.JFrame;						//imported java library
import javax.swing.BorderFactory;				//imported java library
import javax.swing.JButton;						//imported java library
import java.awt.Color;							//imported java library
import javax.swing.JLabel;						//imported java library
import java.awt.event.ActionListener;			//imported java library
import java.awt.event.ActionEvent;				//imported java library

public class BlackJ extends JFrame {
	private Player player; // defining global private variable
	private Player dealer; // defining global private variable
	private Deck deck; // defining global private variable
	private JLabel lblP_Money; // defining global private variable
	private JLabel lblD_Money; // defining global private variable
	private JLabel lblPot; // defining global private variable
	private int pot; // defining global private variable
	private int round = 0; // defining global private variable
	private int turn = 0; // defining global private variable
	private JButton btnBet; // defining global private variable
	private JButton btnHIT; // defining global private variable
	private JButton btnSTAY; // defining global private variable
	private JLabel lblPCard1; // defining global private variable
	private JLabel lblPCard2; // defining global private variable
	private JLabel lblPCard3; // defining global private variable
	private JLabel lblPCard4; // defining global private variable
	private JLabel lblPCard5; // defining global private variable

	private JLabel lblDeCard1; // defining global private variable
	private JLabel lblDeCard2; // defining global private variable
	private JLabel lblDeCard3; // defining global private variable
	private JLabel lblDeCard4; // defining global private variable
	private JLabel lblDeCard5; // defining global private variable
	public boolean bust = false; // defining global public variable

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackJ frame = new BlackJ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BlackJ() {

		Border blackline = BorderFactory.createLineBorder(Color.black); // blackjack border design
		getContentPane().setBackground(new Color(34, 139, 34)); // blackjack color
		setBounds(100, 100, 946, 562); // defining bounds of BlackJack game
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // defining close operation of BlackJack game
		getContentPane().setLayout(null); // defining

		btnHIT = new JButton("HIT"); // defining button HIT
		btnHIT.setBounds(10, 331, 85, 21); // setting bounds of button HIT
		getContentPane().add(btnHIT); // defining button content - HIT.
		btnHIT.addActionListener(new ActionListener() { // Defining action to HIT button
			public void actionPerformed(ActionEvent arg0) {

				if (turn == 0) {
					if (lblPCard3.getIcon() == null) { // Verifies if the third label has a card on it
						player.hit(deck.getCard()); // If it does not have, set it
						lblPCard3.setIcon(player.getCard(2)); // and display it

					} else if (lblPCard4.getIcon() == null) { // Verifies if the fourth label has a card on it
						player.hit(deck.getCard()); // If it does not have, set it
						lblPCard4.setIcon(player.getCard(3)); // and display it
					} else {
						player.hit(deck.getCard()); // If it does not have, set it
						lblPCard5.setIcon(player.getCard(4)); // and display it
						btnHIT.setEnabled(false);	//disable button hit
					}
				} else {
					if (lblDeCard3.getIcon() == null) { // Verifies if the third label has a card on it
						dealer.hit(deck.getCard()); // If it does not have, set it
						lblDeCard3.setIcon(dealer.getCard(2)); // and display it
					} else if (lblDeCard4.getIcon() == null) { // Verifies if the fourth label has a card on it
						dealer.hit(deck.getCard()); // If it does not have, set it
						lblDeCard4.setIcon(dealer.getCard(3)); // and display it
					} else {
						dealer.hit(deck.getCard()); // If it does not have, set it
						lblDeCard5.setIcon(dealer.getCard(4)); // and display it
					}
				}
				compareHands(); // method to check and compare hands from both players
			}
		});

		btnSTAY = new JButton("STAY"); // defining button STAY
		btnSTAY.setBounds(10, 285, 85, 21); // setting bounds of button STAY
		getContentPane().add(btnSTAY); // defining button content - STAY
		btnSTAY.addActionListener(new ActionListener() { // Defining action to STAY button
			public void actionPerformed(ActionEvent arg0) {
				if (turn == 0) {	//conditional state to check if player click button stay in turn 0,  
					dealersTurn();	//it will be dealer's time to play and check for it's action
				} else {	//if player did not click in stay button, must be case of blackjack for one of them or both
					compareHands();	//compare hands to check for blackjack
					btnSTAY.setEnabled(false);	//disable stay button
					btnHIT.setEnabled(false);	//disable hit button
				}
			}
		});

		lblP_Money = new JLabel("Player Money:"); // defining label Player Money
		lblP_Money.setBounds(10, 107, 116, 36); // setting bounds of label player money
		getContentPane().add(lblP_Money); // defining label content - Player money
		lblP_Money.setBorder(blackline); // defining label border - Player money

		lblD_Money = new JLabel("Dealer Money:"); // defining label Dealer Money
		lblD_Money.setBounds(10, 61, 116, 36); // setting bounds of label Dealer money
		getContentPane().add(lblD_Money); // defining label content - Dealer money
		lblD_Money.setBorder(blackline); // defining label border - Dealer money

		lblPot = new JLabel("Pot: 0"); // defining label Pot
		lblPot.setBounds(10, 153, 116, 58); // setting bounds of label Pot
		getContentPane().add(lblPot); // defining label content - Pot
		lblPot.setBorder(blackline); // defining label border - Pot

		btnBet = new JButton("BET");	// defining button BET
		btnBet.setBounds(10, 372, 85, 21);	// setting bounds of button BET
		getContentPane().add(btnBet);	// defining button content - BET
		btnBet.addActionListener(new ActionListener() {	// Defining action to BET button
			public void actionPerformed(ActionEvent arg0) {
				pot = pot + player.bet();	//defining and updating values of pot variable with player.bet() 
				pot = pot + dealer.bet();	//defining and updating values of pot variable with dealer.bet()
				lblPot.setText("Pot: " + pot);	//label pot text to be displayed
				displayMoney();	//method to display money of each players
				startRound(); // starting round Joption pane message

				btnHIT.setEnabled(true); // enabling others button to be pressed
				btnSTAY.setEnabled(true); // enabling others button to be pressed
				btnBet.setEnabled(false); // enabling bet button to be pressed
				compareHands();	//method with win condition state and logic to compare both hands

			}
		});

		lblPCard1 = new JLabel("");	//label Player Card 1 defined as a new label with a blank text
		lblPCard1.setBounds(140, 340, 80, 123);	// setting bounds of label Player Card 1
		getContentPane().add(lblPCard1);	// defining label content - Player Card 1 
		lblPCard1.setBorder(blackline);	// defining label border - Player Card 1

		lblPCard2 = new JLabel("");	//label Player Card 2 defined as a new label with a blank text
		lblPCard2.setBounds(240, 340, 80, 123);	// setting bounds of label Player Card 2
		getContentPane().add(lblPCard2);	// defining label content - Player Card 2 
		lblPCard2.setBorder(blackline);	// defining label border - Player Card 2

		lblPCard3 = new JLabel("");	//label Player Card 3 defined as a new label with a blank text
		lblPCard3.setBounds(340, 340, 80, 123);	// setting bounds of label Player Card 3
		getContentPane().add(lblPCard3);	// defining label content - Player Card 3
		lblPCard3.setBorder(blackline);	// defining label border - Player Card 3

		lblPCard4 = new JLabel("");	//label Player Card 4 defined as a new label with a blank text
		lblPCard4.setBounds(440, 340, 80, 123);	// setting bounds of label Player Card 4
		getContentPane().add(lblPCard4);	// defining label content - Player Card 4 
		lblPCard4.setBorder(blackline);	// defining label border - Player Card 4

		lblPCard5 = new JLabel("");	//label Player Card 5 defined as a new label with a blank text
		lblPCard5.setBounds(540, 340, 80, 123);	// setting bounds of label Player Card 5
		getContentPane().add(lblPCard5);	// defining label content - Player Card 5 
		lblPCard5.setBorder(blackline);	// defining label border - Player Card 5

		lblDeCard1 = new JLabel("");	//label Dealer Card1 defined as a new label with a blank text
		lblDeCard1.setBounds(140, 50, 80, 123);	// setting bounds of label Dealer Card 1
		getContentPane().add(lblDeCard1);	// defining label content - Dealer Card 1 
		lblDeCard1.setBorder(blackline);	// defining label border - Dealer Card 1

		lblDeCard2 = new JLabel("");	//label Dealer Card2 defined as a new label with a blank text
		lblDeCard2.setBounds(240, 50, 80, 123);	// setting bounds of label Dealer Card 2
		getContentPane().add(lblDeCard2);	// defining label content - Dealer Card 2
		lblDeCard2.setBorder(blackline);	// defining label border - Dealer Card 2

		lblDeCard3 = new JLabel("");	//label Dealer Card3 defined as a new label with a blank text
		lblDeCard3.setBounds(340, 50, 80, 123);	// setting bounds of label Dealer Card 3
		getContentPane().add(lblDeCard3);	// defining label content - Dealer Card 3
		lblDeCard3.setBorder(blackline);	// defining label border - Dealer Card 3

		lblDeCard4 = new JLabel("");	//label Dealer Card4 defined as a new label with a blank text
		lblDeCard4.setBounds(440, 50, 80, 123);	// setting bounds of label Dealer Card 4
		getContentPane().add(lblDeCard4);	// defining label content - Dealer Card 4
		lblDeCard4.setBorder(blackline);	// defining label border - Dealer Card 4

		lblDeCard5 = new JLabel("");	//label Dealer Card5z defined as a new label with a blank text
		lblDeCard5.setBounds(540, 50, 80, 123);	// setting bounds of label Dealer Card 5
		getContentPane().add(lblDeCard5);	// defining label content - Dealer Card 5
		lblDeCard5.setBorder(blackline);// defining label border - Dealer Card 5

		displayWelcome();		//display a welcome message before the starting round
		player = new Player(); // create the Player
		dealer = new Player(); // create the Dealer
		btnHIT.setEnabled(false);	//disabling button Hit until button BET has been used once
		btnSTAY.setEnabled(false);	//disabling button Stay until button BET has been used once

	}

	private void compareHands() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	private void comparehands
	// Method parameters	:	-
	// Method return		:	none
	// Synopsis				:   This method compare player hands with dealer hands and create the win condition state
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-04-05		F. F. Beckedorff		Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		int p = player.plScoreHand();	//definition of p as an integer and as the player's sum of Value Cards 
		int d = dealer.plScoreHand();	//definition of d as an integer and as the dealer's sum of Value Cards
		int win_condition = 0; // 0 condition: no round winners; 1 = player wins the round; 2 = dealer wins the
								// round; 3 = it is a draw for the round.

		if (round == 0) {		//conditional state for round 0 (checking if player or dealer has blackjack at the start of the game
			if (p == 21) {		//conditional state (checking if player has blackjack at the start of the game)
				if (d == 21) {	//conditional state (checking if player AND dealer has blackjack at the start of the game)
					JOptionPane.showMessageDialog(null, "It is a Draw!");	//result a message of draw
					win_condition = 3; // draw condition - return money back to player and dealer

				} else {	//conditional state for round 0 when player has blackjack and dealer does not have, at the start of the game
					JOptionPane.showMessageDialog(null, "Player wins!");	//result a message of player win
					win_condition = 1; // condition 1 = player wins the round
				}
			} else if (d == 21) {	//conditional state for round 0 when dealer has blackjack and player does not have, at the start of the game
				JOptionPane.showMessageDialog(null, "Dealer wins!");	//result a message of dealer win
				win_condition = 2; // condition 2 = dealer wins the round
			}
		} else if (turn > 1) {		//conditional state for round 1, after round 0 with no blackjack (label 3 and 4 of player and dealer cards)

			if (p == 21) { // player made a 21 out of 1st round
				if (d == 21) { // dealer made a 21 out of 1st round
					JOptionPane.showMessageDialog(null, "It is a Draw!"); // it is a draw, both have 21
					win_condition = 3; // draw condition - return money back to player and dealer

				} else {
					JOptionPane.showMessageDialog(null, "Player wins!"); // only player made a 21 out of 1st wound
					win_condition = 1; // condition 1 = player wins the round
				}
			} else if (d == 21) { // dealer made a 21 out of 1st round
				JOptionPane.showMessageDialog(null, "Dealer wins!"); // dealer wins the round
				win_condition = 2; // condition 2 = dealer wins the round
			} else if (player.sizeHand() == 5 && p < 21) { // Charlie comparing situation
				if (dealer.sizeHand() == 5 && d < 21) { // Charlie comparing situation
					JOptionPane.showMessageDialog(null, "Both had a Charlie! It is a Draw!");// Charlie comparing
					win_condition = 3; // draw condition - return money back to player and dealer // situation

				} else {
					JOptionPane.showMessageDialog(null, "It is Charlie! Player Wins!");// Charlie comparing situation
					win_condition = 1; // condition 1 = player wins the round
				}
			} else if (dealer.sizeHand() == 5 && d < 21) {// Charlie comparing situation
				JOptionPane.showMessageDialog(null, "It is Charlie! Dealer Wins!");// Charlie comparing situation
				win_condition = 2; // condition 2 = dealer wins the round
			} else if (d > 21) {	//conditional situation when dealer has more than 21 score value
				JOptionPane.showMessageDialog(null, "Dealer busted! Player Wins!");	// dealer exceeded 21, player wins
				win_condition = 1; // condition 1 = player wins the round
			}
			if (turn == 3) {	// conditions to proceed in round 3 (label 5 of player and dealer cards)
				if (p > d) {	//conditional win state, when p score is greater than d score 
					JOptionPane.showMessageDialog(null, "Player Wins!");	//message displayed of player win
					win_condition = 1;	//achieve of win condition 1 - player win
				} else if (p < d) {	//conditional win state, when p score is less than d score 
					JOptionPane.showMessageDialog(null, "Dealer Wins!");	//message displayed of dealer win
					win_condition = 2;	//achieve of win condition 2 - dealer win
				} else {
					JOptionPane.showMessageDialog(null, "It's a Draw!");	//message displayed of a draw
					win_condition = 3;	//achieve of (!win) condition 3 - draw
				}
			}

		} else {
			if (p > 21) {	//conditional situation when player has more than 21 score value
				JOptionPane.showMessageDialog(null, "Player busted! Dealer Wins!");	// player exceeded 21, dealer wins, player loses
				win_condition = 2; // condition 2 = dealer wins the round
			}
		}

		round++; // increase the number round by 1

		if (win_condition > 0) {	//conditional state for when someone wins the round, or draw (3) 
			calculateMoney(win_condition); // method to calculate the money and check if there is a game winner (P.money
											// or D.money = 0)

			clearTable(); // method to clear the table and start a new round

			if (player.getMoney() <= 0 || dealer.getMoney() <= 0) {	//conditional state for an end game
				gameOver(win_condition);			//method for an end game with the win condition parameter
			} else {	//condition if the end game has not been achieved - continue to the next match
				btnBet.setEnabled(true);	//bet button enabled
				displayMoney();				//display money amount for both players
				btnHIT.setEnabled(false);	//hit button disabled
				btnSTAY.setEnabled(false);	//stay button disabled
			}

		}

	}

	private void gameOver(int option) { // finishing the game condition: 1 - dealer get 0 money; 2 - player get 0 money
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	private void game over
		// Method parameters	:	int option
		// Method return		:	none
		// Synopsis				:   This method stablish the end game condition and display the end game message 
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		if (option == 1) {			//conditional state for option 1 = when player wins the game (leading dealer with no money left)
			JOptionPane.showMessageDialog(null, "Congratulations, Player wins the game!"); // end game message
		} else if (option == 2) {	//conditional state for option 2 = when dealer wins the game (leading player with no money left)
			JOptionPane.showMessageDialog(null, "that's too bad, Dealer wins the game!"); // end game message
		}

		System.exit(0); // finish the application
	}

	private void clearTable() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	private void clear table
		// Method parameters	:	
		// Method return		:	none
		// Synopsis				:   This method establishes a function to clear data from the label's of the table so the game can reset with no values previously stored 
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=


		lblPCard1.setIcon(null); // reseting the display value of the pot
		lblPCard2.setIcon(null); // defining global private variable
		lblPCard3.setIcon(null); // defining global private variable
		lblPCard4.setIcon(null); // defining global private variable
		lblPCard5.setIcon(null); // defining global private variable

		lblDeCard1.setIcon(null); // defining global private variable
		lblDeCard2.setIcon(null); // defining global private variable
		lblDeCard3.setIcon(null); // defining global private variable
		lblDeCard4.setIcon(null); // defining global private variable
		lblDeCard5.setIcon(null); // defining global private variable

		lblPot.setText("Pot: 0"); // reseting the display value of the pot
		pot = 0; // clear the current state of the Pot
		turn = 0;	//defining an initial value to turn
		round = 0;	//defining an initial value to round 

	}

	private void calculateMoney(int option) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	private void clear table
		// Method parameters	:	
		// Method return		:	none
		// Synopsis				:   This method establishes a function to clear data from the label's of the table so the game can reset with no values previously stored 
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=


		if (option == 1) {	//conditional state for option 1 = when player wins the round (leading him to sum his current money with the bet in the pot)	
			player.money = player.money + pot;		//function do define and update player money
		} else if (option == 2) {	//conditional state for option 2 = when dealer wins the round (leading him to sum his current money with the bet in the pot)
			dealer.money = dealer.money + pot;		//function do define and update dealer money
		} else if (option == 3) {	//conditional state for option 3 = when no player wins the round - a draw (leading the pot to be splitter and giving back to their correspondent owner)
			dealer.money = dealer.money + pot / 2;	//function do define and update dealer money
			player.money = player.money + pot / 2;	//function do define and update player money
		}
	}

	public static void displayWelcome() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public static void display welcome
		// Method parameters	:	
		// Method return		:	none
		// Synopsis				:   This method display a welcome message before the start of the first round of the gane 
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		JOptionPane.showMessageDialog(null, "Welcome to BlackJack.v1 ");	//function to show in a dialog box a welcome message
	}

	private void startRound() { // starting round Joption pane message function
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	private void startRound
		// Method parameters	:	
		// Method return		:	none
		// Synopsis				:   This method initiate every new round after the 1st, implementing the shuffle of the deck, tablecleaner and disable buttons
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=


		player.clearHand(); // clear the hand of player
		dealer.clearHand(); // clear the hand of dealer
		deck = new Deck(); // create the Deck
		deck.shuffle(); // shuffle the deck to start a (new) round
		displayMoney(); // show amount money players (player and dealer) have
		btnBet.setEnabled(true);	//enabling button bet
		player.hit(deck.getCard()); // function to choose to press hit and get another card
		player.hit(deck.getCard()); // function to choose to press hit and get another card
		dealer.hit(deck.getCard()); // function to choose to press hit and get another card
		dealer.hit(deck.getCard()); // function to choose to press hit and get another card
		displayHand(); // function to show the cards of hand
		JOptionPane.showMessageDialog(null, "Starting round"); // starting round Joption pane message
		btnHIT.setEnabled(false);	//disabling button hit until bet has been clicked
		btnSTAY.setEnabled(false);	//disabling button stay until bet has been clicked
		turn = 0;	//defining turn equals zero
	}

	private void displayMoney() { // function to display money from player and dealer
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	private void display money
		// Method parameters	:	
		// Method return		:	none
		// Synopsis				:   This method sets the text to display money for player and dealer
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
		lblP_Money.setText("Player Money: " + player.getMoney()); // label to display money from player (P)
		lblD_Money.setText("Dealer Money: " + dealer.getMoney()); // label to display money from dealer (D)
	}

	private void displayHand() { // function to display hand of player and dealer
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	private void display hand
		// Method parameters	:	
		// Method return		:	none
		// Synopsis				:   This method sets the icon to display cards image to the label of  player and dealer
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		
		lblPCard1.setIcon(player.getCard(0)); // setting the label to show 1st card of the player
		lblPCard2.setIcon(player.getCard(1)); // setting the label to show 2nd card of the player

		lblDeCard1.setIcon(dealer.getCard(0)); // setting the label to show 1st card of the dealer
		lblDeCard2.setIcon(dealer.getCard(1)); // setting the label to show 2nd card of the dealer
	}

	private void dealersTurn() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	private void dealers turn
		// Method parameters	:	
		// Method return		:	none
		// Synopsis				:   This method set the decision making of dealer's turn
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=


		boolean finished = false;		//set finished as a boolean equal to false 
		turn = 2;		// set turn = 2
		while (!finished) {		//loop statement while finished is not true
			int dealer_cards = dealer.plScoreHand(); // updating number of dealer cards and dealers card values

			if (dealer_cards > 21) {	//conditional state when dealer has more than 21 card value
				finished = true;		//set finished = true - dealer busted
			} else if (dealer.sizeHand() == 5) {	//conditional state when dealer hand has 5 cards
				finished = true;		//set finished = true - dealer can't hit anymore
			} else if (dealer.sizeHand() < 5) {	//conditional state when dealer hand has less than 5 cards	
				if (dealer_cards < 18 && dealer_cards < player.plScoreHand()) {	//conditional state when dealer's card value is less than 18 AND dealer's card value is less than player's card value
					btnHIT.doClick(); //dealer execute the hit button function
				} else {	//if not met those conditions
					finished = true;	// finished is true and finishes the loop
				}
			}
		}
		turn = 3;	//defining turn = 3 after the looping
		btnSTAY.doClick();	//dealer execute the stay button function to compare hands the last time
	}
}
