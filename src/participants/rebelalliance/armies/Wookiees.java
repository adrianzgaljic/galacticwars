package participants.rebelalliance.armies;

import demo.Health;
import participants.Army;
import participants.WarParticipant;
import weapons.DLT19HeavyBlasterRifle;
import weapons.E11BlasterRifle;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 * Wookiees is singleton class which represents Wookiees, a species of tall, hairy humanoids fighting against Galactic Empire.
 */
public class Wookiees extends Army {

    private Random random = new Random();

    /**
     * flag which shows if Chewbacca, most notable member of this species is alive
     */
    public boolean chewAlive = true;

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new DLT19HeavyBlasterRifle(),
            new E11BlasterRifle())
    );

    /**
     * only instance of Wookiees class
     */
    private static  Wookiees wookiees  = new Wookiees();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Wookiees(){
    }

    @Override
    public String getName() {
        return "Wookiees";
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
        int noOfWookiee = getHealth()/ Health.WOOKIEES;
        if (noOfWookiee>0){
            int noOfShooting = 1+random.nextInt(noOfWookiee);
            weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
        }
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        force = quantify(force,Health.WOOKIEES);
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.WOOKIEES;
        int noOfDied = force/Health.WOOKIEES;
        noOfDied = Math.min(noOfDied,getHealth()/Health.WOOKIEES);
        if (chewAlive && noOfDied>0 && random.nextInt(3)==0){
            System.out.println("Chewbacca je poginuo :(");
            chewAlive = false;

        }
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je uništeno "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}
