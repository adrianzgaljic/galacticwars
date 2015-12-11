package participants.rebelalliance.armies;

import participants.WarParticipant;
import weapons.DLT19HeavyBlasterRifle;
import weapons.E11BlasterRifle;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 */
public class Wookiees extends WarParticipant {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new DLT19HeavyBlasterRifle(),
            new E11BlasterRifle())
    );

    /**
     * name of character
     */
    private final String name = "Wookiees";

    /**
     * only instance of Wookiees class
     */
    private static  Wookiees wookiees  = new Wookiees();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Wookiees(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of Wookiees class
     * @return Wookiees instance
     */
    public static Wookiees getInstance(){
        return wookiees;
    }


    @Override
    public void attack(WarParticipant target) {
        weapons.get(random.nextInt(weapons.size())).fire(target, this);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
    /*    setHealth(getHealth() - force);
        int noAlive = getHealth()/10;
        int noOfDied = force/10;
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je poginulo "+noOfDied+
                ", ostalo ih je još "+noAlive);*/
    }
}
