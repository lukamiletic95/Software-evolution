package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.*;
import javax.swing.*;

import org.junit.jupiter.api.Test;
import org.uispec4j.Panel;
import org.uispec4j.Window;

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
	
	@Test
	void testAddGuessInfoToHangmanBoard() {
		HangmanBoard board = new HangmanBoard(new HangmanInputDialogMock());
		Window window = new Window(board);
		
		Panel guessInfo = window.getPanel(Constants.GUESS_INFO_PANEL_NAME);
		assertTrue(guessInfo.getAwtContainer() instanceof JPanel);
		assertTrue(guessInfo.getAwtContainer().getComponentCount() == 2);
		
		assertTrue(guessInfo.getAwtContainer().getComponent(0).getName().equals(Constants.GUESS_INFO_WORD_LABEL_NAME));
		assertTrue(guessInfo.getAwtContainer().getComponent(1).getName().equals(Constants.GUESS_INFO_FAILED_ATTEMPTS_LABEL_NAME));
		
		assertTrue(((JLabel)guessInfo.getAwtContainer().getComponent(0)).getText().contains(Constants.GUESS_INFO_WORD_LABEL_TEXT));
		assertTrue(((JLabel)guessInfo.getAwtContainer().getComponent(1)).getText().contains(Constants.GUESS_INFO_FAILED_ATTEMPTS_LABEL_TEXT));
	}
	
}
