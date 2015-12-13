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
 * Droideka is singleton class which represents Droideka army of droids.
 */
public class Droideka extends Army {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new DLT19HeavyBlasterRifle(),
            new E11BlasterRifle())
    );

    /**
     * only instance of Droideka class
     */
    private static  Droideka droideka  = new Droideka();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Droideka(){
    }

    @Override
    public String getName() {
        return "Droideka";
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
        int noOfDroideka = getHealth()/ Health.DROIDEKA;
        if(noOfDroideka > 0){
            int noOfShooting = 1+random.nextInt(noOfDroideka);
            weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
        }
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        force = quantify(force,Health.DROIDEKA);
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.DROIDEKA;
        int noOfDied = (int)Math.ceil(force/(double)Health.DROIDEKA);
        noOfDied = Math.min(noOfDied,getHealth()/Health.DROIDEKA);
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je uništeno "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}
