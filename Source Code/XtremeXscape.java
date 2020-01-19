import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** The XtremeXscape class makes the JFrame, and calls all of the necessary classes. This class
  * makes the program. When the user plays this program, first a small splashscreen animation
  * appears, and the main menu appears. There is one menu called "Options", with 5 menu items: 
  * "Levels", "Instructions", "High Scores", "Save Score", and "Quit". When the user clicks the
  * "Levels" menu item, they are taken to the levels menu. From there they can decide which level
  * they want to play. There are 3 levels. When the user clicks the "Instructions" menu item, 
  * they are taken to the instructions page where they can view instructions. When the user clicks
  * the "High Scores" menu item, they are taken to the High Scores page where they can see all of
  * the top scores. When the user clicks the "Save Score" menu item, they are taken to a page where
  * they can save their score under a username. Finally, if they click the "Quit" menu item, they
  * are taken to the credits screen, and the program will close.
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>frame </b> This is the reference of the JFrame that is used throughout the game.
  * <p>
  * <b>livingRoom </b> This creates an instance of the ImageIcon class for the living room.
  * <p>
  * <b>hauntedHouse </b> This creates an instance of the ImageIcon class for the haunted house.
  * <p>
  * <b>girl </b> This creates an instance of the ImageIcon class for the girl.
  * <p>
  * <b>enterspot </b> This creates an instance of the JTextField class for the place they need to enter their username.
  * <p>
  * <b>houseLabel </b> This creates an instance of the JLabel class for the haunted house.
  * <p>
  * <b>panelHouse </b> This creates an instance of the JPanel class for the haunted house panel.
  * <p>
  * <b>options </b> This creates an instance of the JMenu class for the options menu.
  * <p>
  * <b>highScores </b> This creates an instance of the JMenuItem class for the high scores menu item.
  * <p>
  * <b>quit </b> This creates an instance of the JMenuItem class for the quit menu item.
  * <p>
  * <b>save </b> This creates an instance of the JMenuItem class for the save menu item.
  * <p>
  * <b>instructions </b> This creates an instance of the JMenuItem class for the instructions menu item.
  * <p>
  * <b>levels </b> This creates an instance of the JMenuItem class for the levels menu item.
  * <p>
  * <b>myMenu </b> This creates an instance of the JMenuBar class for the menu bar.
  * <p>
  * <b>savePage </b> This creates an instance of the JPanel class for the save page.
  * <p>
  * <b>instructionsPage </b> This creates an instance of the JPanel class for the instructions page.
  * <p>
  * <b>hs </b> This creates an instance of the HighScores class.
  * <p>
  * <b>levelsPage </b> This creates an instance of the JPanel class for the levels page.
  * <p>
  * <b>xxClass </b> This creates an instance of the XtremeXscape class.
  * <p>
  * <b>l1 </b> This creates an instance of the Level1 class.
  * <p>
  * <b>l2 </b> This creates an instance of the Level2 class.
  * <p>
  * <b>l3 </b> This creates an instance of the Level3 class.
  * <p>
  * <b>score1 </b> This stores level 1's score.
  * <p>
  * <b>score2 </b> This stores level 2's score.
  * <p>
  * <b>score3 </b> This stores level 3's score.
  * 
  * @author Hannah Zhu and Jessica Peter
  * @version Final 06.06.17
  * Time Spent: 20 hours
  */
public class XtremeXscape extends JFrame
{
  private JFrame frame;
  private ImageIcon livingRoom;
  private ImageIcon hauntedHouse;
  private ImageIcon girl;
  private JTextField enterspot;
  private JLabel houseLabel;
  private JPanel panelHouse;
  private JMenu options;
  private JMenuItem highScores;
  private JMenuItem quit;
  private JMenuItem save;
  private JMenuItem instructions;
  private JMenuItem levels;
  private JMenuBar myMenu;
  private JPanel savePage;
  private JPanel instructionsPage;
  private HighScores hs;
  private JPanel levelsPage;
  private XtremeXscape xxClass;
  private Level1 l1;
  private Level2 l2;
  private Level3 l3;
  private int score1;
  private int score2;
  private int score3;
  
  /** The XtremeXscape constuctor gives a value to xxClass, and creates a new JPanel for
    * levelsPage, panelHouse, instructionsPage, and savePage. It also creates a new JFrame
    * with the title, Xtreme Xscape. It sets the size, layout, resizability, default close
    * operation, and its visibility. It also makes a new HighScores instance, as well as a new
    * instance of the Level1, Level2, and Level3 classes.
    */
  public XtremeXscape()
  {
    xxClass = this;
    levelsPage = new JPanel();
    panelHouse = new JPanel ();
    instructionsPage = new JPanel ();
    savePage = new JPanel ();
    frame = new JFrame ("Xtreme Xscape");
    frame.setSize (1020, 576);
    frame.setLayout (new BorderLayout ());
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible (true);
    hs  = new HighScores (frame);
    l1 = new Level1 (frame, xxClass);
    l2 = new Level2 (frame, xxClass);
    l3 = new Level3 (frame, xxClass);  
  }
  
  /** The hauntedHousePic() method makes the haunted house display.
    * <b>Local variables: </b>
    * <p>
    * <b>title </b> This creates an instance of the JLabel class for the title.
    */
  public void hauntedHousePic()
  {
    new OpenAnimation (frame);
    JLabel title = new JLabel ("Xtreme Xscape");
    hauntedHouse = new ImageIcon("HauntedHouse.png");
    houseLabel = new JLabel(hauntedHouse);
    panelHouse.setLayout (null);
    title.setForeground (Color.WHITE);
    title.setFont(new java.awt.Font("Brush Script MT", Font.BOLD, 120));
    panelHouse.add (title);
    title.setBounds (160, 0, 700, 200);
    panelHouse.add (houseLabel);
    houseLabel.setBounds (0, 0, 1024, 576);
    frame.add(panelHouse);
    frame.setVisible(true);
  }
  
  /** The instructionsSetUp() method removes the panelHouse, levelsPage, savePage, and HighScores
    * panel from the frame, and the sets the background of the panel. It then creates and displays
    * the instructions for the program.
    * <b>Local variables: </b>
    * <p>
    * <b>title </b> This creates an instance of the JLabel class for the title.
    * <p>
    * <b>size </b> This creates the dimensions of the title.
    * <p>
    * <b>info </b> This creates an instance of the JLabel class for the instructions of the game.
    */
  public void instructionsSetUp()
  {
    frame.remove (panelHouse);
    frame.remove (levelsPage);
    frame.remove (savePage);
    frame.remove (hs.pane);
    instructionsPage.setBackground(new java.awt.Color(123, 247, 189));
    instructionsPage.setLayout(null);
    JLabel title = new JLabel("Instructions");
    title.setFont(new java.awt.Font("Copperplate", 1, 25));
    instructionsPage.add (title);
    Dimension size = title.getPreferredSize();
    title.setBounds(400, 25, 300, size.height);
    JLabel info = new JLabel ("<html>You are trapped inside Dr EveVil's house and need to escape! The only way to do so is to pass all three levels.<br><br> To access the levels go to the levels page and click the level that you want to play.<br>Instructions will pop up before the game, make sure to read carefully because you can't access them after you close them.<br> Once you are in a level you are only able to exit by finishing the level (you don't have to finish with a good score).<br>After finishing a level you will return to the levels page of the game.<br>In each level you can win up to 200 points.<br><br>You can view your score in the highscores screen also accessible through the menu.<br>The high scores menu also has an option of clearing the previous highscores.<br><br>To save your score you can go to the save option in the menu and type in your username.<br><br>To exit this game press the quit option on the menu.<br><br>Now you've learned the basics of this game, can you escape Dr EveVil's house before it's too late?</html>");
    instructionsPage.add(info);
    size = info.getPreferredSize();
    info.setBounds(25, 100, size.width, size.height);
    instructionsPage.setVisible(true);
    frame.add(instructionsPage);
    frame.repaint();
    frame.revalidate();
  }
  
  /** The levelsSetUp() method sets up the levels menu. It creates 3 buttons, that when clicked
    * will lead the user to a different level.
    * <b>Local variables: </b>
    * <p>
    * <b>level1 </b> This creates an instance of the JButton class for the level 1 button.
    * <p>
    * <b>level2 </b> This creates an instance of the JButton class for the level 2 button.
    * <p>
    * <b>level3 </b> This creates an instance of the JButton class for the level 3 button.
    * <p>
    * <b>title </b> This creates an instance of the JLabel class for the title.
    */
  public void levelsSetUp()
  {    
    levelsPage.setLayout (null);
    levelsPage.setBackground(new Color(240, 200, 233));
    frame.remove (panelHouse);
    frame.remove (savePage);
    frame.remove (instructionsPage);
    frame.remove (hs.pane);
    JButton level1 = new JButton ("Level 1");
    JButton level2 = new JButton ("Level 2");
    JButton level3 = new JButton ("Level 3");
    JLabel title = new JLabel("Levels");
    title.setFont(new java.awt.Font("Copperplate", 1, 30));
    levelsPage.add (title);
    title.setBounds (450, 0, 132, 50);
    levelsPage.add (level1);
    level1.setBounds (430, 150, 142, 50);
    levelsPage.add (level2);
    level2.setBounds (430, 250, 142, 50);
    levelsPage.add (level3);
    level3.setBounds (430, 350, 142, 50);
    frame.add(levelsPage);
    frame.repaint();
    frame.revalidate();
    level1.addActionListener (new ActionListener ()
                                {
      public void actionPerformed (ActionEvent ae)
      {
        frame.remove (levelsPage);
        options.setEnabled (false);
        l1 = new Level1 (frame, xxClass);
        l1.executionLevel1 ();
      }
    });
    level2.addActionListener (new ActionListener ()
                                {
      public void actionPerformed (ActionEvent ae)
      {
        frame.remove (levelsPage);
        options.setEnabled (false);
        l2.execution ();
      }
    });
    level3.addActionListener (new ActionListener ()
                                {
      public void actionPerformed (ActionEvent ae)
      {
        frame.remove (levelsPage);
        options.setEnabled (false);
        l3.execution ();
      }
    });
  }
  
  /** The afterLevel() method displays the frame after the level has finished. The options menu
    * is set to enabled again, and the levelsPage panel is added back on the frame. The frame is
    * then repainted.
    */
  public void afterLevel ()
  {
    options.setEnabled (true);
    frame.add (levelsPage);
    frame.repaint();
  }
  
  /** The menu() method controls the flow of all of the menu items, and determines which method to
    * call when each menu item is clicked.
    */
  public void menu()
  {
    options = new JMenu ("Options");
    levels = new JMenuItem("Levels");
    instructions = new JMenuItem("Instructions");
    highScores = new JMenuItem ("High Scores");
    save = new JMenuItem ("Save Score");
    quit = new JMenuItem ("Quit");
    myMenu = new JMenuBar ();
    options.add (levels);
    options.add (instructions);
    options.add (highScores);
    options.add (save);
    options.add (quit);
    myMenu.add (options);
    frame.add (myMenu, BorderLayout.NORTH);
    instructions.addActionListener (new ActionListener ()
                                      {
      public void actionPerformed (ActionEvent ae)
      {
        instructionsSetUp();
      }
    });
    levels.addActionListener (new ActionListener ()
                                {
      public void actionPerformed (ActionEvent ae)
      {
        levelsSetUp();
      }
    });
    quit.addActionListener (new ActionListener ()
                              {
      public void actionPerformed (ActionEvent ae)
      {
        options.setEnabled (false);
        frame.remove (panelHouse);
        frame.remove (savePage);
        frame.remove (levelsPage);
        frame.remove (instructionsPage);
        frame.remove (hs.pane);
        new Credits (frame);
      }
    });
    highScores.addActionListener (new ActionListener ()
                                    {
      public void actionPerformed (ActionEvent ae)
      {
        frame.remove (panelHouse);
        frame.remove (savePage);
        frame.remove (levelsPage);
        frame.remove (instructionsPage);
        frame.remove (hs.pane);
        hs.display();
      }
    });
    save.addActionListener (new ActionListener ()
                              {
      public void actionPerformed (ActionEvent ae)
      {
        frame.remove (panelHouse);
        frame.remove (levelsPage);
        frame.remove (instructionsPage);
        frame.remove (hs.pane);
        saveMethod();
      }
    });
    frame.setVisible (true);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
  }
  
  /** The save method saves the user's current score under a username. The user's current score
    * is made up of their score in levels 1-3. The username cannot have any special characters.
    * When the score is saved, a message will display on the JTextField, confirming that it was
    * saved.
    * <b>Local variables: </b>
    * <p>
    * <b>saving </b> This creates an instance of the JButton class for the "Save" button.
    * <p>
    * <b>title </b> This creates an instance of the JLabel class for the title.
    * <p>
    * <b>size </b> This creates the dimensions of the title.
    * <p>
    * <b>scoreDisplay </b> This creates an instance of the JLabel class for their current score.
    * <p>
    * <b>info </b> This creates an instance of the JLabel class for the instructions of what the user should do.
    * <p>
    * <b>valid </b> This stores whether the username is valid or not.
    * <p>
    * <b>username </b> This stores the user's username.
    */
  public void saveMethod ()
  {
    score1 = Math.max(score1, l1.getScore());
    score2 = Math.max(score2, l2.getScore());
    score3 = Math.max(score3, l3.getScore());
    savePage.removeAll();
    savePage.setLayout (null);
    savePage.setBackground(new java.awt.Color(202, 204, 240));
    enterspot = new JTextField ();
    savePage.add(enterspot);
    enterspot.setLocation (380,255);
    enterspot.setSize(270,30);
    enterspot.setText("");
    JButton saving = new JButton ("Save");
    savePage.add (saving);
    saving.setBounds (440, 400, 150, 40);
    JLabel title = new JLabel ("Save Your Score");
    title.setFont(new java.awt.Font("Copperplate", 1, 25));
    savePage.add (title);
    Dimension size = title.getPreferredSize();
    title.setBounds(400, 25, 340, size.height);
    JLabel scoreDisplay = new JLabel ("Your current score is: " + (score1+score2+score3));
    savePage.add(scoreDisplay);
    size = scoreDisplay.getPreferredSize();
    scoreDisplay.setBounds(440, 140, size.width, size.height);
    JLabel info = new JLabel ("Please enter your username (can't contain special characteres)");
    savePage.add(info);
    size = info.getPreferredSize();
    info.setBounds(340, 230, size.width, size.height);
    savePage.setVisible(true);
    frame.add(savePage);
    frame.repaint();
    frame.revalidate();
    saving.addActionListener (new ActionListener ()
                                {
      public void actionPerformed (ActionEvent ae)
      {
        boolean valid = true;
        String username = enterspot.getText();
        for (int x = 0; x <username.length(); x++)
        {
          if ((username.charAt(x)< 65 || username.charAt(x)> 90)&&(username.charAt(x)< 48 || username.charAt(x)> 57)&&(username.charAt(x)< 97 || username.charAt(x)> 122)&& username.charAt(x)!=32)
          {
            valid = false;
          }
        }
        if (username.equals(""))
        {
          enterspot.setText("Username has to contain at least one character");
        }
        else if (valid)
        {
          hs.addName (score1+score2+score3, username);
          enterspot.setText("Saved");
        }
        else
        {
          enterspot.setText("Username can't contain special characters");
        }
      }
    });
  }
  
  /** The main method creates an instance of the XtremeXscape class,
    * and calls the hauntedHousePic() method, as well as the menu() 
    * method.
    * 
    * @param args [ ]  String array that allows command line
    * parameters to be used when executing the program.
    */ 
  public static void main (String[]args)
  {
    XtremeXscape x1 = new XtremeXscape();
    x1.hauntedHousePic();
    x1.menu();
  }
}