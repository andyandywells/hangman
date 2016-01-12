package uk.ac.cam.aw684.oopjava.hangman;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public abstract class HangmanImpl implements HangmanInterface {
	private int wordLength;
	private int lives = 1;
	protected String word;
	private String guess;
	protected String[] wordArray;
	protected String[] guessArray;


	public String getWord() {
		return word;
	}

	public HangmanImpl(int wordLength) throws IOException {
		this.wordLength = wordLength;
	
		wordLoader load = new wordLoader();
		word = load.loader(wordLength);
		wordArray = new String[getWordLength()];
		guessArray = new String[getWordLength()];

		for (int i = 0; i < word.length(); i++) {
			wordArray[i] = word.charAt(i) + " ";
		}
		for (int i = 0; i < word.length(); i++) {
			guessArray[i] = " _ ";
		}

	}

	public int getLives() {
		return this.lives;
	}
	public void setLives(int l) {
		this.lives = l;
	}
	@Override
	public int getWordLength() {
		return this.wordLength;
	}

	public abstract void play();

	

	public void inputCheck(String inputGuess) {

		String[] temp = new String[getWordLength()];
		for(int i = 0; i < getWordLength(); i++) {
			temp[i] = guessArray[i];
		}
		for (int i = 0; i < getWordLength(); i++) {
			if (wordArray[i].equals(inputGuess + " ")) {
				guessArray[i] = wordArray[i];
				
			} 
		}
		print(guessArray);
		
		if(Arrays.equals(temp, guessArray)) {
			lives++;
		}
		
	}

	public Boolean arrayCompare() {
		if (Arrays.equals(guessArray, wordArray)) {
			return true;
		} else {
			return false;
		}
	}

	public abstract String getInput();
	public abstract void print(String[] arr);

	public String getLenInput() {
		// TODO Auto-generated method stub
		return null;
	}
}
