//	⦁	Implement an object oriented solution to represent French Cards and a Hand. 
//		A Hand can hold exactly 5 French Cards. Here you can find some hints: 
//		https://www.wsop.com/poker-hands/

//	⦁	So the custom logic can take a Hand and evaluate its cards.

//	⦁	Cover your solution by unit tests.
//	⦁	Upload your solution to GitHub.
//	⦁	(Tips for classes: Color, Value, Card, Hand, Evaluator, …)

import Cards.Card;
import House.Dealer;
import House.Hand;

public class FrenchCards {
	
	public static final boolean DEBUG = false;
	
	private Dealer dealer;
	private Card playerCards[];
	
	public FrenchCards() {
		this.dealer = new Dealer();
		this.playerCards = new Card[5];
	}

	public Hand playPoker() {
		for(int i = 0; i < playerCards.length; i++) {
			playerCards[i] = dealer.dealCard();
		}
		
		if(DEBUG) {
			System.out.println("The dealt cards are:\n");
			for(Card c : playerCards) {
				System.out.println(c.toString());
			}
		}
		
		Hand result = dealer.checkHand(playerCards);
		
		if(DEBUG) {
			System.out.println("\nResulting in a: " + result.name());
		}
		
		return result;
	}
	
}
