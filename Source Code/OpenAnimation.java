import java.awt.*;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.event.*;

/** The OpenAnimation class shows an animation of the main character and her firend running out of the house 
 * This class is a JPanel and uses the paint method to paint the animation
 * <p>
 * @author H Zhu 
 * @version Final 06.06.17
 * <p>
 * Modifications: created this class (it didn't exsist before)
 * <p>
 * Total hours = 2
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>count </b> This creates an int variable that keeps track of how many times the Timer has looped in order to stop the Timer after a certian number of loops
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
 * <b>frame </b> This is the reference of the JFrame that is used throughout the game.
 */
public class OpenAnimation extends JPanel
{
  private int count;
  private int xPosition;
  private int yPosition;
  private int xPosition2;
  private int yPosition2;
  private ImageIcon hauntedHouse;
  private Timer animationLoop;
  private ImageIcon mainCharacter;
  private ImageIcon friend;
  private JFrame frame;
  
  /** The class constructor initializes the count variable, assigns the value of the Jframe passed the constructor to the instance variable frame, creates an instance of the JPanel,and sets up the layout of the JPanel used
   * as well as the positions of the characters. It also initializes mainCharacter and friend.
   * 
   * @param frame
   * This is the reference of the JFrame that is used throughout the game.
   */
  public OpenAnimation (JFrame frame)
  {
    super();
    this.setLayout (null);    
    count = 0;
    xPosition = 200;
    yPosition = 350;
    xPosition2 = 200;
    yPosition2 = 255;
    this.frame = frame;
    mainCharacter = new ImageIcon ("Girl's Front.png");
    friend = new ImageIcon ("Friend.png");
    hauntedHouse = new ImageIcon("HauntedHouse.png");
    playEnd();
  }
  
  /** The paint method is an override of the paint method already present in the JPanel class
   * This method calls the original repaint method but then adds the animation graphics and the string of the game's name
   * The xPosition and yPosition variables are manipulated by the timer to change the position of the characters
   * 
   * @param g
   * Graphics that are drawn onto the screen
   * 
   */
  @Override
  public void paint (Graphics g)
  {
    super.repaint();
    g.drawImage (hauntedHouse.getImage(), 0, 0, 1024, 576, null);
    g.drawImage (mainCharacter.getImage(), xPosition, yPosition, 100, 200, null);
    g.setFont(new java.awt.Font("Brush Script MT", Font.BOLD, 120));
    g.setColor(Color.white);
    g.drawString("Xtreme Xscape", 160, 150);
    if (yPosition2 >= 400)
    {
      g.drawImage (friend.getImage(), xPosition2, yPosition2, 50, 100, null);
    }
  }
  
  /** The playEnd method is used to call the paint method and adjust the x and y positions of the characters to create the movement in the animation
   * This method uses a timer to run call the paint method a specific number of times. After the animations are done playing this method calls the removePanel method.
   * The xPosition and yPosition variables are manipulated by the timer to change the position of the characters
   * The if statement is used to determine which variable to increment
   * 
   */
  public void playEnd ()
  {
    frame.add(this);
    revalidate();
    repaint ();
    
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
          removePanel();
        }
        revalidate();
        repaint ();
      }
    });
    animationLoop.start();
    
    
  }
  
  /** The removePanel method removes the panel the animation is on from the frame
    */
  public void removePanel ()
  {
    frame.remove (this);
    frame.repaint();
  }
}
