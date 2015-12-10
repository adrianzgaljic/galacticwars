package participants.empire.armies;

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
public class StormTroopers extends WarParticipant {

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
    private final String name = "Storm Troopers";

    /**
     * only instance of DarthVader class
     */
    private static  StormTroopers stormTroopers  = new StormTroopers();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private StormTroopers(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of StormTroopers  class
     * @return StormTroopers instance
     */
    public static StormTroopers getInstance(){
        return stormTroopers;
    }


    @Override
    public void attack(WarParticipant target) {
        weapons.get(random.nextInt(weapons.size())).fire(target, this);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth()-force);
        int noAlive = getHealth()/10;
        int noOfDied = force/10;
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je poginulo "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}
