package main;

import java.util.regex.Pattern;

public class Hangman {

	private String wordToGuess;
	private int numberOfAttempts;
	
	public Hangman(String wordToGuess, int numberOfAttempts) {
		if (numberOfAttempts <= 0) {
			throw new IllegalArgumentException("Invalid number of attempts provided. Number of attempts has to be greater than zero!");
		}
		
		if (!Pattern.matches("[a-zA-Z]+", wordToGuess)) {
			throw new IllegalArgumentException("Invalid word to guess provided. Only english alphabet letters are supported!");	
		}
		
		this.wordToGuess = wordToGuess;
		this.numberOfAttempts = numberOfAttempts;
	}
	
	public String getWordToGuess() {
		return this.wordToGuess;
	}
	
	public int getNumberOfAttempts() {
		return this.numberOfAttempts;
	}
	
}
