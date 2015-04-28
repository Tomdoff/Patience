package uk.ac.aber.dcs.cs12320.cards;

public class Move {
	private int startColumn;
	private int destinationColumn;
	
	public Move(int sColumn,int dColumn)
	{
		startColumn = sColumn;
		destinationColumn = dColumn; 
	}
	
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
