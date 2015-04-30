/**
 * @author Tom Doyle
 */

package uk.ac.aber.dcs.cs12320.cards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class GuiFrame extends JFrame {
private JPanel cards;
private JPanel buttons;
private JButton autoPlay;
private JButton save;
private JButton exit;
private JButton autoMulti;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GuiFrame() {


		super("tom game");
		
		setSize(1200, 300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cards = new JPanel();
		cards.setBackground(Color.YELLOW);
		buttons = new JPanel();
		buttons.setBackground(Color.BLUE);
		save = new JButton("Save Game");
		exit = new JButton("Exit Game");
		autoPlay = new JButton("Play For Me");
		autoMulti = new JButton("Play For Me x X");
		
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS)); //stacks the buttons
		
		buttons.add(save);
		buttons.add(exit);
		buttons.add(autoPlay);
		buttons.add(autoMulti);
		buttons.validate();
		add(cards, BorderLayout.CENTER);
		add(buttons, BorderLayout.LINE_END);

	}

	public static void main(String[] args) {
		GuiFrame frame = new GuiFrame();
		frame.setVisible(true);
		
	}

}
