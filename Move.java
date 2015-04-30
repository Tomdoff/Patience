package uk.ac.aber.dcs.cs12320.cards;

/**
 * @author Tom Doyle
 *
 */
public class Move {
	private int startColumn;
	private int destinationColumn;
	
	/**
	 * @param sColumn start column
	 * @param dColumn destination column
	 */
	public Move(int sColumn,int dColumn)
	{
		startColumn = sColumn;
		destinationColumn = dColumn; 
	}
	
	/**
	 * 
	 * @param startCard the starting array of cards
	 * @param endCard when they will end up
	 * @return returns true if the cards have either matching suit or value.
	 */
	
	public boolean checkMove(Card startCard, Card endCard)
	{
		boolean isLegal = false;
		if(startCard.getSuit().equals(endCard.getSuit())||startCard.getValue().equals(endCard.getValue()))
		{
			isLegal=true;
		}

		return isLegal;
	}

}
