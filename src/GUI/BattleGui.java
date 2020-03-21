package GUI;
import items.Boosters;
import items.Weapons;
import managers.Master;
import players.Computer;
import players.Player;
import players.User;
import pokemons.Attacks;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BattleGui extends JFrame
{
    private JLabel UserPokImage, CompPokImage;
    private JButton SwitchBtn;
    private JLabel TitleLbl;
    private JButton Attack1, Attack2, Attack3, Attack4;
    private JButton Item, Booster;
    private Player user;
    private Computer computer;
    private JLabel StoryStatement;
    private JLabel UserHealthLbl, CompHealthLbl;
    private Boosters boosterFound;
    private Weapons weaponFound;


    //-------------GETTERS AND SETTERS---------------
    public Boosters getBoosterFound() {
        return boosterFound;
    }

    public void setBoosterFound(Boosters boosterFound) {
        this.boosterFound = boosterFound;
    }

    public Weapons getWeaponFound() {
        return weaponFound;
    }

    public void setWeaponFound(Weapons weaponFound) {
        this.weaponFound = weaponFound;
    }
    public Player getUser() {
        return user;
    }

    public void setUser(Player user) {
        this.user = user;
    }

    public Computer getComputer() {
        return computer;
    }
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
    //------------------------------------------------
    //------------CONSTRUCTOR-------------------------
    public BattleGui(Player PUser, Computer PComputer)
    {
        // Initialize the 2 main players on the screen
        user = PUser;
        computer = PComputer;

        //Show Gui
        CreateGui();
        CenterWindow();
        AddImages();
        AddHealthToGUI();
        AddNamesToGui();
        AddAttacks();
        AddSwitchBtn();
        AddActionListeners();
        AddStoryStatement();
        this.setVisible(true);

    }

    private void AddStoryStatement() {
        StoryStatement = new JLabel();
        StoryStatement.setForeground(Color.white);
        StoryStatement.setBackground(new Color(61, 65, 71));
        StoryStatement.setBounds(20,300,500,500);
        StoryStatement.setVisible(false);
        this.add(StoryStatement);
    }

    //------------------------------------------------
    public void AddActionListeners()
    {
        Attack1.addActionListener(new Master(this));
        Attack2.addActionListener(new Master(this));
        Attack3.addActionListener(new Master(this));
        Attack4.addActionListener(new Master(this));
        SwitchBtn.addActionListener(new Master(this));
        Item.addActionListener(new Master(this));
        Booster.addActionListener(new Master(this));
    }

    public void UpdateAttacks()
    {
        //if an attack's power point is not equal to 0
        if(user.getCurrentPokemon().getAttacksList().get(0).getPowerPoints()!=0) {
            Attack1.setText(user.getCurrentPokemon().getAttacksList().get(0).getName());
            Attack1.setVisible(true);
        }
        else
            Attack1.setVisible(false);
        if(user.getCurrentPokemon().getAttacksList().get(1).getPowerPoints()!=0) {
            Attack2.setText(user.getCurrentPokemon().getAttacksList().get(1).getName());
            Attack2.setVisible(true);
        }
        else
            Attack2.setVisible(false);
        if(user.getCurrentPokemon().getAttacksList().get(2).getPowerPoints()!=0) {
            Attack3.setText(user.getCurrentPokemon().getAttacksList().get(2).getName());
            Attack3.setVisible(true);
        }
        else
            Attack3.setVisible(false);
        if(user.getCurrentPokemon().getAttacksList().get(3).getPowerPoints()!=0) {
            Attack4.setText(user.getCurrentPokemon().getAttacksList().get(3).getName());
            Attack4.setVisible(true);
        }
        else
            Attack4.setVisible(false);
    }
    public void AddSwitchBtn()
    {
        SwitchBtn = new JButton("Switch!");
        SwitchBtn.setBackground(new Color(99, 87, 208));
        SwitchBtn.setBounds(260,385,100,30);
        this.add(SwitchBtn);
    }

    public void AddNamesToGui() {
        TitleLbl = new JLabel();
        TitleLbl.setText(user.getPlayerName()+ " Vs. Computer");
        TitleLbl.setFont(new Font("Normal", Font.BOLD, 24));
        TitleLbl.setForeground(Color.red);
        TitleLbl.setBackground(new Color(61, 65, 71));
        TitleLbl.setBounds(190,20,500,40);
        this.add(TitleLbl);
    }

    public void AddAttacks()
    {

        //-----------GETTING THE ATTACKS AND ASSIGNING THEIR NAMES TO BUTTONS-------------
        Attack1 = new JButton();
        Attack2 = new JButton();
        Attack3 = new JButton();
        Attack4 = new JButton();
        UpdateAttacks();
        //--------------------------------------------------------------------------------
        //-----------SETTING BOOSTERS AND ITEMS FOUND-------------------------------------
        Item = new JButton();
        Booster = new JButton();
        updateBoostersandItems();
        //--------------------------------------------------------------------------------
        //---------------------------INITIALIZE PANELS------------------------------------
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        //--------------------------------------------------------------------------------
        //-------------------------SET BORDERS FOR PANELS---------------------------------
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(null, "Attack",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12),
                Color.WHITE)));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(null, "Items Found",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12),
                Color.WHITE)));
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(null, "Boosters Found",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12),
                Color.WHITE)));
        //--------------------------------------------------------------------------------
        //---------------------------CREATE BOX LAYOUTS FOR PANELS------------------------

        BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        BoxLayout layout3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
        panel1.setLayout(layout1);
        panel2.setLayout(layout2);
        panel3.setLayout(layout3);
        //---------------------------------------------------------------------------------

        //------------SETTING BOUNDS AND CHARACTERISTICS OF BUTTONS-----------------------
        Booster.setAlignmentX(Component.CENTER_ALIGNMENT);
        Item.setAlignmentX(Component.CENTER_ALIGNMENT);
        Booster.setBackground(new Color(40, 168, 75));
        Item.setBackground(new Color(40, 168, 75));

        Attack1.setAlignmentX(Component.CENTER_ALIGNMENT);
        Attack2.setAlignmentX(Component.CENTER_ALIGNMENT);
        Attack3.setAlignmentX(Component.CENTER_ALIGNMENT);
        Attack4.setAlignmentX(Component.CENTER_ALIGNMENT);
        Attack1.setBackground(new Color(40, 168, 75));
        Attack2.setBackground(new Color(40, 168, 75));
        Attack3.setBackground(new Color(40, 168, 75));
        Attack4.setBackground(new Color(40, 168, 75));
        //----------------------------------------------------------------------------------
        //---------------ADDING ITEMS TO PANELS---------------------------------------------
        panel1.add(Attack1);
        panel1.add(Box.createVerticalStrut(5));
        panel1.add(Attack2);
        panel1.add(Box.createVerticalStrut(5));
        panel1.add(Attack3);
        panel1.add(Box.createVerticalStrut(5));
        panel1.add(Attack4);
        panel1.setBackground(new Color(61, 65, 71));
        panel1.setBounds(30,270,160,150);

        panel2.add(Item);
        panel3.add(Booster);
        panel2.setBackground(new Color(61, 65, 71));
        panel2.setBounds(250,270,120,60);
        panel3.setBackground(new Color(61, 65, 71));
        panel3.setBounds(450,270,120,60);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);

    }

    public void updateBoostersandItems() {

        //If an Item is found
        if (user.ItemFound())
        {

            //get that item ad set button property to same text
            weaponFound= user.GetItem();
            Item.setText(weaponFound.getName());
            Item.setVisible(true);

        }
        //if not, keep button set to invisible
        else {
            Item.setVisible(false);
            weaponFound = null;
        }
        //if a booster is found
        if(user.BoosterIsFound())
        {
            boosterFound = user.getBooster();
            Booster.setText(boosterFound.getName());
            Booster.setVisible(true);
        }
        else{
            Booster.setVisible(false);
            boosterFound=null;
        }
    }

    public void UpdateImages()
    {
        //------------------------UPDATE USER POKEMON IMAGE-----------------------------------
        ImageIcon UserPokemonPic = new ImageIcon(user.getCurrentPokemon().getPictureLocation());
        Image image = UserPokemonPic.getImage(); // transform it
        Image newimg = image.getScaledInstance(100, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        UserPokemonPic = new ImageIcon(newimg);
        UserPokImage.setIcon(UserPokemonPic);
        UserPokImage.setBounds(60,120,100,120);
        //------------------------------------------------------------------------------------

        //------------------------UPDATE COMPUTER POKEMON IMAGE-------------------------------
        ImageIcon CompPokemonPic = new ImageIcon(computer.getCurrentPokemon().getPictureLocation());
        Image image2 = CompPokemonPic.getImage(); // transform it
        Image newimg2 = image2.getScaledInstance(100, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        CompPokemonPic = new ImageIcon(newimg2);
        CompPokImage.setIcon(CompPokemonPic);
        CompPokImage.setBounds(420,120,100,120);
        //-------------------------------------------------------------------------------------
    }

    public void AddHealthToGUI()
    {

        //---------------------ADDING THE USER HEALTH---------------
        UserHealthLbl = new JLabel("Health: "+ user.getCurrentPokemon().getHitPoints());
        UserHealthLbl.setForeground(Color.white);
        UserHealthLbl.setBackground(new Color(61, 65, 71));
        UserHealthLbl.setFont(new Font("Sans Serif", Font.BOLD, 16));
        //------------------------------------------------------------

        //--------------------UPDATING THE COMPUTER HEALTH-------------
        CompHealthLbl = new JLabel("Health: "+ computer.getCurrentPokemon().getHitPoints());
        CompHealthLbl.setForeground(Color.white);
        CompHealthLbl.setBackground(new Color(61, 65, 71));
        CompHealthLbl.setFont(new Font("Sans Serif", Font.BOLD, 16));
        //-------------------------------------------------------------

        //---------------------SETTING THE BOUNDS----------------------
        UserHealthLbl.setBounds(60,90,100,20);
        CompHealthLbl.setBounds(420,90,100,20);
        //--------------------ADD LABELS TO GUI------------------------
        this.add(CompHealthLbl);
        this.add(UserHealthLbl);
        //-------------------------------------------------------------
    }

    public void UpdateHealth()
    {
        //---------------------UPDATING THE USER HEALTH---------------
        UserHealthLbl.setText("Health: "+ user.getCurrentPokemon().getHitPoints());
        //------------------------------------------------------------

        //--------------------UPDATING THE COMPUTER HEALTH-------------
        CompHealthLbl.setText("Health: "+ computer.getCurrentPokemon().getHitPoints());

        //-------------------------------------------------------------


    }

    public void AddImages()
    {
        //------------------------UPDATE USER POKEMON IMAGE-----------------------------------
        ImageIcon UserPokemonPic = new ImageIcon(user.getCurrentPokemon().getPictureLocation());
        Image image = UserPokemonPic.getImage(); // transform it
        Image newimg = image.getScaledInstance(100, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        UserPokemonPic = new ImageIcon(newimg);
        UserPokImage = new JLabel(UserPokemonPic);
        UserPokImage.setBounds(60,120,100,120);
        //------------------------------------------------------------------------------------

        //------------------------UPDATE COMPUTER POKEMON IMAGE-------------------------------
        ImageIcon CompPokemonPic = new ImageIcon(computer.getCurrentPokemon().getPictureLocation());
        Image image2 = CompPokemonPic.getImage(); // transform it
        Image newimg2 = image2.getScaledInstance(100, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        CompPokemonPic = new ImageIcon(newimg2);
        CompPokImage = new JLabel(CompPokemonPic);
        CompPokImage.setBounds(420,120,100,120);
        //-------------------------------------------------------------------------------------

        //-------------------------------ADD BOTH IMAGES TO SCREEN-----------------------------
        this.add(UserPokImage);
        this.add(CompPokImage);
        //-------------------------------------------------------------------------------------


    }

    public void CenterWindow()
    {
        //Open in middle of screen
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 3;
        int iCoordY = (objDimension.height - this.getHeight()) / 8;
        this.setLocation(iCoordX, iCoordY);
    }

    public void CreateGui()
    {
        //-------------------Look and Feel-------------------
        this.setUndecorated(false);

        //-----------------SETTING ELEMENTS OF FRAME---------

        // Setting layout as null of JFrame.
        this.setLayout(null);
        //Set Size of window
        this.setSize(600,700);
        //Changing the background color to grey
        this.getContentPane().setBackground(new Color(61, 65, 71));
        //do not allow user to resize
        this.setResizable(false);
        //set title name
        this.setTitle("Battle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //-----------------------------------------------------

        //------------------Title and Icon----------------------------
        ImageIcon icon = new ImageIcon("Pics/Ball.png");
        this.setIconImage(icon.getImage());
        //--------------------------------------------------------------


    }
    public void UpdateStatement(String Statement)
    {
        StoryStatement.setText(Statement);
        StoryStatement.setVisible(true);
    }
}
