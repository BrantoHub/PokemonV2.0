package items;

import pokemons.Pokemon;

public class EmptyPepsi implements Weapons {
    private String Name = "EmptyPepsi";
    private int Damage = 30;
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
