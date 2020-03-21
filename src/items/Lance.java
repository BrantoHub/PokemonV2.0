package items;

import pokemons.Pokemon;

public class Lance implements Weapons {
    private int Damage = 55;
    private String Name = "Lance";

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
