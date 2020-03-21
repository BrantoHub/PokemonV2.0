package pokemons;

public class Pikachu extends Pokemon
{
    public Pikachu()
    {
       super();
       Name= "Pikachu";
       Type= "Electric";
       PictureLocation= "Pics/Pikachu.png";
       SetAttacks();
    }
    @Override
    public void SetAttacks()
    {

        AttacksList.add(new Attacks ("Thunder Shock", 15,20, 2));
        AttacksList.add(new Attacks ("Growl", 15,20, 2));
        AttacksList.add(new Attacks ("Double Kick", 10,15, 4));
        AttacksList.add(new Attacks ("Tail Whip", 8, 10, 8));
    }
}
