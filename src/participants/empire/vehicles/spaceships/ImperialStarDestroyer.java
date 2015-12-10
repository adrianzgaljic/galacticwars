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
public class ImperialStarDestroyer extends Vehicle {

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
    private final String name = "Imperial Star Destroyer";

    /**
     * only instance of ImperialStarDestroyer class
     */
    private static  ImperialStarDestroyer imperialStarDestroyer = new ImperialStarDestroyer();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private ImperialStarDestroyer(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of ImperialStarDestroyer class
     * @return ImperialStarDestroyer instance
     */
    public static ImperialStarDestroyer getInstance(){
        return imperialStarDestroyer;
    }

    @Override
    public void attack(WarParticipant target) {
        weapons.get(random.nextInt(weapons.size())).fire(target, this);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        System.out.println("ImperialStarDestroyer aktivira štit, nemreš mi ništa");
    }
}
