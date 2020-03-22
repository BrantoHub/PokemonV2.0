package items;
import pokemons.*;

/**
 * Weapons interface that is used for all weapons created in the
 * package items. weapons are capable of damaging the enemy's pokemon that is sent to the use function.
 * getname function is used for documentation in showing the user what happened behind the scene.
 */
public interface Weapons
{
    void Use(Pokemon P);
    String getName();
}
