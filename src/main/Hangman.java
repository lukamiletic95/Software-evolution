package main;

public class Hangman {

	private String wordToGuess;
	private int numberOfAttempts;
	
	public Hangman(String wordToGuess, int numberOfAttempts) {
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
