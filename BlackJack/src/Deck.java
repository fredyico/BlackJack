import java.util.ArrayList;				//imported java library
import java.util.Collections;			//imported java library
import javax.swing.ImageIcon;			//imported java library

public class Deck {		//a public class called Deck

	private ArrayList<Card> cards = new ArrayList<>();	//definition of an array list of cards as a new array
	
	public Deck() {	
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public Deck
		// Method parameters	:	-
		// Method return		:	none
		// Synopsis				:   This method creates a Deck of card from the cards array list 
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		
		Card card;								//defining card as an element of Card arraylist
		for (int st = 0; st < 4; st++) {		//loop to create the 4 suits of the card deck
			for (int vl = 0; vl < 13; vl++) {	//loop to create the 13 card values of the deck
				card = new Card(st, vl);		//definition of card as the junction of a value and a suit
				cards.add(card);				//function to add a card in the cards array
			}				
		}
		this.shuffle();							//defining the method (to) shuffle [the deck of cards]
	}	

	private void removeCard(int index) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	private void remove card
		// Method parameters	:	int index
		// Method return		:	none
		// Synopsis				:   This method creates a function to remove a card from the index of an array 
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		cards.remove(index);	//function to remove a card from the index (of an array) 
	}
	
	public void shuffle() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public void shuffle
		// Method parameters	:	-
		// Method return		:	none
		// Synopsis				:   This method creates a function to shuffle the array of cards
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		Collections.shuffle(cards);		//This method creates a function to shuffle and return a collection of [cards] in the array of cards
	}
	
	public Card getCard() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public Card get card
		// Method parameters	:	-
		// Method return		:	card (from the deck)
		// Synopsis				:   This method creates a function to get a card from the Card array list
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		Card card = this.cards.get(0);	//defining this.card as an element of a card array list - and to get it from the array list
		this.removeCard(0);				//method to remove a card after getting a card from the deck
		return card;					//after getting and removing a card, return(give) the same card to the player(or dealer)
	}
	
	public int getDeckSize() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public int getdeck size
		// Method parameters	:	-
		// Method return		:	cards size
		// Synopsis				:   This method gets the size of the deck of cards 
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		return cards.size();	//return the size of the array cards (deck of cards)
	}
	
	public String toString() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	public string to string
		// Method parameters	:	-
		// Method return		:	return deck
		// Synopsis				:   This method define the  
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-04-05		F. F. Beckedorff		Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		String deck = "";	//defining deck as a string
		for (Card card : cards) {	//loop to change the type of card from cards array into string 
			deck += card.toString() + "/n";	//defining (changing) elements (card) of deck as string 
		}
		return deck;	//return deck elements as a string
	}
}