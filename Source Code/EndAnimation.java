import java.awt.*;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.event.*;

/** The EndAnimation class shows either a animation of the main character and her firend running out of the house or the robot getting 
  * caught by the lazers depending on if they had the right code or not.
  * This class is a JPanel and uses the paint method to paint the animation
  * <p>
  * @author H Zhu 
  * @version Final 06.06.17
  * <p>
  * Modifications: took out the static main because it is now called in the Level3 class
  * <p>
  * Total hours = 4
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>count </b> This creates an int variable that keeps track of how many times the Timer has looped in order to stop the Timer after a certian number of loops
  * <p>
  * <b>score </b> This int's value is recieved through the constructor's parameters and displayed to the user during the animation
  * <p>
  * <b>xPosition </b> This is an int that keeps track of the x coordinate of the main character so it can be drawn at the correct position
  * <p>
  * <b>yPosition </b> This is an int that keeps track of the y coordinate of the main character so it can be drawn at the correct position
  * <p>
  * <b>xPosition2 </b> This is an int that keeps track of the x coordinate of the friend so it can be drawn at the correct position
  * <p>
  * <b>yPosition2 </b> This is an int that keeps track of the y coordinate of the friend so it can be drawn at the correct position
  * <p>
  * <b>hauntedHouse </b> This creates an ImageIcon of the haunted house used in the background of the animation
  * <p>
  * <b>animationLoop </b> This creates an instance of the Timer class used to continously call the panel's repaint method inturn running the animation
  * <p>
  * <b>mainCharacter </b> This creates an imageIcon of the main character drawn in the animations
  * <p>
  * <b>badEnding </b> This creates an imageIcon of bad ending displayed to the user if they don't have the correct code
  * <p>
  * <b>friend </b> This creates an imageIcon of the friend drawn in the animations
  * <p>
  * <b>win </b> This is a boolean that's value is determined by the parameter passed to it through  the constructor and is used to determine which ending to show the user
  * <p>
  * <b>frame </b> This is the reference of the JFrame that is used throughout the game.
  * <p>
  * <b>xxClass </b> This is the reference variable of the XtremeXscape class that is used to return to the instructions page once the animation is finished
  */
public class EndAnimation extends JPanel
{
  
  private int count;
  private int score;
  private int xPosition;
  private int yPosition;
  private int xPosition2;
  private int yPosition2;
  private ImageIcon hauntedHouse;
  private Timer animationLoop;
  private ImageIcon mainCharacter;
  private ImageIcon badEnding;
  private ImageIcon friend;
  private boolean win;
  private JFrame frame;
  private XtremeXscape xxClass;
  
  /** The class constructor initializes the count variable, assigns the value of the Jframe passed the constructor to the instance variable frame, creates an instance of the JPanel,and sets up the layout of the JPanel used
    * as well as the positions of the characters. It also assigns the values of win, score, xxClass, and initializes mainCharacter and friend.
    * 
    * @param frame
    * This is the reference of the JFrame that is used throughout the game.
    * 
    * @param win
    * Used to determine which ending to show the user
    * 
    * @param score
    * Used to display the score 
    * 
    * @param xxClass
    * Used to call a method in the XtremeXscape class
    */
  public EndAnimation (JFrame frame, boolean win, int score, XtremeXscape xxClass)
  {
    super();
    this.setLayout (null);    
    count = 0;
    xPosition = 200;
    yPosition = 350;
    xPosition2 = 200;
    yPosition2 = 250;
    this.win = win;
    this.score = score;
    this.frame = frame;
    mainCharacter = new ImageIcon ("Girl's Front.png");
    friend = new ImageIcon ("Friend.png");
    this.xxClass = xxClass;
    playEnd();
  }
  
  /** The paint method is an override of the paint method already present in the JPanel class
    * This method calls the original repaint method but then adds the animation graphics, the string telling the user whether or not they passed, and the user's score
    * The xPosition and yPosition variables are manipulated by the timer to change the position of the characters
    * The if statement is used to determine which ending to show the user
    * 
    * 
    * @param g 
    * Graphics that are drawn onto the screen 
    * 
    */
  @Override
  public void paint (Graphics g)
  {
    super.repaint();
    
    if (win)
    {
      g.setColor(Color.white);
      g.drawImage (hauntedHouse.getImage(), 0, 0, 1024, 570, null);
      g.drawImage (mainCharacter.getImage(), xPosition, yPosition, 100, 200, null);
      if (yPosition2 >= 400)
      {
        g.drawImage (friend.getImage(), xPosition2, yPosition2, 50, 100, null);
      }
      if (xPosition >=500)
      {
        g.setFont(new java.awt.Font("Brush Script MT", Font.BOLD, 80));
        g.setColor(Color.white);
        g.drawString("Congratulations you have", 110, 200);
        g.drawString("escaped Dr EveVil's house!", 80, 300);
      }
    }
    else
    {
      g.setFont(new java.awt.Font("Brush Script MT", Font.BOLD, 80));
      g.drawImage (badEnding.getImage(), 0, -10, 1024, 590, null);
      g.drawString("Oh no! That wasn't ", 230, 200);
      g.drawString("the right code...", 260, 300);
    }
    
    g.setFont(new java.awt.Font("Brush Script MT", Font.BOLD, 30));
    g.drawString("Score: " + score, 880, 30);
  }
  
  
  /** The playEnd method is used to call the paint method and adjust the x and y positions of the characters to create the movement in the animation
    * This method uses a timer to run call the paint method a specific number of times. After the animations are done playing this method calls the removePanel method.
    * The xPosition and yPosition variables are manipulated by the timer to change the position of the characters
    * The if statement is used to determine which ending the user is being shown and how many times to run the timer
    * 
    */
  public void playEnd ()
  {
    badEnding = new ImageIcon ("Level3BadEnding.png");
    frame.add(this);
    revalidate();
    repaint ();
    if (win)
    {
      hauntedHouse = new ImageIcon("HauntedHouse.png");
      animationLoop = new Timer (1, new ActionListener ()
                                   {
        public void actionPerformed (ActionEvent ae)
        {
          count++; 
          if (count < 25)
          {
            yPosition++;
            yPosition2++;
          }
          else if (count < 170)
          {
            yPosition2++;
            xPosition++;
          }
          else if (count < 1020)
          {
            xPosition2++;
            xPosition++;
          }
          else
          {
            animationLoop.stop();
            try 
            {
              Thread.sleep(300);
            }
            catch (InterruptedException e)
            {
            }
            removePanel();
          }
          revalidate();
          repaint ();
        }
      });
      animationLoop.start();
    }
    else
    {
      animationLoop = new Timer (1, new ActionListener ()
                                   {
        public void actionPerformed (ActionEvent ae)
        {
          count++; 
          if (count > 1)
          {
            animationLoop.stop();
            try 
            {
              Thread.sleep(2700);
            }
            catch (InterruptedException e)
            {
            }
            removePanel();
          }
          revalidate();
          repaint ();
        }
      });
      animationLoop.start();
    }
  }
  
  /** The removePanel method removes the panel the animation is on from the frame and then calls a method from the driver class to return to the levels page
    */
  public void removePanel ()
  {
    frame.remove (this);
    frame.repaint();
    xxClass.afterLevel();
  }
}
