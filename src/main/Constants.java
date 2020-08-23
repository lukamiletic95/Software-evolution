package main;

public final class Constants {

	public static final int MAX_NUMBER_OF_FAILED_ATTEMPTS_PER_GAME = 6;
	public static final String INVALID_WORD_TO_GUESS_MESSAGE = "Invalid word to guess provided. Only english alphabet letters are supported!";
	
	
	public static final String WINDOW_TITLE = "MS1ES_ml183164m Hangman";
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 500;
	
	public static final String DIALOG_TITLE = "Welcome to Hangman!";
	public static final String DIALOG_LABEL = "Enter word to guess: ";
	public static final String DIALOG_MOCK_WORD_TO_GUESS = "SoftwareEvolution";
	
	public static final String GUESS_INFO_PANEL_NAME = "guessInfo";
	public static final String GUESS_INFO_WORD_LABEL_TEXT = "Word currently being guessed: ";
	public static final String GUESS_INFO_WORD_LABEL_NAME = "guessInfoWord";
	public static final String GUESS_INFO_FAILED_ATTEMPTS_LABEL_TEXT = "Number of failed attempts: ";
	public static final String GUESS_INFO_FAILED_ATTEMPTS_LABEL_NAME = "guessInfoFailedAttempts";
}
