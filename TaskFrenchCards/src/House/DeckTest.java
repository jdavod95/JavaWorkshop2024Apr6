package House;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import Cards.Card;
import Cards.Rank;
import Cards.Suit;

public class DeckTest {

	// Should be able to draw the first and the last cards, with random chance,
	// without throwing IndexOutOfBoundsException
	@Test
	public void testDrawCard() {
		Deck deck = new Deck();
		
		Card twoOfDiamonds = new Card(Suit.DIAMONDS, Rank.TWO);
		Card aceOfHearts = new Card(Suit.HEARTS, Rank.ACE);

		assertDoesNotThrow(() -> { while(!deck.drawCard().equals(aceOfHearts)); });

		deck.deckSetup();

		assertDoesNotThrow(() -> { while(!deck.drawCard().equals(twoOfDiamonds)); });
	}

}
