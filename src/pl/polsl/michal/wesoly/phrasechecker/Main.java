package pl.polsl.michal.wesoly.phrasechecker;

import java.util.ArrayList;

import pl.polsl.michal.wesoly.phrasechecker.controller.MainController;
import pl.polsl.michal.wesoly.phrasechecker.model.Phrase;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxPhrasesCount = 10;
		if (args.length > 0) {
			try {
				maxPhrasesCount = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Argument" + " must be an integer");
				System.exit(1);
			}
		}

		ArrayList<Phrase> phraseList = new ArrayList<Phrase>();
		MainController mainController = new MainController(phraseList, maxPhrasesCount);

		mainController.mainWindow();
	}

}