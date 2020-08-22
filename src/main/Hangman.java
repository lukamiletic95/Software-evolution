package main;

import java.util.regex.Pattern;

public class Hangman {

	public static final int MAX_NUMBER_OF_FAILED_ATTEMPTS_PER_GAME = 6;
	
	private enum GameState {
		InProgress,
		Win,
		Loss
	}
	
	private String wordToGuess;	
	private int currentNumberOfFailedAttempts;
	private GameState gameState;
	
	public Hangman(String wordToGuess) {	
		if (!Pattern.matches("[a-zA-Z]+", wordToGuess)) {
			throw new IllegalArgumentException("Invalid word to guess provided. Only english alphabet letters are supported!");	
		}
		
		this.wordToGuess = wordToGuess.toLowerCase();
		this.currentNumberOfFailedAttempts = 0;
		this.gameState = GameState.InProgress;
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
	
}
