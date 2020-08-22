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
		
		assertTrue(game.getWordToGuess().toLowerCase().equals(wordToGuess));
		assertTrue(game.getCurrentNumberOfAttempts() + Hangman.MAX_NUMBER_OF_ATTEMPTS_PER_GAME == Hangman.MAX_NUMBER_OF_ATTEMPTS_PER_GAME);
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

}
