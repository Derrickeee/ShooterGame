
//Header Files
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Main Game Logic File
public class Game extends JPanel {
	/*private boolean newGame = false;
	private boolean instructions = false;
	private boolean lb = false;

	/*
	 * Declaring new game variables
	 */


	/*private JButton begin, control, sound, leaderboard;

	private int soundCount = 1;



		Game() {

		// Set layout to absolute for buttons.
		setLayout(null);
		// Generating player Icon at starting point of the game.


		// Create button component, set image, remove borders.
		begin = new JButton(new ImageIcon(getClass().getResource("images/newstart.png")));
		//start.setBorder(BorderFactory.createEmptyBorder());
		//control = new JButton(new ImageIcon(getClass().getResource("Flash/howtoplay.png")));
		//control.setBorder(BorderFactory.createEmptyBorder());
		sound = new JButton(new ImageIcon(getClass().getResource("images/hearsound.png")));
		//sound.setBorder(BorderFactory.createEmptyBorder());
		//leaderboard = new JButton(new ImageIcon(getClass().getResource("Flash/leaderboard.png")));
		//leaderboard.setBorder(BorderFactory.createEmptyBorder());


		// Trigger at the start of the game when there isn't any sound

		sound.setIcon(new ImageIcon(getClass().getResource("images/hearsound.png")));

		//Listener for button clicking
	begin.addActionListener(this);
		//control.addActionListener(this);
		sound.addActionListener(this);
		//leaderboard.addActionListener(this);

		//Append the buttons onto the frame

		add(begin);
		//add(control);
		add(sound);
		//add(leaderboard);

		// Display start and control button

		begin.setBounds(445, 50, 300, 100);
		//control.setBounds(475, 500, 240, 50);
		sound.setBounds(100, 100, 200, 200);
		sound.setFocusPainted(false);
		//leaderboard.setBounds(475, 600, 240, 50);

		// Create key listeners for each player
		addKeyListener(this);
		// Center the JPanel
		setFocusable(true);
		// Make the movement smooth.
		setDoubleBuffered(true);
		// Create the game timer and start it.




	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sound) {
			//check if sound is on.
			if (soundCount == 1) {
				soundCount = 0;
				sound.setIcon(new ImageIcon(getClass().getResource("images/mutesound.png")));
				SoundEffect.stop();
				//check if sound is off.
			} else if (soundCount == 0) {
				soundCount = 1;
				sound.setIcon(new ImageIcon(getClass().getResource("images/hearsound.png")));
				SoundEffect.setFile("Flash/Sounds/bgmusic.wav");
				SoundEffect.play();
				SoundEffect.loop();
			}
		}
		else if (e.getSource() == begin) {
			newGame();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
	
	/**
	 * Method that starts a new game.
	 */
	private void newGame() {
		/*if (newGame) {
			// Get this JFrame and destroy it.
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
			frame.dispose();*/

			// Create new main menu JFrame.


	//new StartGame(false, soundCount);

		}
	}



