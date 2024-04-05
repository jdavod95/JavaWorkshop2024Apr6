package House;

import Cards.Card;

public class Dealer {
	private Deck deck;
	private Evaluator evaluator;
	
	public Dealer() {
		this.deck = new Deck();
		this.evaluator = new Evaluator();
	}
	
	public Card dealCard() {
		return deck.drawCard();
	}
	
	public Hand checkHand(Card[] cards) {
		return evaluator.evaluate(cards);
	}
}
