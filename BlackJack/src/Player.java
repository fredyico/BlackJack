import java.util.ArrayList;					//imported java library
import javax.swing.ImageIcon;				//imported java library

public class Player {
	
	public ArrayList<Card> hand = null; // dinamyc array	
	
	public int money;					//defining money as an integer 
	
	public void clearHand() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public void clearhand 
		// Method parameters	:	-
		// Method return		:	none
		// Synopsis				:   This method cleans the player/dealer hand by defining a new arraylist of card to the hand  
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		this.hand = new ArrayList<Card>(); //clean the player/dealer hand by defining a new arraylist of card to the hand  
	}
	
	public Player() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public player
		// Method parameters	:	-
		// Method return		:	none
		// Synopsis				:   This method creates the information to the player (money)
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		this.money = 100;	//defining the amount of money players start the game
	}
	
	public int bet() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public int bet
		// Method parameters	:	-
		// Method return		:	int 0 or 10
		// Synopsis				:   This method creates the function to make a bet
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		if (this.money >= 10) {				//conditional statement checking if there is more money or equal than 10 in the player's wallet 
			this.money = this.money - 10;	//bet will update the value from 10 to 10 - subtracting the total to put into the betting pot
			return 10;						//return 10, to put 10 to the betting pot 
		}
		return 0;							//return 0, if there is no money left
	}
	
	public void hit(Card pCard) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public void hit (card pCard)
		// Method parameters	:	-
		// Method return		:	-
		// Synopsis				:   This method creates the hit function to add a card to the hand
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		hand.add(pCard);		//function to add a card to the hand
	}
	
	public int getMoney() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public int get money()
		// Method parameters	:	-
		// Method return		:	int this money
		// Synopsis				:   This method define that getmoney will get it from this.money
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		
		return this.money;		//defining that getmoney method will return back it from this.money
	}
	
	public int plScoreHand() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public int plScoreHand()
		// Method parameters	:	-
		// Method return		:	int (handScoreCountage)
		// Synopsis				:   This method define the hand card Value of player
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		int handScoreCountage = 0;			//defininf handscorecountage as an inteter with initial value of 0
		boolean playerHandHasAce = false;	//boolean to check if player hand has an AC (and the value of the Ace)
		
		for (int plC = 0; plC < hand.size(); plC++) {								//loop to compose player hand
			handScoreCountage = handScoreCountage + hand.get(plC).getCardValue();	//updating player score hand value
			if (hand.get(plC).isAce()) {			//conditional statement to check if in player hand has an Ace
				playerHandHasAce = true;			//if it has, return true
			}
		}
		if (playerHandHasAce && handScoreCountage <= 11) {		//conditional statement to determine value of Ace as +10
			handScoreCountage = handScoreCountage +10;			//updating the value of handscore countage
		}		
		return handScoreCountage;								//returning the new value of handscore countage
	}
	
	public int sizeHand() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public int sizehand
		// Method parameters	:	-
		// Method return		:	int hand.size()
		// Synopsis				:   This method define the hand card Value of player
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		return hand.size();		//method to return to size of the hand of players
	}	
	
	public ImageIcon getCard(int position) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public imageicon get card
		// Method parameters	:	int position
		// Method return		:	card.getbackimage
		// Synopsis				:   This method get a card image to a determined position
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		if (hand.size() > position) {					//conditional statement checking if hand size is greater than position
			return hand.get(position).getImage();		//if it is, return the image to the position
		}
		else {											//if it is not, 
			return Card.getBackImage();					//return the back of the image card
		}
	}
}
