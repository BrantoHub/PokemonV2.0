package items;

import players.Player;

public class Pepsi implements Boosters {
    private int Bonus = 50;
    private String Name = "Pepsi <3";

    @Override
    public void use(Player UserPlayer) {
        int TemporaryHP = UserPlayer.getCurrentPokemon().getHitPoints() + Bonus;
        if(TemporaryHP > 100)
            UserPlayer.getCurrentPokemon().setHitPoints(100);
        else
            UserPlayer.getCurrentPokemon().setHitPoints(UserPlayer.getCurrentPokemon().getHitPoints() + Bonus);
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public int getBonus() {
        return Bonus;
    }
}
