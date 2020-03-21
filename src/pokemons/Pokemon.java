package pokemons;
import java.util.ArrayList;

public abstract class Pokemon
{
    //Field Variables for pokemons
    protected String Name;
    protected String Type;
    protected int HitPoints;
    protected String PictureLocation;
    protected ArrayList<Attacks> AttacksList;


    //Getters and setters
    public String getPictureLocation() {
        return PictureLocation;
    }

    public void setPictureLocation(String pictureLocation) {
        PictureLocation = pictureLocation;
    }

    public void setAttacksList(ArrayList<Attacks> attacksList) {
        AttacksList = attacksList;
    }

    //constructor
    public Pokemon()
    {
        HitPoints = 100;
        AttacksList = new ArrayList<Attacks>(4);
    }

    //GETTERS AND SETTERS
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getHitPoints() {
        return HitPoints;
    }

    public void setHitPoints(int hitPoints) {
        HitPoints = hitPoints;
    }

    public ArrayList<Attacks> getAttacksList() {
        return AttacksList;
    }

    //abstract method set attacks that sets different attacks for every pokemon
    public abstract void SetAttacks();
}
