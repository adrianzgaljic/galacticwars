package participants.empire.characters;

import participants.WarParticipant;
import weapons.LightSaber;
import weapons.PureForce;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 * DarthSidious is singleton class which represents evil Sith Darth Sidious
 */
public class DarthSidious extends WarParticipant {


    Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new LightSaber("red", 100), new PureForce()));


    /**
     * only instance of DarthSidious class
     */
    private static DarthSidious darthVader  = new DarthSidious();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private DarthSidious(){
    }

    @Override
    public String getName() {
        return "Darth Sidious";
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
        weapons.get(random.nextInt(weapons.size())).fire(target, this, 1);

    }

    @Override
    public void defend(WarParticipant attacker, int force) {


        setHealth(getHealth()-force);
        System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");

    }

}

