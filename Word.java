package uk.ac.cam.aw684.oopjava.hangman;

public class Word {
	private String word;
	private int length;
	public Word(String w) {
		word = w;
		length = word.length();
	}
	public String getWord() {
		return word;
	}
	public int getLength() {
		return length;
	}

}
