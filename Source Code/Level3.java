import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.Dimension;

/** The Level3 class give the user a brief understanding of the story line and 
  * explains how to escape the house by coding a robot. It also calls EndAnimation which shows an ending depending on how well the user did in the game 
  * <p>
  * @author H Zhu 
  * @version Final 06.06.17
  * <p>
  * Modifications: removed static main, now works from XtremeXscape class
  * <p>
  * Total hours = 28
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>score </b> int representing how well the user did in the game
  * <p>
  * <b>scrollPane </b> scroll bar added to the JTextArea to allow users to see 
  * <p>
  * <b>close </b> JButton used to move from the instructions screen to the game screen
  * <p>
  * <b>correct </b> boolean that represents whether or not the user's code works
  * <p>
  * <b>resultsPanel </b> JPanel used to show what the user's code looks like when it's run
  * <p>
  * <b>gamePane </b> The JPanel the coding game is on
  * <p>
  * <b>background </b> ImageIcon of the game's background
  * <p>
  * <b>help </b> The instructions JPanel 
  * <p>
  * <b>backgroundStart </b> ImageIcon of the background that the game starts with
  * <p>
  * <b>count </b> int used to keep track of how many times the timer has run
  * <p>
  * <b>numLines </b> the number of lines in the user's code
  * <p>
  * <b>next </b> The JButton used to transfer from the intro pane to the instructions pane 
  * <p>
  * <b>gamePane </b> The JPanel the coding game is on
  * <p>
  * <b>right </b> JButton that turns the robot 90 degrees clockwise
  * <p>
  * <b>left </b> JButton that turns the robot 90 degrees counterclockwise
  * <p>
  * <b>move </b> JButton that moves the robot one step
  * <p>
  * <b>clear </b> JButton that clears the user's previous lines of code
  * <p>
  * <b>run </b> JButton that calls the method that tesets the user's code
  * <p>
  * <b>commands </b> The code that the user wrote
  * <p>
  * <b>directions </b> Teh possible directions the robot can be facing
  * <p>
  * <b>eve </b> ImageIcon of the robot the user is coding
  * <p>
  * <b>xPosition </b> x coordinate of the robot
  * <p>
  * <b>yPosition </b> y coordinate of the robot
  * <p>
  * <b>direction </b> The direction the robot is facing
  * <p>
  * <b>correctString </b> What the user should have as their correct code
  * <p>
  * <b>textArea </b> The JTextArea that the user's code is shown on
  * <p>
  * <b>frame </b> This is the reference of the JFrame that is used throughout the game.
  * <p>
  * <b>gameTimer </b> Timer used to run the animation of the robot following the user's code
  * <p>
  * <b>xxClass </b> Reference variable used to call a method from the XtremeXscape class
  * 
  */
public class Level3 
{
  private int score;
  private JScrollPane scrollPane;
  private JButton close;
  private boolean correct;
  private JPanel resultsPanel;
  private JPanel gamePane;
  private ImageIcon background;
  private JPanel help;
  private JLabel backgroundStart;
  private int count;
  private int numLines;
  private JButton next;
  private JButton right;
  private JButton left;
  private JButton move;
  private JButton clear;
  private JButton run;
  private String commands;
  private String [] directions = {"north", "east", "south", "west"};;
  private ImageIcon eve;
  private int xPosition;
  private int yPosition;
  private int direction;
  private String correctString;
  private JTextArea textArea;
  private JFrame frame;
  private Timer gameTimer;
  private XtremeXscape xxClass;
  
  /** The Level3 constructor initializes the score and numebr of lines of code the user has along with 
    * assigning variables passed through the parameters to the corrisponding instance variables
    * It also instanziates all the JComponents needed in the game and then calls firstGameSetUp
    * 
    * @param frame
    * This is the reference of the JFrame that is used throughout the game.
    * 
    * @param xxClass
    * Reference variable used to call a method from the XtremeXscape class
    */
  public Level3 (JFrame frame, XtremeXscape xxClass)
  {
    score = 0;
    numLines = 0;
    this.frame = frame;
    frame.setVisible (true);
    background = new ImageIcon ("Level3Game.png");
    right = new JButton ("Turn Clockwise");
    left = new JButton ("Turn Counterclockwise");
    move = new JButton ("Move");
    clear = new JButton ("Clear");
    run= new JButton ("Run");
    eve = new ImageIcon ("RobotEve.png");
    textArea = new JTextArea(8, 250);
    textArea.setEditable(false); 
    scrollPane = new JScrollPane (textArea);
    this.xxClass = xxClass;
    firstGameSetUp();
  }
  
  /** The firstGameSetUp method sets up the game pane for the first time the game is played by placing the JComponents in the right spot 
    * and adding action listeners to the JButtons
    * 
    */
  public void firstGameSetUp()
  {
    gamePane = new JPanel ();
    gamePane.setLayout (null);
    gamePane.add(left); 
    left.setBounds (110, 100, 180, 30); 
    gamePane.add(right);
    right.setBounds (110, 150, 180, 30); 
    gamePane.add(move);
    move.setBounds (110, 200, 180, 30); 
    gamePane.add(clear);
    clear.setBounds (110, 250, 180, 30); 
    gamePane.add(run);
    run.setBounds (110, 300, 180, 30); 
    textArea.setWrapStyleWord(true);
    gamePane.add(scrollPane);
    scrollPane.setBounds (80, 350, 255, 150);
    right.addActionListener (new ActionListener ()
                               {
      public void actionPerformed (ActionEvent ae)
      {
        direction = direction % 4 +1;
        numLines++;
        textArea.append("The robot is now facing " + directions[direction-1]  + "\n");
      }
    });
    left.addActionListener (new ActionListener ()
                              {
      public void actionPerformed (ActionEvent ae)
      {
        if (direction == 1)
        {
          direction += 3;
        }
        else
        {
          direction--;
        }
        numLines++;
        textArea.append("The robot is now facing " + directions[direction-1]  + "\n");
      }
    });    
    move.addActionListener (new ActionListener ()
                              {
      public void actionPerformed (ActionEvent ae)
      {
        commands += (direction + "m");
        numLines++;
        textArea.append("The robot has taken a step " + directions[direction-1]  + "\n");
      }
    });
    clear.addActionListener (new ActionListener ()
                               {
      public void actionPerformed (ActionEvent ae)
      {
        commands = "";
        textArea.setText ("");
        direction = 1;
        numLines = 0;
        textArea.append("The robot is now facing " + directions[direction-1]  + "\n");
      }
    });
    run.addActionListener (new ActionListener ()
                             {
      public void actionPerformed (ActionEvent ae)
      {
        if (commands.length() == 0)
        {
          frame.remove(gamePane);
          new EndAnimation (frame, correct, 0, xxClass);
        }
        else
        {
          running ();
        }
      }
    });
    frame.revalidate();
    frame.repaint();
  }
  
  /** The gameSetup method sets up the game every single time the user plays, even after the first
    * 
    * <b>Local variables: </b>
    * <p>
    * <b>robot </b> the JLabel of the robot eve
    * <p>
    * <b>gameBack </b> The background that goes behind the game
    */
  public void gameSetup ()
  {
    score = 0;
    numLines = 0;
    textArea.setText ("");
    JLabel robot = new JLabel (eve);
    gamePane.add(robot);
    robot.setBounds (450, 440, 60, 91);
    JLabel gameBack = new JLabel (background);
    gamePane.add(gameBack);
    gameBack.setBounds (0,0,1024, 549);
  }
  
  /** The game method sets up the position of the robot for when it needs to run through the lazers
    */
  public void game ()
  {
    direction = 1;
    xPosition = 300;
    yPosition = 400;
    commands = "";
    textArea.append("The robot is now facing " + directions[direction-1]  + "\n");
    frame.revalidate();
    frame.repaint();
  }
  
  
  
  
  /** The running method is used to check if the user's code is correct and displays an animation of what is user's code looks like when run
    * The if statements are used to check if the user's code works and when to stop the Timer
    * The timer is used to run the animations of the robot
    * When the animation has stopped running it calls the decision method to decide the score and which animation to show
    */
  public void running ()
  {
    correct = true;
    resultsPanel = new JPanel()
    {
      @Override
      public void paintComponent(Graphics g)
      {
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;
        draw (g2d);
      }
    };
    frame.remove (gamePane);
    frame.add (resultsPanel);
    count = 1;
    correctString = "2m1m2m2m2m1m1m1m";
    if (correctString.equals (commands) == false)
    {
      correct = false;
    }
    correctString += "90";
    gameTimer = new Timer (5, new ActionListener()
                             {
      public void actionPerformed(ActionEvent ae)
      {
        count++;
        moveCharacter(commands.charAt((count-1)/100 *2));
        resultsPanel.revalidate();
        resultsPanel.repaint();
        if (count/100 >= Math.min(correctString.length(), commands.length())/2)
        {
          gameTimer.stop();
          decision ();
        }   
        else if (count % 100 == 0)
        {
          if (correctString.substring ((count-1)/100 * 2, (count-1)/100 * 2 +1 ).equals(commands.substring ((count-1)/100 * 2, (count-1)/100 * 2+1)) == false)
          { 
            gameTimer.stop();
            decision ();
          }
        }
      }
    });
    gameTimer.start();
    
  }
  
  /** The decision method is used to determine the user's score and which ending the final message will display
    * The if statement is used to check that the user's code is valid before giving them any points
    * It then call the EndAnimation class to show the animation
    */
  public void decision ()
  {
    frame.remove(resultsPanel);
    if (correct)
    {
      score = (int) 2400/numLines;
    }
    new EndAnimation (frame, correct, score, xxClass);
  }
  
  
  
  /** The moveCharacter method is used to move the robot in the direction that corrisponds with the user's code
    * The if statements are used to determine how to manipulate the robot's coordinates depending on what the user's code says
    * @param direction
    * used to determine which direction the user's code tells the robot to mmove and how that changes the robot's x and y coordinates
    */
  public void moveCharacter (char direction)
  {
    if (direction == '1')
    {
      yPosition--;
    }
    else if (direction == '2')
    {
      xPosition++;
    }
    else if (direction == '3')
    {
      yPosition++;
    }
    else 
    {
      xPosition--;
    }
    
  }
  
  /** The draw method is responsible for actually drawing the robot onto the JPanel
    * 
    * @param g2d
    * The casted version of graphics used to draw onto the JPanel
    */
  public void draw (Graphics2D g2d)
  { 
    ImageIcon executeBackground = new ImageIcon ("Level3GameExecution.png");
    g2d.drawImage (executeBackground.getImage(), 0, -5, 1024, 576, null);
    g2d.drawImage (eve.getImage(), xPosition, yPosition, 60, 91,null);
  }
  
  /** The getScore method return the user's score
    * 
    * @return score
    * used to calculate the user's final score
    */
  public int getScore ()
  {
    return score;
  }
  
  /** The helpMethod is the setup for the instructions pane
    * It takes away the previos pane and then add the instructions pane onto the frame
    * 
    * <b>Local variables: </b>
    * <p>
    * <b>title </b> The JLabel with the title of the panel
    * <p>
    * <b>size </b> The preferred size of JComponents
    * <p>
    * <b>info </b> The Jlabel that contains the instructions to the game
    */
  public void helpMethod ()
  {
    frame.remove(backgroundStart);
    frame.remove (next);
    help = new JPanel();
    help.setBackground(new java.awt.Color(123, 247, 189));
    help.setLayout (null);
    JLabel title = new JLabel ("Instructions");
    title.setFont(new java.awt.Font("Copperplate", 1, 25));
    help.add(title);
    Dimension size = title.getPreferredSize();
    title.setBounds (512 - size.width/2, 15, size.width, size.height);
    JLabel info = new JLabel ("<html>YOU CANNOT ACCESS THIS PAGE ONCE IT HAS BEEN CLOSED.<br><br>In order to pass this level you must program your robot to reach the finish without running into the lasers.<br><br>To program the robot, click the different buttons in the correct order.<br>The Turn Counterclockwise will rotate the robot 90 degrees counterclockwise so it is facing left of where it was originally.<br>The Turn Clockwise, will rotate the robot 90 degrees clockwise is it is facing right of where is was originally.<br>The Move button moves the robot one space in the indicated direction.<br>The Clear button erases all previous commands.<br>The Run button will test the code that you have entered so far.<br>All your robot's programmed moves will appear in the box below the buttons.<br><br>Be careful though, if your code does not run correctly you will be sent back to the levels menu and have to start all over again.<br>Your score is determined by the number of lines of code that you have.<br>The less lines of code you have the higher your score, but only if your code works, or else you get a score of zero.<br><br>Good luck!</html>");
    help.add(info);
    size = info.getPreferredSize();
    info.setBounds (15, 15, 1000, 400);
    frame.add (help);
    frame.revalidate();
    frame.repaint();
  }
  
  /** The execution method is used to organize the flow of the program 
    * It is responsible for the order that the different JPanels are put onto the screen and for when they are removed
    */
  public void execution ()
  {
    next = new JButton ("Go!");
    close = new JButton("Close Instructions");
    ImageIcon hallway = new ImageIcon("Hallway.png");
    backgroundStart = new JLabel(hallway);
    frame.add (next);
    next.setBounds (900, 507, 55, 25);
    frame.add(backgroundStart);
    backgroundStart.setBounds (0,0,1024,459);
    frame.revalidate();
    frame.repaint();
    next.addActionListener (new ActionListener ()
                              {
      public void actionPerformed (ActionEvent ae)
      {
        helpMethod();
        frame.revalidate();
        frame.repaint();
        
        help.add (close);
        Dimension size = close.getPreferredSize();
        close.setBounds (450, 400, size.width, size.height);
        frame.revalidate();
        frame.repaint();
        
        
      }
    });
    close.addActionListener (new ActionListener()
                               {
      public void actionPerformed (ActionEvent ae)
      {
        frame.remove (help);
        gameSetup();
        frame.add (gamePane);
        frame.revalidate();
        frame.repaint();
      }
    });
    game();
    
  }
}


