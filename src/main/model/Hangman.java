package main.model;

import java.util.*;
import java.util.regex.*;

import main.Constants;

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
	
	public String getWordToGuessHidden() {
		char[] wordToGuessHidden = new char[this.wordToGuess.length()];
		
		for (int i = 0; i < this.wordToGuess.length(); i++) {
			char c = this.wordToGuess.charAt(i);
			
			if (this.guessedLetters.contains(c)) {
				wordToGuessHidden[i] = c;
			} else {
				wordToGuessHidden[i] = '#';
			}
		}
		
		return new String(wordToGuessHidden);
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
