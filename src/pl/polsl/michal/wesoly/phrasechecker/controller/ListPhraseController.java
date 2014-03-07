package pl.polsl.michal.wesoly.phrasechecker.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import pl.polsl.michal.wesoly.phrasechecker.model.Phrase;
import pl.polsl.michal.wesoly.phrasechecker.view.ListPhrasesWindow;

public class ListPhraseController {
	ListPhrasesWindow window;
	ArrayList<Phrase> phraseList;

	public ListPhraseController(Builder builder) {
		this.phraseList = builder.phraseList;
		this.window = builder.window;
	}

	public void listPhrases() {
		Collections.sort(phraseList);

		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Native");
		columnNames.add("Foreign");

		@SuppressWarnings("rawtypes")
		Vector<Vector> tableData = new Vector<Vector>();
		for (Phrase phrase : phraseList) {
			Vector<String> rowData = new Vector<String>();
			rowData.add(phrase.getNativeMeaning());
			rowData.add(phrase.getForeignMeaning());
			tableData.add(rowData);
		}

		@SuppressWarnings("unused")
		ListPhrasesWindow window = new ListPhrasesWindow(tableData,
				columnNames);
	}
	
	public static class Builder {
		ListPhrasesWindow window;
		ArrayList<Phrase> phraseList;
		
		public Builder window(ListPhrasesWindow window) {
			this.window = window;
			return this;
		}
		
		public Builder phraseList(ArrayList<Phrase> phraseList) {
			this.phraseList = phraseList;
			return this;
		}
		
		public ListPhraseController build() {
			return new ListPhraseController(this);
		}
	}
}
