package items;

import pokemons.Pokemon;

public class Dagger implements Weapons {
    private int Damage = 30;
    private String Name = "Dagger";

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
