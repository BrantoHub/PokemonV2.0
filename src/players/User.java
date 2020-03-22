package players;
import pokemons.Pokemon;

/**
 * Player class is the class used to instantiate a user who uses all functions from the parent class, player.
 */
public class User extends Player {
    public User(String Pname, Pokemon P1, Pokemon P2) {
        super(Pname, P1, P2);
    }
}
