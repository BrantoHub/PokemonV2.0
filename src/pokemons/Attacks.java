package pokemons;
/**
 * Attacks class generates a number of hit point every time the function getHitPoint
 * is called to make the game more fair between the user and the computer.
 * Functions are described below in detail.
  */

public class Attacks {
    //Field variables
    private String Name;
    private int PowerPoints;
    private int min;
    private int max;
    private int Damage;


    //Constructor that takes Name of attack and two numbers that a random
    //number is generated between min and max every time the function get PowerPoints is called.
    public Attacks(String PName, int Pmin, int Pmax, int PP)
    {
        Name = PName;
        min = Pmin;
        max = Pmax;
        PowerPoints= PP;

    }

    //GETTERS AND SETTERS
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    // An attack is used if the attack is not missed
    public void Use(Pokemon Opponent)
    {
        Damage = (int)(Math.random() * (max - min + 1) + min);
        int TemporaryHP = Opponent.getHitPoints()-Damage;
        if (TemporaryHP>0)
            Opponent.setHitPoints(TemporaryHP);
        else
            Opponent.setHitPoints(0);
    }
    //function that decreases the powerpoints by 1
    public void setPowerPoints()
    {
        PowerPoints-=1;
    }
    public int getPowerPoints()
    {
        return PowerPoints;
    }
    // Checks to see if an attack is not missed.
    //there is a 20% chance for every attack call to be missed
    public boolean Missed()
    {
        int chance = (int)(Math.random() * (100 - min + 1) + 1);
        if(chance >= 80)
            return true;
        else
            return false;
    }

}
