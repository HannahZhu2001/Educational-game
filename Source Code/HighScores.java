import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;
import java.io.*;

/** The HighScores class sorts, reads in, writes out abd displays the highscores of the game
  * It also has an option of clearing the highscores
  * <p>
  * @author H Zhu 
  * @version Final 06.06.17
  * <p>
  * Modifications: created this class (it didn't exsist before)
  * <p>
  * Total hours = 12
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b> frame </b> This is the reference of the JFrame that is used throughout the game.
  * <p>
  * <b> names </b> This an array list used to store the names of the top players
  * <p>
  * <b> scores </b> This an array list used to store the scores of the top players
  * <p>
  * <b> pane </b> This is panel that the highscores are displayed on
  * 
  */
public class HighScores 
{
  private JFrame frame;
  private ArrayList<String> names = new ArrayList<String> ();
  private ArrayList<Integer> scores = new ArrayList<Integer> ();
  JPanel pane;
  
  /** The HighScores constructor assigns the value of the Jframe passed to the constructor to the instance variable frame and initializes pane
    * 
    * @param frame
    * This is the reference of the JFrame that is used throughout the game.
    */
  public HighScores (JFrame frame)
  {
    this.frame = frame;
    pane = new JPanel ();
  }
  
  /** The display method calls the readIn method and the sort method and then displays the high scores
    * It also give the option to clear the highscores by outputing nothing to the highscores file
    * The for loop is used to store all of the statistics onto JLabels
    * 
    * <b> Local variables: </b>
    * <p>
    * <b> nameLabel </b> A label that is used as the heading for the names column
    * <p>
    * <b> scoreLabel </b> A label that is used as the heading for the scores column
    * <p>
    * <b> title </b> The title high scores on the top of the Jpanel
    * <p>
    * <b> rankLabel </b> A label that is used as the heading for the rankings column
    * <p>
    * <b> ranksToStore </b> A string used to store ranks that will eventually be put on a JLabel
    * <p>
    * <b> namesToStore </b> A string used to store names that will eventually be put on a JLabel
    * <p>
    * <b> scoresToStore </b> A string used to store scores that will eventually be put on a JLabel
    * <p>
    * <b> x </b> int used to run a for loop
    * <p>
    * <b> displayNames </b> JLabel of namesToStore
    * <p>
    * <b> displayScores </b> JLabel of scoresToStore
    * <p>
    * <b> displayRanks </b> JLabel of ranksToStore
    * <p>
    * <b> scoresToStore </b> A string used to store scores that will eventually be put on a JLabel
    * <p>
    * <b> size </b> used to store preffered dimensions of a JComponent
    * <p>
    * <b> clear </b> JButton used to clear the high scores
    * 
    */
  public void display ()
  {
    readIn();
    sort();
    pane.removeAll();
    pane.setLayout (null);
    pane.setBackground(new java.awt.Color(123, 247, 240));
    JLabel nameLabel = new JLabel ("Name");
    nameLabel.setFont(new java.awt.Font("Copperplate", 1, 20));
    JLabel scoreLabel = new JLabel ("Score");
    scoreLabel.setFont(new java.awt.Font("Copperplate", 1, 20));
    JLabel title = new JLabel ("High Scores");
    title.setFont(new java.awt.Font("Copperplate", 1, 25));
    JLabel rankLabel = new JLabel ("Ranking");
    rankLabel.setFont(new java.awt.Font("Copperplate", 1, 20));
    String ranksToStore = "<html>";
    String namesToStore = "<html>";
    String scoresToStore = "<html>";
    for (int x = 0; x < names.size(); x++)
    {
      namesToStore += (names.get(x) + "<br>");
      scoresToStore += (scores.get(x) + "<br>");
      ranksToStore += ((x+1) + "<br>");
    }
    namesToStore += "</html>";
    scoresToStore += "</html>";
    ranksToStore += "</html>";
    JLabel displayNames = new JLabel (namesToStore);
    JLabel displayScores = new JLabel (scoresToStore);
    JLabel displayRanks = new JLabel (ranksToStore);
    pane.add(title);
    Dimension size = title.getPreferredSize();
    title.setBounds (512 - size.width/2, 15, size.width, size.height);
    size = displayRanks.getPreferredSize();
    pane.add(rankLabel);
    rankLabel.setBounds (180, 50, 80, 50);
    pane.add(displayRanks);
    displayRanks.setBounds (210, 100, 80, size.height);
    pane.add(nameLabel);
    nameLabel.setBounds (480, 50, 150, 50);
    pane.add(scoreLabel);
    scoreLabel.setBounds (780, 50, 100, 50);
    pane.add(displayNames);
    displayNames.setBounds (480, 100, 100, size.height);
    pane.add(displayScores);
    displayScores.setBounds (800, 100, 100, size.height);
    JButton clear = new JButton ("Clear Scores");
    clear.addActionListener (new ActionListener ()
                               {
      public void actionPerformed (ActionEvent ae)
      {
        scores.clear();
        names.clear();
        pane.removeAll();
        try
        {
          File textFile = new File(System.getProperty("user.home") + "/HighScores.haha");
          PrintWriter out = new PrintWriter (new FileWriter (textFile));
          out.print ("");
          out.close();
        }
        catch (IOException e)
        {
        }
        display();
      }
    });
    pane.add(clear);
    clear.setBounds (452, 450, 120, 30);
    frame.add(pane);
    frame.revalidate();
    frame.repaint();
  }
  
  /** The method addName adds a name and a score to the file if the username did not exist before or else just saves the higher score of the two scores for the username
    * The for loop and if statement is used to determine if there is anyone else in the rankings with the same username and then it calls sort
    * 
    * @param newScore
    * the new score of the player that's to be added onto highscores
    * 
    * @param newName
    * the new name of the player that's to be added onto highscores
    */
  public void addName(int newScore, String newName)
  {
    boolean found = false;
    for (int x = 0; x < names.size(); x++)
    {
      if (names.get(x).equals (newName))
      {
        found = true;
        scores.set(x, (Math.max(scores.get(x), newScore)));
      }
    }
    if (found == false) 
    {
      names.add(newName);
      scores.add(newScore);
    }
    sort();
  }
  /** The sort method sorts all the rankings in the arraylists and arranges them in order from highest score to lowest score
    * the double for loops and if statement is used to sort the ranksing in order of highest score
    * The second if statement is used to check if there's an 11th element and to remove it from the arraylists before it's outputed into a file
    * The try block is used to catch any IOExceptions that may occur when writing out to a file
    * 
    * <b> Local variables: </b>
    * <p>
    * <b> tempName </b> String used to store a person's name while swapping the places of 2 elements in the arraylist
    * <p>
    * <b> tempScore </b> int used to store a person's score while swapping the places of 2 elements in the arraylist
    * <p>
    * <b> index </b> int used to hole the index of the highest score
    * <b> x </b> int used to run a for loop
    * <p>
    * <b> y </b> int used to run a for loop
    * <p>
    * <b> textFile </b> the text file the method is writting to 
    * <p>
    * <b> out </b> PrintWriter used to write to a text file
    */
  public void sort ()
  {
    String tempName;
    int tempScore;
    int index = 0;
    for (int x = 0; x < scores.size() -1; x++)
    {
      index = x;
      for (int y = x; y < scores.size(); y++)
      {
        if (scores.get(index) < scores.get(y))
        {
          index = y;
        }
      }
      tempScore = scores.get(index);
      tempName = names.get(index);
      scores.set(index, scores.get(x));
      names.set(index, names.get(x));
      scores.set(x,tempScore);
      names.set(x, tempName);
    }
    if (scores.size() > 10)
    {
      scores.remove(11);
      names.remove(11);
    }
    //writes the scores to file
    try
    {
      File textFile = new File(System.getProperty("user.home") + "/HighScores.haha");
      PrintWriter out = new PrintWriter (new FileWriter (textFile));
      for (int x =0; x < names.size(); x++)
      {
        out.println (names.get(x));
        out.println (scores.get(x));
      }
      out.close();
    }
    catch (IOException e)
    {
    }
  }
  
  /** The method readIn is used to read in the list of highscores from a text file and then store the info into arrayLists
    * The try block is used to catch any IOExceptions that may occur when reading in from a file
    * 
    * <b> Local variables: </b>
    * <p>
    * <b> temp </b> String used read in a line and check if it is null, if it isn't then it is added to the names ArrayList
    * <p>
    * <b> in </b> BufferedReader used to help read in from a file
    * <p>
    * <b> fileIn </b> The file the method is reading in from 
    */
  public void readIn ()
  {
    String temp;
    BufferedReader in;
    names.clear();
    scores.clear();
    try
    {
      FileInputStream fileIn = new FileInputStream(System.getProperty("user.home") + "/HighScores.haha");
      in = new BufferedReader (new FileReader (System.getProperty("user.home") + "/HighScores.haha"));
      temp = in.readLine();
      while (temp != null && temp.equals("")==false)
      {
        names.add(temp);
        scores.add(Integer.parseInt(in.readLine()));
        temp = in.readLine();
      }
      in.close();
    }
    catch (IOException e)
    {
    }
  }
  
}