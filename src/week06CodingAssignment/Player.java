package week06CodingAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
	
	private int score;
	
	List<Card> hand = new ArrayList<Card>();
	String name = "";
	
	// constructor for Player class
	public Player(String name) {
		this.name = name;
		this.score = 0;
		//this.value = value;
	}
	
	public void describe() {
		// out to console information about the player and calls the
		// describe method for each card in the Hand List
		System.out.println(this.name + " has an initial score of " + this.score);
	}
	
	public Card flip(List<Card> myCard) {
		// removes and returns the top card of the Hand
		Card card = myCard.remove(0);	// removes a card from the list
		return card;
		
	}
	
	public Card draw(Deck deck) {
		// takes a Deck as argument and calls the draw method on the deck,
		// adding the returned Card to the hand field
		Card myCard = deck.draw();
		//deck.draw();		
		return myCard;
				
	}
	
	public void incrementScore() {
		// adds 1 to the Players score field
	}
	
}
