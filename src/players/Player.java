package players;
import items.*;
import pokemons.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Player
{
    //Fields
    protected String PlayerName;
    protected Pokemon Pokemon1;
    protected Pokemon Pokemon2;
    protected Pokemon CurrentPokemon;
    protected ArrayList<Weapons> ItemsList;
    protected ArrayList<Boosters> BoostersList;

    //GETTERS AND SETTERS
    public String getPlayerName() {
        return PlayerName;
    }

    public ArrayList<Weapons> getItemsList() {
        return ItemsList;
    }
    public Pokemon getPokemon1() {
        return Pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        Pokemon1 = pokemon1;
    }

    public Pokemon getPokemon2() {
        return Pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        Pokemon2 = pokemon2;
    }

    public Pokemon getCurrentPokemon() {
        return CurrentPokemon;
    }

    public void setCurrentPokemon(Pokemon currentPokemon) {
        CurrentPokemon = currentPokemon;
    }


    //Constructor
    public Player(String Pname, Pokemon P1, Pokemon P2)
    {
        PlayerName = Pname;
        Pokemon1 = P1;
        Pokemon2 = P2;
        CurrentPokemon = Pokemon1;
        AddItemsToArrayList();
        AddBoosterstoArrayList();
    }

    public void AddBoosterstoArrayList()
    {
        BoostersList = new ArrayList<Boosters>();
        BoostersList.add(new Water());
        BoostersList.add(new Apple());
        BoostersList.add(new CherryPepsi());
        BoostersList.add(new CrystalPepsi());
        BoostersList.add(new DietPepsi());
        BoostersList.add(new EnergyDrink());
        BoostersList.add(new OrganicDrink());
        BoostersList.add(new Pepsi());
    }

    public void AddItemsToArrayList()
    {
        ItemsList = new ArrayList<Weapons>();
        ItemsList.add(new Hammer());
        ItemsList.add(new Dagger());
        ItemsList.add(new EmptyPepsi());
        ItemsList.add(new Lance());
        ItemsList.add(new PocketKnife());
        ItemsList.add(new Rapier());
    }
    public boolean ItemFound()
    {
        boolean ItemIsFound;
        //Generate a random number between 0 and 100
        int RandomNum = (int)(Math.random() * (100 - 0 + 1) + 0);
        // There is a 25% chance that the player might find an Item after playing a hit
        if (RandomNum >75)
            ItemIsFound = true;
        else
            ItemIsFound = false;
        return ItemIsFound;
    }
    //returns a boolean value based on a random number generator that generates a number between 0 and 100
    public boolean BoosterIsFound()
    {
        boolean ItemIsFound;
        //Generate a random number between 0 and 100
        int RandomNum = (int)(Math.random() * (100 - 0 + 1) + 0);
        // There is a 25% chance that the player might find an Item after playing a hit
        if (RandomNum >80)
            ItemIsFound = true;
        else
            ItemIsFound = false;
        return ItemIsFound;
    }
    //Returns the found item
    public Boosters getBooster()
    {
        Random random = new Random();
        Boosters Booster = BoostersList.get(random.nextInt(BoostersList.size()));
        return Booster;
    }
    //function that returns a random Item from the list of Items
    public Weapons GetItem()
    {
        Random random = new Random();
        Weapons Item = ItemsList.get(random.nextInt(ItemsList.size()));
        return Item;
    }
}
