package blackjack.domain.gamer;

import java.util.List;

import blackjack.domain.card.Card;

public record Hand(List<Card> cards) {

	private static final int BLACKJACK_MAX_SCORE = 21;
	private static final int ACE_VALUE_MODIFIER = 10;

	public void add(Card card) {
		cards.add(card);
	}

	public int calculateScore() {
		int sum = cards.stream()
			.mapToInt(Card::getNumber)
			.sum();

		if (hasAce()) {
			return adjustSumWithAce(sum);
		}
		return sum;
	}

	private boolean hasAce() {
		return cards.stream()
			.anyMatch(Card::isAce);
	}

	/**
	 * 21 이하이면서 가장 큰 값을 찾습니다.
	 * Ace는 CardNumber에 11로 지정하였기에, 합계가 21을 초과하면 Ace의 개수만큼 10씩 빼는 방법으로 Ace를 1로 계산합니다.
	 */
	private int adjustSumWithAce(int sum) {
		int aceCount = (int)cards.stream()
			.filter(Card::isAce)
			.count();

		for (int i = 0; i < aceCount; i++) {
			sum = adjust(sum);
		}
		return sum;
	}

	private int adjust(int sum) {
		if (sum > BLACKJACK_MAX_SCORE) {
			sum -= ACE_VALUE_MODIFIER;
		}
		return sum;
	}

	public Card getFirstCard() {
		return cards.get(0);
	}
}
