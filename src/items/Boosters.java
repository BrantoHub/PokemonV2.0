package items;
import players.Player;
import pokemons.*;

public interface Boosters {
    void use(Player UserPlayer);
    String getName();
    int getBonus();
}
