import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField textGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess(){
		String guessText = textGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber)
				message = guess + " is too low. Try again.";
			else if (guess > theNumber)
				message = guess + " is too high. Try again.";
			else {
				message = guess + " is correct. You win.";
				newGame();
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			textGuess.requestFocus();
			textGuess.selectAll();
		}
	}
	public void newGame(){
		theNumber = (int)(Math.random() * 100 + 1);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HiLo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("HiLo GAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 30, 130, 22);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(55, 94, 224, 38);
		getContentPane().add(lblNewLabel_1);

		textGuess = new JTextField();
		textGuess.setBounds(289, 104, 96, 19);
		getContentPane().add(textGuess);
		textGuess.setColumns(10);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOutput.setBounds(121, 191, 264, 22);
		getContentPane().add(lblOutput);

		JButton btnNewButton = new JButton("Guess");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(171, 142, 116, 29);
		getContentPane().add(btnNewButton);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}
