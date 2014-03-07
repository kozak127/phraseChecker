package pl.polsl.michal.wesoly.phrasechecker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import pl.polsl.michal.wesoly.phrasechecker.view.ManipulateEntriesWindow;
import pl.polsl.michal.wesoly.phrasechecker.exception.DuplicatePhraseException;
import pl.polsl.michal.wesoly.phrasechecker.exception.PhraseNotFoundException;
import pl.polsl.michal.wesoly.phrasechecker.model.*;

public class ManipulateListController implements ActionListener {
	ManipulateEntriesWindow window = null;
	ArrayList<Phrase> phraseList = null;

	public ManipulateListController(Builder builder) {
		this.phraseList = builder.phraseList;
		this.window = builder.window;
	}

	public void displayWindow() {
		this.window = new ManipulateEntriesWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("add")) {
			tryAddPhrase();
			window.dispose();
		}
		if (e.getActionCommand().equals("remove")) {
			tryRemovePhrase();
			window.dispose();
		}
		if (e.getActionCommand().equals("cancel")) {
			window.dispose();
		}
	}

	private ArrayList<String> getPhraseDataFromWindow() {
		ArrayList<String> phraseData = new ArrayList<String>();
		phraseData.add(window.getPhraseNativeMeaning());
		phraseData.add(window.getPhraseForeignMeaning());
		return phraseData;
	}

	public void tryAddPhrase() {
		try {
			addPhrase(getPhraseDataFromWindow());
		} catch (DuplicatePhraseException e) {
			JOptionPane.showMessageDialog(this.window,
					"Duplicate phrases found. Phrase not added",
					"Phrase list error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void tryRemovePhrase() {
		try {
			removePhrase(getPhraseDataFromWindow());
		} catch (PhraseNotFoundException e) {
			JOptionPane.showMessageDialog(this.window,
					"Phrase not found. Phrase not deleted",
					"Phrase list error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void addPhrase(ArrayList<String> phraseData)
			throws DuplicatePhraseException {
		for (Phrase phrase : phraseList) {
			if ((phrase.getNativeMeaning().equals(phraseData.get(0)))
					|| (phrase.getForeignMeaning().equals(phraseData.get(1)))) {
				throw new DuplicatePhraseException();
			}
		}
		phraseList.add(
				new Phrase(phraseData.get(0), phraseData.get(1)));
		Collections.sort(phraseList);
	}

	public void removePhrase(ArrayList<String> phraseData)
			throws PhraseNotFoundException {
		for (Phrase phrase : phraseList) {
			if ((phrase.getNativeMeaning().equals(phraseData.get(0)))
					&& (phrase.getForeignMeaning().equals(phraseData.get(1)))) {
				phraseList.remove(phrase);

			}
		}
		throw new PhraseNotFoundException();
	}

	public static class Builder {
		ManipulateEntriesWindow window;
		ArrayList<Phrase> phraseList;

		public Builder phraseList(ArrayList<Phrase> phraseList) {
			this.phraseList = phraseList;
			return this;
		}

		public Builder manipulateEntriesWindow(ManipulateEntriesWindow window) {
			this.window = window;
			return this;
		}

		public ManipulateListController build() {
			return new ManipulateListController(this);
		}
	}
}
