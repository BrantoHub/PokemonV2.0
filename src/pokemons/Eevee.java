package pokemons;


public class Eevee extends Pokemon
{
    public Eevee()
    {
        super();
        Name= "Eevee";
        Type= "Normal";
        PictureLocation= "Pics/Eevee.png";
        SetAttacks();
    }
    @Override
    public void SetAttacks()
    {
        AttacksList.add(new Attacks ("Last Resort", 20,28, 2));
        AttacksList.add(new Attacks ("Bite", 15,20, 2));
        AttacksList.add(new Attacks ("Tackle", 10,15, 4));
        AttacksList.add(new Attacks ("Swift", 8, 10, 8));

    }
}
