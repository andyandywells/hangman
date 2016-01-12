package uk.ac.cam.aw684.oopjava.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class wordLoader {
	static List<Word> dictionary = new ArrayList<Word>();
	protected String fileName = "/Users/Andy/Downloads/OOPIncompleteWordGame-master/src/main/resources/words.txt";
	private int maxLen;
	private int minLen;

	
	public String loader(int n) throws IOException {
		loadFromDisk(fileName);
		Collections.sort(dictionary, new Comparator<Word>() {
			public int compare(Word w1, Word w2) {
				return w1.getLength() - w2.getLength();
			}
		});
		maxLen = dictionary.get(dictionary.size()-1).getLength();
		minLen = dictionary.get(0).getLength();

		if(n >= minLen && n <= maxLen) {
			return getRandomWord(n);
		}
		else {
			System.out.println("no words of length " + n + " exist");
			return null;
		}
		
		
	}
	public static List<Word> load(Reader r) throws IOException {
		BufferedReader buff = new BufferedReader(r);
		String line = buff.readLine();

		while (line != null) {
			Word w = new Word(line);
			dictionary.add(w);

			line = buff.readLine();
		}
		return dictionary;
	}

	public static List<Word> loadFromDisk(String filename) throws IOException {
		return load(new FileReader(filename));
	}

	public static List<Word> loadFromURL(String url) throws IOException {
		URL destination = new URL(url);
		URLConnection conn = destination.openConnection();
		return load(new InputStreamReader(conn.getInputStream()));
	}

	public static String getRandomWord(int n) {
		
		String word = null;
		Boolean con = true;
		while (con) {
			int index = (int) Math.ceil(Math.random() * dictionary.size());
			
			if (dictionary.get(index).getLength() == n) {
				word = dictionary.get(index).getWord();
				con = false;
			} else {
				continue;
			}
		}
		return word;
	}

}
