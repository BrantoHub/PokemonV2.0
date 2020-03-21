package items;

import pokemons.Pokemon;

public class Rapier implements Weapons {
    private int Damage = 40;
    private String Name = "Rapier";

    @Override
    public void Use(Pokemon Opponent) {
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
