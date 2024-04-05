package Cards;

public class Card {
	
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return rank.name() + " of " + suit.name();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Card)) {
			return false;
		}
		
		Card otherCard = (Card) obj;
		
		return suit.equals(otherCard.getSuit()) && rank.equals(otherCard.getRank());
	}
	
}
