package participants.rebelalliance.armies;

import demo.Health;
import participants.WarParticipant;
import weapons.DLT19HeavyBlasterRifle;
import weapons.E11BlasterRifle;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 10/12/15.
 */
public class Ewoks extends WarParticipant {

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
    private final String name = "Ewoks";

    /**
     * only instance of StormTroopers class
     */
    private static  Ewoks ewoks  = new Ewoks();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Ewoks(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of Ewoks  class
     * @return Ewoks instance
     */
    public static Ewoks getInstance(){
        return ewoks;
    }


    @Override
    public void attack(WarParticipant target) {
        int noOfEwoks = getHealth()/ Health.EWOKS;
        int noOfShooting = 1+random.nextInt(noOfEwoks);
        weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.EWOKS;
        int noOfDied = force/Health.EWOKS;
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je uništeno "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}
