package pl.polsl.michal.wesoly.phrasechecker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pl.polsl.michal.wesoly.phrasechecker.view.SettingsWindow;

public class SettingsController implements ActionListener {
	SettingsWindow window = null;
	int phrasesCountDefinedMax;
	
	public SettingsController(Builder builder){
		this.window = builder.window;
		this.phrasesCountDefinedMax = builder.phrasesCountDefinedMax;
	}

	public void displayWindow() {
		this.window = new SettingsWindow(this);
		String temporary = Integer.toString(phrasesCountDefinedMax);
		window.setPhrasesNumberInSingleSessionTextField(temporary);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("done")) {
			String temporary = window.getPhrasesNumberInSingleSession();
			phrasesCountDefinedMax = Integer.parseInt(temporary);
			window.dispose();
		}

		if (e.getActionCommand().equals("cancel")) {
			window.dispose();
		}
	}
	
	public static class Builder{
		SettingsWindow window;
		int phrasesCountDefinedMax;
				
		public Builder settingsWindow(SettingsWindow window) {
			this.window = window;
			return this;
		}
		
		public Builder phrasesCountDefinedMax(int phrasesCountDefinedMax) {
			this.phrasesCountDefinedMax = phrasesCountDefinedMax;
			return this;
		}
		
		public SettingsController build(){
			return new SettingsController(this);
		}
	}
}
