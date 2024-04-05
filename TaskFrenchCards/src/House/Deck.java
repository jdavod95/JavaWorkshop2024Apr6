package House;
import java.util.LinkedList;

import Cards.Card;
import Cards.Rank;
import Cards.Suit;

public class Deck {
	
	private LinkedList<Card> deck;

	public Deck() {
		deckSetup();
	}
	
	public Card drawCard() {
		return deck.remove((int) Math.floor(Math.random() * deck.size()));
	}
	
	public void deckSetup() {
		deck = new LinkedList<>();
		for(Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				deck.add(new Card(s, r));
			}
		}
	}
}
