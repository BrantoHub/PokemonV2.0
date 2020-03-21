package GUI;
import managers.Listener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LandingGui extends JFrame
{
    private JLabel title;
    private JButton BtnNext;

    //Constructor
    public LandingGui()
    {

        SetInitialGui();
        centerWindow();
        SetNext();
        SetInformation();
        //Set Size
        this.setSize(500,600);
        //SetGui to be visible
        this.setVisible(true);
    }
    public void centerWindow() {
        //Open in middle of screen
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 3;
        int iCoordY = (objDimension.height - this.getHeight()) / 8;
        this.setLocation(iCoordX, iCoordY);
    }
    // Set information displayed in the middle of the screen
    private void SetInformation()
    {
        //create a panel
        JPanel CenterPanel = new JPanel();
        //This is an HTML string that will be added in the middle of the screen
        String INFO = "<html><p>Welcome to Kareem and Kyle's version of Pokemon!</p>"+
                "<p>We are so glad that you arrived here safely after suffering from other projects..</p>"+
                "<p>Now, we know how excited you are to play our game, but trust me, you are not excited as I am because"+
                " this thing took us a lot of time! Anyway.. before we start, we would like to give you some information of how this works!"+
                "</p><ul><li>you start off with 2 pokemons of your choice and you play against the computer.</li><li> The attacks" +
                " that you use have a 25% chance of being a miss.</li> <li>there is a 25% chance for you to find an item after every hit</li>" +
                "<li> There is also a 20% chance for you to find a booster and use it to upgrade your health!</li>"+"<li> your list of attacks are associated with the pokemon that you choose. Meaning, each Pokemon has its own "+
                " attacks.</li><li>Every time you attack, the attack causes a random number of damage between a range that I have decided.</li>"+
                "<li> When your attack button disappear, means that you have used all power points for this particular attack.</li></ul>"+
                "<p> Click Next to enter your information and Choose your pokemons!</p></html>";
        //add the string to the JLabel
        JLabel LabelInfo = new JLabel(INFO);
        //Set text color to white
        LabelInfo.setForeground(Color.white);
        // set the panel's layout as box layout on one line axis
        //CenterPanel.setLayout(new BoxLayout(CenterPanel, BoxLayout.PAGE_AXIS));
        CenterPanel.setLayout(new BoxLayout(CenterPanel,BoxLayout.Y_AXIS));
        //set background color of panel to the same default color we are using
        CenterPanel.setBackground(new Color(61, 65, 71));
        //set padding for the panel
        CenterPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        // add the label to the centerPanel
        CenterPanel.add(LabelInfo);
        //add the center panel to the Center of the frame.
        this.add(CenterPanel, BorderLayout.CENTER);
    }

    //function that sets the button next
    public void SetNext()
    {
        //create a panel
        JPanel pane = new JPanel();
        // set the panel's layout as box layout on one line axis
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
        //set background color of panel to the same default color we are using
        pane.setBackground(new Color(61, 65, 71));
        //set padding for the panel
        pane.setBorder(new EmptyBorder(10, 10, 10, 10));
        //initiate button Next
        BtnNext= new JButton("Next");
        // set button background color to be green
        BtnNext.setBackground(new Color(40, 168, 75));
        // empty space to the horizontal left
        pane.add(Box.createHorizontalGlue());
        // add the button to the panel
        pane.add(BtnNext);
        //Add Action listener to Btn Next
        //----------------EventListeners-----------
        Listener action = new Listener();
        action.SendLandGui(this);
        BtnNext.addActionListener(action);
        //--------------------------------------
        // add the panel to the frame
        this.add(pane, BorderLayout.SOUTH);
        this.pack();
    }
    // function that sets initial GUI
    public void SetInitialGui()
    {
        //set Icon image
        //Image icon = Toolkit.getDefaultToolkit().getImage("../Pics/StarterLogo.png");
        ImageIcon icon = new ImageIcon("Pics/Ball.png");
        this.setIconImage(icon.getImage());
        //title Image
        ImageIcon imageIcon = new ImageIcon("Pics/pokemon_logo.png");
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(210, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        JLabel TitleImage = new JLabel(imageIcon);
        //do not allow user to resize
        this.setResizable(false);
        //set title name
        this.setTitle("Introduction");
        // set background of application
        this.getContentPane().setBackground(new Color(61, 65, 71));
        title = new JLabel("Pokemon Battle");
        Font TimesNewRoman = new Font("times new roman",Font.BOLD,25);
        title.setFont(TimesNewRoman);
        // Change text color to white
        title.setForeground(new Color(180, 0, 0));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        title.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        title.setVerticalAlignment((int) CENTER_ALIGNMENT);
        this.add(TitleImage, BorderLayout.NORTH);

    }
}
