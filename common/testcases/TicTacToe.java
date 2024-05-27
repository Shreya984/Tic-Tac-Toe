/*
	TicTacToe class contains the entry point function.
	It creates the frame and adds the Board object to it.
*/

// Importing the Board package,Game package and JFrame package.
import com.tictactoe.game.util.*;
import javax.swing.JFrame;
class TicTacToe{
	public static void main(String args[]) {
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Board()); 
		frame.setBounds(600, 600, 600, 600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}