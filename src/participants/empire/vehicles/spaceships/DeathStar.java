package participants.empire.vehicles.spaceships;

import participants.Vehicle;
import participants.WarParticipant;
import weapons.DLT19HeavyBlasterRifle;
import weapons.E11BlasterRifle;
import weapons.SuperLaser;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 10/12/15.
 */
public class DeathStar extends Vehicle {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new DLT19HeavyBlasterRifle(),
            new E11BlasterRifle(),
            new SuperLaser())
    );

    /**
     * name of character
     */
    private final String name = "Death star";

    /**
     * only instance of DeathStar class
     */
    private static  DeathStar deathStar  = new DeathStar();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private DeathStar(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of DeathStar class
     * @return DeathStar instance
     */
    public static DeathStar getInstance(){
        return deathStar;
    }

    @Override
    public void attack(WarParticipant target) {
        weapons.get(random.nextInt(weapons.size())).fire(target, this);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        System.out.println("death star aktivira štit, nemreš mi ništa");
        int fatality = (int)(random.nextInt(200)/(double)10000*force);
        System.out.println("Ipak, poginulo "+fatality+" ljudi");
        if (getCrew()<=0){
            System.out.println("zvijezda smrti nema posadu i samouništava se");
            setHealth(0);
        }
    }
}
