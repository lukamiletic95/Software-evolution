package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;
import main.Constants;
import main.view.HangmanBoard;
import main.view.HangmanInputDialogMock;

class HangmanGUITests {

	@Test
	void testInitHangmanBoard() {
		HangmanBoard board = new HangmanBoard(new HangmanInputDialogMock());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		assertTrue(board.getTitle() == Constants.WINDOW_TITLE);
		assertTrue(board.getWidth() == Constants.WINDOW_WIDTH);
		assertTrue(board.getHeight() == Constants.WINDOW_HEIGHT);
		assertTrue(!board.isResizable());
		assertTrue(board.getDefaultCloseOperation() == JFrame.EXIT_ON_CLOSE);
		assertTrue(board.getLocation().equals(new Point(dim.width / 2 - board.getSize().width / 2, dim.height / 2 - board.getSize().height / 2)));
		assertTrue(board.getWordToGuess().equals(Constants.DIALOG_MOCK_WORD_TO_GUESS.toLowerCase()));
	}
	
}
