package participants.empire.vehicles.spaceships;

import demo.Health;
import participants.Vehicle;
import participants.WarParticipant;
import weapons.DLT19HeavyBlasterRifle;
import weapons.E11BlasterRifle;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 10/12/15.
 * Executor is singleton class which represents personal flagship of the Dark Lord of the Sith Darth Vader.
 */
public class Executor  extends Vehicle {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new DLT19HeavyBlasterRifle(),
            new E11BlasterRifle())
    );


    @Override
    public String getName() {
        return "Executor";
    }

    /**
     * only instance of Executor class
     */
    private static  Executor executor  = new Executor();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Executor(){}

    /**
     * getter for only instance of DeathStar class
     * @return DeathStar instance
     */
    public static Executor getInstance(){
        return executor;
    }



    @Override
    public void attack(WarParticipant target) {
        int noOfExecutors = getHealth()/ Health.STORM_TR;
        if (noOfExecutors>0){
            int noOfShooting = 1+random.nextInt(noOfExecutors);
            weapons.get(random.nextInt(weapons.size())).fire(target, this,noOfShooting);
        }
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.STORM_TR;
        int noOfDied = force/Health.STORM_TR;
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je uništeno "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}
