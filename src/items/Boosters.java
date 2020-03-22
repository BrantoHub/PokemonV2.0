package items;
import players.Player;

/**
 * Interface Boosters that is used to create children who inherit the Use function that
 * takes a parameter of the User player who increases his/her energy with the specific
 * number that is different in every booster.
 * GetName function is used to get the name of the booster and getBonus returns the amount of bonus that
 * the user has increased in his/her health. This is helpful with the documentation that is used through the Master class,
 * as it shows the user what happens behind the scenes.
 */

public interface Boosters {
    void use(Player UserPlayer);
    String getName();
    int getBonus();
}
