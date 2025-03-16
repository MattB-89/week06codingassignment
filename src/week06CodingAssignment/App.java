package week06CodingAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		System.out.println("\n==============================");
		System.out.println("\n");
		System.out.println("       The Game of War!");
		System.out.println("\n");
		System.out.println("==============================");
		
		// Create 2 players for the game
		System.out.println("\nInstantiate 2 players");
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		
		// Call the describe method of the player class to describe the players and their initial scores.
		player1.describe();
		player2.describe();
		System.out.println("\n");
		
		// Create a new instance of the Deck object called myDeck and call the shuffle method method on the new Deck
		Deck deck = new Deck();
				
		// shuffle the deck
		deck.shuffle();
		
		// create two new lists to hold each players hands
		List<Card> player1Hand = new ArrayList<>();
		List<Card> player2Hand = new ArrayList<>();
		
		// Declare the number of players for this game - will always be 2 so the declaration is Final
		final int numOfPlayers = 2;
		
		// iterate through the deck of 52 cards dealing to each player
		for (int i = 0; i < 52/numOfPlayers ; i++) {			
			player1Hand.add(deck.draw());
			player2Hand.add(deck.draw());					
		}
		
		// Play the game
		// initialize variable to track the rounds in the game
		int round = 1;
		
		for (int i = 0; i < 26; i++) {
			// players play the first card and the console is provided the description of the cards flipped
			Card p1Card = player1.flip(player1Hand);
			Card p2Card = player2.flip(player2Hand);
			System.out.println("Round " + round + "!");
			System.out.println("====================");
			System.out.print(player1.name + " plays: ");
			p1Card.describe();
			System.out.print(player2.name + " plays: ");
			p2Card.describe();
			
			// comparison to evaluate which player holds the higher value of the flipped card.
			// which ever player has the higher valued card their score is incremented.
			// the game does not provide a scenario for a draw so a draw has no winner and the player's scores don't increment.
			// each round is played and the totals are calculated for each round.
			if(p1Card.value > p2Card.value) {
				System.out.println(player1.name + " gains the point!\n");
				player1.incrementScore();
			} else if (p1Card.value < p2Card.value) {
				System.out.println(player2.name + " gains the point!\n");
				player2.incrementScore();
			} else {
				System.out.println("Cards have equal value so no points awarded.\n");
			}
			round++;
		}
		
		
		// to the console provide the results of the game.  each players score is displayed and the winner is declared
		System.out.println("Game is now over.");
		System.out.println(player1.name + " has " + player1.score);
		System.out.println(player2.name + " has " + player2.score);
		if(player1.score > player2.score) {
			System.out.println(player1.name + " WINS!!");
		} else if (player1.score < player2.score) {
			System.out.println(player2.name + " WINS!!");
		} else {
			System.out.println("Scores are equal so the game is a DRAW.");
		}
	}				
}
