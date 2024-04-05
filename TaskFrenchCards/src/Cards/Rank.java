package Cards;

public enum Rank {
	ACE(12),
	KING(11),
	QUEEN(10),
	JACK(9),
	TEN(8),
	NINE(7),
	EIGHT(6),
	SEVEN(5),
	SIX(4),
	FIVE(3),
	FOUR(2),
	THREE(1),
	TWO(0);
	
	int order;
	
	Rank(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}
}
