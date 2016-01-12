package uk.ac.cam.aw684.oopjava.hangman;

import java.io.IOException;
import java.util.Scanner;

public class hangmanTEXT extends HangmanImpl{

	public hangmanTEXT(int wordLength) throws IOException {
		super(wordLength);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int wordLen = in.nextInt();
		hangmanTEXT newGame = new hangmanTEXT(wordLen);
		newGame.play();
	}

	@Override
	public String getInput() {
		Scanner input = new Scanner(System.in);
		System.out.println(input.nextLine());
		return input.nextLine();	

	}
	
	@Override
	public String getLenInput() {
		Scanner input = new Scanner(System.in);
		System.out.println(input.nextLine());
		return input.nextLine();	

	}
	
	public void print(String[] arr) {
		for (String s : arr) {
			System.out.print(s);
		}
		System.out.println();
	}

	public void play() {

		for (String s : wordArray) {
			System.out.print(s);
		}
		while (!arrayCompare() && getLives() < 10) {
			inputCheck(getInput());
			
			System.out.println("Lives: " + (10 - getLives()));
		}
		if(!arrayCompare() || getLives() == 9) {
			System.out.println("you lose");
		}
		else {
			System.out.println("you win!");
		}

	}

}
