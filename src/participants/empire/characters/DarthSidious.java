package participants.empire.characters;

import participants.WarParticipant;
import weapons.LightSaber;
import weapons.Weapon;

import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 */
public class DarthSidious extends WarParticipant {


    Random random = new Random();

    /**
     * war participants weapon
     */
    private Weapon weapon = new LightSaber("red",100);


    /**
     * name of character
     */
    private final String name = "Darth Sidious";

    /**
     * only instance of DarthSidious class
     */
    private static DarthSidious darthVader  = new DarthSidious();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private DarthSidious(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of DarthSidious  class
     * @return DarthSidious instance
     */
    public static DarthSidious getInstance(){
        return darthVader;
    }


    @Override
    public void attack(WarParticipant target) {
        weapon.fire(target, this,1);


    }

    @Override
    public void defend(WarParticipant attacker, int force) {


        setHealth(getHealth()-force);
        System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");

    }

}

