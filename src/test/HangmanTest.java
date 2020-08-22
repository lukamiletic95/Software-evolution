package test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import main.Hangman;

class HangmanTest {

	@Test
	void testInitialGameState() {
		String wordToGuess = "SoftwareEvolution";
		Hangman game = new Hangman(wordToGuess);
		
		assertTrue(game.getWordToGuess().equals(wordToGuess.toLowerCase()));
		assertTrue(game.getCurrentNumberOfFailedAttempts() + Hangman.MAX_NUMBER_OF_FAILED_ATTEMPTS_PER_GAME == Hangman.MAX_NUMBER_OF_FAILED_ATTEMPTS_PER_GAME);
		assertTrue(!game.isWin());
		assertTrue(!game.isLoss());
	}
	
	@Test
	void testInitialGameStateNonAlphabeticWord() {
		Exception ex = assertThrows(
				IllegalArgumentException.class,
				() -> new Hangman("ЕволуцијаСофтвера")); 
		
		assertTrue(ex instanceof IllegalArgumentException);
		assertTrue(ex.getMessage().equals("Invalid word to guess provided. Only english alphabet letters are supported!"));
	}
	
	@Test
	void testHangmanWin() {
		String wordToGuess = "SoftwareEvolution";
		Hangman game = new Hangman(wordToGuess);
		
		assertTrue(game.guess('s'));
		assertTrue(game.guess('o'));
		assertTrue(!game.guess('x'));
		assertTrue(game.guess('f'));
		assertTrue(game.guess('t'));
		assertTrue(!game.guess('d'));
		assertTrue(game.guess('w'));
		assertTrue(game.guess('a'));
		assertTrue(game.guess('r'));
		assertTrue(game.guess('e'));
		assertTrue(game.guess('v'));
		assertTrue(!game.guess('p'));
		assertTrue(game.guess('l'));
		assertTrue(game.guess('u'));
		assertTrue(game.guess('i'));
		assertTrue(game.guess('n'));
		
		assertTrue(game.getCurrentNumberOfFailedAttempts() == 3);
		assertTrue(game.isWin());
		assertTrue(!game.isLoss());
	}
	
	@Test
	void testHangmanLoss() {
		String wordToGuess = "SoftwareEvolution";
		Hangman game = new Hangman(wordToGuess);
		
		assertTrue(!game.guess('x'));
		assertTrue(!game.guess('y'));
		assertTrue(!game.guess('z'));
		assertTrue(!game.guess('q'));
		assertTrue(!game.guess('p'));
		assertTrue(!game.guess('k'));
		
		assertTrue(game.getCurrentNumberOfFailedAttempts() == Hangman.MAX_NUMBER_OF_FAILED_ATTEMPTS_PER_GAME);
		assertTrue(!game.isWin());
		assertTrue(game.isLoss());
	}
	
	@Test
	void testMaxNumberOfFailedAttemptsExceeded() {
		String wordToGuess = "SoftwareEvolution";
		Hangman game = new Hangman(wordToGuess);
		
		assertTrue(!game.guess('x'));
		assertTrue(!game.guess('y'));
		assertTrue(!game.guess('z'));
		assertTrue(!game.guess('q'));
		assertTrue(!game.guess('p'));
		assertTrue(!game.guess('k'));
		
		Exception ex = assertThrows(
			IllegalStateException.class,
			() -> game.guess('s'));
		
		assertTrue(ex instanceof IllegalStateException);
		assertTrue(ex.getMessage().equals("Cannot invoke a guess action when the maximum number of failed attempts has been reached!"));
	}

}
