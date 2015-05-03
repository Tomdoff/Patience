package uk.ac.aber.dcs.cs12320.cards;

public class Card {
	private String name;
	private String suit;
	private String value;
	
	
	public Card(String nameIni, String suitIni, String valueIni)
	{
		name = nameIni;
		suit = suitIni;
		value = valueIni;
		
	}
	public Card()
	{
		name = null;
		suit = null;
		value = null;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public void setValue(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}

	public String toString()
	{
		return value + " of " + suit;
		
	}
}