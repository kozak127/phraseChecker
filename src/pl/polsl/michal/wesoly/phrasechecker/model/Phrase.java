package pl.polsl.michal.wesoly.phrasechecker.model;

import java.util.Comparator;

public class Phrase implements Comparable<Phrase> {

	public Phrase(String nativeMeaning, String foreignMeaning) {
		this.nativeMeaning = nativeMeaning;
		this.foreignMeaning = foreignMeaning;
	}

	public Phrase() {
		this.nativeMeaning = null;
		this.foreignMeaning = null;
	}

	String nativeMeaning;
	String foreignMeaning;
	int errorsInTranslation;
	int attemptsToTranslation;
	boolean usedInSession;
	
	public static Comparator<Phrase> learnLevelComparator(final int minNumberOfRepeatToLearn) {
		return new Comparator<Phrase>() {

			@Override
			public int compare(Phrase arg0, Phrase arg1) {
				if (arg0.getAttemptsToTranslation() < minNumberOfRepeatToLearn) {
					return 0;
				} else if (arg1.getAttemptsToTranslation() < minNumberOfRepeatToLearn) {
					return 1;
				} else if (arg0.getErrorsToAttempts() <= arg1.getErrorsToAttempts()) {
					return 0;
				} else {
					return 1;
				}
			}
		};
	}
	
	public float getErrorsToAttempts() {
		float toReturn = (this.errorsInTranslation / this.attemptsToTranslation);
		return toReturn;
	}
	
	public int compareTo(Phrase phraseToCompare) {
		return this.nativeMeaning.compareTo(phraseToCompare.getNativeMeaning());
	}

	public String getNativeMeaning() {
		return nativeMeaning;
	}

	public void setNativeMeaning(String nativeMeaning) {
		this.nativeMeaning = nativeMeaning;
	}

	public String getForeignMeaning() {
		return foreignMeaning;
	}

	public void setForeignMeaning(String foreignMeaning) {
		this.foreignMeaning = foreignMeaning;
	}

	public int getErrorsInTranslation() {
		return errorsInTranslation;
	}

	public void setErrorsInTranslation(int errorsInTranslation) {
		this.errorsInTranslation = errorsInTranslation;
	}

	public int getAttemptsToTranslation() {
		return attemptsToTranslation;
	}

	public void setAttemptsToTranslation(int attemptsToTranslation) {
		this.attemptsToTranslation = attemptsToTranslation;
	}
}
