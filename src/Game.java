
//Header Files
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

//Main Game Logic File
public abstract class Game extends JPanel implements ActionListener, KeyListener {
	private boolean newGame = false;
	private boolean instructions = false;
	private boolean lb = false;

	/*
	 * Declaring new game variables
	 */


	private JButton start, control, sound, leaderboard;

	private int soundCount = 1;



}

