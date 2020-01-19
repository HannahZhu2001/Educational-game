import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**The Level1 class outputs level 1 in this program. It makes the instructions, 
  * and background. It allows the user to click around the living room to look
  * for the key, and then, it ouputs the level 1 game that is created in the 
  * Level1Game class. This class was edited and revised by Hannah Zhu.
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>frame </b> This is the reference of the JFrame that is used throughout the game.
  * <p>
  * <b>livingRoom </b> This creates an instance of the ImageIcon class for the living room.
  * <p>
  * <b>lrLabel </b> This creates an instance of the JLabel class for the living room ImageIcon.
  * <p>
  * <b>displayLabel </b> This creates an instance of the JLabel class for the displaying of the living room ImageIcon.
  * <p>
  * <b>instructionsLabel </b> This creates an instance of the JLabel class for the instructions.
  * <p>
  * <b>x </b> This stores the x position for the living room when it is being zoomed in.
  * <p>
  * <b>xLen </b> This stores the x length for the living room when it is being zoomed in.
  * <p>
  * <b>yLen </b> This stores the y length for the living room when it is being zoomed in.
  * <p>
  * <b>image1 </b> This creates an instance of the ImageIcon class for the first scene.
  * <p>
  * <b>image2 </b> This creates an instance of the ImageIcon class for the second scene.
  * <p>
  * <b>image3 </b> This creates an instance of the ImageIcon class for the third scene.
  * <p>
  * <b>image4 </b> This creates an instance of the ImageIcon class for the fourth scene.
  * <p>
  * <b>image5 </b> This creates an instance of the ImageIcon class for the fifth scene.
  * <p>
  * <b>evilScientist </b> This creates an instance of the ImageIcon class for the evil scientist.
  * <p>
  * <b>mainCharacter </b> This creates an instance of the ImageIcon class for the main character.
  * <p>
  * <b>mainCharacterBack </b> This creates an instance of the ImageIcon class for the back of the main character.
  * <p>
  * <b>mainCharacterSad </b> This creates an instance of the ImageIcon class for the sad main character.
  * <p>
  * <b>friendSad </b> This creates an instance of the ImageIcon class for the sad friend.
  * <p>
  * <b>blackLine </b> This creates an instance of the ImageIcon class for the lines used in the cells.
  * <p>
  * <b>text </b> This creates an instance of the ImageIcon class for the ending text bubble.
  * <p>
  * <b>xPos </b> This stores the x position of the characters at certain times.
  * <p>
  * <b>yPos </b> This stores the y position of the characters at certain times.
  * <p>
  * <b>count </b> This stores the number of times the program runs through the timer action listener after the timer has started.
  * <p>
  * <b>animation </b> This creates an instance of the Timer class.
  * <p>
  * <b>xxClass </b> This creates an instance of the XtremeXscape class.
  * <p>
  * <b>mouseFirst </b> This stores whether this is the first time the mouse was clicked.
  * <p>
  * <b>g1 </b> This creates an instance of the Level1Game class.
  * <p>
  * <b>instructionsPane </b> This creates an instance of the JPanel class for the instructions.
  * 
  * @author Jessica Peter
  * @version Final 06.06.17
  * Time Spent: 20 hours
  */
public class Level1
{
  private JFrame frame;
  private JPanel livingRoomPanel;
  private JPanel introPane;
  private JPanel mainPane;
  private ImageIcon livingRoom;
  private JLabel lrLabel;
  private JLabel displayLabel;
  private JLabel instructionsLabel;
  private Timer t;
  private int x = 0;
  private int xLen = 1024;
  private int yLen = 576;
  private ImageIcon image1, image2, image3, image4, image5;
  private ImageIcon evilScientist;
  private ImageIcon mainCharacter, mainCharacterBack, mainCharacterSad;
  private ImageIcon friendSad;
  private ImageIcon blackLine;
  private ImageIcon text;
  private int xPos, yPos;
  private int count;
  private Timer animation;
  private XtremeXscape xxClass;
  private boolean mouseFirst;
  private Level1Game g1;
  private JPanel instructionsPane;
  
  /** The constructor for the Level1 class sets the class JFrame to
    * the JFrame that was passed as a parameter. It also sets the 
    * XtremeXscape class to the xxClass class variable. It then makes 
    * a new JPanel for the living room, and creates an instance of the
    * Level1Game game class with the parameters frame and xxClass. The 
    * panel used for the introduction is also created and the paint method
    * is overriden to draw the introduction scenes.
    * @param frame This makes an instance of the JFrame class.
    * @param xxClass This makes an instance of the XtremeXscape class.
    */
  public Level1 (JFrame frame, XtremeXscape xxClass)
  {
    this.frame = frame;
    this.xxClass = xxClass;
    livingRoomPanel = new JPanel();
    g1 = new Level1Game(frame, xxClass);
    introPane = new JPanel()
    {
      /** The paint method draws all of the different scenes on to the
        * frame depending on what the value of count is. Every time the 
        * timer increases by 1, this method is called, and using an if
        * statement, the correct scene is called. This is also how the
        * animations are added.
        * @param g This makes an instance of the Graphics class.
        */
      @Override
      public void paint (Graphics g)
      {
        if (count < 1174)
        {
          xPos++;
          g.drawImage (image1.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (mainCharacter.getImage(), xPos, 300, 150, 300, null);
        }
        else if (count >= 1174 && count < 1800)
        {
          xPos++;
          g.drawImage (image2.getImage(),0,0,1024,576,null);
          frame.setVisible(true);
        }
        else if (count == 1800)
        {
          xPos = -150;
          g.drawImage (image3.getImage(),0,0,1024,576,null);
          frame.setVisible(true);
        }
        else if (count > 1800 && count <2000)
        {
          xPos++;
          g.drawImage (image3.getImage(),0,0,1024,576,null);
          g.drawImage (mainCharacterSad.getImage(), xPos, 300, 400, 300, null);
          frame.setVisible(true);
        }
        else if (count >= 2000 && count <2700)
        {
          g.drawImage (image3.getImage(),0,0,1024,576,null);
          g.drawImage (mainCharacterBack.getImage(), 200, 350, 100, 200, null);
          frame.setVisible(true);
        }
        else if (count == 2700)
        {
          xPos = -150;
          g.drawImage (image4.getImage(),0,0,1024,576,null);
          frame.setVisible(true);
        }
        else if (count >2700 && count <= 2900)
        {
          xPos++;
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), xPos, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, 300, 200, 200, null);
        }
        else if (count > 2900 && count <= 2950)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, 300, 200, 200, null);
        }
        else if (count > 2950 && count <= 3000)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, 300, 200, 200, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
        }
        else if (count > 3000 && count <= 3050)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, 300, 200, 200, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
        }
        else if (count > 3050 && count <= 3100)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, 300, 200, 200, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
        }
        else if (count > 3100 && count <= 3150)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, 300, 200, 200, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 260, 0, 7, 570, null); 
        }
        else if (count > 3150 && count <= 3200)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, 300, 200, 200, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 260, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 280, 0, 7, 570, null); 
        }
        else if (count > 3200 && count <= 3250)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, 300, 200, 200, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 260, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 280, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 300, 0, 7, 570, null); 
        }
        else if (count > 3250 && count <= 3300)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, 300, 200, 200, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 260, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 280, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 300, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 320, 0, 7, 570, null); 
        }
        else if (count > 3300 && count < 3350)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, 300, 200, 200, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 260, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 280, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 300, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 320, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 340, 0, 7, 570, null); 
        }
        else if (count == 3350)
        {
          yPos = 300;
        }
        else if (count > 3350 && count <= 3600)
        {
          yPos++;
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, yPos, 200, 200, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 260, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 280, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 300, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 320, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 340, 0, 7, 570, null); 
        }
        else if (count > 3350 && count <= 4000)
        {
          yPos++;
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (evilScientist.getImage(), 500, yPos, 200, 200, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 260, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 280, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 300, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 320, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 340, 0, 7, 570, null); 
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4000 && count <= 4050)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 260, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 280, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 300, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 320, 0, 7, 570, null); 
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4050 && count <= 4100)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 260, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 280, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 300, 0, 7, 570, null); 
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4100 && count <= 4150)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 260, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 280, 0, 7, 570, null); 
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4100 && count <= 4150)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 260, 0, 7, 570, null); 
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4150 && count <= 4200)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 240, 0, 7, 570, null); 
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4200 && count <= 4250)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 220, 0, 7, 570, null); 
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4250 && count <= 4300)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (blackLine.getImage(), 200, 0, 7, 570, null);
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4300 && count < 4400)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), 50, 270, 470, 353, null);
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count == 4400)
        {
          xPos = 50;
        }
        else if (count > 4400 && count <= 4800)
        {
          xPos++;
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 1010, 0, 7, 570, null);
          g.drawImage (mainCharacterSad.getImage(), xPos, 270, 470, 353, null);
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4800 && count <= 4850)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 990, 0, 7, 570, null); 
          g.drawImage (mainCharacterSad.getImage(), 450,270, 470, 353, null);
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4850 && count <= 4900)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 970, 0, 7, 570, null); 
          g.drawImage (mainCharacterSad.getImage(), 450, 270, 470, 353, null);
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4900 && count <= 4950)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 950, 0, 7, 570, null); 
          g.drawImage (mainCharacterSad.getImage(), 450, 270, 470, 353, null);
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 4950 && count <= 5000)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 930, 0, 7, 570, null); 
          g.drawImage (mainCharacterSad.getImage(), 450, 270, 470, 353, null);
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 5000 && count <= 5050)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (blackLine.getImage(), 910, 0, 7, 570, null); 
          g.drawImage (mainCharacterSad.getImage(), 450, 270, 470, 353, null);
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 5050 && count <= 5100)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (blackLine.getImage(), 890, 0, 7, 570, null); 
          g.drawImage (mainCharacterSad.getImage(), 450, 270, 470, 353, null);
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 5100 && count < 5300)
        {
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900, 300, 150, 300, null);
          g.drawImage (mainCharacterSad.getImage(), 450, 270, 470, 353, null);
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count == 5300)
        {
          xPos = 0;
        }
        else if (count > 5300 && count <= 5500)
        {
          xPos++;
          g.drawImage (image4.getImage(), 0, 0, 1024, 576, null);
          g.drawImage (friendSad.getImage(), 900 + xPos, 300, 150, 300, null);
          g.drawImage (mainCharacterSad.getImage(), 450 + xPos, 270, 470, 353, null);
          g.drawImage (text.getImage(), 0, 0, 1024, 600, null);
        }
        else if (count > 5500)
        {
          g.drawImage (image5.getImage(), 0, 0, 1024, 576, null);
        }
      }
    };
  }
  
  /** This is the display() method, which starts the timer, and stops
    * it after the program has run through the action listener 6300 
    * times after the timer has started. It also makes a new instance
    * of all the ImageIcons used in the introduction animation.
    */
  public void display()
  {
    mainPane = new JPanel (new BorderLayout ());
    mainCharacter = new ImageIcon("Girl's front.png");
    mainCharacterSad = new ImageIcon("Main Character Sad.png");
    mainCharacterBack = new ImageIcon("Girl's back.png");
    friendSad = new ImageIcon("Friend sad.png");
    evilScientist = new ImageIcon("EvilScientist.png");
    image1 = new ImageIcon("Image1.png");
    image2 = new ImageIcon("Image2.png");
    image3 = new ImageIcon("Image3.png");
    image4 = new ImageIcon("Image4.png");
    image5 = new ImageIcon("Image5.png");
    blackLine = new ImageIcon("BlackLine.jpg");
    text = new ImageIcon("Text.png");
    xPos = -150;
    yPos = 0;
    frame.add(introPane);
    frame.revalidate();
    frame.repaint();
    frame.setVisible(true);
    animation = new Timer (1, new ActionListener()
                             {
      public void actionPerformed (ActionEvent ae)
      {
        if (count > 6300)
        {
          animation.stop();
          frame.remove (introPane);
          frame.revalidate();
          frame.repaint();
        }
        introPane.revalidate();
        introPane.repaint ();
        count++; 
      }
    });
    animation.start();
  }
  
  
  /** The firstInstructionsPage1() method creates the first set of 
    * instructions that the user gets for the first level. The 
    * instructions are displayed on a panel with a blue background.
    * <b>Local variables: </b>
    * <p>
    * <b>skyBlue </b> This creates an instance of the Color class for the background of the instructions. The color is sky blue.
    * <p>
    * <b>instructionFont </b> This creates an instance of the Font class for the font used in the instructions.
    */
  private void firstInstructionsPage1()
  {
    instructionsPane = new JPanel ();
    instructionsPane.setLayout (null);
    x = 0;
    xLen = 1024;
    yLen = 576;
    Color skyBlue = new Color (10, 200, 250);
    Font instructionFont = new Font ("Serif", Font.BOLD, 30);
    instructionsPane.setBackground(skyBlue);
    instructionsLabel = new JLabel ("<html>You have now entered the living room. Unfortunately, the evil scientist has locked you inside! You must look through the room for a key that is hidden behind an object in this room. Simply DOUBLE tap the objects in the room to see if you can find the key. Once you have found the key, you will be led to the game.</html>");
    instructionsLabel.setFont (instructionFont);
    instructionsPane.add (instructionsLabel);
    instructionsLabel.setBounds (10, 10, 1000, 350);
    frame.add(instructionsPane);
    frame.revalidate();
    frame.repaint();
  }
  
  /** The livingRoom() method adds the living room label that 
    * displays the ImageIcon of the living room to a panel. It
    * then adds the panel to the frame.
    */
  public void livingRoom()
  {
    livingRoom = new ImageIcon("LivingRoom.png");
    lrLabel = new JLabel(livingRoom);
    livingRoomPanel.add(lrLabel);
    frame.add(livingRoomPanel);
    frame.setVisible(true);
  }
  
  /** The clicking() method adds a MouseListener to the frame,
    * so that the user can click around the screen, looking for
    * the clue. It also removes the living room panel.
    */
  public void clicking()
  {
    mouseFirst = true;
    livingRoomPanel.addMouseListener(new MouseAdapter() 
                                       {
      public void mouseClicked(MouseEvent e) 
      {
        if (e.getX()>=417 && e.getX()<=576 && e.getY()>=82 && e.getY()<=208 && mouseFirst == true)
        {
          mouseFirst = false;
          frame.remove(livingRoomPanel);
          displaying();
        }
      }
    });
  }
  
 
  /** The displaying() method displays the living room, and adds the 
    * living room to the living room panel, as well as revalidates and
    * repaints the frame. It also makes a new Level1Game instance, and 
    * calls the executionGame1() method in the Level1Game class.
    */
  public void displaying()
  {
    displayLabel = new JLabel(livingRoom)
    {
      public void paintComponent (Graphics g) 
      {
        try
        {
          g.drawImage (livingRoom.getImage(), x, 0, xLen, yLen, null);
          repaint ();
        }
        catch(Exception e)
        {
        }
      }
    };
    livingRoomPanel.add(displayLabel);
    frame.remove(livingRoomPanel);
    frame.revalidate();
    frame.repaint();
    g1 = new Level1Game(frame, xxClass);
    g1.executionGame1();
  }
  
  /** The getScore() method returns the level 1 score.
    * 
    * @return g1.getScore() This returns the score that is determined in the Level1Game class.
    */
  public Integer getScore()
  {
    return g1.getScore();
  }
  
  /** This is the executionLevel1() method, which calls all of the 
    * methods in this class. This method is used when this class
    * is called in another class. It also makes an ActionListener
    * for the "Close" button in the Instructions panel.
    */
  public void executionLevel1()
  {
    JButton close = new JButton ("Close");
    display();
    firstInstructionsPage1(); 
    instructionsPane.add(close);
    close.setBounds (480, 400, 154, 50);
    close.addActionListener (new ActionListener ()
                               {
      public void actionPerformed (ActionEvent ae)
      {
        frame.remove(instructionsPane);
        frame.revalidate();
        frame.repaint();
        livingRoom();
        clicking();
      }
    });
  }
}
