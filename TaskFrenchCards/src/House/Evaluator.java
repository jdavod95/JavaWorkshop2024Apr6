package House;

import java.util.Arrays;

import Cards.Card;
import Cards.Rank;
import Cards.Suit;

//⦁	Implement a custom logic to find out the maximum value of the cards kept in a Hand

public class Evaluator {
	
	public static final boolean DEBUG = false;

	public Hand evaluate(Card[] cards) {
		if(cards.length != 5) {
			return Hand.NONE;
		}
		Card[] sortedCards = sortCards(cards);
		boolean isSameSuits = checkSuits(sortedCards);
		boolean isSequencedRanks = checkSequence(sortedCards);
		
		// AKQJ10
		if(isSameSuits && isSequencedRanks && cards[4].getRank().equals(Rank.TEN)) {
			return Hand.ROYAL_FLUSH;
		}
	
		// KQJ109 || 5432A
		if(isSameSuits && isSequencedRanks) {
			return Hand.STRAIGHT_FLUSH;
		}
		
		// AAAAK || AKKKK 
		if(cards[0].getRank().equals(cards[3].getRank()) || 
				cards[1].getRank().equals(cards[4].getRank())) {
			return Hand.FOUR_OF_A_KIND;
		}

		// AAKKK || AAAKK
		if((cards[0].getRank().equals(cards[2].getRank()) && 
			cards[3].getRank().equals(cards[4].getRank())) ||
			(cards[0].getRank().equals(cards[1].getRank()) && 
			cards[2].getRank().equals(cards[4].getRank()))) {
			return Hand.FULL_HOUSE;
		}
	
		if(isSameSuits) {
			return Hand.FLUSH;
		}
		
		if(isSequencedRanks) {
			return Hand.STRAIGHT;
		}
		
		// AAAKQ || AKKKQ || AKQQQ
		if(cards[0].getRank().equals(cards[2].getRank()) ||
			cards[1].getRank().equals(cards[3].getRank()) ||
			cards[2].getRank().equals(cards[4].getRank())) {
			return Hand.THREE_OF_A_KIND;
		}
		
		boolean hasPair = false;
		for(int i = 1; i < cards.length; i++) {
			if(cards[i-1].getRank().getOrder() - cards[i].getRank().getOrder() == 0) {
				if(!hasPair) {
					hasPair = true;
				} else {
					// AAKKQ || AAKQQ || AKKQQ
					return Hand.TWO_PAIR;
				}
			}
		}

		// AAKQJ || AKKQJ || AKQQJ || AKQJJ 
		return hasPair ? Hand.PAIR : Hand.HIGH_CARD;
	}
	
	private boolean checkSuits(Card[] cards) {
		Suit suit = cards[0].getSuit();
		
		for(Card c : cards) {
			if(!c.getSuit().equals(suit)) {
				return false;
			}
			suit = c.getSuit();
		}
		
		return true;
	}
	
	private Card[] sortCards(Card[] cards) {
		Arrays.sort(cards, 
				(o1, o2) -> {
					return o1.getRank().getOrder() < o2.getRank().getOrder() ? 1 : -1;
				});

		if(DEBUG) {
			System.out.println("\nThe cards in decreasing order:\n");
			for(Card c : cards) {
				System.out.println(c.toString());
			}
		}
		
		return cards; 
	}
	
	private boolean checkSequence(Card[] cards) {
		boolean result = true;
		
		for(int i = 1; i < cards.length; i++) {
			if(cards[i-1].getRank().getOrder() - cards[i].getRank().getOrder() != 1) {
				result = false;
			}
		}
		
		return result || isHandLowAceStraight(cards);
	}
	
	private boolean isHandLowAceStraight(Card[] cards) {
		return cards[0].getRank().equals(Rank.ACE) &&
			cards[1].getRank().equals(Rank.FIVE) &&
			cards[2].getRank().equals(Rank.FOUR) &&
			cards[3].getRank().equals(Rank.THREE) &&
			cards[4].getRank().equals(Rank.TWO);
	}
}
