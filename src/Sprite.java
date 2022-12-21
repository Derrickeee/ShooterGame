
import javax.swing.*;
import java.awt.*;

//Class to make rectangles for collision method.
//Class to set sprite image.
//Class for graphics.

/*
 * Class that creates a sprite with an image, location,
 * directional movement and a collision method.
 */
class Sprite {

	// Sprite location.
	private double xlocation, ylocation;

	// Sprite direction.
	private double xdirection, ydirection;

	// Holds the image of the sprite.
	private ImageIcon image;

	// Draw sprite image or not.
	private boolean show = true;

	// Holds the image filename.
	public String filename = "";

	/**
	 * The default constructor.
	 */
	Sprite() {
		image = null;
		xlocation = 0;
		ylocation = 0;
		xdirection = 0;
		ydirection = 0;
	}

	/**
	 * Constructor that sets the sprite image and location.
	 */
	public Sprite(String filename, int xloc, int yloc) {
		setImage(filename);
		this.xlocation = xloc;
		this.ylocation = yloc;
	}

	/**
	 * Constructor that takes the location as the argument.
	 */
	public Sprite(int xloc, int yloc) {
		this.xlocation = xloc;
		this.ylocation = yloc;
	}

	/**
	 * Constructor that takes an image filename as the argument.
	 */
	public Sprite(String filename) {
		setImage(filename);
	}

	/*
	 * Method to set the image variable.
	 */
	public void setImage(String filename) {
		this.filename = filename;

		try {
			this.image = new ImageIcon(getClass().getResource(filename));
		} catch (Exception e) {
			image = null;
			System.out.println("Sprite Image not Found");
		}
	}

	/*
	 * Getters.
	 */
	// Get xloc.
	public int getXLoc() {
		return (int) xlocation;
	}

	/*
	 * Setters
	 */
	// Sets xloc.
	public void setXLoc(int xloc) {
		this.xlocation = xloc;
	}

	// Get yloc.
	public int getYLoc() {
		return (int) ylocation;
	}

	// Sets yloc.
	public void setYLoc(int yloc) {
		this.ylocation = yloc;
	}

	// Get xdir.
	public double getXDir() {
		return xdirection;
	}

	// Sets xdir.
	void setXDir(double xdir) {
		this.xdirection = xdir;
	}

	// Get ydir.
	public double getYDir() {
		return ydirection;
	}

	// Sets ydir.
	public void setYDir(double ydir) {
		this.ydirection = ydir;
	}

	// Get image filename.
	public String getFileName() {
		return filename;
	}

	/*
	 * Moves character by adding the direction to the location.
	 */
	public void move() {
		xlocation += xdirection;
		ylocation += ydirection;
	}

	// Return the width of the sprite
	// or 20 if the image is null.
	public int getWidth() {
		if (image == null)
			return 20;
		else
			return image.getIconWidth();
	}

	// Return the height of the sprite
	// or 20 if the image in null.
	public int getHeight() {
		if (image == null)
			return 20;
		else
			return image.getIconHeight();
	}

	/*
	 * Method to draw sprite onto JPanel.
	 */
	public void paint(Graphics g, JPanel panel) {
		if (show) {
			if (image == null)
				g.drawRect((int) xlocation, (int) ylocation, 50, 50);
			else
				image.paintIcon(panel, g, (int) xlocation, (int) ylocation);
		}
	}
	/**
	 * Checks for sprite collisions.
	 */
	public boolean collision(Sprite two) {
		// Creates rectangles around sprites and checks for interesection.
		Rectangle first = new Rectangle(getXLoc(), getYLoc(), getWidth(), getHeight());
		Rectangle second = new Rectangle(two.getXLoc(), two.getYLoc(), two.getWidth(), two.getHeight());

		return first.intersects(second);
	}

}
