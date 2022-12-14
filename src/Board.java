

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;

public class Board extends JPanel {
    private final int OFFSET = 30;
    private final int SPACE = 20;
    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;
    private int pinkMove;
    private int blueMove;
    private int life = 3;



    public static enum STATE{
        MENU,
        GAME,
        HELP,
        LEADERBOARD,
        CHATBOT
    };

    public static Menu menu;
    public static STATE State = STATE.MENU;
    public Rectangle returnButton = new Rectangle(230, 255, 200, 25);

    Timer timer;
    double msecond = 0;
    double second = 0;
    double minute = 0;

    static double score;

    private int w = 0;
    private int h = 0;

    private boolean isCompleted = false;
    // Draw map here
    private String level
            = "##############################\n"
            + "#########   ##################\n"
            + "######### $ ##################\n"
            + "#########   ##################\n"
            + "#######   ~  #################\n"
            + "######   ~   #################\n"
            + "#####  # ##      .. ##########\n"
            + "#####   ~   $     ,,##########\n"
            + "######### ###$ ###@& .,#######\n"
            + "#########      ###############\n"
            + "##############################\n";

    // @ symbol used for Player 1
    // & symbol used for Player 2
    // ~ symbol used for Pink Baggage
    // $ symbol used for Blue Baggage
    // . symbol used for Pink Area
    // , symbol used for Blue Area

    public Board() {
    	setBackground(Color.ORANGE);
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        menu = new Menu();

    }

    public void simpleTimer() {
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isCompleted == false) {
                    msecond += 1;
                    if(msecond == 200) {
                        msecond = 0;
                        second ++;
                        System.out.println("Seconds: " + second);
                    }
                    else if(second == 60) {
                        second = 0;
                        minute ++;
                        System.out.println("Minutes: " + minute);
                    }
                }
                if(isCompleted == true) {
                    timer.stop();
                }
            }
        });
    }

   
    private void buildWorld(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if (State == STATE.GAME) {
            repaint();
            //g.setColor(new Color(250, 240, 170));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
          

            g.setColor(new Color(0, 0, 0));
            g.drawString("Press H for Help", 30, 270);
            g.drawString("Total Moves: ", 30, 20);
            g.drawString(String.valueOf(pinkMove + blueMove), 100, 20);
            g.drawString("Life: ", 140, 20);
            g.drawString(String.valueOf(life), 170, 20);



            if (life == 0) {
                g.drawString("Game is Over", 538, 20);
                g.drawString("Press R to return to Menu", 250, 270);
            }
            else {
                if (isCompleted) {
                    g.setColor(new Color(0, 0, 0));
                    g.drawString("Level Completed", 538, 20);
                    g.drawString("Time Taken: " + (int) minute + " minutes " + (int) second + " seconds", 250, 20);
                    g.drawString("Press R to return to Menu", 250, 270);
                }
            }
        }
        if (State == STATE.MENU) {
            repaint();
            //g.setColor(new Color(250, 240, 170));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            menu.render(g);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        if (State == STATE.GAME) {
            super.paintComponent(g);
            buildWorld(g);
        }
        else if (State == STATE.MENU) {
            repaint();
            JLabel label = new JLabel(); //JLabel Creation
            label.setIcon(new ImageIcon("mqdefault_6s.png"));
            //Container c = frame.getContentPane();
            //c.add(label);
            //g.setColor(new Color(250, 240, 170));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            menu.render(g);
        }


    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (isCompleted) {
                int key = e.getKeyCode();
                if (State == STATE.GAME || State == STATE.HELP ) {
                    switch (key) {
                        case KeyEvent.VK_R:
                            if (State == STATE.GAME) {
                                JFrame frame = new JFrame();
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setResizable(false);
                                frame.setTitle("Puzzle Time");

                                Board game = new Board();
                                frame.getContentPane().add(game);
                                frame.setMinimumSize(new Dimension(680, 370));
                                frame.pack();
                                frame.setLocationRelativeTo(null);
                                State = STATE.MENU;
                                frame.setVisible(true);
                                break;
                            }
                    }
                }
            }

            int key = e.getKeyCode();
            if (State == STATE.GAME || State == STATE.HELP ) {

                switch (key) {

            }
        }
    }



    private boolean checkPinkBagCollision(int type) {

      

          

        return false;
    }

  
   

    }
}