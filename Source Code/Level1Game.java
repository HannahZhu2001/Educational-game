import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer.*;

/** The Level1Game class creates the mini game for the first 
  * level. It teaches the user how to classify animals into
  * the 6 animal classes. A chart is generated with the 6 types
  * of animals (mammal, bird, fish, reptile, amphibian, and
  * invertebrate) as the top headings on the first row. On the
  * first column, 5 animals are displayed. There are 5 possible
  * groups of animals that can be displayed. The program randomly
  * decides which group to display. The user must match each animal
  * with the correct group it belongs in by clicking on the correct
  * box in the chart. They are allowed to change their answers 
  * until they click the "Run" button. Once the "Run" button is 
  * clicked, it becomes disabled and they are not allowed to 
  * reclick it. If their answer is correct, the box turns green.
  * If their answer is wrong, the box turns red. If they haven't
  * chosen an answer for that animal, nothing happens. The user
  * knows if they have chosen an answer for each animal because
  * the box turns orange as they are guessing. For each correct
  * answer, the user gets 40 points, for a maximum of 200 points. 
  * There is no penalty for a wrong answer. 
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>frame </b> This is the reference of the JFrame that is used throughout the game.
  * <p>
  * <b>panel </b> This creates an instance of the JPanel class.
  * <p>
  * <b>instructionsPaneGame </b> This creates an instance of the JPanel class for the instructions.
  * <p>
  * <b>instructionsLabel </b> This creates an instance of the JLabel class used to display the instructions.
  * <p>
  * <b>returnButton </b> This creates an instance of the JButton class.
  * <p>
  * <b>correct1 </b> This String variable stores the correct classification for the first animal.
  * <p>
  * <b>correct2 </b> This String variable stores the correct classification for the second animal.
  * <p>
  * <b>correct3 </b> This String variable stores the correct classification for the third animal.
  * <p>
  * <b>correct4 </b> This String variable stores the correct classification for the fourth animal.
  * <p>
  * <b>correct5 </b> This String variable stores the correct classification for the fifth animal.
  * <p>
  * <b>animal1 </b> This String variable stores the user's guess of the classification for the first animal.
  * <p>
  * <b>animal2 </b> This String variable stores the user's guess of the classification for the second animal.
  * <p>
  * <b>animal3 </b> This String variable stores the user's guess of the classification for the third animal.
  * <p>
  * <b>animal4 </b> This String variable stores the user's guess of the classification for the fourth animal.
  * <p>
  * <b>animal5 </b> This String variable stores the user's guess of the classification for the fifth animal.
  * <p>
  * <b>isAnim1 </b> This boolean variable stores whether the first group of animals is displayed.
  * <p>
  * <b>isAnim2 </b> This boolean variable stores whether the second group of animals is displayed.
  * <p>
  * <b>isAnim3 </b> This boolean variable stores whether the third group of animals is displayed.
  * <p>
  * <b>isAnim4 </b> This boolean variable stores whether the fourth group of animals is displayed.
  * <p>
  * <b>isAnim5 </b> This boolean variable stores whether the fifth group of animals is displayed.
  * <p>
  * <b>xVal1 </b> This int variable stores the x-coordinate of orangeLabel1.
  * <p>
  * <b>xVal2 </b> This int variable stores the x-coordinate of orangeLabel2.
  * <p>
  * <b>xVal3 </b> This int variable stores the x-coordinate of orangeLabel3.
  * <p>
  * <b>xVal4 </b> This int variable stores the x-coordinate of orangeLabel4.
  * <p>
  * <b>xVal5 </b> This int variable stores the x-coordinate of orangeLabel5.
  * <p>
  * <b>yVal1 </b> This int variable stores the y-coordinate of orangeLabel1.
  * <p>
  * <b>yVal2 </b> This int variable stores the y-coordinate of orangeLabel2.
  * <p>
  * <b>yVal3 </b> This int variable stores the y-coordinate of orangeLabel3.
  * <p>
  * <b>yVal4 </b> This int variable stores the y-coordinate of orangeLabel4.
  * <p>
  * <b>yVal5 </b> This int variable stores the y-coordinate of orangeLabel5.
  * <p>
  * <b>disableRun </b> This boolean variable stores whether the run button is disabled.
  * <p>
  * <b>xxClass </b> This creates an instance of the XtremeXscape class.
  * <p>
  * <b>pauseTimer </b> This creates an instance of the Timer class.
  * <p>
  * <b>score </b> This int variable stores the user's score.
  * <p>
  * <b>done </b> This stores whether the user is done the game.
  * 
  * @author Jessica Peter
  * @version Final 06.06.17
  * 
  * Total hours: 20 hours
  */ 
public class Level1Game 
{
  
  private JFrame frame;
  private JPanel panel;
  private JPanel instructionsPaneGame;
  private JLabel instructionsLabel;
  private JButton returnButton;
  private String correct1, correct2, correct3, correct4, correct5;
  private String animal1, animal2, animal3, animal4, animal5;
  private boolean isAnim1, isAnim2, isAnim3, isAnim4, isAnim5;
  private int xVal1,xVal2, xVal3, xVal4, xVal5;
  private int yVal1, yVal2, yVal3, yVal4, yVal5;
  private boolean disableRun;
  private XtremeXscape xxClass;
  private javax.swing.Timer pauseTimer;
  private int score;
  private boolean done;
  
  /** The constructor of the Level1Game class passes a JFrame as a 
    * parameter, so that when this class is called in another class,
    * the game will be displayed on the same frame as the frame of
    * the other class. The constructor also creates the JPanel.
    * @param frame This makes an instance of the JFrame class.
    * @param xxClass This makes an instance of the XtremeXscape class.
    */
  public Level1Game(JFrame frame, XtremeXscape xxClass)
  {
    this.frame = frame;
    this.xxClass = xxClass;
    panel = new JPanel();
    panel.setLayout (null);
  }
  
  /** The secondInstructionsPage1() method displays the second
    * set of instructions for level 1. It tells the user that
    * they have uncovered the location of the key, and now
    * must play the game to get the clue.
    */
  public void secondInstructionsPage1()
  {
    instructionsPaneGame = new JPanel();
    instructionsPaneGame.setLayout(null);
    instructionsPaneGame.setBackground(new Color (147, 255, 200));
    instructionsLabel = new JLabel ("<html>You have found the location of the key! It was behind the painting. To get out of the room, however, you need to play this mini game. Match the given animals to the animal class that they belong to. To match the animals, tap the correct box in the chart, and then hit the Run button.</html>");
    instructionsLabel.setBounds(25, 100, 984, 300);
    instructionsLabel.setFont (new Font("Serif", Font.BOLD, 30));
    instructionsPaneGame.add (instructionsLabel);
    frame.add (instructionsPaneGame);
    frame.revalidate();
    frame.repaint();
  }
  
  /**
   * This is the drawBackground() method, which draws the title (Guess 
   * the Animal), along with the lines for the chart, and the top
   * headings in the chart (Mammal, Bird, Fish, Reptile, Amphibian,
   * Invertebrate).
   * <b>Local variables: </b>
   * <p>
   * <b>blackLine </b> This creates the ImageIcon for the black lines used in the chart.
   * <p>
   * <b>blackLabel </b> This creates an instance of the JLabel class for the black lines in the chart.
   * <p>
   * <b>big </b> This creates the big font for the short top headings in the chart.
   * <p>
   * <b>small </b> This creates the small font for the Invertebrate top heading in the chart.
   * <p>
   * <b>title </b> This creates the font for the title.
   * <p>
   * <b>titleLabel </b> This creates an instance of the JLabel class with the name "Guess the Animal".
   * <p>
   * <b>mammals </b> This creates an instance of the JLabel class with the name "Mammal".
   * <p>
   * <b>birds </b> This creates an instance of the JLabel class with the name "Bird".
   * <p>
   * <b>fish </b> This creates an instance of the JLabel class with the name "Fish".
   * <p>
   * <b>reptiles </b> This creates an instance of the JLabel class with the name "Reptile".
   * <p>
   * <b>amphibians </b> This creates an instance of the JLabel class with the name "Amphibian".
   * <p>
   * <b>invertebrates </b> This creates an instance of the JLabel class with the name "Invertebrate".
   */
  public void drawBackground()
  {
    ImageIcon blackLine = new ImageIcon("BlackLine.jpg");
    JLabel blackLabel;
    Font big = new Font("Courier", Font.BOLD,16);
    Font small = new Font("Courier", Font.BOLD,14);
    Font title = new Font ("Plantagenet Cherokee", Font.BOLD, 60);
    JLabel titleLabel = new JLabel("Classify the Animal");
    JLabel mammals = new JLabel("Mammal");
    JLabel birds = new JLabel("Bird");
    JLabel fish = new JLabel("Fish");
    JLabel reptiles = new JLabel("Reptile");
    JLabel amphibians = new JLabel("Amphibian");
    JLabel invertebrates = new JLabel("Invertebrate");
    
    done = false;
    panel.setBackground(Color.YELLOW);
    panel.setLayout (new BorderLayout());
    blackLabel = new JLabel(blackLine)
    {
      public void paintComponent (Graphics g) 
      {
        for (int r = 0; r < 819; r+= 116)
        {
          g.drawImage (blackLine.getImage(), 102+r, 92, 5, 381, null);
          repaint();
        }
        for (int c = 0; c < 379; c+=63)
        {
          g.drawImage (blackLine.getImage(), 102, 92+c, 814, 3, null);
          repaint();
        }
      }
    };
    panel.add(blackLabel);
    frame.revalidate();
    frame.repaint();
    panel.setLayout(null);
    panel.add(titleLabel);
    titleLabel.setFont(title);
    titleLabel.setBounds(150, 25, 724, 70);
    frame.revalidate();
    frame.repaint();
    
    panel.add(mammals);
    panel.add(birds);
    panel.add(fish);
    panel.add(reptiles);
    panel.add(amphibians);
    panel.add(invertebrates);
    
    mammals.setFont(big);
    birds.setFont(big);
    fish.setFont(big);
    reptiles.setFont(big);
    amphibians.setFont(big);
    invertebrates.setFont(small);
    
    mammals.setBounds (248, 76, 100, 100);
    birds.setBounds (372, 76, 100, 100);
    fish.setBounds (492, 76, 100, 100);
    reptiles.setBounds (592,76, 100, 100);
    amphibians.setBounds (699, 76, 100, 100);
    invertebrates.setBounds (810, 76, 100, 100);
    
    frame.revalidate();
    frame.repaint();
  }
  
  /** This is the drawAnimals() method, which draws the animals in
    * the chart. There are 5 possible groups of 5 animals that can be
    * drawn. The group is randomly chosen. The animal ImageIcons are
    * drawn onto the frame using the drawImage() method.
    * <b>Local variables: </b>
    * <p>
    * <b>bat </b> This creates an instance of the ImageIcon class for the bat.
    * <p>
    * <b>eagle </b> This creates an instance of the ImageIcon class for the eagle.
    * <p>
    * <b>snake </b> This creates an instance of the ImageIcon class for the snake.
    * <p>
    * <b>frog </b> This creates an instance of the ImageIcon class for the frog.
    * <p>
    * <b>shark </b> This creates an instance of the ImageIcon class for the shark.
    * <p>
    * <b>parrot </b> This creates an instance of the ImageIcon class for the parrot.
    * <p>
    * <b>elephant </b> This creates an instance of the ImageIcon class for the elephant.
    * <p>
    * <b>butterfly </b> This creates an instance of the ImageIcon class for the butterfly.
    * <p>
    * <b>crocodile </b> This creates an instance of the ImageIcon class for the crocodile.
    * <p>
    * <b>goldfish </b> This creates an instance of the ImageIcon class for the goldfish.
    * <p>
    * <b>owl </b> This creates an instance of the ImageIcon class for the owl.
    * <p>
    * <b>pig </b> This creates an instance of the ImageIcon class for the pig.
    * <p>
    * <b>turtle </b> This creates an instance of the ImageIcon class for the turtle.
    * <p>
    * <b>worm </b> This creates an instance of the ImageIcon class for the worm.
    * <p>
    * <b>salamander </b> This creates an instance of the ImageIcon class for the salamander.
    * <p>
    * <b>tiger </b> This creates an instance of the ImageIcon class for the tiger.
    * <p>
    * <b>lizard </b> This creates an instance of the ImageIcon class for the lizard.
    * <p>
    * <b>swordfish </b> This creates an instance of the ImageIcon class for the swordfish.
    * <p>
    * <b>peacock </b> This creates an instance of the ImageIcon class for the peacock.
    * <p>
    * <b>spider </b> This creates an instance of the ImageIcon class for the spider.
    * <p>
    * <b>zebra </b> This creates an instance of the ImageIcon class for the zebra.
    * <p>
    * <b>chameleon </b> This creates an instance of the ImageIcon class for the chameleon.
    * <p>
    * <b>clownfish </b> This creates an instance of the ImageIcon class for the clownfish.
    * <p>
    * <b>ladybug </b> This creates an instance of the ImageIcon class for the ladybug.
    * <p>
    * <b>penguin </b> This creates an instance of the ImageIcon class for the penguin.
    * <p>
    * <b>batLabel </b> This creates an instance of the JLabel class for the bat.
    * <p>
    * <b>eagleLabel </b> This creates an instance of the JLabel class for the eagle.
    * <p>
    * <b>snakeLabel </b> This creates an instance of the JLabel class for the snake.
    * <p>
    * <b>frogLabel </b> This creates an instance of the JLabel class for the frog.
    * <p>
    * <b>sharkLabel </b> This creates an instance of the JLabel class for the shark.
    * <p>
    * <b>parrotLabel </b> This creates an instance of the JLabel class for the parrot.
    * <p>
    * <b>elephantLabel </b> This creates an instance of the JLabel class for the elephant.
    * <p>
    * <b>butterflyLabel </b> This creates an instance of the JLabel class for the butterfly.
    * <p>
    * <b>crocodileLabel </b> This creates an instance of the JLabel class for the crocodile.
    * <p>
    * <b>goldfishLabel </b> This creates an instance of the JLabel class for the goldfish.
    * <p>
    * <b>owlLabel </b> This creates an instance of the JLabel class for the owl.
    * <p>
    * <b>pigLabel </b> This creates an instance of the JLabel class for the pig.
    * <p>
    * <b>turtleLabel </b> This creates an instance of the JLabel class for the turtle.
    * <p>
    * <b>wormLabel </b> This creates an instance of the JLabel class for the worm.
    * <p>
    * <b>salamanderLabel </b> This creates an instance of the JLabel class for the salamander.
    * <p>
    * <b>tigerLabel </b> This creates an instance of the JLabel class for the tiger.
    * <p>
    * <b>lizardLabel </b> This creates an instance of the JLabel class for the lizard.
    * <p>
    * <b>swordfishLabel </b> This creates an instance of the JLabel class for the swordfish.
    * <p>
    * <b>peacockLabel </b> This creates an instance of the JLabel class for the peacock.
    * <p>
    * <b>spiderLabel </b> This creates an instance of the JLabel class for the spider.
    * <p>
    * <b>zebraLabel </b> This creates an instance of the JLabel class for the zebra.
    * <p>
    * <b>chameleonLabel </b> This creates an instance of the JLabel class for the chameleon.
    * <p>
    * <b>clownfishLabel </b> This creates an instance of the JLabel class for the clownfish.
    * <p>
    * <b>ladybugLabel </b> This creates an instance of the JLabel class for the ladybug.
    * <p>
    * <b>penguinLabel </b> This creates an instance of the JLabel class for the penguin.
    * <p>
    * <b>rand </b> This creates an instance of the Random class.
    * <p>
    * <b>x </b> This stores the number that is randomly generated from 0-4.
    */
  public void drawAnimals()
  {
    ImageIcon bat = new ImageIcon("Bat.png");
    ImageIcon eagle = new ImageIcon("Eagle.png");
    ImageIcon snake = new ImageIcon("Snake.png");
    ImageIcon frog = new ImageIcon("Frog.png");
    ImageIcon shark = new ImageIcon("Shark.png");
    ImageIcon parrot = new ImageIcon("Parrot.png");
    ImageIcon elephant = new ImageIcon("Elephant.png");
    ImageIcon butterfly = new ImageIcon("Butterfly.png");
    ImageIcon crocodile = new ImageIcon("Crocodile.png"); 
    ImageIcon goldfish = new ImageIcon("Goldfish.png"); 
    ImageIcon owl = new ImageIcon("Owl.png"); 
    ImageIcon pig = new ImageIcon("Pig.png"); 
    ImageIcon turtle = new ImageIcon("Turtle.png");
    ImageIcon worm = new ImageIcon("Worm.png");
    ImageIcon salamander = new ImageIcon("Salamander.png");
    ImageIcon tiger = new ImageIcon("Tiger.png");
    ImageIcon lizard = new ImageIcon("Lizard.png");
    ImageIcon swordfish = new ImageIcon("Swordfish.png");
    ImageIcon peacock = new ImageIcon("Peacock.png");
    ImageIcon spider = new ImageIcon("Spider.png");
    ImageIcon zebra = new ImageIcon("Zebra.png");
    ImageIcon chameleon = new ImageIcon("Chameleon.png");
    ImageIcon clownfish = new ImageIcon("Clownfish.png");
    ImageIcon ladybug = new ImageIcon("Ladybug.png");
    ImageIcon penguin = new ImageIcon("Penguin.png");
    JLabel batLabel, snakeLabel, eagleLabel, frogLabel, sharkLabel;
    JLabel parrotLabel, elephantLabel, butterflyLabel, crocodileLabel, goldfishLabel;
    JLabel owlLabel, pigLabel, turtleLabel, wormLabel, salamanderLabel;
    JLabel tigerLabel, lizardLabel, swordfishLabel, peacockLabel, spiderLabel;
    JLabel zebraLabel, chameleonLabel, clownfishLabel, ladybugLabel, penguinLabel;
    Random rand = new Random ();
    int x = rand.nextInt(5);
    panel.setLayout (new BorderLayout());
    if (x==0)
    {
      correct1="mammal";
      correct2="bird";
      correct3="reptile";
      correct4="amphibian";
      correct5="fish";
      isAnim1 = true;
      batLabel = new JLabel(bat) //mammal
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (bat.getImage(), 124, 157, 80,60, null);
          repaint();
        }
      };
      panel.add(batLabel);
      frame.revalidate();
      frame.repaint();
      
      eagleLabel = new JLabel(eagle) //bird
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (eagle.getImage(), 124, 220, 80,60, null);
          repaint();
        }
      };
      panel.add(eagleLabel);
      frame.revalidate();
      frame.repaint();
      
      snakeLabel = new JLabel(snake) //reptile
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (snake.getImage(), 124, 284, 77,58, null);
          repaint();
        }
      };
      panel.add(snakeLabel);
      frame.revalidate();
      frame.repaint();
      
      frogLabel = new JLabel(frog) //amphibian
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (frog.getImage(), 124, 348, 77,58, null);
          repaint();
        }
      };
      panel.add(frogLabel);
      frame.revalidate();
      frame.repaint();
      
      sharkLabel = new JLabel(shark) //fish
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (shark.getImage(), 124, 410, 77,58, null);
          repaint();
        }
      };
      panel.add(sharkLabel);
      frame.revalidate();
      frame.repaint();
    }
    else if (x==1)
    {
      correct1="bird";
      correct2="mammal";
      correct3="invertebrate";
      correct4="reptile";
      correct5="fish";
      isAnim2 = true;
      parrotLabel = new JLabel(parrot) //bird
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (parrot.getImage(), 124, 157, 80,60, null);
          repaint();
        }
      };
      panel.add(parrotLabel);
      frame.revalidate();
      frame.repaint();
      
      elephantLabel = new JLabel(elephant) //mammal
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (elephant.getImage(), 124, 220, 80,60, null);
          repaint();
        }
      };
      panel.add(elephantLabel);
      frame.revalidate();
      frame.repaint();
      
      butterflyLabel = new JLabel(butterfly) //invertebrate
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (butterfly.getImage(), 124, 284, 77,58, null);
          repaint();
        }
      };
      panel.add(butterflyLabel);
      frame.revalidate();
      frame.repaint();
      
      crocodileLabel = new JLabel(crocodile) //reptile
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (crocodile.getImage(), 114, 338, 97,78, null);
          repaint();
        }
      };
      panel.add(crocodileLabel);
      frame.revalidate();
      frame.repaint();
      
      goldfishLabel = new JLabel(goldfish) //fish
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (goldfish.getImage(), 124, 411, 77,58, null);
          repaint();
        }
      };
      panel.add(goldfishLabel);
      frame.revalidate();
      frame.repaint();
    }
    else if (x==2)
    {
      correct1="bird";
      correct2="mammal";
      correct3="reptile";
      correct4="invertebrate";
      correct5="amphibian";
      isAnim3 = true;
      owlLabel = new JLabel(owl) //bird
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (owl.getImage(), 134, 157, 60,60, null);
          repaint();
        }
      };
      panel.add(owlLabel);
      frame.revalidate();
      frame.repaint();
      
      pigLabel = new JLabel(pig) //mammal
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (pig.getImage(), 125, 220, 80,60, null);
          repaint();
        }
      };
      panel.add(pigLabel);
      frame.revalidate();
      frame.repaint();
      
      turtleLabel = new JLabel(turtle) //reptile
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (turtle.getImage(), 124, 284, 77,58, null);
          repaint();
        }
      };
      panel.add(turtleLabel);
      frame.revalidate();
      frame.repaint();
      
      wormLabel = new JLabel(worm) //invertebrate
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (worm.getImage(), 116, 347, 80,59, null);
          repaint();
        }
      };
      panel.add(wormLabel);
      frame.revalidate();
      frame.repaint();
      
      salamanderLabel = new JLabel(salamander) //amphibian
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (salamander.getImage(), 22, 334, 280,210, null);
          repaint();
        }
      };
      panel.add(salamanderLabel);
      frame.revalidate();
      frame.repaint();
    }
    else if (x==3)
    {
      correct1="mammal";
      correct2="reptile";
      correct3="fish";
      correct4="bird";
      correct5="invertebrate";
      isAnim4 = true;
      tigerLabel = new JLabel(tiger) //mammal
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (tiger.getImage(), 134, 157, 60,60, null);
          repaint();
        }
      };
      panel.add(tigerLabel);
      frame.revalidate();
      frame.repaint();
      
      lizardLabel = new JLabel(lizard) //reptile
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (lizard.getImage(), 125, 220, 80,60, null);
          repaint();
        }
      };
      panel.add(lizardLabel);
      frame.revalidate();
      frame.repaint();
      
      swordfishLabel = new JLabel(swordfish) //fish
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (swordfish.getImage(), 124, 284, 77,58, null);
          repaint();
        }
      };
      panel.add(swordfishLabel);
      frame.revalidate();
      frame.repaint();
      
      peacockLabel = new JLabel(peacock) //bird
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (peacock.getImage(), 116, 347, 80,59, null);
          repaint();
        }
      };
      panel.add(peacockLabel);
      frame.revalidate();
      frame.repaint();
      
      spiderLabel = new JLabel(spider) //invertebrate
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (spider.getImage(), 124, 411, 80,60, null);
          repaint();
        }
      };
      panel.add(spiderLabel);
      frame.revalidate();
      frame.repaint();
    }
    else
    {
      correct1="mammal";
      correct2="reptile";
      correct3="fish";
      correct4="invertebrate";
      correct5="bird";
      isAnim5 = true;
      zebraLabel = new JLabel(zebra) //mammal
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (zebra.getImage(), 134, 157, 60,60, null);
          repaint();
        }
      };
      panel.add(zebraLabel);
      frame.revalidate();
      frame.repaint();
      
      chameleonLabel = new JLabel(chameleon) //reptile
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (chameleon.getImage(), 125, 222, 80,56, null);
          repaint();
        }
      };
      panel.add(chameleonLabel);
      frame.revalidate();
      frame.repaint();
      
      clownfishLabel = new JLabel(clownfish) //fish
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (clownfish.getImage(), 124, 284, 77,58, null);
          repaint();
        }
      };
      panel.add(clownfishLabel);
      frame.revalidate();
      frame.repaint();
      
      ladybugLabel = new JLabel(ladybug) //invertebrate
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (ladybug.getImage(), 124, 347, 80,60, null);
          repaint();
        }
      };
      panel.add(ladybugLabel);
      frame.revalidate();
      frame.repaint();
      
      penguinLabel = new JLabel(penguin) //bird
      {
        public void paintComponent (Graphics g) 
        {
          g.drawImage (penguin.getImage(), 124, 411, 77,58, null);
          repaint();
        }
      };
      panel.add(penguinLabel);
      frame.revalidate();
      frame.repaint();
    }
  }
  
  /** The guessAnswer() method allows the user to play the game, and
    * tells them their score afterwards. First, using a MouseListener,
    * the program allows the user to make their guesses for how they
    * believe each animal should be classified. Whenever they make a 
    * guess, the square turns orange using a JLabel to let them know
    * that they have selected that square. The run button located at
    * the bottom of the screen is disabled until they have tried to
    * guess the answer for at least one animal. When they click on a 
    * square in the chart, the animal that they have chosen is assigned
    * to a variable, as well as the x value of the left side of the box.
    * Once they have clicked the run button at the bottom of the screen,
    * the squares that they have correctly chosen are turned green, and
    * the squares that they have guessed wrong are turned red using 
    * JLabels. Their score is then determined. Each correct animal is 
    * worth 40 points, with a total possible score of 200 points. Their
    * score is displayed at the bottom of the screen. If they have a 
    * score of 200, the congratulatory message will appear. If they have
    * a score less than 200, however, the losing message will appear, and
    * they will be returned back to the main menu.
    * <b>Local variables: </b>
    * <p>
    * <b>run </b> This creates an instance of the JButton class for the run button.
    * <p>
    * <b>orange </b> This creates an instance of the ImageIcon class for the orange image that appears when they click a box. 
    * <p>
    * <b>green </b> This creates an instance of the ImageIcon class for the green image that appears when they have guessed correctly.
    * <p>
    * <b>red </b> This creates an instance of the ImageIcon class for the red image that appears when they have guessed wrong.
    * <p>
    * <b>greenLabel1 </b> This creates an instance of the JLabel class for the green image that appears when they have guessed the first animal correctly.
    * <p>
    * <b>greenLabel2 </b> This creates an instance of the JLabel class for the green image that appears when they have guessed the second animal correctly.
    * <p>
    * <b>greenLabel3 </b> This creates an instance of the JLabel class for the green image that appears when they have guessed the third animal correctly.
    * <p>
    * <b>greenLabel4 </b> This creates an instance of the JLabel class for the green image that appears when they have guessed the fourth animal correctly.
    * <p>
    * <b>greenLabel5 </b> This creates an instance of the JLabel class for the green image that appears when they have guessed the fifth animal correctly.
    * <p>
    * <b>redLabel1 </b> This creates an instance of the JLabel class for the red image that appears when they have guessed the first animal wrong.
    * <p>
    * <b>redLabel2 </b> This creates an instance of the JLabel class for the red image that appears when they have guessed the second animal wrong.
    * <p>
    * <b>redLabel3 </b> This creates an instance of the JLabel class for the red image that appears when they have guessed the third animal wrong.
    * <p>
    * <b>redLabel4 </b> This creates an instance of the JLabel class for the red image that appears when they have guessed the fourth animal wrong.
    * <p>
    * <b>redLabel5 </b> This creates an instance of the JLabel class for the red image that appears when they have guessed the fifth animal wrong.
    * <p>
    * <b>orangeLabel1 </b> This creates an instance of the JLabel class for the orange image that appears when they make a guess.
    * <p>
    * <b>orangeLabel2 </b> This creates an instance of the JLabel class for the orange image that appears when they make a guess.
    * <p>
    * <b>orangeLabel3 </b> This creates an instance of the JLabel class for the orange image that appears when they make a guess.
    * <p>
    * <b>orangeLabel4 </b> This creates an instance of the JLabel class for the orange image that appears when they make a guess.
    * <p>
    * <b>orangeLabel5 </b> This creates an instance of the JLabel class for the orange image that appears when they make a guess.
    */
  public void guessAnswer()
  {
    JButton run = new JButton("Run"); 
    ImageIcon orange = new ImageIcon("Orange.jpg");
    ImageIcon green = new ImageIcon ("GreenBackground.gif");
    ImageIcon red = new ImageIcon ("RedBackground.jpg");
    JLabel greenLabel1, greenLabel2, greenLabel3, greenLabel4, greenLabel5;
    JLabel redLabel1, redLabel2, redLabel3, redLabel4, redLabel5;
    JLabel orangeLabel1, orangeLabel2, orangeLabel3, orangeLabel4, orangeLabel5;
    
    orangeLabel1 = new JLabel (orange);
    orangeLabel2 = new JLabel (orange);
    orangeLabel3 = new JLabel (orange);
    orangeLabel4 = new JLabel (orange);
    orangeLabel5 = new JLabel (orange);
    xVal1 = -200;
    xVal2 = -200;
    xVal3 = -200;
    xVal4 = -200;
    xVal5 = -200;
    
    run.setEnabled(false);   
    panel.addMouseListener(new MouseAdapter() 
                             {
      public void mouseClicked(MouseEvent e) 
      {
        if (!disableRun)
        {
          run.setEnabled(true);
        }
        else
        {
          run.setEnabled(false);
        }
        
        if (e.getY()>=182&& e.getY()<=241)
        {
          yVal1 = 158;
          if(e.getX()>=223&&e.getX()<=334)
          {
            animal1="mammal";
            xVal1 = 223;
          }
          else if(e.getX()>=339&&e.getX()<=450)
          {
            animal1="bird";
            xVal1 = 339;
          }
          else if(e.getX()>=455&&e.getX()<=566)
          {
            animal1="fish";
            xVal1 = 455;
          }
          else if(e.getX()>=571&&e.getX()<=682)
          {
            animal1="reptile";
            xVal1 = 571;
          }
          else if(e.getX()>=687&&e.getX()<=798)
          {
            animal1="amphibian";
            xVal1 = 687;
          }
          else if(e.getX()>=803&&e.getX()<=914)
          {
            animal1="invertebrate";
            xVal1 = 803;
          } 
          else
          {
            animal1=null;
          }
          orangeLabel1.setBounds(xVal1, yVal1, 111, 62);                
        }
        else if(e.getY()>=245&&e.getY()<=304)
        {
          yVal2 = 220;
          if(e.getX()>=223&&e.getX()<=334)
          {
            animal2="mammal";
            xVal2 = 223;
          }
          else if(e.getX()>=339&&e.getX()<=450)
          {
            animal2="bird";
            xVal2 = 339;
          }
          else if(e.getX()>=455&&e.getX()<=566)
          {
            animal2="fish";
            xVal2 = 455;
          }
          else if(e.getX()>=571&&e.getX()<=682)
          {
            animal2="reptile";
            xVal2 = 571;
          }
          else if(e.getX()>=687&&e.getX()<=798)
          {
            animal2="amphibian";
            xVal2 = 687;
          }
          else if(e.getX()>=803&&e.getX()<=914)
          {
            animal2="invertebrate";
            xVal2 = 803;
          }
          else 
          {
            animal2=null;
          }
          orangeLabel2.setBounds(xVal2, yVal2, 111, 62);                
        }
        else if(e.getY()>=308&&e.getY()<=367)
        {
          yVal3 = 282;
          if(e.getX()>=223&&e.getX()<=334)
          {
            animal3="mammal";
            xVal3 = 223;
          }
          else if(e.getX()>=339&&e.getX()<=450)
          {
            animal3="bird";
            xVal3 = 339;
          }
          else if(e.getX()>=455&&e.getX()<=566)
          {
            animal3="fish";
            xVal3 = 455;
          }
          else if(e.getX()>=571&&e.getX()<=682)
          {
            animal3="reptile";
            xVal3 = 571;
          }
          else if(e.getX()>=687&&e.getX()<=798)
          {
            animal3="amphibian";
            xVal3 = 687;
          }
          else if(e.getX()>=803&&e.getX()<=914)
          {
            animal3="invertebrate";
            xVal3 = 803;
          }
          else 
          {
            animal3=null;
          }
          orangeLabel3.setBounds(xVal3, yVal3, 111, 62);                
        }
        else if(e.getY()>=371&&e.getY()<=430)
        {
          yVal4 = 345;
          if(e.getX()>=223&&e.getX()<=334)
          {
            animal4="mammal";
            xVal4 = 223;
          }
          else if(e.getX()>=339&&e.getX()<=450)
          {
            animal4="bird";
            xVal4 = 339;
          }
          else if(e.getX()>=455&&e.getX()<=566)
          {
            animal4="fish";
            xVal4 = 455;
          }
          else if(e.getX()>=571&&e.getX()<=682)
          {
            animal4="reptile";
            xVal4 = 571;
          }
          else if(e.getX()>=687&&e.getX()<=798)
          {
            animal4="amphibian";
            xVal4 = 687;
          }
          else if(e.getX()>=803&&e.getX()<=914)
          {
            animal4="invertebrate";
            xVal4 = 803;
          }
          else 
          {
            animal4=null;
          }
          orangeLabel4.setBounds(xVal4, yVal4, 111, 62);                
        }
        else if(e.getY()>=434&&e.getY()<=493)
        {
          yVal5 = 408;
          if(e.getX()>=223&&e.getX()<=334)
          {
            animal5="mammal";
            xVal5 = 223;
          }
          else if(e.getX()>=339&&e.getX()<=450)
          {
            animal5="bird";
            xVal5 = 339;
          }
          else if(e.getX()>=455&&e.getX()<=566)
          {
            animal5="fish";
            xVal5 = 455;
          }
          else if(e.getX()>=571&&e.getX()<=682)
          {
            animal5="reptile";
            xVal5 = 571;
          }
          else if(e.getX()>=687&&e.getX()<=798)
          {
            animal5="amphibian";
            xVal5 = 687;
          }
          else if(e.getX()>=803&&e.getX()<=914)
          {
            animal5="invertebrate";
            xVal5 = 803;
          }
          else 
          {
            animal5=null;
          }
          orangeLabel5.setBounds(xVal5, yVal5, 111, 62);                
        }
      }        
    });
    panel.add(orangeLabel1); 
    panel.add(orangeLabel2);
    panel.add(orangeLabel3);
    panel.add(orangeLabel4);
    panel.add(orangeLabel5);
    frame.revalidate();
    frame.repaint();
    
    
    greenLabel1 = new JLabel (green);
    greenLabel2 = new JLabel (green);
    greenLabel3 = new JLabel (green);
    greenLabel4 = new JLabel (green);
    greenLabel5 = new JLabel (green);
    
    redLabel1 = new JLabel (red);
    redLabel2 = new JLabel (red);
    redLabel3 = new JLabel (red);
    redLabel4 = new JLabel (red);
    redLabel5 = new JLabel (red);
    score = 0;
    run.addActionListener(new ActionListener() 
                            { 
      public void actionPerformed(ActionEvent ae) 
      {
        run.setEnabled(false);
        disableRun = true;
        if (animal1 == null)
        {
          animal1="Null";
          xVal1 = -100;
          yVal1 = -100;
        }
        if (animal2 == null)
        {
          animal2="Null";
          xVal2 = -100;
          yVal2 = -100;
        }
        if (animal3 == null)
        {
          animal3="Null";
          xVal3 = -100;
          yVal3 = -100;
        }
        if (animal4 == null)
        {
          animal4="Null";
          xVal4 = -100;
          yVal4 = -100;
        }
        if (animal5 == null)
        {
          animal5="Null";
          xVal5 = -100;
          yVal5 = -100;
        }
        if (isAnim1)
        {
          if (animal1.equals(correct1))
          {
            score+= 40;
            greenLabel1.setBounds(223, 158, 111, 62); // mammal
            panel.remove(orangeLabel1);
            panel.add(greenLabel1);
            frame.revalidate();
            frame.repaint();
          }
          if (animal2.equals(correct2))
          {
            score+= 40;
            greenLabel2.setBounds(339, 220, 111, 62); // bird
            panel.remove(orangeLabel2);
            panel.add(greenLabel2);
            frame.revalidate();
            frame.repaint();
          }
          if (animal3.equals(correct3))
          {
            score+= 40;
            greenLabel3.setBounds(571, 282, 111, 62); // reptile
            panel.remove(orangeLabel3);
            panel.add(greenLabel3);
            frame.revalidate();
            frame.repaint();
          }
          if (animal4.equals(correct4))
          {
            score+= 40;
            greenLabel4.setBounds(687, 345, 111, 62); // amphibian
            panel.remove(orangeLabel4);
            panel.add(greenLabel4);
            frame.revalidate();
            frame.repaint();
          }
          if (animal5.equals(correct5))
          {
            score+= 40;
            greenLabel5.setBounds(455, 408, 111, 62); // fish
            panel.remove(orangeLabel5);
            panel.add(greenLabel5);
            frame.revalidate();
            frame.repaint();
          }
        }
        else if (isAnim2)
        {
          if (animal1.equals(correct1))
          {
            score+= 40;
            greenLabel1.setBounds(339, 158, 111, 62); // bird
            panel.remove(orangeLabel1);
            panel.add(greenLabel1);
            frame.revalidate();
            frame.repaint();
          }
          if (animal2.equals(correct2))
          {
            score+= 40;
            greenLabel2.setBounds(223, 220, 111, 62); // mammal
            panel.remove(orangeLabel2);
            panel.add(greenLabel2);
            frame.revalidate();
            frame.repaint();
          }
          if (animal3.equals(correct3))
          {
            score+= 40;
            greenLabel3.setBounds(803, 282, 111, 62); // invertebrate
            panel.remove(orangeLabel3);
            panel.add(greenLabel3);
            frame.revalidate();
            frame.repaint();
          }
          if (animal4.equals(correct4))
          {
            score+= 40;
            greenLabel4.setBounds(571, 345, 111, 62); // reptile
            panel.remove(orangeLabel4);
            panel.add(greenLabel4);
            frame.revalidate();
            frame.repaint();
          }
          if (animal5.equals(correct5))
          {
            score+= 40;
            greenLabel5.setBounds(455, 408, 111, 62); // fish
            panel.remove(orangeLabel5);
            panel.add(greenLabel5);
            frame.revalidate();
            frame.repaint();
          }
        }
        else if (isAnim3)
        {
          if (animal1.equals(correct1))
          {
            score+= 40;
            greenLabel1.setBounds(339, 158, 111, 62); // bird
            panel.remove(orangeLabel1);
            panel.add(greenLabel1);
            frame.revalidate();
            frame.repaint();
          }
          if (animal2.equals(correct2))
          {
            score+= 40;
            greenLabel2.setBounds(223, 220, 111, 62); // mammal
            panel.remove(orangeLabel2);
            panel.add(greenLabel2);
            frame.revalidate();
            frame.repaint();
          }
          if (animal3.equals(correct3))
          {
            score+= 40;
            greenLabel3.setBounds(571, 282, 111, 62); // reptile
            panel.remove(orangeLabel3);
            panel.add(greenLabel3);
            frame.revalidate();
            frame.repaint();
          }
          if (animal4.equals(correct4))
          {
            score+= 40;
            greenLabel4.setBounds(803, 345, 111, 62); // invertebrate
            panel.remove(orangeLabel4);
            panel.add(greenLabel4);
            frame.revalidate();
            frame.repaint();
          }
          if (animal5.equals(correct5))
          {
            score+= 40;
            greenLabel5.setBounds(687, 408, 111, 62); // amphibian
            panel.remove(orangeLabel5);
            panel.add(greenLabel5);
            frame.revalidate();
            frame.repaint();
          }
        }
        else if (isAnim4)
        {
          if (animal1.equals(correct1))
          {
            score+= 40;
            greenLabel1.setBounds(223, 158, 111, 62); // mammal
            panel.remove(orangeLabel1);
            panel.add(greenLabel1);
            frame.revalidate();
            frame.repaint();
          }
          if (animal2.equals(correct2))
          {
            score+= 40;
            greenLabel2.setBounds(571, 220, 111, 62); // reptile
            panel.remove(orangeLabel2);
            panel.add(greenLabel2);
            frame.revalidate();
            frame.repaint();
          }
          if (animal3.equals(correct3))
          {
            score+= 40;
            greenLabel3.setBounds(455, 282, 111, 62); // fish
            panel.remove(orangeLabel3);
            panel.add(greenLabel3);
            frame.revalidate();
            frame.repaint();
          }
          if (animal4.equals(correct4))
          {
            score+= 40;
            greenLabel4.setBounds(339, 345, 111, 62); // bird
            panel.remove(orangeLabel4);
            panel.add(greenLabel4);
            frame.revalidate();
            frame.repaint();
          }
          if (animal5.equals(correct5))
          {
            score+= 40;
            greenLabel5.setBounds(803, 408, 111, 62); // invertebrate
            panel.remove(orangeLabel5);   
            panel.add(greenLabel5);
            frame.revalidate();
            frame.repaint();
          }
        }
        else
        {
          if (animal1.equals(correct1))
          {
            score+= 40;
            panel.remove(orangeLabel1);
            greenLabel1.setBounds(223, 158, 111, 62); // mammal
            panel.add(greenLabel1);
            frame.revalidate();
            frame.repaint();
          }
          if (animal2.equals(correct2))
          {
            score+= 40;
            panel.remove(orangeLabel2);
            greenLabel2.setBounds(571, 220, 111, 62); // reptile
            panel.add(greenLabel2);
            frame.revalidate();
            frame.repaint();
          }
          if (animal3.equals(correct3))
          {
            score+= 40;
            panel.remove(orangeLabel3);
            greenLabel3.setBounds(455, 282, 111, 62); // fish
            panel.add(greenLabel3);
            frame.revalidate();
            frame.repaint();
          }
          if (animal4.equals(correct4))
          {
            score+= 40;
            panel.remove(orangeLabel4);
            greenLabel4.setBounds(803, 345, 111, 62); // bird
            panel.add(greenLabel4);
            frame.revalidate();
            frame.repaint();
          }
          if (animal5.equals(correct5))
          {
            score+= 40;
            panel.remove(orangeLabel5);  
            greenLabel5.setBounds(339, 408, 111, 62); // invertebrate
            panel.add(greenLabel5);
            frame.revalidate();
            frame.repaint();
          }
        }
        
        if (!(animal1.equals(correct1)) && animal1 != null)
        {
          redLabel1.setBounds(xVal1, yVal1, 111, 62);
          panel.remove(orangeLabel1);
          panel.add(redLabel1);
          frame.revalidate();
          frame.repaint();
        }
        if (!(animal2.equals(correct2)) && animal2 != null)
        {
          redLabel2.setBounds(xVal2, yVal2, 111, 62);
          panel.remove(orangeLabel2);
          panel.add(redLabel2);
          frame.revalidate();
          frame.repaint();
        }
        if (!(animal3.equals(correct3)) && animal3 != null)
        {
          
          redLabel3.setBounds(xVal3, yVal3, 111, 62);
          panel.remove(orangeLabel3);
          panel.add(redLabel3);
          frame.revalidate();
          frame.repaint();
        }
        if (!(animal4.equals(correct4)) && animal4 != null)
        {
          redLabel4.setBounds(xVal4, yVal4, 111, 62);
          panel.remove(orangeLabel4);
          panel.add(redLabel4);
          frame.revalidate();
          frame.repaint();
        }
        if (!(animal5.equals(correct5)) && animal5 != null)
        {
          redLabel5.setBounds(xVal5, yVal5, 111, 62);
          panel.remove(orangeLabel5);
          panel.add(redLabel5);
          frame.revalidate();
          frame.repaint();
        }
        Font scoreFont = new Font("Plantagenet Cherokee", Font.BOLD, 20);
        JLabel scoreLabel = new JLabel ("Score: " + score);
        panel.add(scoreLabel);
        scoreLabel.setFont(scoreFont);
        scoreLabel.setBounds(102, 480, 150, 50);
        done = true;
        frame.revalidate();
        frame.repaint();
        pauseTimer = new javax.swing.Timer (1, new ActionListener()
                                              {
          public void actionPerformed (ActionEvent ae)
          {
            pauseTimer.stop();
            try
            {
              Thread.sleep(1500);
            }
            catch (InterruptedException e)
            {
            }
            frame.remove (panel);
            frame.revalidate();
            frame.repaint();
            xxClass.afterLevel();
          }
        });
        pauseTimer.start();
      }
    });
    run.setBounds(900, 500, 100, 40); 
    panel.add(run);
  }
  
  /** The getScore() method returns the level 1 game score.
    * 
    * @return score This returns the score that the user gets on the level 1 game.
    */
  public int getScore()
  {
    return score;
  }
  
  /** This is the executionGame1() method, which calls all of the 
    * methods in this class. This method is used when this class
    * is called in another class. It also creates the "Close" button,
    * and adds an ActionListener for it to close the instructions
    * panel.
    * <b>Local variables: </b>
    * <p>
    * <b>close </b> This creates an instance of the JButton class for the close button.
    */
  public void executionGame1()
  {
    JButton close = new JButton ("Close");
    
    secondInstructionsPage1();
    instructionsPaneGame.add(close);
    close.setBounds (380, 400, 154, 50);
    close.addActionListener (new ActionListener ()
                               {
      public void actionPerformed (ActionEvent ae)
      {
        frame.remove(instructionsPaneGame);
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
        drawAnimals();
        drawBackground();
        guessAnswer();
      }
    });
  }  
}

