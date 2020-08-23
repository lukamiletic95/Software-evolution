package main.view;

public class Main {

	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                HangmanBoard board = new HangmanBoard(new HangmanInputDialogImp());
                board.setVisible(true);
            }
        });
		
	}

}
