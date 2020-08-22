package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HangmanTest {

	/**
	 * Tests whether the game is properly initialized.
	 * The game receives two parameters upon initialization:
	 *	1) A word to be guessed
	 *	2) Number of attempts given to the user
	 */
	@Test
	void testInitialGameState() 
	{
		string wordToGuess = "SoftwareEvolution";
		int numberOfAttempts = 10;
		
		Hangman game = new Hangman(wordToGuess, numberOfAttempts);
		
		assertTrue(game.getWordToGuess().Equals(wordToGuess));
		assertTrue(game.getNumberOfAttempts() == numberOfAttempts);
	}

}
