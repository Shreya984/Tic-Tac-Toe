/* This package 
	1) Implements the rules of the game.
	2) Maintains the data structure which stores the input.
*/

package com.tictactoe.game.util;
public class Game {
	private String playerMark = "X";

	// Stores X's and O's filled in the 9 slots.
	private String table[] = new String[9];

	// Ensures that the table String array contains empty string and not null value.
	Game() {
		for(int i = 0; i < 9; i++) table[i] = "";
	}

	// Assigns value to playerMark
	public void setPlayerMark(String playerMark) {
		this.playerMark = playerMark;
	}

	// Retrieves value of playerMark
    	public String getPlayerMark() {
        	return this.playerMark;
    	}

	// Fills the text present in the button that was clicked, in the table String array.
    	public void setButtonText(String buttonText, int buttonIndex) {
        	if (buttonIndex < 9) table[buttonIndex] = buttonText;
	}

	// Checks the draw condition
	public boolean checkDraw() {
        	boolean full = true;
        	for (int i = 0; i < 9; i++) {
        		if (table[i].equals("")) {
                		full = false;
                		break;
            		}
        	}
        	return full;
    	}

	// Checks if the playerMark entered as parameter has won the game or not.
	public boolean checkForWinner(String mark) {
		if(checkRows(mark) == true || checkColumns(mark) == true || checkDiagonals(mark) == true) return true;
		else return false;
	}
	
	// Checks the row condition for winning.
	public boolean checkRows(String mark) {
		if(table[0].equals(mark) && table[1].equals(mark) && table[2].equals(mark)) return true;
		if(table[3].equals(mark) && table[4].equals(mark) && table[5].equals(mark)) return true;
		if(table[6].equals(mark) && table[7].equals(mark) && table[8].equals(mark)) return true;
		return false;
	}

	// Checks the column condition for winning.
	public boolean checkColumns(String mark) {
		if(table[0].equals(mark) && table[3].equals(mark) && table[6].equals(mark)) return true;
		if(table[1].equals(mark) && table[4].equals(mark) && table[7].equals(mark)) return true;
		if(table[2].equals(mark) && table[5].equals(mark) && table[8].equals(mark)) return true;
		return false;
	}

	// Checks the diagonal condition for winning.
	public boolean checkDiagonals(String mark) {
		if(table[0].equals(mark) && table[4].equals(mark) && table[8].equals(mark)) return true;
		else if(table[2].equals(mark) && table[4].equals(mark) && table[6].equals(mark)) return true;
		return false;
	}

	// Sets all the elements of the table String array as empty string after resetTheButtons() method is called i.e., when the game is played again.
	public void reset() {
		for(int i = 0; i < this.table.length; i++) this.table[i] = "";
	}
}