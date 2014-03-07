package pl.polsl.michal.wesoly.phrasechecker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import pl.polsl.michal.wesoly.phrasechecker.exception.NoPhrasesInListException;
import pl.polsl.michal.wesoly.phrasechecker.model.*;
import pl.polsl.michal.wesoly.phrasechecker.view.*;

public class MainController implements ActionListener {

	MainWindow window;

	ArrayList<Phrase> phraseList;
	int phrasesCountMax, phrasesCountDefinedMax;

	public MainController(ArrayList<Phrase> phraseList, int maxPhrasesCount) {
		this.phrasesCountDefinedMax = maxPhrasesCount;
		this.phraseList = phraseList;
	}

	public void mainWindow() {
		this.window = new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("checkNative")) {
			this.phrasesCountMax = checkedPhrasesCountMax(phrasesCountDefinedMax);
			PhraseCheckController phraseCheckController = new PhraseCheckController.Builder()
					.phrasesCountMax(this.phrasesCountMax)
					.nativeToForeign(true).phraseList(this.phraseList).build();
			tryPhraseCheck(phraseCheckController);
		}

		if (e.getActionCommand().equals("checkForeign")) {
			this.phrasesCountMax = checkedPhrasesCountMax(phrasesCountDefinedMax);
			PhraseCheckController phraseCheckController = new PhraseCheckController.Builder()
					.phrasesCountMax(this.phrasesCountMax)
					.nativeToForeign(false).phraseList(this.phraseList).build();
			tryPhraseCheck(phraseCheckController);
		}

		if (e.getActionCommand().equals("manipulate")) {
			ManipulateListController manipulateListController = new ManipulateListController.Builder()
					.phraseList(this.phraseList).build();
			manipulateListController.displayWindow();
		}
		
		if (e.getActionCommand().equals("settings")) {
			SettingsController settingsController = new SettingsController.Builder()
					.phrasesCountDefinedMax(phrasesCountDefinedMax).build();
			settingsController.displayWindow();
		}

		if (e.getActionCommand().equals("list")) {
			ListPhraseController listPhraseController = new ListPhraseController.Builder()
					.phraseList(this.phraseList).build();
			listPhraseController.listPhrases();
		}

		if (e.getActionCommand().equals("load")) {
			LoadPhrasesController loadPhrasesController = new LoadPhrasesController.Builder()
					.phraseList(this.phraseList).window(this.window).build();
			loadPhrasesController.openFileDialog();
		}

		if (e.getActionCommand().equals("save")) {
			SavePhrasesController savePhrasesController = new SavePhrasesController.Builder()
					.phraseList(phraseList).window(this.window).build();
			savePhrasesController.saveFileDialog();
		}

		if (e.getActionCommand().equals("exit")) {
			System.exit(0);
		}
	}

	public int checkedPhrasesCountMax(int phrasesCountDefinedMax) {
		int phrasesCountMax = phraseList.size();
		if (phrasesCountMax > phrasesCountDefinedMax) {
			phrasesCountMax = phrasesCountDefinedMax;
		}
		return phrasesCountMax;
	}

	public void tryPhraseCheck(PhraseCheckController controller) {
		try {
			controller.startCheck();
		} catch (NoPhrasesInListException e1) {
			JOptionPane.showMessageDialog(this.window,
					"No phrases to check. Populate list first",
					"Empty list error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
