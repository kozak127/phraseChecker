package pl.polsl.michal.wesoly.phrasechecker.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import pl.polsl.michal.wesoly.phrasechecker.model.Phrase;
import pl.polsl.michal.wesoly.phrasechecker.view.MainWindow;

public class LoadPhrasesController {

	ArrayList<Phrase> phraseList;
	MainWindow window;

	public LoadPhrasesController(Builder builder) {
		this.phraseList = builder.phraseList;
		this.window = builder.window;
	}

	public void openFileDialog() {
		JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showOpenDialog(window);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				if (!file.canRead()) {
					throw new IOException();
				} else {
					phraseList.clear();
					readFile(file.getPath());
					Collections.sort(phraseList);
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(window,
						"Error while processing file", "IO error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void readFile(String filePath) throws IOException {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while (true) {
			Phrase temporaryPhrase = new Phrase();
			line = bufferedReader.readLine();
			if (line != null) {
				temporaryPhrase.setNativeMeaning(line);
			} else {
				break;
			}
			line = bufferedReader.readLine();
			if (line != null) {
				temporaryPhrase.setForeignMeaning(line);
				phraseList.add(temporaryPhrase);
			} else {
				break;
			}
		}
		bufferedReader.close();
	}
	
	public static class Builder {
		ArrayList<Phrase> phraseList;
		MainWindow window;
		
		public Builder phraseList(ArrayList<Phrase> phraseList) {
			this.phraseList = phraseList;
			return this;
		}
		
		public Builder window(MainWindow window) {
			this.window = window;
			return this;
		}
		
		public LoadPhrasesController build() {
			return new LoadPhrasesController(this);
		}
	}
}
