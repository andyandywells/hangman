package uk.ac.cam.aw684.oopjava.hangman;

import java.awt.EventQueue;
import java.io.IOException;

public class hangmanGUI extends HangmanImpl {
	static GUIHangman window;
	
	public hangmanGUI(int wordLength) throws IOException {
		super(wordLength);
	}
	
	public static void main(String args[]) throws IOException {
		EventQueue.invokeLater(new Runnable() {
	
		public void run() {
			try {
				window = new GUIHangman();
				
				window.frame.setVisible(true);
				window.frame.setResizable(false);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});


	}

	@Override
	public String getLenInput() {
		// TODO Auto-generated method stub
		
		return Integer.toString(window.getWordLength());
	}

	@Override
	public void print(String[] arr) {
		// TODO Auto-generated method stub
		window.guessDisplayUpdate(arr);
	}

	@Override
	public String getInput() {
		// TODO Auto-generated method stub

		return (window.getLastGuess());
	}
	public void initialise() {
		print(guessArray);
		window.buttonOn();
	}
	public void play() {
		
		if(super.getLives() < 9) {
			System.out.println(word);
			inputCheck(getInput());
			print(guessArray);
			window.livesUpdate(super.getLives());
		}
		if(super.getLives() == 9) {
			window.livesUpdate(super.getLives());
			window.gameOverDisplay("Bad Luck! GAME OVER");
			window.buttonOff();
		}
		
		if(arrayCompare()) {
			window.gameOverDisplay("CONGRATULATIONS! You guessed: " + word + " correctly!");
		}
		System.out.println("lives" + " " + super.getLives());
	}
}
