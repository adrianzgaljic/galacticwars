package participants.empire.vehicles.landvehicles;

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
public class Z74SpeederBike extends Vehicle {

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
    private final String name = "74-Z Speeder Bike";



    @Override
    public String getName() {
        return name;
    }



    @Override
    public void attack(WarParticipant target) {
        weapons.get(random.nextInt(weapons.size())).fire(target, this);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        System.out.println("Delta-7B Interceptor aktivira štit, nemreš mi ništa");
    }
}

