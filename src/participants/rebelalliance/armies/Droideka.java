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
 * Created by adrianzgaljic on 11/12/15.
 */
public class Droideka extends WarParticipant {

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
    private final String name = "Droideka";

    /**
     * only instance of Droideka class
     */
    private static  Droideka droideka  = new Droideka();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Droideka(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of Droideka class
     * @return Droideka instance
     */
    public static Droideka getInstance(){
        return droideka;
    }


    @Override
    public void attack(WarParticipant target) {
        int noOfDroids = getHealth()/ Health.DROIDEKA;
        int noOfShooting = 1+random.nextInt(noOfDroids);
        weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.DROIDEKA;
        int noOfDied = force/Health.DROIDEKA;
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je uništeno "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}
