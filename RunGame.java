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

public class RunGame {
	public ArrayList<Card> Deck = new ArrayList<Card>();
	private ArrayList<ArrayList<Card>> field;
	public int turns = 0;
	private Scanner scan;
	private String filename = "cards.txt";

/*
 * adds all the cards from a file to the deck.
 * throws File not found error
 * throws IOException error.
 */
	public void initialiseDeck() {
		try (FileReader fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr);
				Scanner infile = new Scanner(br)) {
			for(int i = 0; i<52; i++)
			{
				String cardValue = infile.nextLine();
				String cardSuit = infile.nextLine();
				String cardName = (cardValue+cardSuit);
				Card card = new Card(cardName, cardSuit, cardValue);
				Deck.add(card);
				System.out.println(card.toString());
				System.out.println(Deck.size());
				
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
	 * Shuffles the deck
	 * Creates a temporary ArrayList to put cards into
	 * Removes cards from Deck as it goes.
	 * Moves all cards back into Deck once deck is empty.
	 */
	public void shuffleDeck() {
		ArrayList<Card>shuffled = new ArrayList<Card>();
		int random;
		while(Deck.size()>0)
		{
			double tempRandom = Math.random()*Deck.size();
			random=(int)tempRandom;
			shuffled.add(Deck.get(random));
			Deck.remove(random);
		}
		Deck.addAll(shuffled);
	}
	
	public void printDeck()
	{
		for(int i=0; i<Deck.size(); i++)
		{
			Card card = Deck.get(i);
			System.out.println(card.toString());
		}
	}

}
