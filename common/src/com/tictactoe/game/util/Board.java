/* 
	This package creates the GUI for the Tic Tac Toe game using AWT and Swing. 
*/

package com.tictactoe.game.util;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Board extends JPanel {
	Game game = new Game();
	JButton[] buttons = new JButton[9];
	public Board() {
		// Setting the grid layout as 3x3 for this game
		setLayout(new GridLayout(3, 3));
		initializeButtons();
	}

	// Function to create 9 buttons and add them to the screen
	
	public void initializeButtons() {
        	for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();

			// Setting background of the buttons as white
			buttons[i].setBackground(Color.WHITE);
			buttons[i].setText("");
			buttons[i].setFont(new Font("SansSerif", Font.BOLD, 75));
			buttons[i].setVisible(true);

			// Listener for when the buttons are clicked
			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton buttonClicked = (JButton) e.getSource();

					// Ensures the slot already filled is not updated again.
					if (!buttonClicked.getText().isEmpty()) {
						JOptionPane.showMessageDialog(Board.this, "This slot is taken.", "Slot Taken", JOptionPane.INFORMATION_MESSAGE);
						return;
					}

					// Sets the text of the button according to the value of playerMark
					buttonClicked.setText(String.valueOf(game.getPlayerMark()));

					// Sets the colour of "X" and "O".
					if(buttonClicked.getText().equals("X")) buttonClicked.setForeground(Color.decode("#3E87CA"));
					else buttonClicked.setForeground(Color.decode("#39BCD4"));

					// Alternates the values of playerMark
					if(game.getPlayerMark().equals("X")) game.setPlayerMark("O");
					else if(game.getPlayerMark().equals("O")) game.setPlayerMark("X");

					// Ensures the String array table is correctly filled.
					int buttonIndex = -1;
					for (int j = 0; j < buttons.length; j++) {
						if (buttons[j] == buttonClicked) {
							buttonIndex = j;
							break;
						}
					}

					// Sets the value of playerMark just entered, before alternation, in the table String array.
					if (buttonIndex != -1 && game.getPlayerMark().equals("X")) {
						game.setButtonText("O", buttonIndex);
					}
					if (buttonIndex != -1 && game.getPlayerMark().equals("O")) {
						game.setButtonText("X", buttonIndex);
					}

					// Calls the gameOver() function the moment any three of the conditions are satisfied.
					if(game.checkForWinner("X")|| game.checkForWinner("O") || game.checkDraw()) gameOver();
				}
			});
			add(buttons[i]);
		}
	}

	// When the game is over, it displays any winners or draw.
	public void gameOver() {
		int dialogResult;
		for(int i = 0; i < 9; i++) buttons[i].setEnabled(false);
		if (game.checkForWinner("O")) {
			dialogResult = JOptionPane.showConfirmDialog(Board.this, "CONGRATULATIONS! O WON! Would you like to play again?", "Game over.", JOptionPane.YES_NO_OPTION);
		} else if (game.checkForWinner("X")) {
			dialogResult = JOptionPane.showConfirmDialog(Board.this, "CONGRATULATIONS! X WON! Would you like to play again?", "Game over.", JOptionPane.YES_NO_OPTION);
		} else {
			dialogResult = JOptionPane.showConfirmDialog(Board.this, "It's a draw. Would you like to play again?", "Game over.", JOptionPane.YES_NO_OPTION);
		}
		if(dialogResult == JOptionPane.YES_OPTION) resetTheButtons();
		else System.exit(0);
	}

	//Resets the buttons
	private void resetTheButtons() {
		game.setPlayerMark("X");
		for(int i = 0; i < 9; i++) {
			buttons[i].setText("");
			buttons[i].setEnabled(true);
		}
		game.reset();
	}
}