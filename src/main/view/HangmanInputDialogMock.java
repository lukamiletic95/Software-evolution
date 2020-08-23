package main.view;

import java.awt.Component;
import main.Constants;

public class HangmanInputDialogMock implements HangmanInputDialog {

	@Override
	public String showInputDialog(Component parentComponent, Object message, String title, int messageType) {
		return Constants.DIALOG_MOCK_WORD_TO_GUESS;
	}

}
