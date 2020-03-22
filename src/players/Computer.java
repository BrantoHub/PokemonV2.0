package players;
import items.Boosters;
import items.Weapons;
import pokemons.*;
import java.util.Random;

/**
 * Purpose: Computer class is a child of Player and it is used to think and take decisions based on what the user does.
 * decisions are described in details in the reply function. Also, this class is associated with and called
 * from the Master class
 */

public class Computer extends Player
{
    public Computer(Pokemon P1, Pokemon P2) {
        super("Computer", P1, P2);
    }
    public void Switch()
    {
        //If my current pokemon is the same as pokemon1
        if(getCurrentPokemon().equals(Pokemon1))
        {
            // Change to pokemon2
            setCurrentPokemon(Pokemon2);
        }
        // if my current pokemon is the same as pokemon2
        else if(getCurrentPokemon().equals(Pokemon2))
        {
            // swap to pokemon1
            setCurrentPokemon(Pokemon1);
        }
    }
    public String Reply(Player User)
    {
        String Statement ="";
        //If pokemon's hit points is 0
        if(getCurrentPokemon().getHitPoints()==0){
            //Pokemon faints and event is handled in the master
            Statement = getCurrentPokemon().getName() + " has fainted! ";
            //If the other pokemon is not dead, switch pokemons.
            if(getCurrentPokemon().equals(getPokemon1()) && getPokemon2().getHitPoints()!=0 ||
                    getCurrentPokemon().equals(getPokemon2()) && getPokemon1().getHitPoints()!=0) {
                Switch();
                Statement += "Computer switched his pokemon to " + getCurrentPokemon().getName() + ". ";
            }
        }
        // If my current pokemon's Hit Points is less than or equal to 25 and not 0 and I have another alive pokemon, switch
        // to that alive pokemon
        else if(getCurrentPokemon().getHitPoints()<= 25 && getCurrentPokemon().getHitPoints()> 0 &&
                (getCurrentPokemon().equals(getPokemon1()) && getPokemon2().getHitPoints()!=0 ||
                getCurrentPokemon().equals(getPokemon2()) && getPokemon1().getHitPoints()!=0))
        {
            Switch();
            Statement = "Computer switched his pokemon to "+ getCurrentPokemon().getName() + ". ";
        }
        //if a booster is found
        if(BoosterIsFound() && getCurrentPokemon().getHitPoints()<100 && getCurrentPokemon().getHitPoints()!=0)
        {
            Boosters boosterFound = getBooster();
            boosterFound.use(this);
            Statement += getCurrentPokemon().getName()+ " Found a " + boosterFound.getName() + " and maxed its energy. ";

        }
        //If an Item is found
        if (ItemFound() && getCurrentPokemon().getHitPoints()!=0)
        {
            //get that item ad set button property to same text
            Weapons weaponFound= GetItem();
            weaponFound.Use(User.getCurrentPokemon());
            Statement += getCurrentPokemon().getName()+ " Found a " + weaponFound.getName() + " and used it on you! ";

        }
        // if none of these, play an attacki if my hitpoints are not 0
        else if(getCurrentPokemon().getHitPoints()!=0)
        {
            //Attack if the attack is not missed
            if(!getCurrentPokemon().getAttacksList().get(0).Missed()) {
                boolean found = false;
                Random random = new Random();
                Attacks attack = getCurrentPokemon().getAttacksList().get(random.nextInt(getCurrentPokemon().getAttacksList().size()));
                if(attack.getPowerPoints()!=0)
                    found = true;
                int counter =0;
                //while the attack's powerpoints =0 keep finding a random attack that I can play
                while(!found)
                {
                    Random random2 = new Random();
                    attack = getCurrentPokemon().getAttacksList().get(random.nextInt(getCurrentPokemon().getAttacksList().size()));
                    if(attack.getPowerPoints()!=0)
                        found = true;
                    else if(counter ==50)
                    {
                        //Switch pokemons if we have not found any available attacks to play
                        Switch();
                        Statement += "Computer switched his pokemon to "+ getCurrentPokemon().getName() + ". ";
                        break;
                    }
                    counter +=1;

                }
                if(found) {
                    //attack opponent
                    attack.Use(User.getCurrentPokemon());
                    //decrease the attack's powerpoints
                    attack.setPowerPoints();
                    Statement += getCurrentPokemon().getName() + " used " + attack.getName() + " on you! ";
                }
            }
            else
                Statement += getCurrentPokemon().getName() + " missed its attack on you! ";

        }
        return Statement;
    }
}
