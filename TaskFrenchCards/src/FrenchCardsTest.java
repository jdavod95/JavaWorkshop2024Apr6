import org.junit.jupiter.api.Test;

import House.DeckTest;
import House.EvaluatorTest;

class FrenchCardsTest {

	@Test
	void test() {
		new DeckTest().testDrawCard();
		new EvaluatorTest().testEvaluations();
		FrenchCards frenchCards = new FrenchCards();
		frenchCards.playPoker();
		
	}

}
