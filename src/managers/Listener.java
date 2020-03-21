package managers;

import GUI.BattleGui;
import GUI.InformationGui;
import GUI.LandingGui;
import players.Computer;
import players.Player;
import players.User;
import pokemons.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener
{
    //Fields
    private InformationGui InfoGui;
    private String UserName;
    private LandingGui LandGui;
    private Pokemon Pokemon1;
    private Pokemon Pokemon2;
    private Pokemon CompPokemon1;
    private Pokemon CompPokemon2;
    private Player user;
    private Computer computer;
    public Listener()
    {

    }
    public void SendInfoGui(InformationGui PGui)
    {
        InfoGui = PGui;
    }
    public void SendLandGui(LandingGui pGui)
    {
        LandGui = pGui;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Start"))
        {

            UserName = InfoGui.getNameField().getText();
            Boolean ValidUserPokemons = CheckPokemons();
            if(ValidUserPokemons) {
                SetCompPokemons();
                user = new User(UserName, Pokemon1, Pokemon2);
                computer = new Computer(CompPokemon1, CompPokemon2);
                //Call the BattleGui to show up
                BattleGui BGui = new BattleGui(user, computer);
                InfoGui.dispose();

            }

        }
        if(e.getActionCommand().equals("Next"))
        {
            JFrame InfoGui = new InformationGui();
            LandGui.dispose();

        }

    }
    // This function sets the computer's pokemons to be something that is different from what the user has chosen to
    private void SetCompPokemons()
    {
        if(Pokemon1.getName()== "Pikachu" && Pokemon2.getName()=="Eevee" ||
                Pokemon1.getName()== "Eevee" && Pokemon2.getName()=="Pikachu")
        {
            CompPokemon1 = new Genger();
            CompPokemon2 = new Charmander();
        }
        else if(Pokemon1.getName()== "Pikachu" && Pokemon2.getName()=="Genger" ||
                Pokemon1.getName()== "Genger" && Pokemon2.getName()=="Pikachu")
        {
            CompPokemon1 = new Eevee();
            CompPokemon2 = new Charmander();
        }
        else if(Pokemon1.getName()== "Pikachu" && Pokemon2.getName()=="Charmander" ||
                Pokemon1.getName()== "Charmander" && Pokemon2.getName()=="Pikachu")
        {
            CompPokemon1 = new Eevee();
            CompPokemon2 = new Genger();
        }
        else if(Pokemon1.getName()== "Eevee" && Pokemon2.getName()=="Genger" ||
                Pokemon1.getName()== "Genger" && Pokemon2.getName()=="Eevee")
        {
            CompPokemon1 = new Pikachu();
            CompPokemon2 = new Charmander();
        }
        else if(Pokemon1.getName()== "Charmander" && Pokemon2.getName()=="Eevee" ||
                Pokemon1.getName()== "Eevee" && Pokemon2.getName()=="Charmander")
        {
            CompPokemon1 = new Genger();
            CompPokemon2 = new Pikachu();
        }
        else if(Pokemon1.getName()== "Charmander" && Pokemon2.getName()=="Genger" ||
                Pokemon1.getName()== "Genger" && Pokemon2.getName()=="Charmander")
        {
            CompPokemon1 = new Eevee();
            CompPokemon2 = new Pikachu();
        }
    }

    private Boolean CheckPokemons()
    {
        if(!InfoGui.getNameField().getText().equals(""))
        {
        //If user enters same pokemon show error message
            if(InfoGui.getCharmanderRadio1().isSelected() && InfoGui.getCharmanderRadio2().isSelected() ||
                InfoGui.getPikachuRadio1().isSelected() && InfoGui.getPikachuRadio2().isSelected() ||
                InfoGui.getEeveeRadio1().isSelected() && InfoGui.getEeveeRadio2().isSelected() ||
                InfoGui.getGengerRadio1().isSelected() && InfoGui.getGengerRadio2().isSelected())
            {
                JOptionPane.showInternalMessageDialog(null, "Thou shall not have the same pokemon",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            //if pokemon selection is valid
            else {
                //Getting the first pokemon selected
                if (InfoGui.getCharmanderRadio1().isSelected()) {
                    Pokemon1 = new Charmander();
                } else if (InfoGui.getPikachuRadio1().isSelected()) {
                    Pokemon1 = new Pikachu();
                } else if (InfoGui.getEeveeRadio1().isSelected()) {
                    Pokemon1 = new Eevee();
                } else if (InfoGui.getGengerRadio1().isSelected()) {
                    Pokemon1 = new Genger();
                } else {
                    JOptionPane.showInternalMessageDialog(null, "You have not selected a main pokemon",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                //Getting the second selected pokemon
                if (InfoGui.getCharmanderRadio2().isSelected()) {
                    Pokemon2 = new Charmander();
                } else if (InfoGui.getPikachuRadio2().isSelected()) {
                    Pokemon2 = new Pikachu();
                } else if (InfoGui.getEeveeRadio2().isSelected()) {
                    Pokemon2 = new Eevee();
                } else if (InfoGui.getGengerRadio2().isSelected()) {
                    Pokemon2 = new Genger();
                } else {
                    JOptionPane.showInternalMessageDialog(null, "You have not selected a second pokemon",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

        }
        else
        {
            JOptionPane.showInternalMessageDialog(null, "Player can not have an empty name.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


}
