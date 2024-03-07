package blackjack.domain.card;

import java.util.Objects;

import blackjack.dto.CardDto;

public class Card {

	private final CardShape cardShape;
	private final CardNumber cardNumber;

	public Card(CardShape cardShape, CardNumber cardNumber) {
		this.cardShape = cardShape;
		this.cardNumber = cardNumber;
	}

	public boolean isAce() {
		return cardNumber == CardNumber.ACE;
	}

	public int getNumber() {
		return cardNumber.getValue();
	}

	public CardDto convertCardToDto() {
		return new CardDto(cardNumber.getName(), cardShape.getName());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Card card = (Card)o;
		return cardShape == card.cardShape && cardNumber == card.cardNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardShape, cardNumber);
	}
}
