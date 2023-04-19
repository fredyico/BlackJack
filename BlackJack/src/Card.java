import java.awt.Image;						//import image
import javax.swing.ImageIcon;				//import Image Icon (cards)

public class Card {
	
	
	private String [] valueCArray = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};	//defining an array of values for the cards
	
	private String [] suitArray = {"S", "C", "H", "D"};	//defining an array of suits for the cards
	
	private int suit;		// defining suits as an integer
	private int valueC;		// defining valueC as an integer
	
	public Card(int suit, int valueC) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public Card
		// Method parameters	:	int suit, int ValueC
		// Method return		:	none
		// Synopsis				:   This class determine what composes the variable Card - int suit and int valueC
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		this.suit = suit;				//defining variable suit
		this.valueC = valueC;			//defining variable ValueC
	}
	
	public boolean isAce () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public boolean Ace
		// Method parameters	:	-
		// Method return		:	true or false
		// Synopsis				:   This method is to check if in the array position 0, is an Ace
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		if (this.valueC == 0) {			//conditional to check if valueC position in the Array = 0 (Ace)  
			return true;				//if is an Ace, return true
		}
		else {							//if not Ace, return false
			return false;				//return false
		}
	}
	
	public int getSuit() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public int getsuit
		// Method parameters	:	-
		// Method return		:	this.suit
		// Synopsis				:   This method is to get the type of suit from the array.
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		return this.suit;		//return suit
	}
	
	public int getValue() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public int get valueC
		// Method parameters	:	-
		// Method return		:	this.valueC
		// Synopsis				:   This method is to get the value of valueC from the array.
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		return this.valueC;		//return ValueC
	}
	
	public String toString() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public string to string
		// Method parameters	:	-
		// Method return		:	a string summed from valueC (from its position from its array) with suit (from its position from its array)
		// Synopsis				:   This method is to get the value of valueC from the array and put it together with the suit from the array.
		//							and make it a string	
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.valueCArray[this.valueC] + this.suitArray[this.suit]; 	//return valueC+suit as a string
	}
	
	public int getCardValue () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public int get card value
		// Method parameters	:	
		// Method return		:	(int) return 10 ,this.valueC+1
		// Synopsis				:   This method sets the value of cards from the array position
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		if (this.valueC == 10 || this.valueC == 11 || this.valueC == 12) {	//conditional state to define the value of cards based on their position in the array
			return 10; // when cards position is 10, 11, 12 (J, Q, K) return value 10 
		} 
		return this.valueC+1; // when cards different than (J,Q,K), they have the value of its position+1
	}

	public ImageIcon getImage() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public image icon get image icon()
		// Method parameters	:	
		// Method return		:	image icon
		// Synopsis				:   This method define imageicon, get it from the folder and rescaled them to fit the label
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		return new ImageIcon (new ImageIcon("Images/" + this.toString() + ".png").getImage().getScaledInstance(80, 123, Image.SCALE_DEFAULT));
	}	// define imageicon, get it from the folder and rescaled them to fit the label
	
	public static ImageIcon getBackImage() {			
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public image icon getback image ()
		// Method parameters	:	
		// Method return		:	image icon back card rescaled 
		// Synopsis				:   This method define imageicon, get it from the folder and rescaled them to fit the label
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
		return new ImageIcon(new ImageIcon("Images/yellow_back.png").getImage().getScaledInstance(80, 123, Image.SCALE_DEFAULT));
	}	//return imageicon back of the card
}

	
