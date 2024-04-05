package House;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Cards.Card;
import Cards.Rank;
import Cards.Suit;

public class EvaluatorTest {

	private Card[] royalFlushHand = new Card[] {
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.JACK),
		new Card(Suit.SPADES, Rank.TEN)
	};
	
	private Card[][] straightFlushHands = new Card[][] {{
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.JACK),
		new Card(Suit.SPADES, Rank.TEN),
		new Card(Suit.SPADES, Rank.NINE)
	},{
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.FIVE),
		new Card(Suit.SPADES, Rank.FOUR),
		new Card(Suit.SPADES, Rank.THREE),
		new Card(Suit.SPADES, Rank.TWO)
	}};

	private Card[][] fourOfAKindHands = new Card[][] {{
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING)
	},{
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.KING)
	}};
	
	private Card[][] fullHouseHands = new Card[][] {{
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.KING)
	},{
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.KING)
	}};
	
	private Card[] flushHand = new Card[] {
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.JACK),
		new Card(Suit.SPADES, Rank.NINE)
	};
	
	private Card[][] straightHands = new Card[][] {{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.JACK),
		new Card(Suit.SPADES, Rank.TEN)
	},{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.FIVE),
		new Card(Suit.SPADES, Rank.FOUR),
		new Card(Suit.SPADES, Rank.THREE),
		new Card(Suit.SPADES, Rank.TWO)
	}};

	private Card[][] threeOfAKindHands = new Card[][] {{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN)
	},{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN)
	},{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.QUEEN)
	}};

	private Card[][] twoPairHands = new Card[][] {{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN)
	},{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.QUEEN)
	},{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.QUEEN)
	}};

	private Card[][] pairHands = new Card[][] {{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.JACK)
	},{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.JACK)
	},{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.JACK)
	},{
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.JACK),
		new Card(Suit.SPADES, Rank.JACK)
	}};
	
	private Card[] highCardHand = new Card[] {
		new Card(Suit.HEARTS, Rank.ACE),
		new Card(Suit.SPADES, Rank.KING),
		new Card(Suit.SPADES, Rank.QUEEN),
		new Card(Suit.SPADES, Rank.JACK),
		new Card(Suit.SPADES, Rank.NINE)
	};

	private Evaluator evaluator = new Evaluator();
	
	@Test
	public void testEvaluations() {
		assertEquals(evaluator.evaluate(royalFlushHand), Hand.ROYAL_FLUSH);
		
		for(Card[] cards : straightFlushHands) {
			assertEquals(evaluator.evaluate(cards), Hand.STRAIGHT_FLUSH);
		}

		for(Card[] cards : fourOfAKindHands) {
			assertEquals(evaluator.evaluate(cards), Hand.FOUR_OF_A_KIND);
		}

		for(Card[] cards : fullHouseHands) {
			assertEquals(evaluator.evaluate(cards), Hand.FULL_HOUSE);
		}

		assertEquals(evaluator.evaluate(flushHand), Hand.FLUSH);
		
		for(Card[] cards : straightHands) {
			assertEquals(evaluator.evaluate(cards), Hand.STRAIGHT);
		}
		
		for(Card[] cards : threeOfAKindHands) {
			assertEquals(evaluator.evaluate(cards), Hand.THREE_OF_A_KIND);
		}
		
		for(Card[] cards : twoPairHands) {
			assertEquals(evaluator.evaluate(cards), Hand.TWO_PAIR);
		}
		
		for(Card[] cards : pairHands) {
			assertEquals(evaluator.evaluate(cards), Hand.PAIR);
		}
		
		assertEquals(evaluator.evaluate(highCardHand), Hand.HIGH_CARD);
	}

}
