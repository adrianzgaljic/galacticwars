package participants.rebelalliance.vehicles.spaceships;

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
public class MillenniumFalcon extends Vehicle {

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
    private final String name = "Millenium Falcon";

    /**
     * only instance of MillenniumFalcon class
     */
    private static  MillenniumFalcon millenniumFalcon = new MillenniumFalcon();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private MillenniumFalcon(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of MillenniumFalcon class
     * @return MillenniumFalcon instance
     */
    public static MillenniumFalcon getInstance(){
        return millenniumFalcon;
    }

    @Override
    public void attack(WarParticipant target) {
        weapons.get(random.nextInt(weapons.size())).fire(target, this,1);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        System.out.println("Millennium Falcon aktivira štit, nemreš mi ništa");
    }
}
