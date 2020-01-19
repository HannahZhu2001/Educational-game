import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**The Level2 class outputs level 2 in this program. It makes the instructions, 
  * and background. It allows the user to click around the bedroom to look
  * for the key, and then, it ouputs the level 2 game that is created in the 
  * Level2Game class. This class was edited and revised by Hannah Zhu.
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>frame </b> This is the reference of the JFrame that is used throughout the game.
  * <p>
  * <b>instructionsPane </b> This is the reference of the JPanel for the instructions page.
  * <p>
  * <b>pane </b> This is the reference of the JPanel class.
  * <p>
  * <b>bLabel </b> This is the reference of the JLabel class that is used for the bedroom ImageIcon.
  * <p>
  * <b>bedroomImage </b> This is the reference of the ImageIcon that is used for the bedroom.
  * <p>
  * <b>pane </b> This is the reference of the JPanel class.
  * <p>
  * <b>bLabel </b> This is the reference of the JLabel class that is used for the bedroom ImageIcon.
  * <p>
  * <b>bedroomImage </b> This is the reference of the ImageIcon that is used for the bedroom.
  * <p>
  * <b>instructionsLabel </b> This is the reference of the JLabel class that is used for the instructions.
  * <p>
  * <b>zoomedLabel </b> This is the reference of the JLabel class that is used for the zoomed in bedroom.
  * <p>
  * <b>zoomTimer </b> This is the reference of the Timer class that is used for the zoomed in bedroom.
  * <p>
  * <b>game </b> This is the reference of the Level2Game class.
  * <p>
  * <b>mouseFirst </b> This stores whether this is the first time the mouse was clicked.
  * <p>
  * <b>xxClass </b> This is the reference of the XtremeXscape class.
  * <p>
  * <b>x </b> This is the int variable that stores the x coordinate of the top left corner of the bedroom when it is being zoomed in.
  * <p>
  * <b>y </b> This is the int variable that stores the y coordinate of the top left corner of the bedroom when it is being zoomed in.
  * <p>
  * <b>xLen </b> This is the int variable that stores the x length of the bedroom when it is being zoomed in.
  * <p>
  * <b>yLen </b> This is the int variable that stores the y length of the bedroom when it is being zoomed in.
  * <p>
  * @author Jessica Peter
  * @version Final 06.06.17
  * 
  * Total hours: 10 hours
  */
public class Level2
{
  private JFrame frame;
  private JPanel instructionsPane;
  private JPanel pane;
  private JLabel bLabel;
  private ImageIcon bedroomImage;
  private JLabel instructionsLabel;
  private JLabel zoomedLabel;
  private Timer zoomTimer;
  private Level2Game game;
  private boolean mouseFirst;
  private XtremeXscape xxClass;
  private int x = 0;
  private int y = 0;
  private int xLen = 1024;
  private int yLen = 576;
  
  /** The constructor of the Level2 class passes the frame to the JFrame in this class, as 
    * well as the XtremeXscape instance variable. It also creates a new JPanel with a 
    * BorderLayout, and a new Level2Game.
    * @param frame This is the reference of the JFrame class.
    * @param xxClass This is the reference of the XtremeXscape class.
    */
  public Level2 (JFrame frame, XtremeXscape xxClass)
  {
    this.frame = frame;
    this.xxClass = xxClass;
    pane = new JPanel (new BorderLayout ());
    game = new Level2Game(frame, xxClass);
    
  }
  
  /** The firstInstructionsPage2() method creates the first set of 
    * instructions that the user gets for the second level. The 
    * instructions are displayed on a frame with a light purple
    * background. The instructions are made on a JLabel, and added
    * to a panel that has a BorderLayout. The panel is then added
    * to the frame.
    */
  public void firstInstructionsPage2()
  {
    instructionsPane = new JPanel ();
    pane = new JPanel (new BorderLayout ());
    x = 0;
    y = 0;
    xLen = 1024;
    yLen = 576;
    instructionsPane.setLayout (null);
    instructionsPane.setBackground(new Color (189, 200, 250));
    instructionsLabel = new JLabel ("<html>You have now entered the bedroom, but the evil scientist locked you in again! You must find the key hidden behind an object in this room to escape. Simply DOUBLE tap the objects in the room to see if you can find the key. Once you have found the key, you will be led to the game.</html>");
    instructionsLabel.setFont (new Font("Serif", Font.BOLD, 30));
    instructionsPane.add (instructionsLabel);
    instructionsLabel.setBounds (0, 0, 1024, 390);
    frame.add(instructionsPane);
    frame.revalidate();
    frame.repaint();
  }
  
  /** The bedroom() method creates the bedroom ImageIcon and JLabel. It adds the JLabel
    * for the bedroom on a panel, and adds the panel on the frame. It repaints the panel,
    * as well as revalidates and repaints the frame.
    */
  public void bedroom()
  {
    frame.add(pane);
    bedroomImage = new ImageIcon ("Bedroom.png");
    bLabel = new JLabel(bedroomImage);
    pane.add(bLabel);
    pane.repaint();
    frame.revalidate();
    frame.repaint();
  }
  
  /** The clicking() method adds an ActionListener to the panel, and removes the label and calls
    * the zooming() method when the user has found the correct location of the key, which is in
    * the safe under the desk.
    */
  public void clicking()
  {
    mouseFirst = true;
    pane.addMouseListener(new MouseAdapter() 
                            {
      public void mouseClicked(MouseEvent e) 
      {
        if (e.getX()>=737 && e.getX()<=817 && e.getY()>=372 && e.getY()<=780 && mouseFirst == true)
        {
          mouseFirst = false;
          pane.remove(bLabel);
          zooming(); 
        }
      }
    });
  }
  /** The safeZoom() method zooms in on the safe under the desk. It changes the x, y, xLen, and
    * yLen values, so that the picture is getting bigger. The bedroom JLabel is added to the panel,
    * and the panel is repainted. The frame is then revalidated and repainted.
    */
  private void safeZoom()
  {
    x-=43;
    y -= 20;
    xLen+=45;
    yLen+=23;
    zoomedLabel = new JLabel(bedroomImage)
    {
      public void paintComponent (Graphics g) 
      {
        if (zoomedLabel != null) 
        {
          try
          {
            g.drawImage (bedroomImage.getImage(), x, y, xLen, yLen, null);
            repaint ();
          }
          catch(Exception e)
          {
          }
        }
      }
    };
    pane.add(zoomedLabel);
    pane.repaint();
    frame.revalidate();
    frame.repaint();
  }
  /** The zooming() method initializes the Timer, and after starting it, makes it run every 15
    * milliseconds. It calls the safeZoom() method, and since the x value is constantly changing
    * in the safeZoom() method, it stops when x is smaller than -1000. The panel is then removed
    * from the frame, and the frame is revalidated. An instance of the Level2Game class is also
    * created, and the executeGame() method is called.
    */
  public void zooming()
  {
    zoomTimer = new Timer (15, new ActionListener()
                             {
      public void actionPerformed (ActionEvent ae)
      {
        safeZoom();
        if (x < -1000)
        {
          zoomTimer.stop();
          frame.remove(pane);
          frame.revalidate();
          game = new Level2Game(frame, xxClass);
          game.executeGame();
        }
      }
    });
    zoomTimer.start();
    
  }
  
  /** This is the execution() method, which creates the close button, and calls every method in 
    * this class. Using an ActionListener, it makes sure that the user can exit from the instructions
    * page.
    * <b>Local variables: </b>
    * <p>
    * <b>close </b> This is the reference of the JButton class that is used to close the instructions JPanel.
    */
  public void execution()
  {
    JButton close = new JButton ("Close");
    firstInstructionsPage2();
    instructionsPane.add(close);
    close.setBounds (380, 400, 154, 50);
    close.addActionListener (new ActionListener ()
                               {
      public void actionPerformed (ActionEvent ae)
      {
        frame.remove(instructionsPane);
        frame.revalidate();
        frame.repaint();
        bedroom();
        clicking();
      }
    });
  }
  
  
  /** The getScore() method returns the level 2 score.
    * 
    * @return game.getScore() This returns the score that is determined in the Level2Game class.
    */
  public int getScore()
  {
    return game.getScore();
  }
}
