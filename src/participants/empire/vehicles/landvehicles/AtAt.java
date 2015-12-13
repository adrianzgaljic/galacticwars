package participants.empire.vehicles.landvehicles;

import demo.Health;
import participants.Vehicle;
import participants.WarParticipant;
import weapons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 10/12/15.
 */
public class AtAt extends Vehicle {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new E5BlasterRifle(),
            new E11BlasterRifle())
    );

    /**
     * name of character
     */
    private final String name = "AT-AT";



    @Override
    public String getName() {
        return name;
    }



    @Override
    public void attack(WarParticipant target) {
        int noOfAtat = getHealth()/ Health.STORM_TR;
        int noOfShooting = random.nextInt(noOfAtat);
        weapons.get(random.nextInt(weapons.size())).fire(target, this,noOfShooting);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth() - force);
        int noAlive = getHealth()/(Health.STORM_TR*2);
        int noOfDied = force/(Health.STORM_TR*2);
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je uništeno "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}
