package main;

import java.util.*;
import java.util.regex.*;

public class Hangman {
	
	private enum GameState {
		InProgress,
		Win,
		Loss
	}
	
	private String wordToGuess;	
	private int currentNumberOfFailedAttempts;
	private long numberOfDistinctCharacters;
	private GameState gameState;
	private HashSet<Character> guessedLetters;
	
	public Hangman(String wordToGuess) {	
		if (!Pattern.matches("[a-zA-Z]+", wordToGuess)) {
			throw new IllegalArgumentException(Constants.INVALID_WORD_TO_GUESS_MESSAGE);	
		}
		
		this.wordToGuess = wordToGuess.toLowerCase();
		this.currentNumberOfFailedAttempts = 0;
		this.numberOfDistinctCharacters = this.wordToGuess.chars().distinct().count();
		this.gameState = GameState.InProgress;
		this.guessedLetters = new HashSet<Character>();
	}
	
	public String getWordToGuess() {
		return this.wordToGuess;
	}
	
	public int getCurrentNumberOfFailedAttempts() {
		return this.currentNumberOfFailedAttempts;
	}
	
	public boolean isWin() {
		return this.gameState.equals(GameState.Win);
	}
	
	public boolean isLoss() {
		return this.gameState.equals(GameState.Loss);
	}
	
	public boolean guess(char c) {
		c = Character.toLowerCase(c);		
		
		if (this.wordToGuess.indexOf(c) != -1) {			
			this.guessedLetters.add(c);
			
			if (this.guessedLetters.size() == this.numberOfDistinctCharacters) {
				this.gameState = GameState.Win;
			}
			
			return true;
		} else {
			this.currentNumberOfFailedAttempts++;
			
			if (this.currentNumberOfFailedAttempts == Constants.MAX_NUMBER_OF_FAILED_ATTEMPTS_PER_GAME) {
				this.gameState = GameState.Loss;
			}
			
			return false;
		}
	}
	
}
