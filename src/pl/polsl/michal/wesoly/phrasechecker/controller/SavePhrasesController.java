package pl.polsl.michal.wesoly.phrasechecker.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import pl.polsl.michal.wesoly.phrasechecker.model.Phrase;
import pl.polsl.michal.wesoly.phrasechecker.view.MainWindow;

public class SavePhrasesController {
	ArrayList<Phrase> phraseList;
	MainWindow window;

	public SavePhrasesController(Builder builder) {
		this.phraseList = builder.phraseList;
		this.window = builder.window;
	}

	public void saveFileDialog() {
		JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showSaveDialog(window);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				if (!file.canWrite()) {
					throw new IOException();
				} else {
					Collections.sort(phraseList);
					saveFile(file.getPath());
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(window,
						"Error while processing file", "IO error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void saveFile(String filePath) throws IOException {
		FileWriter fileWriter = new FileWriter(filePath);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for (Phrase phrase : phraseList) {
			bufferedWriter.write(phrase.getNativeMeaning() + "\n");
			bufferedWriter.write(phrase.getForeignMeaning() + "\n");
		}
		bufferedWriter.close();
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
		
		public SavePhrasesController build() {
			return new SavePhrasesController(this);
		}
	}
}
