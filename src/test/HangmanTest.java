package test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import main.Hangman;

class HangmanTest {

	@Test
	void testInitialGameState() {
		String wordToGuess = "SoftwareEvolution";
		int numberOfAttempts = 10;
		
		Hangman game = new Hangman(wordToGuess, numberOfAttempts);
		
		assertTrue(game.getWordToGuess().equals(wordToGuess));
		assertTrue(game.getNumberOfAttempts() == numberOfAttempts);
	}
	
	@Test
	void testInitialGameStateNonAlphabeticWord() {
		Exception ex = assertThrows(
				IllegalArgumentException.class,
				() -> new Hangman("ЕволуцијаСофтвера", 10)); 
		
		assertTrue(ex instanceof IllegalArgumentException);
		assertTrue(ex.getMessage().equals("Invalid word to guess provided. Only english alphabet letters are supported!"));
	}
	
	@Test
	void testInitialGameStateInvalidNumberOfAttempts() {
		Exception ex = assertThrows(
				IllegalArgumentException.class,
				() -> new Hangman("SoftwareEvolution", -10)); 
		
		assertTrue(ex instanceof IllegalArgumentException);
		assertTrue(ex.getMessage().equals("Invalid number of attempts provided. Number of attempts has to be greater than zero!"));
	}

}
