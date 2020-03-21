package pokemons;

public class Genger extends Pokemon
{
    public Genger()
    {
        super();
        Name= "Genger";
        Type= "Ghost";
        PictureLocation= "Pics/Genger.png";
        SetAttacks();
    }
    @Override
    public void SetAttacks() {
        AttacksList.add(new Attacks ("Shadow Claw", 15,20, 2));
        AttacksList.add(new Attacks ("Hex", 15,20, 2));
        AttacksList.add(new Attacks ("Sucker Punch", 10,15, 4));
        AttacksList.add(new Attacks ("Lick", 8, 10, 8));

    }
}
