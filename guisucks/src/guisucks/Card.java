package guisucks;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card extends JLabel{
	String name;
	String suit;
	String value;
	
	public Card(String name, String suit, String value){
		this.name = name;
		this.suit = suit;
		this.value = value;
		ImageIcon icon = new ImageIcon("cards/"+name+".gif");
		setIcon(icon);
		this.setBounds(20, 50, 70, 100);
	}
	
	public String toString(){
		return "CARD NAME: "+name;
	}

}
