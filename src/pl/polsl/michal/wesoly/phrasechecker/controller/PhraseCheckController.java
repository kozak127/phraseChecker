package pl.polsl.michal.wesoly.phrasechecker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import pl.polsl.michal.wesoly.phrasechecker.exception.NoPhrasesInListException;
import pl.polsl.michal.wesoly.phrasechecker.model.*;
import pl.polsl.michal.wesoly.phrasechecker.view.PhraseCheckWindow;

public class PhraseCheckController implements ActionListener {

	int mistakes = 0;
	int phrasesCountMax = 0;
	int phrasesCounter = 0;
	boolean nativeToForeign = false;
	PhraseCheckWindow window = null;
	ArrayList<Phrase> phraseList = null;
	Phrase phraseToTranslate = null;

	public PhraseCheckController(Builder builder) {
		this.phraseList = builder.phraseList;
		this.nativeToForeign = builder.nativeToForeign;
		this.phrasesCountMax = builder.phrasesCountMax;
	}

	public void startCheck() throws NoPhrasesInListException {

		if (phraseList.isEmpty() == true)
			throw new NoPhrasesInListException();

		Collections.shuffle(this.phraseList);
		this.window = new PhraseCheckWindow(this);

		if (nativeToForeign == true) {
			nextNativePhrase();
		} else {
			nextForeignPhrase();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("translate")) {
			if (this.phrasesCounter < this.phrasesCountMax) {
				translation();
			} else {
				endPhraseCheckSession();
			}
		}
			
		if (e.getActionCommand().equals("cancel")) {
			Collections.sort(this.phraseList);
			this.window.dispose();
		}
	}

	public void nextNativePhrase() {
		this.phraseToTranslate = this.phraseList.get(
				this.phrasesCounter);
		this.window.setPhraseToCheck(this.phraseToTranslate.getNativeMeaning());
		this.phrasesCounter++;
	}

	public void nextForeignPhrase() {
		this.phraseToTranslate = this.phraseList.get(
				this.phrasesCounter);
		this.window
				.setPhraseToCheck(this.phraseToTranslate.getForeignMeaning());
		this.phrasesCounter++;
	}

	public void checkUserTranslation(String rightTranslation) {
		String buffer = this.window.getUserTranslation();
		if (rightTranslation.equals(buffer) == false) {
			this.mistakes++;
			JOptionPane.showMessageDialog(window,
					"Wrong translation. Right translation is: \n"
							+ rightTranslation, "Wrong translation",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void translation() {
			if (this.nativeToForeign == true) {
				checkUserTranslation(this.phraseToTranslate.getForeignMeaning());
				nextNativePhrase();
			} else {
				checkUserTranslation(this.phraseToTranslate.getNativeMeaning());
				nextForeignPhrase();
			}
	}
	
	public void endPhraseCheckSession() {
		checkUserTranslation(this.phraseToTranslate.getForeignMeaning());
		JOptionPane.showMessageDialog(window, "Mistakes: " + this.mistakes
				+ "\n" + "Phrases: " + this.phrasesCounter, "End of check",
				JOptionPane.PLAIN_MESSAGE);
		Collections.sort(this.phraseList);
		this.window.dispose();
	}

	public static class Builder {
		int mistakes = 0;
		int phrasesCountMax = 0;
		int phrasesCounter = 0;
		boolean nativeToForeign;
		PhraseCheckWindow window = null;
		ArrayList<Phrase> phraseList = null;
		Phrase phraseToTranslate = null;

		public Builder mistakes(int mistakes) {
			this.mistakes = mistakes;
			return this;
		}

		public Builder phrasesCountMax(int phrasesCountMax) {
			this.phrasesCountMax = phrasesCountMax;
			return this;
		}

		public Builder phrasesCounter(int phrasesCounter) {
			this.phrasesCounter = phrasesCounter;
			return this;
		}

		public Builder nativeToForeign(boolean nativeToForeign) {
			this.nativeToForeign = nativeToForeign;
			return this;
		}

		public Builder phraseCheckWindow(PhraseCheckWindow window) {
			this.window = window;
			return this;
		}

		public Builder phraseList(ArrayList<Phrase> phraseList) {
			this.phraseList = phraseList;
			return this;
		}

		public Builder phraseToTranslate(Phrase phraseToTranslate) {
			this.phraseToTranslate = phraseToTranslate;
			return this;
		}

		public PhraseCheckController build() {
			return new PhraseCheckController(this);
		}
	}
}
