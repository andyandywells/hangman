package uk.ac.cam.aw684.oopjava.hangman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.util.*;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;

public class GUIHangman {

	JFrame frame;
	private hangmanGUI start;
	private JLabel lblGuessArray;
	private String lastGuess;
	private int wordLength;
	private JLabel lblLives;
	private ImageIcon[] images;
	private JPanel livesPanel;
	private JButton[] buttonArray;
	public int getWordLength() {
		return wordLength;
	}
	public String getLastGuess() {
		return lastGuess;
	}
	/**
	 * Create the application.
	 */
	public GUIHangman() {

		initialize();
	}
	public void guessDisplayUpdate(String[] guessArray) {
		String out = "";
		for(int i=0;i<guessArray.length;i++) {
			out+=guessArray[i];
		}
		lblGuessArray.setText(out);
	}
	public void gameOverDisplay(String s) {
		lblGuessArray.setText(s);
	}
	public void livesUpdate(int i) {
		System.out.println("lives updated");
		lblLives = new JLabel("", images[i], JLabel.CENTER);
		livesPanel.removeAll();
		livesPanel.validate();
        livesPanel.repaint();
		livesPanel.add(lblLives, BorderLayout.CENTER );
		livesPanel.validate();
        livesPanel.repaint(); 
        System.out.println("lives update method:" + i);
	}
	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 570, 695);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(6, 481, 558, 186);
		panel.add(buttonPanel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(38, 195, 247, -67);
		panel.add(panel_1);
		
		livesPanel = new JPanel();
		livesPanel.setBackground(new Color(250, 250, 210));
		livesPanel.setBounds(0, 125, 570, 285);
		panel.add(livesPanel);
		
		lblGuessArray = new JLabel("Hangman 1.0 by Andrew Wells");
		lblGuessArray.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		lblGuessArray.setOpaque(true);
		lblGuessArray.setBackground(Color.WHITE);
		lblGuessArray.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessArray.setBounds(0, 0, 570, 116);
		panel.add(lblGuessArray);
		lblGuessArray.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setBounds(285, 422, 279, 47);
		panel.add(btnPlay);
		
		JFormattedTextField frmtdtxtfldInputWordLength = new JFormattedTextField();
		frmtdtxtfldInputWordLength.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldInputWordLength.setBounds(6, 422, 279, 47);
		panel.add(frmtdtxtfldInputWordLength);
		frmtdtxtfldInputWordLength.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frmtdtxtfldInputWordLength.setText("INPUT WORD LENGTH");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					start = new hangmanGUI(Integer.parseInt(frmtdtxtfldInputWordLength.getText()));
					start.initialise();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		buttonArray = new JButton[26];

		for (int i = 0; i < 26; ++i) {
			char c = (char) ('A' + i);
			String s = c + "";
			buttonArray[i] = new JButton(s);
			buttonPanel.add(buttonArray[i]);
			buttonArray[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					
					lastGuess = event.getActionCommand().toLowerCase();
					start.play();
					((JButton) event.getSource()).setEnabled(false);
				}
			});
		}
	
		
		images = new ImageIcon[10];
		for(int i=1;i<10;i++) {
			images[i] = new ImageIcon("img/stage" + (i) +".png");
		}
		livesUpdate(1);

	}
	
	public void buttonOff() {
		for(JButton b : buttonArray) {
			b.setEnabled(false);
		}
	}
	public void buttonOn() {
		for(JButton b : buttonArray) {
			b.setEnabled(true);
		}
	}
}
