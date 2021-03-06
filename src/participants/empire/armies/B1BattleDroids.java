package participants.empire.armies;

import demo.Health;
import participants.Army;
import participants.WarParticipant;
import weapons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 * B1 Battle droids are military force used by Galactic Empire.
 * Each of them has 5 points of health.
 */
public class B1BattleDroids extends Army {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new Blaster(),
            new E5BlasterRifle(),
            new E11BlasterRifle())
    );

    /**
     * only instance of B1BattleDroids class
     */
    private static  B1BattleDroids b1BattleDroids = new B1BattleDroids();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private B1BattleDroids(){
    }

    @Override
    public String getName() {
        return "B1 Battle droids";
    }




    /**
     * getter for only instance of B1BattleDroids class
     * @return B1BattleDroids instance
     */
    public static B1BattleDroids getInstance(){
        return b1BattleDroids;
    }


    @Override
    public void attack(WarParticipant target) {
        int noOfDroids = getHealth()/ Health.B1_BATTLE_DROID;
        if (noOfDroids>0){
            int noOfShooting = 1+random.nextInt(noOfDroids);
            weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
        }

    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        force = quantify(force,Health.B1_BATTLE_DROID);
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.B1_BATTLE_DROID;
        int noOfDied = force/Health.B1_BATTLE_DROID;
        noOfDied = Math.min(noOfDied,getHealth()/Health.B1_BATTLE_DROID);
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je uništeno "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}

