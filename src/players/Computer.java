package players;
import items.Boosters;
import items.Weapons;
import pokemons.*;

import java.sql.Statement;
import java.util.Random;

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
        if(getCurrentPokemon().getHitPoints()==0){
            Statement = getCurrentPokemon().getName() + " has fainted!";
            Switch();
        }
        // If my current pokemon's Hit Points is less than or equal to 10
        if(getCurrentPokemon().getHitPoints()<= 25 && getCurrentPokemon().getHitPoints()>= 10)
        {
            Switch();
            Statement = "Computer switched his pokemon to "+ getCurrentPokemon().getName() + ". ";
        }
        //if a booster is found
        if(BoosterIsFound() && getCurrentPokemon().getHitPoints()<100)
        {
            Boosters boosterFound = getBooster();
            boosterFound.use(this);
            Statement += getCurrentPokemon().getName()+ " Found a " + boosterFound.getName() + " and maxed its energy. ";

        }
        //If an Item is found
        if (ItemFound())
        {
            //get that item ad set button property to same text
            Weapons weaponFound= GetItem();
            weaponFound.Use(User.getCurrentPokemon());
            Statement += getCurrentPokemon().getName()+ " Found a " + weaponFound.getName() + " and used it on you! ";

        }
        // if anything else
        else
        {
            //Attack if the attack is not missed
            if(!getCurrentPokemon().getAttacksList().get(0).Missed()) {
                boolean found = false;
                Random random = new Random();
                Attacks attack = getCurrentPokemon().getAttacksList().get(random.nextInt(getCurrentPokemon().getAttacksList().size()));
                if(attack.getPowerPoints()!=0)
                    found = true;
                int counter =0;
                //if the attack's powerpoints !=0
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
