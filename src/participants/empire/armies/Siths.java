package participants.empire.armies;

import demo.Health;
import participants.WarParticipant;
import weapons.DLT19HeavyBlasterRifle;
import weapons.E11BlasterRifle;
import weapons.LightSaber;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 */
public class Siths extends WarParticipant {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<LightSaber> weapons = new ArrayList<>(Arrays.asList(
            new LightSaber("orange",10),
            new LightSaber("purple",15),
            new LightSaber("yellow",20),
            new LightSaber("red",25))
    );

    /**
     * name of character
     */
    private final String name = "Siths";

    /**
     * only instance of Siths class
     */
    private static  Siths siths = new Siths();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Siths(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of Siths class
     * @return Siths instance
     */
    public static Siths getInstance(){
        return siths;
    }


    @Override
    public void attack(WarParticipant target) {
        int noOfDroids = getHealth()/ Health.SITHS;
        int noOfShooting = 1+random.nextInt(noOfDroids);
        weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.SITHS;
        int noOfDied = force/Health.SITHS;
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je poginulo "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}

