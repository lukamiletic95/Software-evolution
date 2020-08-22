package test;

import static org.junit.jupiter.api.Assertions.*;

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

}
