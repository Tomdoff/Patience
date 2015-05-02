/**
 * @author Tom Doyle
 * @version 1.0
 */
package uk.ac.aber.dcs.cs12320.cards;

import java.util.ArrayList;

public class CardStack {
	private ArrayList<Card> stack = new ArrayList<Card>();

	public CardStack(Card fromDeck) {
		stack.add(fromDeck);
	}

	public String getTopCard() {
		String name = stack.get(stack.size() - 1).getName(); // gets the last
																// card in the
																// array.
		name = name + ".gif";
		return name;
	}
	
	public Card getCard(int location) {
		Card card = stack.get(location);
		return card;
	}
}