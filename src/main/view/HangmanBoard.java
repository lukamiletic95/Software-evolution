package main.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import main.Constants;
import main.model.Hangman;

public class HangmanBoard extends JFrame {

	private Hangman model;

	public HangmanBoard(HangmanInputDialog inputDialog) {
		setTitle(Constants.WINDOW_TITLE);
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		
		String wordToGuess = getWordToGuess(inputDialog);
		model = new Hangman(wordToGuess);
	}

	private String getWordToGuess(HangmanInputDialog inputDialog) {
		String wordToGuess = inputDialog.showInputDialog(this, Constants.DIALOG_LABEL, Constants.DIALOG_TITLE, JOptionPane.QUESTION_MESSAGE);

		while (wordToGuess == null || wordToGuess.isEmpty()) {
			wordToGuess = inputDialog.showInputDialog(this, Constants.DIALOG_LABEL, Constants.DIALOG_TITLE, JOptionPane.QUESTION_MESSAGE);
		}

		return wordToGuess;
	}
	
	public String getWordToGuess() {
		return (model == null) ? null : model.getWordToGuess();
	}

}
