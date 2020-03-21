package items;
import players.Player;
import pokemons.Pokemon;

public class Water implements Boosters {
    private String Name = "Water Bottle";
    private int Bonus = 25;

    @Override
    public void use(Player UserPlayer) {
        int TemporaryHP = UserPlayer.getCurrentPokemon().getHitPoints() + Bonus;
        if(TemporaryHP > 100)
            UserPlayer.getCurrentPokemon().setHitPoints(100);
        else
            UserPlayer.getCurrentPokemon().setHitPoints(UserPlayer.getCurrentPokemon().getHitPoints() + Bonus);
    }
    public int getBonus() {
        return Bonus;
    }

    @Override
    public String getName() {
        return Name;
    }
}
