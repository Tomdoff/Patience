/**
 * @author Tom Doyle
 */

package uk.ac.aber.dcs.cs12320.cards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GuiFrame extends JFrame {
	private JPanel cards;
	private JPanel buttons;
	private JButton autoPlay;
	private JButton save;
	private JButton exit;
	private JButton autoMulti;

	public GuiFrame() {
		super("Tom Game");

		
		setPreferredSize(new Dimension(600, 400));
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		save = new JButton("Save Game");
		exit = new JButton("Exit Game");
		autoPlay = new JButton("Play For Me");	
		autoMulti = new JButton("Play For Me x X");
		
		Dimension size = new Dimension (40,10);

		save.setSize(size);
		exit.setSize(size);
		autoPlay.setSize(size);
		autoMulti.setSize(size);
		
		buttons = new JPanel();
		buttons.setLayout(new GridLayout()); //stacks the buttons horizontally
		buttons.add(save);
		buttons.add(exit);
		buttons.add(autoPlay);
		buttons.add(autoMulti);
		
		cards = new JPanel();
		Card card=new Card("b","b","B");
		displayCard(card);
		cards.setLayout(new FlowLayout());
		cards.setBackground(Color.gray);
		JScrollPane scrollbar = new JScrollPane(cards);
		scrollbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		add(scrollbar, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		pack();
		repaint();
		setVisible(true);

	}

	
	public void displayCard(Card card)
	{
		String name = card.getName();
		JLabel cardToDisplay = new JLabel();
		ImageIcon icon = new ImageIcon("cards/" + name + ".gif");
		cardToDisplay.setIcon(icon);
		cards.add(cardToDisplay);
		pack();
	}
}
