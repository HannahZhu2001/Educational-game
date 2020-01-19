import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** The Level2Game class creates the mini game for the second 
  * level. It tests the user's math skills. There are 4 math
  * questions displayed, and a JTextField for each question at 
  * the bottom. They must answer the math question in the 
  * corresponding text field, and then hit the "Run" button. If
  * their answer is correct, the box turns green. If their answer
  * is wrong, the box turns red. If they haven't chosen an answer 
  * for that question, the box turns red. For each correct answer, 
  * the user gets 40 points, for a maximum of 200 points. There is 
  * no penalty for a wrong answer. 
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>frame </b> This is the reference of the JFrame that is used throughout the game.
  * <p>
  * <b>instructionsPaneGame </b> This is the reference of the JFrame that is used throughout the game.
  * <p>
  * <b>flowPane </b> This is the reference of the JPanel class for the bottom JTextFields and button.
  * <p>
  * <b>mainPane </b> This is the reference of the JPanel class for the main panel.
  * <p>
  * <b>box </b> This is the reference of the ImageIcon that is used for the lock box.
  * <p>
  * <b>run </b> This is the reference of the JButton that is used for the "Run" button.
  * <p>
  * <b>boxLabel </b> This is the reference of the JLabel that is used for the lock box.
  * <p>
  * <b>instructionsLabel </b> This is the reference of the JLabel class for the instructions.
  * <p>
  * <b>input1 </b> This is the reference of the JTextField class for the first input.
  * <p>
  * <b>input2 </b> This is the reference of the JTextField class for the second input.
  * <p>
  * <b>input3 </b> This is the reference of the JTextField class for the third input.
  * <p>
  * <b>input4 </b> This is the reference of the JTextField class for the fourth input.
  * <p>
  * <b>input5 </b> This is the reference of the JLabel class.
  * <p>
  * <b>pauseTimer </b> This is the reference of the Timer class.
  * <p>
  * <b>xxClass </b> This creates an instance of the XtremeXscape class.
  * <p>
  * <b>questions </b> This creates an instance of the Font class for the questions.
  * <p>
  * <b>score </b> This int variable stores the user's score.
  * 
  * @author Jessica Peter
  * @version Final 06.06.17
  * Time Spent: 15 hours
  */
public class Level2Game
{
  private JFrame frame;
  private JPanel instructionsPaneGame;
  private JPanel flowPane;
  private JPanel mainPane;
  private ImageIcon box;
  private JButton run;
  private JLabel boxLabel;
  private JLabel instructionsLabel;
  private JTextField input1;
  private JTextField input2;
  private JTextField input3;
  private JTextField input4;
  private JLabel input5;
  private Timer pauseTimer;
  private XtremeXscape xxClass;
  private Font questions;
  private int score;
  
  /** The constructor of the Level1Game class passes a JFrame as a 
    * parameter, so that when this class is called in another class,
    * the game will be displayed on the same frame as the frame of
    * the other class. The constructor also creates the JPanel for 
    * the instructions as well as the main panel. It sets the layout
    * of the main panel to BorderLayout, and creates the questions'
    * font. It also initializes the xxClass variable with the passed
    * XtremeXscape instance.
    * @param frame This makes an instance of the JFrame class.
    * @param xxClass This makes an instance of the XtremeXscape class.
    */
  public Level2Game(JFrame frame, XtremeXscape xxClass)
  {
    this.xxClass = xxClass;
    this.frame = frame;
    instructionsPaneGame = new JPanel ();
    mainPane = new JPanel ();
    mainPane.setLayout (new BorderLayout ());
    questions = new Font ("Serif", Font.BOLD, 40);
  }
  
  /** The secondInstructionsPage2() method displays the second
    * set of instructions for level 2. It tells the user that
    * they have uncovered the location of the second key, and now
    * must play the game.
    */
  public void secondInstructionsPage2()
  {
    instructionsPaneGame.setLayout (null);
    instructionsPaneGame.setBackground(new Color (147, 255, 200));
    instructionsLabel = new JLabel ("<html>You have found the location of the key! It was in the safe. To continue, you must first complete this game. Answer the following 4 math questions, and then click the Run button. Once you get all 4 questions correct, you will recieve another clue that will help you escape.</html>");
    instructionsLabel.setBounds(25, 120, 984, 300);
    instructionsLabel.setFont (new Font("Serif", Font.BOLD, 30));
    instructionsPaneGame.add (instructionsLabel);
    frame.add(instructionsPaneGame);
    frame.revalidate();
    frame.repaint();
  }
  
  /** The background() method creates the background of the main panel. It sets the background,
    * and displays the questions as well as the lock box.
    * <b>Local variables: </b>
    * <p>
    * <b>q1 </b> This creates the JLabel for the first question.
    * <p>
    * <b>q2 </b> This creates the JLabel for the second question.
    * <p>
    * <b>q3 </b> This creates the JLabel for the third question.
    * <p>
    * <b>q4 </b> This creates the JLabel for the fourth question.
    * <p>
    * <b>q5 </b> This creates an empty JLabel so the other 4 questions could be formatted nicely.
    */
  public void background()
  {
    Color lightBlue = new Color (135,206,250);
    mainPane.setBackground(lightBlue);
    JLabel q1 = new JLabel ("A. 15 * 3");
    JLabel q2 = new JLabel ("B. 81 / 9");
    JLabel q3 = new JLabel ("C. 76 + 41");
    JLabel q4 = new JLabel ("D. 105 - 24");
    JLabel q5 = new JLabel ();
    
    q1.setVisible(true);
    q1.setFont(questions);
    q1.setBounds(50, 50, 300, 50);
    mainPane.add (q1);
    q2.setFont(questions);
    q2.setBounds(50, 120, 300, 50);
    mainPane.add (q2);
    q3.setFont(questions);
    q3.setBounds(50, 190, 300, 50);
    mainPane.add (q3);
    q4.setFont(questions);
    q4.setBounds(50, 260, 300, 50);
    mainPane.add (q4);
    mainPane.add(q5);
    
    frame.revalidate();
    frame.repaint();
    
    box = new ImageIcon("LockBox.png");
    boxLabel = new JLabel(box)
    {
      public void paintComponent (Graphics g) 
      {
        g.drawImage (box.getImage(), 300, -100,900, 500, null);
        repaint();
      }
    };
    mainPane.add(boxLabel);
    frame.add(mainPane);
    frame.revalidate();
    frame.repaint();
  }
  
  /** The input() method gets the user's input for the 4 questions. It sets the background to
    * a light blue shade, and then adds the JTextFields to a panel with a FlowLayout. JLabels are
    * also created to be added above the text fields. The run button is created, and the flow panel
    * is set to a BorderLayout panel. The answers are errortrapped, and the score is determined and
    * displayed.
    * <b>Local variables: </b>
    * <p>
    * <b>lightBlue </b> This creates an instance of the Color class for the light blue background.
    * <p>
    * <b>letter1 </b> This creates the JLabel for the "A".
    * <p>
    * <b>letter2 </b> This creates the JLabel for the "B".
    * <p>
    * <b>letter3 </b> This creates the JLabel for the "C".
    * <p>
    * <b>letter4 </b> This creates the JLabel for the "D".
    * <p>
    * <b>letter5 </b> This creates an empty JLabel to make formatting nicer.
    * <p>
    * <b>borderPane </b> This creates a new instance of the JPanel class.
    * <p>
    * <b>scoreFont </b> This creates an instance of the Font class for the score.
    * <p>
    * <b>scoreLabel </b> This creates an insteance of the JLabel class for the score.
    */
  public void input()
  {
    Color lightBlue = new Color (135,206,250);
    flowPane = new JPanel ();
    flowPane.setBackground(lightBlue);
    input1 = new JTextField ();
    input2 = new JTextField ();
    input3 = new JTextField ();
    input4 = new JTextField ();
    input5 = new JLabel ("SCORE GOES HERE");
    
    JLabel letter1 = new JLabel("A");
    JLabel letter2 = new JLabel("B");
    JLabel letter3 = new JLabel("C");
    JLabel letter4 = new JLabel("D");
    JLabel letter5 = new JLabel();
    
    run = new JButton("Run");
    run.setFont (new Font ("Serif", Font.PLAIN, 20));
    
    letter1.setBounds(135, 410, 30,50);
    mainPane.add (letter1);
    letter1.setFont(questions);
    letter2.setBounds(289, 410, 30, 50);
    mainPane.add (letter2);
    letter2.setFont(questions);
    letter3.setBounds(440, 410, 30, 50);
    mainPane.add (letter3);
    letter3.setFont(questions);
    letter4.setBounds(595, 410, 30, 50);
    mainPane.add (letter4);
    letter4.setFont(questions);
    mainPane.add(letter5);
    flowPane.setLayout(new FlowLayout());
    
    input1.setPreferredSize(new Dimension(150,50));
    input2.setPreferredSize(new Dimension(150,50));
    input3.setPreferredSize(new Dimension(150,50));
    input4.setPreferredSize(new Dimension(150,50));
    input5.setForeground (lightBlue);
    
    flowPane.add (input1);
    flowPane.add (input2);
    flowPane.add (input3);
    flowPane.add (input4);
    
    JPanel borderPane = new JPanel ();
    borderPane.setLayout (new BorderLayout());
    borderPane.add (flowPane, BorderLayout.SOUTH);
    borderPane.setBackground(lightBlue);
    mainPane.add(borderPane);
    
    frame.revalidate();
    frame.repaint();
    score = 0;
    
    run.addActionListener(new ActionListener() 
                            { 
      public void actionPerformed(ActionEvent ae) 
      {
        input1.setEnabled(false);
        input2.setEnabled(false);
        input3.setEnabled(false);
        input4.setEnabled(false);
        run.setEnabled(false);
        if (input1.getText().equals("45"))
        {
          input1.setBackground(Color.GREEN);
          score += 50;
        }
        else
        {
          input1.setBackground(Color.RED);
        }
        if (input2.getText().equals("9"))
        {
          input2.setBackground(Color.GREEN);
          score += 50;
        }
        else
        {
          input2.setBackground(Color.RED);
        }
        if (input3.getText().equals("117"))
        {
          input3.setBackground(Color.GREEN);
          score += 50;
        }
        else
        {
          input3.setBackground(Color.RED);
        }
        if (input4.getText().equals("81"))
        {
          input4.setBackground(Color.GREEN);
          score += 50;
        }
        else
        {
          input4.setBackground(Color.RED);     
        }
        Font scoreFont = new Font("Plantagenet Cherokee", Font.BOLD, 20); // make global
        JLabel scoreLabel = new JLabel ("Score: " + score);
        flowPane.remove(input5);
        flowPane.add(scoreLabel);
        scoreLabel.setFont(scoreFont);
        pauseTimer = new Timer (1, new ActionListener()
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
            frame.remove (mainPane);
            frame.revalidate();
            frame.repaint();
            xxClass.afterLevel();
          }
        });
        pauseTimer.start();
      }
    });
    flowPane.add(run);
    flowPane.add (input5);
    run.setPreferredSize(new Dimension(150,50));
    frame.revalidate();
    frame.repaint();
  }
  
  /** The getScore() method returns the level 2 game score.
    * 
    * @return score This returns the score that the user gets on the level 2 game.
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
  public void executeGame()
  {
    JButton close = new JButton ("Close");
    secondInstructionsPage2();
    instructionsPaneGame.add(close);
    close.setBounds (380, 400, 154, 50);
    close.addActionListener (new ActionListener ()
                               {
      public void actionPerformed (ActionEvent ae)
      {
        frame.remove(instructionsPaneGame);
        frame.revalidate();
        frame.repaint();
        background();
        input();
      }
    });
  }
}

