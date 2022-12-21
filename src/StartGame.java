import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class StartGame extends JPanel implements ActionListener, KeyListener{
	
	private boolean newGame = false;
	private boolean instructions = false;
	private boolean lb = false;
	private JButton begin, control, sound, leaderboard, startButton, instructionsButton, quitButton;

	private int soundCount = 1;

    //change this to your own
    static String filename="c:/users/Alice/download.jpg";
    JFrame frame = new JFrame("Test");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new StartGame().createAndShowUI();
                SoundEffect.setFile("Flash/Sounds/bgmusic.wav");
        		SoundEffect.play();
            }
        });
    }

    private void createAndShowUI() {

   
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Shooter Game");

        initComponents(frame);
      
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        
    }

    private void initComponents(JFrame frame) {

    	 frame.setMinimumSize(new Dimension(800, 600));
    	   startButton = new JButton("Start");
           startButton.setBounds(350, 350, 100, 40);
        startButton.addActionListener(this);
           frame.add(startButton);
           sound = new JButton(new ImageIcon(getClass().getResource("images/hearsound.png")));
   		sound.setIcon(new ImageIcon(getClass().getResource("images/hearsound.png")));
   		sound.setBounds(30, 30, 250, 250);
   		sound.addActionListener(this);
           
           frame.add(sound);
           instructionsButton = new JButton("Instructions");
           instructionsButton.setBounds(330, 430, 140, 40);
           frame.add(instructionsButton);
           quitButton = new JButton("Quit");
           quitButton.setBounds(350, 510, 100, 40);
           quitButton.addActionListener(this);
           frame.add(quitButton);
        final BufferedImage img = new ImgUtils().scaleImage(800, 600, filename);
        //create label with image as background
        JLabel label = new JLabel(new ImageIcon((Image) img));
   
        frame.getContentPane().add(label, BorderLayout.CENTER);
     
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
		else if (e.getSource() == startButton) {
			frame.dispose();
            new PlayGame();

		}
		else if (e.getSource() == quitButton) {
			System.exit(1);
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

class ImgUtils {

    public BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
        BufferedImage bi = null;
        try {
            ImageIcon ii = new ImageIcon(filename);//path to image
            bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) bi.createGraphics();
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
            g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bi;
    }
    
	/*
	 * Declaring new game variables
	 */






	
}





