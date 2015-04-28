package uk.ac.aber.dcs.cs12320.cards;

import java.util.ArrayList;
import java.util.Scanner;

import uk.ac.aber.dcs.cs12320.cards.gui.TheFrame;

public class TestFrame {

	/**
	 * prints the menu properties.
	 */
	private void runMenu() {
		String response;
		do {
			printMenu();
			Scanner scan = new Scanner(System.in);
			response = scan.nextLine().toUpperCase();
			switch (response) {
			case "1":
				RunGame game = new RunGame();
				game.initialiseDeck();
				game.shuffleDeck();
				game.printDeck();
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			case "q":
				
				break;

			}
		} while (!(response.equals("Q")));
	}
	
	private void printMenu()
	{
		System.out.println("\n");
		System.out.println("1 - New Game");
		System.out.println("2 - Load Game");
		System.out.println("3 - See High Scores");
		System.out.println("q - Quit");
		System.out.println("\n");
	}

	public static void main(String args[]) {
		TestFrame run = new TestFrame();
		System.out.println("Welcome to Accordian Patience!");
		System.out.println("What would you like to do?");
		run.runMenu();
		System.out.println("Thank you for playing! :) ");
		
		 // prints out the contents of the deck in current
							// order
		TheFrame frame = new TheFrame();

		/*ArrayList<String> cardStrings = new ArrayList<String>();
		for (int i = 0; game.Deck.size() > 0 && i < game.Deck.size(); i++) {
			Card card = game.Deck.get(i);
			cardStrings.add(card.getName() + ".gif");
		}
		*/

		//frame.cardDisplay(cardStrings);
	}
}
