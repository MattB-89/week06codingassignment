package week06CodingAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	// 2. Deck Class:
	//		Create a class called Deck.
	//		Fields:  This class should have a list of Card field called cards 
	//				 that will hold all the cards in the deck. 
	//				 List<Card> cards = new ArrayList<Card>(); 
	//
	//		Constructor: The constructor for the Deck Class should
	// 					 instantiate all 52 standard playing cards and add them to the cards list.
	//
	//		Methods:  
	//			a.  describe() to describe the deck to the Console -- 
	//				print out all of the cards in the deck.
	//
			
	List<Card> cards = new ArrayList<Card>();

	public Deck() {
		//Create string arrays to hold the combination of cards available in a deck of cards
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] numbers = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
				
		// iterate through lists to create the deck of cards
		for(String suit : suits) {
			int count = 2;	// variable to hold the value of the card
			for (String number : numbers) {
				cards.add(new Card(number, suit, count));	// add the card to the cards list
				count++;
			}
		}
	}

	// Getters and Setters for Deck class
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
			
	public void describe() {
		for(Card card : this.cards) {
			card.describe();
		}
	}
			
	// Deck shuffle() Method:
	//		Add a shuffle method within the Deck Class
	public void shuffle() {
		Collections.shuffle(this.cards);	// Built-in Collections method to randomize elements within a list
	}
			
	// Deck draw() Method:
	//		Add a draw method within the Deck Class	
	public Card draw() {
		Card card = this.cards.remove(0);	// removes a card from the list
		return card;
	}
}
