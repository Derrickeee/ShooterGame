
//Header Files
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Main Game Logic File
public class Game extends JPanel implements ActionListener, KeyListener {
	private boolean newGame = false;
	private boolean instructions = false;
	private boolean lb = false;

	/*
	 * Declaring new game variables
	 */


	private JButton start, control, sound, leaderboard;

	private int soundCount = 1;



		Game() {

		// Set layout to absolute for buttons.
		setLayout(null);
		// Generating player Icon at starting point of the game.


		// Create button component, set image, remove borders.
		//start = new JButton(new ImageIcon(getClass().getResource("Flash/newstart.png")));
		//start.setBorder(BorderFactory.createEmptyBorder());
		//control = new JButton(new ImageIcon(getClass().getResource("Flash/howtoplay.png")));
		//control.setBorder(BorderFactory.createEmptyBorder());
		sound = new JButton(new ImageIcon(getClass().getResource("Flash/hearsound.png")));
		sound.setBorder(BorderFactory.createEmptyBorder());
		//leaderboard = new JButton(new ImageIcon(getClass().getResource("Flash/leaderboard.png")));
		//leaderboard.setBorder(BorderFactory.createEmptyBorder());


		// Trigger at the start of the game when there isnt any sound

		sound.setIcon(new ImageIcon(getClass().getResource("Flash/hearsound.png")));

		//Listener for button clicking
		//start.addActionListener(this);
		//control.addActionListener(this);
		sound.addActionListener(this);
		//leaderboard.addActionListener(this);

		//Append the buttons onto the frame

		//add(start);
		//add(control);
		add(sound);
		//add(leaderboard);

		// Display start and control button

		//start.setBounds(445, 350, 300, 100);
		//control.setBounds(475, 500, 240, 50);
		sound.setBounds(100, 100, 40, 40);
		//sound.setFocusPainted(false);
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
				sound.setIcon(new ImageIcon(getClass().getResource("Flash/mutesound.png")));
				SoundEffect.stop();
				//check if sound is off.
			} else if (soundCount == 0) {
				soundCount = 1;
				sound.setIcon(new ImageIcon(getClass().getResource("Flash/hearsound.png")));
				SoundEffect.setFile("Flash/Sounds/bgmusic.wav");
				SoundEffect.play();
				SoundEffect.loop();
			}
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
}

