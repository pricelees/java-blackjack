package blackjack.domain.gamer;

import java.util.ArrayList;
import java.util.List;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;

public abstract class BlackjackGamer {

	private final Name name;
	private final Hand hand;

	public BlackjackGamer(Name name, List<Card> cards) {
		this.name = name;
		this.hand = new Hand(cards);
	}

	public BlackjackGamer(Name name) {
		this(name, new ArrayList<>());
	}

	public abstract boolean canReceiveCard();

	public void initCard(Deck deck, int initialCardCount) {
		for (int i = 0; i < initialCardCount; i++) {
			addCard(deck.draw());
		}
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public boolean isBusted() {
		return hand.checkIfBust();
	}

	public boolean isBlackjack() {
		return hand.checkIfBlackjack();
	}

	public Card getFirstCard() {
		return hand.getFirstCard();
	}

	public int getScore() {
		return hand.calculateScore();
	}

	public Name getName() {
		return name;
	}

	public Hand getHand() {
		return hand;
	}
}
