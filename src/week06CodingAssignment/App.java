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
		
		// Add your code here to instantiate a Card			
		//Card card = new Card("Ace", "Spades", 14);		
			
		// Call the describe method on the newly instantiated card.
		//card.describe();
			
		//System.out.println("\nQuestion 2: Deck Class");		
		// Add your code here to instantiate a Deck			    
		//Deck deck = new Deck();
		    
		// Call the describe method on the newly instantiated deck.
		//deck.describe();		
		
		
		
		
		//System.out.println("\nQuestion 3: Deck shuffle() method");
		// Test your method here
		//deck.shuffle();
		
		// Call the describe method on the newly shuffled deck.
		//deck.describe();		
		
		//System.out.println("\nQuestion 4: Deck draw() method");
		// Test your method here
		//Card drawnCard = deck.draw();
		//drawnCard.describe();
		
		//System.out.println("Drawn from list: " + strings);
		
		// 5. Create Game Board:
		//		Create and test a method that takes an int as a parameter (representing the
		// 		number of players for a game) and returns a Map<String>, List<Card>>
		// 		that represents each player (i.e. "Player 1", "Player 2", etc..) 
		//		and their cards.
		//
		// 		The method should create a new instance of Deck, shuffle it,
		// 		and deal the cards out to the "players" in the Map.
		
		System.out.println("\nQuestion 5: Play the game.");
		
		
		// Call your method here passing int numberOfPlayers as the argument
		// and returning the Map of the players and what they were dealt
		Map<String, List<Card>> gameBoard = new HashMap<>();
		// Instantiate 2 Players for the game
		System.out.println("\nInstantiate 2 players");
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
				
		player1.describe();
		player2.describe();
		System.out.println("\n");
		
		// Create a new instance of the Deck object called myDeck and call the shuffle method method on the new Deck
		Deck deck = new Deck();
		//deck.describe();
				
		// shuffle the deck
		deck.shuffle();
			
		// describe the shuffled deck for reference
		deck.describe();
		
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
		 		
		// console output to validate the dealing of cards to each player for reference
		System.out.println("\nPlayer 1 Hand:");
		System.out.println("--------------");
		for (Card card : player1Hand) {
			card.describe();
		}
		
		System.out.println("\nPlayer 2 Hand:");
		System.out.println("----------------");
		for (Card card : player2Hand) {
			card.describe();
		}
		
		// Play the game
		int round = 1;
		
		for (int i = 0; i < 26; i++) {
			Card p1Card = player1.flip(player1Hand);
			Card p2Card = player2.flip(player2Hand);			
		}
		
		player1.describe();
		player2.describe();
		
//		gameBoard = createGame(player1, player2);
//		
//		//Send to console the output of the details from the createGame method
//		System.out.println("-----------------------------------------------------");
//		int numberOfPlayers = 2;
//		for (int i = 1; i <= numberOfPlayers ; i++) {
//			String playerName = "Player " + i;											// print the player name to the console
//			System.out.println(playerName + "\n--------");								// print line to make reading easier
//			List<Card> playerList = gameBoard.get(playerName);							// get the list of cards assigned to player
//			for (Card handCard : playerList) {											// iterate through list of cards assigned to player
//				handCard.describe();													// call the describe method to see the cards drawn
//			}
//		}
//		System.out.println("-----------------------------------------------------");
	}
	
	// Method 5:
	
	public static Map<String, List<Card>> createGame(Player player1, Player player2){
		// initialize local variable for the number of players - in this program there is only 2
		final int numOfPlayers = 2;
		
		// Create a map of the players hands that are participating in the game
		Map<String, List<Card>> finalGameBoard = new HashMap<>();
		
		// Create a new instance of the Deck object called myDeck and call the shuffle method method on the new Deck
		Deck deck = new Deck();
		//deck.describe();
		
		deck.shuffle();
		
		deck.describe();
		
		// Print to console to identify the number of cards in the deck
		//System.out.println("Deck has " + deck.getCards().size() + " cards.");
		
		
		// Create the Map of the each player and their allocated list (hand) but empty
		for (int i = 1; i <= numOfPlayers; i++) {
			List<Card> playerList = new ArrayList<>();		// create a list for the player
			String playerName = "Player " + i;				// name the player
			finalGameBoard.put(playerName, playerList); 	// put the entries into the map (key (playerName), value (playerList))
		}
				
		// Create a loop to deal the deck to the players in the game
		for (int i = 0; i < 52/numOfPlayers; i++) {							// evenly deal the cards to the players
			for(int j = 1; j <= numOfPlayers; j++) {						// loop of the players in the game
				String playerName = "Player " + j;							// create the player name based on index
				List<Card> playerList = finalGameBoard.get(playerName);		// get the list of cards in the gameBoard using key (playerName)
				playerList.add(deck.draw());								// card is drawn and added to playerList
				finalGameBoard.replace(playerName, playerList);				// replace the card with this draw
			}
		}
		
//		method to communicate what's left over due from other number of players
//		if (52 % numOfPlayers != 0) {
//			System.out.print("With " + numOfPlayers + " players -- ");
//			System.out.println("Cards left in deck: " + 52 % numOfPlayers);
//		} else {
//			System.out.println("All cards have been dealt!");
//		}
		return finalGameBoard;
	}
	
	/*
	 * There is no requirement to follow the methodology of what Lab05OOP did.  Simply shuffle the deck and add the cards from that deck to
	 * each of the players hands.  A simple for loop like -- for (int i = 0; i < 26; i++) will work.  On each iteration add the card to the
	 * players hand.  Go through playing the hands, flip the cards through a class call flip(), return the cards flipped and do a comparison
	 * of value to determine winner.
	 */

}
