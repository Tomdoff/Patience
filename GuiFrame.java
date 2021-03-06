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

public class GuiFrame extends JFrame {
private JPanel cards;
private JPanel buttons;
private JButton autoPlay;
private JButton save;
private JButton exit;
private JButton autoMulti;

	private static final long serialVersionUID = 1L;

	private GuiFrame() {


		super("tom game");
		
		Card test = new Card("3h", "h", "3");
		Card test1 = new Card("3d", "d", "3");
		
		setSize(1200, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cards = new JPanel();
		displayCard(test);
		displayCard(test1);
		cards.setLayout(new FlowLayout());
		cards.setBackground(Color.gray);
		buttons = new JPanel();
		save = new JButton("Save Game");
		exit = new JButton("Exit Game");
		autoPlay = new JButton("Play For Me");
		autoMulti = new JButton("Play For Me x X");
		
		buttons.setLayout(new GridLayout()); //stacks the buttons
		
		Dimension size = new Dimension (40,10);
		save.setSize(size);
		exit.setSize(size);
		autoPlay.setSize(size);
		autoMulti.setSize(size);
		

		
		buttons.add(save);
		buttons.add(exit);
		buttons.add(autoPlay);
		buttons.add(autoMulti);
		buttons.validate();
		add(cards, BorderLayout.CENTER);
		add(buttons, BorderLayout.PAGE_END);

	}

	public static void main(String[] args) {
		GuiFrame frame = new GuiFrame();
		frame.setVisible(true);
		
	}

	public void displayCard(Card card)
	{
		String name = card.getName();
		JLabel cardToDisplay = new JLabel();
		ImageIcon icon = new ImageIcon("cards/" + name + ".gif");
		cardToDisplay.setIcon(icon);
		cardToDisplay.setSize(MAXIMIZED_HORIZ, MAXIMIZED_VERT);
		cards.add(cardToDisplay);
		cards.add(cardToDisplay, BorderLayout.NORTH);
		cards.repaint();

	}
}
