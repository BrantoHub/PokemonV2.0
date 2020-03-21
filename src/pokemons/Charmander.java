package pokemons;


public class Charmander extends Pokemon
{
    public Charmander()
    {
        super();
        Name= "Charmander";
        Type= "Fire";
        PictureLocation= "Pics/Charmander.png";
        SetAttacks();
    }
    @Override
    public void SetAttacks() {
        AttacksList.add(new Attacks ("Flare Blitz", 20,25, 2));
        AttacksList.add(new Attacks ("Dragon Breath", 15,23, 2));
        AttacksList.add(new Attacks ("Fire Spin", 10,15, 4));
        AttacksList.add(new Attacks ("Ember", 8, 10, 8));

    }
}
