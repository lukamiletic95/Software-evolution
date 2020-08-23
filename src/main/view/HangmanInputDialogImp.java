package main.view;

import java.awt.Component;
import javax.swing.JOptionPane;

public class HangmanInputDialogImp implements HangmanInputDialog {

	@Override
	public String showInputDialog(Component parentComponent, Object message, String title, int messageType) {
		return JOptionPane.showInputDialog(parentComponent, message, title,	messageType);
	}

}
