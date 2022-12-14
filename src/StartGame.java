import javax.swing.JFrame;
import java.awt.*;

public class StartGame extends JFrame{
	public StartGame() {
	}

    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Shot Me Down");

        Board game = new Board();
        frame.getContentPane().add(game);
        frame.setMinimumSize(new Dimension(680, 370));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    	SoundEffect.setFile("Flash/Sounds/bgmusic.wav");
		SoundEffect.play();
    }

}
