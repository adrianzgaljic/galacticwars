package participants.empire.characters;

import participants.WarParticipant;
import weapons.LightSaber;
import weapons.Weapon;

import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 */
public class DarthMaul extends WarParticipant {


    Random random = new Random();

    /**
     * war participants weapon
     */
    private Weapon weapon = new LightSaber("double bladed red",80);


    /**
     * name of character
     */
    private final String name = "Darth Maul";

    /**
     * only instance of DarthMaul class
     */
    private static DarthMaul darthMaul  = new DarthMaul();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private DarthMaul(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of DarthMaul class
     * @return DarthMaul instance
     */
    public static DarthMaul getInstance(){
        return darthMaul;
    }


    @Override
    public void attack(WarParticipant target) {
        weapon.fire(target, this);


    }

    @Override
    public void defend(WarParticipant attacker, int force) {


        setHealth(getHealth()-force);
        System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");

    }

}

