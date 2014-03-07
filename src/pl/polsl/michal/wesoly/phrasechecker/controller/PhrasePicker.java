package pl.polsl.michal.wesoly.phrasechecker.controller;

import java.util.ArrayList;
import java.util.Collections;

import pl.polsl.michal.wesoly.phrasechecker.model.Phrase;

public class PhrasePicker {
	ArrayList<Phrase> phraseList;

	public PhrasePicker (Builder builder) {
		this.phraseList = builder.phraseList;
	}
	
	public void sortPhrases() {
		Collections.sort(phraseList, Phrase.learnLevelComparator(3));
	}
	
	public Phrase pickPhrase {
		if ()
	}
	
	
	public class Builder {
		ArrayList<Phrase> phraseList;
		
		
		public Builder phraseList(ArrayList<Phrase> phraseList) {
			this.phraseList = phraseList;
			return this;
		}
		
		public PhrasePicker build() {
			return new PhrasePicker(this);
		}
	}
}
