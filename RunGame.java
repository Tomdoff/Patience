/**
 * Class where the game is run from
 * @author Tom Doyle
 * @version 1.0 (26/04/2015)
 * Changed the shuffling algorithm to the Fisher-Yates algorithm 
 * -(figured out on my own, later found out it (obviously) already existed.)
 */

package uk.ac.aber.dcs.cs12320.cards;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import uk.ac.aber.dcs.cs12320.cards.gui.TheFrame;

public class RunGame {
	public ArrayList<Card> Deck = new ArrayList<Card>();
	private ArrayList<CardStack> field = new ArrayList<CardStack>();
	private ArrayList<String> cardStrings = new ArrayList<String>();
	TheFrame frame = new TheFrame();
	public int turns = 0;
	private Scanner scan;
	private String filename = "cards.txt";

	public void newGame() {
		initialiseDeck();
		shuffleDeck();
		playCard(); // gets the game into a playable position.
		playCard();
		displayCards();
		String response;
		do {
			displayGameMenu();
			Scanner scan = new Scanner(System.in);
			response = scan.nextLine().toUpperCase();
			switch (response) {
			case "1": // make move
				System.out.println("What move would you like to make?");
				makeMove();
				break;
			case "2": // automatic move

				break;
			case "3": // save game

				break;
			default:
				System.out.println("Sorry, user input was not understood");
				break;
			}
		} while (!(response.equals("4")));

	}

	private void makeMove() {
		String startCard;
		String destinationCard;
		scan = new Scanner(System.in);
		ArrayList<String> TopCards = new ArrayList<String>();
		for (int i = 0; i < field.size(); i++) {
			CardStack card = field.get(i);
			String topCard = card.getTopCard();
			TopCards.add(topCard);
		}
		while (true) {
			System.out.println("Type start card e.g ah = ace of hearts. \n");
			startCard = scan.nextLine();
			if (TopCards.contains(startCard)) {
				break;
			}
			System.out.println("Sorry, the card you typed was not valid.");
		}

		while (true) {
			System.out
					.println("Type destination card e.g ah = ace of hearts. \n");
			destinationCard = scan.nextLine();
			if (TopCards.contains(destinationCard)) {
				break;
			}
			System.out.println("Sorry, user input was not understood");
		}
		

	}

	public void displayGameMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\n");
		System.out.println("1 - Make Move");
		System.out.println("2 - Autmoatic Move");
		System.out.println("3 - Save Game");
		System.out.println("4 - Exit Game");
		System.out.println("\n");
	}

	public void initialiseDeck() {
		try (FileReader fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr);
				Scanner infile = new Scanner(br)) {
			for (int i = 0; i < 52; i++) {
				String cardValue = infile.nextLine();
				String cardSuit = infile.nextLine();
				String cardName = (cardValue + cardSuit);
				Card card = new Card(cardName, cardSuit, cardValue);
				Deck.add(card);
				// System.out.println(card.toString());
				// System.out.println(Deck.size());

			}

		} catch (FileNotFoundException e) {
			System.err.println("The file" + filename
					+ "have you accidentally deleted the file?");
		} catch (IOException e) {
			System.err
					.println("An unexpected error occurred when trying to open the file "
							+ filename);
			System.err.println(e.getMessage());
		}

	}

	/*
	 * Shuffles the deck Creates a temporary ArrayList to put cards into Removes
	 * cards from Deck as it goes. Moves all cards back into Deck once deck is
	 * empty.
	 */
	public void shuffleDeck() {
		ArrayList<Card> shuffled = new ArrayList<Card>();
		int random;
		while (Deck.size() > 0) {
			double tempRandom = Math.random() * Deck.size();
			random = (int) tempRandom;
			shuffled.add(Deck.get(random));
			Deck.remove(random);
		}
		Deck.addAll(shuffled);
	}

	public void printDeck() {
		for (int i = 0; i < Deck.size(); i++) {
			Card card = Deck.get(i);
			System.out.println(card.toString());
		}
	}

	private void playCard() {
		CardStack stack = new CardStack(Deck.get(0)); // takes the top card of
														// the deck and adds it
														// to a new slot
		field.add(stack); // adds the new slot to the field.
		Deck.remove(0); // removes card from the deck.
	}

	public void displayCards() {
		for (int i = 0; i < field.size(); i++) {
			CardStack stack = field.get(i);
			String topCard = stack.getTopCard();
			cardStrings.add(topCard);
			frame.cardDisplay(cardStrings);
		}
	}

}
