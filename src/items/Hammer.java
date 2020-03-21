package items;
import items.*;
import pokemons.*;

public class Hammer implements Weapons {
    private String Name = "Hammer";
    private int Damage = 45;
    @Override
    public void Use(Pokemon Opponent)
    {
        int TemporaryHP = Opponent.getHitPoints()-Damage;
        if(TemporaryHP<0)
            Opponent.setHitPoints(0);
        else
            Opponent.setHitPoints(Opponent.getHitPoints() - Damage);
    }

    @Override
    public String getName() {
        return Name;
    }
}
